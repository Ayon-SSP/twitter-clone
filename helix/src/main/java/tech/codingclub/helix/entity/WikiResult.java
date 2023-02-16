package tech.codingclub.helix.entity;

public class WikiResult {

    private String query;
    private String text_result;
    private String image_url;


    public WikiResult(String query, String text_result, String image_url) {
        this.query = query;
        this.text_result = text_result;
        this.image_url = image_url;
    }
    public WikiResult()
    {

    }

    public String getQuery() {
        return query;
    }



    public String getImage_url() {
        return image_url;
    }

    public String getText_result()
    {
        return text_result;
    }
}
