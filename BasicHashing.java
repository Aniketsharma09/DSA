import java.util.*;

public class BasicHashing {
    
    public static void printFrequency(String str){
        
        int map[] = new int[256];
        Arrays.fill(map, 0);

        for(char ch : str.toCharArray()){
           map[ch - 'a']++;
        }

        for(int i = 0; i < 256; i++){
            if(map[i] > 0){
                char ch = (char)(i + 'a');
                System.out.println(ch + " --> " + map[i]);
            }
        }
    }
    public static void main(String[] args){
        String str = "madam";

        printFrequency(str);
    }
}
