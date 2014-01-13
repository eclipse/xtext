/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 */
package example3;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class BottleSupport {
  public static String bottles(final int i) {
    String _switchResult = null;
    switch (i) {
      case 0:
        _switchResult = "no more bottles";
        break;
      case 1:
        _switchResult = "one bottle";
        break;
      default:
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(i, "");
        _builder.append(" bottles");
        _switchResult = _builder.toString();
        break;
    }
    return _switchResult.toString();
  }
  
  public static String Bottles(final int i) {
    String _bottles = BottleSupport.bottles(i);
    return StringExtensions.toFirstUpper(_bottles);
  }
}
