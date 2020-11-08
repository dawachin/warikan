package domain.model.請求;

import org.junit.Test;

import java.math.BigDecimal;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class 注文品Test {

    @Test
    public void そもそもマイナスの単価では注文品とは見なせないよね() {

        // 単価や個数にマイナスが入っているとインスタンス自体が生成できない
        // --> ”注文品”というモデルとしてあり得ない
        Throwable 単価がマイナスでエラー = assertThrows(RuntimeException.class, ()->{
            new 注文品(new 注文品名("鉄板鶏餃子"), new 注文単価(-520), new 注文個数(2), false);
        });
        Throwable 個数がマイナスでエラー = assertThrows(RuntimeException.class, ()->{
            new 注文品(new 注文品名("鉄板鶏餃子"), new 注文単価(520), new 注文個数(-2), false);
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
            new 注文品(new 注文品名("鉄板鶏餃子"), new 注文単価(520), new 注文個数(500), true);
        });

        assertWithMessage("エラーがスローされている事")
                .that(持ち帰りなのに個数が500.getMessage()).isEqualTo("持ち帰りのときは201個以上は注文できません");
    }

    @Test
    public void 単価に個数を乗算した値が小計である() {
        注文品 注文 = new 注文品(new 注文品名("鉄板鶏餃子"), new 注文単価(520), new 注文個数(2), false);

        BigDecimal 小計 = 注文.小計();

        assertWithMessage("エラーがスローされている事")
                .that(小計).isEqualTo(new BigDecimal(1040));
    }
}
