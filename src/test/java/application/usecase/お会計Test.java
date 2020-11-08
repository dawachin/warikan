package application.usecase;

import domain.model.請求.注文品Evil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertWithMessage;

public class お会計Test {

    お会計EvilUseCase お会計UseCase = new お会計EvilUseCase();

    @Test
    public void 注文一覧から合計金出する_EVIL() {

        注文品Evil 塩つくね = new 注文品Evil();
        塩つくね.set注文品名("塩つくね");
        塩つくね.set単価(220);
        塩つくね.set個数(4);
        塩つくね.set持ち帰り(false);

        注文品Evil 鉄板鶏餃子 = new 注文品Evil();
        鉄板鶏餃子.set注文品名("鉄板鶏餃子");
        鉄板鶏餃子.set単価(520);
        鉄板鶏餃子.set個数(2);
        鉄板鶏餃子.set持ち帰り(false);

        注文品Evil 唐揚げ = new 注文品Evil();
        唐揚げ.set注文品名("唐揚げ");
        唐揚げ.set単価(420);
        唐揚げ.set個数(2);
        唐揚げ.set持ち帰り(true);

        //　注文品一覧
        List<注文品Evil> 注文一覧 = Arrays.asList(塩つくね, 鉄板鶏餃子, 唐揚げ);

        long 計算結果 = お会計UseCase.合計金額を計算する(注文一覧);

        assertWithMessage("falseになること").that(計算結果).isEqualTo(3019);

    }

    @Test(expected = RuntimeException.class)
    public void 注文品にマイナスが格納されているとき_EVIL() {

        注文品Evil 塩つくね = new 注文品Evil();
        塩つくね.set注文品名("塩つくね");
        塩つくね.set単価(220);
        塩つくね.set個数(4);
        塩つくね.set持ち帰り(false);

        注文品Evil 鉄板鶏餃子 = new 注文品Evil();
        鉄板鶏餃子.set注文品名("鉄板鶏餃子");
        鉄板鶏餃子.set単価(-520); //　×単価にマイナスとかあり得ない
        鉄板鶏餃子.set個数(-2); //　×個数にマイナスとかあり得ない
        鉄板鶏餃子.set持ち帰り(false);

        注文品Evil 唐揚げ = new 注文品Evil();
        唐揚げ.set注文品名("唐揚げ");
        唐揚げ.set単価(420);
        唐揚げ.set個数(2);
        唐揚げ.set持ち帰り(true);

        //　注文品一覧
        List<注文品Evil> 注文一覧 = Arrays.asList(塩つくね, 鉄板鶏餃子, 唐揚げ);

        long 計算結果 = お会計UseCase.合計金額を計算する(注文一覧);
    }


    @Test(expected = RuntimeException.class)
    public void お持ち帰りのときは個数上限がある_EVIL() {

        注文品Evil 塩つくね = new 注文品Evil();
        塩つくね.set注文品名("塩つくね");
        塩つくね.set単価(220);
        塩つくね.set個数(4);
        塩つくね.set持ち帰り(false);

        注文品Evil 鉄板鶏餃子 = new 注文品Evil();
        鉄板鶏餃子.set注文品名("鉄板鶏餃子");
        鉄板鶏餃子.set単価(520);
        鉄板鶏餃子.set個数(2);
        鉄板鶏餃子.set持ち帰り(false);

        注文品Evil 唐揚げ = new 注文品Evil();
        唐揚げ.set注文品名("唐揚げ");
        唐揚げ.set単価(420);
        唐揚げ.set個数(101); //　×お持ち帰りで唐揚げ2十万個とかあり得るのか
        唐揚げ.set持ち帰り(true);

        //　注文品一覧
        List<注文品Evil> 注文一覧 = Arrays.asList(塩つくね, 鉄板鶏餃子, 唐揚げ);

        long 計算結果 = お会計UseCase.合計金額を計算する(注文一覧);
    }
}
