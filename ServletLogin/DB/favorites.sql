--���̺� ����
create table favorites
(
	idx int,
	coTitle varchar2(100) not null,
	coId    varchar2(100) not null,
	coView  int default 0
)

--�⺻Ű ���� 
alter table favorites 
add constraint pk_idx primary key(idx)

--sample
insert into favorites values( (select nvl(max(idx)+1, 1) from favorites), '���� ����Ʈ �ڽ� top10', 'ȫ¯¯', 0);
insert into favorites values( (select nvl(max(idx)+1, 1) from favorites), '���� ����Ʈ �ڽ� top5', '�ǹ���1��', 0, '����','���� ����Ʈ�ϰ� �;�');
delete favorites where idx = 2;

--��ȸ
select * from favorites
select idx from favorites where myNick='ȫ¯¯';

--test
update favorites set coView= coview+1 where idx=1
update favorites set coText = '���� ����Ʈ�ڽ� ��� ���� �𿩶�! 1. ���� 2. �Ե�����...' where idx = 1

--��������
alter table favorites
add myNick varchar2(100) default '����' unique

alter table favorites
add coText varchar2(100)

alter table favorites 
drop constraint unique myNick

