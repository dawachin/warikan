package domain.model.請求;

import domain.model.注文.*;
import domain.type.金額;
import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class 注文品Test {

    @Test
    public void そもそもマイナスの単価では注文品とは見なせないよね() {

        // 単価や個数にマイナスが入っているとインスタンス自体が生成できない
        // --> ”注文品”というモデルとしてあり得ない
        Throwable 単価がマイナスでエラー = assertThrows(RuntimeException.class, ()->{
            new 注文品(new 注文品名("鉄板鶏餃子"), new 注文単価(-520), new 注文個数(2), 飲食形態.店内);
        });
        Throwable 個数がマイナスでエラー = assertThrows(RuntimeException.class, ()->{
            new 注文品(new 注文品名("鉄板鶏餃子"), new 注文単価(520), new 注文個数(-2), 飲食形態.店内);
        });

        assertWithMessage("エラーがスローされている事")
                .that(単価がマイナスでエラー.getMessage()).isEqualTo("単価がマイナスになっています");
        assertWithMessage("エラーがスローされている事")
                .that(個数がマイナスでエラー.getMessage()).isEqualTo("個数がマイナスになっています");
    }

    @Test
    public void 持ち帰りのときは個数の上限がある() {

        // 持ち帰りのとき、個数を201以上になっているとインスタンス自体が生成できない
        // --> ”注文品”というモデルとしてあり得ない
        Throwable 持ち帰りなのに個数が500 = assertThrows(RuntimeException.class, ()->{
            new 注文品(new 注文品名("鉄板鶏餃子"), new 注文単価(520), new 注文個数(500), 飲食形態.持ち帰り);
        });

        assertWithMessage("エラーがスローされている事")
                .that(持ち帰りなのに個数が500.getMessage()).isEqualTo("持ち帰りのときは201個以上は注文できません");
    }

    @Test
    public void 単価に個数を乗算した値が小計である() {
        注文品 注文 = new 注文品(new 注文品名("鉄板鶏餃子"), new 注文単価(520), new 注文個数(2), 飲食形態.店内);

        注文小計 計算結果 = 注文.小計をだす();

        金額 正解 = 金額.整数より(1040);

        assertWithMessage("正しく税抜の小計が計算されていること")
                .that(計算結果.税抜金額()).isEqualTo(正解);
    }
}
