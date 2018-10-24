package com.prohlpsolution.test1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity{

    /**
     * Called when the activity is first created.
     */
    int resultStatus=0;
    int currentStatus=0;
    InputStream is;
    int status=0;
    String result="0";
    String field1="0";
    String field2="0";
    String field3="0";
    String field4="0";
    String field5="0";
    String field6="0";
    String field7="0";
    String field8="0";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but1 = (Button) findViewById(R.id.button1);
        Button but2 = (Button) findViewById(R.id.button);
        TextView res1 = (TextView) findViewById(R.id.textView1);
        TextView res2 = (TextView) findViewById(R.id.textView2);
        TextView res3 = (TextView) findViewById(R.id.textView3);
        TextView res4 = (TextView) findViewById(R.id.textView4);
        //  final EditText et = (EditText) findViewById(R.id.editText);

        //res1.setBackgroundColor(Color.parseColor("#00ff00"));



        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            updateField(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        but1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    //updateField();
                    field1="1";
                    updateField(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        but2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    //updateField();
                    field1="1";
                    updateField(1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /*public void runUrl() throws IOException {
        String url = "https://api.thingspeak.com/update?api_key=H793WTXGYWNGY0KE&field1="+field1+"&field2="+field2+"&field3="+field3+"&field4="+field4+"&field5="+field5+"&field6="+field6+"&field7="+field7;
        // String url = "https://api.thingspeak.com/channels/76969/fields/1.json?results=1";
        //  HttpClient mClient= new DefaultHttpClient();
        //  TextView res = (TextView) findViewById(R.id.textView4);

        while (resultStatus == currentStatus) {
            URL urlObj = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
            is = urlConnection.getInputStream();
            // status = urlConnection.getResponseCode();
            String result1 = urlConnection.getResponseMessage();
            // Object result = urlConnection.getContent();
            Toast.makeText(this, String.valueOf(result1), Toast.LENGTH_SHORT).show();

            int ch;
            StringBuilder sb = new StringBuilder();
            while ((ch = is.read()) != -1)
                sb.append((char) ch);
            // is.reset();
            result = sb.toString();


            int st=Integer.parseInt(result);
            if(st != 0)
                currentStatus=st;
        }
        //   Toast.makeText(this, String.valueOf(status), Toast.LENGTH_SHORT).show();
        //  res.setText(result);
        resultStatus = currentStatus;
    }
*/
    public void updateField(int b) throws IOException {
        // String url = "https://api.thingspeak.com/update?api_key=H793WTXGYWNGY0KE&field1="+field1+"&field2="+field2+"&field3="+field3+"&field4="+field4+"&field5="+field5+;
        // String url = "https://api.thingspeak.com/channels/76969/fields/1.json?results=1";

        TextView res1 = (TextView) findViewById(R.id.textView1);
        TextView res2 = (TextView) findViewById(R.id.textView2);
        TextView res3 = (TextView) findViewById(R.id.textView3);
        TextView res4 = (TextView) findViewById(R.id.textView4);
        TextView res5 = (TextView) findViewById(R.id.textView5);

        // String url = "https://api.thingspeak.com/channels/341331/feeds.json?api_key=HM533PYQKU7DP51J&results=1";
        String url = "https://api.thingspeak.com/channels/343926/feeds.json?api_key=FL4RWJ3ARB7D0FF8&results=1";
        URL urlObj = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
        is = urlConnection.getInputStream();
        // status = urlConnection.getResponseCode();
        String result1 = urlConnection.getResponseMessage();
        // Object result = urlConnection.getContent();


        int ch;
        StringBuilder sb = new StringBuilder();
        while ((ch = is.read()) != -1)
            sb.append((char) ch);
        // is.reset();
        result = sb.toString();
        int startIndex=result.indexOf("feeds:");
        if(startIndex>=0)
        {
            String myResult= result.substring(startIndex);
            //       Toast.makeText(this, myResult, Toast.LENGTH_SHORT).show();
            startIndex = myResult.indexOf("field1:")+10;
            int endIndex =myResult.indexOf("field2:")-1;
            field1 = myResult.substring(startIndex,endIndex);

            startIndex = myResult.indexOf("field2:")+10;
            endIndex =myResult.indexOf("field3:")-1;
            field2 = myResult.substring(startIndex,endIndex);

            startIndex = myResult.indexOf("field3:")+10;
            endIndex =myResult.indexOf("field4:")-1;
            field3 = myResult.substring(startIndex,endIndex);

         /*    startIndex = myResult.indexOf("\"field4\":")+10;
             endIndex =myResult.indexOf(",\"field5\"")-1;
             field4 = myResult.substring(startIndex,endIndex);

             startIndex = myResult.indexOf("\"field5\":")+10;
             endIndex =myResult.indexOf(",\"field6\"")-1;
             field5 = myResult.substring(startIndex,endIndex);

             startIndex = myResult.indexOf("\"field6\":")+10;
             endIndex =myResult.indexOf(",\"field7\"")-1;
             field6 = myResult.substring(startIndex,endIndex);*/

            startIndex = myResult.indexOf("field4:")+10;
            endIndex =myResult.indexOf("}")-1;
            field4 = myResult.substring(startIndex,endIndex);
        }

        // tv1.setText(field6);
        // tv2.setText(field7);

        //  int st=Integer.parseInt(result);
        int f = 0,f1=0,f2=0,f3=0,f4=0;

            f1 = Integer.parseInt(field1);
            f2 = Integer.parseInt(field2);
            f3 = Integer.parseInt(field3);
            f4 = Integer.parseInt(field4);
        res5.setBackgroundColor(Color.parseColor("#808080"));
        if(f1 == 0)
        {
            res5.setText(" Available");
            if(b == 1) {
                field1 = "2";
                f=1;
            }

        }

        else if(f2 == 0)
        {
            res5.setText(" Available");
            if(b == 1) {
                field2 = "2";
                f=2;
            }
        }


        else if(f3 == 0)
        {
            res5.setText(" Available");
            if(b == 1) {
                field3 = "2";
                f=3;
            }
        }

        else if(f4 == 0)
        {
            res5.setText(" Available");
            if(b == 1) {
                field4 = "2";
                f=4;
            }
        }

        else
        {
            res5.setText("No Space");
        }

        if(b == 1)
        {
            // url = "https://api.thingspeak.com/channels/343926/feeds.json?api_key=FL4RWJ3ARB7D0FF8&results=1";
            url = "https://api.thingspeak.com/update?api_key=5SMRQAIL8RK9JDZG&field1="+field1+"&field2="+field2+"&field3="+field3+"&field4="+field4;
            urlObj = new URL(url);
            urlConnection = (HttpURLConnection) urlObj.openConnection();
            is = urlConnection.getInputStream();
            // status = urlConnection.getResponseCode();
            result1 = urlConnection.getResponseMessage();
            Toast.makeText(this, "Slot "+String.valueOf(f)+" reserved", Toast.LENGTH_SHORT).show();
        }

        if(field1.contains("1"))
            res1.setBackgroundColor(Color.parseColor("#FF0000"));
        else if(field1.contains("2"))
            res1.setBackgroundColor(Color.parseColor("#0000FF"));
        else
            res1.setBackgroundColor(Color.parseColor("#00FF00"));

        if(field2.contains("1"))
            res2.setBackgroundColor(Color.parseColor("#FF0000"));
        else if(field2.contains("2"))
            res2.setBackgroundColor(Color.parseColor("#0000FF"));
        else
            res2.setBackgroundColor(Color.parseColor("#00FF00"));

        if(field3.contains("1"))
            res3.setBackgroundColor(Color.parseColor("#FF0000"));
        else if(field3.contains("2"))
            res3.setBackgroundColor(Color.parseColor("#0000FF"));
        else
            res3.setBackgroundColor(Color.parseColor("#00FF00"));

        if(field4.contains("1"))
            res4.setBackgroundColor(Color.parseColor("#FF0000"));
        else if(field4.contains("2"))
            res4.setBackgroundColor(Color.parseColor("#0000FF"));
        else
            res4.setBackgroundColor(Color.parseColor("#00FF00"));

        Toast.makeText(this, String.valueOf(result1), Toast.LENGTH_SHORT).show();
        //  Toast.makeText(this, String.valueOf(status), Toast.LENGTH_SHORT).show();
    }
}
