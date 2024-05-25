DELETE FROM bond;
DELETE FROM security;
DELETE FROM fin_asset;
DELETE FROM tiker;

ALTER SEQUENCE tiker_id_seq RESTART WITH 1;
ALTER SEQUENCE fin_asset_id_seq RESTART WITH 1;
ALTER SEQUENCE security_id_seq RESTART WITH 1;
ALTER SEQUENCE bond_id_seq RESTART WITH 1;

INSERT INTO tiker (name_tiker, deal_place) VALUES ('AAPL', 'NASDAQ');
INSERT INTO tiker (name_tiker, deal_place) VALUES ('GOOGL', 'NASDAQ');

INSERT INTO fin_asset (tiker_id, registration, data_registration, emitent, form_issue, principal, amount) VALUES (1, 'SEC', '2023-01-15', 'Apple Inc.', 'Наличная', 100.00, 1000);
INSERT INTO fin_asset (tiker_id, registration, data_registration, emitent, form_issue, principal, amount) VALUES (2, 'FCA', '2022-12-20', 'Alphabet Inc.', 'Безналичная', 50.00, 2000);

INSERT INTO security (fin_asset_id, date_accommodation, date_report) VALUES (1, '2023-01-16', '2023-01-17');
INSERT INTO security (fin_asset_id, date_accommodation, date_report) VALUES (2, '2022-12-21', '2022-12-22');

INSERT INTO bond (fin_asset_id, data_repayment, coupons_amount, coupons_rate) VALUES (1, '2024-01-15', 4, 5.00);
INSERT INTO bond (fin_asset_id, data_repayment, coupons_amount, coupons_rate) VALUES (2, '2024-02-20', 8, 4.50);


