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

--��ȸ
select * from favorites

--test
update favorites set coView= coview+1 where idx=1

--��������
alter table favorites
add myNick varchar2(100) default '����' unique