package org.eclipse.xtend.core.tests.smoke;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Case_7 {
  public Map.Entry<String, List<String>> bug345449() {
    Map.Entry<String, List<String>> _xblockexpression = null;
    {
      final ArrayList<Map.Entry<String, List<String>>> result = CollectionLiterals.<Map.Entry<String, List<String>>>newArrayList();
      Map.Entry<String, List<String>> _head = null;
      if (result!=null) {
        _head=IterableExtensions.<Map.Entry<String, List<String>>>head(result);
      }
      _xblockexpression = _head;
    }
    return _xblockexpression;
  }
  
  public Object bug345452() {
    Object _xblockexpression = null;
    {
      CharSequence x = null;
      Object _xifexpression = null;
      if ((x instanceof Map.Entry)) {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
