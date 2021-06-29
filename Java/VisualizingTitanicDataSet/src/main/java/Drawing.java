import java.awt.Color;
import java.util.List;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

public class Drawing implements Drawing_interface{
    public  void age_plot(List<String> xlabl,List<Double> ylabl){

        CategoryChart chart=new CategoryChartBuilder().width(1000).height(800).title("Ages Histogram").xAxisTitle("Names").yAxisTitle("Age").build();
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setStacked(true);
        chart.addSeries("Passenger Ages", xlabl,ylabl);
        new SwingWrapper(chart).displayChart();

    }
    public  void gender_chart(int male,int female){
        PieChart chart=new PieChartBuilder().width(1000).height(600).title("Male v Female").build();
        Color[] slicecolor=new Color[]{new Color(180,208,50),new Color(230,105,120)};
        chart.getStyler().setSeriesColors(slicecolor);
        chart.addSeries("male", male);
        chart.addSeries("female", female);
        new SwingWrapper(chart).displayChart();

    }

}
