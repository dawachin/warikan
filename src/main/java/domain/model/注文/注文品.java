package domain.model.注文;

import domain.type.金額;

public class 注文品 {

    private 注文品名 注文品名;

    private 注文単価 単価;

    private 注文個数 個数;

    private 飲食形態 飲食形態;

    public 注文品(注文品名 注文品名, 注文単価 単価, 注文個数 個数, 飲食形態 飲食形態){
        if (飲食形態.equals(飲食形態.持ち帰り) && 個数.は次の注文個数以上か(new 注文個数(201)))
            throw new RuntimeException("持ち帰りのときは201個以上は注文できません");
        this.注文品名 = 注文品名;
        this.単価 = 単価;
        this.個数 = 個数;
        this.飲食形態 = 飲食形態;
    }

    /**
     * 注文品の小計
     *
     * @return
     */
    public 注文小計 小計をだす(){
        金額 税抜金額 = 単価.個数を乗算する(this.個数);
        return new 注文小計(税抜金額, 飲食形態.税区分());
    }
}
