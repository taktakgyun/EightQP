import java.util.Scanner;

public class Main {

    // msize=8 Map[msize][msize]
    public static final int msize = 8;
    public static int[] map = new int[msize];
    public static int numM = 0; // ������ Ƚ��
    public static int numQ = 0; // �� ����
    public static int numInit = -100;

    public static void main(String[] args) {

        // ���ʱ�ȭ
        init_map();
        init_numM();

        while (get_number_of_Queen() < msize) {

            // �� ���
            print_map();

            // ����� ��� ����
            char action = get_char_from_user();

            // ����
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
            map[i] = numInit;
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
            map[y] = numInit;
        }
    }

    public static int get_number_of_Queen() {
        int sum = 0;
        for (int i : map) {
            if (i >= 0) {
                sum += 1;
            }
        }
        return sum;
    }

    // ---------------------Function About Other function-----------

    public static boolean check_valid_of_pos(int x, int y) {
        // �� ���� ���� ���
        if ((x >= 0 && x < msize) && (y >= 0 && y < msize))
            return true;

        // �� ���� ���� ���
        return false;
    }

    // Count Move && init Move count
    public static void init_numM() {
        numM = 0;
    }

    public static void count_numM() {
        numM++;
    }

    // --------------Funtion About UI--------------------

    // Add, Delete, Move Queen
    public static void add_Queen() {
        int x, y;

        // ����� ��ǥ �Է�
        System.out.print("Input new queen's position (x,y): ");
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();

        x = Integer.parseInt(temp.split(" ")[0].trim()) - 1;
        y = Integer.parseInt(temp.split(" ")[1].trim()) - 1;

        // ����� ��ǥ ��ȿ�� Ȯ��
        // check_valid_of_pos
        if (!check_valid_of_pos(x, y)) {
            System.out.println("ERROR: It is not a valid position!");
            return;
        }
        // ��ǥ�� Queen�� �Ѽ� �ִ��� Ȯ��
        // check_addible_of_Queen
        if (!check_addible_of_Queen(x, y)) {
            System.out.println("ERROR: It is not a valid position!");
            return;
        }

        // �����ϴٸ�, Queen�� �ΰ�, Queen����
        // ����(numQ) �̵� Ƚ��(numM) 1ȸ ����
        change_map(x, y, true);
        count_numM();
    }

    public static void delete_Queen() {
        int x, y;

        // ����� ��ǥ �Է�
        System.out.print("Input old queen's position (x,y): ");
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();

        x = Integer.parseInt(temp.split(" ")[0].trim()) - 1;
        y = Integer.parseInt(temp.split(" ")[1].trim()) - 1;

        // ����� ��ǥ ��ȿ�� Ȯ��
        // check_valid_of_pos
        if (!check_valid_of_pos(x, y)) {
            System.out.println("ERROR: It is not a valid position!");
            return;
        }
        // ��ǥ�� Queen�� �����ϴ��� Ȯ��
        // check_Queen(x,y)
        if (!check_Queen(x, y)) {
            System.out.println("ERROR: It is not a valid position!");
            return;
        }
        // Queen�� ������ �� �ִٸ�,
        // �����ϰ� �̵� Ƚ��(numM) 1ȸ ����
        change_map(x, y, false);
        count_numM();
    }

    public static void move_Queen() {
        System.out.println("Please implement the \"Move\" feature.");
    }

    // Get Char from user
    public static char get_char_from_user() {
        String menu = "(A)dd, (M)ove, or (D)elete? ";
        String error = "ERROR: It is not a valid option!";
        String input;
        char result = 'N';

        while (true) {
            System.out.print(menu);
            Scanner scanner = new Scanner(System.in);

            input = scanner.nextLine();
            input = input.trim();

            result = input.charAt(0);

            switch (result) {
                case 'A':
                case 'a':
                case 'D':
                case 'd':
                case 'M':
                case 'm':
                    break;
                default:
                    System.out.println(error);
                    continue;
            }
            break;
        }
        return result;
    }

    // print map
    public static void print_map() {
        System.out.println("(numM:" + numM + " | numQ:" + get_number_of_Queen() + ")");
        System.out.print("  ");
        for (int i = 1; i <= msize; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int y = 0; y < msize; y++) {
            int pos = map[y];
            System.out.print((y + 1) + " ");
            if (pos <= -1)
                for (int x = 0; x < msize; x++) {
                    if (!check_addible_of_Queen(x, y)) {
                        System.out.print("x ");
                    } else {
                        System.out.print(". ");
                    }
                }
            else {
                int i = 0;
                for (; i < pos; i++)
                    System.out.print("x ");
                System.out.print("Q ");
                for (i = i + 1; i < msize; i++)
                    System.out.print("x ");
            }
            System.out.println();

        }
    }

}