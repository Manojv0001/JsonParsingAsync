package com.example.manoj_pc.jsonparsingasync;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProgressDialog pDialog;
    private static  final String URL = "https://firebasestorage.googleapis.com/v0/b/fir-storage-861db.appspot.com/o/uploads%2FNewDemo.json?alt=media&token=b9c8e5ce-98b4-4f17-926c-aea63150acce";
    private static  final String EMPTY = "";
    private List<Customer> customerList = new ArrayList<>();
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        new CallWebService().execute();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @SuppressLint("StaticFieldLeak")
    private class CallWebService extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }



        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(URL);
            if(jsonStr!=null){
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray jsonArray = jsonObject.getJSONArray("jsonArray");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                        String customerid = jsonObject1.getString("CustomerId");
                        String customername = jsonObject1.getString("CustomerName");
                        String customerbirth = jsonObject1.optString("CustomerBirth");
                        String customerage = jsonObject1.optString("CustomerAge");
                        String customercity = jsonObject1.optString("CustomerCity");


                        JSONObject jsonObject2 = jsonObject1.getJSONObject("EmpEducation");
                        String graduation = jsonObject2.optString("graduation");
                        String interschool = jsonObject2.optString("interschool");
                        String undergraduate = jsonObject2 .optString("undergradution");
                        String postgraduate = jsonObject2 .optString("postgraduation");

                        JSONObject jsonObject3 = jsonObject1.getJSONObject("WorkInfo");
                        String empdepartment = jsonObject3.optString("empdepartment");
                        String empid = jsonObject3.optString("empid");
                        String empsalary = jsonObject3.optString("empsalary");
                        String empstatus = jsonObject3.optString("empstatus");
                        String emphobbie = jsonObject3.optString("emphobbie");
                        Customer customer = new Customer();

                          if(customerid!=null){
                                customer.setCustomerid(customerid);
                            }else{
                                customer.setCustomerid(EMPTY);
                            }

                            if(customername!=null){
                                customer.setCustomername(customername);
                            }else{
                                customer.setCustomername(EMPTY);
                            }

                        if(customerbirth!=null){
                            customer.setCustomerbirth(customerbirth);
                        }else{
                            customer.setCustomerbirth(EMPTY);

                        }

                            if(customerage!=null){
                                customer.setCustomerage(customerage);
                            }else{
                                customer.setCustomerage(EMPTY);
                            }

                        if(customercity!=null){
                            customer.setCustomercity(customercity);
                        }else{
                            customer.setCustomercity(EMPTY);
                        }

                            if(graduation!=null){
                                customer.setGraduation(graduation);
                            }else{
                                customer.setGraduation(EMPTY);
                            }
                            if(interschool!=null){
                                customer.setInterschool(interschool);
                            }else{
                                customer.setInterschool(EMPTY);
                            }

                            if(undergraduate!=null){
                                customer.setUndergradution(undergraduate);
                            }else{
                                customer.setUndergradution(EMPTY);
                            }

                        if(postgraduate!=null){
                           customer.setPostgraduation(postgraduate);
                        }else {
                            customer.setPostgraduation(EMPTY);
                        }

                            if(empdepartment!=null){
                                customer.setEmpdepartment(empdepartment);
                            }else {
                                customer.setEmpdepartment(EMPTY);
                            }

                            if(empid!=null){
                                customer.setEmpid(empid);
                            }else {
                                customer.setEmpid(EMPTY);
                            }

                            if(empsalary!=null){
                                customer.setEmpsalary(empsalary);
                            }else {
                                customer.setEmpsalary(EMPTY);
                            }

                        if(empstatus!=null){
                            customer.setEmpstatus(empstatus);
                        }else {
                            customer.setEmpstatus(EMPTY);
                        }

                        if(emphobbie!=null){
                            customer.setEmphobbie(emphobbie);
                        }else {
                            customer.setEmphobbie(EMPTY);
                        }

                        customerList.add(customer);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Error in json parsing",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }
            }else{
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (pDialog.isShowing())
                pDialog.dismiss();
            if(customerList!=null&&customerList.size()>0){
                mAdapter = new DataAdapter(customerList);
                mRecyclerView.setAdapter(mAdapter);
            }else{
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Something went wrong",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

        }

    }
}
