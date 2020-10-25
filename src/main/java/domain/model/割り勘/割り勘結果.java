package domain.model.割り勘;

import domain.model.参加者.参加者一覧;
import domain.type.金額;


public class 割り勘結果 {

    final 参加者一覧 参加者一覧;

    final 金額 割り勘最小単位金額;

    public 割り勘結果(参加者一覧 参加者一覧, 金額 割り勘最小単位金額) {
        this.参加者一覧 = 参加者一覧;
        this.割り勘最小単位金額 = 割り勘最小単位金額;
    }
}
