package tech.codingclub.helix.entity;

public class TimeApi {

    private String time_str;
    private long epoch_time;

    public TimeApi(String time_str, long epoch_time)
    {

        this.time_str = time_str;
        this.epoch_time = epoch_time;
    }

}
