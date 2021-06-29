import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

public class DAO implements DAO_inteface {

    String path;
    public DAO(String path) {
        this.path=path;
    }

    public POJO readPrepareData() throws IOException {
        List<String> xlabel;
        List<Double> ydata;
        Table data=Table.read().csv(path);
        StringColumn names=(StringColumn) data.column("name");
        DoubleColumn ages=(DoubleColumn) data.column("age");
        xlabel=names.asList().stream().limit(10).collect(Collectors.toList());
        ydata=ages.asList().stream().limit(10).collect(Collectors.toList());


        StringColumn sex=(StringColumn) data.column("sex");
        List<String> gender=sex.asList();
        int male_occurence= Collections.frequency(gender, "male");
        int female_occurence= Collections.frequency(gender, "female");
        return new POJO(male_occurence,female_occurence,xlabel,ydata);
    }




}
