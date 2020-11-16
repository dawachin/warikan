package domain.model.請求;

import domain.type.百分率;

public enum  消費税率区分 {

    標準税率(消費税.整数より(10)),
    軽減税率(消費税.整数より(10).軽減税率を適用(百分率.整数より(2)));

    private 消費税 税率;

    消費税率区分(消費税 消費税){
        this.税率 = 消費税;
    }

    public 百分率 税率(){
        return this.税率.率();
    }

}
