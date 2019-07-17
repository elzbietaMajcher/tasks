create table orders (id integer, contactname varchar(255), address varchar(255), city varchar(255), postcode char(255), country char(255), `amount[tones]` smallint , `type` char(255));

insert into orders(id, contactname,address,city,postcode,country,`amount[tones]`,`type`) values (1,"Schmidt GmbH","Obere,Str. 57","Frankfurt","12209","Germany",150,"Barley");
insert into orders(id, contactname,address,city,postcode,country,`amount[tones]`,`type`) values (2,"Meraux","Avda. de la Constitucion 2222","Paris","05021","France",24,"Soybean");
insert into orders(id, contactname,address,city,postcode,country,`amount[tones]`,`type`) values (3,"Petersen A/S","Sundvej 2312","Aarhus","05023","Denmark",89,"Cotton");
insert into orders(id, contactname,address,city,postcode,country,`amount[tones]`,`type`) values (4,"Hardy Co.","120 Hanover Sq.","London","WA1 1DP","UK",32,"Potato");
insert into orders(id, contactname,address,city,postcode,country,`amount[tones]`,`type`) values (5,"Berglund","Berguvsvägen 8","Luleå","S-958 22","Sweden",78,"Cotton");
insert into orders(id, contactname,address,city,postcode,country,`amount[tones]`,`type`) values (6,"Fonda,Commodities","Mosley,Street 11","Manchester","M2 3JL","UK",220,"Early Rice");
insert into orders(id, contactname,address,city,postcode,country,`amount[tones]`,`type`) values (5,"McBoatie","Baker Street 21","London","81-3782","UK",78,"Onion");

-- select * from orders;

SELECT * from orders WHERE `amount[tones]` > 200;

UPDATE orders SET `type` = "corn" WHERE id = 2;
SELECT * from orders;