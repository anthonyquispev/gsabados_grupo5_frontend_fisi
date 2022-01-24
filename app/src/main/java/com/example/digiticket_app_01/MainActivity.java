package com.example.digiticket_app_01;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digiticket_app_01.Retrofit.IMyService;
import com.example.digiticket_app_01.Retrofit.RetrofitClient;

public class MainActivity extends AppCompatActivity {

    /*
    EditText et_cod_usuario, et_password;
    Button btn_login, btn_usuarios;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    IMyService iMyService;

    @Override
    protected void onStop() {
        super.onStop();
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Retrofit retrofitClient = RetrofitClient.getInstance();
        iMyService = retrofitClient.create(IMyService.class);

        et_cod_usuario = findViewById(R.id.et_cod_usuario);
        et_password = findViewById(R.id.et_password);

        btn_login = findViewById(R.id.btn_Login);
        btn_usuarios = findViewById(R.id.btn_usuarios);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser(et_cod_usuario.getText().toString(), et_password.getText().toString());
            }
        });

        btn_usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuarios();
            }
        });
        */
    }

    /*
    private void loginUser(String cod_usuario, String password) {
        Toast.makeText(MainActivity.this, "Cod_usuario:" + cod_usuario + "__Pass:" + password, Toast.LENGTH_SHORT).show();
        compositeDisposable.add(iMyService.login(cod_usuario, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String response) throws Exception {
                        Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();
                    }
                }));
//        compositeDisposable.add(iMyService.login(cod_usuario,password)
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Consumer() {
//            @Override
//            public void accept(Object o) throws Exception {
//                Toast.makeText(MainActivity.this, ""+o.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }));
    }

    private void usuarios() {
        compositeDisposable.add(iMyService.usuarios()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String response) throws Exception {
                        Toast.makeText(MainActivity.this, "" + response, Toast.LENGTH_SHORT).show();
                    }
                }));
    }
    */
}