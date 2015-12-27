package SQLPhraseRetrieval;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Aaron on 12/20/2015.
 * This will function as a Database Access Object
 * This object shall retriever phrase(s) from the database and returns them as a single string or as a list
 */
public class PhraseRetriever {
    private DatabaseHelper TheHelper;
    private SQLiteDatabase TheDatabase;
    private Random RandomNumberGenerator;

    public PhraseRetriever (Context context) {
        TheHelper = new DatabaseHelper(context);
        RandomNumberGenerator = new Random();
    }

    //Opens the database connection
    public void openDatabase()
    {
        TheDatabase = TheHelper.getWritableDatabase();
    }

    //Closes the database connection
    public void closeDatabase()
    {
        if ((TheDatabase != null) && (TheDatabase.isOpen()))
        {
            TheDatabase.close();
        }
    }

    public long addCategory(String newCategory)
    {
        //Store in object
        ContentValues newEntry = new ContentValues();
        newEntry.put(TheHelper.CATEGORY_COLUMN, newCategory);

        //Add to database
        long ID = TheDatabase.insert(TheHelper.CATEGORY_TABLE,null,newEntry);

        //Now create a corresponding table
        TheDatabase.execSQL("CREATE TABLE " + newCategory + " (" + TheHelper.UNIQUE_ID_COLUMN + " integer primary key autoincrement, " + TheHelper.PHRASE_COLUMN + " text);");
        return ID;
    }

    public long addPhrase(String category, String newPhrase)
    {
        //Store in object
        ContentValues newEntry = new ContentValues();
        newEntry.put(TheHelper.PHRASE_COLUMN, newPhrase);

        //Add to database
        long ID = TheDatabase.insert(category,null,newEntry);
        return ID;
    }

    //Returns a single phrase from one category
    public String returnRandomPhrase(String selected_category)
    {
        String returnString = "";
        //First we find the size of table in question
        String queryString = "SELECT * FROM " + selected_category;
        Cursor resultQuery = TheDatabase.rawQuery(queryString,null);
        int querySize = resultQuery.getCount();
        //Acquire random number
        int randomNumber = RandomNumberGenerator.nextInt(querySize);
        //Query
        resultQuery.moveToPosition(randomNumber);
        returnString = resultQuery.getString(1);
        return returnString;
    }

    //Returns a list of phrases
    public ArrayList<String> returnListOfPhrases(String selected_category, int number_of_phrases)
    {
        ArrayList<String> returnList = new ArrayList<String>();

        return returnList;
    }
}
