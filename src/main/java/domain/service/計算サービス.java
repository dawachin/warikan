package domain.service;

import domain.model.割り勘.割り勘対象金額;
import domain.model.割り勘.割り勘結果;
import domain.model.割り勘.重み合計;
import domain.model.参加者.参加者一覧;
import domain.model.請求.税込請求額;
import domain.type.金額;

public class 計算サービス {


    public 割り勘結果 割り勘する(税込請求額 税込額, 参加者一覧 参加者一覧){

        重み合計 重みの合計 = 参加者一覧.割り勘傾斜種別一覧().重み一覧に変換().重みの合計();


        割り勘対象金額 割り勘したい金額 = new 割り勘対象金額(税込額.金額());


        金額 割り勘最小単位金額 = 割り勘したい金額.を重み合計で除算した金額(重みの合計);


        return new 割り勘結果(参加者一覧, 割り勘最小単位金額);
    }

}
