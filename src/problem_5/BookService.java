package problem_5;

import java.util.List;

public interface BookService {

    List<Book> findBookByAuthor(String author);

}