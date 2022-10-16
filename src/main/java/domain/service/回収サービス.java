package domain.service;

import domain.model.割り勘.割り勘結果;
import domain.model.割り勘.費用回収結果;
import domain.model.参加者.参加者;
import domain.model.参加者.参加者一覧;
import domain.model.参加者.参加者名;
import domain.type.日本銀行発行通貨種別;
import domain.type.金額;

import java.util.Map;
import java.util.stream.Collectors;

public class 回収サービス {
    public 費用回収結果 費用回収実行(割り勘結果 割り勘結果, 参加者一覧 参加者一覧, 日本銀行発行通貨種別 端数単位) {

        // 参加者際に回収する金額を計算する
        Map<参加者名, 金額>回収結果一覧 = 参加者一覧.一覧().stream().map(参加者 -> {
            金額 割り勘結果金額 = 割り勘結果.次の人が支払う金額(参加者);
            金額 切り上げ結果 = 割り勘結果金額.を次の通貨発行単位まで切り上げる(端数単位);
            return new 回収結果アイテム(参加者.名前(), 切り上げ結果);
        }).collect(Collectors.toMap(回収結果アイテム::get名前, 回収結果アイテム::get回収金額));

        return new 費用回収結果(回収結果一覧);
    }

    private class 回収結果アイテム{
        参加者名 名前;
        金額 回収金額;

        回収結果アイテム(参加者名 名前, 金額 回収金額) {
            this.名前 = 名前;
            this.回収金額 = 回収金額;
        }

        public 参加者名 get名前() {
            return 名前;
        }

        public 金額 get回収金額() {
            return 回収金額;
        }
    }
}
