
-- Relatorio 1
SELECT STATUS.STATUS,
       COUNT(*) AS QUANTIDADE_DE_RESULTADOS
FROM RESULTS
         JOIN STATUS ON RESULTS.STATUSID = STATUS.STATUSID
GROUP BY STATUS.STATUS
ORDER BY  QUANTIDADE_DE_RESULTADOS DESC;


SELECT * FROM airports a



-- Relatorio 2

CREATE INDEX IF NOT EXISTS idx_geocities15k_lat_long ON geocities15k (lat, long);

CREATE EXTENSION IF NOT EXISTS earthdistance CASCADE;

SELECT lat, long  FROM geocities15k gc WHERE name = 'São Paulo' AND gc.country = 'BR';

SELECT DISTINCT
    geocities15k.name AS nome_cidade,
    airports.iatacode AS codigo_IATA,
    airports.name AS aeroporto,
    airports.city AS cidade_aeroporto,
    earth_distance(
            ll_to_earth(-23.54750, -46.63611),
            ll_to_earth(airports.latdeg, airports.longdeg)
        ) / 1000 AS distancia_em_km,
    airports.type AS tipo_aeroporto
FROM
    geocities15k
        JOIN
    airports ON geocities15k.name = airports.city
WHERE
        geocities15k.country = 'BR'
  AND airports.type IN ('medium_airport', 'large_airport')
  AND earth_distance(
              ll_to_earth(-23.54750, -46.63611),
              ll_to_earth(airports.latdeg, airports.longdeg)
          ) <= 100000 -- limite de distância = 100000 metros (100km)
ORDER BY
    distancia_em_km;

