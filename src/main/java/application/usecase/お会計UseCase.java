package application.usecase;

import domain.model.注文.注文一覧;
import domain.model.注文.注文品;
import domain.type.金額;

import java.util.List;

public class お会計UseCase {

    public 金額 合計金額を計算する(List<注文品> 注文一覧){

        注文一覧 注文された一覧 = new 注文一覧(注文一覧);

        金額 丸めた金額 = 注文された一覧.税込総合計金額を出す().四捨五入();
        return 丸めた金額;
    }
}
