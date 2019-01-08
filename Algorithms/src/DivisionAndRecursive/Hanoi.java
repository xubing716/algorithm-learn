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

    public static void main(String[] args) {
        move('A', 'C', 'B', 3);
    }
}
