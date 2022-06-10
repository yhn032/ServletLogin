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
insert into favorites values( (select nvl(max(idx)+1, 1) from favorites), '경주 데이트 코스 top5', '의문의1인', 0, '없음','나도 데이트하고 싶어');
delete favorites where idx = 2;

--조회
select * from favorites
select idx from favorites where myNick='홍짱짱';

--test
update favorites set coView= coview+1 where idx=1
update favorites set coText = '서울 데이트코스 모두 여기 모여라! 1. 남산 2. 롯데월드...' where idx = 1

--제한조건
alter table favorites
add myNick varchar2(100) default '없음' unique

alter table favorites
add coText varchar2(100)

alter table favorites 
drop constraint unique myNick

