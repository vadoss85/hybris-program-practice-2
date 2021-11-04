# hybris-program-practice-2

Hybris Academy practice work. Part 2

Ciklum Hybris test task with using Java Servlets.

##Database
```mysql
    create table order_items
    (
    order_id   int null,
    product_id int null,
    quantity   int null
    );
```
```mysql
    create table orders
    (
    id         int auto_increment
    primary key,
    user_id    int          null,
    status     varchar(255) null,
    created_at datetime     null
    );
```
```mysql
    create table products
    (
    id         int auto_increment
    primary key,
    name       varchar(255)                                     null,
    price      int                                              null,
    status     enum ('out_of_stock', 'in_stock', 'running_low') null,
    created_at datetime                                         null
    );
```

##Available routes
**/show-products** - *list of created products*

**/product** - *product creation form*

**/product?id={productId}** - *product edit form*

**/delete-product** - *All products deleting form*

**/delete-product?productId={productId}** - *Delete single product form*

**/ordered-products** - *list of ordered products which have been ordered at least once, with total ordered quantity sorted descending by the quantity*

**/orders** - *list of orders using view from task*

**/orders?id={orderId}** - *single order using previous view*
