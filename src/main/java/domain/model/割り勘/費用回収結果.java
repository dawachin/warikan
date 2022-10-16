package domain.model.割り勘;

import domain.model.参加者.参加者;
import domain.model.参加者.参加者名;
import domain.type.金額;

import java.util.Map;

public class 費用回収結果 {

    private Map<参加者名, 金額> 回収結果一覧;

    public 費用回収結果(Map<参加者名, 金額> 結果一覧) {
        this.回収結果一覧 = 結果一覧;
    }

    public 金額 実回収総額() {
        金額 合計 = 金額.ゼロ();
        for (参加者名 名前: this.回収結果一覧.keySet()) {
            合計 = 合計.加算(this.回収結果一覧.get(名前));
        }
        return  合計;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        this.回収結果一覧.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);


        return builder.toString();
    }
}
