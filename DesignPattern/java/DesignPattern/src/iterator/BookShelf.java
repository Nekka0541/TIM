package iterator;

/**
 * このクラスにいろいろんな処理が集まってくる
 */
public class BookShelf implements Aggregate{
    /**
     * Bookの配列
     */
    private Book[] books;
    private int last = 0;
    /**
     * コンストラクタで本の個数(maxsize)を指定
     * @param maxsize
     */
    public BookShelf(int maxsize){
        this.books = new Book[maxsize];
    }
    public Book getBookAt(int index){
        return books[index];
    }
    /**
     * 本追加
     * @param book
     */
    public void appendBook(Book book){
        this.books[last] = book;
        last++;
    }
    public int getLength(){
        return last;
    }
    /**
     * thisの本棚の数を数え上げたいときに使う
     */
    public Iterator iterator(){
        return new BookShelfIterator(this);
    }
}
