

-- ----------------------------------------------
-- DDL Statements for tables
-- ----------------------------------------------

CREATE TABLE "GAMESUMMARY" ("ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "CLIENTGESTURE" VARCHAR(255), "SERVERGESTURE" VARCHAR(255), "RESULT" VARCHAR(255), "TIMEPLAYED" TIMESTAMP);

-- ----------------------------------------------
-- DDL Statements for keys
-- ----------------------------------------------

-- primary/unique
ALTER TABLE "GAMESUMMARY" ADD CONSTRAINT "SQL120325130144010" PRIMARY KEY ("ID");

