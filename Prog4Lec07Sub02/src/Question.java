public class Question {
    String contents;
    String choice1;
    String choice2;
    String choice3;
    String ans;
    int level;

    /**
     * コンストラクタ
     *
     * @param contents 問題文
     * @param choice1  選択肢1
     * @param choice2  選択肢2
     * @param choice3  選択肢3
     * @param ans      正解番号
     * @param level    問題レベル
     */
    public Question(String contents, String choice1, String choice2, String choice3, String ans, int level) {
        this.contents = contents;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.ans = ans;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
