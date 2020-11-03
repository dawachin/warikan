package domain.model.参加者;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 参加者一覧 {

    List<参加者> 参加者一覧;

    public List<参加者> 一覧(){
        return Collections.unmodifiableList(this.参加者一覧);
    }

    public 参加者一覧(List<参加者> 参加者一覧){
        this.参加者一覧 = 参加者一覧;
    }

    public 参加者の傾斜種別一覧 割り勘傾斜種別一覧(){
        return new 参加者の傾斜種別一覧(参加者一覧.stream().map(参加者 -> 参加者.傾斜種別).collect(Collectors.toList()));
    }

    public boolean に含まれているか(参加者 比較対象){
        return this.参加者一覧.stream()
                .filter(参加者 -> 参加者.equals(比較対象))
                .findFirst()
                .isPresent();
    }
}
