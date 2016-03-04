package yashaguo.secondhomework;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.app.Activity;



public class Tip extends Activity {
    //define private variables
    private EditText bill;
    private EditText people;
    private EditText tip;

    private Button calculate;
    private double tippercentage;

    private TextView totalbill;
    private TextView totaltip;
    private TextView totalperperson;
    private TextView tipperperson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Access the various widgets by their id in R.java
        bill=(EditText) findViewById(R.id.edit_bill);
        bill.requestFocus();

        people=(EditText) findViewById(R.id.edit_people);

        tip=(EditText) findViewById(R.id.edit_tip);

        totalbill=(TextView) findViewById(R.id.total_bill_view);

        totaltip=(TextView) findViewById(R.id.total_tip_view);

        totalperperson=(TextView) findViewById(R.id.per_person_view);
        tipperperson=(TextView) findViewById(R.id.tip_person_view);

        calculate = (Button) findViewById(R.id.go);
        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //if user didn't input any values in check amount or number of people
                if (bill.getText().toString().equals("") || people.getText().toString().isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "All Input field must be filled", Toast.LENGTH_LONG).show();
                    return;
                }

                //if user didn't input value in tip percentage, then using a default value of 15%
                if (tip.getText().toString().isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "using 15% as default tip percentage", Toast.LENGTH_LONG).show();
                    double totalamount=Double.parseDouble(bill.getText().toString());
                    double numberOfPeep=Double.parseDouble(people.getText().toString());
                    tippercentage=15;

                    double totalamountbill=totalamount*(1+tippercentage/100);
                    double totaltipbill=totalamount*(tippercentage/100);
                    double totalamountperson=totalamountbill/numberOfPeep;
                    double totaltipperson=totaltipbill/numberOfPeep;

                    totalbill.setText(String.format("%.2f", totalamountbill));
                    totaltip.setText(String.format("%.2f", totaltipbill));
                    totalperperson.setText(String.format("%.2f", totalamountperson));
                    tipperperson.setText(String.format("%.2f", totaltipperson));
                    return;
                }

//calculate the text view fields

                double totalamount=Double.parseDouble(bill.getText().toString());
                double tippercentage=Double.parseDouble(tip.getText().toString());
                double numberOfPeep=Double.parseDouble(people.getText().toString());

                double totalamountbill=totalamount*(1+tippercentage/100);
                double totaltipbill=totalamount*(tippercentage/100);
                double totalamountperson=totalamountbill/numberOfPeep;
                double totaltipperson=totaltipbill/numberOfPeep;

                totalbill.setText(String.format("%.2f", totalamountbill));
                totaltip.setText(String.format("%.2f", totaltipbill));
                totalperperson.setText(String.format("%.2f", totalamountperson));
                tipperperson.setText(String.format("%.2f", totaltipperson));



            }
        });

    }}

