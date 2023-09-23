package br.edu.up.app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile

@Database(entities = [Produto::class], version = 1)
abstract class Banco : RoomDatabase() {

    abstract fun produtoDao(): ProdutoDao
    companion object{

        @Volatile
        private var INSTANCE: Banco? = null

        fun get(context: Context): Banco {
            if (INSTANCE == null) {

                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Banco::class.java,
                        "meu_banco.db"
                        ).build()
                }
            }
            return INSTANCE!!
        }

    }
}