package cc.antx.utils.translate.chinese;

import cc.antx.utils.translate.Config;
import cc.antx.utils.web.WebUtils;

/**
 * @author zhong
 * @date 2023-02-11 15:21
 */
public class ChineseTranslation {
    public static void main(String[] args) throws Exception {
        ChineseTranslation chinese = new ChineseTranslation("你好");
        System.out.println(chinese.toEnglish());
    }

    /**
     * 中文
     */
    public String chinese;


    /**
     * 构造函数
     *
     * @param chinese 中文
     */
    public ChineseTranslation(String chinese) {
        this.chinese = chinese;
    }


    public String toEnglish() throws Exception {
        String html = WebUtils.getUrlHTML(Config.CHINESE_TO_ENGLISH_URL + chinese);

        String english = null;
        return english;
    }

}
