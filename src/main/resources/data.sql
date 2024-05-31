insert into user_details (birth_date , id , name)
values(current_date() , 1001 , 'SANKET');

insert into user_details (birth_date , id , name)
values(current_date() , 1002 , 'RAJAT');

insert into user_details (birth_date , id , name)
values(current_date() , 1003 , 'CARRY');

insert into user_details (birth_date , id , name)
values(current_date() , 1004 , 'TECHNO');

insert into post (id , user_id , description)
values(201 , 1001 , 'WANT TO LEARN C++');


insert into post (id , user_id , description)
values(202 , 1002 , 'WANT TO LEARN JAVA');


insert into post (id , user_id , description)
values(203 , 1003 , 'WANT TO LEARN AWS');


insert into post (id , user_id , description)
values(204 , 1004 , 'WANT TO LEARN C#');

-- this is how one to one and many to many is working , id and user_id , how its connecting as a foreign key



