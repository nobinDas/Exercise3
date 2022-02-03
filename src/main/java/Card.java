import java.io.Serializable;

public class Card implements Serializable {
    String rank, suite;

    public Card(String rank, String suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public String getRank() {
        return rank;
    }

    public String getSuite() {
        return suite;
    }

    public String toString() {
        return this.rank + this.suite;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.toString().equals(this.toString())) return true;
        else return false;
    }
}
