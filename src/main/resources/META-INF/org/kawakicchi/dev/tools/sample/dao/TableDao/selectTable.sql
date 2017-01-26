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
/*%if schema != null */
AND A.schemaname = /* schema */''
/*%end*/
/*%if table != null */
AND A.relname = /* table */''
/*%end*/
ORDER BY
    A.schemaname
  , A.relname
