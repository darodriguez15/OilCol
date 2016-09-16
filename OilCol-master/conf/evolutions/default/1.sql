# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table productentity (
  id                        bigint not null,
  name                      varchar(255),
  stock                     integer,
  price                     float,
  available                 boolean,
  constraint pk_productentity primary key (id))
;

create sequence Product;




# --- !Downs

drop table if exists productentity cascade;

drop sequence if exists Product;

