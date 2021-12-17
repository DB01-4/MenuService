package com.example.menuservice.model

import javax.persistence.*
import com.example.menuservice.model.OrderItem

@Entity
@Table(name = "orders")
class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null;

    @Column(name = "table_id")
    var tableId: Int? = null;

    @Column(name = "status", nullable = true)
    var status: Int? = null;

    @OneToMany(cascade = [CascadeType.ALL] ,orphanRemoval = true)
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    var orderItems: List<OrderItem>? = null;

    class Order(){}

    /*@ManyToMany
    @JoinTable(
        name = "order_items",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    val products: List<Product>? = null*/

}