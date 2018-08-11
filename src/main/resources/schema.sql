DROP TABLE role IF EXISTS;

CREATE TABLE role (
  role_id          int(11) PRIMARY KEY,
  role VARCHAR(255)  );


DROP TABLE user IF EXISTS;

CREATE TABLE user (
  user_id          int(11) PRIMARY KEY,
  active    int(11),
  email   varchar(255) not null,
  last_name varchar(255) not null,
  name varchar(255) not null,
  password varchar(255) not null);

DROP TABLE user_role IF EXISTS;

CREATE TABLE user_role (
  user_id          int(11) not null,
  role_id    int(11) not null,
  primary key(user_id,role_id));