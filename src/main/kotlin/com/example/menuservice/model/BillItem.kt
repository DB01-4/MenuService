package com.example.menuservice.model

import javax.persistence.*


@Entity
@Table(name = "bill_items")
class BillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(name = "bill_id")
    var billid: Int? = null

    @Column(name = "order_id")
    var orderid: Int? = null

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    var order: Order? = null

}