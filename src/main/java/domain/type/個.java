package domain.type;

import java.math.BigDecimal;

public class 個 {

    BigDecimal 個;

    public 個(BigDecimal 個){
        this.個 = 個;
    }

    public static 個 整数より(Integer 整数個){
        return new 個(new BigDecimal(整数個));
    }

    public boolean は次の値以上か(個 比較対象){
        return this.個.compareTo(比較対象.個) >= 0;
    }

    public boolean は次の値より大きいか(個 比較対象){
        return this.個.compareTo(比較対象.個) > 0;
    }

    public boolean は次の値以下か(個 比較対象){ return this.個.compareTo(比較対象.個) <= 0; }

    public boolean は次の値より小さいか(個 比較対象){ return this.個.compareTo(比較対象.個) < 0; }

}
