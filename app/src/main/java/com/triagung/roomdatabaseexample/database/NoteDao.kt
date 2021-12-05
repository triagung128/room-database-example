package com.triagung.roomdatabaseexample.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.triagung.roomdatabaseexample.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM note ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}