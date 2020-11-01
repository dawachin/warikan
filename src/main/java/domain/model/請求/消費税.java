package domain.model.請求;


import domain.type.百分率;

import java.math.BigDecimal;

public class 消費税 {

    百分率 消費税率;

    private final 百分率 最大消費税率 = new 百分率(new BigDecimal(100));

    public 消費税(百分率 百分率){
        if (!百分率.は整数())throw new RuntimeException("消費税率は0以上100以下の整数にしてください");
        if (!百分率.は次の値より小さい(最大消費税率)) throw new RuntimeException("消費税率は100以下にしてください");
        this.消費税率 = 百分率;
    }

    public static 消費税 整数より(Integer 整数){
        return new 消費税(new 百分率(new BigDecimal(整数)));
    }

    public 百分率 率(){
        return 消費税率;
    }


}
