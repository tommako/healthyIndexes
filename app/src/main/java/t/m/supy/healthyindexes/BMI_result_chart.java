package t.m.supy.healthyindexes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
//import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import objects.BMIobject;

//import java.util.ArrayList;


public class BMI_result_chart extends AppCompatActivity {


    BarChart barChart;
    int cDayToday;
    int cDayMinusOne;
    int cDayMinusTwo;
    int cDayMinusThree;
    int cDayMinusFour;

    //public static SQLLiteHelper sqlLiteHelper;
    //SQLLiteHelper sqlLiteHelper;

    ArrayList<BMIobject> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result_chart);

        getDaysOfWeek();

        MPchart();
        GraphView();

        //Cursor cursor = BMI_result_chart.sqlLiteHelper.getData("SELECT MIN(val) FROM BMI WHERE date = 10:8");
        //Cursor cursor = BMR_activity.sqlLiteHelper.getData("SELECT Id, date, val * FROM BMI");
        //list.clear();
        StringBuilder stringBuilder = new StringBuilder();
        /*while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String date = cursor.getString(1);
            String val = cursor.getString(2);
            //System.out.println("Value from database " + animalName + id + animalDescription);
            //stringBuilder.append(date + val);
            //System.out.println(stringBuilder);
            list.add(new BMIobject(id, date, val));

        }*/

        //sqlLiteHelper = new SQLLiteHelper(this, "IndexesDB.sqlite", null, 1);
        //sqlLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS BMI (Id INTEGER PRIMARY KEY AUTOINCREMENT, Date VARCHAR, Values VARCHAR)");

    }

    public void getDaysOfWeek(){

        Calendar calander = Calendar.getInstance();
        cDayToday = calander.get(Calendar.DAY_OF_MONTH);
        cDayMinusOne = calander.get(Calendar.DAY_OF_MONTH)-1;
        cDayMinusTwo = calander.get(Calendar.DAY_OF_MONTH)-2;
        cDayMinusThree = calander.get(Calendar.DAY_OF_MONTH)-3;
        cDayMinusFour = calander.get(Calendar.DAY_OF_MONTH)-4;
    }

    //https://www.youtube.com/watch?v=pi1tq-bp7uA&t=223s MP Android chart
    //https://www.youtube.com/watch?v=KRUSdhfWLPI Graphview approach

    public void GraphView() {

        GraphView graph = (GraphView) findViewById(R.id.graph);

        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(getDataPoint());


        graph.addSeries(series);
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLUE);
        series.setSpacing(20);
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                //return Color.rgb(125,236,142);
                if(data.getY()>6)
                    return Color.rgb(0,255,0);
                else if (data.getY()>4)
                    return Color.rgb(0,0,255);
                else
                    return Color.rgb(255,0,0);
            }
        });

    }

    private DataPoint[] getDataPoint(){

        SimpleDateFormat sff = new SimpleDateFormat("dd MM yy");
        String date = sff.format(Calendar.getInstance().getTime());

        //Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        //Date currentTime = localCalendar.getTime();
        //cDay = localCalendar.get(Calendar.DAY_OF_WEEK);

        DataPoint[] dp = new DataPoint[]
                        {

                                new DataPoint(0, 2),
                                new DataPoint(1, cDayMinusOne),
                                new DataPoint(2, cDayToday)

                        };

                return dp;



    }

    boolean hasNext = true;
    BufferedReader br;
    int skipLines;
    boolean linesSkiped;
    String pending;
    int INITIAL_READ_SIZE = 128;
    char escape;
    char quotechar;
    boolean inField = false;
    boolean strictQuotes;
    char separator;
    boolean ignoreLeadingWhiteSpace;

    /*public boolean isPending() {
        return pending != null;
    }*/

    /*public String[] parseLineMulti(String nextLine) throws IOException {
        return parseLine(nextLine, true);
    }*/

    /*public String[] parseLine(String nextLine) throws IOException {
        return parseLine(nextLine, false);
    }*/

    /*private boolean isNextCharacterEscapedQuote(String nextLine, boolean inQuotes, int i) {
        return inQuotes  // we are in quotes, therefore there can be escaped quotes in here.
                && nextLine.length() > (i + 1)  // there is indeed another character to check.
                && nextLine.charAt(i + 1) == quotechar;
    }*/

    /*protected boolean isNextCharacterEscapable(String nextLine, boolean inQuotes, int i) {
        return inQuotes  // we are in quotes, therefore there can be escaped quotes in here.
                && nextLine.length() > (i + 1)  // there is indeed another character to check.
                && (nextLine.charAt(i + 1) == quotechar || nextLine.charAt(i + 1) == this.escape);
    }*/

    /*protected boolean isAllWhiteSpace(CharSequence sb) {
        boolean result = true;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            if (!Character.isWhitespace(c)) {
                return false;
            }
        }
        return result;
    }*/

    /*public String[] parseLine(String nextLine, boolean multi) throws IOException {

        if (!multi && pending != null) {
            pending = null;
        }

        if (nextLine == null) {
            if (pending != null) {
                String s = pending;
                pending = null;
                return new String[]{s};
            } else {
                return null;
            }
        }

        List<String> tokensOnThisLine = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(INITIAL_READ_SIZE);
        boolean inQuotes = false;
        if (pending != null) {
            sb.append(pending);
            pending = null;
            inQuotes = true;
        }
        for (int i = 0; i < nextLine.length(); i++) {

            char c = nextLine.charAt(i);
            if (c == this.escape) {
                if (isNextCharacterEscapable(nextLine, inQuotes || inField, i)) {
                    sb.append(nextLine.charAt(i + 1));
                    i++;
                }
            } else if (c == quotechar) {
                if (isNextCharacterEscapedQuote(nextLine, inQuotes || inField, i)) {
                    sb.append(nextLine.charAt(i + 1));
                    i++;
                } else {
                    //inQuotes = !inQuotes;

                    // the tricky case of an embedded quote in the middle: a,bc"d"ef,g
                    if (!strictQuotes) {
                        if (i > 2 //not on the beginning of the line
                                && nextLine.charAt(i - 1) != this.separator //not at the beginning of an escape sequence
                                && nextLine.length() > (i + 1) &&
                                nextLine.charAt(i + 1) != this.separator //not at the	end of an escape sequence
                                ) {

                            if (ignoreLeadingWhiteSpace && sb.length() > 0 && isAllWhiteSpace(sb)) {
                                sb.setLength(0);  //discard white space leading up to quote
                            } else {
                                sb.append(c);
                                //continue;
                            }

                        }
                    }

                    inQuotes = !inQuotes;
                }
                inField = !inField;
            } else if (c == separator && !inQuotes) {
                tokensOnThisLine.add(sb.toString());
                sb.setLength(0); // start work on next token
                inField = false;
            } else {
                if (!strictQuotes || inQuotes) {
                    sb.append(c);
                    inField = true;
                }
            }
        }
        // line is done - check status
        if (inQuotes) {
            if (multi) {
                // continuing a quoted section, re-append newline
                sb.append("\n");
                pending = sb.toString();
                sb = null; // this partial content is not to be added to field list yet
            } else {
                throw new IOException("Un-terminated quoted field at end of CSV line");
            }
        }
        if (sb != null) {
            tokensOnThisLine.add(sb.toString());
        }
        return tokensOnThisLine.toArray(new String[tokensOnThisLine.size()]);

    }*/

    /*public List<String[]> readAll() throws IOException{

        List<String[]> allElements = new ArrayList<String[]>();
        while (hasNext) {
            String[] nextLineAsTokens = readNext();
            if (nextLineAsTokens != null)
                allElements.add(nextLineAsTokens);
        }
        return allElements;

    }*/

    /*public String[] readNext() throws IOException {

        String[] result = null;
        do {
            String nextLine = getNextLine();
            if (!hasNext) {
                return result; // should throw if still pending?
            }
            String[] r = parseLineMulti(nextLine);
            if (r.length > 0) {
                if (result == null) {
                    result = r;
                } else {
                    String[] t = new String[result.length+r.length];
                    System.arraycopy(result, 0, t, 0, result.length);
                    System.arraycopy(r, 0, t, result.length, r.length);
                    result = t;
                }
            }
        } while (isPending());
        return result;
    }*/

    /*public String getNextLine() throws IOException {
        if (!this.linesSkiped) {
            for (int i = 0; i < skipLines; i++) {
                br.readLine();
            }
            this.linesSkiped = true;
        }
        String nextLine = br.readLine();
        if (nextLine == null) {
            hasNext = false;
        }
        return hasNext ? nextLine : null;
    }*/

    public void MPchart(){

        barChart = (BarChart)findViewById(R.id.bargraph);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        /*SimpleDateFormat sff = new SimpleDateFormat("dd MM yy");
        String date = sff.format(Calendar.getInstance().getTime());
        int cDay = Calendar.DAY_OF_MONTH;*/

        /*barEntries.add(new BarEntry(44f,0));
        barEntries.add(new BarEntry(45f,1));
        barEntries.add(new BarEntry(40f,2));
        barEntries.add(new BarEntry(30f,3));
        barEntries.add(new BarEntry(35f,40));
        barEntries.add(new BarEntry(47f,5));*/

        String Data;
        StringBuffer stringBuffer = null;
        String[] loadedData;
        try {
            int i;
            //HashMap<String, Integer > map = new HashMap<String, Integer >();
            //HashMap<String, int[] > map = new HashMap<String, int[]>();
            HashMap<String, Double > map = new HashMap<String, Double>();
            //HashMap<String, float[] > map = new HashMap<String, float[]>();
            //String Data;
            FileInputStream fileInputStream = openFileInput("BMI1.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            stringBuffer = new StringBuffer();
            //CSVReader csv = new CSVReader();

            //Scanner lineReader =


            //List<String[]> csvdata = new ArrayList<>();
            //csvdata.get()

            //Iterator<String[]> itr = csvdata.iterator();
            //Iterator<String[]> itr = null;
            //itr.next();

            while ((Data = bufferedReader.readLine()) != null){
            //while ((Iterator = bufferedReader.lines()) != null){
                    //csvdata.add(Data.split(";"));
                    loadedData = Data.split(";");
                //Iterator<String[]> itr = loadedData.iterator();

                /*for(int j=0;j<loadedData.length;j++){
                    //String arr[] = loadedData[j];
                    //loadedData[j].toString();
                    Double result = new Double(loadedData[2].trim()).doubleValue();
                    map.put(loadedData[0], result);

                    //System.out.println(arr[0] + ";" + arr[1] + ";" + arr[2]);

                }*/

                //String daco = loadedData[0];
                //String daco2 = loadedData[1];
                //String daco3 = loadedData[2];
                    //System.out.println("data from list" + csvdata.get(1).toString());
                    //maping procedure
                    //int[] result;
                    //result = new int[1];
                    //result[0] = new Integer(loadedData[2].trim()).intValue();

                    Double result = new Double(loadedData[2].trim()).doubleValue();
                    //StringBuilder sb = new StringBuilder();
                    //sb.append(loadedData[0]);
                    //sb.append(loadedData[1]);
                //String [] arr;


                    //map.put(loadedData[0] + ";" + loadedData[1], result);
                    map.put(loadedData[1], result);

                    //maping procedure
                /*float[] result;
                result = new float[1];
                result[0] = new Integer(loadedData[2].trim()).intValue();
                map.put(loadedData[0] + ";" + loadedData[1], result);*/

                    System.out.println(loadedData[0] + ";" + loadedData[1] + ";" + loadedData[2]+ "Map values" + map.values());
                    //int[] result2 = null;
                    //Double result2 = map.get("8:8");
                    //System.out.println("Result2 is " + result2);
                    //System.out.println("data loaded" + Double.toString(Double.parseDouble(result2.toString())));
                    //String res = Double.toString(Double.parseDouble(String.format("%.2f", result2)));
                    //System.out.println("Response is" + res);
                    //stringBuffer.append(Data + "\n");

            }
            //t.setText(stringBuffer.toString());
            //t.setVisibility(view.VISIBLE);
            //loadData.setText(stringBuffer.toString());
            //loadData.setVisibility(view.VISIBLE);

            //double data = sqlLiteHelper.SelectData("BMI","20");
            /*
            //Cursor cursor = BMI_result_chart.sqlLiteHelper.getData("SELECT MIN(val) FROM BMI WHERE date = 10:8");
            Cursor cursor = BMI_result_chart.sqlLiteHelper.getData("SELECT * FROM BMI");
            //list.clear();
            while (cursor.moveToNext()) {
                //int id = cursor.getInt(0);
                String animalName = cursor.getString(2);
                //String animalDescription = cursor.getString(2);
                System.out.println("Value from database " + animalName);
            }
            */

            fileInputStream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }

        barEntries.add(new BarEntry(1,cDayMinusFour));
        //barEntries.add(new BarEntry(1, Integer.parseInt(loadedData)));
        barEntries.add(new BarEntry(2,cDayMinusThree));
        barEntries.add(new BarEntry(3,cDayMinusTwo));
        barEntries.add(new BarEntry(4,cDayMinusOne));
        barEntries.add(new BarEntry(5,cDayToday));
        barEntries.add(new BarEntry(6,60));
        //barEntries.add(new BarEntry(25f,6));
        BarDataSet barDataSet = new BarDataSet(barEntries,"Dates");
        //IBarDataSet iBarDataSet = new IBarDataSet();

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(barDataSet);

        ArrayList<String> theDates = new ArrayList<>();

        theDates.add("April");
        theDates.add("May");
        theDates.add("Jun");
        theDates.add("Jul");
        theDates.add("August");
        theDates.add("September");

        //BarData theData = new BarData(theDates, "");
        //BarData theData = new BarData(theDates, dataSets);
        BarData theData = new BarData(dataSets);

        barChart.setData(theData);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);

    }
}
