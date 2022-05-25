
create table review 
(
	reviewIdx int,
	movieIdx  int,
	id varchar2(100),
	reviewDate varchar2(100),
	reviewText varchar2(100) not null

)

--�⺻Ű & �ܷ�Ű �߰�
alter table review
	add constraint pk_review_reviewIdx primary key (reviewIdx);
alter table review
	add constraint fk_review_movieIdx foreign key (movieIdx) references movie (movieIdx) ;
alter table review
	add constraint fk_review_id foreign key (id) references users (id);

--�⺻Ű & �ܷ�Ű �����	
alter table review
	drop constraint pk_review_reviewIdx
alter table review
	drop constraint fk_review_movieIdx
alter table review
	drop constraint fk_review_id

--Sample Data (�����) 	 
insert into review values(seq_reviewIdx.nextVal, 1, 'ȫ�浿', '2022-05-14', '�ȳ��ϼ����')
insert into review values(seq_reviewIdx.nextVal, 2, '�ڱ浿', '2022-05-14', '�ɱ��� �︮�� ��ȭ..')

	
--���̺� �����
drop table review

select * from REVIEW
select * from review where id = 'as' order by reviewIdx desc
----------------------------------------------------------------------------------------

create table users
(
	id varchar2(100),
	pwd varchar2(100) not null
)

alter table users
	add constraint pk_users_id primary key (id);
	
drop table users

insert into users values('�ֱԹ�', '1234');

--Sample Data (�����) 
insert into users values('ȫ�浿', '1234');	
insert into users values('�ڱ浿', '1234');	
insert into users values('���浿', '1234');	
insert into users values('������', '1234');	

select * from users
	
----------------------------------------------------------------------------------------


create table movie
(
	movieIdx int,
	movieTitle varchar2(100)
)

alter table movie
	add constraint pk_movie_movieIdx primary key (movieIdx);
	
insert into movie values (1,'������ �߾�');
insert into movie values (2,'1987');
insert into movie values (3,'���˵���');
insert into movie values (4,'���˿�������');
insert into movie values (5,'�Ƹ޸�ĭ ������');
insert into movie values (6,'������ ����');
	

select * from review
select * from users
select * from movie

--���̺� �����
drop table movie


----------------------------------------------------------------------------------------

--�� �����
create or replace view selectAll
as
select  r.reviewIdx, r.id reviewId , r.movieIdx remoIdx, u.id userId , m.movieIdx moIdx , m.movieTitle 
from review r
	left outer join users u
	on r.id = u.id
		left outer join movie m
		on r.movieIdx = m.movieIdx
	order by r.reviewIdx

	
--���� + ��ȭ ���̺� ����	
create or replace view selectReview
as
select  r.reviewIdx,
		m.movieIdx,
		m.movieTitle,
		u.id,
		r.reviewText,
		r.reviewDate
from review r left outer join users u on r.id = u.id
			  left outer join movie m on r.movieIdx = m.movieIdx
order by r.reviewIdx



	
--left outer join ��ȸ -> users, movie, review
select * from selectAll
select * from selectReview

select * from selectReview where id = 'as'

--�� ����
drop view selectAll
drop view selectReview



----------------------------------------------------------------------------------------

--������ ����
create sequence seq_reviewIdx

--������ ����
insert into review(reviewIdx) values(seq_reviewIdx.nextVal)
-- ex)
insert into review values(seq_reviewIdx.nextVal,1,'�ֱԹ�',sysdate,'�ɱ��� �︮�� ��ȭ..')

insert into review values(seq_reviewIdx.nextVal, 3, 'as', to_char(sysdate, 'YYYY-MM-DD'), '��')

