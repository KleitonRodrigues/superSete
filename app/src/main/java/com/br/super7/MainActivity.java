package com.br.super7;

import com.google.android.gms.ads.AdRequest;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.NavigationUI;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private TextView lbl_Col1_0, lbl_Col1_1, lbl_Col1_2, lbl_Col1_3, lbl_Col1_4, lbl_Col1_5, lbl_Col1_6, lbl_Col1_7, lbl_Col1_8, lbl_Col1_9;
    private TextView lbl_Col2_0, lbl_Col2_1, lbl_Col2_2, lbl_Col2_3, lbl_Col2_4, lbl_Col2_5, lbl_Col2_6, lbl_Col2_7, lbl_Col2_8, lbl_Col2_9;
    private TextView lbl_Col3_0, lbl_Col3_1, lbl_Col3_2, lbl_Col3_3, lbl_Col3_4, lbl_Col3_5, lbl_Col3_6, lbl_Col3_7, lbl_Col3_8, lbl_Col3_9;
    private TextView lbl_Col4_0, lbl_Col4_1, lbl_Col4_2, lbl_Col4_3, lbl_Col4_4, lbl_Col4_5, lbl_Col4_6, lbl_Col4_7, lbl_Col4_8, lbl_Col4_9;
    private TextView lbl_Col5_0, lbl_Col5_1, lbl_Col5_2, lbl_Col5_3, lbl_Col5_4, lbl_Col5_5, lbl_Col5_6, lbl_Col5_7, lbl_Col5_8, lbl_Col5_9;
    private TextView lbl_Col6_0, lbl_Col6_1, lbl_Col6_2, lbl_Col6_3, lbl_Col6_4, lbl_Col6_5, lbl_Col6_6, lbl_Col6_7, lbl_Col6_8, lbl_Col6_9;
    private TextView lbl_Col7_0, lbl_Col7_1, lbl_Col7_2, lbl_Col7_3, lbl_Col7_4, lbl_Col7_5, lbl_Col7_6, lbl_Col7_7, lbl_Col7_8, lbl_Col7_9, lblJogo;
    private Button btnJogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        lblJogo = (TextView)findViewById(R.id.txtJogo);
        lblJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copiarJogo();
            }
        });
                // inicio banner
        AdView mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-2381321693293442/4240224268");
        mAdView = findViewById(R.id.adView_home);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        // final banner
        //
        btnJogo = (Button) findViewById(R.id.btnNovo);
        btnJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(5000, 500) {
                    public void onTick(long millisUntilFinished) {
                        allBlack();
                        if(lblJogo.getText() != ""){
                            lblJogo.setText("Carregando...");
                        }
                        btnJogo.setText("Carregando...");
                    }

                    public void onFinish() {
                        gerarJogo();
                        btnJogo.setText(" Gerar Jogo ");
                    }
                }.start();

            }
        });

        ///
        // coluna 1
        lbl_Col1_0 = (TextView)findViewById(R.id.txt_Linha0_1);
        lbl_Col1_1 = (TextView)findViewById(R.id.txt_Linha1_1);
        lbl_Col1_2 = (TextView)findViewById(R.id.txt_Linha2_1);
        lbl_Col1_3 = (TextView)findViewById(R.id.txt_Linha3_1);
        lbl_Col1_4 = (TextView)findViewById(R.id.txt_Linha4_1);
        lbl_Col1_5 = (TextView)findViewById(R.id.txt_Linha5_1);
        lbl_Col1_6 = (TextView)findViewById(R.id.txt_Linha6_1);
        lbl_Col1_7 = (TextView)findViewById(R.id.txt_Linha7_1);
        lbl_Col1_8 = (TextView)findViewById(R.id.txt_Linha8_1);
        lbl_Col1_9 = (TextView)findViewById(R.id.txt_Linha9_1);
        // coluna 2
        lbl_Col2_0 = (TextView)findViewById(R.id.txt_Linha0_2);
        lbl_Col2_1 = (TextView)findViewById(R.id.txt_Linha1_2);
        lbl_Col2_2 = (TextView)findViewById(R.id.txt_Linha2_2);
        lbl_Col2_3 = (TextView)findViewById(R.id.txt_Linha3_2);
        lbl_Col2_4 = (TextView)findViewById(R.id.txt_Linha4_2);
        lbl_Col2_5 = (TextView)findViewById(R.id.txt_Linha5_2);
        lbl_Col2_6 = (TextView)findViewById(R.id.txt_Linha6_2);
        lbl_Col2_7 = (TextView)findViewById(R.id.txt_Linha7_2);
        lbl_Col2_8 = (TextView)findViewById(R.id.txt_Linha8_2);
        lbl_Col2_9 = (TextView)findViewById(R.id.txt_Linha9_2);
        // coluna 3
        lbl_Col3_0 = (TextView)findViewById(R.id.txt_Linha0_3);
        lbl_Col3_1 = (TextView)findViewById(R.id.txt_Linha1_3);
        lbl_Col3_2 = (TextView)findViewById(R.id.txt_Linha2_3);
        lbl_Col3_3 = (TextView)findViewById(R.id.txt_Linha3_3);
        lbl_Col3_4 = (TextView)findViewById(R.id.txt_Linha4_3);
        lbl_Col3_5 = (TextView)findViewById(R.id.txt_Linha5_3);
        lbl_Col3_6 = (TextView)findViewById(R.id.txt_Linha6_3);
        lbl_Col3_7 = (TextView)findViewById(R.id.txt_Linha7_3);
        lbl_Col3_8 = (TextView)findViewById(R.id.txt_Linha8_3);
        lbl_Col3_9 = (TextView)findViewById(R.id.txt_Linha9_3);
        // coluna 4
        lbl_Col4_0 = (TextView)findViewById(R.id.txt_Linha0_4);
        lbl_Col4_1 = (TextView)findViewById(R.id.txt_Linha1_4);
        lbl_Col4_2 = (TextView)findViewById(R.id.txt_Linha2_4);
        lbl_Col4_3 = (TextView)findViewById(R.id.txt_Linha3_4);
        lbl_Col4_4 = (TextView)findViewById(R.id.txt_Linha4_4);
        lbl_Col4_5 = (TextView)findViewById(R.id.txt_Linha5_4);
        lbl_Col4_6 = (TextView)findViewById(R.id.txt_Linha6_4);
        lbl_Col4_7 = (TextView)findViewById(R.id.txt_Linha7_4);
        lbl_Col4_8 = (TextView)findViewById(R.id.txt_Linha8_4);
        lbl_Col4_9 = (TextView)findViewById(R.id.txt_Linha9_4);
        // coluna 5
        lbl_Col5_0 = (TextView)findViewById(R.id.txt_Linha0_5);
        lbl_Col5_1 = (TextView)findViewById(R.id.txt_Linha1_5);
        lbl_Col5_2 = (TextView)findViewById(R.id.txt_Linha2_5);
        lbl_Col5_3 = (TextView)findViewById(R.id.txt_Linha3_5);
        lbl_Col5_4 = (TextView)findViewById(R.id.txt_Linha4_5);
        lbl_Col5_5 = (TextView)findViewById(R.id.txt_Linha5_5);
        lbl_Col5_6 = (TextView)findViewById(R.id.txt_Linha6_5);
        lbl_Col5_7 = (TextView)findViewById(R.id.txt_Linha7_5);
        lbl_Col5_8 = (TextView)findViewById(R.id.txt_Linha8_5);
        lbl_Col5_9 = (TextView)findViewById(R.id.txt_Linha9_5);
        // coluna 6
        lbl_Col6_0 = (TextView)findViewById(R.id.txt_Linha0_6);
        lbl_Col6_1 = (TextView)findViewById(R.id.txt_Linha1_6);
        lbl_Col6_2 = (TextView)findViewById(R.id.txt_Linha2_6);
        lbl_Col6_3 = (TextView)findViewById(R.id.txt_Linha3_6);
        lbl_Col6_4 = (TextView)findViewById(R.id.txt_Linha4_6);
        lbl_Col6_5 = (TextView)findViewById(R.id.txt_Linha5_6);
        lbl_Col6_6 = (TextView)findViewById(R.id.txt_Linha6_6);
        lbl_Col6_7 = (TextView)findViewById(R.id.txt_Linha7_6);
        lbl_Col6_8 = (TextView)findViewById(R.id.txt_Linha8_6);
        lbl_Col6_9 = (TextView)findViewById(R.id.txt_Linha9_6);
        // coluna 7
        lbl_Col7_0 = (TextView)findViewById(R.id.txt_Linha0_7);
        lbl_Col7_1 = (TextView)findViewById(R.id.txt_Linha1_7);
        lbl_Col7_2 = (TextView)findViewById(R.id.txt_Linha2_7);
        lbl_Col7_3 = (TextView)findViewById(R.id.txt_Linha3_7);
        lbl_Col7_4 = (TextView)findViewById(R.id.txt_Linha4_7);
        lbl_Col7_5 = (TextView)findViewById(R.id.txt_Linha5_7);
        lbl_Col7_6 = (TextView)findViewById(R.id.txt_Linha6_7);
        lbl_Col7_7 = (TextView)findViewById(R.id.txt_Linha7_7);
        lbl_Col7_8 = (TextView)findViewById(R.id.txt_Linha8_7);
        lbl_Col7_9 = (TextView)findViewById(R.id.txt_Linha9_7);
        //
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new CountDownTimer(1000, 200) {
                    public void onTick(long millisUntilFinished) {
                        // simpleButton1.setText("CALCULANDO...");
                    }

                    public void onFinish() {
                        compartilhar();
                    }
                }.start();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        // NavigationUI.setupWithNavController(navigationView, navController);
        final NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean handled = NavigationUI.onNavDestinationSelected(item, navController);

                if (!handled) {
                    switch (item.getItemId()) {
                        case R.id.nav_como: {
                            startActivity(new Intent(MainActivity.this, ComoActivity.class));
                            break;
                        }
                        case R.id.nav_info: {
                            sobre();
                            break;
                        }
                        case R.id.nav_share: {
                            compartilharApp();
                            break;
                        }
                        case R.id.nav_avaliar: {
                            avaliarApp();
                            break;
                        }
                    }
                }

                //drawer.closeDrawer(GravityCompat.START);
                return handled;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void gerarJogo(){
        allBlack();
        Random rand = new Random();
        int x1  = rand.nextInt(10);
        int x2  = rand.nextInt(10);
        int x3  = rand.nextInt(10);
        int x4  = rand.nextInt(10);
        int x5  = rand.nextInt(10);
        int x6  = rand.nextInt(10);
        int x7  = rand.nextInt(10);
        int x8  = rand.nextInt(10);
        int x9  = rand.nextInt(10);
        verificaCol1(x1);
        verificaCol2(x2);
        verificaCol3(x3);
        verificaCol4(x4);
        verificaCol5(x5);
        verificaCol6(x6);
        verificaCol7(x7);
        lblJogo.setText("Jogo Gerado: "+ x1 +" - "+x2 +" - "+x3 +" - "+x4 +" - "+x5 +" - "+x6 +" - "+x7);
    }

    public void verificaCol1(int x1){
        if(x1==0){

            lbl_Col1_0.setTextColor(Color.rgb(230,0,0));

        }
        if(x1==1){

            lbl_Col1_1.setTextColor(Color.rgb(230,0,0));
        }
        if(x1==2){

            lbl_Col1_2.setTextColor(Color.rgb(230,0,0));
        }
        if(x1==3){

            lbl_Col1_3.setTextColor(Color.rgb(230,0,0));
        }
        if(x1==4){

            lbl_Col1_4.setTextColor(Color.rgb(230,0,0));
        }
        if(x1==5){

            lbl_Col1_5.setTextColor(Color.rgb(230,0,0));
        }
        if(x1==6){

            lbl_Col1_6.setTextColor(Color.rgb(230,0,0));
        }
        if(x1==7){

            lbl_Col1_7.setTextColor(Color.rgb(230,0,0));
        }
        if(x1==8){

            lbl_Col1_8.setTextColor(Color.rgb(230,0,0));
        }
        if(x1==9){

            lbl_Col1_9.setTextColor(Color.rgb(230,0,0));
        }
    }
    //col2
    public void verificaCol2(int x2){
        if(x2==0){

            lbl_Col2_0.setTextColor(Color.rgb(230,0,0));
        }
        if(x2==1){

            lbl_Col2_1.setTextColor(Color.rgb(230,0,0));
        }
        if(x2==2){

            lbl_Col2_2.setTextColor(Color.rgb(230,0,0));
        }
        if(x2==3){

            lbl_Col2_3.setTextColor(Color.rgb(230,0,0));
        }
        if(x2==4){

            lbl_Col2_4.setTextColor(Color.rgb(230,0,0));
        }
        if(x2==5){

            lbl_Col2_5.setTextColor(Color.rgb(230,0,0));
        }
        if(x2==6){

            lbl_Col2_6.setTextColor(Color.rgb(230,0,0));
        }
        if(x2==7){

            lbl_Col2_7.setTextColor(Color.rgb(230,0,0));
        }
        if(x2==8){

            lbl_Col2_8.setTextColor(Color.rgb(230,0,0));
        }
        if(x2==9){

            lbl_Col2_9.setTextColor(Color.rgb(230,0,0));
        }
    }
    //col 3
    public void verificaCol3(int x3){
        if(x3==0){

            lbl_Col3_0.setTextColor(Color.rgb(230,0,0));
        }
        if(x3==1){

            lbl_Col3_1.setTextColor(Color.rgb(230,0,0));
        }
        if(x3==2){

            lbl_Col3_2.setTextColor(Color.rgb(230,0,0));
        }
        if(x3==3){

            lbl_Col3_3.setTextColor(Color.rgb(230,0,0));
        }
        if(x3==4){

            lbl_Col3_4.setTextColor(Color.rgb(230,0,0));
        }
        if(x3==5){

            lbl_Col3_5.setTextColor(Color.rgb(230,0,0));
        }
        if(x3==6){

            lbl_Col3_6.setTextColor(Color.rgb(230,0,0));
        }
        if(x3==7){

            lbl_Col3_7.setTextColor(Color.rgb(230,0,0));
        }
        if(x3==8){

            lbl_Col3_8.setTextColor(Color.rgb(230,0,0));
        }
        if(x3==9){

            lbl_Col3_9.setTextColor(Color.rgb(230,0,0));
        }
    }
    //col 4
    public void verificaCol4(int x4){
        if(x4==0){

            lbl_Col4_0.setTextColor(Color.rgb(230,0,0));
        }
        if(x4==1){

            lbl_Col4_1.setTextColor(Color.rgb(230,0,0));
        }
        if(x4==2){

            lbl_Col4_2.setTextColor(Color.rgb(230,0,0));
        }
        if(x4==3){

            lbl_Col4_3.setTextColor(Color.rgb(230,0,0));
        }
        if(x4==4){

            lbl_Col4_4.setTextColor(Color.rgb(230,0,0));
        }
        if(x4==5){

            lbl_Col4_5.setTextColor(Color.rgb(230,0,0));
        }
        if(x4==6){

            lbl_Col4_6.setTextColor(Color.rgb(230,0,0));
        }
        if(x4==7){

            lbl_Col4_7.setTextColor(Color.rgb(230,0,0));
        }
        if(x4==8){

            lbl_Col4_8.setTextColor(Color.rgb(230,0,0));
        }
        if(x4==9){

            lbl_Col4_9.setTextColor(Color.rgb(230,0,0));
        }
    }
    //col 5
    public void verificaCol5(int x5){
        if(x5==0){

            lbl_Col5_0.setTextColor(Color.rgb(230,0,0));
        }
        if(x5==1){

            lbl_Col5_1.setTextColor(Color.rgb(230,0,0));
        }
        if(x5==2){

            lbl_Col5_2.setTextColor(Color.rgb(230,0,0));
        }
        if(x5==3){

            lbl_Col5_3.setTextColor(Color.rgb(230,0,0));
        }
        if(x5==4){

            lbl_Col5_4.setTextColor(Color.rgb(230,0,0));
        }
        if(x5==5){

            lbl_Col5_5.setTextColor(Color.rgb(230,0,0));
        }
        if(x5==6){

            lbl_Col5_6.setTextColor(Color.rgb(230,0,0));
        }
        if(x5==7){

            lbl_Col5_7.setTextColor(Color.rgb(230,0,0));
        }
        if(x5==8){

            lbl_Col5_8.setTextColor(Color.rgb(230,0,0));
        }
        if(x5==9){

            lbl_Col5_9.setTextColor(Color.rgb(230,0,0));
        }
    }
    //col 6
    public void verificaCol6(int x6){
        if(x6==0){

            lbl_Col6_0.setTextColor(Color.rgb(230,0,0));
        }
        if(x6==1){

            lbl_Col6_1.setTextColor(Color.rgb(230,0,0));
        }
        if(x6==2){

            lbl_Col6_2.setTextColor(Color.rgb(230,0,0));
        }
        if(x6==3){

            lbl_Col6_3.setTextColor(Color.rgb(230,0,0));
        }
        if(x6==4){

            lbl_Col6_4.setTextColor(Color.rgb(230,0,0));
        }
        if(x6==5){

            lbl_Col6_5.setTextColor(Color.rgb(230,0,0));
        }
        if(x6==6){

            lbl_Col6_6.setTextColor(Color.rgb(230,0,0));
        }
        if(x6==7){

            lbl_Col6_7.setTextColor(Color.rgb(230,0,0));
        }
        if(x6==8){

            lbl_Col6_8.setTextColor(Color.rgb(230,0,0));
        }
        if(x6==9){

            lbl_Col6_9.setTextColor(Color.rgb(230,0,0));
        }
    }
    //col 7
    public void verificaCol7(int x7){
        if(x7==0){

            lbl_Col7_0.setTextColor(Color.rgb(230,0,0));
        }
        if(x7==1){

            lbl_Col7_1.setTextColor(Color.rgb(230,0,0));
        }
        if(x7==2){

            lbl_Col7_2.setTextColor(Color.rgb(230,0,0));
        }
        if(x7==3){

            lbl_Col7_3.setTextColor(Color.rgb(230,0,0));
        }
        if(x7==4){

            lbl_Col7_4.setTextColor(Color.rgb(230,0,0));
        }
        if(x7==5){

            lbl_Col7_5.setTextColor(Color.rgb(230,0,0));
        }
        if(x7==6){

            lbl_Col7_6.setTextColor(Color.rgb(230,0,0));
        }
        if(x7==7){

            lbl_Col7_7.setTextColor(Color.rgb(230,0,0));
        }
        if(x7==8){

            lbl_Col7_8.setTextColor(Color.rgb(230,0,0));
        }
        if(x7==9){

            lbl_Col7_9.setTextColor(Color.rgb(230,0,0));
        }
    }

    public void allBlack(){
        lbl_Col1_0.setTextColor(Color.rgb(114,114,114));
        lbl_Col1_1.setTextColor(Color.rgb(114,114,114));
        lbl_Col1_2.setTextColor(Color.rgb(114,114,114));
        lbl_Col1_3.setTextColor(Color.rgb(114,114,114));
        lbl_Col1_4.setTextColor(Color.rgb(114,114,114));
        lbl_Col1_5.setTextColor(Color.rgb(114,114,114));
        lbl_Col1_6.setTextColor(Color.rgb(114,114,114));
        lbl_Col1_7.setTextColor(Color.rgb(114,114,114));
        lbl_Col1_8.setTextColor(Color.rgb(114,114,114));
        lbl_Col1_9.setTextColor(Color.rgb(114,114,114));
        //col2
        lbl_Col2_0.setTextColor(Color.rgb(114,114,114));
        lbl_Col2_1.setTextColor(Color.rgb(114,114,114));
        lbl_Col2_2.setTextColor(Color.rgb(114,114,114));
        lbl_Col2_3.setTextColor(Color.rgb(114,114,114));
        lbl_Col2_4.setTextColor(Color.rgb(114,114,114));
        lbl_Col2_5.setTextColor(Color.rgb(114,114,114));
        lbl_Col2_6.setTextColor(Color.rgb(114,114,114));
        lbl_Col2_7.setTextColor(Color.rgb(114,114,114));
        lbl_Col2_8.setTextColor(Color.rgb(114,114,114));
        lbl_Col2_9.setTextColor(Color.rgb(114,114,114));
        //col3
        lbl_Col3_0.setTextColor(Color.rgb(114,114,114));
        lbl_Col3_1.setTextColor(Color.rgb(114,114,114));
        lbl_Col3_2.setTextColor(Color.rgb(114,114,114));
        lbl_Col3_3.setTextColor(Color.rgb(114,114,114));
        lbl_Col3_4.setTextColor(Color.rgb(114,114,114));
        lbl_Col3_5.setTextColor(Color.rgb(114,114,114));
        lbl_Col3_6.setTextColor(Color.rgb(114,114,114));
        lbl_Col3_7.setTextColor(Color.rgb(114,114,114));
        lbl_Col3_8.setTextColor(Color.rgb(114,114,114));
        lbl_Col3_9.setTextColor(Color.rgb(114,114,114));
        //col4
        lbl_Col4_0.setTextColor(Color.rgb(114,114,114));
        lbl_Col4_1.setTextColor(Color.rgb(114,114,114));
        lbl_Col4_2.setTextColor(Color.rgb(114,114,114));
        lbl_Col4_3.setTextColor(Color.rgb(114,114,114));
        lbl_Col4_4.setTextColor(Color.rgb(114,114,114));
        lbl_Col4_5.setTextColor(Color.rgb(114,114,114));
        lbl_Col4_6.setTextColor(Color.rgb(114,114,114));
        lbl_Col4_7.setTextColor(Color.rgb(114,114,114));
        lbl_Col4_8.setTextColor(Color.rgb(114,114,114));
        lbl_Col4_9.setTextColor(Color.rgb(114,114,114));
        //col5
        lbl_Col5_0.setTextColor(Color.rgb(114,114,114));
        lbl_Col5_1.setTextColor(Color.rgb(114,114,114));
        lbl_Col5_2.setTextColor(Color.rgb(114,114,114));
        lbl_Col5_3.setTextColor(Color.rgb(114,114,114));
        lbl_Col5_4.setTextColor(Color.rgb(114,114,114));
        lbl_Col5_5.setTextColor(Color.rgb(114,114,114));
        lbl_Col5_6.setTextColor(Color.rgb(114,114,114));
        lbl_Col5_7.setTextColor(Color.rgb(114,114,114));
        lbl_Col5_8.setTextColor(Color.rgb(114,114,114));
        lbl_Col5_9.setTextColor(Color.rgb(114,114,114));
        //col6
        lbl_Col6_0.setTextColor(Color.rgb(114,114,114));
        lbl_Col6_1.setTextColor(Color.rgb(114,114,114));
        lbl_Col6_2.setTextColor(Color.rgb(114,114,114));
        lbl_Col6_3.setTextColor(Color.rgb(114,114,114));
        lbl_Col6_4.setTextColor(Color.rgb(114,114,114));
        lbl_Col6_5.setTextColor(Color.rgb(114,114,114));
        lbl_Col6_6.setTextColor(Color.rgb(114,114,114));
        lbl_Col6_7.setTextColor(Color.rgb(114,114,114));
        lbl_Col6_8.setTextColor(Color.rgb(114,114,114));
        lbl_Col6_9.setTextColor(Color.rgb(114,114,114));
        //col7
        lbl_Col7_0.setTextColor(Color.rgb(114,114,114));
        lbl_Col7_1.setTextColor(Color.rgb(114,114,114));
        lbl_Col7_2.setTextColor(Color.rgb(114,114,114));
        lbl_Col7_3.setTextColor(Color.rgb(114,114,114));
        lbl_Col7_4.setTextColor(Color.rgb(114,114,114));
        lbl_Col7_5.setTextColor(Color.rgb(114,114,114));
        lbl_Col7_6.setTextColor(Color.rgb(114,114,114));
        lbl_Col7_7.setTextColor(Color.rgb(114,114,114));
        lbl_Col7_8.setTextColor(Color.rgb(114,114,114));
        lbl_Col7_9.setTextColor(Color.rgb(114,114,114));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void compartilhar(){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,"*"+lblJogo.getText()+"*\n\n \uD83E\uDD11\uD83C\uDF40\uD83D\uDCB0\uD83D\uDE4F\uD83C\uDFFE \nBaixe Já o Aplicativo *Super Sete*  \n https://play.google.com/store/apps/details?id=com.br.super7");
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }


    public void compartilharApp(){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT," \uD83E\uDD11\uD83C\uDF40\uD83D\uDCB0\uD83D\uDE4F\uD83C\uDFFE \nBaixe Já o Aplicativo *Super Sete*  \n https://play.google.com/store/apps/details?id=com.br.super7");
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }

    public void sobre(){
        AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
        alert.setTitle("Pix");
        alert.setMessage("Versão 1.0.3\nDesenvolvido por:\nkleiton@email.com");
        alert.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         int id = item.getItemId();

         if (id == R.id.action_settings) {
            sobre();
         }

        return super.onOptionsItemSelected(item);
    }

    public void avaliarApp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + "com.br.super7")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.br.super7")));
        }
    }

    public void copiarJogo(){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", lblJogo.getText()+"\n\n \uD83E\uDD11\uD83C\uDF40\uD83D\uDCB0\uD83D\uDE4F\uD83C\uDFFE \nBaixe Já o Aplicativo *Super Sete*  \n https://play.google.com/store/apps/details?id=com.br.super7");
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Jogo Copiado!", Toast.LENGTH_LONG).show();
    }
}