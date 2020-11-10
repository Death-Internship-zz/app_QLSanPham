package dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    Context context;
    public DbHelper(Context context)
    {
        super(context, "Ql_SanPham.sqlite", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " +
                "PROC (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME VARCHAR(50), "+
                "PRICE VARCHAR(50), " +
                "TYPE VARCHAR(50), "+
                "IMG VARCHAR(50))";
        db.execSQL(sqlCreate);
        String mt01 = "INSERT INTO PROC (NAME, PRICE, TYPE, IMG) VALUES ('CBR 250RR', '160 triệu','Honda', 'cbr_250rr.jpg')";
        db.execSQL(mt01);
        String mt02 = "INSERT INTO PROC (NAME, PRICE, TYPE, IMG) VALUES ('CBR 1000RRR', '949 triệu','Honda', 'cbr_1000rr.jpg')";
        db.execSQL(mt02);
        String mt03 = "INSERT INTO PROC (NAME, PRICE, TYPE, IMG) VALUES ('GOLDWING', '1 tỷ 2','Honda', 'goldwing_1800.jpg')";
        db.execSQL(mt03);
        String mt04 = "INSERT INTO PROC (NAME, PRICE, TYPE, IMG) VALUES ('KAWASAKI NINJA 250', '133 triệu', 'Kawasaki', 'kawasaki_ninja_250.jpg')";
        db.execSQL(mt04);
        String mt05 = "INSERT INTO PROC (NAME, PRICE, TYPE, IMG) VALUES ('KAWASAKI Z1000R', '459 triệu', 'Kawasaki', 'kawasaki_1000.jpg')";
        db.execSQL(mt05);
        String mt06 = "INSERT INTO PROC (NAME, PRICE, TYPE, IMG) VALUES ('BMW S1000RR', '949 triệu', 'BMW', 'bmw_1000rr.jpg')";
        db.execSQL(mt06);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
