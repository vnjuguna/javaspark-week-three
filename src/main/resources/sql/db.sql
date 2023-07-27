CREATE TABLE "rangers" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "name" varchar
);

CREATE TABLE "animals" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "name" varchar,
  "endangered" boolean,
  "age" integer,
  "health" varchar
);

CREATE TABLE "sightings" (
  "id" INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "ranger_id" integer,
  "animal_id" integer,
  "health" varchar,
  "location" varchar,
  "timestamp" timestamp
);

ALTER TABLE "sightings" ADD FOREIGN KEY ("ranger_id") REFERENCES "rangers" ("id");

ALTER TABLE "sightings" ADD FOREIGN KEY ("animal_id") REFERENCES "animals" ("id");