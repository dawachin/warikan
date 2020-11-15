package domain.model.請求;

import domain.model.注文.*;
import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class 注文個数Test {

    @Test
    public void 個数がマイナスは認められない() {

        // マイナスが入っているとインスタンス自体が生成できない
        Throwable 単価がマイナスでエラー = assertThrows(RuntimeException.class, ()->{
            new 注文個数(-10);
        });

        assertWithMessage("エラーがスローされている事")
                .that(単価がマイナスでエラー.getMessage()).isEqualTo("個数がマイナスになっています");
    }

    @Test
    public void 個数は最大で500() {
        // 正しくnewできればok
        new 注文個数(500);
    }

    @Test
    public void 個数は最大で500なので501ではエラー() {

        // 単価や個数にマイナスが入っているとインスタンス自体が生成できない
        // --> ”注文品”というモデルとしてあり得ない
        Throwable 単価がマイナスでエラー = assertThrows(RuntimeException.class, ()->{
            new 注文個数(501);
        });

        assertWithMessage("エラーがスローされている事")
                .that(単価がマイナスでエラー.getMessage()).isEqualTo("扱える最大注文個数を超えています");
    }
}
