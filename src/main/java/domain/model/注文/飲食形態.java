package domain.model.注文;

import domain.model.請求.消費税率区分;

public enum 飲食形態 {
    店内(domain.model.請求.消費税率区分.標準税率),
    持ち帰り(domain.model.請求.消費税率区分.軽減税率);

    private final 消費税率区分 消費税率区分;

    public 消費税率区分 税区分(){
        return this.消費税率区分;
    }

    飲食形態(消費税率区分 消費税率区分){
        this.消費税率区分 = 消費税率区分;
    }
}
