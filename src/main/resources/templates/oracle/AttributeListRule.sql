CREATE OR REPLACE TRIGGER BRG_<code>_<targettable>_TRG
BEFORE DELETE OR INSERT OR UPDATE
ON <targettable>
FOR EACH ROW
DECLARE
  L_PASSED BOOLEAN := FALSE;
  V_COLUMN_1    VARCHAR2(60) := :NEW.<targetcolumn>;
BEGIN
      IF V_COLUMN_1 <operator> <list> THEN
        L_PASSED := TRUE;
      ELSE
        RAISE_APPLICATION_ERROR(-20000, <error>);
    END IF;

  IF NOT L_PASSED THEN
    RAISE_APPLICATION_ERROR(-20000, 'Error: Something went wrong!' );
    END IF;
  END;