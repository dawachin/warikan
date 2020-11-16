package application.usecase;

import domain.model.注文.注文一覧;
import domain.type.金額;

public class お会計UseCase {

    public 金額 合計金額を計算する(注文一覧 注文された一覧){
        return 注文された一覧.税込総合計金額を出す().四捨五入();
    }
}
