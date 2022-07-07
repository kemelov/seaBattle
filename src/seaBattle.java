import java.util.ArrayList;
import java.util.Scanner;

public class seaBattle {

    public Scanner Enter = new Scanner(System.in);
    public String Scanner, parts = "", bl = "", point = "", wInput = "Неправильный ввод. Нужно ввести координаты: лат. буквы ABCDE и цифры от 1 до 5, н-р, B3, A1, C5.";
    public String[][] bf = new String[6][6];
    public int boat = 3, ship = 2, part = 1, attempts = 20, pScore = 7;


    public seaBattle() {
        bf[0][0] = " "; bf[0][1] = "A"; bf[0][2] = "B"; bf[0][3] = "C"; bf[0][4] = "D"; bf[0][5] = "E";
        bf[1][0] = "1"; bf[1][1] = "□"; bf[1][2] = "□"; bf[1][3] = "□"; bf[1][4] = "□"; bf[1][5] = "□";
        bf[2][0] = "2"; bf[2][1] = "□"; bf[2][2] = "□"; bf[2][3] = "□"; bf[2][4] = "□"; bf[2][5] = "□";
        bf[3][0] = "3"; bf[3][1] = "□"; bf[3][2] = "□"; bf[3][3] = "□"; bf[3][4] = "□"; bf[3][5] = "□";
        bf[4][0] = "4"; bf[4][1] = "□"; bf[4][2] = "□"; bf[4][3] = "□"; bf[4][4] = "□"; bf[4][5] = "□";
        bf[5][0] = "5"; bf[5][1] = "□"; bf[5][2] = "□"; bf[5][3] = "□"; bf[5][4] = "□"; bf[5][5] = "□";
        Start();
    }
    public void Start() {
        System.out.println("                  .  ;  ; .                             \n" +
                "                   '  .. '                              \n" +
                "     _|_          =- {  } -=       _|_                  \n" +
                "    ``|`           .  \"\" .         `|``                 \n" +
                "   ```|``         '  ;  ; '       ``|```                \n" +
                "   `__!__    )'             '(    __!__`                \n" +
                "   :     := },;             ;,{ =:     :                \n" +
                "   '.   .'                       '.   .'                \n" +
                " ~-=~~-=~~-=~~-=~~-=~~-=~~-=~~-=~~-=~~-=~~    ");
        System.out.println(
                "Добро пожаловать в 'Морской бой'!" + "\n" + "О том, как играть:" + "\n" +
                        "Сначала первый игрок расставляет по порядку корабли разного размера - " +
                        "3 одинарных(лодки '■'), 2 двойных(корабли '■■')."+"\n"+
                        "Для того, чтобы установить корабли - нужно ввести координаты: лат. буквы ABCDE и цифры от 1 до 5, н-р, B3, A1, C5." + "\n" +
                        "После ввода искомая клетка закрасится в '■', а смежные с ней в '☓'. " +
                        "Это означает, что нельзя задать эти клетки для установки корабля." + "\n" +
                        "Далее ходит второй игрок, который должен угадать за 20 ходов в каких клетках могут находиться корабли, вводя координаты." + "\n" +
                        "" + "\n" + "Чтобы начать игру, нажмите любую клавишу.");



        Scanner = Enter.nextLine();
        showcase();
    }

    public void showcase() {
        for (String[] i:bf){
            for (String j:i) {
                System.out.print(j);
            }
            System.out.println();
        }
        player1();
    }

