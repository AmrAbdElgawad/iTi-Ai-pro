import tech.tablesaw.api.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TitanicEdaTablesaw {
    String paths;
    TitanicEdaTablesaw(String pat){
        paths=pat;

    }
    public  String getDataInfoStructure(Table data){
        Table dataStructure= data.structure();
        return dataStructure.toString();
    }
    /// Load Data From CSV File using Table saw
    public  Table loadDataFromCVS() throws IOException {
        Table titanicData=Table.read().csv(paths);
        return titanicData;
    }
    public  String getDataSummary(Table data){
        Table summary = data.summary ();
        return summary.toString();
    }
    public  Table addDateColumnToData(Table data){
        int rowCount=data.rowCount ();
        List<LocalDate> dateList=new ArrayList<LocalDate>();
        for(int i=0;i<rowCount;i++) {
            dateList.add (LocalDate.of (2021, 3, i%31==0?1:i%31));
        }
        DateColumn dateColumn= DateColumn.create("Fake Date",dateList);
        data.insertColumn (data.columnCount (),dateColumn);
        return data;
    }
    public  Table mapTextColumnToNumber(Table data){
        NumberColumn mappedGenderColumn=null;
        StringColumn gender= (StringColumn) data.column ("Sex");
        List<Number> mappedGenderValues=new ArrayList<Number>();
        for(String v:gender) {
            if ((v != null) && (v.equals ("female"))) {
                mappedGenderValues.add (new Double (1));
            } else {
                mappedGenderValues.add (new Double (0));
            }
        }
        mappedGenderColumn= DoubleColumn.create("gender",mappedGenderValues);
        data.addColumns (mappedGenderColumn);
        return data;
    }




}
