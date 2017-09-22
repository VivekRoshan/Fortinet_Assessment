package problem_5;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
public class AuthorServiceTest {

    @Test
    public void test_total_book_by_mock() {

		//1. Setup
        AuthorServiceImpl obj = new AuthorServiceImpl();

        /*BookServiceImpl bookService = new BookServiceImpl();
        bookService.setBookDao(new BookDaoImpl()); //Where Dao connect to?
        obj.setBookService(bookService);
        */
        
        //added mock db line
        obj.setBookService(new MockBookServiceImpl());
        obj.setBookValidatorService(new FakeBookValidatorService());

		//2. Test method
        int qty = obj.getTotalBooks("fortinet");

		//3. Verify result
        assertThat(qty, is(2));

    }

}