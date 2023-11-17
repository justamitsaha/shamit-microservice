CREATE TABLE customer_accounts (
    customer_number VARCHAR(10),
    account_number VARCHAR(12),
    account_type VARCHAR(20),
    PRIMARY KEY (account_number)
);
ALTER TABLE customer_accounts
ADD INDEX idx_customer_number (customer_number);

INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000001', 'ACCT00000001', 'savings');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000001', 'ACCT00000002', 'credit');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000001', 'ACCT00000003', 'loans');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000001', 'ACCT00000004', 'investment');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000001', 'ACCT00000005', 'insurance');

-- Insert statements for customer 2
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000002', 'ACCT00000006', 'credit');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000002', 'ACCT00000007', 'investment');

-- Insert statements for customer 3
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000003', 'ACCT00000008', 'savings');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000003', 'ACCT00000009', 'loans');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000003', 'ACCT00000010', 'investment');

-- Insert statements for customer 4
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000004', 'ACCT00000011', 'savings');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000004', 'ACCT00000012', 'credit');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000004', 'ACCT00000013', 'investment');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000004', 'ACCT00000014', 'insurance');

-- Insert statements for customer 5
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000005', 'ACCT00000015', 'credit');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000005', 'ACCT00000016', 'loans');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000005', 'ACCT00000017', 'investment');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000005', 'ACCT00000018', 'insurance');
INSERT INTO customer_accounts (customer_number, account_number, account_type)
VALUES ('CUST000005', 'ACCT00000019', 'savings');


CREATE TABLE Customers (
    customer_number VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(10),
    country VARCHAR(50),
    registration_date DATE,
    last_purchase_date DATE,
    FOREIGN KEY (customer_number) REFERENCES customer_accounts(customer_number)
);

INSERT INTO Customers (customer_number, first_name, last_name, email, phone, address, city, state, zip_code, country, registration_date, last_purchase_date)
VALUES ('CUST000001', 'John', 'Doe', 'johndoe@example.com', '555-555-5555', '123 Main St', 'Anytown', 'CA', '12345', 'USA', '2023-10-14', '2023-10-14');

-- Insert customer 2
INSERT INTO Customers (customer_number, first_name, last_name, email, phone, address, city, state, zip_code, country, registration_date, last_purchase_date)
VALUES ('CUST000002', 'Jane', 'Smith', 'janesmith@example.com', '555-555-5556', '456 Elm St', 'Othertown', 'NY', '54321', 'USA', '2023-10-14', '2023-10-15');

-- Insert customer 3
INSERT INTO Customers (customer_number, first_name, last_name, email, phone, address, city, state, zip_code, country, registration_date, last_purchase_date)
VALUES ('CUST000003', 'David', 'Johnson', 'davidjohnson@example.com', '555-555-5557', '789 Oak St', 'Smalltown', 'TX', '67890', 'USA', '2023-10-15', '2023-10-15');

-- Insert customer 4
INSERT INTO Customers (customer_number, first_name, last_name, email, phone, address, city, state, zip_code, country, registration_date, last_purchase_date)
VALUES ('CUST000004', 'Sarah', 'Wilson', 'sarahwilson@example.com', '555-555-5558', '101 Pine St', 'Hometown', 'OH', '43210', 'USA', '2023-10-15', '2023-10-16');

-- Insert customer 5
INSERT INTO Customers (customer_number, first_name, last_name, email, phone, address, city, state, zip_code, country, registration_date, last_purchase_date)
VALUES ('CUST000005', 'Michael', 'Brown', 'michaelbrown@example.com', '555-555-5559', '222 Cedar St', 'Villagetown', 'FL', '98765', 'USA', '2023-10-16', '2023-10-16');
