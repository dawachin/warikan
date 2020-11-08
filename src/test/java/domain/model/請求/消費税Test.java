package domain.model.請求;

import domain.type.百分率;
import org.junit.Test;

import java.lang.reflect.Executable;
import java.math.BigDecimal;

import static com.google.common.truth.Truth.assertWithMessage;

public class 消費税Test {

    @Test
    public void 整数なら消費税率として正しい(){ 消費税.整数より(10); }

    @Test(expected = RuntimeException.class)
    public void 負の整数は消費税率として正しく無い(){ 消費税.整数より(-10); }

    @Test
    public void ゼロは消費税率として正しい(){
        消費税.整数より(0);
    }

    @Test(expected = RuntimeException.class)
    public void 小数点を含む消費税率は正しく無い(){
        new 消費税(new 百分率(new BigDecimal("10.05")));
    }

    @Test
    public void 小数点を含む消費税率は正しく無いが小数点以下がゼロであれば問題ない(){
        new 消費税(new 百分率(new BigDecimal("10.00")));
    }

    @Test
    public void 税率100は正しい(){
        消費税.整数より(100);
    }

    @Test(expected = RuntimeException.class)
    public void 百より大きい消費税率は正しく無い(){
        消費税.整数より(101);
    }

    @Test
    public void 軽減税率を適応できる(){
        消費税 初期 = 消費税.整数より(10);
        消費税 軽減税率適用 = 初期.軽減税率を適用(百分率.整数より(5));
        assertWithMessage("初期税率から軽減税率を適用").that(軽減税率適用).isEqualTo(消費税.整数より(5));
    }

    @Test()
    public void 軽減税率を適用して0にする事はできる() {
        消費税 初期 = 消費税.整数より(10);
        消費税 軽減税率適用 = 初期.軽減税率を適用(百分率.整数より(10));
        assertWithMessage("初期税率から軽減税率を適用").that(軽減税率適用).isEqualTo(消費税.整数より(0));
    }

    @Test(expected = RuntimeException.class)
    public void 軽減税率を適用して0より以下にはできない() {
        消費税 初期 = 消費税.整数より(10);
        初期.軽減税率を適用(百分率.整数より(15));
    }
}
