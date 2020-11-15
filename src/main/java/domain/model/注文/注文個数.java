package domain.model.注文;

import domain.type.個;

public class 注文個数 {

    個 注文個数;

    個 最大注文個数 = 個.整数より(500);
    個 最小注文個数 = 個.整数より(0);

    /**
     * コンストラクタ
     *
     * ■ ドメイン駆動設計でつくる
     * このコンストラクタで"注文個数"という概念の制約を表現する
     *
     * @param 個数
     */
    public 注文個数(Integer 個数){
        this.注文個数 = 個.整数より(個数);
        if ( this.注文個数.は次の値より小さいか(最小注文個数)) throw new RuntimeException("個数がマイナスになっています");
        if ( this.注文個数.は次の値より大きいか(最大注文個数)) throw new RuntimeException("扱える最大注文個数を超えています");
    }

    public boolean は次の値以上か(個 比較対象個数){
        return this.注文個数.は次の値以上か(比較対象個数);
    }

    public 個 値() {
        return this.注文個数;
    }

}
