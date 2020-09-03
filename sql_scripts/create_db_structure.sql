create table USER
(
    ID           INTEGER PRIMARY KEY,
    LOGIN        VARCHAR2 NOT NULL,
    PASSWORD     VARCHAR2 NOT NULL,
    FULL_NAME    VARCHAR2 NOT NULL,
    BIRTHDAY     DATE,
    HOME_CITY    VARCHAR2,
    PHONE_NUMBER VARCHAR2,
    EMAIL        VARCHAR2 NOT NULL
);

create table MESSAGE
(
    ID          INTEGER PRIMARY KEY,
    DATE        DATE     NOT NULL,
    IS_READ     BOOLEAN  NOT NULL,
    TEXT        VARCHAR2 NOT NULL,
    SENDER_ID   INTEGER  NOT NULL,
    RECEIVER_ID INTEGER  NOT NULL,
    FOREIGN KEY (SENDER_ID) REFERENCES USER (ID),
    FOREIGN KEY (RECEIVER_ID) REFERENCES USER (ID)
);

create table FRIEND
(
    USER_ID   INTEGER NOT NULL,
    FRIEND_ID INTEGER NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES USER (ID),
    FOREIGN KEY (FRIEND_ID) REFERENCES USER (ID)
);

create table COMMENT
(
    ID      INTEGER PRIMARY KEY,
    TEXT    VARCHAR2 NOT NULL,
    DATE    DATE     NOT NULL,
    USER_ID INTEGER  NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES USER (ID)
);