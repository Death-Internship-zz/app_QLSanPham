package dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Database.DbHelper;
import dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Model.Proc;

public class ProcDAO {
    DbHelper dbHelper;
    public ProcDAO(Context context)
    {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Proc> getAllProduct()
    {
        String sql = "SELECT * FROM PROC";
        ArrayList<Proc> motoArrayList = new ArrayList<Proc>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            Proc proc = new Proc();
            proc.setId(cursor.getInt(0));
            proc.setName(cursor.getString(1));
            proc.setPrice(cursor.getString(2));
            proc.setType(cursor.getString(3));
            proc.setImg(cursor.getString(4));
            motoArrayList.add(proc);
            cursor.moveToNext();
        }
        return  motoArrayList;
    }
    public void Add(Proc proc)
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", proc.getId());
        values.put("NAME", proc.getName());
        values.put("PRICE", proc.getPrice());
        values.put("TYPE", proc.getType());
        values.put("IMG", proc.getType());
        database.insert("PROC", "", values);
    }
    public void Update(Proc proc)
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        Integer id = proc.getId();
        values.put("ID", proc.getId());
        values.put("NAME", proc.getName());
        values.put("PRICE", proc.getPrice());
        values.put("TYPE", proc.getType());
        values.put("IMG", proc.getImg());
        database.update("PROC", values,"ID=?", new String[] {id.toString()});
    }
    public void Delete(Proc proc)
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Integer id = proc.getId();
        database.delete("PROC","ID=?", new String[] {id.toString()});
    }
}
