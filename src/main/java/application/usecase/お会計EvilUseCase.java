package application.usecase;

import domain.model.注文.注文品Evil;

import java.math.BigDecimal;
import java.util.List;

public class お会計EvilUseCase {


    public long 合計金額を計算する(List<注文品Evil> 注文一覧){

        // 合計金額を0で初期化
        BigDecimal 合計金額 = BigDecimal.ZERO;

        BigDecimal 標準税率 = new BigDecimal(1.1);
        BigDecimal 軽減税率 = new BigDecimal(1.08);

        // 注文一覧から合計金額を算出する
        for (注文品Evil 注文品 : 注文一覧){

            if (注文品.get単価().compareTo(BigDecimal.ZERO) < 0) throw new RuntimeException("単価にマイナスが入っています");
            if (注文品.get個数() < 0) throw new RuntimeException("個数にマイナスが入っています");
            if (注文品.is持ち帰り() && 注文品.get個数() > 100) throw new RuntimeException("お持ち帰りの上限個数を超えています");
            if (注文品.get単価().compareTo(new BigDecimal(100000)) >= 0) throw new RuntimeException("対応できる単価を超えています");

            // 持ち帰りか否かで適用する税率が変わる
            BigDecimal 小計;
            if (注文品.is持ち帰り()){
                // 持ち帰りの時は軽減税率を適用
                小計 = 注文品.get単価().multiply(new BigDecimal(注文品.get個数())).multiply(軽減税率);
            } else {
                // 持ち帰りじゃない時は標準税率を適用
                小計 = 注文品.get単価().multiply(new BigDecimal(注文品.get個数())).multiply(標準税率);
            }
            合計金額 = 合計金額.add(小計);
        }

        BigDecimal 丸めた金額 = 合計金額.setScale(0, BigDecimal.ROUND_HALF_UP);
        return 丸めた金額.longValue();
    }
}
