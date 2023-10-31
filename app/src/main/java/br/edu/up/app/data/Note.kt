package br.edu.up.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var docId: String,
    var notation: String
)
{
    constructor():this(
        0,
        "",
        "",
    )
}