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

public class BFP_activity extends AppCompatActivity {

    private static EditText weight_ET;
    private static EditText height_ET;
    private static EditText age_ET;

    private static Button button_bfp;

    private static RadioGroup gender_RadioGr;

    private static RadioButton radio_b_gender;

    private static TextView result_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bfp_activity);
        CalculateBFP();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    //Adult from 20 years

    public void CalculateBFP(){

        weight_ET = (EditText)findViewById(R.id.weight_editText);
        height_ET = (EditText)findViewById(R.id.height_editText);
        age_ET = (EditText)findViewById(R.id.age_editText);

        result_TextView = (TextView)findViewById(R.id.result_textView);

        gender_RadioGr = (RadioGroup)findViewById(R.id.gender_radioGroup);

        button_bfp = (Button)findViewById(R.id.bfp_button);

        button_bfp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(weight_ET.getText().toString().isEmpty() || height_ET.getText().toString().isEmpty() || age_ET.getText().toString().isEmpty()) {
                            Toast.makeText(BFP_activity.this, "You didn't imput circumference, weight, age or hight necessary for calculation",
                                    Toast.LENGTH_SHORT).show();
                        } else {

                            double weight = Double.parseDouble(weight_ET.getText().toString());
                            double height = Double.parseDouble(height_ET.getText().toString());
                            double age = Double.parseDouble(age_ET.getText().toString());


                            int selected_id_gender = gender_RadioGr.getCheckedRadioButtonId();
                            radio_b_gender = (RadioButton)findViewById(selected_id_gender);
                            String gender = radio_b_gender.getText().toString();

                            double heightInMeter = height / 100;
                            double bmi = weight / Math.pow(heightInMeter, 2);

                            if(gender.equals("Man") || age <= 19){

                                double result = (1.51 * bmi) - (0.70 * age) - (3.6 * 1) + 1.4;
                                //double result = (1.20 * bmi) + (0.23 * age) - (10.8 * 1) - 5.4;

                                //BFP = (1.51 * BMI) − (0.70 * Age) − (3.6 * S) + 1.4

                                /*BFP Category	Women	Men
                                Essential Fat Percent	10-13%	2-5%
                                        Fat Percent for Athletes	14-20%	6-13%
                                        Fitness Level	21-24%	14-17%
                                        Average Level	24-31%	18-24%
                                        Obese Level	32% and above	25% and above*/
                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));

                                if(result >= 2 && result <= 5){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Essential");
                                }

                                if(result >= 6 && result <= 13){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Athletes");
                                }

                                if(result >= 14 && result <= 17){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Fitness");
                                }

                                if(result >= 18 && result <= 24){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Average");
                                }

                                if(result >= 25){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Obese");
                                }



                            }

                            if (gender.equals("Women") || age <= 19){

                                double result = (1.51 * bmi) - (0.70 * age) - (3.6 * 0) + 1.4;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));

                                if(result >= 10 && result <= 13){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Essential");
                                }

                                if(result >= 14 && result <= 20){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Athletes");
                                }

                                if(result >= 21 && result <= 24){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Fitness");
                                }

                                if(result >= 25 && result <= 31){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Average");
                                }

                                if(result >= 32){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Obese");
                                }


                            }


                            if(gender.equals("Man") || age >= 20){

                                //BFP = (1.20 * BMI) + (0.23 * Age) − (10.8 * S) − 5.4
                                double result = (1.20 * bmi) + (0.23 * age) - (10.8 * 1) - 5.4;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));

                                if(result >= 2 && result <= 5){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Essential");
                                }

                                if(result >= 6 && result <= 13){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Athletes");
                                }

                                if(result >= 14 && result <= 17){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Fitness");
                                }

                                if(result >= 18 && result <= 24){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Average");
                                }

                                if(result >= 25){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Obese");
                                }


                            }

                            if (gender.equals("Women") || age >= 20){

                                double result = (1.20 * bmi) + (0.23 * age) - (10.8 * 0) - 5.4;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));

                                if(result >= 10 && result <= 13){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Essential");
                                }

                                if(result >= 14 && result <= 20){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Athletes");
                                }

                                if(result >= 21 && result <= 24){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Fitness");
                                }

                                if(result >= 25 && result <= 31){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Average");
                                }

                                if(result >= 32){

                                    result_TextView.setText("Your Body Fat Percentage is " + resultInString + "%. You are in the BFP category of Obese");
                                }

                            }





                        }

                    }
                }
        );
    }

}
