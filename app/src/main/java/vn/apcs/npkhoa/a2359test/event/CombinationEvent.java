package vn.apcs.npkhoa.a2359test.event;

import java.util.List;

import vn.apcs.npkhoa.a2359test.entities.Combination;

/**
 * Created by khoanguyen on 4/5/18.
 */

//This is an event model which wraps all of the event information. In this case, it is a list of combinations
//and an error string (if exists)
public class CombinationEvent {
    private String error;
    private List<Combination> combinations;

    public CombinationEvent(String error, List<Combination> combinations) {
        this.error = error;
        this.combinations = combinations;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Combination> getCombinations() {
        return combinations;
    }

    public void setCombinations(List<Combination> combinations) {
        this.combinations = combinations;
    }
}
