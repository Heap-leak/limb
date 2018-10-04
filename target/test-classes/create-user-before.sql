delete from user_roles;
delete from usr;

insert into usr(id, active, password, username) values
(1, true , '1234', 'admin'),
(2, true , '1234', 'hipp');

insert into user_roles( user_id, roles) values
(1, 'USER'), (1, 'ADMIN'),
(2, 'USER');

