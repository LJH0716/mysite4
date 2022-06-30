drop table files;
drop sequence seq_files_no;

create table files (
                      no number,
                      org_name   varchar2(80),
                      save_name  varchar2(2000), 
                      file_path  varchar2(2000),
                      file_size  varchar2(2000),
                      primary key(no)	
                    );

create sequence seq_files_no
increment by 1 
start with 1 
nocache ;

commit;
rollback;

select *
from files;
