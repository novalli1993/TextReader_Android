package ind.kephan.textreader.model.operator

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ind.kephan.textreader.model.data.Book
import ind.kephan.textreader.model.data.Chapter

@Dao
interface ChapterDao {
    @Query("SELECT * FROM chapters WHERE bookId = :bookId AND id = :id")
    fun getChapterById(bookId: Long, id: Long): Chapter
    @Query("SELECT * FROM chapters WHERE bookId = :bookId ORDER BY id")
    fun getAllChapters(bookId: Long): List<Chapter>
    @Insert
    fun addChapter(chapter: Chapter)
    @Insert
    fun addChapter(chapters: List<Chapter>)
    @Update
    fun updateChapter(chapter: Chapter)
    @Delete
    fun deleteChapter(chapter: Chapter)
}