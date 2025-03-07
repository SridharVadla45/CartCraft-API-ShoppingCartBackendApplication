# Ecommerce App Database Schema

## Tables

### User_roles

| Column           | Data Type        | Constraints      | Notes                                  |
|------------------|------------------|-------------------|----------------------------------------|
| Id               | INT              | PRIMARY KEY       |                                        |
| Role_name        | VARCHAR          |                   | (Admin / Customer)                     |
| Created_at       | TIMESTAMP        |                   |                                        |
| Updated_at       | TIMESTAMP        | NULL              |                                        |

### Users

| Column         | Data Type        | Constraints      | Notes                                      |
|----------------|------------------|-------------------|--------------------------------------------|
| Id             | INT              | PRIMARY KEY       |                                            |
| Role_id        | INT              | FOREIGN KEY       | (References User_roles.Id) (admin/customer) |
| Full_name      | VARCHAR          |                   |                                            |
| Email          | VARCHAR          |                   |                                            |
| Password       | VARCHAR          |                   |                                            |
| Phone_number   | VARCHAR          |                   |                                            |
| Status         | ENUM             |                   | (active/inactive/block)                    |

### Categories

| Column         | Data Type        | Constraints      | Notes                                       |
|----------------|------------------|-------------------|---------------------------------------------|
| id             | INT              | PRIMARY KEY       |                                             |
| Category_name  | VARCHAR          |                   |                                             |
| Url_slug       | TEXT             | UNIQUE            | (cat-name)                                  |
| Parent_cat_id  | INT              |                   |                                             |
| Status         | ENUM             |                   | (active / inactive)                         |

### Products

| Column          | Data Type        | Constraints      | Notes                                         |
|-----------------|------------------|-------------------|-----------------------------------------------|
| Id              | INT              | PRIMARY KEY       |                                               |
| Product_name    | VARCHAR          |                   |                                               |
| Url_slug        | TEXT             | UNIQUE            |                                               |
| Cat_id          | INT              | FOREIGN KEY       | (References Categories.id)                   |
| Description     | TEXT             |                   |                                               |
| Price           | FLOAT(10, 2)     |                   |                                               |
| Stock_quantity  | INT              |                   |                                               |
| Status          | ENUM             |                   | (active / inactive)                           |

### Product_variants

| Column          | Data Type        | Constraints      | Notes                                         |
|-----------------|------------------|-------------------|-----------------------------------------------|
| Id              | INT              | PRIMARY KEY       |                                               |
| Product_id      | INT              | FOREIGN KEY       | (References Products.Id)                     |
| Color           | VARCHAR          | NULL              | (optional)                                    |
| Size            | VARCHAR          | NULL              | (optional)                                    |
| Price           | FLOAT(10, 2)     |                   |                                               |
| Stock_quantity  | INT              |                   |                                               |

### Carts

| Column             | Data Type        | Constraints      | Notes                                             |
|--------------------|------------------|-------------------|---------------------------------------------------|
| Id                 | INT              | PRIMARY KEY       |                                                   |
| User_id            | INT              | FOREIGN KEY       | (References Users.Id)                             |
| Product_id         | INT              | FOREIGN KEY       | (References Products.Id) - NULL                    |
| Product_variant_id | INT              | FOREIGN KEY       | (References Product_variants.Id) - NULL           |
| Quantity           | INT              |                   |                                                   |

### Shipping_addresses

| Column        | Data Type        | Constraints      | Notes                                      |
|---------------|------------------|-------------------|--------------------------------------------|
| Id            | INT              | PRIMARY KEY       |                                            |
| User_id       | INT              | FOREIGN KEY       | (References Users.Id)                     |
| Full_address  | VARCHAR          |                   |                                            |
| State         | VARCHAR          |                   |                                            |
| City          | VARCHAR          |                   |                                            |
| zip_code      | VARCHAR          |                   |                                            |

### Orders

| Column                 | Data Type        | Constraints      | Notes                                                              |
|------------------------|------------------|-------------------|--------------------------------------------------------------------|
| Id                     | INT              | PRIMARY KEY       |                                                                    |
| Order_number           | VARCHAR          | UNIQUE            |                                                                    |
| User_id                | INT              | FOREIGN KEY       | (References Users.Id)                                            |
| Total_amount           | FLOAT            |                   |                                                                    |
| Discount_amount        | FLOAT            |                   |                                                                    |
| Gross_amount           | FLOAT            |                   |                                                                    |
| Shipping_amount        | FLOAT            |                   |                                                                    |
| net_amount             | FLOAT            |                   |                                                                    |
| Status                 | ENUM             |                   | (placed / processing / shipping / delivered)                       |
| Payment_status         | ENUM             |                   | (paid / not paid)                                                  |
| Payment_type           | ENUM             |                   | (netbanking / upi / cod)                                           |
| Payment_transaction_id | VARCHAR          |                   |                                                                    |

### Order_items / order_products

| Column             | Data Type        | Constraints      | Notes                                                |
|--------------------|------------------|-------------------|------------------------------------------------------|
| Id                 | INT              | PRIMARY KEY       |                                                      |
| Order_id           | INT              | FOREIGN KEY       | (References Orders.Id)                              |
| Product_id         | INT              | FOREIGN KEY       | (References Products.Id)                            |
| Product_variant_id | INT              | FOREIGN KEY       | (References Product_variants.Id)                    |
| Product_name       | VARCHAR          |                   |                                                      |
| Color              | VARCHAR          | NULL              |                                                      |
| Size               | VARCHAR          | NULL              |                                                      |
| Price              | FLOAT            |                   |                                                      |
| Quantity           | INT              |                   |                                                      |
| Total_amount       | FLOAT            |                   |                                                      |

### Order_shipping_addresses

| Column             | Data Type        | Constraints      | Notes                                             |
|--------------------|------------------|-------------------|---------------------------------------------------|
| Id                 | INT              | PRIMARY KEY       |                                                   |
| Order_id           | INT              | FOREIGN KEY       | (References Orders.Id)                              |
| Shipping_address_id| INT              | FOREIGN KEY       | (References Shipping_addresses.Id)                 |
| Full_address       | VARCHAR          |                   |                                                   |
| State              | VARCHAR          |                   |                                                   |
| City               | VARCHAR          |                   |                                                   |
| Zip_code           | VARCHAR          |                   |                                                   |

### Wishlist

| Column             | Data Type        | Constraints      | Notes                                             |
|--------------------|------------------|-------------------|---------------------------------------------------|
| id                 | INT              | PRIMARY KEY       |                                                   |
| User_id            | INT              | FOREIGN KEY       | (References Users.Id)                             |
| Product_id         | INT              | FOREIGN KEY       | (References Products.Id)                            |
| Product_variant_id | INT              | FOREIGN KEY       | (References Product_variants.Id)                    |

### Offers / discounts

| Column          | Data Type        | Constraints      | Notes                                        |
|-----------------|------------------|-------------------|----------------------------------------------|
| Id              | INT              | PRIMARY KEY       |                                              |
| Coupon_code     | VARCHAR          | UNIQUE            |                                              |
| Discount_type   | ENUM             |                   | (fixed / rate)                               |
| Discount_value  | FLOAT            |                   |                                              |
| Start_date      | DATE             |                   |                                              |
| End_date        | DATE             |                   |                                              |
| Description     | TEXT             |                   |                                              |
| Status          | ENUM             |                   | (active / inactive)                          |