package DivisionAndRecursive;

/**
 * Hanoi搭，即现在越南河内 典型递归思想
 * 
 * @author x00427549
 *
 */
public class Hanoi {

    private static void moveOne(char from, char to) {
        System.out.printf("%s ----> %s\n", from, to);
    }

    public static void move(char from, char to, char aux, int num) {
        if (num == 1) {
            moveOne(from, to);
            return;
        }
        move(from, aux, to, num - 1);
        moveOne(from, to);
        move(aux, to, from, num - 1);
    }

    public static int getStrCombNumsFromStart(String str, int num, char from, char to, char aux) {

        if (num == 0) {
            return 0;
        }

        // 获取最大盘子是否位于辅助上
        if (str.charAt(str.length() - 1) == aux) {
            return -1;
        }

        // 后半者部分
        if (str.charAt(str.length() - 1) == to) {
            int n = getStrCombNumsFromStart(str, num - 1, aux, to, from);
            if (n == -1) {
                return -1;
            }
            return (1 << num - 1) + n;
        }
        // 前半者部分
        return getStrCombNumsFromStart(str, num - 1, from, aux, to);
    }

    public static void main(String[] args) {
        move('A', 'C', 'B', 3);

        String str = "AAC";

        int length = getStrCombNumsFromStart(str, 3, 'A', 'C', 'B');
        System.out.println("length:" + length);
    }
}
