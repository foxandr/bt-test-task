
INSERT INTO users (first_name, last_name, address) VALUES
  ('Bob', 'Smith', '123 Main Street, New York'),
  ('Bill', 'Anderson', '12401 Kingston, New York '),
  ('Karl', 'Jones', '711-2880 Nulla St.Mankato Mississippi ');



INSERT INTO accounts (first_name, last_name, account_number,account_balance,currency) VALUES
  ('Bob', 'Smith',    '563489162753',5098.2100, 'USD'),
  ('Bill', 'Anderson','872309563406',7623.9000,'EUR'),
  ('Karl', 'Jones',   '539723695398',12890.0000,'USD'),
  ('Karl', 'Jones',   '539723695399',00.0000,'EUR'),
  ('Bob', 'Smith',    '563489162754',77.5100, 'USD');


INSERT INTO operations (first_name, last_name, account_id,total_sum,operation,datetime) VALUES
  ('Bob', 'Smith',   1, 98.2100,  'Outcome', '2021-02-12 14:21:58.305'),
  ('Bob', 'Smith',   1, 8.2900,  'Income','2020-02-12 14:21:58.305'),
  ('Bill', 'Anderson',2, 3.9000,  'Outcome','2021-02-11 14:21:58.305'),
  ('Bill', 'Anderson',2, 67.9000,  'Outcome','2021-02-12 14:21:58.305'),
  ('Karl', 'Jones',   3, 100.00, 'Income','2021-02-10 14:21:58.305'),
  ('Karl', 'Jones',   3, 7800.00, 'Outcome','2021-02-12 14:21:58.305');

