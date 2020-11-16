package domain.type;

import domain.model.請求.消費税;

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

    public static 金額 ゼロ() {return new 金額(BigDecimal.ZERO);}

    public 金額 百分率を乗算する(百分率 百分率){
        BigDecimal 答え = this.value.multiply(百分率.を割合になおす());
        return new 金額(答え);
    }

    public 金額 次の消費税を乗算する(消費税 消費税) {
        BigDecimal 答え = this.value.add(value.multiply(消費税.率().を割合になおす()));
        return new 金額(答え);
    }

    public 金額 除算(Integer 割る数){
        return new 金額(this.value.divide(new BigDecimal(割る数),2, BigDecimal.ROUND_HALF_UP));
    }

    public 金額 乗算(Integer かける数) {return new 金額(this.value.multiply(new BigDecimal(かける数))); }

    public 金額 乗算(個 かける数) {return new 金額(this.value.multiply(かける数.個)); }

    public 金額 減算(金額 減算額) {return new 金額(this.value.subtract(減算額.value)); }

    public 金額 加算(金額 加算額) {return new 金額(this.value.add(加算額.value)); }

    public 金額 四捨五入() {return new 金額(this.value.setScale(0, BigDecimal.ROUND_HALF_UP)); }

    public boolean 次の金額より大きいか(金額 比較金額){
        return this.value.compareTo(比較金額.value) > 0;
    }

    public boolean 次の金額より小さいか(金額 比較金額) {
        return this.value.compareTo(比較金額.value) < 0;
    }


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
        return "¥" + value.toString();
    }
}
