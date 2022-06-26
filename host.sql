create table host
(
    host_id      bigint auto_increment
        primary key,
    created_at   datetime(6)  null,
    modified_at  datetime(6)  null,
    ip           varchar(255) not null unique ,
    name         varchar(255) not null unique ,
    recent_alive varchar(255) null,
);