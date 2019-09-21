package t.m.supy.healthyindexes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Tomas on 9/3/2017.
 */

public class SQLLiteHelper extends SQLiteOpenHelper {

   public SQLLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
   }

   public SQLiteDatabase database(){

       SQLiteDatabase database = getWritableDatabase();
       return database;
   }

   public void QueryData(String sql){
       SQLiteDatabase database = getWritableDatabase();
       database.execSQL(sql);
   }

   public void InsertData(String tableName, String indexName, String value){
       SQLiteDatabase database = getWritableDatabase();
       String sql = "INSERT INTO " + tableName + " VALUES (NULL, ?, ?)";
       SQLiteStatement statement = database.compileStatement(sql);
       statement.clearBindings();
       statement.bindString(1, indexName);
       statement.bindString(2, value);

       statement.executeInsert();
       database.close();
   }

   public void SelectData(String tableName, String date){
       database();
       String sql = "SELECT MIN(VALUES) FROM " + tableName + " WHERE YEAR(DATE) = ? ";
       SQLiteStatement statement = database().compileStatement(sql);
       statement.clearBindings();
       statement.bindString(1, date);

       statement.execute();
       database().close();

   }

    public Cursor getData(String sql){

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
