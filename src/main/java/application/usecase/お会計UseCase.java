package application.usecase;

import domain.model.請求.注文品;
import domain.model.請求.注文品Evil;
import domain.model.請求.消費税率区分;

import java.math.BigDecimal;
import java.util.List;

public class お会計UseCase {

    public long 合計金額を計算する(List<注文品> 注文一覧){


        // 合計金額を0で初期化
        BigDecimal 合計金額 = BigDecimal.ZERO;

        // 注文一覧から合計金額を算出する
        for (注文品 注文品 : 注文一覧){

            BigDecimal 消費税 = 消費税率区分.消費税率を持ち帰り可否から決める(注文品.is持ち帰り());
            BigDecimal 小計 = 注文品.小計().multiply(消費税);
            合計金額 = 合計金額.add(小計);

        }

        BigDecimal 丸めた金額 = 合計金額.setScale(0, BigDecimal.ROUND_HALF_UP);
        return 丸めた金額.longValue();
    }
}
