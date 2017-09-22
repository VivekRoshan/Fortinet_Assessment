package problem_4;

public abstract class Factory {
	 protected abstract PrintType printDocument(String selection);
	 protected abstract void setPrinter(int option);
}