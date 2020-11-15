package domain.model.注文;

import java.math.BigDecimal;

public class 注文個数 {

    BigDecimal 個数;

    BigDecimal 最大注文個数 = new BigDecimal(500);

    /**
     * コンストラクタ
     *
     * ■ ドメイン駆動設計でつくる
     * このコンストラクタで"注文個数"という概念の制約を表現する
     *
     * @param 個数
     */
    public 注文個数(Integer 個数){
        if ( 個数 < 0) throw new RuntimeException("個数がマイナスになっています");
        if (new BigDecimal(個数).compareTo(最大注文個数) > 0) throw new RuntimeException("扱える最大注文個数を超えています");
        this.個数 = new BigDecimal(個数);
    }

    public boolean は次の値以上か(Integer 値){
        return this.個数.compareTo(new BigDecimal(値)) >= 0;
    }

    public BigDecimal 値() {
        return this.個数;
    }

}