    private void check1() {
        switch (Scanner) {
            case "A1": bf[1][1] = "■"; bf[1][2] = "☓"; bf[2][1] = "☓"; bl = bl + "A1"+"A2"+"B1"; break;
            case "A2": bf[2][1] = "■"; bf[1][1] = "☓"; bf[3][1] = "☓"; bf[2][2] = "☓"; bl = bl + "A1"+"A2"+"A3"+"B2"; break;
            case "A3": bf[3][1] = "■"; bf[2][1] = "☓"; bf[3][2] = "☓"; bf[4][1] = "☓"; bl = bl + "A3"+"A2"+"A4"+"B3"; break;
            case "A4": bf[4][1] = "■"; bf[3][1] = "☓"; bf[5][1] = "☓"; bf[4][2] = "☓"; bl = bl + "A4"+"A3"+"A5"+"B4"; break;
            case "A5": bf[5][1] = "■"; bf[4][1] = "☓"; bf[5][2] = "☓"; bl = bl + "A5"+"A4"+"B5"; break;

            case "B1": bf[1][2] = "■"; bf[2][2] = "☓"; bf[1][1] = "☓"; bf[1][3] = "☓"; bl = bl + "B1"+"B2"+"A1"+"C1"; break;
            case "B2": bf[2][2] = "■"; bf[1][2] = "☓"; bf[2][1] = "☓"; bf[3][2] = "☓"; bf[2][3] = "☓"; bl = bl + "B2"+"B1"+"A2"+"B3"+"C2"; break;
            case "B3": bf[3][2] = "■"; bf[2][2] = "☓"; bf[3][1] = "☓"; bf[4][2] = "☓"; bf[3][3] = "☓"; bl = bl + "B3"+"B2"+"A3"+"B4"+"C3"; break;
            case "B4": bf[4][2] = "■"; bf[3][2] = "☓"; bf[4][1] = "☓"; bf[5][2] = "☓"; bf[4][3] = "☓"; bl = bl + "B4"+"B3"+"A4"+"B5"+"C4"; break;
            case "B5": bf[5][2] = "■"; bf[4][2] = "☓"; bf[5][1] = "☓"; bf[5][3] = "☓"; bl = bl + "B5"+"B4"+"A5"+"C5"; break;

            case "C1": bf[1][3] = "■"; bf[1][2] = "☓"; bf[2][3] = "☓"; bf[1][4] = "☓"; bl = bl + "C1"+"B1"+"C2"+"D1"; break;
            case "C2": bf[2][3] = "■"; bf[2][2] = "☓"; bf[1][3] = "☓"; bf[3][3] = "☓"; bf[2][4] = "☓"; bl = bl + "C2"+"B2"+"C1"+"C3"+"D2"; break;
            case "C3": bf[3][3] = "■"; bf[3][2] = "☓"; bf[2][3] = "☓"; bf[4][3] = "☓"; bf[3][4] = "☓"; bl = bl + "C3"+"B3"+"C2"+"C4"+"D3"; break;
            case "C4": bf[4][3] = "■"; bf[4][2] = "☓"; bf[3][3] = "☓"; bf[5][3] = "☓"; bf[4][4] = "☓"; bl = bl + "C4"+"B4"+"C3"+"C5"+"D4"; break;
            case "C5": bf[5][3] = "■"; bf[5][2] = "☓"; bf[4][3] = "☓"; bf[5][4] = "☓"; bl = bl + "C5"+"B5"+"C4"+"D5"; break;

            case "D1": bf[1][4] = "■"; bf[1][3] = "☓"; bf[2][4] = "☓"; bf[1][5] = "☓"; bl = bl + "D1"+"C1"+"D2"+"E1"; break;
            case "D2": bf[2][4] = "■"; bf[2][3] = "☓"; bf[1][4] = "☓"; bf[3][4] = "☓"; bf[2][5] = "☓"; bl = bl + "D2"+"C2"+"D1"+"D3"+"E2"; break;
            case "D3": bf[3][4] = "■"; bf[3][3] = "☓"; bf[2][4] = "☓"; bf[4][4] = "☓"; bf[3][5] = "☓"; bl = bl + "D3"+"C3"+"D2"+"D4"+"E3"; break;
            case "D4": bf[4][4] = "■"; bf[4][3] = "☓"; bf[3][4] = "☓"; bf[5][4] = "☓"; bf[4][5] = "☓"; bl = bl + "D4"+"C4"+"D3"+"D5"+"E4"; break;
            case "D5": bf[5][4] = "■"; bf[5][3] = "☓"; bf[4][4] = "☓"; bf[5][5] = "☓"; bl = bl + "D5"+"C5"+"D4"+"E5"; break;

            case "E1": bf[1][5] = "■"; bf[2][5] = "☓"; bf[1][4] = "☓"; bl = bl + "E1"+"E2"+"D1"; break;
            case "E2": bf[2][5] = "■"; bf[1][5] = "☓"; bf[2][4] = "☓"; bf[3][5] = "☓"; bl = bl + "E2"+"E1"+"E3"+"D2"; break;
            case "E3": bf[3][5] = "■"; bf[2][5] = "☓"; bf[3][4] = "☓"; bf[4][5] = "☓"; bl = bl + "E3"+"E2"+"E4"+"D3"; break;
            case "E4": bf[4][5] = "■"; bf[3][5] = "☓"; bf[4][4] = "☓"; bf[5][5] = "☓"; bl = bl + "E4"+"E3"+"E5"+"D4"; break;
            case "E5": bf[5][5] = "■"; bf[4][5] = "☓"; bf[5][4] = "☓"; bl = bl + "E5"+"E4"+"D5"; break;

            default:
                System.out.println(wInput);
                player1();
        }
        for (String[] i:bf){
            for (String j:i) {
                System.out.print(j);
            }
            System.out.println();
        }
        boat = boat-1;
        point = point + Scanner;
        player1();
    }

