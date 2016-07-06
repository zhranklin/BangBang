CREATE TABLE user (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(20)  NOT NULL UNIQUE,
  password VARCHAR(20)  NOT NULL,
  realname VARCHAR(20) NOT NULL,
  phone    VARCHAR(20)  NOT NULL,
  coin     INT          NOT NULL
);

CREATE TABLE place (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  name      VARCHAR(20)
            NULL UNIQUE,
  longitude DOUBLE       NOT NULL,
  latitude  DOUBLE       NOT NULL
);

CREATE TABLE mission (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  start       INT          NOT NULL REFERENCES place (id),
  dest        INT          NOT NULL REFERENCES place (id),
  price       INT          NOT NULL,
  description VARCHAR(400)
              NOT NULL,
  due         TIMESTAMP    NOT NULL,
  producer    INT          NOT NULL REFERENCES user (id),
  consumer    INT          NOT NULL REFERENCES user (id),
  status      INT          NOT NULL
);

CREATE TABLE `group` (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(20)
              NOT NULL,
  description VARCHAR(400)
              NOT NULL,
  location    INT          NOT NULL
);

INSERT INTO user (username, password, realname, phone, coin)
VALUES ('user1', 'psw', 'xiaoming1', '123', 0);
INSERT INTO user (username, password, realname, phone, coin) VALUES ('user2', 'psw', 'xiaoming2', '123', 0);
INSERT INTO user (username, password, realname, phone, coin) VALUES ('user3', 'psw', 'xiaoming3', '123', 0);
INSERT INTO user (username, password, realname, phone, coin) VALUES ('user4', 'psw', 'xiaoming4', '123', 0);

