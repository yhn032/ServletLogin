--테이블 생성

create table member2
(

email varchar2(100),
pwd varchar2(100),
name varchar2(100),
nickname varchar2(100),
birth varchar2(100),
tel varchar2(100),
question varchar2(100),
answer varchar2(100)

)

alter table member2
add constraint pk_member2_email primary key(email);


select * from member2

alter table member2 drop primary key
alter table member2      drop      column id;        

drop table member2


--sample
insert into member2 values('hong1@naver.com', 'qwer1234!', '홍길동', '홍짱짱', '1994-08-12', '010-1234-1234', '고향은 어디입니까?', '조선')