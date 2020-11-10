package dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Model.Proc;
import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.R;

public class ProcAdapter extends BaseAdapter {
    Context context;
    ArrayList<Proc> procArrayList;

    @Override
    public int getCount() {
        return procArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHoder;
        if(convertView == null)
        {
            viewHoder = new ViewHoder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.gridview_item, null);
            viewHoder.ivHinh = (ImageView) convertView.findViewById(R.id.proc_img);
            viewHoder.tvProcId = (TextView) convertView.findViewById(R.id.lbl_proc_id);
            viewHoder.tvProcName =(TextView) convertView.findViewById(R.id.lbl_proc_name);
            viewHoder.tvProcPrice = (TextView) convertView.findViewById(R.id.lbl_proc_price);
            viewHoder.tvProcType = (TextView) convertView.findViewById(R.id.lbl_proc_type);
            viewHoder.tvProcImg = (TextView) convertView.findViewById(R.id.lbl_proc_img);
            convertView.setTag(viewHoder);
        }
        else
        {
            viewHoder = (ViewHoder) convertView.getTag();
        }
        Proc proc = procArrayList.get(position);
        viewHoder.tvProcId.setText(proc.getId().toString());
        viewHoder.tvProcName.setText(proc.getName());
        viewHoder.tvProcPrice.setText(proc.getPrice());
        viewHoder.tvProcType.setText(proc.getType());
        viewHoder.tvProcImg.setText(proc.getImg());
        switch (proc.getImg()) {
            case "cbr_250rr.jpg":
                viewHoder.ivHinh.setImageResource(R.drawable.cbr_250rr);
                break;
            case "cbr_1000rr.jpg":
                viewHoder.ivHinh.setImageResource(R.drawable.cbr_1000rr);
                break;
            case "goldwing_1800.jpg":
                viewHoder.ivHinh.setImageResource(R.drawable.goldwing_1800);
                break;
            case "kawasaki_ninja_250.jpg":
                viewHoder.ivHinh.setImageResource(R.drawable.kawasaki_ninja_250);
                break;
            case "kawasaki_1000.jpg":
                 viewHoder.ivHinh.setImageResource(R.drawable.kawasaki_1000);
                break;
            case "bmw_1000rr.jpg":
                viewHoder.ivHinh.setImageResource(R.drawable.bmw_1000rr);
                break;
            case "ktm_duke_250.jpg":
                viewHoder.ivHinh.setImageResource(R.drawable.ktm_duke_250);
                break;
        }
        return  convertView;
    }
    public ProcAdapter(Context context, ArrayList<Proc> objects) {
        this.context = context;
        this.procArrayList = objects;
    }
    public class ViewHoder
    {
        public ImageView ivHinh;
        public TextView tvProcId, tvProcName, tvProcPrice, tvProcType, tvProcImg;
    }
}
