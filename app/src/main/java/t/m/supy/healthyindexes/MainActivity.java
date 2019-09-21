package t.m.supy.healthyindexes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static Button bmi_button;
    private static Button bai_button;
    private static Button absi_button;
    private static Button ibw_button;
    private static Button bfp_button;
    private static Button bmr_button;
    private static Button tdee_button;
    private static Button lbm_button;
    private static Button whr_button;
    private static Button pcf_button;

    //private static Button info_button;
    private static Button info_bmi;
    private static Button info_absi;
    private static Button info_bai;
    private static Button info_bfp;
    private static Button info_bmr;
    private static Button info_ibw;
    private static Button info_lbm;
    private static Button info_pcf;
    private static Button info_tdee;
    private static Button info_whr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BMI_act();
        BAI_act();
        ABSI_act();
        IBW_act();
        BFP_act();
        BMR_act();
        TDEE_act();
        //Info_Button();
        LBM_act();
        WHR_act();
        PCF_act();
        info_BMI();
        info_ABSI();
        info_BAI();
        info_BFP();
        info_BMR();
        info_IBW();
        info_LBM();
        info_PCF();
        info_TDEE();
        info_WHR();
    }


    public void info_WHR(){

        info_whr = (Button)findViewById(R.id.infoWHR);

        info_whr.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.WHR_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void info_TDEE(){

        info_tdee = (Button)findViewById(R.id.infoTDEE);

        info_tdee.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.TDEE_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void info_PCF(){

        info_pcf = (Button)findViewById(R.id.infoPCF);

        info_pcf.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.PCF_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void info_LBM(){

        info_lbm = (Button)findViewById(R.id.infoLBM);

        info_lbm.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.LBM_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void info_IBW(){

        info_ibw = (Button)findViewById(R.id.infoIBW);

        info_ibw.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.IBW_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void info_BMR(){

        info_bmr = (Button)findViewById(R.id.infoBMR);

        info_bmr.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.BMR_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void info_BFP(){

        info_bfp = (Button)findViewById(R.id.infoBFP);

        info_bfp.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.BFP_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void info_BAI(){

        info_bai = (Button)findViewById(R.id.infoBAI);

        info_bai.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.BAI_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void info_ABSI(){

        info_absi = (Button)findViewById(R.id.infoABSI);

        info_absi.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.ABSI_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void info_BMI(){

        info_bmi = (Button)findViewById(R.id.infoBMI);

        info_bmi.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.BMI_info_activity");
                        startActivity(intent);
                    }
                }
        );

    }


   /* public void Info_Button(){

        info_button = (Button)findViewById(R.id.infoButton);

        info_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                        //View mView = getLayoutInflater().inflate(R.layout.dialog_info, null);
                        mBuilder.setTitle("thi is tytle");
                        mBuilder.setMessage("this is message");
                        mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss();

                            }
                        });
                        //mBuilder.setView(mView);
                        AlertDialog dialog = mBuilder.create();
                        dialog.show();
                    }
                }
        );
    }*/

    public void BMI_act(){

        bmi_button =(Button)findViewById(R.id.bmi_button);

        bmi_button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.BMI_activity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void BAI_act(){

        bai_button =(Button)findViewById(R.id.bai_button);

        bai_button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public  void onClick(View v){
                        Intent intent = new Intent("t.m.supy.healthyindexes.BAI_activity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void ABSI_act(){

        absi_button =(Button)findViewById(R.id.absi_button);

        absi_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("t.m.supy.healthyindexes.ABSI_activity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void IBW_act(){

        ibw_button =(Button)findViewById(R.id.ibw_button);

        ibw_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("t.m.supy.healthyindexes.IBW_activity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void BFP_act(){

        bfp_button = (Button)findViewById(R.id.bfp_button);

        bfp_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("t.m.supy.healthyindexes.BFP_activity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void BMR_act(){

        bmr_button = (Button)findViewById(R.id.bmr_button);

        bmr_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("t.m.supy.healthyindexes.BMR_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void TDEE_act(){

        tdee_button = (Button)findViewById(R.id.tdee_button);

        tdee_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("t.m.supy.healthyindexes.TDEE_activity");
                        startActivity(intent);
                    }
                }
        );

    }

    public void LBM_act(){

        lbm_button = (Button)findViewById(R.id.lbm_button);

        lbm_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("t.m.supy.healthyindexes.LBM_activity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void WHR_act(){

        whr_button = (Button)findViewById(R.id.whr_button);

        whr_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("t.m.supy.healthyindexes.WHR_activity");
                        startActivity(intent);
                    }
                }
        );
    }

    public void PCF_act(){

        pcf_button = (Button)findViewById(R.id.pcf_button);

        pcf_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("t.m.supy.healthyindexes.PCF_activity");
                        startActivity(intent);
                    }
                }
        );
    }

}
