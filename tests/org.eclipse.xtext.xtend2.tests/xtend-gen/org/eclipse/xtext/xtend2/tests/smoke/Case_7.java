package org.eclipse.xtext.xtend2.tests.smoke;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Case_7 {
  
  public Entry<String,List<String>> bug345449() {
    Entry<String,List<String>> _xblockexpression = null;
    {
      ArrayList<Entry<String,List<String>>> _newArrayList = CollectionLiterals.<Entry<String,List<String>>>newArrayList();
      final ArrayList<Entry<String,List<String>>> result = _newArrayList;
      Entry<String,List<String>> _head = result==null?(Entry<String,List<String>>)null:IterableExtensions.<Entry<String,List<String>>>head(result);
      _xblockexpression = (_head);
    }
    return _xblockexpression;
  }
  
  public Object bug345452() {
    Object _xblockexpression = null;
    {
      CharSequence x = null;
      Object _xifexpression = null;
      if ((x instanceof java.util.Map.Entry)) {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}