CREATE TABLE IF NOT EXISTS account
(
    account_id  bigserial PRIMARY KEY,
    country     TEXT NOT NULL,
    customer_id TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS balance
(
    account_id bigint REFERENCES account  ON DELETE CASCADE,
    currency   TEXT NOT NULL,
    balance    double precision DEFAULT 0.00,
    PRIMARY KEY (account_id, currency)
    );

CREATE TABLE IF NOT EXISTS transaction
(
    transaction_id bigserial PRIMARY KEY,
    account_id     bigint REFERENCES account  ON DELETE CASCADE,
    amount         double precision NOT NULL,
    currency       TEXT             NOT NULL,
    direction      text NOT NULL,
    description    text NOT NULL
);

DROP TABLE IF EXISTS lock_table;

CREATE TABLE lock_table
(
    account_id bigint NOT NULL REFERENCES account  ON DELETE CASCADE,
    currency   TEXT NOT NULL,
    PRIMARY KEY (account_id, currency)
);