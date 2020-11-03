package domain.model.請求;

import domain.type.金額;

public class 税抜請求額 {

    金額 税抜き請求額;

    public 税抜請求額(金額 税抜き請求額){
        this.税抜き請求額 = 税抜き請求額;
    }

    public 金額 金額(){
        return 税抜き請求額;
    }

    public 税込請求額 消費税を乗算する(消費税 今日の消費税率) {
        return 税込請求額.税抜請求額と消費税率より(this, 今日の消費税率);
    }
}
