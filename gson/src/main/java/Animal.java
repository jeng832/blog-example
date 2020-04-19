import com.google.gson.annotations.SerializedName;

public class Animal {
    @SerializedName("legs")
    private int nLeg;

    @SerializedName("name")
    private String name;

    @Override
    public String toString() {
        return "Animal[nLeg: " + nLeg + ", name: " + name + "]";
    }

}
