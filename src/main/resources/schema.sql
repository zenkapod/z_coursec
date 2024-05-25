CREATE TABLE IF NOT EXISTS tiker
(
    id serial PRIMARY KEY,
    name_tiker VARCHAR(255) NOT NULL,
    deal_place VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS fin_asset
(
    id serial PRIMARY KEY,
    tiker_id BIGINT not null,
    registration VARCHAR(255) NOT NULL,
    data_registration DATE NOT NULL,
    emitent VARCHAR(255) NOT NULL,
    form_issue VARCHAR(255) NOT NULL,
    principal NUMERIC(20, 2) NOT NULL,
    amount INTEGER NOT NULL,
    FOREIGN KEY (tiker_id) REFERENCES tiker (id)
);

CREATE TABLE IF NOT EXISTS security
(
    id serial PRIMARY KEY,
    fin_asset_id BIGINT NOT NULL,
    date_accommodation DATE NOT NULL,
    date_report DATE NOT NULL,
    FOREIGN KEY (fin_asset_id) REFERENCES fin_asset (id)
);

CREATE TABLE IF NOT EXISTS bond
(
    id serial PRIMARY KEY,
    fin_asset_id BIGINT NOT NULL,
    data_repayment DATE NOT NULL,
    coupons_amount INTEGER NOT NULL,
    coupons_rate NUMERIC(20, 2) NOT NULL,
    FOREIGN KEY (fin_asset_id) REFERENCES fin_asset (id)
);

