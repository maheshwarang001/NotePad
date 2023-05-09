package com.example.notepad.di

import android.app.Application
import androidx.room.Room
import com.example.notepad.feature_note.data.data_source.DB
import com.example.notepad.feature_note.data.repository.NoteRepoImplementation
import com.example.notepad.feature_note.domain.repository.NoteRepository
import com.example.notepad.feature_note.domain.use_cases.AddNotesUseCase
import com.example.notepad.feature_note.domain.use_cases.DeleteNotesUseCase
import com.example.notepad.feature_note.domain.use_cases.GetNotesUseCase
import com.example.notepad.feature_note.domain.use_cases.MainUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDB(app:Application): DB {

        return Room.databaseBuilder(
            app,
            DB::class.java,
            DB.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepo(db: DB):NoteRepository{
        return NoteRepoImplementation(db.noteDAO)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: NoteRepository):MainUseCase{
        return MainUseCase(
            getNotes = GetNotesUseCase(repository),
            deleteNotes = DeleteNotesUseCase(repository),
            editeNotes = AddNotesUseCase(repository)

        )
    }


}