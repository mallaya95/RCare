package com.first.rcare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    String u,p,s,s1,s2,s3;
    android.content.Context Context;
    Intent objHome,getObjHome1;
    int logFlag = 0;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.b1);
        e1=(EditText)findViewById(R.id.userlog);
        e2=(EditText)findViewById(R.id.userpass);
        e1.setText("akhil123@gmail.com");
        e2.setText("123456");
        b1.setTransformationMethod(null);
        sharedpreferences = getSharedPreferences("cuser", Context.MODE_PRIVATE);
        objHome = new Intent(getApplicationContext(),Rcare.class);
    }
    public void login(View view) {

        logFlag = 0;
        u=e1.getText().toString();
        p=e2.getText().toString();

        class background extends AsyncTask {



            @Override
            protected Object doInBackground(Object[] objects) {
                String result="";

                String conne="http://192.168.22.89/main/mobdata/userLoginCheck.php";
                try {
                    URL url=new URL(conne);
                    HttpURLConnection http = (HttpURLConnection) url.openConnection();

                    http.setRequestMethod("POST");
                    http.setDoInput(true);
                    http.setDoOutput(true);

                    OutputStream outputStream=http.getOutputStream();
                    BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                    String data= URLEncoder.encode("uemail","UTF-8")+"="+URLEncoder.encode(u,"UTF-8")+"&&"
                            +URLEncoder.encode("upass","UTF-8")+"="+URLEncoder.encode(p,"UTF-8");
                    writer.write(data);
                    Log.d("data\n",data);
                    writer.flush();
                    writer.close();
                    outputStream.close();


                    InputStream ips=http.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
                    String line="";
                    while ((line=reader.readLine())!=null){
                        Log.d("get vlaues\n",result);

                        result+=line;

                    }

                    reader.close();
                    ips.close();
                    result.trim();

                    if(result.length() > 2)
                    {
                        logFlag = 1;
                        JSONArray arr = new JSONArray(result);
                        JSONObject obj = arr.getJSONObject(0);
                        Log.d("RESULT",obj.getString("userid"));
                        Log.d("RESULT",obj.getString("email"));
                        s=obj.getString("userid");
                        s1=obj.getString("type");
                        s2=obj.getString("email");
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        Log.d("type",s1);
                        editor.putString("useri",s);
                        editor.putString("type",s1);
                        editor.commit();
                        // finish();
                        runOnUiThread(new Runnable() {
                            //@Override
                            public void run()
                            {
                                String v = null ;
                                String t1=sharedpreferences.getString("type",v);


//                                if (t1.equals("1")) {
                                    startActivity(objHome);
//                                }
//                                else if (t1.equals("0"))
//                                {
//
//                                    startActivity(getObjHome1);
//                                }


                            }
                        });

                    }
                    else
                    {
                        runOnUiThread(new Runnable() {
                            //@Override
                            @SuppressLint("WrongConstant")
                            public void run()
                            {
                                Toast.makeText(getApplicationContext(), "Invalid user detaos", 2).show();
                            }
                        });
                    }


                    http.disconnect();
                    return result;


                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("last vlaues\n",result);
                return result;
            }

            @Override
            protected void onPreExecute() {

            }
            protected void onPostExecute(String result){

                try
                {
                    Log.d("OUTPUT",result);
                    //JSONObject obj = new JSONObject(response.toString());
                    //String str = obj.getString("email");
                    //Log.d("RESULT",response.toString());


                }
                catch(Exception e)
                {
                    Log.d("ERROR3",e.toString());
                }

            }
        }

        background bg=new background();
        bg.execute();




    }


}
