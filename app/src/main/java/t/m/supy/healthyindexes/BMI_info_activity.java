package t.m.supy.healthyindexes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class BMI_info_activity extends AppCompatActivity {

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_info_activity);

        //TextView link = (TextView)findViewById(R.id.link_textView);
        //link.setMovementMethod(LinkMovementMethod.getInstance());

        linkOpen();
    }

    public void linkOpen(){

        TextView link = (TextView)findViewById(R.id.link_absi_textView);
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
