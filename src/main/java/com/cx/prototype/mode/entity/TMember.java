package com.cx.prototype.mode.entity;


import com.baomidou.mybatisplus.annotations.TableName;
import com.cx.prototype.util.entity.BaseEntity;



/**
 * @author cx123
 * @since 2019-04-21
 */
@TableName("t_member")
public class TMember extends BaseEntity{



    private static final long serialVersionUID = 1L;

                private String name;
        /**
         * 电话号码
         */
        private String phone;
        /**
         * 账户余额
         */
        private Double balance;
        /**
         * 账户积分
         */
        private Integer integral;
    




             public String getName() {
                return name;
                }

            public void setName(String name) {
                this.name = name;
                }

             public String getPhone() {
                return phone;
                }

            public void setPhone(String phone) {
                this.phone = phone;
                }

             public Double getBalance() {
                return balance;
                }

            public void setBalance(Double balance) {
                this.balance = balance;
                }

             public Integer getIntegral() {
                return integral;
                }

            public void setIntegral(Integer integral) {
                this.integral = integral;
                }




}
