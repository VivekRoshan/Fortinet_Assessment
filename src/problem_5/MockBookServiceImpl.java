package problem_5;

import java.util.ArrayList;
import java.util.List;

//I am a mock object!
public class MockBookServiceImpl implements BookService {

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<Book> books = new ArrayList<>();

        if ("fortinet".equals(author)) {
            books.add(new Book("fortinet in action"));
            books.add(new Book("vivek in action"));
            books.add(new Book("bot"));
        }

        return books;
    }

    //implements other methods...

}