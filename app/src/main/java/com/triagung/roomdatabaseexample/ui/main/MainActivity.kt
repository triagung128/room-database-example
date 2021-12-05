package com.triagung.roomdatabaseexample.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.triagung.roomdatabaseexample.databinding.ActivityMainBinding
import com.triagung.roomdatabaseexample.helper.ViewModelFactory
import com.triagung.roomdatabaseexample.ui.insert.NoteAddUpdateActivity
import com.triagung.roomdatabaseexample.ui.main.adapter.NoteAdapter
import com.triagung.roomdatabaseexample.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainViewModel = obtainViewModel(this)
        mainViewModel.getAllNotes().observe(this, { noteList ->
            if (noteList != null) {
                noteAdapter.setListNotes(noteList)
            }
        })

        noteAdapter = NoteAdapter()

        binding.rvNotes.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = noteAdapter
        }

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, NoteAddUpdateActivity::class.java)
            startActivity(intent)
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): MainViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[MainViewModel::class.java]
    }
}