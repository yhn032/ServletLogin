grant connect,resource to test7


create table member
(
id varchar2(100),
pwd varchar2(100),
name varchar2(100),
nickname varchar2(100),
birth varchar2(100),
tel varchar2(100),
email varchar2(100),
question varchar2(100),
answer varchar2(100)
)

select * from member

drop table member

alter table member drop primary key;

