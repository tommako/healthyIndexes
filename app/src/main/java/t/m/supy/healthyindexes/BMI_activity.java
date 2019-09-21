package t.m.supy.healthyindexes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static t.m.supy.healthyindexes.R.raw.bmi;

public class BMI_activity extends AppCompatActivity {

    private static Button button_cal;
    private static Button button_load;
    private static Button button_chart;
    private static EditText e;
    private static EditText e1;

    private static  TextView loadData;

    private static TextView t;
    private static TextView t2;

    public static SQLLiteHelper sqlLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_activity);
        onButtonClick();
        //onChartClick();
        //t =(TextView)findViewById(R.id.textView8);
       // readData(View view);
       // t =(TextView)findViewById(R.id.textView8);
        //t2 =(TextView)findViewById(R.id.textView9);
        //t.setVisibility(View.GONE);
        //readData();
        //loadData = (TextView)findViewById(R.id.textView42);
        //loadData.setVisibility(View.GONE);

        //sqlLiteHelper = new SQLLiteHelper(this, "IndexesDB.sqlite", null, 1);
        //sqlLiteHelper.QueryData("CREATE TABLE IF NOT EXISTS BMI (Id INTEGER PRIMARY KEY AUTOINCREMENT, date VARCHAR, val VARCHAR)");


    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        return true;
    }

    //https://www.youtube.com/watch?v=D8jSGCkIltM
   // https://www.youtube.com/watch?v=9UGAe2ydAFM
    //https://www.youtube.com/watch?v=mMcrj_To18k
    //https://www.youtube.com/watch?v=WX4yYQmJKBY
    public void  readData(View view){



        try {
            String Data;
            FileInputStream fileInputStream = openFileInput("BMI1.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((Data = bufferedReader.readLine()) != null){
                stringBuffer.append(Data + "\n");
            }
            //t.setText(stringBuffer.toString());
            //t.setVisibility(view.VISIBLE);
            loadData.setText(stringBuffer.toString());
            loadData.setVisibility(view.VISIBLE);

            fileInputStream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();
        }

    }

    public void onButtonClick(){

        //Texts fields for input
        e =(EditText)findViewById(R.id.editText);
        e1 =(EditText)findViewById(R.id.editText2);

        t =(TextView)findViewById(R.id.textView8);
        t2 =(TextView)findViewById(R.id.textView9);

        button_cal = (Button)findViewById(R.id.cal_button);

        button_cal.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        if (e.getText().toString().isEmpty() || e1.getText().toString().isEmpty()){

                            Toast.makeText(BMI_activity.this, "You didn't imput weight or kg necessary for calculation",
                                    Toast.LENGTH_SHORT).show();

                        }else {

                            double weight = Double.parseDouble(e.getText().toString());

                            double height = Double.parseDouble(e1.getText().toString());
                            double heightToMeters = height / 100;
                            double result = weight / (heightToMeters * heightToMeters);


                            t.setText(Double.toString(Double.parseDouble(String.format("%.2f", result))));


                            if (result < 18.5) {
                                t2.setText("Malnutrition - The body is not sufficiently dependent, lacks basic trace elements, which results in " +
                                        "frequent condition overall weakening of the body and often suffering from anorexia or bulimia.");
                                //Týka sa predovšetkým trpiacich anorexiou či bulímiou. Telo nie je dostatočne vyživované, chýbajú mu základné stopové prvky, čo sa prejavuje častými ochoreniami a celkovým oslabením organizmu.
                                //try {
                                    //File file = new File(context.getFilesDir(), filename);
                                    //File fos2 = getResources().openRawResource(R.raw.BMI);
                                    //FileOutputStream fos = new FileOutputStream();
                                    //String s = String.valueOf(getResources().openRawResource(R.raw.BMI));
                                    //FileOutputStream fos2 = openFileOutput(getResources().openRawResource(R.raw.bmi), contex.getFileDir());
                                   /* File root = Environment.getExternalStorageDirectory();
                                    File dir = new File(root.getAbsolutePath());
                                    File file = new File(context.getFilesDir(), "bmi.csv");*/

                                   //FileOutputStream fos2 = openFileOutput("file.csv", MODE_PRIVATE);
                                    //OutputStreamWriter outputWriter=new OutputStreamWriter(fos2);

                                    //SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy HH:mm");
                                    //Calendar c = Calendar.getInstance();
                                    //SimpleDateFormat sdf = new SimpleDateFormat("dd MM HH:mm");
                                    //sdf.format(c.getTime());

                                    //Date dt = new Date("dd MM hh:mm");
                                    //String stringDate = DateFormat.getDateTimeInstance().format(dt);

                                    /*Calendar c = Calendar.getInstance();
                                    int day = c.get(Calendar.DAY_OF_MONTH);
                                    int month = c.get(Calendar.MONTH);
                                    int hour = c.get(Calendar.HOUR_OF_DAY);
                                    int minute = c.get(Calendar.MINUTE);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(day + "-");
                                    sb.append(month + ";");
                                    sb.append(hour + ":");
                                    sb.append(minute);*/

                                    //String filename = "BMI1.csv";
                                    //FileOutputStream fos = openFileOutput("BMI.csv" , Context.MODE_PRIVATE);
                                    //FileOutputStream fos = openFileOutput(filename , Context.MODE_APPEND);
                                    //File file = new File(getFilesDir(), filename);

                                    /*String res = Double.toString(Double.parseDouble(String.format("%.2f", result)));
                                    Double resultInDouble = Double.parseDouble(res);
                                    String res2 = sb + ";" + res + "\n";
                                    //fos.write(res.getBytes());
                                    String roundingResult = String.format("%.2f", result);
                                    fos.write(res2.getBytes());
                                    fos.close();*/

                                    //https://www.youtube.com/watch?v=ZtVcT38_7Gs&t=580s

                                    //outputWriter.write("TEST STRING..");
                                    //outputWriter.close();

                                    //display file saved message
                                    //Toast.makeText(getBaseContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();

                                    /*Toast.makeText(getApplication(),"Data saved" + file, Toast.LENGTH_LONG).show();

                                    String dateToString = Integer.toString(day) + ":" + Integer.toString(month);
                                    sqlLiteHelper.InsertData("BMI", dateToString, roundingResult);
                                    //sqlLiteHelper.InsertData("BMI", dateToString, resultInDouble);

                                    Toast.makeText(getApplicationContext(),"Added to database" + dateToString + " " + roundingResult, Toast.LENGTH_SHORT).show();

                                }catch (Exception e){

                                }*/

                            }
                            if (result > 18.5 && result < 25) {
                                t2.setText("Ideal - A person with this BMI you should keep your weight balanced diet and plenty of movement. Medical complications " +
                                        "of weight in this group are the least common.");
                                // Človek s týmto BMI by si mal svoju váhu udržať vyváženou stravou a dostatkom pohybu. Zdravotné komplikácie spojené s hmotnosťou sú v tejto skupine najmenej časté.
                            }
                            if (result > 25 && result < 30) {
                                t2.setText("Modestly overweight - A person with this BMI have high probability for hight blood presuare or heart problems. Reason is " +
                                        "mostly wrong eating habits, for m late or night eating, wrong balace fat and other food ingredients. Also not enought activity " +
                                        "or seating type of work");
                                //Riziko vysokého tlaku či srdcových ťažkostí sa tu mierne zvyšuje. Poväčšine ide o nesprávne stravovacie návyky, napríklad nadmerné konzumovanie večer a v noci, alebo nevyvážený podiel tukov a iných zložiek potravy. Takisto je tu častý nedostatok pohybu či sedavé zamestnanie.
                            }
                            if (result > 30 && result < 40) {
                                t2.setText("Obesity - in this case it's big health risk");
                                //V tomto prípade ide o pomerne vážne zdravotné riziko.
                            }
                            if (result > 40) {
                                t2.setText("Severe obesity - in this case it's necassary radical change eating habits and habits");
                                //V tomto štádiu je potrebná radikálna zmena stravovacieho režimu a návykov.
                            }

                        }
                    }
                }

        );

    }

    /*public void onChartClick(){

        button_chart = (Button)findViewById(R.id.ChartButton);

        button_chart.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("BMI_result_chart");
                        startActivity(intent);
                    }
                }
        );

    }*/
}
