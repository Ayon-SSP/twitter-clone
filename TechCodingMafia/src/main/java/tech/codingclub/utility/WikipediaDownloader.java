package tech.codingclub.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;

public class WikipediaDownloader implements Runnable{

    private String keyword;

    public WikipediaDownloader()
    {

    }

    public WikipediaDownloader(String keyword) {
        this.keyword = keyword;
    }
    public void run()
    {
        // STEP'S
        // get clean Keyword
        // get the url for wikipedia
        // make a get request to wikipedia
        // parse the useful result using jsoup
        // showing results to the user
        if(this.keyword==null || this.keyword.length()==0)
        {
            return ;
        }
        // regex expression
        // trim used to remove unwanted space at first and last of keyword
//        STEP 1
        this.keyword=this.keyword.trim().replaceAll("[ ]+","_");
//        STEP 2
        String wikiUrl=getWikipediaUrlForQuery(this.keyword);
        String imageUrl="";
        String response="";
        try
        {
//        STEP 3
            String wikipediaResponseHTML = HttpURLConnectionExample.sendGet(wikiUrl);
//            System.out.println(wikipediaResponseHTML);
//        STEP 4
            Document document = Jsoup.parse(wikipediaResponseHTML,wikiUrl);

            Elements childElements=document.body().select(".mw-parser-output > *");
            int state=0;

            for(Element childElement : childElements)
            {
                if(state==0)
                {
                    if(childElement.tagName().equals("table"))
                    {
                        state=1;
                    }
                }
                else if(state==1)
                {
                    if(childElement.tagName().equals("p"))
                    {
                        state=2;
                        response=childElement.text();
                        break;
                    }
                }
            }
            try
            {
               imageUrl=document.body().select(".infobox img").get(0).attr("src");

            }
            catch (Exception ex)
            {

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // PUSH RESULT INTO DATA BASE
        WikiResult wikiResult=new WikiResult(this.keyword,response,imageUrl);
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        //System.out.println(gson);
        String json = gson.toJson(wikiResult);
        System.out.println(json);
    }
    private String getWikipediaUrlForQuery(String cleanKeyword) {
        return "https://en.wikipedia.org/wiki/"+cleanKeyword;
    }

    public static void main(String[] args) {
        TaskManager taskManager=new TaskManager(20);
        System.out.println("This is Mohit Kota ");
        System.out.println("Running WikipediaDownloader at "+new Date());
        String arr[]={"India","United States"};
        for(String i:arr)
        {
            WikipediaDownloader wikipediaDownloader=new WikipediaDownloader(i);
            taskManager.waitTillQueueIsFreeAndAddTask(wikipediaDownloader);
        }

    }
}
