package problem_5;
public class FakeBookValidatorService implements BookValidatorService {

    @Override
    public boolean isValid(Book book) {
        if (book == null)
            return false;

        if ("bot".equals(book.getName())) {
            return false;
        } else {
            return true;
        }

    }
}