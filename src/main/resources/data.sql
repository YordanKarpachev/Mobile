INSERT INTO roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users (id, email, first_name, last_name, is_active, password)
VALUES
    (1, 'admin@example.com', 'Admin', 'Adminov', 1, '$2a$10$YelHxdnNur5Wc3MKWuYA6OQGGTARcX1ub9z7F0Ty/5Tlm/80loZhi');


INSERT INTO users_roles (user_entity_id, roles_id)
VALUES
    (1, 1),
    (1, 2);


INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1280px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg');

insert into offers(id,  description, engine, image_url, mileage, price, transmission, year, model_id, seller_id)
VALUES
    (1,  ' Dieses kompakte Auto bietet sparsamen Spritverbrauch und ist ideal für die Stadt.', 'GASOLINE', 'https://cdn.motor1.com/images/mgl/9Yv30/s1/ford-fiesta-st-line-2022.jpg',
     320001, 2601, 'MANUAL', 2005, 1, 1),
    (2,  'Ein bewährtes Modell mit komfortabler Ausstattung für den täglichen Gebrauch.', 'GASOLINE', 'https://www.motorsport-total.com/img/2017/170806/193197_w620_h500.jpg?ts=1687990810',
     13000, 8432, 'AUTOMATIC', 2015, 1, 1),
    (3,  'Diese kompakten Autos bieten wirtschaftlichen Fahrspaß und sind perfekt für Pendler geeignet.', 'GASOLINE', 'https://www.autozeitung.de/assets/field/image/ford-fiesta-st-2017-03.jpg',
     160000, 3200, 'MANUAL', 2010, 1, 1);