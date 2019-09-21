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

public class WHR_activity extends AppCompatActivity {

    private static EditText waist_ET;
    private static EditText hip_ET;

    private static Button button_whr;

    private static RadioGroup gender_RadioGr;

    private static RadioButton radio_b_gender;

    private static TextView result_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whr_activity);
        CalculateWHR();
    }

    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void CalculateWHR(){

        waist_ET = (EditText)findViewById(R.id.waist_editText);
        hip_ET = (EditText)findViewById(R.id.hip_editText);

        result_TextView = (TextView)findViewById(R.id.result_textView);

        gender_RadioGr = (RadioGroup)findViewById(R.id.gender_radioGroup);

        button_whr = (Button)findViewById(R.id.whr_button);

        button_whr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(waist_ET.getText().toString().isEmpty() || hip_ET.getText().toString().isEmpty()){

                            Toast.makeText(WHR_activity.this, "You didn't imput weight or hight necessary for calculation",
                                    Toast.LENGTH_SHORT).show();

                        }else {

                           double waist = Double.parseDouble(waist_ET.getText().toString());
                           double hip = Double.parseDouble(hip_ET.getText().toString());

                            int selected_id_gender = gender_RadioGr.getCheckedRadioButtonId();
                            radio_b_gender = (RadioButton)findViewById(selected_id_gender);
                            String gender = radio_b_gender.getText().toString();

                            double result = waist / hip;

                            if(gender.equals("Men") && result < 0.90){

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));
                                String resultToTextView = "Your Waist-Hip Ratio is " + resultInString + " Congrats!! You are Pear Shaped, Normal with Low risk of developing health conditions.";
                                result_TextView.setText(resultToTextView);

                            }

                            if(gender.equals("Men") && result >= 0.90 && result <= 0.95){

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));
                                String resultToTextView = "Your Waist-Hip Ratio is " + resultInString + " You are slightly Apple Shaped, Moderate Obese with Moderate risk of developing health conditions.";
                                result_TextView.setText(resultToTextView);

                            }

                            if(gender.equals("Men") && result > 0.95){

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));
                                String resultToTextView = "Your Waist-Hip Ratio is " + resultInString + " You are Apple Shaped, Obese with High risk of developing serious health conditions.";
                                result_TextView.setText(resultToTextView);


                            }

                            if(gender.equals("Women") && result < 0.85){

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));
                                String resultToTextView = "Your Waist-Hip Ratio is " + resultInString + " Congrats!! You are Pear Shaped, Normal with Low risk of developing health conditions..";
                                result_TextView.setText(resultToTextView);

                            }

                            if(gender.equals("Women") && result >= 0.85 && result <= 0.90){

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));
                                String resultToTextView = "Your Waist-Hip Ratio is " + resultInString + " You are slightly Apple Shaped, Moderate Obese with Moderate risk of developing health conditions.";
                                result_TextView.setText(resultToTextView);

                            }

                            if(gender.equals("Women") && result > 0.90){

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));
                                String resultToTextView = "Your Waist-Hip Ratio is " + resultInString + " You are Apple Shaped, Obese with High risk of developing serious health conditions.";
                                result_TextView.setText(resultToTextView);

                            }

                        }

                    }
                }
        );

    }


    //waist / hip in cm

   /* Waist-Hip Ratio Cut-Off Points (Range)
    Men	Women	Body Shape	Risk Level
    Less than 0.90	Less than 0.85	Pear	Low risk of metabolic complications
    Between 0.90 and 0.95	Between 0.85 and 0.90	Apple	Moderate risk of metabolic complications like diabetes, heart disease, stroke, etc..
    Above 0.95	Above 0.90	Apple	High risk of metabolic complications like diabetes, heart disease, stroke, etc..*/
}
