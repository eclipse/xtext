/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package lazy;

import lazy.Lazy;

@SuppressWarnings("all")
public class LazyExample {
  @Lazy
  private String foo;
  
  @Lazy
  private Integer another;
  
  private String _initfoo() {
    return "holla";
  }
  
  public String getFoo() {
    if (foo==null)
      foo = _initfoo();
    return foo;
  }
  
  private Integer _initanother() {
    String _foo = this.getFoo();
    int _length = _foo.length();
    int _multiply = (42 * _length);
    return Integer.valueOf(_multiply);
  }
  
  public Integer getAnother() {
    if (another==null)
      another = _initanother();
    return another;
  }
}
