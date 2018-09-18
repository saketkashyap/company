create table "company_emp_commands" (
  id SERIAL,
  name varchar(100) not null,
  commanddesc varchar(100) not NULL,
  status varchar(100) not NULL,
  primary key (id)
);