package org.eclipse.xtext.xbase.tests.lib.internal;

import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class MyEntity {
  private final boolean boolProp = true;
  
  private final int intProp = 42;
  
  private final ArrayList<String> myList = new Function0<ArrayList<String>>() {
    public ArrayList<String> apply() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
      return _newArrayList;
    }
  }.apply();
  
  private final MyEntity friend;
  
  public MyEntity() {
    this.friend = null;
  }
  
  public MyEntity(final MyEntity friend) {
    this.friend = friend;
  }
  
  public String toString() {
    String _plus = ("" + Boolean.valueOf(this.boolProp));
    String _plus_1 = (_plus + "\n");
    String _plus_2 = (_plus_1 + Integer.valueOf(this.intProp));
    String _plus_3 = (_plus_2 + "\n");
    String _plus_4 = (_plus_3 + this.myList);
    String _plus_5 = (_plus_4 + "\n");
    return (_plus_5 + this.friend);
  }
}
