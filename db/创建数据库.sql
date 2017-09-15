/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/8/20 16:52:42                           */
/*==============================================================*/


drop table if exists business;

drop table if exists employee;

drop table if exists jo_level;

drop table if exists joiner;

drop table if exists organ;

drop table if exists product;

drop table if exists seller;

drop table if exists sys_menu;

drop table if exists sys_menu_role;

drop table if exists sys_role;

drop table if exists sys_user;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: business                                              */
/*==============================================================*/
create table business
(
   id                   int not null auto_increment,
   Seller_phone         Char(11),
   Cus_phone            Char(11),
   Pro_name             Varchar(50),
   bus_type             Varchar(50),
   Bus_open             date,
   Bus_close            date,
   Seller_id            int,
   bus_status           VARCHAR (50),
   primary key (id)
);

/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
create table employee
(
   id                   int not null auto_increment,
   organ_id             int,
   job                  varchar(50),
   name                 Char(2),
   sex                  Char(11),
   phone                varchar(50),
   doc_type             varchar(50),
   doc_number           varchar(50),
   agent_name           varchar(50),
   loc                  varchar(50),
   bank_name            varchar(50),
   bank_number          varchar(50),
   user_id              int,
   primary key (id)
);

/*==============================================================*/
/* Table: jo_level                                              */
/*==============================================================*/
create table jo_level
(
   jo_level_id          int not null auto_increment,
   jo_level_name        varchar(50),
   jo_level_explain     varchar(1024),
   primary key (jo_level_id)
);

/*==============================================================*/
/* Table: joiner                                                */
/*==============================================================*/
create table joiner
(
   joiner_id            int not null auto_increment,
   joiner_name          varchar(50),
   organ_id             int,
   joiner_loc           varchar(50),
   joiner_linkname      varchar(50),
   joiner_phone         Char(11),
   joiner_email         varchar(50),
   joiner_address       varchar(50),
   joiner_bank          varchar(50),
   joiner_holder        varchar(50),
   joiner_banknum       varchar(50),
   joiner_explain       varchar(1024),
   jo_level_id          int,
   jo_heigher_id        int,
   joiner_date          date,
   user_id              int,
   joiner_status        Char(1) default '0',
   joiner_remark        varchar(500),
   primary key (joiner_id)
);

/*==============================================================*/
/* Table: organ                                                 */
/*==============================================================*/
create table organ
(
   organ_id             int not null,
   organ_heigh          varchar(50),
   organ_name           varchar(50),
   organ_type           varchar(50),
   organ_loc            varchar(50),
   organ_dir            varchar(50),
   organ_linkman        varchar(50),
   organ_phone          Char(11),
   organ_explain        varchar(1024),
   primary key (organ_id)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   pro_id               int not null auto_increment,
   pro_name             Varchar(50),
   Pro_type             Varchar(50),
   Pro_cost             Varchar(50),
   Pro_loc              Varchar(100),
   Pro_img              Varchar(200),
   Pro_first            double,
   Pro_month            double,
   Pro_link             Varchar(1024),
   Pro_out              Varchar(1024),
   Pro_status           Char(1) default '0',
   Pro_date             date,
   primary key (pro_id)
);

/*==============================================================*/
/* Table: seller                                                */
/*==============================================================*/
create table seller
(
   Seller_id            int not null auto_increment,
   Seller_name          Varchar(50),
   joiner_id            int,
   user_id              int,
   Seller_sex           Char(2),
   Seller_card          Varchar(50),
   Seller_cardnum       Char(18),
   Seller_remark        Varchar(1024),
   Seller_date          date,
   Seller_loc           Varchar(1024),
   primary key (Seller_id)
);

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   menu_id              int not null auto_increment,
   menu_parent_id       int,
   seq                  int,
   menu_name            varchar(50),
   menu_descn           varchar(400),
   menu_link_url        varchar(200),
   menu_status          varchar(20),
   primary key (menu_id)
);

/*==============================================================*/
/* Table: sys_menu_role                                         */
/*==============================================================*/
create table sys_menu_role
(
   menu_id              int,
   role_id              int
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   role_id              int not null auto_increment,
   role_name            varchar(50),
   role_desc            varchar(200),
   role_code            varchar(50),
   primary key (role_id)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   user_id              int not null auto_increment,
   user_name            varchar(50),
   user_password        varchar(50),
   user_flag            char(1) default '1',
   primary key (user_id)
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   user_id              int,
   role_id              int
);

alter table business add constraint FK_Reference_11 foreign key (Seller_id)
      references seller (Seller_id) on delete restrict on update restrict;

alter table employee add constraint FK_Reference_5 foreign key (user_id)
      references sys_user (user_id) on delete restrict on update restrict;

alter table employee add constraint FK_Reference_4 foreign key (organ_id)
      references organ (organ_id) on delete restrict on update restrict;

alter table joiner add constraint FK_Reference_8 foreign key (user_id)
      references sys_user (user_id) on delete restrict on update restrict;

alter table joiner add constraint FK_Reference_6 foreign key (organ_id)
      references organ (organ_id) on delete restrict on update restrict;

alter table joiner add constraint FK_Reference_7 foreign key (jo_level_id)
      references jo_level (jo_level_id) on delete restrict on update restrict;

alter table seller add constraint FK_Reference_10 foreign key (user_id)
      references sys_user (user_id) on delete restrict on update restrict;

alter table seller add constraint FK_Reference_9 foreign key (joiner_id)
      references joiner (joiner_id) on delete restrict on update restrict;

alter table sys_menu_role add constraint FK_Reference_3 foreign key (role_id)
      references sys_role (role_id) on delete restrict on update restrict;

alter table sys_menu_role add constraint FK_Reference_4 foreign key (menu_id)
      references sys_menu (menu_id) on delete restrict on update restrict;

alter table sys_user_role add constraint FK_Reference_1 foreign key (user_id)
      references sys_user (user_id) on delete restrict on update restrict;

alter table sys_user_role add constraint FK_Reference_2 foreign key (role_id)
      references sys_role (role_id) on delete restrict on update restrict;

