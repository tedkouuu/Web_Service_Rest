insert into user_details(id, birth_date, name)
values (10001, current_date(), 'Ranga');

insert into user_details(id, birth_date, name)
values (10005, current_date(), 'Teo');

insert into user_details(id, birth_date, name)
values (10003, current_date(), 'Teo2');

insert into user_details(id, birth_date, name)
values (10002, current_date(), 'Teo3');

insert into post(id, description, user_id)
values (20001, 'I want to learn AWS', 10001);

insert into post(id, description, user_id)
values (20002, 'I want to learn DevOps', 10005);

insert into post(id, description, user_id)
values (20003, 'I want to learn Python', 10003);

insert into post(id, description, user_id)
values (20004, 'I want to learn Java', 10002)