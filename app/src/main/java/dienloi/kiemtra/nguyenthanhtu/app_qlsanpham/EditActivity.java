package dienloi.kiemtra.nguyenthanhtu.app_qlsanpham;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.DAO.ProcDAO;
import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Model.Proc;

public class EditActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText ProcId;
    EditText ProcName;
    EditText ProcPrice;
    EditText ProcType;
    Spinner ProcImg;
    Integer index;
    String[] arrayImg = {
            "cbr_250rr.jpg",
            "cbr_1000rr.jpg",
            "goldwing_1800.jpg",
            "kawasaki_ninja_250.jpg",
            "kawasaki_1000.jpg",
            "bmw_1000rr.jpg",
            "ktm_duke_250.jpg"};
    Proc proc;
    ProcDAO procDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("EDIT SẢN PHẨM");
        AnhXa();
        getDataItem();
        setDataImg();
        Sua();
        Xoa();
        Thoat();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    void getDataItem()
    {
        Intent intent = getIntent();
        proc = (Proc) intent.getSerializableExtra("PRODUCT_PROC");
        ProcId.setText( proc.getId().toString());
        ProcName.setText(proc.getName());
        ProcPrice.setText(proc.getPrice());
        ProcType.setText(proc.getType());
        index = Arrays.asList(arrayImg).indexOf(proc.getImg());
    }
    void AnhXa()
    {
        ProcId = findViewById(R.id.txt_proc_id);
        ProcName = findViewById(R.id.txt_proc_name);
        ProcPrice = findViewById(R.id.txt_proc_price);
        ProcType = findViewById(R.id.txt_proc_type);
        ProcImg =(Spinner) findViewById(R.id.cbx_proc_img);
        procDAO = new ProcDAO(EditActivity.this);
    }
    void setDataImg()
    {
        ProcImg.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter adapter = new ArrayAdapter<>(EditActivity.this, android.R.layout.simple_spinner_item, arrayImg);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ProcImg.setAdapter(adapter);
        ProcImg.setOnItemSelectedListener(this);
        ProcImg.setSelection(index);
        Toast.makeText(getApplicationContext(), index.toString(), Toast.LENGTH_LONG).show();
    }
    public void Sua()
    {
        findViewById(R.id.btn_edit_proc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = Integer.parseInt(ProcId.getText().toString());
                String name = ProcName.getText().toString();
                String price = ProcPrice.getText().toString();
                String type = ProcType.getText().toString();
                String img = String.valueOf(ProcImg.getSelectedItem());
                proc = new Proc(id, name, price, type, img);
                procDAO.Update(proc);
                Toast.makeText(getApplication(), "Sửa dữ liệu thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Xoa()
    {
        findViewById(R.id.btn_del_proc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = Integer.parseInt(ProcId.getText().toString());
                proc = new Proc(id);
                procDAO.Delete(proc);
                Toast.makeText(getApplication(), "Xóa dữ liệu thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Thoat()
    {
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}