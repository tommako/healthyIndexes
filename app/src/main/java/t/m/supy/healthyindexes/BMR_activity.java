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

public class BMR_activity extends AppCompatActivity {

    private static EditText weight_ET;
    private static EditText height_ET;
    private static EditText age_ET;

    private static RadioGroup gender_RadioGr;
    private static RadioGroup equation_RadioGr;

    private static RadioButton radio_b_gender;
    //private static RadioButton radio_b_equation;

    private static TextView result_TextView;

    private static Button button_bmr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_activity);
        CalculateBMR();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void CalculateBMR(){

        weight_ET = (EditText)findViewById(R.id.weight_editText);
        height_ET = (EditText)findViewById(R.id.height_editText);
        age_ET = (EditText)findViewById(R.id.age_editText);

        result_TextView = (TextView)findViewById(R.id.result_textView);

        gender_RadioGr = (RadioGroup)findViewById(R.id.gender_radioGroup);
        //equation_RadioGr = (RadioGroup)findViewById(R.id.equation_radioGroup);

        button_bmr = (Button)findViewById(R.id.bmr_button);

        button_bmr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (weight_ET.getText().toString().isEmpty() || height_ET.getText().toString().isEmpty() || age_ET.getText().toString().isEmpty()) {
                            Toast.makeText(BMR_activity.this, "You didn't imput circumference, weight, age or hight necessary for calculation",
                                    Toast.LENGTH_SHORT).show();

                        }else {

                            double weight = Double.parseDouble(weight_ET.getText().toString());
                            double height = Double.parseDouble(height_ET.getText().toString());
                            double age = Double.parseDouble(age_ET.getText().toString());

                            int selected_id_gender = gender_RadioGr.getCheckedRadioButtonId();
                            radio_b_gender = (RadioButton)findViewById(selected_id_gender);
                            String gender = radio_b_gender.getText().toString();

                            /*int selected_id_equation = equation_RadioGr.getCheckedRadioButtonId();
                            radio_b_equation = (RadioButton)findViewById(selected_id_equation);
                            String equation = radio_b_equation.getText().toString();
                            equation.equals("Mifflin St Jeor"*/

                            if(gender.equals("Man")){

                                double result = (10 * weight) + (6.25 * height) - (5 * age) + 5;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));

                                result_TextView.setText("Your Basal Metabolic Rate (BMR) is " + resultInString + "Kcal/day. i.e. your body burns " +
                                        resultInString + " Kcal a day, just for performing its basis functions like breathing, cell growth, blood circulation, etc...");
                                        //Daily Calorie Requirement or Total Daily Energy Expenditure (TDEE) here... ⇒Daily Calorie Needs⇐

                            }

                            if(gender.equals("Woman")){

                                double result = (10 * weight) + (6.25 * height) - (5 * age) - 161;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));

                                result_TextView.setText("Your Basal Metabolic Rate (BMR) is " + resultInString + "Kcal/day. i.e. your body burns " + resultInString + " Kcal a day, just for performing its basis functions like breathing, cell growth, blood circulation, etc...");



                            }

                           /* if(gender.equals("Man") || equation.equals("Harris-Benedict")){

                                double result = (13.397 * weight) + (4.799 * height) - (5.677 * age) + 88.362;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));

                                result_TextView.setText("Your Basal Metabolic Rate (BMR) is " + resultInString + "Kcal/day. i.e. your body burns " + resultInString + " Kcal a day, just for performing its basis functions like breathing, cell growth, blood circulation, etc...");



                            }

                            if(gender.equals("Woman") || equation.equals("Harris-Benedict")){

                                double result = (9.247 * weight) + (3.098 * height) - (4.330 * age) + 447.593;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.2f", result)));

                                result_TextView.setText("Your Basal Metabolic Rate (BMR) is " + resultInString + "Kcal/day. i.e. your body burns " + resultInString + " Kcal a day, just for performing its basis functions like breathing, cell growth, blood circulation, etc...");



                            }*/

                        }

                    }
                }
        );

    }

}
