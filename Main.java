import java.util.Scanner;

public class Main {

    // msize=8 Map[msize][msize]
    public static final int msize = 8;
    public static int[] map = new int[msize];
    public static int numM = 0; // 움직인 횟수
    public static int numQ = 0; // 퀸 개수

    public static void main(String[] args) {

        // 맵초기화
        init_map();

        while (numQ < msize) {

            // 맵 출력
            print_map();

            // 사용자 기능 선택
            char action = get_char_from_user();

            // 반응
            switch (action) {
                case 'A':
                case 'a':
                    add_Queen();
                    break;
                case 'D':
                case 'd':
                    delete_Queen();
                    break;
                case 'M':
                case 'm':
                    move_Queen();
                    break;
            }

        }

        System.out.println("Congratulation!!!");
        System.out.println("You solved 8-queen puzzle by " + numM + " moves!");

        return;
    }

    // --------------Funtion About Map---------------------
    // initialize map
    public static void init_map() {
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
    }

    // check addible of Queen(x,y)
    public static boolean check_addible_of_Queen(int x, int y) {
        System.out.println("Please implement the \"Check_addible_of_Queen\" feature.");
        return true;
    }

    public static boolean check_Queen(int x, int y) {
        if (map[y] == x)
            return true;
        else
            return false;
    }

    // Change Map(x,y)
    public static void change_map(int x, int y, boolean Q) {
        boolean empty = !check_Queen(x, y);
        String error = "Error : Found unchecked map change attempt.\nPlease use \"change_map()\" after using \"check_Queen()\".";
        if (Q) {
            if (!empty)
                System.out.println(error);
            map[y] = x;
        } else {
            if (empty)
                System.out.println(error);
            map[y] = -1;
        }
    }

    // Count Move && init Move count

    // --------------Funtion About UI--------------------

    // Add, Delete, Move Queen
    public static void add_Queen() {
        System.out.println("Please implement the \"Add\" feature.");
    }

    public static void delete_Queen() {
        System.out.println("Please implement the \"Delete\" feature.");
    }

    public static void move_Queen() {
        System.out.println("Please implement the \"Move\" feature.");
    }

    // User input
    public static String get_user_input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        input = input.trim();

        return input;
    }

    // Get Char from user
    public static char get_char_from_user() {
        String menu = "(A)dd, (M)ove, or (D)elete? ";
        String error = "ERROR: It is not a valid option!";
        String input;
        char result = 'N';

        while (true) {
            System.out.print(menu);

            input = get_user_input();

            result = input.charAt(0);

            switch (result) {
                case 'A':
                case 'a':
                case 'D':
                case 'd':
                case 'M':
                case 'm':
                    return result;
                default:
                    System.out.println(error);
            }
        }
    }

    // print map
    public static void print_map() {
        for (int pos : map) {
            if (pos <= -1)
                for (int i = 0; i < msize; i++)
                    System.out.print(". ");
            else {
                int i = 0;
                for (; i < pos - 1; i++)
                    System.out.print(". ");
                System.out.print("Q ");
                for (; i < msize; i++)
                    System.out.print(". ");
            }
            System.out.println();

        }
    }

}
