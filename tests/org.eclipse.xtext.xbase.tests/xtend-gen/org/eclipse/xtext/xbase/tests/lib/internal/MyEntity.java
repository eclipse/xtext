package org.eclipse.xtext.xbase.tests.lib.internal;

import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class MyEntity {
  private final boolean boolProp = true;
  
  private final int intProp = 42;
  
  private final ArrayList<String> myList = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
  
  private final MyEntity friend;
  
  private final RetentionPolicy policy = RetentionPolicy.CLASS;
  
  public MyEntity() {
    this.friend = null;
  }
  
  public MyEntity(final MyEntity friend) {
    this.friend = friend;
  }
  
  public String toString() {
    String _plus = (Boolean.valueOf(this.boolProp) + "\n");
    String _plus_1 = (_plus + Integer.valueOf(this.intProp));
    String _plus_2 = (_plus_1 + "\n");
    String _plus_3 = (_plus_2 + this.myList);
    String _plus_4 = (_plus_3 + "\n");
    String _plus_5 = (_plus_4 + this.friend);
    String _plus_6 = (_plus_5 + "\n");
    return (_plus_6 + this.policy);
  }
}
