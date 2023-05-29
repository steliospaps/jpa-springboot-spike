CREATE TABLE OWNER (
    NAME VARCHAR(50) NOT NULL PRIMARY KEY,
    FIELD1 VARCHAR(50) NOT NULL
);

CREATE TABLE OTHER_DATA (
    DATA_ID VARCHAR(50) NOT NULL PRIMARY KEY,
    DATA VARCHAR(100) NOT NULL
);

CREATE TABLE OWNER_FEATURE (
    OWNER_NAME VARCHAR(50) NOT NULL REFERENCES OWNER(NAME),
    DATA_ID VARCHAR(50) NOT NULL REFERENCES OTHER_DATA(DATA_ID),
    DATA2 VARCHAR(100) NOT NULL,
    PRIMARY KEY (OWNER_NAME,DATA_ID,DATA2)
    
);


insert into owner(name,field1)
values
('Jimbo','field1'),
('Jimbo2','field1');

insert into other_data(DATA_ID,data)
values
('dataid1','dataa');

insert into owner_feature (owner_name,data_id,data2)
values
('Jimbo','dataid1','data2a'),
('Jimbo2','dataid1','data2a'),
('Jimbo','dataid1','data2b');