    private void check2_1() {
        if (part == 2) {
            System.out.println(parts);
            switch (parts) {
                case "A1A2","A2A1": bf[1][1] = "■"; bf[2][1] = "■"; bf[1][2] = "☓"; bf[2][2] = "☓"; bf[3][1] = "☓"; bl = bl + "A1 A2 A3 B1 B2"; break;
                case "A2A3","A3A2": bf[2][1] = "■"; bf[3][1] = "■"; bf[1][1] = "☓"; bf[2][2] = "☓"; bf[3][2] = "☓"; bf[4][1] = "☓"; bl = bl + "A2 A3 A1 B2 B3 A4"; break;
                case "A3A4","A4A3": bf[3][1] = "■"; bf[4][1] = "■"; bf[2][1] = "☓"; bf[3][2] = "☓"; bf[4][2] = "☓"; bf[5][1] = "☓"; bl = bl + "A3 A4 A2 B3 B4 A5"; break;
                case "A4A5","A5A4": bf[4][1] = "■"; bf[5][1] = "■"; bf[3][1] = "☓"; bf[4][2] = "☓"; bf[5][2] = "☓"; bl = bl + "A4 A5 A3 B4 B5"; break;

                case "A1B1","B1A1": bf[1][1] = "■"; bf[1][2] = "■"; bf[2][1] = "☓"; bf[2][2] = "☓"; bf[1][3] = "☓"; bl = bl + "A1 B1 A2 B2 C1"; break;
                case "A2B2","B2A2": bf[2][1] = "■"; bf[2][2] = "■"; bf[1][1] = "☓"; bf[1][2] = "☓"; bf[3][1] = "☓"; bf[3][2] = "☓"; bf[2][3] = "☓"; bl = bl + "A2 B2 A1 B1 A3 B3 C2"; break;
                case "A3B3","B3A3": bf[3][1] = "■"; bf[3][2] = "■"; bf[2][1] = "☓"; bf[2][2] = "☓"; bf[4][1] = "☓"; bf[4][2] = "☓"; bf[3][3] = "☓"; bl = bl + "A3 B3 A2 B2 A4 B4 C3"; break;
                case "A4B4","B4A4": bf[4][1] = "■"; bf[4][2] = "■"; bf[3][1] = "☓"; bf[3][2] = "☓"; bf[5][1] = "☓"; bf[5][2] = "☓"; bf[4][3] = "☓"; bl = bl + "A4 B4 A3 B3 A5 B5 C4"; break;
                case "A5B5","B5A5": bf[5][1] = "■"; bf[5][2] = "■"; bf[4][1] = "☓"; bf[4][2] = "☓"; bf[5][3] = "☓"; bl = bl + "A5 B5 A4 B4 C5"; break;

                case "B1B2","B2B1": bf[1][2] = "■"; bf[2][2] = "■"; bf[1][1] = "☓"; bf[2][1] = "☓"; bf[3][2] = "☓"; bf[1][3] = "☓"; bf[2][3] = "☓"; bl = bl + "B1 B2 B3 A1 A2 C1 C2"; break;
                case "B2B3","B3B2": bf[2][2] = "■"; bf[3][2] = "■"; bf[2][1] = "☓"; bf[3][1] = "☓"; bf[1][2] = "☓"; bf[4][2] = "☓"; bf[2][3] = "☓"; bf[3][3] = "☓"; bl = bl + "B2 B3 B4 A2 A3 C2 C3"; break;
                case "B3B4","B4B3": bf[3][2] = "■"; bf[4][2] = "■"; bf[3][1] = "☓"; bf[4][1] = "☓"; bf[2][2] = "☓"; bf[5][2] = "☓"; bf[3][3] = "☓"; bf[4][3] = "☓"; bl = bl + "B3 B4 B5 A3 A4 C3 C4"; break;
                case "B4B5","B5B4": bf[4][2] = "■"; bf[5][2] = "■"; bf[4][1] = "☓"; bf[5][1] = "☓"; bf[3][2] = "☓"; bf[4][3] = "☓"; bf[5][3] = "☓"; bl = bl + "B4 B5 B3 A4 A5 C4 C5"; break;

                case "B1C1","C1B1": bf[1][2] = "■"; bf[1][3] = "■"; bf[1][1] = "☓"; bf[2][2] = "☓"; bf[2][3] = "☓"; bf[1][4] = "☓"; bl = bl + "B1 C1 B2 C2 A1 D1"; break;
                case "B2C2","C2B2": bf[2][2] = "■"; bf[2][3] = "■"; bf[2][1] = "☓"; bf[1][2] = "☓"; bf[1][3] = "☓"; bf[3][2] = "☓"; bf[3][3] = "☓"; bf[2][4] = "☓"; bl = bl + "B2 C2 B1 C1 B3 C3 A2 D2"; break;
                case "B3C3","C3B3": bf[3][2] = "■"; bf[3][3] = "■"; bf[3][1] = "☓"; bf[2][2] = "☓"; bf[2][3] = "☓"; bf[4][2] = "☓"; bf[4][3] = "☓"; bf[3][4] = "☓"; bl = bl + "B3 C3 B2 C2 B4 C4 A3 D3"; break;
                case "B4C4","C4B4": bf[4][2] = "■"; bf[4][3] = "■"; bf[4][1] = "☓"; bf[3][2] = "☓"; bf[3][3] = "☓"; bf[5][2] = "☓"; bf[5][3] = "☓"; bf[4][4] = "☓"; bl = bl + "B4 C4 B3 C3 B5 C5 A4 D4"; break;
                case "B5C5","C5B5": bf[5][2] = "■"; bf[5][3] = "■"; bf[5][1] = "☓"; bf[4][2] = "☓"; bf[4][3] = "☓"; bf[5][4] = "☓"; bl = bl + "B5 C5 B4 C4 A5 D5"; break;

                case "C1C2","C2C1": bf[1][3] = "■"; bf[2][3] = "■"; bf[1][2] = "☓"; bf[2][2] = "☓"; bf[3][3] = "☓"; bf[1][4] = "☓"; bf[2][4] = "☓"; bl = bl + "C1 C2 C3 B1 B2 D1 D2"; break;
                case "C2C3","C3C2": bf[2][3] = "■"; bf[3][3] = "■"; bf[2][2] = "☓"; bf[3][2] = "☓"; bf[1][3] = "☓"; bf[4][3] = "☓"; bf[2][4] = "☓"; bf[3][4] = "☓"; bl = bl + "C2 C3 C4 B2 B3 D2 D3"; break;
                case "C3C4","C4C3": bf[3][3] = "■"; bf[4][3] = "■"; bf[3][2] = "☓"; bf[4][2] = "☓"; bf[2][3] = "☓"; bf[5][3] = "☓"; bf[3][4] = "☓"; bf[4][4] = "☓"; bl = bl + "C3 C4 C5 B3 B4 D3 D4"; break;
                case "C4C5","C5C4": bf[4][3] = "■"; bf[5][3] = "■"; bf[4][2] = "☓"; bf[5][2] = "☓"; bf[3][3] = "☓"; bf[4][4] = "☓"; bf[5][4] = "☓"; bl = bl + "C4 C5 C3 B4 B5 D4 D5"; break;

                case "C1D1","D1C1": bf[1][3] = "■"; bf[1][4] = "■"; bf[1][2] = "☓"; bf[2][3] = "☓"; bf[2][4] = "☓"; bf[1][5] = "☓"; bl = bl + "C1 D1 C2 D2 B1 E1"; break;
                case "C2D2","D2C2": bf[2][3] = "■"; bf[2][4] = "■"; bf[2][2] = "☓"; bf[1][3] = "☓"; bf[1][4] = "☓"; bf[3][3] = "☓"; bf[3][4] = "☓"; bf[2][5] = "☓"; bl = bl + "C2 D2 C1 D1 C3 D3 B2 E2"; break;
                case "C3D3","D3C3": bf[3][3] = "■"; bf[3][4] = "■"; bf[3][2] = "☓"; bf[2][3] = "☓"; bf[2][4] = "☓"; bf[4][3] = "☓"; bf[4][4] = "☓"; bf[3][5] = "☓"; bl = bl + "C3 D3 C2 D2 C4 D4 B3 E3"; break;
                case "C4D4","D4C4": bf[4][3] = "■"; bf[4][4] = "■"; bf[4][2] = "☓"; bf[3][3] = "☓"; bf[3][4] = "☓"; bf[5][3] = "☓"; bf[5][4] = "☓"; bf[4][5] = "☓"; bl = bl + "C4 D4 C3 D3 C5 D5 B4 E4"; break;
                case "C5D5","D5C5": bf[5][3] = "■"; bf[5][4] = "■"; bf[5][2] = "☓"; bf[4][3] = "☓"; bf[4][4] = "☓"; bf[5][5] = "☓"; bl = bl + "C5 D5 C4 D4 B5 E5"; break;

                case "D1D2","D2D1": bf[1][4] = "■"; bf[2][4] = "■"; bf[1][3] = "☓"; bf[2][3] = "☓"; bf[3][4] = "☓"; bf[1][5] = "☓"; bf[2][5] = "☓"; bl = bl + "D1 D2 D3 C1 C2 E1 E2"; break;
                case "D2D3","D3D2": bf[2][4] = "■"; bf[3][4] = "■"; bf[2][3] = "☓"; bf[3][3] = "☓"; bf[1][4] = "☓"; bf[4][4] = "☓"; bf[2][5] = "☓"; bf[3][5] = "☓"; bl = bl + "D2 D3 D4 C2 C3 E2 E3"; break;
                case "D3D4","D4D3": bf[3][4] = "■"; bf[4][4] = "■"; bf[3][3] = "☓"; bf[4][3] = "☓"; bf[2][4] = "☓"; bf[5][4] = "☓"; bf[3][5] = "☓"; bf[4][5] = "☓"; bl = bl + "D3 D4 D5 C3 C4 E3 E4"; break;
                case "D4D5","D5D4": bf[4][4] = "■"; bf[5][4] = "■"; bf[4][3] = "☓"; bf[5][3] = "☓"; bf[3][4] = "☓"; bf[4][5] = "☓"; bf[5][5] = "☓"; bl = bl + "D4 D5 D3 C4 C5 E4 E5"; break;

                case "D1E1","E1D1": bf[1][4] = "■"; bf[1][5] = "■"; bf[2][4] = "☓"; bf[2][5] = "☓"; bf[1][3] = "☓"; bl = bl + "D1 E1 D2 E2 C1"; break;
                case "D2E2","E2D2": bf[2][4] = "■"; bf[2][5] = "■"; bf[1][4] = "☓"; bf[1][5] = "☓"; bf[3][4] = "☓"; bf[3][5] = "☓"; bf[2][3] = "☓"; bl = bl + "D2 C2 D1 C1 D3 C3 C2"; break;
                case "D3E3","E3D3": bf[3][4] = "■"; bf[3][5] = "■"; bf[2][4] = "☓"; bf[2][5] = "☓"; bf[4][4] = "☓"; bf[4][5] = "☓"; bf[3][3] = "☓"; bl = bl + "D3 C3 D2 C2 D4 C4 C3"; break;
                case "D4E4","E4D4": bf[4][4] = "■"; bf[4][5] = "■"; bf[3][4] = "☓"; bf[3][5] = "☓"; bf[5][4] = "☓"; bf[5][5] = "☓"; bf[4][3] = "☓"; bl = bl + "D4 C4 D3 C3 D5 C5 C4"; break;
                case "D5E5","E5D5": bf[5][4] = "■"; bf[5][5] = "■"; bf[4][4] = "☓"; bf[4][5] = "☓"; bf[5][3] = "☓"; bl = bl + "D5 E5 D4 E4 C5"; break;

                case "E1E2","E2E1": bf[1][5] = "■"; bf[2][5] = "■"; bf[1][4] = "☓"; bf[2][4] = "☓"; bf[3][5] = "☓"; bl = bl + "E1 E2 E3 D1 D2"; break;
                case "E2E3","E3E2": bf[2][5] = "■"; bf[3][5] = "■"; bf[2][4] = "☓"; bf[3][4] = "☓"; bf[4][5] = "☓"; bf[1][5] = "☓"; bl = bl + "E2 E3 E1 D2 D3 E4"; break;
                case "E3E4","E4E3": bf[3][5] = "■"; bf[4][5] = "■"; bf[3][4] = "☓"; bf[4][4] = "☓"; bf[5][5] = "☓"; bf[2][5] = "☓"; bl = bl + "E3 E4 E2 D3 D4 E5"; break;
                case "E4E5","E5E4": bf[4][5] = "■"; bf[5][5] = "■"; bf[4][4] = "☓"; bf[5][4] = "☓"; bf[3][5] = "☓"; bl = bl + "E4 E5 E3 D4 D5"; break;


                default: System.out.println("Неправильный ввод! Выберите смежные клетки (A1+A2 или C4+B4)."); part = 1; parts = ""; player1();
            }
            for (String[] i:bf){
                for (String j:i) {
                    System.out.print(j);
                }
                System.out.println();
            }

            part = part + 1;
            player1();
        }
        part = part + 1;
        player1();
    }



