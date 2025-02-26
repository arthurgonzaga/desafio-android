package com.arthurgonzaga.wikistarwars.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arthurgonzaga.wikistarwars.util.toEntity
import io.reactivex.rxjava3.core.Observable
import java.io.Serializable

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String = "",
    val height: String = "",
    val weight: String = "",
    @ColumnInfo(name = "hair_color")
    val hairColor: String = "",
    @ColumnInfo(name = "skin_color")
    val skinColor: String = "",
    @ColumnInfo(name = "eye_color")
    val eyeColor: String = "",
    @ColumnInfo(name = "birth_year")
    val birthYear: String = "",
    val gender: String = "",
    @ColumnInfo(name = "specie_name")
    val specieName: String? = null,
    @ColumnInfo(name = "home_world_name")
    val homeWoldName: String? = null,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false,
    @ColumnInfo(name = "is_synchronized_with_backend")
    val isSynchronizedWithBackend: Boolean = false,
): Serializable
