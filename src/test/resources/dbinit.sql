delete from TBL_USER where ID in (-1,-2);
insert into TBL_USER values(-1,-1,'kevin','kevin','kevin@-16-3.com','-1-3-3-1-2-345678');
insert into TBL_USER values(-2,-1,'zm','zm','zm-1-2-1987@-16-3.com','-1-3-3-1-2-345678');

delete from TBL_GROUP where ID in (-1,-2,-3);
insert into TBL_GROUP values(-1,'dev','开发部门');
insert into TBL_GROUP values(-2,'test','测试部门');
insert into TBL_GROUP values(-3,'information','信息技术部门');

delete from TBL_ROLE where ID in (-1,-2,-3);
insert into TBL_ROLE values(-1,'普通用户','普通的公司用户');
insert into TBL_ROLE values(-2,'管理员','系统管理员');
insert into TBL_ROLE values(-3,'中心人员','国家信息中心工作人员');

delete from REL_USER_GROUP where ID in (-1,-2,-3);
insert into REL_USER_GROUP values(-1,-1,-1);
insert into REL_USER_GROUP values(-2,-1,-2);
insert into REL_USER_GROUP values(-3,-2,-1);

delete from REL_GROUP_ROLE where ID in (-1,-2,-3);
insert into REL_GROUP_ROLE values(-1,-1,-1);
insert into REL_GROUP_ROLE values(-2,-1,-2);
insert into REL_GROUP_ROLE values(-3,-2,-1);

delete from TBL_COMPANY where ID in (-1,-2,-3);
insert into TBL_COMPANY values(-1,'北大青鸟','北京市朝阳区','张山');
insert into TBL_COMPANY values(-2,'北大方正','北京市海淀区','里斯');
insert into TBL_COMPANY values(-3,'清华紫光','北京市海淀区','王五');

delete from TBL_CONTRACT where ID in (-1,-2,-3);
insert into TBL_CONTRACT(id,contract_name,file_uri,md5) values(-1,'合同-1','/contract_file/','uyeafhoenlaoy');
insert into TBL_CONTRACT(id,contract_name,file_uri,md5) values(-2,'合同-2','/contract_file/','uydfaeeafavbf');
insert into TBL_CONTRACT(id,contract_name,file_uri,md5) values(-3,'合同-3','/contract_file/','uyeradafvelkj');

delete from REL_INITIATE where ID in (-1);
insert into REL_INITIATE values(-1,-1,-1);

delete from REL_SIGNED where ID in (-1,-2);
insert into REL_SIGNED values(-1,-2,-1);
insert into REL_SIGNED values(-2,-3,-1);