package com.example.manoj_pc.jsonparsingasync;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by NG on 13-Dec-2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<Customer> mAndroidList;
    private List<Customer> jsonArrayItemList;
    private static final String EMPTY = "";
   /* public DataAdapter(List<Customer> androidList) {
        mAndroidList = androidList;
    }*/

    public DataAdapter(List<Customer> jsonArrayItemList) {
        this.jsonArrayItemList = jsonArrayItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Customer customer =  jsonArrayItemList.get(position);
        if(customer.getCustomerid()!=null){
            holder.tvId.setText(customer.getCustomerid());
        }else{
            holder.tvId.setText(EMPTY);
        }
        if(customer.getCustomername()!=null){
            holder.tvName.setText(customer.getCustomername());
        }else {
            holder.tvName.setText(EMPTY);
        }

        if(customer.getCustomerbirth()!=null){
            holder.tvBirth.setText(customer.getCustomerbirth());
        }else {
            holder.tvBirth.setText(EMPTY);
        }

        if(customer.getCustomerage()!=null){
            holder.tvAge.setText(customer.getCustomerage());
        }else {
            holder.tvAge.setText(EMPTY);
        }


        if(customer.getCustomercity()!=null){
            holder.tvCity.setText(customer.getCustomercity());
        }else {
            holder.tvCity.setText(EMPTY);
        }


        if(customer.getGraduation()!=null){
            holder.tvGraduate.setText(customer.getGraduation());
        }else {
            holder.tvGraduate.setText(EMPTY);
        }
        if(customer.getInterschool()!=null){
            holder.tvSchool.setText(customer.getInterschool());
        }else {
            holder.tvSchool.setText(EMPTY);
        }
        if(customer.getUndergradution()!=null){
            holder.tvUnderGraduate.setText(customer.getUndergradution());
        }else {
            holder.tvUnderGraduate.setText(EMPTY);
        }
        if(customer.getPostgraduation()!=null){
            holder.tvPostGraduate.setText(customer.getPostgraduation());
        }else {
            holder.tvPostGraduate.setText(EMPTY);
        }
        if(customer.getEmpdepartment()!=null){
            holder.tvDepartment.setText(customer.getEmpdepartment());
        }else {
            holder.tvDepartment.setText(EMPTY);
        }
        if(customer.getEmpid()!=null){
            holder.tvEmpId.setText(customer.getEmpid());
        }else {
            holder.tvEmpId.setText(EMPTY);
        }
        if(customer.getEmpsalary()!=null){
            holder.tvSalary.setText(customer.getEmpsalary());
        }else {
            holder.tvSalary.setText(EMPTY);
        }
        if(customer.getEmpstatus()!=null){
            holder.tvStatus.setText(customer.getEmpstatus());
        }else {
            holder.tvStatus.setText(EMPTY);
        }
        if(customer.getEmphobbie()!=null){
            holder.tvHobbie.setText(customer.getEmphobbie());
        }else {
            holder.tvHobbie.setText(EMPTY);
        }
    }

    @Override
    public int getItemCount() {
        return jsonArrayItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private  TextView tvGraduate,tvSchool,tvUnderGraduate,tvPostGraduate,tvDepartment,tvEmpId,tvSalary,tvStatus,tvHobbie;
        private TextView tvId,tvName,tvBirth,tvAge,tvCity;
        public ViewHolder(View view) {
            super(view);

            tvId = (TextView)view.findViewById(R.id.tvId);
            tvName = (TextView)view.findViewById(R.id.tvName);
            tvBirth = (TextView)view.findViewById(R.id.tvBirth);
            tvAge = (TextView)view.findViewById(R.id.tvAge);
            tvCity = (TextView)view.findViewById(R.id.tvCity);

            tvGraduate = (TextView)view.findViewById(R.id.tvGraduate);
            tvSchool = (TextView)view.findViewById(R.id.tvSchool);
            tvUnderGraduate = (TextView)view.findViewById(R.id.tvUnderGraduate);
            tvPostGraduate = (TextView)view.findViewById(R.id.tvPostGraduate);
            tvDepartment = (TextView)view.findViewById(R.id.tvDepartment);

            tvEmpId = (TextView)view.findViewById(R.id.tvEmpId);
            tvSalary = (TextView)view.findViewById(R.id.tvSalary);
            tvStatus = (TextView)view.findViewById(R.id.tvStatus);
            tvHobbie = (TextView)view.findViewById(R.id.tvHobbie);
        }
    }
}
