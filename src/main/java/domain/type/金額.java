package domain.type;

import java.math.BigDecimal;
import java.util.Objects;

public class 金額 {

    BigDecimal value;

    public 金額(BigDecimal value){
        this.value = value;
    }

    public static 金額 整数より(Integer 整数){
        return new 金額(new BigDecimal(整数));
    }

    public 金額 百分率を乗算する(百分率 百分率){
        BigDecimal 答え = this.value.add(value.multiply(百分率.を割合になおす()));
        return new 金額(答え);
    }

    public 金額 除算(Integer 割る数){
        return new 金額(this.value.divide(new BigDecimal(割る数),2, BigDecimal.ROUND_HALF_UP));
    }

    public 金額 乗算(Integer かける数) {return new 金額(this.value.multiply(new BigDecimal(かける数))); }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        金額 比較対象金額 = (金額) other;
        return this.value.compareTo(比較対象金額.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "¥ " + value.toString();
    }
}
