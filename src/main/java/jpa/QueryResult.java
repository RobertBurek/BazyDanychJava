package jpa;

/**
 * Created by Robert Burek
 */
public class QueryResult {

    private String odp1;
    private String odp2;
    private String odp3;
    private String odp4;
    private long odp5;

    public QueryResult(String odp1, long odp5) {
        this.odp1 = odp1;
        this.odp5 = odp5;
    }


    public QueryResult(String odp1) {
        this.odp1 = odp1;
    }

    public QueryResult(String odp1, String odp2) {
        this.odp1 = odp1;
        this.odp2 = odp2;
    }

    public QueryResult(String odp1, String odp2, String odp3) {
        this.odp1 = odp1;
        this.odp2 = odp2;
        this.odp3 = odp3;
    }

    public QueryResult(String odp1, String odp2, String odp3, String odp4) {
        this.odp1 = odp1;
        this.odp2 = odp2;
        this.odp3 = odp3;
        this.odp4 = odp4;
    }


    public String toStringInt() {
        return "QueryResult{" +
                "odp1='" + odp1 + '\'' +
                ", odp5=" + odp5 +
                '}';
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "odp1='" + odp1 + '\'' +
                ", odp2='" + odp2 + '\'' +
                ", odp3='" + odp3 + '\'' +
                ", odp4='" + odp4 + '\'' +
                '}';
    }

    public String toString(int ile) {
        String odp = "";
        if (ile >= 1) odp += "odp1='" + odp1 + '\'';
        if (ile >= 2) odp += "odp2='" + odp2 + '\'';
        if (ile >= 3) odp += "odp3='" + odp3 + '\'';
        if (ile >= 4) odp += "odp4='" + odp4 + '\'';
        return "QueryResult{" + odp + '}';
    }
}
