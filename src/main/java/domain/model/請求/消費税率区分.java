package domain.model.請求;

import domain.model.注文.飲食形態;
import domain.type.百分率;

public enum  消費税率区分 {

    標準税率(消費税.整数より(10), domain.model.注文.飲食形態.店内),
    軽減税率(消費税.整数より(10).軽減税率を適用(百分率.整数より(2)), domain.model.注文.飲食形態.持ち帰り);

    private 消費税 税率;
    private 飲食形態 飲食形態;

    消費税率区分(消費税 消費税, 飲食形態 飲食形態){
        this.税率 = 消費税;
        this.飲食形態 = 飲食形態;
    }

    public 消費税 税率(){
        return this.税率;
    }

    public static 消費税率区分 飲食形態より決める(飲食形態 飲食形態){
        for (消費税率区分 区分 : 消費税率区分.values()){
            if(区分.飲食形態.equals(飲食形態))return 区分;
        }
        throw new RuntimeException("指定された飲食形態に該当する税率がありません");
    }

}
