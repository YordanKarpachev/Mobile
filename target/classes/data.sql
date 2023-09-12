INSERT INTO roles (id, role)
values (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO users (id, email, first_name, last_name, is_active, password)
VALUES (1, 'admin@example.com', 'Admin', 'Adminov', 1, '$2a$10$YelHxdnNur5Wc3MKWuYA6OQGGTARcX1ub9z7F0Ty/5Tlm/80loZhi');


INSERT INTO users_roles (user_entity_id, roles_id)
VALUES (1, 1),
       (1, 2);


INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota'),
       (3, 'Mercedes');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1,
        'https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2,
        'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1280px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg'),
       (4, 'Clk', 'CAR', 2002, 2009, 3, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg'),
       (5, 'Cls', 'CAR', 2004, 2009, 3, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg');

insert into offers(id, offer_id, description, engine, image_url, mileage, price, transmission, year, model_id,
                   seller_id)
VALUES (1, '503a5764-feaa-43d5-ad7e-f523091fbd8f',
        ' Dieses kompakte Auto bietet sparsamen Spritverbrauch und ist ideal für die Stadt.', 'GASOLINE',
        'https://i.auto-bild.de/ir_img/5/2/7/9/8/1/Ford-Fiesta-560x373-391ad186c7f4985e.jpg',
        320001, 2601, 'MANUAL', 2005, 1, 1),
       (2, '0b9e50a0-272c-4dca-b043-cdc5d51e97bb',
        'Ein bewährtes Modell mit komfortabler Ausstattung für den täglichen Gebrauch.', 'GASOLINE',
        'https://img.indianautosblog.com/crop/1200x675/2014/11/2015-Ford-Escort-front-at-Guangzhou-Auto-Show-2014.jpg',
        13000, 8432, 'AUTOMATIC', 2015, 2, 1),
       (3, '55491147-1d2f-455e-9958-1e35f1df5a82',
        'Diese kompakten Autos bieten wirtschaftlichen Fahrspaß und sind perfekt für Pendler geeignet.', 'GASOLINE',
        'https://img.motorline.cc/cache/imageresize/static/article/images/4/42e8a3c60b55cd375f42f221904c9a08-500-.jpg',
        160000, 3200, 'MANUAL', 2010, 3, 1),
       (4, '06f84056-44f1-40d8-9333-2ed460884b25',
        'Zum Verkauf steht ein eleganter Mercedes CLK in tadellosem Zustand.', 'GASOLINE',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkDxIu1qI_oxFncSwNmLMBwolsL_NhRCMsuA&usqp=CAU',
        52000, 5300, 'AUTOMATIC', 2008, 4, 1),
       (5, 'f22248fb-d5b2-4829-ae96-75ab59f3ff22',
        'Dieses einzigartige Fahrzeug kombiniert atemberaubendes Design mit erstklassiger Leistung und modernster Technologie, um Ihnen ein unvergleichliches Fahrerlebnis zu bieten.', 'GASOLINE',
        'https://image-cdn.beforward.jp/large/202210/4241791/BM764132_a52300.jpg',
        44000, 13200, 'AUTOMATIC', 2005, 5, 1);