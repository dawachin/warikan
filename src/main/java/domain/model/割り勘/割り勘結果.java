package domain.model.割り勘;

import domain.model.参加者.参加者;
import domain.model.参加者.参加者一覧;
import domain.type.金額;


public class 割り勘結果 {

    final 参加者一覧 参加者一覧;

    final 金額 割り勘最小単位金額;

    public 割り勘結果(参加者一覧 参加者一覧, 金額 割り勘最小単位金額) {
        this.参加者一覧 = 参加者一覧;
        this.割り勘最小単位金額 = 割り勘最小単位金額;
    }

    public 金額 次の人が支払う金額(参加者 問い合わせ参加者) {
        if (!this.参加者一覧.に含まれているか(問い合わせ参加者))
            throw new RuntimeException(問い合わせ参加者 + "は参加者一覧に含まれていません");

        重み単位 重み単位 = 傾斜種別ごとの重み単位区分.割り勘傾斜種別から重み単位を算出(問い合わせ参加者.傾斜種別());

        金額 支払額 = 割り勘最小単位金額.乗算(重み単位.単位数());

        return 支払額;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        this.参加者一覧.一覧().stream()
                .forEach(参加者 -> {
                    builder.append(参加者 + "のお支払いは," + this.次の人が支払う金額(参加者));
                    builder.append(System.getProperty("line.separator"));
                });


        return builder.toString();
    }
}
