insert into usr(id, username, password, active)
values (1, 'admin', '1234', true );

insert into user_roles(user_id, roles)
values (1, 'USER'), (1, 'ADMIN');