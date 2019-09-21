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

public class BAI_activity extends AppCompatActivity {

    private static Button button_bai;
    private static RadioGroup radioGr;
    private static RadioButton radio_b;
    private static EditText circumference_ET;
    private static EditText hight_ET;
    private static EditText age_ET;
    private static TextView result_TextView;
    private static TextView det_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_activity);
        Calculate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void Calculate() {

        circumference_ET = (EditText) findViewById(R.id.circumference_editText);
        hight_ET = (EditText) findViewById(R.id.hight_editText);
        age_ET = (EditText) findViewById(R.id.Age_editText);
        result_TextView = (TextView) findViewById(R.id.result_textView);
        det_TextView = (TextView) findViewById(R.id.detail_textView);

        button_bai = (Button) findViewById(R.id.bai_button);

        radioGr = (RadioGroup) findViewById(R.id.radioGroup);

        //double circumference = Double.parseDouble(circumference_ET.getText().toString());
        //double hight = Double.parseDouble(hight_ET.getText().toString());
        //double age = Double.parseDouble(age_ET.getText().toString());

        //double resutlt = (circumference / Math.pow(hight, 1.5))-18;

        button_bai.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (circumference_ET.getText().toString().isEmpty() || hight_ET.getText().toString().isEmpty()) {

                            Toast.makeText(BAI_activity.this, "You didn't imput circumference or hight necessary for calculation",
                                    Toast.LENGTH_SHORT).show();

                        } else {

                            double circumference = Double.parseDouble(circumference_ET.getText().toString());
                            double height = Double.parseDouble(hight_ET.getText().toString());
                            double heightToMeters = height / 100;
                            double age = Double.parseDouble(age_ET.getText().toString());


                            double result = (circumference / Math.pow(heightToMeters, 1.5)) - 18;
                            //double result = circumference + hight;

                            if(age <= 19){
                                Toast.makeText(BAI_activity.this, "Your age isn't from 20 to 79 include ",
                                        Toast.LENGTH_SHORT).show();
                            }else {

                                result_TextView.setText(Double.toString(Double.parseDouble(String.format("%.2f", result))));

                                int selected_id = radioGr.getCheckedRadioButtonId();
                                radio_b = (RadioButton) findViewById(selected_id);
                                String gender = radio_b.getText().toString();


                                //BAI for women

                                //Age from 20 to 39

                                if (age >= 20 && age <= 39 && gender.equals("Women") && result < 21) {
                                    det_TextView.setText("Underweight");

                                }

                                if (age >= 20 && age <= 39 && gender.equals("Women") && result >= 21 && result <= 33) {
                                    det_TextView.setText("Healthy");

                                }

                                if (age >= 20 && age <= 39 && gender.equals("Women") && result > 33 && result <= 39) {
                                    det_TextView.setText("Overweight");

                                }

                                if (age >= 20 && age <= 39 && gender.equals("Women") && result > 39) {
                                    det_TextView.setText("Obese");

                                }

                                //Age from 40 to 59

                                if (age >= 40 && age <= 59 && gender.equals("Women") && result < 23) {
                                    det_TextView.setText("Underweight");

                                }

                                if (age >= 40 && age <= 59 && gender.equals("Women") && result >= 23 && result <= 35) {
                                    det_TextView.setText("Healthy");

                                }

                                if (age >= 40 && age <= 59 && gender.equals("Women") && result > 35 && result <= 40) {
                                    det_TextView.setText("Overweight");

                                }

                                if (age >= 40 && age <= 59 && gender.equals("Women") && result > 41) {
                                    det_TextView.setText("Obese");

                                }

                                //Age from 60 to 79

                                if (age >= 20 && age <= 39 && gender.equals("Women") && result < 25) {
                                    det_TextView.setText("Underweight");

                                }

                                if (age >= 20 && age <= 39 && gender.equals("Women") && result >= 25 && result <= 38) {
                                    det_TextView.setText("Healthy");

                                }

                                if (age >= 20 && age <= 39 && gender.equals("Women") && result > 38 && result <= 42) {
                                    det_TextView.setText("Overweight");

                                }

                                if (age >= 20 && age <= 39 && gender.equals("Women") && result > 43) {
                                    det_TextView.setText("Obese");

                                }


                                //BAI for men

                                //Age from 20 to 39

                                if (age >= 20 && age <= 39 && gender.equals("Man") && result < 8) {
                                    det_TextView.setText("Underweight");

                                }

                                if (age >= 20 && age <= 39 && gender.equals("Man") && result >= 8 && result <= 21) {
                                    det_TextView.setText("Healthy");

                                }

                                if (age >= 20 && age <= 39 && gender.equals("Man") && result > 21 && result <= 26) {
                                    det_TextView.setText("Overweight");

                                }

                                if (age >= 20 && age <= 39 && gender.equals("Man") && result > 26) {
                                    det_TextView.setText("Obese");

                                }

                                //Age from 40 to 59

                                if (age >= 40 && age <= 59 && gender.equals("Man") && result < 11) {
                                    det_TextView.setText("Underweight");

                                }

                                if (age >= 40 && age <= 59 && gender.equals("Man") && result >= 11 && result <= 23) {
                                    det_TextView.setText("Healthy");

                                }

                                if (age >= 40 && age <= 59 && gender.equals("Man") && result > 23 && result <= 29) {
                                    det_TextView.setText("Overweight");

                                }

                                if (age >= 40 && age <= 59 && gender.equals("Man") && result > 29) {
                                    det_TextView.setText("Obese");

                                }

                                //Age from 60 to 79

                                if (age >= 60 && age <= 79 && gender.equals("Man") && result < 13) {
                                    det_TextView.setText("Underweight");

                                }

                                if (age >= 60 && age <= 79 && gender.equals("Man") && result >= 13 && result <= 25) {
                                    det_TextView.setText("Healthy");

                                }

                                if (age >= 60 && age <= 79 && gender.equals("Man") && result > 25 && result <= 31) {
                                    det_TextView.setText("Overweight");

                                }

                                if (age >= 60 && age <= 79 && gender.equals("Man") && result > 31) {
                                    det_TextView.setText("Obese");

                                }
                            }
                        }
                    }
                }
        );
    }
}


