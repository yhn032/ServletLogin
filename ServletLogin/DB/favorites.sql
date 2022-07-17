--���̺� ����
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

--�⺻Ű ���� 
alter table favorites 
add constraint pk_idx primary key(f_idx)

--sample
insert into favorites values( (select nvl(max(idx)+1, 1) from favorites), '���� ����Ʈ �ڽ� top10', 'ȫ¯¯', 0);
insert into favorites values( (select nvl(max(idx)+1, 1) from favorites), '���� ����Ʈ �ڽ� top5', '�ǹ���1��', 0,'���� ����Ʈ�ϰ� �;�');
delete favorites where idx = 2;

--��ȸ
select * from favorites

--test
update favorites set coView= coview+1 where idx=1
update favorites set coText = '���� ����Ʈ�ڽ� ��� ���� �𿩶�! 1. ���� 2. �Ե�����...' where idx = 1
update favorites set coTitle='���� �� �����̵� 20�� �ʹ� ��� �����ҷ�?', coText = '���� ����Ʈ�ڽ� ��� ���� �𿩶�! 1. ���� 2. �Ե�����...' where f_idx = 2
update favorites set coText = '<p>���� ����Ʈ�ڽ� ��� <span style="color:#1abc9c">���� �𿩶�!</span> 1. ���� 2. �Ե�����...</p>

<p>asd</p>

<p>asd</p>' where f_idx = 1
 

update favorites set coPhoto1='no_file', coPhoto2='no_file', coPhoto3='no_file' where f_idx in (1, 2, 3, 4)

--��������

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

--���ã�� ������ ������ ���̺� �����ϱ� 
create table mycourse
(
	mc_idx		int,		--pk
	m_idx		int,		--fk
	f_idx			int			--fk
)

--seq
create sequence seq_mycourse_idx

--��������
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
