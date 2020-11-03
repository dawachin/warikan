package domain.model.参加者;

import domain.model.割り勘.割り勘傾斜種別;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertWithMessage;

public class 参加者一覧Test {

    @Test
    public void 参加者一覧に含まれている参加者を指定するとTrue(){
        参加者 熊谷さん = new 参加者(new 参加者名("熊谷さん"), 割り勘傾斜種別.多め);
        参加者 中田さん = new 参加者(new 参加者名("中田さん"), 割り勘傾斜種別.多め);
        参加者 船山さん = new 参加者(new 参加者名("船山さん"), 割り勘傾斜種別.普通);
        参加者 大和田 = new 参加者(new 参加者名("大和田"), 割り勘傾斜種別.普通);

        参加者一覧 今日の参加者 = new 参加者一覧(Arrays.asList(
                熊谷さん, 中田さん, 船山さん, 大和田
        ));

        参加者 問い合わせ参加者 = new 参加者(new 参加者名("熊谷さん"), 割り勘傾斜種別.多め);

        boolean 結果 = 今日の参加者.に含まれているか(問い合わせ参加者);
        assertWithMessage("trueになること").that(結果).isEqualTo(true);
    }

    @Test
    public void 参加者一覧に含まれていない参加者を指定するとfalse(){
        参加者 熊谷さん = new 参加者(new 参加者名("熊谷さん"), 割り勘傾斜種別.多め);
        参加者 中田さん = new 参加者(new 参加者名("中田さん"), 割り勘傾斜種別.多め);
        参加者 船山さん = new 参加者(new 参加者名("船山さん"), 割り勘傾斜種別.普通);
        参加者 大和田 = new 参加者(new 参加者名("大和田"), 割り勘傾斜種別.普通);

        参加者一覧 今日の参加者 = new 参加者一覧(Arrays.asList(
                熊谷さん, 中田さん, 船山さん, 大和田
        ));

        参加者 問い合わせ参加者 = new 参加者(new 参加者名("松政さん"), 割り勘傾斜種別.多め);

        boolean 結果 = 今日の参加者.に含まれているか(問い合わせ参加者);
        assertWithMessage("falseになること").that(結果).isEqualTo(false);
    }

}
