package domain.type;

public enum 日本銀行発行通貨種別 {
    一円玉硬貨(金額.整数より(1)),
    五円玉硬貨(金額.整数より(5)),
    十円玉硬貨(金額.整数より(10)),
    五十円玉硬貨(金額.整数より(50)),
    百円玉硬貨(金額.整数より(100)),
    五百円玉硬貨(金額.整数より(500)),
    千円札紙幣(金額.整数より(1000)),
    二千円札紙幣(金額.整数より(2000)),
    五千円札紙幣(金額.整数より(5000)),
    一万円札紙幣(金額.整数より(10000));


    金額 値;

    日本銀行発行通貨種別(金額 金額) {
        this.値 = 金額;
    }

}
