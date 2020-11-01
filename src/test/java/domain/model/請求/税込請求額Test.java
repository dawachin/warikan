package domain.model.請求;

import domain.type.金額;
import org.junit.Test;


import java.math.BigDecimal;

import static com.google.common.truth.Truth.assertWithMessage;

public class 税込請求額Test {


    @Test
    public void 税抜き金額と消費税率から税込み金額ができる(){
        税抜請求額 税抜き金額 = new 税抜請求額(金額.整数より(1000));
        消費税 消費税 = domain.model.請求.消費税.整数より(10);
        税込請求額 税込請求額 = domain.model.請求.
                税込請求額.税抜請求額と消費税率より(税抜き金額, 消費税);
        金額 正解の税込み金額 = 金額.整数より(1100);
        assertWithMessage("税率をかけた金額と等しい事").that(税込請求額.金額()).isEqualTo(正解の税込み金額);
    }

    @Test
    public void 税込み金額は小数点以下の値も計算してあること(){
        税抜請求額 税抜き金額 = new 税抜請求額(金額.整数より(5555));
        消費税 消費税 = domain.model.請求.消費税.整数より(10);
        税込請求額 税込請求額 = domain.model.請求.
                税込請求額.税抜請求額と消費税率より(税抜き金額, 消費税);
        金額 正解の税込み金額 = new 金額(new BigDecimal("6110.5"));
        assertWithMessage("税率をかけた金額と等しい事").that(税込請求額.金額()).isEqualTo(正解の税込み金額);
    }


}
