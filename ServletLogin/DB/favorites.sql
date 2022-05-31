--테이블 생성
create table favorites
(
	idx int,
	coTitle varchar2(100) not null,
	coId    varchar2(100) not null,
	coView  int default 0
)

--기본키 생성 
alter table favorites 
add constraint pk_idx primary key(idx)

--sample
insert into favorites values( (select nvl(max(idx)+1, 1) from favorites), '서울 데이트 코스 top10', '홍짱짱', 0);

--조회
select * from favorites

--test
update favorites set coView= coview+1 where idx=1

--제한조건
alter table favorites
add myNick varchar2(100) default '없음' unique