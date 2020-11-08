package domain.model.請求;


import domain.type.百分率;

import java.math.BigDecimal;
import java.util.Objects;

public class 消費税 {

    百分率 消費税率;

    private final 百分率 最大消費税率 = new 百分率(new BigDecimal(100));

    public 消費税(百分率 百分率){
        if (!百分率.は整数())throw new RuntimeException("消費税率は0以上100以下の整数にしてください");
        if (!百分率.は次の値以下(最大消費税率)) throw new RuntimeException("消費税率は100以下にしてください");
        this.消費税率 = 百分率;
    }

    public static 消費税 整数より(Integer 整数){
        return new 消費税(new 百分率(new BigDecimal(整数)));
    }

    public 消費税 軽減税率を適用(百分率 軽減率){
        百分率 軽減税率適用結果 = 消費税率.引く(軽減率);
        if (軽減税率適用結果.は次の値より小さい(百分率.ゼロ())) throw new RuntimeException("軽減是率を適用した結果が0以下になっています");
        return new 消費税(軽減税率適用結果);
    }

    public 百分率 率(){
        return 消費税率;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        消費税 比較対象 = (消費税) other;
        return this.消費税率.equals(比較対象.消費税率);
    }

    @Override
    public int hashCode() {
        return Objects.hash(消費税率); }


}
