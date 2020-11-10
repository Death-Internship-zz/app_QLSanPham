package dienloi.kiemtra.nguyenthanhtu.app_qlsanpham;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Adapter.ProcAdapter;
import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.DAO.ProcDAO;
import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Model.Proc;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText ProcName;
    EditText ProcPrice;
    EditText ProcType;
    Spinner ProcImg;
    Proc proc;
    ProcDAO procDAO;
    String arrayImg[] = {
            "cbr_250rr.jpg",
            "cbr_1000rr.jpg",
            "goldwing_1800.jpg",
            "kawasaki_ninja_250.jpg",
            "kawasaki_1000.jpg",
            "bmw_1000rr.jpg",
            "ktm_duke_250.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("THÊM SẢN PHẨM");
        AnhXa();
        setDataImg();
        Them();
        Thoat();
    }
    void AnhXa()
    {
        ProcName = findViewById(R.id.txt_proc_name);
        ProcPrice = findViewById(R.id.txt_proc_price);
        ProcType = findViewById(R.id.txt_proc_type);
        procDAO = new ProcDAO(AddActivity.this);
        ProcImg =(Spinner) findViewById(R.id.cbx_proc_img);
    }
    void setDataImg()
    {
        ProcImg.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter adapter = new ArrayAdapter<>(AddActivity.this, android.R.layout.simple_spinner_item, arrayImg);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ProcImg.setAdapter(adapter);
        ProcImg.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void Them()
    {
        findViewById(R.id.btn_add_proc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ProcName.getText().toString();
                String price = ProcPrice.getText().toString();
                String type = ProcType.getText().toString();
                String img = String.valueOf(ProcImg.getSelectedItem());
                proc = new Proc(name, price, type, img);
                procDAO.Add(proc);
                Toast.makeText(getApplication(), "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                ProcName.setText(null);
                ProcPrice.setText(null);
                ProcType.setText(null);
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