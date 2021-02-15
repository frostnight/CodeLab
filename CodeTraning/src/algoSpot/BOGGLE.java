package algoSpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOGGLE {

    static String[][] BOARD = new String[5][5];
    static int WORD_COUNT;
    static String[] WORD = null;
    static int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};

    public static void main(String[] args){
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            int testCase = Integer.parseInt(br.readLine());

            for(int i=0; i < testCase; i++){
                saveInputValue(br);
                for(int j=0; j < WORD_COUNT; j++) {

                    int x = 0;
                    int y = 0;
                    System.out.println("word:"+WORD[j]);
                    for(int direction = 0; direction < 8; direction++) {
                        int nextY = y + dy[direction];
                        int nextX = x + dx[direction];
                        if(hasWord(nextY, nextX, WORD[j])){
                            System.out.println(WORD[j]+" "+"YES");
                            break;
                        } else {
                            System.out.println(WORD[j]+" "+"No");
                        }
                    }
                }
            }

        } catch(IOException ex){
            ex.printStackTrace();
        } finally {
            try { br.close(); } catch (IOException e2){ }
        }
    }

    public static void saveInputValue(BufferedReader br){
        // Test Case 받기
        try {
            for(int i = 0; i < BOARD.length; i++) {
                BOARD[i]  = br.readLine().split("");
            }
            // 단어 수
            WORD_COUNT = Integer.parseInt(br.readLine());
            WORD = new String[WORD_COUNT];
            // 단어들 입력
            for(int i=0; i < WORD_COUNT; i++) {
                WORD[i] = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1. 위치(y, x)에 단어의 첫 글자가 아닌 경우 false
    static boolean hasWord(int y, int x, String word){

        // 기저 사례1: 시작위치가 보드 밖
        if(!inRange(y, x)) {
            System.out.println("range out");
            return false;
        }
        System.out.println("y:"+y);
        System.out.println("x:"+x);
        System.out.println("word.substring(0,1):"+word.substring(0, 1));
        System.out.println("BOARD[y][x]:"+BOARD[y][x]);
        // 기저 사례2: 첫글자가 다름
        if(!BOARD[y][x].equals(word.substring(0, 1))) {
            System.out.println("firstWord not same");
            return false;
        }
        // 기저 사례3: 1글자
        if(word.length() == 1) {
            System.out.println("one word");
            return true;
        }

        // 인접 여덟 칸 검사(자기자신 빼고)
        for(int direction = 0; direction < 8; direction++){
            int nextY = y + dy[direction];
            int nextX = x + dx[direction];
            System.out.println("next word:"+word.substring(1));
            // 다음칸 검사
            if(hasWord(nextY, nextX, word.substring(1))){
                return true;
            }
        }
        return false;
    }

    // 범위 밖 계산
    static boolean inRange(int y, int x){
        boolean result = false;

        try{
            String checkException = BOARD[y][x];
            result = true;
        } catch(ArrayIndexOutOfBoundsException e){
        }

        return result;
    }
}
