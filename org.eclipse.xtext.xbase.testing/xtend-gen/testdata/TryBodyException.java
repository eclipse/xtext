package testdata;

@SuppressWarnings("all")
public class TryBodyException extends Exception {
  private final String text = "Exception in try (with resources) body";
  
  public String getText() {
    return this.text;
  }
}
