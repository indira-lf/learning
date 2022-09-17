package com.feng.sharding.vo;

import java.math.BigDecimal;

/**
 * @author
 * @time 2022/9/16 21:47
 * @Description- TODO
 */
public class OrderVo {
    private String orderNo;
    private BigDecimal amount;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                '}';
    }
}
