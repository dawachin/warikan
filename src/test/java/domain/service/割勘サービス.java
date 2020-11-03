package domain.service;

import domain.model.割り勘.割り勘傾斜種別;
import domain.model.割り勘.割り勘結果;
import domain.model.参加者.参加者;
import domain.model.参加者.参加者一覧;
import domain.model.参加者.参加者名;
import domain.model.請求.消費税;
import domain.model.請求.税込請求額;
import domain.type.金額;
import org.junit.Test;

import java.util.Arrays;

public class 割勘サービス {

    計算サービス 割り勘計算サービス = new 計算サービス();

    @Test
    public void 試験(){

        参加者 熊谷さん = new 参加者(new 参加者名("熊谷さん"), 割り勘傾斜種別.多め);
        参加者 中田さん = new 参加者(new 参加者名("中田さん"), 割り勘傾斜種別.多め);
        参加者 茂木さん = new 参加者(new 参加者名("茂木さん"), 割り勘傾斜種別.多め);
        参加者 船山さん = new 参加者(new 参加者名("船山さん"), 割り勘傾斜種別.多め);
        参加者 大和田 = new 参加者(new 参加者名("大和田"), 割り勘傾斜種別.普通);
        参加者 松政さん = new 参加者(new 参加者名("松政さん"), 割り勘傾斜種別.普通);
        参加者 中島さん = new 参加者(new 参加者名("中島さん"), 割り勘傾斜種別.少なめ);
        参加者 周さん = new 参加者(new 参加者名("周さん"), 割り勘傾斜種別.少なめ);

        参加者一覧 今日の参加者 = new 参加者一覧(Arrays.asList(
                熊谷さん, 中田さん, 茂木さん, 船山さん, 大和田, 松政さん, 中島さん, 周さん
        ));

        税込請求額 お支払い = new 税込請求額(金額.整数より(30000), 消費税.整数より(10));

        割り勘結果 割り勘結果 = 割り勘計算サービス.割り勘する(お支払い, 今日の参加者);

        System.out.println("===============================================");
        System.out.print(割り勘結果);
        System.out.println("===============================================");


    }

}
