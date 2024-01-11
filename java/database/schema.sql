BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE lists (
    list_id SERIAL,
    list_name varchar(100) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_list_id PRIMARY KEY (list_id),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id)
);

CREATE TABLE items (
  item_id SERIAL,
  item_name varchar (100) NOT NULL,
  list_id int NOT NULL,
  CONSTRAINT PK_item_id PRIMARY KEY (item_id),
  CONSTRAINT FK_list_id FOREIGN KEY (list_id)
);

COMMIT TRANSACTION;
