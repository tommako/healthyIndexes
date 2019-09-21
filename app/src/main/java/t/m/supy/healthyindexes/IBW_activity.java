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

public class IBW_activity extends AppCompatActivity {

    private static Button button_ibw;
    private static EditText weight_ET;
    private static TextView result_TextView;

    private static RadioGroup gender_RadioGr;
    private static RadioGroup method_RadioGr;
    private static RadioButton radio_b_gender;
    private static RadioButton radio_b_method;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibw_activity);
        CalculateIBW();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void CalculateIBW(){

        weight_ET = (EditText)findViewById(R.id.weigth_editText);

        result_TextView = (TextView)findViewById(R.id.result_textView);

        gender_RadioGr = (RadioGroup)findViewById(R.id.gender_radioGroup);
        method_RadioGr = (RadioGroup)findViewById(R.id.method_radioGroup);

        button_ibw = (Button)findViewById(R.id.ibw_button);

        button_ibw.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(weight_ET.getText().toString().isEmpty()){
                            Toast.makeText(IBW_activity.this, "You didn't imput weight necessary for calculation",
                                    Toast.LENGTH_SHORT).show();
                        }else {

                            int selected_id_gender = gender_RadioGr.getCheckedRadioButtonId();
                            radio_b_gender = (RadioButton)findViewById(selected_id_gender);
                            String gender = radio_b_gender.getText().toString();

                            int selected_id_method = method_RadioGr.getCheckedRadioButtonId();
                            radio_b_method = (RadioButton)findViewById(selected_id_method);
                            String method = radio_b_method.getText().toString();

                            double height = Double.parseDouble(weight_ET.getText().toString());
                            double heightInInches = height / 2.54;

                            if (gender.equals("Man") && method.equals("J. D. Robinson")){

                                double result = 52 + (1.9 * (heightInInches - 60));
                               // double resultInKg = result * 0.45359237;
                                //"Ideal Body Weight: " + result + " Kilograms"
                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Ideal Body Weight: " + resultInString + " Kilograms";
                                result_TextView.setText(resultToTextView);

                                //result_TextView.setText(Double.toString(Double.parseDouble(String.format("%.4f", result))));
                            }

                            if (gender.equals("Women")&& method.equals("J. D. Robinson")){

                                double result = 49 + (1.7 * (heightInInches - 60));
                                //"Ideal Body Weight: " + result + " Kilograms"
                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Ideal Body Weight: " + resultInString + " Kilograms";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Man")&& method.equals("D. R. Miller")){

                                double result = 56.2 + (1.41 * (heightInInches - 60));
                                //"Ideal Body Weight: " + result + " Kilograms"
                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Ideal Body Weight: " + resultInString + " Kilograms";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Women")&& method.equals("D. R. Miller")){

                                double result = 53.1 + (1.36 * (heightInInches - 60));
                                //"Ideal Body Weight: " + result + " Kilograms"
                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Ideal Body Weight: " + resultInString + " Kilograms";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Man")&& method.equals("G. J. Hamwi")){

                                double result = 48 + (2.7 * (heightInInches - 60));
                                //"Ideal Body Weight: " + result + " Kilograms"
                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Ideal Body Weight: " + resultInString + " Kilograms";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Women")&& method.equals("G. J. Hamwi")){

                                double result = 45.5 + (2.2 * (heightInInches - 60));
                                //"Ideal Body Weight: " + result + " Kilograms"
                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Ideal Body Weight: " + resultInString + " Kilograms";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Man")&& method.equals("B. J. Devine")){

                                double result = 50 + (2.3 * (heightInInches - 60));
                                //"Ideal Body Weight: " + result + " Kilograms"
                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Ideal Body Weight: " + resultInString + " Kilograms";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Women")&& method.equals("B. J. Devine")){

                                double result = 45.5 + (2.3 * (heightInInches - 60));
                                //"Ideal Body Weight: " + result + " Kilograms"
                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Ideal Body Weight: " + resultInString + " Kilograms";
                                result_TextView.setText(resultToTextView);

                            }

                           //if ( gender.equals("Man")|| gender.equals("Women") && method.equals("Body Mass Index")){
                            if (method.equals("Body Mass Index")){

                                double resultMin = (18.5 / 703)* Math.pow(heightInInches, 2);
                                double resultMax = (24.9 / 703)* Math.pow(heightInInches, 2);
                                double resultMinToKg = resultMin * 0.45359237;
                                double resultMaxToKg = resultMax * 0.45359237;
                                //"Ideal Body Weight: " + result + " Kilograms"
                                String resultInStringMin = Double.toString(Double.parseDouble(String.format("%.1f", resultMinToKg)));
                                String resultInStringMax = Double.toString(Double.parseDouble(String.format("%.1f", resultMaxToKg)));

                                String resultToTextView = "Ideal Body Weight is from " + resultInStringMin + " to " + resultInStringMax + " Kilograms";
                                result_TextView.setText(resultToTextView);

                            }



                        }
                    }
                }
        );

    }




}
