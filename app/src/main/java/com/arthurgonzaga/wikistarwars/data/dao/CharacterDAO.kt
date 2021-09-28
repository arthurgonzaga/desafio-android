package com.arthurgonzaga.wikistarwars.data.dao

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.arthurgonzaga.wikistarwars.data.model.CharacterEntity

import androidx.room.*


@Dao
interface CharacterDAO{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(characterEntity: List<CharacterEntity>): List<Long>


    @Query("SELECT id FROM characters WHERE is_favorite = 1")
    suspend fun getAllFavoritesIds(): List<Int>

    @Query("SELECT * FROM CHARACTERS WHERE is_favorite = 1")
    fun getAllFavoriteCharacters(): PagingSource<Int, CharacterEntity>

    @Query("UPDATE characters SET is_favorite = 1 WHERE id= :id")
    suspend fun favorite(id: Int)

    @Query("UPDATE characters SET is_favorite = 0 WHERE id = :id")
    suspend fun unFavorite(id: Int)

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): PagingSource<Int, CharacterEntity>

    @Query("DELETE FROM characters")
    fun clearCharacters()

    @Query("UPDATE characters SET is_favorite = 1 WHERE id IN (:ids)")
    fun update(
        ids: List<Int>
    )


    @Transaction
    suspend fun upsert(obj: List<CharacterEntity>) {
        val favoriteIds = getAllFavoritesIds()
        clearCharacters()

        insertAll(obj);

        update(favoriteIds)
    }
}