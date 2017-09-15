INSERT INTO employee.product (pro_name, Pro_type, Pro_cost, Pro_loc, Pro_img, Pro_first, Pro_month, Pro_link, Pro_out, Pro_status, Pro_date) VALUES ('飞信', '短信类', '5元/月', '', null, 1, 0.3, '', null, '1', '2017-08-01');
INSERT INTO employee.product (pro_name, Pro_type, Pro_cost, Pro_loc, Pro_img, Pro_first, Pro_month, Pro_link, Pro_out, Pro_status, Pro_date) VALUES ('手机动漫', '彩信类', '16元/月', null, null, 2, 0.3, null, null, '1', '2017-08-02');
INSERT INTO employee.product (pro_name, Pro_type, Pro_cost, Pro_loc, Pro_img, Pro_first, Pro_month, Pro_link, Pro_out, Pro_status, Pro_date) VALUES ('动漫空间', '彩信类', '5元/月', null, null, 1, 0.2, null, null, '1', '2017-08-03');
INSERT INTO employee.product (pro_name, Pro_type, Pro_cost, Pro_loc, Pro_img, Pro_first, Pro_month, Pro_link, Pro_out, Pro_status, Pro_date) VALUES ('体育周刊', '短信类', '5元/月', null, null, 1, 0.2, null, null, '0', '2017-08-04');

INSERT INTO employee.jo_level (jo_level_name, jo_level_explain) VALUES ('一级代理商', '一级代理商，由移动直接进行审核');
INSERT INTO employee.jo_level (jo_level_name, jo_level_explain) VALUES ('二级代理商', null);
INSERT INTO employee.jo_level (jo_level_name, jo_level_explain) VALUES ('三级代理商', null);

INSERT INTO employee.sys_menu (menu_parent_id, seq, menu_name, menu_descn, menu_link_url, menu_status) VALUES (null, 100, '系统管理', '系统管理', null, '1');
INSERT INTO employee.sys_menu (menu_parent_id, seq, menu_name, menu_descn, menu_link_url, menu_status) VALUES (1, 101, '菜单管理', '菜单管理', 'menulist.jsp', '1');
INSERT INTO employee.sys_menu (menu_parent_id, seq, menu_name, menu_descn, menu_link_url, menu_status) VALUES (1, 102, '角色管理', '角色管理', 'rolelist.jsp', '1');
INSERT INTO employee.sys_menu (menu_parent_id, seq, menu_name, menu_descn, menu_link_url, menu_status) VALUES (1, 103, '用户管理', '用户管理', 'userlist.jsp', '1');

INSERT INTO employee.sys_role (role_name, role_desc, role_code) VALUES ('系统管理员', '系统管理员', 'ROLE-001');

INSERT INTO employee.sys_menu_role (menu_id, role_id) VALUES (1, 1);
INSERT INTO employee.sys_menu_role (menu_id, role_id) VALUES (2, 1);
INSERT INTO employee.sys_menu_role (menu_id, role_id) VALUES (3, 1);
INSERT INTO employee.sys_menu_role (menu_id, role_id) VALUES (4, 1);

INSERT INTO employee.sys_user (user_name, user_password, user_flag) VALUES ('admin', '21232F297A5', '1');

INSERT INTO employee.sys_user_role (user_id, role_id) VALUES (1, 1);

INSERT INTO employee.organ (organ_heigh, organ_name, organ_type, organ_loc, organ_dir, organ_linkman, organ_phone, organ_explain) VALUES ('', '湖南移动', '', '湖南', '付洲', '咪咪', '156151651', '省级组织');
INSERT INTO employee.organ (organ_heigh, organ_name, organ_type, organ_loc, organ_dir, organ_linkman, organ_phone, organ_explain) VALUES ('1', '长沙移动', '', '长沙市', '鲁靖', '鲁盖盖', '156165', '市级组织');
INSERT INTO employee.organ (organ_heigh, organ_name, organ_type, organ_loc, organ_dir, organ_linkman, organ_phone, organ_explain) VALUES ('1', '株洲移动', null, '株洲市', '张尧', '米后', '16516523', '市级组织');
INSERT INTO employee.organ (organ_heigh, organ_name, organ_type, organ_loc, organ_dir, organ_linkman, organ_phone, organ_explain) VALUES ('2', '天心区移动', null, '天心区', '李坤', '丽丽', '156189', '区级组织');
INSERT INTO employee.organ (organ_heigh, organ_name, organ_type, organ_loc, organ_dir, organ_linkman, organ_phone, organ_explain) VALUES ('3', '天元区移动', null, '天元区', '何佳杰', '速度', '16515', '区级组织');



