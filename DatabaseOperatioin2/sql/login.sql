CREATE schema "USER";

CREATE TABLE USERS
    (IDENTITY_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY
    CONSTRAINT IDEN_PK PRIMARY KEY, 
    USER_NAME VARCHAR(255),
    PASSWORD VARCHAR(255),
    UID VARCHAR(255)
    );
    
    
    
    
    
    
    