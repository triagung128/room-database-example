package com.triagung.roomdatabaseexample.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.triagung.roomdatabaseexample.model.Note
import com.triagung.roomdatabaseexample.repository.NoteRepository

class NoteAddUpdateViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }

    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }
}