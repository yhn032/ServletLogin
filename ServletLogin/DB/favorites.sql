--테이블 생성
create table favorites
(
	f_idx int,
	coTitle varchar2(100) not null,
	coId    varchar2(100) not null,
	coView  int default 0,
	coText  varchar2(4000) not null,
	coPhoto1 varchar2(100),
	coPhoto2 varchar2(100),
	coPhoto3 varchar2(100) 
 
)

--기본키 생성 
alter table favorites 
add constraint pk_idx primary key(f_idx)

--sample
insert into favorites values( (select nvl(max(idx)+1, 1) from favorites), '서울 데이트 코스 top10', '홍짱짱', 0);
insert into favorites values( (select nvl(max(idx)+1, 1) from favorites), '경주 데이트 코스 top5', '의문의1인', 0,'나도 데이트하고 싶어');
delete favorites where idx = 2;

--조회
select * from favorites

--test
update favorites set coView= coview+1 where idx=1
update favorites set coText = '서울 데이트코스 모두 여기 모여라! 1. 남산 2. 롯데월드...' where idx = 1
update favorites set coTitle='이제 막 성인이된 20대 초반 어디서 연애할래?', coText = '서울 데이트코스 모두 여기 모여라! 1. 남산 2. 롯데월드...' where f_idx = 2
update favorites set coText = '<p>서울 데이트코스 모두 <span style="color:#1abc9c">여기 모여라!</span> 1. 남산 2. 롯데월드...</p>

<p>asd</p>

<p>asd</p>' where f_idx = 1
 

update favorites set coPhoto1='no_file', coPhoto2='no_file', coPhoto3='no_file' where f_idx in (1, 2, 3, 4)

--제한조건

alter table favorites
add coText varchar2(100)

alter table favorites
add coPhoto1 varchar2(100) 

alter table favorites
add coPhoto2 varchar2(100) 

alter table favorites
add coPhoto3 varchar2(100) 

alter table favorites 
modify(coText varchar2(4000)) 

alter table favorites 
drop constraint unique myNick

alter table favorites 
drop column mynick

ALTER TABLE favorites RENAME COLUMN idx TO f_idx

--즐겨찾기 정보를 저장할 테이블 생성하기 
create table mycourse
(
	mc_idx		int,		--pk
	m_idx		int,		--fk
	f_idx			int			--fk
)

--seq
create sequence seq_mycourse_idx

--제한조건
alter table mycourse
add constraint pk_mycourse primary key(mc_idx)

alter table mycourse
add constraint fk_favorites foreign key(idx) references favorites(idx) on delete cascade

alter table mycourse drop constraint fk_favorites

alter table mycourse
add constraint fk_member2 foreign key(m_idx) references member2(m_idx) on delete cascade

select * from mycourse

ALTER TABLE mycourse RENAME COLUMN idx TO f_idx

create or replace view myList
as
	select 
		f_idx, coTitle, coId, coText, coView,
		mc_idx, m_idx
	from favorites f join mycourse mc using(f_idx)
