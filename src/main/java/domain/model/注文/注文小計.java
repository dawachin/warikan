package domain.model.注文;

import domain.model.請求.消費税率区分;
import domain.type.金額;

public class 注文小計 {

    private final 金額 税抜合計金額;

    private final 消費税率区分 税区分;

    public 注文小計(金額 税抜合計金額, 消費税率区分 税区分){
        this.税抜合計金額 = 税抜合計金額;
        this.税区分 = 税区分;
    }

    public 金額 税抜金額(){
        return this.税抜合計金額;
    }

    public 金額 税込金額(){
        金額 税込金額 = this.税抜合計金額.次の消費税を乗算する(this.税区分.税率());
        return 税込金額;
    }

    public 金額 消費税金額分() {
        return this.税抜合計金額.百分率を乗算する(this.税区分.税率().率());
    }

}
