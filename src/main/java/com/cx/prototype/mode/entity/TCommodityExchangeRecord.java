package com.cx.prototype.mode.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.cx.prototype.util.entity.BaseEntity;



/**
 * @author cx123
 * @since 2019-04-19
 */
@TableName("t_commodity_exchange_record")
public class TCommodityExchangeRecord extends BaseEntity{



    private static final long serialVersionUID = 1L;

                /**
         * 会员表ID(t_member)
         */
        private Long memberId;
        /**
         * 商品ID
         */
        private Long commodityId;
        /**
         * 兑换数量
         */
        private Integer number;
        /**
         * 兑换商品时所需积分
         */
        private Integer integral;
    




             public Long getMemberId() {
                return memberId;
                }

            public void setMemberId(Long memberId) {
                this.memberId = memberId;
                }

             public Long getCommodityId() {
                return commodityId;
                }

            public void setCommodityId(Long commodityId) {
                this.commodityId = commodityId;
                }

             public Integer getNumber() {
                return number;
                }

            public void setNumber(Integer number) {
                this.number = number;
                }

             public Integer getIntegral() {
                return integral;
                }

            public void setIntegral(Integer integral) {
                this.integral = integral;
                }




}
