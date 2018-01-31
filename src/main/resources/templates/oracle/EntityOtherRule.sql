CREATE OR REPLACE TRIGGER BRG<code><target_table>_TRG

BEFORE DELETE OR INSERT OR UPDATE
ON <target_table>

FOR EACH ROW
DECLARE
  L_OPER        VARCHAR2(3);

  BEGIN
    IF L_OPER IN ('INS', 'UPD')
    THEN
      L_PASSED := <customCode>

      IF NOT L_PASSED
      THEN
      L_ERROR_STACK := L_ERROR_STACK || '<error>';

    END IF;
  END IF;
END;