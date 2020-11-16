package application.usecase;

import domain.model.注文.*;
import domain.type.金額;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertWithMessage;

public class お会計Test {

    お会計UseCase お会計UseCase = new お会計UseCase();

    @Test
    public void 注文一覧から合計金出する() {

        注文品 塩つくね = new 注文品(new 注文品名("塩つくね"), new 注文単価(220), new 注文個数(4), 飲食形態.店内);
        注文品 鉄板鶏餃子 = new 注文品(new 注文品名("鉄板鶏餃子"), new 注文単価(520), new 注文個数(2), 飲食形態.店内);
        注文品 唐揚げ = new 注文品(new 注文品名("唐揚げ"), new 注文単価(420), new 注文個数(2), 飲食形態.持ち帰り);

        //　注文品一覧
        注文一覧 注文された一覧 = new 注文一覧(Arrays.asList(塩つくね, 鉄板鶏餃子, 唐揚げ));

        金額 計算結果 = お会計UseCase.合計金額を計算する(注文された一覧);

        金額 予想 = 金額.整数より(3019);

        assertWithMessage("予想と等しいこと").that(計算結果).isEqualTo(予想);

    }


}
