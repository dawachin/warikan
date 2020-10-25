package domain.model.請求;

import domain.type.百分率;
import org.junit.Test;

import java.math.BigDecimal;

public class 消費税率Test {

    @Test
    public void 整数なら消費税率として正しい(){ 消費税率.整数より(10); }
    @Test(expected = RuntimeException.class)
    public void 負の整数は消費税率として正しく無い(){ 消費税率.整数より(-10); }
    @Test
    public void ゼロは消費税率として正しい(){
        消費税率.整数より(0);
    }
    @Test(expected = RuntimeException.class)
    public void 小数点を含む消費税率は正しく無い(){
        new 消費税率(new 百分率(new BigDecimal("10.05")));
    }
    @Test
    public void 小数点を含む消費税率は正しく無いが小数点以下がゼロであれば問題ない(){
        new 消費税率(new 百分率(new BigDecimal("10.00")));
    }
    @Test
    public void 税率100は正しい(){
        消費税率.整数より(100);
    }
    @Test(expected = RuntimeException.class)
    public void 百より大きい消費税率は正しく無い(){
        消費税率.整数より(101);
    }
}
