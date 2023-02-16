package tech.codingclub.helix.entity;

public class Follower {
    public Follower(Long user_id, Long following_id) {
        this.user_id = user_id;
        this.following_id = following_id;
    }

    public Follower() {
    }

    public Long user_id;
    public Long following_id;
}
