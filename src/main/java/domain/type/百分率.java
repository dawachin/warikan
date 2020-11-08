package domain.type;

import java.math.BigDecimal;
import java.util.Objects;

public class 百分率 {

    BigDecimal パーセント;

    BigDecimal ゼロ = BigDecimal.ZERO;

    public 百分率(BigDecimal パーセント){
        if (パーセント.compareTo(ゼロ) < 0) throw new RuntimeException("百分率は0以上で指定してください");
        this.パーセント = パーセント;
    }

    public static 百分率 整数より(Integer パーセント){
        return new 百分率(BigDecimal.valueOf(パーセント));
    }

    public static  百分率 ゼロ() {return new 百分率(BigDecimal.ZERO); }

    public BigDecimal を割合になおす(){
        return パーセント.divide(new BigDecimal(100));
    }


    public boolean は整数(){
        BigDecimal 小数点以下の部分 = パーセント.subtract(new BigDecimal(パーセント.intValue()));
        return 小数点以下の部分.compareTo(ゼロ) == 0;
    }

    public boolean は次の値以下(百分率 値){
        return パーセント.compareTo(値.パーセント) <= 0;
    }

    public boolean は次の値より小さい(百分率 値){
        return パーセント.compareTo(値.パーセント) < 0;
    }

    public 百分率 引く(百分率 引く値){
        return new 百分率(パーセント.subtract(引く値.パーセント));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        百分率 比較対象 = (百分率) other;
        return this.パーセント.compareTo(比較対象.パーセント) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(パーセント);
    }

    @Override
    public String toString() {
        return パーセント.toString() + "%";
    }
}
