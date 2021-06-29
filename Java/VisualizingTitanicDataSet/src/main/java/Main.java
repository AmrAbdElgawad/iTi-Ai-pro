import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String args[]) throws IOException {
        //DAO for Getting Data
        String path="titanic.csv";
        DAO dataRead =new DAO(path);
        //POJO for getting values from Dao
       POJO POJO_Object=dataRead.readPrepareData();
        int males=POJO_Object.getMale_occurence();
        int females=POJO_Object.getFemale_occurence();
        List<String> xlabl = POJO_Object.getXlabl();
        List<Double> ylabl = POJO_Object.getYlabl();
        System.out.println(males);
        System.out.println(females);
        //Drawing the processed Data
        Drawing draw_data=new Drawing();
        draw_data.age_plot(xlabl,ylabl);

        draw_data.gender_chart(males,females);





    }
}
