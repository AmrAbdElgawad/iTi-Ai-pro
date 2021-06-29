import joinery.DataFrame;
import tech.tablesaw.api.*;
import tech.tablesaw.columns.Column;

import java.io.IOException;
import java.util.List;

public class TitanicEda {
    public static void main(String[] args) throws IOException {
        String path= "titanic.csv";
        TitanicEdaTablesaw tableSawDF= new TitanicEdaTablesaw(path);
        Table titianicDF_tablesaw=tableSawDF.loadDataFromCVS();

        System.out.println(tableSawDF.getDataInfoStructure(titianicDF_tablesaw));
        System.out.printf("=====================Data Summary is ===========================");
        System.out.println(tableSawDF.getDataSummary(titianicDF_tablesaw));
        Table insertedData=tableSawDF.addDateColumnToData(titianicDF_tablesaw);
        System.out.println("================================Data After inserting Fake Date column=============");
        System.out.println(String.valueOf(insertedData));
        System.out.println("=============Adding Gender Column(using Sex column)  0 , 1  1=female , 0 = male ==========");
        System.out.println(tableSawDF.mapTextColumnToNumber(titianicDF_tablesaw));
        //two cols from the first df
        Column<?> co1 = titianicDF_tablesaw.column("Name");
        insertedData.removeColumns("Name");

        co1.setName("Fake Names");
        insertedData.insertColumn(insertedData.columnCount(),co1);
        System.out.println("================================Table Saw Merging cols from two Tables (Adding Fake names Cols At the end and delete orginal Name)=============");
        System.out.println(String.valueOf(insertedData));




        //EDA using Joinery
        System.out.println("=============Starting EDA on Titanic Data set using Joinery ==========");

        TitanicEdaJoinery joinerydf=new TitanicEdaJoinery(path);
        DataFrame<Object> titianicDF_joinery = joinerydf.loadDataFromCVS();
        System.out.println("=============Describe data  using Joinery ==========");
        System.out.println(titianicDF_joinery.describe());
        // adding a column
        System.out.println("================================Joinery inserting Fake Date column=============");
        DataFrame<Object> added_columnndf = joinerydf.addDateColumnToData(titianicDF_joinery);
        System.out.println(added_columnndf.toString());

        //two cols from the first df
        List<Object> col0=titianicDF_joinery.col("Ticket");
        List<Object> col1 = titianicDF_joinery.col("Fare");
        // two cols from modified df
        List<Object> col2 = added_columnndf.col("Pclass");
        List<Object> col3 = added_columnndf.col("Name");
        DataFrame <Object> newDF=new DataFrame<>();
        newDF.append("Name",col3);
        newDF.append("PCLASS",col2);
        newDF.append("FARE",col1);
        newDF.append("Ticket  ",col0);


        newDF=newDF.transpose();

        System.out.println("================================Joinery Merging cols from two DF =============");
        System.out.println(newDF.toString());

    }
}
