package com.example.menuservice.model

import javax.persistence.*


@Entity
@Table(name = "order_items")
class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(name = "order_id")
    var orderId: Int? = null

    @Column(name = "product_id")
    var productId: Int? = null

    @Column(name = "quantity")
    var quantity: Int? = null

//    @ManyToOne
//    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
//    var order: Order? = null

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    var product: Product? = null


//    @ManyToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
//    var product: Product? = null;

}