package tech.codingclub.helix.entity;

public class TweetUi extends Tweet
{
    public String author_name;
    public String email;
    public TweetUi(Tweet tweet,Member member)
    {
        this.message = tweet.message;
        this.id = tweet.id;
        this.created_at = tweet.created_at;
        this.author_id = tweet.author_id;
        this.author_name=member.name;
        this.email = member.email;
    }


}
