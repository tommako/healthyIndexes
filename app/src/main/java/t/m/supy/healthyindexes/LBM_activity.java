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

public class LBM_activity extends AppCompatActivity {

    private static EditText weight_ET;
    private static EditText height_ET;

    private static Button button_lbm;

    private static RadioGroup gender_RadioGr;
    private static RadioGroup formula_RadioGr;

    private static RadioButton radio_b_gender;
    private static RadioButton radio_b_formula;

    private static TextView result_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbm_activity);
        CalculateLBM();
    }

    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void CalculateLBM(){

        weight_ET = (EditText)findViewById(R.id.weight_editText);
        height_ET = (EditText)findViewById(R.id.height_editText);

        result_TextView = (TextView)findViewById(R.id.result_textView);

        gender_RadioGr = (RadioGroup)findViewById(R.id.gender_radioGroup);
        formula_RadioGr = (RadioGroup)findViewById(R.id.formula_radioGroup);

        button_lbm = (Button)findViewById(R.id.lbm_button);

        button_lbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (weight_ET.getText().toString().isEmpty() || height_ET.getText().toString().isEmpty()){
                            Toast.makeText(LBM_activity.this, "You didn't imput weight or hight necessary for calculation",
                                    Toast.LENGTH_SHORT).show();
                        }else {

                            double weight = Double.parseDouble(weight_ET.getText().toString());
                            double height = Double.parseDouble(height_ET.getText().toString());

                            int selected_id_gender = gender_RadioGr.getCheckedRadioButtonId();
                            radio_b_gender = (RadioButton)findViewById(selected_id_gender);
                            String gender = radio_b_gender.getText().toString();

                            int selected_id_formula = formula_RadioGr.getCheckedRadioButtonId();
                            radio_b_formula = (RadioButton)findViewById(selected_id_formula);
                            String formula = radio_b_formula.getText().toString();

                            if (gender.equals("Man") && formula.equals("W.P.T. James's")){

                                double result = (1.1 * weight) - 128 * ( Math.pow(weight, 2)/Math.pow(height, 2));

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Lean Body Mass: " + resultInString + " Kilograms (Kg).";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Woman") && formula.equals("W.P.T. James's")){

                                double result = (1.07 * weight) - 148 * ( Math.pow(weight, 2)/Math.pow(height, 2));

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Lean Body Mass: " + resultInString + " Kilograms (Kg).";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Man") && formula.equals("R. Hume's")){

                                double result = (0.3281 * weight) + (0.33929 * height) - 29.5336;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Lean Body Mass: " + resultInString + " Kilograms (Kg).";
                                result_TextView.setText(resultToTextView);

                            }

                            if (gender.equals("Woman") && formula.equals("R. Hume's")){

                                double result = (0.29569 * weight) + (0.41813 * height) - 43.2933;

                                String resultInString = Double.toString(Double.parseDouble(String.format("%.1f", result)));
                                String resultToTextView = "Lean Body Mass: " + resultInString + " Kilograms (Kg).";
                                result_TextView.setText(resultToTextView);

                            }

                           /* Formulas To Calculate Lean Body Mass
                            1. W.P.T. James's Formula :
                            LBM (For Men) = (1.1 x Wt) – 128 x ( Wt2/Ht2)
                            LBM (For Women) = (1.07 x Wt) – 148 x ( Wt2/Ht2)
                            LBM = Lean Body Mass in Kilograms (Kg).
                                    Wt = Body Weight in Kilograms (Kg).
                                    Ht = Body Height in Centimeters (cm).

                            2. R. Hume's Formula :
                            LBM (For Men) = (0.3281 x Wt) + (0.33929 x Ht) - 29.5336
                            LBM (For Women) = (0.29569 x Wt) + (0.41813 x Ht) - 43.2933
                            */

                        }

                    }
                }
        );

    }
}
