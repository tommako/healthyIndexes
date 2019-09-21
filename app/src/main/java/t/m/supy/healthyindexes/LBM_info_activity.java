package t.m.supy.healthyindexes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class LBM_info_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbm_info_activity);

        linkOpen();
    }

    public void linkOpen(){

        TextView link = (TextView)findViewById(R.id.link_lbm_textView);
        link.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
