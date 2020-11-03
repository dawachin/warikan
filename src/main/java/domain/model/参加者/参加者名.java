package domain.model.参加者;


import java.util.Objects;

public class 参加者名 {

    String value;

    public 参加者名(String value){
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        参加者名 比較対象参加者名 = (参加者名) other;
        return this.value.equals(比較対象参加者名.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString(){
        return this.value;
    }
}
