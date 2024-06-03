import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static ArrayList<Question> questions;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        questions = initQuestion();

        // ソート
        questions.sort(Comparator.comparing(Question::getLevel));

        questions.forEach(question -> {
                    display(question);
                    judge(question, scanner);
                }
        );
        scanner.close();
    }

    /**
     * 問題文の設定
     */
    private static ArrayList<Question> initQuestion() {
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "アメリカの首都はどこですか？", "ニューヨーク", "ワシントン", "ロサンジェルス", "2", 2
        ));
        questions.add(new Question(
                "キリンの平均睡眠時間はどれくらいでしょうか？", "12時間", "2時間", "20分", "3", 3
        ));
        questions.add(new Question(
                "ロダン作の彫刻「考える人」は、何を考えているでしょうか？", "人生とは何か", "平和とは何か", "特に何も考えていない", "3", 2
        ));
        questions.add(new Question(
                "ネコの血液型は何種類あるでしょうか？", "3種類", "5種類", "10種類以上", "1", 1
        ));
        return questions;
    }

    /**
     * 入力値から答え合わせを行う
     *
     * @param q       問題
     * @param scanner Scannerのインスタンス
     */
    private static void judge(Question q, Scanner scanner) {
        if (q.ans.equals(inputAnswer(scanner))) {
            System.out.println("正解です。");
        } else {
            System.out.println("不正解です。");
        }
        System.out.println();
    }

    /**
     * 標準入力し受け取った整数を返す
     *
     * @return input String
     */
    private static String inputAnswer(Scanner scanner) {
        boolean isInt = false;
        String input = "";
        while (!isInt) {
            input = scanner.next();
            try {
                Integer.parseInt(input);
                isInt = true;
            } catch (IllegalStateException | NumberFormatException e) {
                System.out.print("整数を入力してください :");
            }
        }
        return input;

    }


    /**
     * 問題の表示
     *
     * @param q 問題
     */
    private static void display(Question q) {
        System.out.println(q.contents);
        System.out.println(1 + ": " + q.choice1);
        System.out.println(2 + ": " + q.choice2);
        System.out.println(3 + ": " + q.choice3);
        System.out.print("答えを番号で入力し、改行を押してください: ");
    }
}