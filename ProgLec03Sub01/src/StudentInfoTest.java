import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * StudentInfoクラスのテスト
 */
@RunWith(Enclosed.class)
public class StudentInfoTest {
    /**
     * StudentInfo#addStudentsに対するテスト
     */
    public static class AddStudentsTest {
        /**
         * 正常系01
         */
        @Test
        public void Test01() {
            StudentInfo StudentInfo = new StudentInfo();
            assertTrue(StudentInfo.addStudents(new Student("テストユーザ", "22R903010", 20)));
        }

        /**
         * 正常系02 100人の生徒を追加する場合
         */
        @Test
        public void Test02() {
            StudentInfo StudentInfo = new StudentInfo();
            boolean isAdded = false;
            for (int i = 0; i < 100; i++) {
                isAdded = StudentInfo.addStudents(new Student("テストユーザ" + i, "22R9030" + i, 20 + i));
            }
            assertTrue(isAdded);
            assertEquals(StudentInfo.getStudentCount(), StudentInfo.MAX_COUNT);
        }

        /**
         * 異常系03 101人の生徒を追加する場合 MAXの長さより大きい
         */
        @Test
        public void Test03() {
            StudentInfo StudentInfo = new StudentInfo();
            boolean isAdded = false;
            for (int i = 0; i < 101; i++) {
                isAdded = StudentInfo.addStudents(new Student("テストユーザ" + i, String.valueOf(i), 20 + i));
            }
            assertFalse(isAdded);
        }

        /**
         * 異常系04 すでに登録済みの生徒を登録する場合
         */
        @Test
        public void Test04() {
            StudentInfo StudentInfo = new StudentInfo();
            StudentInfo.addStudents(new Student("テストユーザ", "22R903010", 20));
            boolean isAdded = StudentInfo.addStudents(new Student("テストユーザ", "22R903010", 20));
            assertFalse(isAdded);
        }

        /**
         * 異常系05 引数にnullが入力されたときの場合
         */
        @Test
        public void Test05() {
            StudentInfo StudentInfo = new StudentInfo();
            boolean isAdded = StudentInfo.addStudents(null);
            assertFalse(isAdded);
        }
    }

    /**
     * StudentInfo#getAverageに対するテスト
     */
    public static class GetAverageTest {
        /**
         * 正常系01 登録されていない場合は0が返ってくる
         */
        @Test
        public void Test01() {
            StudentInfo StudentInfo = new StudentInfo();
            assertEquals(0.0, StudentInfo.getAverage(), 0.0);
        }

        /**
         * 正常系02 平均年齢が返ってくる
         */
        @Test
        public void Test02() {
            StudentInfo StudentInfo = new StudentInfo();
            // モックデータ
            int[] ages = {20, 21, 22};
            StudentInfo.addStudents(new Student("テストユーザ1", "22R903010", ages[0]));
            StudentInfo.addStudents(new Student("テストユーザ2", "22R903011", ages[1]));
            StudentInfo.addStudents(new Student("テストユーザ3", "22R903012", ages[2]));

            int ans = 0;
            for (int n : ages) {
                ans += n;
            }
            assertEquals((double) ans / ages.length, StudentInfo.getAverage(), 0.0);
        }
    }
}