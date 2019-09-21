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

public class PCF_activity extends AppCompatActivity {

    private static EditText weight_ET;
    private static EditText height_ET;
    private static EditText age_ET;

    private static Button button_pcf;

    private static RadioGroup gender_RadioGr;
    private static RadioGroup activity_RadioGr;

    private static RadioButton radio_b_gender;
    private static RadioButton radio_b_activity;

    private static TextView result_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcf_activity);
        CalculatePCF();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void CalculatePCF(){

        weight_ET = (EditText)findViewById(R.id.weight_editText);
        height_ET = (EditText)findViewById(R.id.height_editText);
        age_ET = (EditText)findViewById(R.id.age_editText);

        result_TextView = (TextView)findViewById(R.id.result_textView);

        gender_RadioGr = (RadioGroup)findViewById(R.id.gender_radioGroup);
        activity_RadioGr = (RadioGroup)findViewById(R.id.activity_radioGroup);

        button_pcf = (Button)findViewById(R.id.pcf_button);

        button_pcf.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (weight_ET.getText().toString().isEmpty() || weight_ET.getText().toString().isEmpty() ||
                                age_ET.getText().toString().isEmpty()){
                            Toast.makeText(PCF_activity.this, "You didn't imput weight, age or hight necessary for calculation",
                                    Toast.LENGTH_SHORT).show();
                        }else {

                            double weight = Double.parseDouble(weight_ET.getText().toString());
                            double height = Double.parseDouble(height_ET.getText().toString());
                            double age = Double.parseDouble(age_ET.getText().toString());

                            int selected_id_gender = gender_RadioGr.getCheckedRadioButtonId();
                            radio_b_gender = (RadioButton) findViewById(selected_id_gender);
                            String gender = radio_b_gender.getText().toString();

                            int selected_id_activity = activity_RadioGr.getCheckedRadioButtonId();
                            radio_b_activity = (RadioButton) findViewById(selected_id_activity);
                            String activity = radio_b_activity.getText().toString();

                            //double MenBMR = (10 * weight) +(6.25 * height) - (5 * age) + 5;

                            if (gender.equals("Man") && activity.equals("Sedentary")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) + 5;
                                double TDEE = BMR * 1.30;

                               /* Carbohydrates	45% to 65%	  4 Cal/gm
                                Protein	10% to 35%	          4 Cal/gm
                                Fat	20% to 35%	              9 Cal/gm*/

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Man") && activity.equals("Lighty Active")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) + 5;
                                double TDEE = BMR * 1.55;

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Man") && activity.equals("Moderately Active")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) + 5;
                                double TDEE = BMR * 1.65;

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);
                            }

                            if (gender.equals("Man") && activity.equals("Very Active")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) + 5;
                                double TDEE = BMR * 1.80;

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);
                            }

                            if (gender.equals("Man") && activity.equals("Extremely Active")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) + 5;
                                double TDEE = BMR * 2.00;

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);
                            }

                            if (gender.equals("Women") && activity.equals("Sedentary")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) - 161;
                                double TDEE = BMR * 1.30;

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Women") && activity.equals("Lighty Active")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) - 161;
                                double TDEE = BMR * 1.55;

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);

                            }


                            if (gender.equals("Women") && activity.equals("Moderately Active")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) - 161;
                                double TDEE = BMR * 1.65;

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);


                            }

                            if (gender.equals("Women") && activity.equals("Very Active")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) - 161;
                                double TDEE = BMR * 1.80;

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);


                            }

                            if (gender.equals("Women") && activity.equals("Extremely Active")) {

                                double BMR = (10 * weight) + (6.25 * height) - (5 * age) - 161;
                                double TDEE = BMR * 2.00;

                                Double CarbohydratesFrom = (0.45 * TDEE) / 4;
                                Double CarbohydratesTo = (0.65 * TDEE) / 4;
                                Double ProteinFrom = (0.10 * TDEE) / 4;
                                Double ProteinTo = (0.35 * TDEE) / 4;
                                Double FatFrom = (0.20 * TDEE) / 9;
                                Double FatTo = (0.35 * TDEE) / 9;

                                String resultInStringCarbohydratesFrom = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesFrom)));
                                String resultInStringCarbohydratesTo = Double.toString(Double.parseDouble(String.format("%.1f", CarbohydratesTo)));
                                String resultInStringProteinFrom = Double.toString(Double.parseDouble(String.format("%.1f", ProteinFrom)));
                                String resultInStringProteinTo = Double.toString(Double.parseDouble(String.format("%.1f", ProteinTo)));
                                String resultInStringFatFrom = Double.toString(Double.parseDouble(String.format("%.1f", FatFrom)));
                                String resultInStringFatTo = Double.toString(Double.parseDouble(String.format("%.1f", FatTo)));
                                String resultToTextView = "Your daily energy expenditure is: " + TDEE + " Cal/Day. For hold your weight you need Protein:" +
                                        "from " + resultInStringProteinFrom + " to " + resultInStringProteinTo + ". Carbohydrates you need from: " + resultInStringCarbohydratesFrom + " " +
                                        " to " + resultInStringCarbohydratesTo + " and Fat from " + resultInStringFatFrom + " to " + resultInStringFatTo + " .";
                                result_TextView.setText(resultToTextView);


                            }
                        }
                    }
                }
        );

    }


}
