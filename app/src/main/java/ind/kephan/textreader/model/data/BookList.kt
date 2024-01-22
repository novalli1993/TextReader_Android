package ind.kephan.textreader.model.data

class BookList(book: Book) {
    private var totalNum = 0
    private val bookList = mutableListOf<Book>()

    init {
        totalNum = 1
        bookList.add(book)
    }

    fun addBook(book: Book) {
        this.bookList.add(book)
        totalNum += 1
    }

    fun getNum(): Int {
        return this.totalNum
    }

    fun getNames(): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        for (i in bookList){
            list.add(i.name)
        }
        return list
    }

    fun getPages(): MutableList<Int> {
        val list: MutableList<Int> = mutableListOf()
        for (i in bookList){
            list.add(i.page)
        }
        return list
    }

    fun getPaths(): MutableList<String> {
        val list: MutableList<String> = mutableListOf()
        for (i in bookList){
            list.add(i.path)
        }
        return list
    }
}