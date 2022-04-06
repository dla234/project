insert into creator(creatorID,name,create_date,modified_date) values ('creator1','승우아빠','2022-01-01T22:22:57','2022-01-01T22:22:57');
insert into creator(creatorID,name,create_date,modified_date) values ('creator2','풍월량','2022-02-01T22:22:57','2022-02-01T22:22:57');
insert into creator(creatorID,name,create_date,modified_date) values ('creator3','김성회','2022-03-01T22:22:57','2022-03-01T22:22:57');
insert into creator(creatorID,name,create_date,modified_date) values ('creator4','침착맨','2022-04-01T22:22:57','2022-04-01T22:22:57');
insert into creator(creatorID,name,create_date,modified_date) values ('creator5','주호민','2022-04-01T22:22:57','2022-04-01T22:22:57');

insert into channel(channelID,name,create_date,modified_date) values ('channel1','승우아빠','2022-01-01T22:22:57','2022-01-01T22:22:57');
insert into channel(channelID,name,create_date,modified_date) values ('channel2','승우아빠 일상채널','2022-02-01T22:22:57','2022-02-01T22:22:57');
insert into channel(channelID,name,create_date,modified_date) values ('channel3','풍월량','2022-02-01T22:22:57','2022-02-01T22:22:57');
insert into channel(channelID,name,create_date,modified_date) values ('channel4','G식 백과','2022-03-01T22:22:57','2022-03-01T22:22:57');
insert into channel(channelID,name,create_date,modified_date) values ('channel5','침착맨 플러스','2022-04-01T22:22:57','2022-04-01T22:22:57');
insert into channel(channelID,name,create_date,modified_date) values ('channel6','샌드박스','2022-04-01T22:22:57','2022-04-01T22:22:57');

insert into share_contract(contractID,profitrate,channelid,creatorid,create_date,modified_date) values ('contract1',100,'channel1','creator1','2022-01-01T22:22:57','2022-01-01T22:22:57');
insert into share_contract(contractID,profitrate,channelid,creatorid,create_date,modified_date) values ('contract2',80,'channel2','creator1','2022-02-01T22:22:57','2022-04-01T22:22:57');
insert into share_contract(contractID,profitrate,channelid,creatorid,create_date,modified_date) values ('contract3',100,'channel3','creator2','2022-03-01T22:22:57','2022-04-01T22:22:57');
insert into share_contract(contractID,profitrate,channelid,creatorid,create_date,modified_date) values ('contract4',60,'channel4','creator3','2022-03-01T22:22:57','2022-04-01T22:22:57');
insert into share_contract(contractID,profitrate,channelid,creatorid,create_date,modified_date) values ('contract5',40,'channel5','creator4','2022-03-01T22:22:57','2022-04-01T22:22:57');
insert into share_contract(contractID,profitrate,channelid,creatorid,create_date,modified_date) values ('contract6',20,'channel6','creator2','2022-04-01T22:22:57','2022-04-01T22:22:57');
insert into share_contract(contractID,profitrate,channelid,creatorid,create_date,modified_date) values ('contract7',20,'channel6','creator3','2022-04-01T22:22:57','2022-04-01T22:22:57');
insert into share_contract(contractID,profitrate,channelid,creatorid,create_date,modified_date) values ('contract8',10,'channel6','creator5','2022-04-01T22:22:57','2022-04-01T22:22:57');

insert into channel_sales(profit,channelID,create_date,modified_date) values(500000,'channel1','2022-01-01','2022-01-01');
insert into channel_sales(profit,channelID,create_date,modified_date) values(5000000,'channel1','2022-01-02','2022-01-02');
insert into channel_sales(profit,channelID,create_date,modified_date) values(1250000,'channel1','2022-01-03','2022-01-03');
insert into channel_sales(profit,channelID,create_date,modified_date) values(100000,'channel1','2022-01-04','2022-01-04');
insert into channel_sales(profit,channelID,create_date,modified_date) values(1300000,'channel1','2022-01-05','2022-01-05');
insert into channel_sales(profit,channelID,create_date,modified_date) values(5000000,'channel1','2022-01-06','2022-01-06');
insert into channel_sales(profit,channelID,create_date,modified_date) values(10000000,'channel1','2022-01-07','2022-01-07');
insert into channel_sales(profit,channelID,create_date,modified_date) values(300000,'channel1','2022-01-08','2022-01-08');
insert into channel_sales(profit,channelID,create_date,modified_date) values(50000000,'channel1','2022-01-09','2022-01-09');
insert into channel_sales(profit,channelID,create_date,modified_date) values(600000,'channel1','2022-01-10','2022-01-10');
insert into channel_sales(profit,channelID,create_date,modified_date) values(700000,'channel1','2022-01-12','2022-01-11');
insert into channel_sales(profit,channelID,create_date,modified_date) values(1000000000,'channel1','2022-01-12','2022-01-12');

insert into channel_sales(profit,channelID,create_date,modified_date) values(10000000,'channel1','2022-02-07','2022-02-07');
insert into channel_sales(profit,channelID,create_date,modified_date) values(300000,'channel1','2022-02-08','2022-02-08');
insert into channel_sales(profit,channelID,create_date,modified_date) values(50000000,'channel1','2022-02-09','2022-02-09');
insert into channel_sales(profit,channelID,create_date,modified_date) values(600000,'channel1','2022-02-10','2022-02-10');
insert into channel_sales(profit,channelID,create_date,modified_date) values(700000,'channel1','2022-02-12','2022-02-11');
insert into channel_sales(profit,channelID,create_date,modified_date) values(10000000,'channel1','2022-02-12','2022-02-12');


insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(10000000,'channel2','2022-01-07','2022-01-07','2022-01-07');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(300000,'channel2','2022-01-08','2022-01-08','2022-01-08');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(50000000,'channel2','2022-01-09','2022-01-09','2022-01-09');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(600000,'channel2','2022-01-10','2022-01-10','2022-01-10');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(700000,'channel2','2022-01-12','2022-01-12','2022-01-12');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(10000001,'channel2','2022-01-13','2022-01-13','2022-01-13');

insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(10000000,'channel6','2022-01-07','2022-01-07','2022-01-07');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(300000,'channel6','2022-01-08','2022-01-08','2022-01-08');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(50000000,'channel6','2022-01-09','2022-01-09','2022-01-09');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(600000,'channel6','2022-01-10','2022-01-10','2022-01-10');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(700000,'channel6','2022-01-12','2022-01-12','2022-01-12');
insert into channel_sales(profit,channelID,register_date,create_date,modified_date) values(10000001,'channel6','2022-01-13','2022-01-13','2022-01-13');