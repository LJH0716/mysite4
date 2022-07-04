drop table rboard;
drop sequence seq_rboard_no;

create table rboard (
                      no number,
                      user_no number not null,
                      title varchar2(500),
                      content varchar2(4000),
                      hit number,
                      reg_date date,
                      group_no number, 
                      order_no number,
                      depth number,
                      primary key(no),	
                      constraint rboard_fk foreign key(user_no)
                      references users(no)
                      );

create sequence seq_rboard_no
increment by 1 
start with 1 
nocache ;

commit;
rollback;

--select
select  no,
        user_no,
        title,
        content,
        hit,
        to_char(reg_date,'YY-MM-DD HH24:MI') reg_date,
        group_no,
        order_no,
        depth
from rboard
order by group_no desc, order_no asc;


--insert
insert into rboard
values(seq_rboard_no.nextval, 1, '안녕하세요', 'content_01', 0, sysdate, 1, 1, 0);
insert into rboard
values(seq_rboard_no.nextval, 2, '반갑습니다', 'content_02', 0, sysdate, 2, 1, 0);
insert into rboard
values(seq_rboard_no.nextval, 8, '회식합시다', 'content_03', 0, sysdate, 3, 1, 0);

