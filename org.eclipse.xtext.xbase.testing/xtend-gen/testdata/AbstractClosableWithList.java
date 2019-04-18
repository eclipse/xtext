package testdata;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public abstract class AbstractClosableWithList implements AutoCloseable {
  private List<String> list;
  
  public AbstractClosableWithList() {
    ArrayList<String> _arrayList = new ArrayList<String>();
    this.list = _arrayList;
    this.list.add("new");
  }
  
  public void add(final String entry) {
    this.list.add(entry);
  }
  
  public List<String> getList() {
    return this.list;
  }
  
  public String printList() {
    return this.list.toString();
  }
}
