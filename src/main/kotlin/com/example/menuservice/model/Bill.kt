package com.example.menuservice.model

import javax.persistence.*

@Entity
class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var total_price: Int? = null

    @OneToMany(cascade = [CascadeType.ALL] ,orphanRemoval = true)
    @JoinColumn(name = "bill_id", referencedColumnName = "id", insertable = false, updatable = false)
    var billitems: List<BillItem>? = null;
}