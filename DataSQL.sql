
Category
------------------------------------------------------------

INSERT INTO public.category (name, description) VALUES ('Coffee', 'Local and International kind of coffee')returning id;
INSERT INTO public.category (name, description) VALUES ('Soft Drink', 'Fresh juice')returning id;
INSERT INTO public.category (name, description) VALUES ('Milk',null)returning id;
INSERT INTO public.category (name, description) VALUES ('Tea', 'Fruit tea and other')returning id;
INSERT INTO public.category (name, description) VALUES ('Other', null)returning id;

-----------------------------------------------------------------------
CoffeeShop
-----------------------------------------------------------------------

INSERT INTO public.coffee_shop (address, homepage, location, name, phone_number) VALUES ('56A Lê Hồng Phong','thelocalbeans.com','Hải Châu, Đà Nẵng', 'The Local Beans', '0123456789')returning id;

----------------------------------------------------------------------
Customer
-----------------------------------------------------------------------

INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('39B Trường Sơn', 'Nguyen Quoc Huy', '0987652522',null)returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('34 Đinh Tiên Hoàng', 'Nguyen Ngoc Dung', '082828272','Good Coffee')returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('12 Thanh Sơn', 'Le Thanh Hoang', '09873333322','Great decoration with warm music!')returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('399 Ngô Quyền', 'Pham Quoc Vuong', '0987653222','Everything acceptable')returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('113 Lê Duẩn', 'Dave Smith', '09876513322',null)returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('200 Thanh Thủy', 'David Mason', '0987611234','Good')returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('10 Lê Lợi', 'Tran Duc Vu', '0987667867','The soft drink is a little sweet!')returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('50 Triệu Nữ Vương', 'Hai Huynh', '0987664545','Nothing to say!')returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('211 Phan Thanh', 'Nguyen Thanh Thao', '0987642123',null)returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('256 Hải Phòng', 'Tran Quang Huy', '0987643235',null)returning id;
INSERT INTO public.customer (address, full_name, phone_number,feed_back) VALUES ('344 Trần Phú', 'Nguyen Hung Thinh', '0987623456',null)returning id;

-----------------------------------------------------------------------
Employee
-----------------------------------------------------------------------

INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'32 - 34 Dinh Tien Hoang', '1999-02-08', 'Thinh', 'MALE', '12304958202', 'Nguyen', 'Hung', '0705018299', 'MANAGER', '2017-05-04', true, 'FULLTIME', '1', 'NV001')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'64 To Huu', '2001-08-02', 'Anh', 'FEMALE', '10764123806', 'Phan Thi', 'Ngoc', '0764123806', 'WAITER', '2021-12-04', true, 'PARTIME', '1', 'NV002')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'119 Tran Xuan Le', '1999-10-13', 'Tien', 'FEMALE', '123123123451', 'Nguyen', 'Quynh', '0772261804', 'BARISTA', '2020-05-04', true, 'FULLTIME', '1', 'NV003')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'155 Trieu Nu Vuong', '1995-03-26', 'Canh', 'MALE', '12304233202', 'Le', 'Tuan', '0989120780', 'SECURITY', '2019-03-14', true, 'FULLTIME', '1', 'NV004')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'09 Nguyen Tuan', '1999-07-27', 'Quy', 'MALE', '13342958202', 'Do', 'Thanh', '0906153944', 'WAITER', '2017-11-04', true, 'PARTIME', '1', 'NV005')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'105 Ngu Hanh Son', '1999-10-27', 'Anh', 'FEMALE', '1231231242', 'Duong', 'Van', '0777545727', 'CASHIER', '2017-05-04', true, 'FULLTIME', '1', 'NV006')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'57 Ngo Tri Hoa', '1999-03-16', 'Le', 'FEMALE', '1222334202', 'Truong', 'Thi', '0935325442', 'CASHIER', '2019-07-24', true, 'FULLTIME', '1', 'NV007')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'K495 Dang Mai Chon', '1999-08-12', 'My', 'FEMALE', '12304958202', 'Huynh', 'Tra', '0789173466', 'WAITER', '2017-05-04', true, 'PARTIME', '1', 'NV008')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'382 Nui Thanh', '2001-08-27', 'Na', 'FEMALE', '12333412', 'Dang', 'Thi', '0329442768', 'BARISTA', '2019-12-03', true, 'FULLTIME', '1', 'NV009')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'32 Nguyen Van Thoai', '2002-08-11', 'Cong', 'MALE', '12304958202', 'Thai', 'Tuan', '0906498113', 'WAITER', '2019-05-04', true, 'PARTIME', '1', 'NV010')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'64 To Huu', '2001-10-01', 'Nhi', 'FEMALE', '12304958202', 'Tran', 'Thi Ai', '0856991299', 'WAITER', '2017-05-04', FALSE, 'PARTIME', '1', 'NV0011')returning id;
INSERT INTO public.employee (address, date_of_birth, first_name, gender, identity, last_name, middle_name, phone_number, role, start_date, status, type, coffee_shop_id, id) VALUES (
'09 Nguyen Tuan', '1999-10-18', 'Phong', 'MALE', '12304958202', 'Nguyen', 'Van', '0345884657', 'SECURITY', '2022-06-01', FALSE, 'PARTIME', '1', 'NV012')returning id;

---------------------------------------------------------------------
Item
---------------------------------------------------------------------

INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Black Coffee', '24000', 'ACTIVE', '1', 'CF001');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Milk Coffee', '24000', 'ACTIVE', '1', 'CF002');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Cappuchino', '39000', 'ACTIVE', '1', 'CF003');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Latte', '39000', 'ACTIVE', '1', 'CF004');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Macchiato', '39000', 'ACTIVE', '1', 'CF005');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Affogato', '39000', 'ACTIVE', '1', 'CF006');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Egg Coffee', '45000', 'ACTIVE', '1', 'CF007');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Strawberry Juice', '29000', 'ACTIVE', '2', 'J001');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Lemon Juice', '29000', 'ACTIVE', '1', 'J002');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Mango Juice', '29000', 'ACTIVE', '1', 'J003');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Watermelon Juice', '39000', 'ACTIVE', '1', 'J004');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Fresh Milk', '29000', 'ACTIVE', '1', 'M001');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Coconut Milk', '39000', 'ACTIVE', '1', 'M002');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Peach Tea', '39000', 'ACTIVE', '1', 'T001');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Leeche Tea', '39000', 'ACTIVE', '1', 'T002');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Mango Tea', '39000', 'ACTIVE', '1', 'T003');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Strawberry Tea', '39000', 'ACTIVE', '1', 'T004');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Milk Tea', '39000', 'ACTIVE', '1', 'T005');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Mix Fruit Yogurt', '45000', 'ACTIVE', '1', 'D001');
INSERT INTO public.item (
name, price, status, category_id, id) VALUES ('Cocoa', '39000', 'ACTIVE', '1', 'D002');
