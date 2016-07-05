CREATE TABLE user (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(20)  NOT NULL UNIQUE,
  password VARCHAR(20)  NOT NULL,
  realname VARCHAR(20)
           CHARSET utf8 NOT NULL,
  phone    VARCHAR(20)  NOT NULL,
  coin     INT          NOT NULL
);

CREATE TABLE place (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  name      VARCHAR(20)
            CHARSET utf8 NOT NULL UNIQUE,
  longitude DOUBLE       NOT NULL,
  latitude  DOUBLE       NOT NULL
);

CREATE TABLE mission (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  start       INT          NOT NULL REFERENCES place (id),
  dest        INT          NOT NULL REFERENCES place (id),
  price       INT          NOT NULL,
  description VARCHAR(400)
              CHARSET utf8 NOT NULL,
  due         TIMESTAMP    NOT NULL,
  producer    INT          NOT NULL REFERENCES user (id),
  consumer    INT          NOT NULL REFERENCES user (id),
  status      INT          NOT NULL
);

CREATE TABLE `group` (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20) CHARSET utf8 NOT NULL,
  description VARCHAR(400) CHARSET utf8 NOT NULL,
  location int NOT NULL
);