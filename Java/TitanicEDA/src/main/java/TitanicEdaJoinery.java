import joinery.*;
import tech.tablesaw.api.DateColumn;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TitanicEdaJoinery
{
    //class Constructor
    String paths;
    TitanicEdaJoinery(String pat){
        paths=pat;
    }
    public DataFrame<Object> loadDataFromCVS() throws IOException {
        DataFrame<Object> df = joinery.DataFrame.readCsv(paths);
        return df;
    }

    public DataFrame<Object> addDateColumnToData(DataFrame<Object> df){
        List<Object> col = df.col("Fare");

        df.add("Fake Fare",col);
            return df;
    }




}
