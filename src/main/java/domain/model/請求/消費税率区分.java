package domain.model.請求;

import domain.type.百分率;

import java.math.BigDecimal;

public enum  消費税率区分 {

    標準税率(new BigDecimal(1.1)),
    軽減税率(new BigDecimal(1.08));

    private BigDecimal 税率;

    消費税率区分(BigDecimal 税率){
        this.税率 = 税率;
    }

    public static BigDecimal 消費税率を持ち帰り可否から決める(boolean 持ち帰りか){
        if (持ち帰りか) return 消費税率区分.軽減税率.税率;
        else return 消費税率区分.標準税率.税率;
    }

//    標準税率(消費税.整数より(10)),
//    軽減税率(消費税.整数より(10).軽減税率を適用(百分率.整数より(2)));

//    private 消費税 税率;

//    消費税率区分(消費税 消費税){
//        this.税率 = 消費税;
//    }

}
