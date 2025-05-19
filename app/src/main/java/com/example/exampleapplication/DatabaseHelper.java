package com.example.exampleapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_database";
    private static final int DATABASE_VERSION = 3;  // Updated version for email column

    // Users table columns
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_EMAIL = "email";  // New column for email

    // Favorites table columns
    public static final String TABLE_FAVORITES = "favorites";
    public static final String COLUMN_RECIPE_ID = "id";
    public static final String COLUMN_RECIPE_NAME = "recipe_name";

    // SQL queries to create tables
    private static final String CREATE_USERS_TABLE =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERNAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_PHONE_NUMBER + " TEXT, " +
                    COLUMN_ADDRESS + " TEXT, " +
                    COLUMN_EMAIL + " TEXT" +  // Add email column to the users table
                    ");";

    private static final String CREATE_FAVORITES_TABLE =
            "CREATE TABLE " + TABLE_FAVORITES + " (" +
                    COLUMN_RECIPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_RECIPE_NAME + " TEXT" +
                    ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the users and favorites tables
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_FAVORITES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop and recreate tables if database version changes
        if (oldVersion < 3) {
            // Add email column to the users table in case of an upgrade
            db.execSQL("ALTER TABLE " + TABLE_USERS + " ADD COLUMN " + COLUMN_EMAIL + " TEXT");
        }
    }

    // Method to insert user data into the users table
    public boolean insertUser(String username, String password, String phoneNumber, String address, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_PASSWORD, password);
        contentValues.put(COLUMN_PHONE_NUMBER, phoneNumber);
        contentValues.put(COLUMN_ADDRESS, address);
        contentValues.put(COLUMN_EMAIL, email);  // Insert email value

        long result = db.insert(TABLE_USERS, null, contentValues);
        db.close();

        return result != -1;
    }

    // Method to get user by username and password
    public Cursor getUserByUsernameAndPassword(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        return db.rawQuery(query, new String[]{username, password});
    }

    // Method to insert a favorite recipe into the favorites table
    public boolean addFavoriteRecipe(String recipeName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_RECIPE_NAME, recipeName);

        long result = db.insert(TABLE_FAVORITES, null, contentValues);
        db.close();

        return result != -1;
    }

    // Method to get all favorite recipes
    public Cursor getAllFavoriteRecipes() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_FAVORITES;
        return db.rawQuery(query, null);
    }

    // Method to check if a recipe is already added to favorites
    public boolean isRecipeFavorite(String recipeName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_FAVORITES + " WHERE " + COLUMN_RECIPE_NAME + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{recipeName});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    // Method to remove a favorite recipe
    public boolean removeFavoriteRecipe(String recipeName) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(TABLE_FAVORITES, COLUMN_RECIPE_NAME + " = ?", new String[]{recipeName});
        db.close();
        return rowsDeleted > 0;
    }
}
