package domain.model.注文;

import domain.type.金額;


public class 注文単価 {

    private 金額 単価;

    public 注文単価(Integer 単価){
        this(金額.整数より(単価));
    }

    public 注文単価(金額 単価){
        if (単価.次の金額より小さいか(金額.ゼロ())) throw new RuntimeException("単価がマイナスになっています");
        if (単価.次の金額より大きいか(金額.整数より(100000))) throw new RuntimeException("対応できる単価を超えています");
        this.単価 = 単価;
    }

    public 金額 金額(){
        return this.単価;
    }
}
