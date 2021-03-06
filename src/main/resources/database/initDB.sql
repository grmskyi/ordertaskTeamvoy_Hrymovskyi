CREATE TABLE IF NOT EXISTS OrderItems
(
    id_order   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_order VARCHAR(100) NOT NULL,
    price      DECIMAL      NOT NULL,
    quantity   INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS Item
(
    id_item   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_item VARCHAR(100) NOT NULL,
    price     DECIMAL      NOT NULL,
    quantity  INTEGER      NOT NULL
);
