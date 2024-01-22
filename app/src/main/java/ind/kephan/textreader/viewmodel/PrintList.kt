package ind.kephan.textreader.viewmodel

import ind.kephan.textreader.model.data.BookList

class PrintList(bookList: BookList) {
    private val numb: Int = bookList.getNum()
    private val names: MutableList<String> = bookList.getNames()
    private val pages: MutableList<Int> = bookList.getPages()

    fun getNumb(): Int {
        return numb
    }

    fun getNames(): MutableList<String> {
        return names
    }

    fun getPages(): MutableList<Int> {
        return pages
    }
}