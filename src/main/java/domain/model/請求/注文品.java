package domain.model.請求;

import java.math.BigDecimal;

public class 注文品 {

    private 注文品名 注文品名;

    private 注文単価 単価;

    private 注文個数 個数;

    private boolean 持ち帰り;

    public 注文品(注文品名 注文品名, 注文単価 単価, 注文個数 個数, boolean 持ち帰り){
        if (持ち帰り && 個数.は次の値以上か(201)) throw new RuntimeException("持ち帰りのときは201個以上は注文できません");
        this.注文品名 = 注文品名;
        this.単価 = 単価;
        this.個数 = 個数;
        this.持ち帰り = 持ち帰り;
    }

    /**
     * 注文品の小計
     *
     * @return
     */
    public BigDecimal 小計() {
        return 単価.次の値を乗算する(個数.値());
    }

    public boolean is持ち帰り(){
        return this.持ち帰り;
    }




}
