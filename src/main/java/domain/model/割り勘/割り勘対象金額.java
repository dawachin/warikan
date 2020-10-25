package domain.model.割り勘;

import domain.type.金額;

public class 割り勘対象金額 {

    金額 割り勘対象金額;

    public 割り勘対象金額(金額 金額){
        this.割り勘対象金額 = 金額;
    }

    public 金額 を重み合計で除算した金額(重み合計 重みの合計) {
        return 割り勘対象金額.除算(重みの合計.値());
    }
}
