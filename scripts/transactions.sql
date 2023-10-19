use `mainservicedb`;
-- Insert customer 2
CREATE TABLE `transactions` (
  `transaction_id` varchar(50) NOT NULL,
  `account_number` varchar(20) DEFAULT NULL,
  `transaction_date` date DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `debit_credit` enum('Debit','Credit') DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `account_number` (`account_number`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`account_number`) REFERENCES `customer_accounts` (`customer_number`)
)