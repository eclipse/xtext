package testdata;

@SuppressWarnings("all")
public class CloseException extends Exception {
  private final String text = "Exception on close";
  
  public String getText() {
    return this.text;
  }
}
