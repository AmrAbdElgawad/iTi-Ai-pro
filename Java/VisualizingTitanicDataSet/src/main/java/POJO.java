import java.util.List;

public final  class POJO {

    private  int male_occurence;
    private  int female_occurence;
    private  List<String> xlabl;
    private  List<Double> ylabl;

    POJO(int male_occurence, int female_occurence, List<String> xlabel, List<Double> ydata){
        this.male_occurence=male_occurence;
        this.female_occurence=female_occurence;
        this.xlabl=xlabel;
        this.ylabl=ydata;


    }

    public int getMale_occurence() {
        return male_occurence;
    }

    public int getFemale_occurence() {
        return female_occurence;
    }

    public List<String> getXlabl() {
        return xlabl;
    }

    public List<Double> getYlabl() {
        return ylabl;
    }
}
