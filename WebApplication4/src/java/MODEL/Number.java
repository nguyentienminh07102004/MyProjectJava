package MODEL;
import java.util.Random;

public class Number {
    private static int random(int min, int max){
        Random r = new Random();
        return r.nextInt(max) + min;
    }
    private static String transform(String s){
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '0'){
            i++;
        }
        sb.substring(i);
        return sb.toString();
    }
    public static int compareTwoBigNumber(String AInumber, String userNumber){
        userNumber = transform(userNumber);
        AInumber = transform(AInumber);
        if(userNumber.length() != AInumber.length()){
            return AInumber.length() - userNumber.length();
        }
        for(int i = 0; i < AInumber.length(); i++){
            if(AInumber.charAt(i) != userNumber.charAt(i)){
                return AInumber.charAt(i) - userNumber.charAt(i);
            }
        }
        return 0;
    }
    private static boolean checkGiaTri(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '0'){
                return false;
            }
        }
        return true;
    }
    public static String genderRandomNumber(int n){
        String res = "";
        for(int i = 0; i < n; i++){
            res += random(0, 9);
        }
        if(checkGiaTri(res) == false){
            StringBuilder sb = new StringBuilder(res);
            sb.setCharAt(0, '0');
            res = sb.toString();
        }
        return res;
    }
}