    public void player1(){
        if (boat != 0){
            System.out.println("\n"+"Ход первого игрока. Установите "+boat+" лодки(■).");
            Scanner = Enter.nextLine();
            if (bl.contains(Scanner)) {
                System.out.println("Нельзя выбрать эту клетку. Выберите другую.");
                player1();
            } else {
                check1();
            }
        } else {
            if (ship != 0) {
                while (part != 3){
                    System.out.println("\n"+"Установите "+ship+" корабли(■■)."+"\n"+"часть "+ part);
                    Scanner = Enter.nextLine();
                    while (!bl.contains(Scanner) && !parts.contains(Scanner)){
                        parts = parts + Scanner;
                        if (parts.contains("0")){
                            parts = ""; part = 1; player1();
                        } else {
                            check2_1();
                        }
                    }
                    for (String[] i:bf){
                        for (String j:i) {
                            System.out.print(j);
                        }
                        System.out.println();
                    }
                    System.out.println("Нельзя выбрать эту клетку. Выберите другую. (Чтобы начать заново - нажмите '0')");
                    player1();
                }
                point = point + parts;
                bl = bl + parts;
                parts = "";
                part = 1;
                ship = ship - 1;
                player1();
            }
            clear();
        }
    }



    public void player2(){
        for (String[] i:bf){
            for (String j:i) {
                System.out.print(j);
            }
            System.out.println();
        }
        if (attempts == 0){
            System.out.println("Попыток не осталось!"+"\n"+"Победил игрок 1"); end();
        }
        if (pScore == 0){
            System.out.println("Все корабли уничтожены!"+"\n"+"Победил игрок 2"); end();
        }
        System.out.println("\n"+"Ход второго игрока. Найдите корабли ("+attempts+" попыток)");
        Scanner = Enter.nextLine();
        while (!bl.contains(Scanner)){
            if (point.contains(Scanner)){
                switch (Scanner) {
                    case "A1": bf[1][1] = "■"; break; case "B1": bf[1][2] = "■"; break; case "C1": bf[1][3] = "■"; break; case "D1": bf[1][4] = "■"; break; case "E1": bf[1][5] = "■"; break;
                    case "A2": bf[2][1] = "■"; break; case "B2": bf[2][2] = "■"; break; case "C2": bf[2][3] = "■"; break; case "D2": bf[2][4] = "■"; break; case "E2": bf[2][5] = "■"; break;
                    case "A3": bf[3][1] = "■"; break; case "B3": bf[3][2] = "■"; break; case "C3": bf[3][3] = "■"; break; case "D3": bf[3][4] = "■"; break; case "E3": bf[3][5] = "■"; break;
                    case "A4": bf[4][1] = "■"; break; case "B4": bf[4][2] = "■"; break; case "C4": bf[4][3] = "■"; break; case "D4": bf[4][4] = "■"; break; case "E4": bf[4][5] = "■"; break;
                    case "A5": bf[5][1] = "■"; break; case "B5": bf[5][2] = "■"; break; case "C5": bf[5][3] = "■"; break; case "D5": bf[5][4] = "■"; break; case "E5": bf[5][5] = "■"; break;
                    default: System.out.println(wInput); player2();
                }
                pScore = pScore - 1;
                bl = bl+Scanner;
                attempts = attempts - 1;
                player2();
            } else {
                switch (Scanner) {
                    case "A1": bf[1][1] = "☓"; break; case "B1": bf[1][2] = "☓"; break; case "C1": bf[1][3] = "☓"; break; case "D1": bf[1][4] = "☓"; break; case "E1": bf[1][5] = "☓"; break;
                    case "A2": bf[2][1] = "☓"; break; case "B2": bf[2][2] = "☓"; break; case "C2": bf[2][3] = "☓"; break; case "D2": bf[2][4] = "☓"; break; case "E2": bf[2][5] = "☓"; break;
                    case "A3": bf[3][1] = "☓"; break; case "B3": bf[3][2] = "☓"; break; case "C3": bf[3][3] = "☓"; break; case "D3": bf[3][4] = "☓"; break; case "E3": bf[3][5] = "☓"; break;
                    case "A4": bf[4][1] = "☓"; break; case "B4": bf[4][2] = "☓"; break; case "C4": bf[4][3] = "☓"; break; case "D4": bf[4][4] = "☓"; break; case "E4": bf[4][5] = "☓"; break;
                    case "A5": bf[5][1] = "☓"; break; case "B5": bf[5][2] = "☓"; break; case "C5": bf[5][3] = "☓"; break; case "D5": bf[5][4] = "☓"; break; case "E5": bf[5][5] = "☓"; break;
                    default: System.out.println(wInput); player2();
                }
            }
            bl = bl+Scanner;
            attempts = attempts - 1;player2();
        }
        System.out.println("Вы уже атаковали эту клетку!");
        player2();
    }

