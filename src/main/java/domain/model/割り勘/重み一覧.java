package domain.model.割り勘;

import java.util.List;

public class 重み一覧 {

    List<重み単位> 重み一覧;

    public 重み一覧(List<重み単位> 重み一覧){
        this.重み一覧 = 重み一覧;
    }

    public 重み合計 重みの合計(){
        return new 重み合計(重み一覧.stream().mapToInt(重み単位 -> 重み単位.単位).sum());
    }



}
