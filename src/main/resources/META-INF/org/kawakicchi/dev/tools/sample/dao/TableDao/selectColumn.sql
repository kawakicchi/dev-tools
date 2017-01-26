
SELECT
    B.column_name              AS "name"
  , B.data_type                AS "type"
  , B.character_maximum_length AS "length"
  , B.numeric_precision        AS "accuracy"
  , CASE
        WHEN B.is_nullable = 'YES' THEN true
        ELSE                            false
    END                        AS nullable
  , C.column_comment           AS comment
FROM
    pg_stat_all_tables         A
  , information_schema.columns B
    LEFT OUTER JOIN
    (
        SELECT
            A.schemaname   AS table_schema
          , A.relname      AS table_name
          , D.attname      AS column_name
          , C.description  AS column_comment
        FROM
            pg_stat_all_tables A
          , pg_description     C
          , pg_attribute       D
        WHERE
            A.relid      = C.objoid
        AND C.objsubid   <> 0
        AND A.schemaname = /* schema */''
        AND A.relname    = /* tableName */''
        AND C.objoid     = D.attrelid
        AND C.objsubid   = D.attnum
    ) C
    ON  C.table_schema = B.table_schema
    AND C.table_name   = B.table_name
    AND C.column_name  = B.column_name
WHERE
    A.schemaname = B.table_schema
AND A.relname    = B.table_name
AND A.schemaname = /* schema */''
AND A.relname    = /* tableName */''