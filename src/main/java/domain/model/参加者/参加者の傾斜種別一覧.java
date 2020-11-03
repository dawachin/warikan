package domain.model.参加者;

import domain.model.割り勘.傾斜種別ごとの重み単位区分;
import domain.model.割り勘.重み一覧;
import domain.model.割り勘.重み単位;
import domain.model.割り勘.割り勘傾斜種別;

import java.util.List;
import java.util.stream.Collectors;

public class 参加者の傾斜種別一覧 {

    List<割り勘傾斜種別> 傾斜一覧;

    public 参加者の傾斜種別一覧(List<割り勘傾斜種別> 傾斜一覧){
        this.傾斜一覧 = 傾斜一覧;
    }

    public 重み一覧 重み一覧に変換(){
        List<重み単位> 重み一覧 = 傾斜一覧.stream().map(傾斜 -> 傾斜種別ごとの重み単位区分.割り勘傾斜種別から重み単位を算出(傾斜)).collect(Collectors.toList());
        return new 重み一覧(重み一覧);
    }
}
