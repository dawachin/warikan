package application.usecase;

import domain.model.注文.注文品;
import domain.model.注文.注文小計;
import domain.type.金額;

import java.util.List;

public class お会計UseCase {

    public 金額 合計金額を計算する(List<注文品> 注文一覧){

        // 合計金額を0で初期化
        金額 税込み総合計 = 金額.ゼロ();

        // 注文一覧から合計金額を算出する
        for (注文品 注文品 : 注文一覧){

            注文小計 小計 = 注文品.小計をだす();
            金額 税込み金額 = 小計.税込金額();
            税込み総合計 = 税込み総合計.加算(税込み金額);
        }

        金額 丸めた金額 = 税込み総合計.四捨五入();
        return 丸めた金額;
    }
}
