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

public class TDEE_activity extends AppCompatActivity {

    private static EditText weight_ET;
    private static EditText height_ET;
    private static EditText age_ET;

    private static Button button_tdee;

    private static RadioGroup gender_RadioGr;
    private static RadioGroup activity_RadioGr;

    private static RadioButton radio_b_gender;
    private static RadioButton radio_b_activity;

    private static TextView result_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdee_activity);
        CalculateTDEE();
    }

    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void CalculateTDEE(){

        weight_ET = (EditText)findViewById(R.id.weight_editText);
        height_ET = (EditText)findViewById(R.id.height_editText);
        age_ET = (EditText)findViewById(R.id.age_editText);

        result_TextView = (TextView)findViewById(R.id.result_textView);

        gender_RadioGr = (RadioGroup)findViewById(R.id.gender_radioGroup);
        activity_RadioGr = (RadioGroup)findViewById(R.id.activity_radioGroup);

        button_tdee = (Button)findViewById(R.id.tdee_button);

        button_tdee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(weight_ET.getText().toString().isEmpty() || height_ET.getText().toString().isEmpty() ||
                                age_ET.getText().toString().isEmpty()){
                            Toast.makeText(TDEE_activity.this, "You didn't imput weight, age or hight necessary for calculation",
                                    Toast.LENGTH_SHORT).show();
                        }else {

                            double weight = Double.parseDouble(weight_ET.getText().toString());
                            double height = Double.parseDouble(height_ET.getText().toString());
                            double age = Double.parseDouble(age_ET.getText().toString());

                            int selected_id_gender = gender_RadioGr.getCheckedRadioButtonId();
                            radio_b_gender = (RadioButton)findViewById(selected_id_gender);
                            String gender = radio_b_gender.getText().toString();

                            int selected_id_activity = activity_RadioGr.getCheckedRadioButtonId();
                            radio_b_activity = (RadioButton)findViewById(selected_id_activity);
                            String activity = radio_b_activity.getText().toString();

                            if (gender.equals("Man") && activity.equals("Sedentary")){

                                double result = 1.2 * ((13.75 * weight) + (5 * height) - (6.76 * age) + 66);

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Sedentary person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Man") && activity.equals("Lighty Active")){

                                double result = 1.375 * ((13.75 * weight) + (5 * height) - (6.76 * age) + 66);

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Lightly Active person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);


                            }

                            if (gender.equals("Man") && activity.equals("Moderately Active")){

                                double result = 1.55 * ((13.75 * weight) + (5 * height) - (6.76 * age) + 66);

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Moderately Active person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Man") && activity.equals("Very Active")){

                                double result = 1.725 * ((13.75 * weight) + (5 * height) - (6.76 * age) + 66);

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Very Active person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Man") && activity.equals("Extremely Active")){

                                double result = 1.9 * ((13.75 * weight) + (5 * height) - (6.76 * age) + 66);

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Extremely Active person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);

                            }

                            //Woman

                            if (gender.equals("Woman") && activity.equals("Sedentary")){

                                double result = 1.2 * ((9.56 * weight) + (1.85 * height) - 4.68 * age) + 655;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Sedentary person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Woman") && activity.equals("Lighty Active")){

                                double result = 1.375 * ((9.56 * weight) + (1.85 * height) - 4.68 * age) + 655;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Lightly Active person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);


                            }

                            if (gender.equals("Woman") && activity.equals("Moderately Active")){

                                double result = 1.55 * ((9.56 * weight) + (1.85 * height) - 4.68 * age) + 655;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Moderately Active person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Woman") && activity.equals("Very Active")){

                                double result = 1.725 * ((9.56 * weight) + (1.85 * height) - 4.68 * age) + 655;


                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Very Active person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Woman") && activity.equals("Extremely Active")){

                                double result = 1.9 * ((9.56 * weight) + (1.85 * height) - 4.68 * age) + 655;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "As a Extremely Active person, you need: " + resultInString + " Kcal a day, for maintaining your current body weight.";
                                result_TextView.setText(resultToTextView);

                            }

                        }

                    }
                }
        );

    }

    /*
    Male (metric): DCE = ALF x ((13.75 x WKG) + (5 x HC) - (6.76 x age) + 66)
    Male (imperial): DCE = ALF x ((6.25 x WP) + (12.7 x HI) - (6.76 x age) + 66)
    Female (metric): DCE = ALF x ((9.56 x WKG) + (1.85 x HC) - 4.68 x age) + 655)
    Female (imperial): DCE = ALF x ((4.35 x WP) + (4.7 x HI) - 4.68 x age) + 655)
    where

            ALF = Activity Level Factor
    DCE = Daily Caloric Expenditure
            HC = Height in Centimetres
    HI = Height in Inches
            WKG = Weight in Kilograms
    WP = Weight in Pounds

    and "Activity Level Factor" has the following values

    "Sedentary": Activity Level Factor = 1.2
            "Lightly Active": Activity Level Factor = 1.375
            "Moderately Active": Activity Level Factor = 1.55
            "Very Active": Activity Level Factor = 1.725
            "Extremely Active": Activity Level Factor = 1.9
            */
}
