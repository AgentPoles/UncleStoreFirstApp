package com.mycompany.myapp.bframework;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Paul on 1/8/2018.
 */
public class AnnContentProvider extends ContentProvider {
    public static final Uri CONTENT_URI = Uri.parse("content://com.mycompany.provider.myapp/details");
    public static final String KEY_ID = "_id";
    public static final String KEY_IDE = "_id";
    public static final String KEY_USER_NAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_PHONE_NUMBER = "phonenumber";
    public static final String KEY_TRANSACTIONS = "transactions";
    public static final String KEY_BUSINESS_NUMBER = "businessnumber";
    public static final String KEY_AVDERT_NUMBER = "advertnumber";
    public static final String KEY_COMMENT_IMAGE = "commentimage";
    public static final String KEY_THE_NAME="thename";
    public static final String KEY_TO_WHO = "towho";
    public static final String KEY_FROM_WHO = "fromwho";
    public static final String KEY_BODY = "body";
    public static final String KEY_DATE = "commentdate";
    public static final String KEY_TYPI = "typi";
    public static final String KEY_TIME = "commenttime";
    private MySQLiteOpenHelper myOpenHelper;
    private static final int ALLROWS = 1;
    private static final int SINGLE_ROW = 2;
    private static final UriMatcher uriMatcher;
    Context v = getContext();

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.mycompany.provider.myapp", "details", ALLROWS);
        uriMatcher.addURI("com.mycompany.provider.myapp", "details/#", SINGLE_ROW);
    }

    @Override
    public boolean onCreate() {
        myOpenHelper = new MySQLiteOpenHelper(getContext(),
                MySQLiteOpenHelper.DATABASE_NAME, null,
                MySQLiteOpenHelper.DATABASE_VERSION);
//        Toast.makeText(getContext(), "creating base", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case ALLROWS:
                return "vnd.android.cursor.dir/vnd.mycompany.details";
            case SINGLE_ROW:
                return "vnd.android.cursor.item/vnd.mycompany.details";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sort) {
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
// Replace these with valid SQL statements if necessary.
        String groupBy = null;
        String having = null;
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(MySQLiteOpenHelper.DATABASE_TABLE);
// If this is a row query, limit the result set to the passed in row.
        switch (uriMatcher.match(uri)) {
            case SINGLE_ROW:
                String rowID = uri.getPathSegments().get(1);
                queryBuilder.appendWhere(KEY_ID + "=" + rowID);
            default:
                break;
        }
        Cursor cursor = queryBuilder.query(db, projection, selection,
                selectionArgs, groupBy, having, sort);
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
// To add empty rows to your database by passing in an empty Content Values
// object, you must use the null column hack parameter to specify the name of
// the column that can be set to null.
        String nullColumnHack = null;
// Insert the values into the table
        long id = db.insert(MySQLiteOpenHelper.DATABASE_TABLE,
                nullColumnHack, values);
        if (id > -1) {
// Construct and return the URI of the newly inserted row.
            Uri insertedId = ContentUris.withAppendedId(CONTENT_URI, id);
// Notify any observers of the change in the data set.
            getContext().getContentResolver().notifyChange(insertedId, null);
//            Toast.makeText(getContext(), "inserting", Toast.LENGTH_LONG).show();
            return insertedId;
        } else
//        Toast.makeText(getContext(),"noinsert",Toast.LENGTH_LONG).show();
            return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
// If this is a row URI, limit the deletion to the specified row.
        switch (uriMatcher.match(uri)) {
            case SINGLE_ROW:
                String rowID = uri.getPathSegments().get(1);
                selection = KEY_ID + "=" + rowID
                        + (!TextUtils.isEmpty(selection) ?
                        "AND (" + selection + ')' : "");
            default:
                break;
        }
// To return the number of deleted items, you must specify a where
// clause. To delete all rows and return a value, pass in “1”.
        if (selection == null)
            selection = "1";

// Execute the deletion.
        int deleteCount = db.delete(MySQLiteOpenHelper.DATABASE_TABLE, selection,
                selectionArgs);
// Notify any observers of the change in the data set.
        getContext().getContentResolver().notifyChange(uri, null);
        return deleteCount;
    }

    @Override
    public int update(Uri uri, ContentValues values,
                      String selection, String[] selectionArgs) {
        SQLiteDatabase db = myOpenHelper.getWritableDatabase();
// If this is a row URI, limit the deletion to the specified row.
        switch (uriMatcher.match(uri)) {
            case SINGLE_ROW:
                String rowID = uri.getPathSegments().get(1);
                selection = KEY_ID + "=" + rowID
                        + (!TextUtils.isEmpty(selection) ?
                        " AND (" + selection + ')' : "");
            default:
                break;
        }
// Perform the update.
        int updateCount = db.update(MySQLiteOpenHelper.DATABASE_TABLE,
                values, selection, selectionArgs);
// Notify any observers of the change in the data set.
        getContext().getContentResolver().notifyChange(uri, null);
        return updateCount;
    }

    private static class MySQLiteOpenHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "bdatabase.db";
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NTABLE ="cdatatable";
        private static final String DATABASE_TABLE = "bdatatable";
        private static final String DATABASE_CREATE = "create table " +
                DATABASE_TABLE + " (" + KEY_ID +
                " integer primary key autoincrement, " +
                KEY_THE_NAME + " text not null, "+ KEY_FROM_WHO + " text not null, " + KEY_TO_WHO + " text not null, " + KEY_TYPI + " integer, " +
                KEY_DATE + " text not null, " + KEY_TIME + " text not null, " + KEY_BODY+ " text not null, " + KEY_COMMENT_IMAGE + " integer" + ");";


        public MySQLiteOpenHelper(Context context, String name,
                                  SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // Called when no database exists in disk and the helper class needs
// to create a new one.
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
//            db.execSQL(DRATABASE_CREATE);

// TODO Create database tables.
        }

        // Called when there is a database version mismatch meaning that the version
// of the database on disk needs to be upgraded to the current version.
        @Override

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Upgrade database.
            // The simplest case is to drop the old table and create a new one.
//            Toast.makeText(,"Upgrading from "+String.valueOf(oldVersion)+ "to"+String.valueOf(newVersion),Toast.LENGTH_LONG).show();
            db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_TABLE);

// Create a new one.
            onCreate(db);

        }
    }
}
