package dienloi.kiemtra.nguyenthanhtu.app_qlsanpham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Adapter.ProcAdapter;
import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.DAO.ProcDAO;
import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Model.Proc;

public class CustomGridviewActivity extends AppCompatActivity {
    GridView gridView;
    Proc proc;
    ProcDAO procDAO = new ProcDAO(CustomGridviewActivity.this);
    ProcAdapter procAdapter;
    ArrayList<Proc> procArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gridview);

        gridView = (GridView) findViewById(R.id.grv_proc);
        procArrayList = procDAO.getAllProduct();
        procAdapter = new ProcAdapter(this, procArrayList);
        gridView.setAdapter(procAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("TẤT CẢ SẢN PHẨM");
        SelectItem();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }
    void SelectItem()
    {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               proc = procArrayList.get(position);
                Intent intent = new Intent(CustomGridviewActivity.this, EditActivity.class);
                intent.putExtra("PRODUCT_PROC", proc);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        procArrayList.clear();
        procArrayList.addAll(procDAO.getAllProduct());
        procAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item_add)
        {
            Intent intent = new Intent(CustomGridviewActivity.this, AddActivity.class);
            startActivity(intent);
        }
        if(id == R.id.item_back)
        {
            finish();
        }
        return true;
    }
}