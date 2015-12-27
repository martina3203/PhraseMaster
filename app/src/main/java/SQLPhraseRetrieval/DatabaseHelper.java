package SQLPhraseRetrieval;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by Aaron on 12/20/2015.
 * This will help maintain our database and how it will be updated
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CATEGORY_TABLE = "CATEGORY_TABLE";
    public static final String DATABASE_NAME = "Database.db";
    public static final int DATABASE_VERSION = 1;

    //These are attribute colum titles used in the Database
    public static final String UNIQUE_ID_COLUMN = "UNIQUE_ID";
    public static final String CATEGORY_COLUMN = "CATEGORY_NAME";
    public static final String PHRASE_COLUMN = "PHRASE";

    //Creation SQL Statement on first implementation
    private static final String CATEGORY_TABLE_CREATION = "CREATE TABLE " + CATEGORY_TABLE + " (" +
            UNIQUE_ID_COLUMN + " integer primary key autoincrement, " + CATEGORY_COLUMN + " text); ";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create the main category table
        db.execSQL(CATEGORY_TABLE_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
