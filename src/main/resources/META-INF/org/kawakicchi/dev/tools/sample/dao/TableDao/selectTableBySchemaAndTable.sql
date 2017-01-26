SELECT
    A.schemaname  AS "schema"
  , A.relname     AS "name"
  , B.description AS "comment"
FROM
    pg_stat_user_tables A
  , pg_description B
WHERE
    A.relid = B.objoid
AND B.objsubid = 0
AND A.schemaname = /* schema */''
AND A.relname    = /* table */''
