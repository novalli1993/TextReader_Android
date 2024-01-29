package ind.kephan.textreader.model.data.operator

import ind.kephan.textreader.model.data.Chapter
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class ChapterRepository(private val chapterDao: ChapterDao) {
    suspend fun addChapter(chapter: Chapter) {
        withContext(IO) {
            chapterDao.addChapter(chapter)
        }
    }

    suspend fun addChapter(chapter: List<Chapter>) {
        withContext(IO) {
            chapterDao.addChapter(chapter)
        }
    }

    suspend fun updateChapter(chapter: Chapter){
        withContext(IO) {
            chapterDao.updateChapter(chapter)
        }
    }

    suspend fun deleteChapter(chapter: Chapter){
        withContext(IO) {
            chapterDao.deleteChapter(chapter)
        }
    }

    fun getChapterById(bookId: Long, id: Long): Chapter {
        return chapterDao.getChapterById(bookId, id)
    }

    fun getAllChapters(bookId: Long): List<Chapter> {
        return chapterDao.getAllChapters(bookId)
    }


    // 单例模式
    companion object {
        private var instance: ChapterRepository? = null

        fun getInstance(chapterDao: ChapterDao): ChapterRepository {
            return instance ?: synchronized(this){
                instance ?: ChapterRepository(chapterDao).also { instance = it }
            }
        }
    }
}