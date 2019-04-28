package com.cx.prototype.mode.pojo;

/**
 * @Description 会员导出信息类
 * @Author cx
 * @Date 2019/4/26 15:20
 **/
public class TMemberPojo {

    /**
     * 姓名
     */
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
