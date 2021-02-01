import java.util.HashMap;

public class MinimumWindowSubstring{

     public static void main(String []args){

        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.MinWindow("azjskfztsz","szz"));
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
         int right=0;
         int left=0;
         
         int maxCharsNeeded=req.size();
         int currCharsPresent=0;
         
         int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
         String minWindow = "";
         int len = str.length();
         
         for(int i=0,j=0; i<len; i++)
         {
             char c = str.charAt(i);
             int cVal = cur.getOrDefault(c,0);
             cur.put(c, cVal+1);
             
             boolean isCharInT = req.containsKey(c);
             if(isCharInT)
             {
                 boolean isReqSatisfied = req.get(c) == cur.get(c);
                 
                 if(isReqSatisfied)
                 {
                    currCharsPresent++;
                 }
                    
             }
             
             while(maxCharsNeeded == currCharsPresent && left<=right)
             {
                 char charAtLeft = str.charAt(left);
                 int windowSize = right-left+1;
                 
                 if(windowSize<minWindowLengthSeenSoFar)
                 {
                     minWindowLengthSeenSoFar = windowSize;
                     minWindow = str.substring(left, right+1);
                 }
                 
                 cur.put(charAtLeft, cur.get(charAtLeft)-1);
                 
                 boolean iscRequired = req.containsKey(charAtLeft);
                 if(iscRequired)
                 {
                     boolean isReqFailed = cur.get(charAtLeft) < req.get(charAtLeft);
                     if(isReqFailed)
                     {
                         currCharsPresent--;
                     }
                 }
                 
                 
                 left++;
             }
             
             right++;
         }

         return minWindow;
     }
}
