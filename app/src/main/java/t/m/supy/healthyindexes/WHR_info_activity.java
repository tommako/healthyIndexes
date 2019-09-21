package t.m.supy.healthyindexes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class WHR_info_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whr_info_activity);

        linkOpen();
    }

    public void linkOpen(){

        TextView link = (TextView)findViewById(R.id.link_whr_textView);
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
