package domain.model.請求;

import java.math.BigDecimal;

public class 注文品Evil {

    private String 注文品名;

    private BigDecimal 単価;

    private Integer 個数;

    private boolean 持ち帰り;

    public Integer get個数() {
        return 個数;
    }

    public void set個数(Integer 個数) {
        this.個数 = 個数;
    }

    public String get注文品名() {
        return 注文品名;
    }

    public void set注文品名(String 注文品名) {
        this.注文品名 = 注文品名;
    }

    public BigDecimal get単価() {
        return 単価;
    }

    public void set単価(BigDecimal 単価) {
        this.単価 = 単価;
    }
    public void set単価(Integer 単価) {
        this.単価 = new BigDecimal(単価);
    }

    public boolean is持ち帰り() {
        return 持ち帰り;
    }

    public void set持ち帰り(boolean 持ち帰り) {
        this.持ち帰り = 持ち帰り;
    }
}
