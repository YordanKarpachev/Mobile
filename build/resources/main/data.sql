 insert into users ( email, first_name , last_name, image_url, is_active, password)
  values ( "admin@gmail.com", "admin", "adminNachnahme", null, 1, "2c0009569ff230a4511622896cc21bf6e7cbc8414c672d3a6f76ac127f96392be58f692f2bc125aa");

insert into  brands (id, name)
values (1, 'Ford'),
       (2, 'Toyota');

insert into models (id, name, category, start_year, end_year, brand_id, image_url)
values (1, 'Fiesta', 'CAR', 1976, null, 1 ,'https://img.zeit.de/auto/2013-05/ford-fiesta/wide__980x551'),
        (2, 'Escort', 'CAR', 1968, 2000, 1 ,'https://www.fordfan.de/fotos-modell/56/responsive/fordescort-1995-fordescort-20201214_w1280h731x133y16.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2 ,'https://assets.adac.de/image/upload/ar_16:9,c_fill,f_auto,g_auto,q_auto:eco,w_1500/v1/ADAC-eV/KOR/Bilder/PR/toyota-yaris-fahrend-2008_fozcwf.jpeg');