package domain.type;

import java.math.BigDecimal;

public class 百分率 {

    BigDecimal パーセント;

    BigDecimal ゼロ = BigDecimal.ZERO;

    public 百分率(BigDecimal パーセント){
        if (パーセント.compareTo(ゼロ) < 0) throw new RuntimeException("百分率は0以上で指定してください");
        this.パーセント = パーセント;
    }

    public BigDecimal を割合になおす(){
        return パーセント.divide(new BigDecimal(100));
    }


    public boolean は整数(){
        BigDecimal 小数点以下の部分 = パーセント.subtract(new BigDecimal(パーセント.intValue()));
        return 小数点以下の部分.compareTo(ゼロ) == 0;
    }

    public boolean は次の値より小さい(百分率 値){
        return パーセント.compareTo(値.パーセント) <= 0;
    }
}
