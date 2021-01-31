import java.util.HashMap;

public class MinimumWindowSubstring{

     public static void main(String []args){
        
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.MinWindow("",""));
     }
     
     public String MinWindow(String str, String t)
     {
         HashMap<Character,Integer> req = new HashMap<Character,Integer>();
         for(int i=0; i<t.length(); i++)
         {
             int count = req.getOrDefault(t.charAt(i), 0);
             req.put(t.charAt(i), count+1);
         }
         
         HashMap<Character,Integer> cur = new HashMap<Character,Integer>();
         
         
         return "hello";
     }
}
