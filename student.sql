create table courseinfo
(
    num    int         null,
    NAME   varchar(11) null,
    course varchar(11) null,
    credit varchar(11) null
);

create table school
(
    sname      varchar(20) null,
    slander    varchar(10) null,
    phone      varchar(20) null,
    createtime datetime    null,
    phone2     varchar(20) null,
    saddress   varchar(20) null,
    sjianjie   varchar(20) null
);

create table status
(
    sname   varchar(20) null,
    author  varchar(20) null,
    version int         null,
    phone   int         null,
    address varchar(20) null,
    email   varchar(20) null
);

create table studentinfo
(
    num     int         null,
    name    varchar(11) null,
    gender  varchar(11) null,
    age     int         null,
    major   varchar(20) null,
    classes varchar(20) null,
    phone   int         null
);

create table user
(
    username varchar(10) null,
    password varchar(10) null,
    phone    int         null
);

create index username
    on user (username);

create table users
(
    user      varchar(11) null,
    password  varchar(11) null,
    privilege varchar(11) null
);

