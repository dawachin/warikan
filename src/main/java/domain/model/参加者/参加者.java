package domain.model.参加者;

import domain.model.割り勘.割り勘傾斜種別;

import java.util.Objects;

public class 参加者 {

    参加者名 名前;

    割り勘傾斜種別 傾斜種別;

    public 参加者(参加者名 名前,  割り勘傾斜種別 傾斜種別){
        this.名前 = 名前;
        this.傾斜種別 = 傾斜種別;
    }

    public 割り勘傾斜種別 傾斜種別() {
        return this.傾斜種別;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        参加者 比較対象参加者 = (参加者) other;
        return this.名前.equals(比較対象参加者.名前);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.名前);
    }

    @Override
    public String toString(){
        return this.名前.toString();
    }



}
