create table MY_USER(
	id bigint not null primary key,
    username varchar_ignorecase(50) not null,
    password varchar_ignorecase(50) not null,
    authorities varchar_ignorecase(100) not null,
    enabled boolean not null
);