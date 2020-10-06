package com.cypher.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created By Ruchir Sachdeva on 3/10/2018.
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {
    @Id
    @Column(length = 120)
    private String productId;

    @NotNull
    private String productName;

    @NotNull
    private BigDecimal productPrice;

    @NotNull
    @Min(0)
    private Integer productStock;

    private String productDescription;

    private String productIcon;

    /** 0: on-sale 1: off-sale */

    @ColumnDefault("0")
    private Integer productStatus;


   /** 类目编号. */
    @ColumnDefault("0")
    private Integer categoryType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "seller_id")
    @JsonIgnore
    private User seller;

    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;

    public ProductInfo() {
    }
}
