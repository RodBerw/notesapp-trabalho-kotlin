package br.edu.up.app

import android.app.Application
import android.content.Context
import br.edu.up.app.data.*
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@HiltAndroidApp
@InstallIn(SingletonComponent::class)
class AppNotes : Application() {

    @Provides
    fun provideNoteRepository(notesDao: NotesDao)
            : NoteRepository{
        return NoteRepositorySQLite(notesDao)
    }

    @Provides
    fun provideNoteRepositoryFirebase(notesRef: CollectionReference)
            : NoteRepositoryFirebase {
        return  NoteRepositoryFirebase(notesRef)
    }

    @Provides
    fun provideNoteDao(banco: BancoSQLite) : NotesDao{
        return banco.noteDao()
    }
    @Provides
    fun provideNotesRef(): CollectionReference{
        return Firebase.firestore.collection("notes")
    }


    @Provides
    @Singleton
    fun provideBanco(@ApplicationContext ctx: Context) : BancoSQLite{
        return BancoSQLite.get(ctx)
    }

}