package com.semenindonesia.sisi.warehouseautomation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private Button btSignUp;
    private Button bt_signin;
    private Button bt_signout;
    private EditText etEmail;
    private EditText etPassword;

    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fStateListener;

    private static final String TAG = RegisterActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /**
         * Inisialisasi Firebase Auth
         */
        fAuth = FirebaseAuth.getInstance();


        /**
         * Cek apakah ada user yang sudah login
         */
        fStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User sedang login
                    Log.v(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    /**
                     * Method ini akan dipanggil apabila user berhasil logout
                     */
                    Toast.makeText(RegisterActivity.this, "User Logout\n",
                            Toast.LENGTH_SHORT).show();
                    bt_signout.setEnabled(false);
                    Log.v(TAG, "onAuthStateChanged:signed_out");
                }
            }

        };

        btSignUp = (Button) findViewById(R.id.bt_signup);
        bt_signin = (Button) findViewById(R.id.bt_signin);
        bt_signout = (Button) findViewById(R.id.bt_signout);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Lempar email dan password ketika tombol signup diklik
                 */
                signUp(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });

        bt_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Lempar email dan password ketika tombol signin diklik
                 */
                signIn(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });

      /*  bt_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });*/



    }
    private void signUp(final String email, String password){

        fAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        /**
                         * Jika sign in gagal, tampilkan pesan ke user. Jika sign in sukses
                         * maka auth state listener akan dipanggil dan logic untuk menghandle
                         * signed in user bisa dihandle di listener.
                         */
                        if (!task.isSuccessful()) {
                            task.getException().printStackTrace();
                            Toast.makeText(RegisterActivity.this, "Proses Pendaftaran Gagal",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Proses Pendaftaran Berhasil\n" +
                                            "Email "+email,
                                    Toast.LENGTH_SHORT).show();
                        }

                        // rest of code
                    }
                });

    }
    private void signIn(final String email, String password){

        fAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        /**
                         * Jika sign in gagal, tampilkan pesan ke user. Jika sign in sukses
                         * maka auth state listener akan dipanggil dan logic untuk menghandle
                         * signed in user bisa dihandle di listener.
                         */
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(RegisterActivity.this, "Proses Login Gagal\n",
                                    Toast.LENGTH_SHORT).show();
                        } else{

                            /**
                             * set enabled pada button logout apabila user berhasil login
                             */

                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            bt_signout.setEnabled(true);
                            Toast.makeText(RegisterActivity.this, "Login Berhasil\n" +
                                            "Email "+email,
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ... rest of code
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        fAuth.addAuthStateListener(fStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (fStateListener != null) {
            fAuth.removeAuthStateListener(fStateListener);
        }
    }
/*
    private void signOut(){

        *//**
         * Method untuk sign out dari Firebase
         *//*
        fAuth.signOut();
    }*/
}


      /*  fAuth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInAnonymously:success");
                    FirebaseUser user = fAuth.getCurrentUser();

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInAnonymously:failure", task.getException());
                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });*/