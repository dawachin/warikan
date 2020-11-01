package domain.model.請求;

import domain.type.金額;

public class 税込請求額 {

    金額 金額;

    消費税 消費税;

    public 税込請求額(金額 金額, 消費税 消費税){
        this.金額 = 金額;
        this.消費税 = 消費税;
    }

    public static 税込請求額 税抜請求額と消費税率より(税抜請求額 税抜請求額, 消費税 消費税){
        return new 税込請求額(税抜請求額.金額(), 消費税);
    }

    public 金額 金額(){
        金額 税込み額 = this.金額.百分率を乗算する(消費税.率());
        return 税込み額;
    }


}
