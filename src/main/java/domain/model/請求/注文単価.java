package domain.model.請求;

import java.math.BigDecimal;

public class 注文単価 {

    private BigDecimal 単価;

    public 注文単価(Integer 単価){
        if (単価 < 0) throw new RuntimeException("単価がマイナスになっています");
        this.単価 = new BigDecimal(単価);
    }

    public BigDecimal 次の値を乗算する(BigDecimal 値){
        return 単価.multiply(値);
    }

}
