package id.co.dimas.android.firebaserealtimedb;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

/**
 * Created by Sidiq on 09/11/2017.
 */

public class IntroActivity extends AppIntro {

    PrefManager prefManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefManager = new PrefManager(this);

        if (!prefManager.isFirstTimeLaunch()) {
            Intent mainIntent = new Intent(IntroActivity.this,MainActivity.class);
            IntroActivity.this.startActivity(mainIntent);
            IntroActivity.this.finish();
        }

        SliderPage kotak = new SliderPage();
        kotak.setTitle("Apa Itu Kotak Keluhan?");
        kotak.setDescription("Kotak Keluhan adalah sebuah kotak ajaib yang menampung aspirasi kalian ke BEMF-IK dan dari kotak tersebut kami dapat mengevaluasi hal tersebut");
        kotak.setImageDrawable(R.drawable.logo);
        kotak.setBgColor(Color.BLACK);
        addSlide(AppIntroFragment.newInstance(kotak));
        SliderPage suara = new SliderPage();
        suara.setTitle("Aspirasi Apa Yang Dapat Disampaikan?");
        suara.setDescription("Kalian dapat mengkritk tentang kinerjs BEMF-IK, kinerja dosen, kinerja fakultas, fasilitas, keluhan kalian dan harapan saran dari kalian.");
        suara.setImageDrawable(R.drawable.suara);
        suara.setBgColor(Color.BLACK);
        addSlide(AppIntroFragment.newInstance(suara));

        SliderPage title = new SliderPage();
        title.setTitle("Ayo Keluarkan Suara Kita!");
        title.setImageDrawable(R.drawable.title);
        title.setBgColor(Color.BLACK);
        addSlide(AppIntroFragment.newInstance(title));

        setSkipText("Lewati");
        setDoneText("Lanjut");

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        Intent mainIntent = new Intent(IntroActivity.this,MainActivity.class);
        IntroActivity.this.startActivity(mainIntent);
        IntroActivity.this.finish();
        prefManager.setFirstTimeLaunch(false);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent mainIntent = new Intent(IntroActivity.this,MainActivity.class);
        IntroActivity.this.startActivity(mainIntent);
        IntroActivity.this.finish();
        prefManager.setFirstTimeLaunch(false);
    }

}
