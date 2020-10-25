package domain.type;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class 百分率Test {

    @Test
    public void ゼロ以上の値は正しい百分率(){
        new 百分率(new BigDecimal(10));
    }
    @Test
    public void ゼロは正しい百分率(){
        new 百分率(new BigDecimal(0));
    }
    @Test
    public void ゼロより小さい値は正しくない百分率(){
        assertThrows(RuntimeException.class, () -> new 百分率(new BigDecimal(-10)));
    }


}