    public void end(){
        System.out.println("Игра окончена. Чтобы начать заново, нажмите любую кнопку:");
        Scanner = Enter.nextLine();
        Start();
    }



    public void clear(){
        bf[1][1] = "□"; bf[1][2] = "□"; bf[1][3] = "□"; bf[1][4] = "□"; bf[1][5] = "□";
        bf[2][1] = "□"; bf[2][2] = "□"; bf[2][3] = "□"; bf[2][4] = "□"; bf[2][5] = "□";
        bf[3][1] = "□"; bf[3][2] = "□"; bf[3][3] = "□"; bf[3][4] = "□"; bf[3][5] = "□";
        bf[4][1] = "□"; bf[4][2] = "□"; bf[4][3] = "□"; bf[4][4] = "□"; bf[4][5] = "□";
        bf[5][1] = "□"; bf[5][2] = "□"; bf[5][3] = "□"; bf[5][4] = "□"; bf[5][5] = "□";
        bl = "";

        if (ship == 0) {
            System.out.println("\n" +
                    "                             __xxxxxxxxxxxxxxxx___.\n" +
                    "                        _gxXXXXXXXXXXXXXXXXXXXXXXXX!x_\n" +
                    "                   __x!XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!x_\n" +
                    "                ,gXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx_\n" +
                    "              ,gXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!_\n" +
                    "            _!XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!.\n" +
                    "          gXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXs\n" +
                    "        ,!XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!.\n" +
                    "       g!XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "      iXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "     ,XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx\n" +
                    "     !XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx\n" +
                    "   ,XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx\n" +
                    "   !XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXi\n" +
                    "  dXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "  !XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "   XXXXXXXXXXXXXXXXXXXf~~~VXXXXXXXXXXXXXXXXXXXXXXXXXXvvvvvvvvXXXXXXXXXXXXXX!\n" +
                    "   !XXXXXXXXXXXXXXXf`       'XXXXXXXXXXXXXXXXXXXXXf`          '~XXXXXXXXXXP\n" +
                    "    vXXXXXXXXXXXX!            !XXXXXXXXXXXXXXXXXX!              !XXXXXXXXX\n" +
                    "     XXXXXXXXXXv`              'VXXXXXXXXXXXXXXX                !XXXXXXXX!\n" +
                    "     !XXXXXXXXX.                 YXXXXXXXXXXXXX!                XXXXXXXXX\n" +
                    "      XXXXXXXXX!                 ,XXXXXXXXXXXXXX                VXXXXXXX!\n" +
                    "      'XXXXXXXX!                ,!XXXX ~~XXXXXXX               iXXXXXX~\n" +
                    "       'XXXXXXXX               ,XXXXXX   XXXXXXXX!             xXXXXXX!\n" +
                    "        !XXXXXXX!xxxxxxs______xXXXXXXX   'YXXXXXX!          ,xXXXXXXXX\n" +
                    "         YXXXXXXXXXXXXXXXXXXXXXXXXXXX`    VXXXXXXX!s. __gxx!XXXXXXXXXP\n" +
                    "          XXXXXXXXXXXXXXXXXXXXXXXXXX!      'XXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "          XXXXXXXXXXXXXXXXXXXXXXXXXP        'YXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "          XXXXXXXXXXXXXXXXXXXXXXXX!     i    !XXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "          XXXXXXXXXXXXXXXXXXXXXXXX!     XX   !XXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "          XXXXXXXXXXXXXXXXXXXXXXXXx_   iXX_,_dXXXXXXXXXXXXXXXXXXXXXXXX\n" +
                    "          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXP\n" +
                    "          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "           ~vXvvvvXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXf\n" +
                    "                    'VXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXvvvvvv~\n" +
                    "                      'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX~\n" +
                    "                  _    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXv`\n" +
                    "                 -XX!  !XXXXXXX~XXXXXXXXXXXXXXXXXXXXXX~   Xxi\n" +
                    "                  YXX  '~ XXXXX XXXXXXXXXXXXXXXXXXXX`     iXX`\n" +
                    "                  !XX!    !XXX` XXXXXXXXXXXXXXXXXXXX      !XX\n" +
                    "                  !XXX    '~Vf  YXXXXXXXXXXXXXP YXXX     !XXX\n" +
                    "                  !XXX  ,_      !XXP YXXXfXXXX!  XXX     XXXV\n" +
                    "                  !XXX !XX           'XXP 'YXX!       ,.!XXX!\n" +
                    "                  !XXXi!XP  XX.                  ,_  !XXXXXX!\n" +
                    "                  iXXXx X!  XX! !Xx.  ,.     xs.,XXi !XXXXXXf\n" +
                    "                   XXXXXXXXXXXXXXXXX! _!XXx  dXXXXXXX.iXXXXXX\n" +
                    "                   VXXXXXXXXXXXXXXXXXXXXXXXxxXXXXXXXXXXXXXXX!\n" +
                    "                   YXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXV\n" +
                    "                    'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!\n" +
                    "                    'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXf\n" +
                    "                       VXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXf\n" +
                    "                         VXXXXXXXXXXXXXXXXXXXXXXXXXXXXv`\n" +
                    "                          ~vXXXXXXXXXXXXXXXXXXXXXXXf`\n" +
                    "                              ~vXXXXXXXXXXXXXXXXv~\n" +
                    "                                 '~VvXXXXXXXV~~\n" +
                    "                                       ~~\n");
            System.out.println("\n" +
                    "      ███╗░░██╗███████╗  ░██████╗███╗░░░███╗░█████╗░████████╗██████╗░██╗\n" +
                    "      ████╗░██║██╔════╝  ██╔════╝████╗░████║██╔══██╗╚══██╔══╝██╔══██╗██║\n" +
                    "      ██╔██╗██║█████╗░░  ╚█████╗░██╔████╔██║██║░░██║░░░██║░░░██████╔╝██║\n" +
                    "      ██║╚████║██╔══╝░░  ░╚═══██╗██║╚██╔╝██║██║░░██║░░░██║░░░██╔══██╗██║\n" +
                    "      ██║░╚███║███████╗  ██████╔╝██║░╚═╝░██║╚█████╔╝░░░██║░░░██║░░██║██║\n" +
                    "      ╚═╝░░╚══╝╚══════╝  ╚═════╝░╚═╝░░░░░╚═╝░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═╝");
            ship = 2; part = 1;boat = 3;
            player2();
        } else if (attempts == 0 || pScore == 0){
            attempts = 20; pScore = 7; point = "";
            Start();
        }
    }
}