package domain.model.請求;

import domain.type.金額;

public class 税込請求額 {

    金額 税込金額;

    public 税込請求額(金額 金額){
        this.税込金額 = 金額;
    }

    public static 税込請求額 税抜請求額と消費税率より(税抜請求額 税抜請求額, 消費税率 税率){
        金額 税込み額 = 税抜請求額.金額().百分率を乗算する(税率.率());
        return new 税込請求額(税込み額);
    }

    public 金額 金額(){
        return this.税込金額;
    }


}
