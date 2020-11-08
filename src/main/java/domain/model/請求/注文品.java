package domain.model.請求;

import java.math.BigDecimal;

public class 注文品 {

    private String 注文品名;

    private BigDecimal 単価;

    private Integer 個数;

    private boolean 持ち帰り;

    public 注文品(String 注文品名, Integer 単価, Integer 個数, boolean 持ち帰り){

        if (単価 < 0) throw new RuntimeException("単価がマイナスになっています");
        if (個数 < 0) throw new RuntimeException("個数がマイナスになっています");
        if (持ち帰り && 個数 > 200) throw new RuntimeException("持ち帰りのときは201個以上は注文できません");

        this.注文品名 = 注文品名;
        this.単価 = new BigDecimal(単価);
        this.個数 = 個数;
        this.持ち帰り = 持ち帰り;
    }




}
