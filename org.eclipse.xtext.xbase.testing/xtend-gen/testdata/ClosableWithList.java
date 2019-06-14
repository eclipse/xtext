package testdata;

import java.util.List;
import testdata.AbstractClosableWithList;

@SuppressWarnings("all")
public class ClosableWithList extends AbstractClosableWithList {
  public ClosableWithList() {
  }
  
  public ClosableWithList(final List<String> collector) {
    collector.addAll(this.list);
    this.list = collector;
  }
  
  @Override
  public void close() {
    this.list.add("close");
  }
}
