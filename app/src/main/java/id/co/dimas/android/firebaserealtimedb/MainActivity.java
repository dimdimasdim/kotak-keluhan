package id.co.dimas.android.firebaserealtimedb;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    DatabaseReference message;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edt_suara_anda)
    EditText edtSuaraAnda;
    @BindView(R.id.btn_submit_suara_anda)
    Button btnSubmitSuaraAnda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initToolbar();

        message = FirebaseDatabase.getInstance().getReference().child("Suara_Keluhan");

        btnSubmitSuaraAnda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtSuaraAnda.getText().toString().equals("")){
                    edtSuaraAnda.setError("Isikan Suara Anda terlebih dahulu");
                }else {
                    showAlertDialog();
                }
            }
        });
    }

    private void initToolbar() {
        toolbar.setTitle("Suara Anda");
        setSupportActionBar(toolbar);
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Apa Anda Yakin Mengirimkan Keluhan Anda?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String keluhan = edtSuaraAnda.getText().toString().trim();

                        message.push().setValue(keluhan);
                        edtSuaraAnda.setText("");
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}
