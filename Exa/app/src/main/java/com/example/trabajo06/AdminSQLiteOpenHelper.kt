package com.example.trabajo06

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
class AdminSQLiteOpenHelper(context: Context, name: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version)  {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table articulos(codigo int primary key, descripcion text, precio real)")
        db.execSQL("create table alumnos(numero_control int primary key, nombre text, edad int)")
        db.execSQL("create table maestros(rfc text primary key, nombre text, experiencia text)")
        db.execSQL("create table materias(aula text primary key, nombre text, creditos int)")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}