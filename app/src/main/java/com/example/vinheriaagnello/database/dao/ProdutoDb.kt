package com.example.vinheriaagnello.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.vinheriaagnello.model.Produto

@Database(entities = [Produto::class], version = 1)
abstract class ProdutoDb: RoomDatabase(){

    abstract fun produtoDao(): ProdutoDao

        companion object{

            private lateinit var instance: ProdutoDb

                fun getDatabase(context: Context): ProdutoDb{
                    if (!::instance.isInitialized){
                        instance = Room
                            .databaseBuilder(
                                context,
                                ProdutoDb::class.java,
                                "produto_db"
                            )
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                    return instance
                }
        }
}

