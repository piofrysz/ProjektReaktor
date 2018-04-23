create database projektreaktor_db;
use projektreaktor_db;

create table admin(
id_a int primary key auto_increment,
login_a varchar(15),
passwd_a varchar(15)
);
insert into user (imie, nazwisko, mail, haslo, gh_login, ocena_java, ocena_spring, ocena_python, ocena_sql, opis_java, opis_python, opis_spring, opis_sql, telefon, uprawnienia) values (
'Jurek','Siurek','jurek@siurek.pl','jureksiurek','jurek95', 3, 3, 4, 5,
'Przeszłość.','Litwo, Ojczyzno moja, Ty jesteś jak zdrowie.','Było mineło.','E makarena.','369258147','ROLE_USER');

select * from user;

