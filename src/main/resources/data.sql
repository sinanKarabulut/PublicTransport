insert into Vehicle(VEHICLE_ID,VEHICLE_NAME,PLATE,MODEL,MODEL_YEAR,STATUS) values(1,'532 BUS','06 D 0071','Mercedes',2015,true);
insert into Vehicle(VEHICLE_ID,VEHICLE_NAME,PLATE,MODEL,MODEL_YEAR,STATUS) values(2,'566 BUS','06 D 0072','Mercedes',2018,true);
insert into Vehicle(VEHICLE_ID,VEHICLE_NAME,PLATE,MODEL,MODEL_YEAR,STATUS) values(3,'500 BUS','06 D 0073','Mercedes',2019,true);

insert into Station(STATION_ID,STATION_NAME,STATUS) values (1,'Etimesgut',true);
insert into Station(STATION_ID,STATION_NAME,STATUS) values (2,'Ümitköy',true);
insert into Station(STATION_ID,STATION_NAME,STATUS) values (3,'Milli Kütüphane',true);
insert into Station(STATION_ID,STATION_NAME,STATUS) values (4,'Kızılay',true);
insert into Station(STATION_ID,STATION_NAME,STATUS) values (5,'Cepa',true);


insert into Route(ROUTE_ID,ROUTE_NAME,STATUS) values(1,'KIZILAY',true);
insert into Route(ROUTE_ID,ROUTE_NAME,STATUS) values(2,'BATIKENT',true);
insert into Route(ROUTE_ID,ROUTE_NAME,STATUS) values(3,'Simsoft',true);

insert into ROUTE_STATION(ROUTE_STATION_ID,STATION_ID,ROUTE_ID,STATUS) values(1,1,3,true);
insert into ROUTE_STATION(ROUTE_STATION_ID,STATION_ID,ROUTE_ID,STATUS) values(2,2,3,true);
insert into ROUTE_STATION(ROUTE_STATION_ID,STATION_ID,ROUTE_ID,STATUS) values(3,5,3,true);

insert into ROUTE_VEHICLE(ROUTE_VEHICLE_ID,VEHICLE_ID,ROUTE_ID,STATUS) values(1,1,3,true);

insert into Users(Id,uname,pwd,name_surname,email,status) values(1,'simsoft','$2a$10$uq0TG9oZ8YzhIbGxeupMyOsHh56k7Ug4i8YyhOSysdiMhXHZIK4nK','simsoft','simsoft@simsoft.com',true);