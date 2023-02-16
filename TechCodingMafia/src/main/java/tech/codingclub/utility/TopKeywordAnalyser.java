package tech.codingclub.utility;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class TopKeywordAnalyser implements Runnable{
    private final String filePath;
    public TopKeywordAnalyser(String filepath)
    {
        this.filePath=filepath;
    }
    public void run()
    {
        ArrayList<String> keywordsFileData = new ArrayList<String>();
        keywordsFileData=fileutility.readFileAsList(filePath);
        HashMap<String,Integer> keywordCouter = new HashMap<String,Integer>();
        // reading every row
        for(String row:keywordsFileData)
        {
            String[] keywords= row.split(" ");
            // withing each row , process each keyword
            for(String keyword:keywords)
            {
               String str=keyword.toLowerCase();
               // if not there in hashmap , put it in the hashmap
               if(!keywordCouter.containsKey(str))
               {
                   keywordCouter.put(str,1);
               }
               else
               {
                   // else get the previous value of this str
                   // increment it now
                   Integer value = keywordCouter.get(str);
                   keywordCouter.put(str,value+1);
               }
            }
        }

        ArrayList<KeywordCount> keywordCountArrayList = new ArrayList<KeywordCount>();

        for(String keyword : keywordCouter.keySet())
        {
            KeywordCount keywordcount=new KeywordCount(keyword,keywordCouter.get(keyword));
            keywordCountArrayList.add(keywordcount);
        }

        Collections.sort(keywordCountArrayList, new Comparator<KeywordCount>() {

            public int compare(KeywordCount o1, KeywordCount o2) {
                if(o2.count==o1.count)
                {
                    return o1.keyword.compareTo(o2.keyword);
                }
                return o2.count-o1.count;
            }
        });

//        int i=0;
        for(KeywordCount keywordCount:keywordCountArrayList)
        {
//            System.out.println(keywordCount.keyword+" : "+keywordCount.count);
//            if(i==9)
//            {
//                break;
//            }
//            i++;
        }
        String json= new Gson().toJson(keywordCountArrayList);
        System.out.println(json);
        String convertJson = "{\"keyword\":\"Hello Gson\",\"count\":100}";
        KeywordCount keywordCount = new Gson().fromJson(convertJson,KeywordCount.class);
        System.out.println("Converted to Object "+keywordCount.keyword+" : "+keywordCount.count);

        String convertJsonArray="[ {'keyword':'Hello Gson' , 'count':1},{'keyword':'Last One','count':100}]";

        ArrayList<KeywordCount> convertedArrayList = new Gson().fromJson(convertJsonArray,new TypeToken<ArrayList<KeywordCount>>(){}.getType());
        System.out.println("ArrayList from Json");
        for (KeywordCount keywordcountTemp : convertedArrayList)
        {
            System.out.println(keywordcountTemp.keyword+" : "+keywordcountTemp.count);
        }
    }

    public static void main(String[] args)
    {
        TaskManager taskManager = new TaskManager(1);
        taskManager.waitTillQueueIsFreeAndAddTask(new TopKeywordAnalyser("C:\\Users\\User\\IdeaProjects\\Tech.CodingClub\\src\\main\\java\\Tech\\CodingClub\\utility\\IndianNationalAnthem.txt"));
    }

}
