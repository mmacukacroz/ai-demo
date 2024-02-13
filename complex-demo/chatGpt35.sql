-- Employees Table
CREATE TABLE Employees (
                           employee_id SERIAL PRIMARY KEY,
                           full_name VARCHAR(100),
                           role VARCHAR(100)
);

-- Customers Table
CREATE TABLE Customers (
                           customer_id SERIAL PRIMARY KEY,
                           full_name VARCHAR(100),
                           identifier VARCHAR(50),
                           date_of_birth DATE,
                           street_address VARCHAR(255),
                           city VARCHAR(100),
                           postal_code VARCHAR(20)
);

-- Accounts Table
CREATE TABLE Accounts (
                          account_id SERIAL PRIMARY KEY,
                          customer_id INT,
                          balance DECIMAL(15, 2),
                          FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- Personal Consultants Table
CREATE TABLE Personal_Consultants (
                                      consultant_id SERIAL PRIMARY KEY,
                                      employee_id INT,
                                      client_id INT,
                                      FOREIGN KEY (employee_id) REFERENCES Employees(employee_id),
                                      FOREIGN KEY (client_id) REFERENCES Customers(customer_id)
);

-- Transactions Table
CREATE TABLE Transactions (
                              transaction_id SERIAL PRIMARY KEY,
                              account_id INT,
                              employee_id INT,
                              transaction_type VARCHAR(50),
                              amount DECIMAL(15, 2),
                              transaction_date DATE,
                              FOREIGN KEY (account_id) REFERENCES Accounts(account_id),
                              FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
);