# DROP DATABASE IF EXISTS medi;
# CREATE DATABASE medi CHARACTER SET utf8 COLLATE utf8_general_ci;
# USE medi;

CREATE TABLE users (
  email       varchar(255) NOT NULL PRIMARY KEY,
  name        varchar(255) NOT NULL,
  `password`  varchar(255) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE usages (
  usage_id  bigint UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name     varchar(50) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE brands (
  brand_id  bigint UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name     varchar(50) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE articles (
  article_id  bigint UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  usage_id    bigint UNSIGNED NOT NULL,
  brand_id    bigint UNSIGNED NOT NULL,
  amount     int UNSIGNED NOT NULL DEFAULT 0,
  name       varchar(255) NOT NULL,
  formula    varchar(255) NOT NULL,
  volume     varchar(50) NOT NULL,
  comments   text,
  CONSTRAINT FK_articles_usage_id
    FOREIGN KEY (usage_id)
    REFERENCES usages(usage_id)
    ON UPDATE CASCADE,
  CONSTRAINT FK_articles_brand_id
    FOREIGN KEY (brand_id)
    REFERENCES brands(brand_id)
    ON UPDATE CASCADE
) ENGINE = InnoDB;

INSERT INTO usages (name) VALUES ('Oral'), ('Sublingual'), ('Rectal'), ('Topical'), ('Intravenous'), ('Intramuscular'), ('Subcutaneous');
INSERT INTO brands (name) VALUES ('Abbot'), ('AstraZeneca'), ('Eli Lilly & Co'), ('GlaxoSmithKline'), ('Johnson & Johnson'), ('MERCK'), ('Novartis'), ('Pfizer'), ('Roche'), ('Sanofi');

# The password is MyPass123 it uses SHA-512
INSERT INTO users (email, name, `password`) VALUES ('john@doe.com', 'John Doe', '99df370c45489026545455495c95f3c13d4c877aa5663b9988651f1cddd1420ae19719b11b49a76197c18a97b7a96210718412b72f18f22c425dde8704207952');
