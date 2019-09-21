package t.m.supy.healthyindexes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ABSI_activity extends AppCompatActivity {

    private static Button button_absi;
    private static RadioGroup radioGr;
    private static RadioButton radio_b;
    private static EditText weight_ET;
    private static EditText height_ET;
    private static EditText waist_circumference_ET;
    private static EditText age_ET;
    private static TextView result_TextView;
    private static TextView det_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absi_activity);
        CalculateABSI();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void CalculateABSI(){

        weight_ET =(EditText)findViewById(R.id.weigth_editText);
        height_ET =(EditText)findViewById(R.id.height_editText);
        waist_circumference_ET =(EditText)findViewById(R.id.waist_editText);
        age_ET =(EditText)findViewById(R.id.age_editText);

        result_TextView =(TextView)findViewById(R.id.result_textView);
        det_TextView =(TextView)findViewById(R.id.detail_textView);

        button_absi =(Button)findViewById(R.id.absi_button);

        radioGr =(RadioGroup)findViewById(R.id.radioGroup);

        button_absi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (weight_ET.getText().toString().isEmpty() || height_ET.getText().toString().isEmpty() ||
                                waist_circumference_ET.getText().toString().isEmpty() || age_ET.getText().toString().isEmpty()){
                            Toast.makeText(ABSI_activity.this, "You didn't imput circumference, weight, age or hight necessary for calculation",
                                    Toast.LENGTH_SHORT).show();

                        }else {

                            double weight = Double.parseDouble(weight_ET.getText().toString());
                            double height = Double.parseDouble(height_ET.getText().toString());
                            double circumference = Double.parseDouble(waist_circumference_ET.getText().toString());
                            double age = Double.parseDouble(age_ET.getText().toString());

                            double heightInToMeter = height / 100;
                            double bmi = weight / Math.pow(heightInToMeter, 2);

                            double result = (circumference / 100) / (Math.pow(bmi, 0.666) * Math.pow(heightInToMeter, 0.5));

                            if (age < 2 || age >= 86) {
                                Toast.makeText(ABSI_activity.this, "Your age isn't to 1 and from 86 include ",
                                        Toast.LENGTH_SHORT).show();
                            } else {


                                result_TextView.setText(Double.toString(Double.parseDouble(String.format("%.4f", result))));

                                int selected_id = radioGr.getCheckedRadioButtonId();
                                radio_b = (RadioButton) findViewById(selected_id);
                                String gender = radio_b.getText().toString();

                                //Calculation for Men

                                //Age 2

                                if (gender.equals("Men") && age == 2) {

                                    double absiZ = (result - 0.07778) / 0.00312;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }

                                }

                                //Age 3

                                if (gender.equals("Men") && age == 3) {

                                    double absiZ = (result - 0.07931) / 0.00283;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 4

                                if (gender.equals("Men") && age == 4) {

                                    double absiZ = (result - 0.07932) / 0.00300;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 5

                                if (gender.equals("Men") && age == 5) {

                                    double absiZ = (result - 0.08009) / 0.00335;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 6

                                if (gender.equals("Men") && age == 6) {

                                    double absiZ = (result - 0.07989) / 0.00362;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 7

                                if (gender.equals("Men") && age == 7) {

                                    double absiZ = (result - 0.07968) / 0.00341;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 8

                                if (gender.equals("Men") && age == 8) {

                                    double absiZ = (result - 0.08063) / 0.00415;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 9

                                if (gender.equals("Men") && age == 9) {

                                    double absiZ = (result - 0.08025) / 0.00423;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 10

                                if (gender.equals("Men") && age == 10) {

                                    double absiZ = (result - 0.07969) / 0.00408;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 11

                                if (gender.equals("Men") && age == 11) {

                                    double absiZ = (result - 0.07964) / 0.00442;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 12

                                if (gender.equals("Men") && age == 12) {

                                    double absiZ = (result - 0.07953) / 0.00438;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 13

                                if (gender.equals("Men") && age == 13) {

                                    double absiZ = (result - 0.07807) / 0.00434;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 14

                                if (gender.equals("Men") && age == 14) {

                                    double absiZ = (result - 0.07712) / 0.00436;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 15

                                if (gender.equals("Men") && age == 15) {

                                    double absiZ = (result - 0.07647) / 0.00415;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 16

                                if (gender.equals("Men") && age == 16) {

                                    double absiZ = (result - 0.07583) / 0.00379;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 17

                                if (gender.equals("Men") && age == 17) {

                                    double absiZ = (result - 0.07625) / 0.00376;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 18

                                if (gender.equals("Men") && age == 18) {

                                    double absiZ = (result - 0.07665) / 0.00361;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 19

                                if (gender.equals("Men") && age == 19) {

                                    double absiZ = (result - 0.07665) / 0.00393;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Age 20

                                if (gender.equals("Men") && age == 20) {

                                    double absiZ = (result - 0.07715) / 0.00410;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }



                                if (gender.equals("Men") && age == 20) {

                                    double absiZ = (result - 0.07715) / 0.00410;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 21) {

                                    double absiZ = (result - 0.07754) / 0.00370;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 22) {

                                    double absiZ = (result - 0.07861) / 0.00452;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 23) {

                                    double absiZ = (result - 0.07839) / 0.00364;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 24) {

                                    double absiZ = (result - 0.07794) / 0.00363;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 25) {

                                    double absiZ = (result - 0.07880) / 0.00354;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 26) {

                                    double absiZ = (result - 0.07895) / 0.00381;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 27) {

                                    double absiZ = (result - 0.07936) / 0.00402;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 28) {

                                    double absiZ = (result - 0.07999) / 0.00387;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 29) {

                                    double absiZ = (result - 0.07944) / 0.00381;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 30) {

                                    double absiZ = (result - 0.07949) / 0.00370;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 31) {

                                    double absiZ = (result - 0.07890) / 0.00317;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 32) {

                                    double absiZ = (result - 0.07922) / 0.00374;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 33) {

                                    double absiZ = (result - 0.08010) / 0.00408;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 34) {

                                    double absiZ = (result - 0.07977) / 0.00367;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 35) {

                                    double absiZ = (result - 0.08039) / 0.00358;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 36) {

                                    double absiZ = (result - 0.07966) / 0.00397;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 37) {

                                    double absiZ = (result - 0.07999) / 0.00381;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 38) {

                                    double absiZ = (result - 0.08031) / 0.00367;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 39) {

                                    double absiZ = (result - 0.08114) / 0.00363;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 40) {

                                    double absiZ = (result - 0.08089) / 0.00354;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 41) {

                                    double absiZ = (result - 0.08127) / 0.00335;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 42) {

                                    double absiZ = (result - 0.08122) / 0.00347;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 43) {

                                    double absiZ = (result - 0.08084) / 0.00339;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 44) {

                                    double absiZ = (result - 0.08110) / 0.00327;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 45) {

                                    double absiZ = (result - 0.08140) / 0.00332;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 46) {

                                    double absiZ = (result - 0.08272) / 0.00426;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 47) {

                                    double absiZ = (result - 0.08176) / 0.00306;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 48) {

                                    double absiZ = (result - 0.08119) / 0.00323;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 49) {

                                    double absiZ = (result - 0.08272) / 0.00400;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 50) {

                                    double absiZ = (result - 0.08322) / 0.00333;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 51) {

                                    double absiZ = (result - 0.08261) / 0.00385;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 52) {

                                    double absiZ = (result - 0.08281) / 0.00360;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 53) {

                                    double absiZ = (result - 0.08272) / 0.00399;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 54) {

                                    double absiZ = (result - 0.08324) / 0.00356;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 55) {

                                    double absiZ = (result - 0.08388) / 0.00406;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 56) {

                                    double absiZ = (result - 0.08321) / 0.00386;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 57) {

                                    double absiZ = (result - 0.08529) / 0.00393;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 58) {

                                    double absiZ = (result - 0.08374) / 0.00344;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 59) {

                                    double absiZ = (result - 0.08343) / 0.00354;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 60) {

                                    double absiZ = (result - 0.08392) / 0.00354;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 61) {

                                    double absiZ = (result - 0.08487) / 0.00354;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 62) {

                                    double absiZ = (result - 0.08455) / 0.00348;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 63) {

                                    double absiZ = (result - 0.08513) / 0.00352;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 64) {

                                    double absiZ = (result - 0.08489) / 0.00275;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 65) {

                                    double absiZ = (result - 0.08547) / 0.00343;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 66) {

                                    double absiZ = (result - 0.08583) / 0.00343;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 67) {

                                    double absiZ = (result - 0.08518) / 0.00324;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 68) {

                                    double absiZ = (result - 0.08565) / 0.00298;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 69) {

                                    double absiZ = (result - 0.08633) / 0.00382;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 70) {

                                    double absiZ = (result - 0.08534) / 0.00387;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 71) {

                                    double absiZ = (result - 0.08603) / 0.00356;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 72) {

                                    double absiZ = (result - 0.08635) / 0.00364;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 73) {

                                    double absiZ = (result - 0.08605) / 0.00325;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 74) {

                                    double absiZ = (result - 0.08648) / 0.00387;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 75) {

                                    double absiZ = (result - 0.08713) / 0.00363;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 76) {

                                    double absiZ = (result - 0.08671) / 0.00313;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 77) {

                                    double absiZ = (result - 0.08691) / 0.00348;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 78) {

                                    double absiZ = (result - 0.08592) / 0.00383;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 79) {

                                    double absiZ = (result - 0.08745) / 0.00361;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 80) {

                                    double absiZ = (result - 0.08759) / 0.00384;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 81) {

                                    double absiZ = (result - 0.08714) / 0.00395;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 82) {

                                    double absiZ = (result - 0.08713) / 0.00370;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 83) {

                                    double absiZ = (result - 0.08714) / 0.00342;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 84) {

                                    double absiZ = (result - 0.08763) / 0.00385;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Men") && age == 84) {

                                    double absiZ = (result - 0.08811) / 0.00356;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                //Women

                                if (gender.equals("Women") && age == 2) {

                                    double absiZ = (result - 0.07922) / 0.00319;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 3) {

                                    double absiZ = (result - 0.08000) / 0.00303;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 4) {

                                    double absiZ = (result - 0.08045) / 0.00280;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 5) {

                                    double absiZ = (result - 0.08085) / 0.00327;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 6) {

                                    double absiZ = (result - 0.08006) / 0.00338;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 7) {

                                    double absiZ = (result - 0.08013) / 0.00333;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 8) {

                                    double absiZ = (result - 0.08039) / 0.00388;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 9) {

                                    double absiZ = (result - 0.08016) / 0.00370;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 10) {

                                    double absiZ = (result - 0.07914) / 0.00378;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 11) {

                                    double absiZ = (result - 0.07934) / 0.00400;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 12) {

                                    double absiZ = (result - 0.07825) / 0.00403;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 13) {

                                    double absiZ = (result - 0.07807) / 0.00439;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 14) {

                                    double absiZ = (result - 0.07762) / 0.00441;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 15) {

                                    double absiZ = (result - 0.07701) / 0.00391;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 16) {

                                    double absiZ = (result - 0.07739) / 0.00399;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 17) {

                                    double absiZ = (result - 0.07714) / 0.00394;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 18) {

                                    double absiZ = (result - 0.07705) / 0.00413;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 19) {

                                    double absiZ = (result - 0.07743) / 0.00419;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 20) {

                                    double absiZ = (result - 0.07712) / 0.00465;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 21) {

                                    double absiZ = (result - 0.07786) / 0.00415;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 22) {

                                    double absiZ = (result - 0.07728) / 0.00430;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 23) {

                                    double absiZ = (result - 0.07726) / 0.00463;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 24) {

                                    double absiZ = (result - 0.07771) / 0.00490;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 25) {

                                    double absiZ = (result - 0.07699) / 0.00407;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 26) {

                                    double absiZ = (result - 0.07719) / 0.00543;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 27) {

                                    double absiZ = (result - 0.07756) / 0.00450;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 28) {

                                    double absiZ = (result - 0.07772) / 0.00468;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 29) {

                                    double absiZ = (result - 0.07744) / 0.00402;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 30) {

                                    double absiZ = (result - 0.07703) / 0.00421;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 31) {

                                    double absiZ = (result - 0.07714) / 0.00478;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 32) {

                                    double absiZ = (result - 0.07738) / 0.00484;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 33) {

                                    double absiZ = (result - 0.07786) / 0.00474;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 34) {

                                    double absiZ = (result - 0.07779) / 0.00459;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 35) {

                                    double absiZ = (result - 0.07756) / 0.00452;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 36) {

                                    double absiZ = (result - 0.07854) / 0.00425;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 37) {

                                    double absiZ = (result - 0.07815) / 0.00396;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 38) {

                                    double absiZ = (result - 0.07861) / 0.00500;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 39) {

                                    double absiZ = (result - 0.07779) / 0.00480;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 40) {

                                    double absiZ = (result - 0.07790) / 0.00462;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 41) {

                                    double absiZ = (result - 0.07892) / 0.00403;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 42) {

                                    double absiZ = (result - 0.07833) / 0.00463;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 43) {

                                    double absiZ = (result - 0.07882) / 0.00493;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 44) {

                                    double absiZ = (result - 0.07774) / 0.00498;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 45) {

                                    double absiZ = (result - 0.07860) / 0.00462;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 46) {

                                    double absiZ = (result - 0.07900) / 0.00386;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 47) {

                                    double absiZ = (result - 0.07916) / 0.00477;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 48) {

                                    double absiZ = (result - 0.07888) / 0.00542;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 49) {

                                    double absiZ = (result - 0.07978) / 0.00464;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 50) {

                                    double absiZ = (result - 0.07894) / 0.00506;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 51) {

                                    double absiZ = (result - 0.08039) / 0.00436;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 52) {

                                    double absiZ = (result - 0.08068) / 0.00471;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 53) {

                                    double absiZ = (result - 0.07941) / 0.00420;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 54) {

                                    double absiZ = (result - 0.08054) / 0.00541;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 55) {

                                    double absiZ = (result - 0.07872) / 0.00498;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 56) {

                                    double absiZ = (result - 0.08000) / 0.00566;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 57) {

                                    double absiZ = (result - 0.08025) / 0.00504;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 58) {

                                    double absiZ = (result - 0.08204) / 0.00491;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 59) {

                                    double absiZ = (result - 0.08038) / 0.00481;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 60) {

                                    double absiZ = (result - 0.08094) / 0.00514;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 61) {

                                    double absiZ = (result - 0.08183) / 0.00478;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 62) {

                                    double absiZ = (result - 0.08146) / 0.00448;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 63) {

                                    double absiZ = (result - 0.08226) / 0.00471;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 64) {

                                    double absiZ = (result - 0.08120) / 0.00556;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 65) {

                                    double absiZ = (result - 0.08148) / 0.00604;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 66) {

                                    double absiZ = (result - 0.08148) / 0.00566;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 67) {

                                    double absiZ = (result - 0.08283) / 0.00486;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 68) {

                                    double absiZ = (result - 0.08228) / 0.00544;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 69) {

                                    double absiZ = (result - 0.08209) / 0.00528;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 70) {

                                    double absiZ = (result - 0.08316) / 0.00485;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 71) {

                                    double absiZ = (result - 0.08394) / 0.00501;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 72) {

                                    double absiZ = (result - 0.08246) / 0.00563;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 73) {

                                    double absiZ = (result - 0.08495) / 0.00495;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 74) {

                                    double absiZ = (result - 0.08342) / 0.00443;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 75) {

                                    double absiZ = (result - 0.08276) / 0.00449;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 76) {

                                    double absiZ = (result - 0.08464) / 0.00501;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 77) {

                                    double absiZ = (result - 0.08539) / 0.00500;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 78) {

                                    double absiZ = (result - 0.08332) / 0.00611;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 79) {

                                    double absiZ = (result - 0.08376) / 0.00585;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 80) {

                                    double absiZ = (result - 0.08543) / 0.00598;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 81) {

                                    double absiZ = (result - 0.08406) / 0.00567;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 82) {

                                    double absiZ = (result - 0.08355) / 0.00641;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 83) {

                                    double absiZ = (result - 0.08542) / 0.00611;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 84) {

                                    double absiZ = (result - 0.08407) / 0.00484;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }

                                if (gender.equals("Women") && age == 85) {

                                    double absiZ = (result - 0.08533) / 0.00528;

                                    if (absiZ <  -0.868){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Very Low");
                                    }
                                    if (absiZ >=  -0.868 && absiZ <=  -0.272){
                                        det_TextView.setText(absiZ +"Your Mortality Risk is Low");
                                    }
                                    if (absiZ >=  -0.272 && absiZ <=  0.229){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Average");
                                    }
                                    if (absiZ >=  0.229 && absiZ <=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is High");
                                    }
                                    if (absiZ >=  0.798){
                                        det_TextView.setText(absiZ + "Your Mortality Risk is Very High");
                                    }


                                }





                            }
                        }



                    }
                }
        );
    }

}