INSERT INTO employee.employee (organ_id, job, name, sex, phone, doc_type, doc_number, agent_name, loc, bank_name, bank_number, user_id) VALUES ('1', '经理', '李聪', '男', '123123123', '身份证', '1165156153', '安抚', '湖南', '中国银行', '16555156', 6);



INSERT INTO employee.joiner (joiner_name, organ_id, joiner_loc, joiner_linkname, joiner_phone, joiner_email, joiner_address, joiner_bank, joiner_holder, joiner_banknum, joiner_explain, jo_level_id, jo_heigher_id, joiner_date, user_id, joiner_status) VALUES ('长沙移动', 1, '长沙市', '一级代理商', '1231231', null, '长沙市', '中国银行', '', null, null, 1, null, '2017-08-02', 2, '1');
INSERT INTO employee.joiner (joiner_name, organ_id, joiner_loc, joiner_linkname, joiner_phone, joiner_email, joiner_address, joiner_bank, joiner_holder, joiner_banknum, joiner_explain, jo_level_id, jo_heigher_id, joiner_date, user_id, joiner_status) VALUES ('长沙岳麓区移动', 2, '岳麓区', '二级代理商', '1231231', null, '岳麓区', null, null, null, null, 2, 1, '2017-08-16', 3, '1');


INSERT INTO employee.seller (Seller_name, Seller_phone, joiner_id, user_id, Seller_sex, Seller_card, Seller_cardnum, Seller_remark, Seller_date, Seller_loc) VALUES ('直销员1号', '123', 1, 4, null, null, null, null, '2017-08-10', '长沙市');
INSERT INTO employee.seller (Seller_name, Seller_phone, joiner_id, user_id, Seller_sex, Seller_card, Seller_cardnum, Seller_remark, Seller_date, Seller_loc) VALUES ('直销员2号', '456', 2, 5, null, null, null, null, '2017-08-01', '长沙市');



INSERT INTO employee.business (Seller_phone, Cus_phone, Pro_name, bus_type, Bus_open, Bus_close, Seller_id) VALUES ('123', '456', '飞信', '手机端', '2017-08-01', '2017-08-31', 1);
INSERT INTO employee.business (Seller_phone, Cus_phone, Pro_name, bus_type, Bus_open, Bus_close, Seller_id) VALUES ('123', '789', '飞信', '手机端', '2017-06-01', '2017-10-31', 1);
INSERT INTO employee.business (Seller_phone, Cus_phone, Pro_name, bus_type, Bus_open, Bus_close, Seller_id) VALUES ('123', '566565', '手机动漫', '手机端', '2017-08-31', '2017-08-16', 1);
INSERT INTO employee.business (Seller_phone, Cus_phone, Pro_name, bus_type, Bus_open, Bus_close, Seller_id) VALUES ('456', '123123123', '体育周报', '手机端', '2017-08-01', '2017-11-09', 2);
INSERT INTO employee.business (Seller_phone, Cus_phone, Pro_name, bus_type, Bus_open, Bus_close, Seller_id) VALUES ('456', '12399999', '动漫空间', '手机端', '2017-08-01', '2017-08-30', 2);
INSERT INTO employee.business (Seller_phone, Cus_phone, Pro_name, bus_type, Bus_open, Bus_close, Seller_id) VALUES ('456', '6666', '动漫空间', '手机端', '2017-06-06', '2017-10-05', 2);









