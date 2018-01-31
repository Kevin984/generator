CREATE OR REPLACE TRIGGER BRG<code><target_table_1>_TRG

BEFORE DELETE OR INSERT OR UPDATE
ON <target_table_1>

FOR EACH ROW
DECLARE
  L_PASSED BOOLEAN := TRUE;
  V_TABLE_1    VARCHAR2(60) := <target_table_1>;
  V_COLUMN_1    VARCHAR2(60) := :NEW.<target_column_1>;
  V_COLUMN_2_VALUE varchar(60);

BEGIN
   SELECT <target_column_2>
   INTO V_COLUMN_2_VALUE
   FROM <target_table_2>
   WHERE MAX(ROWNUM);

  IF (V_COLUMN_1 <operator> V_COLUMN_2_VALUE) THEN

    L_PASSED := TRUE;
  ELSE
    RAISE_APPLICATION_ERROR(-20000, '<error>');

  END IF;
END;