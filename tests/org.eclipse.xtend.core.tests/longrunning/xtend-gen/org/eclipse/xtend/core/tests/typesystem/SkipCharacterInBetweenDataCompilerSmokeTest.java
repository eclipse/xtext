/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtend.core.tests.typesystem.AbstractDataCompilerSmokeTest;
import org.eclipse.xtext.xbase.lib.IntegerRange;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SkipCharacterInBetweenDataCompilerSmokeTest extends AbstractDataCompilerSmokeTest {
  public void assertNonSmoking(final CharSequence input) throws Exception {
    final String string = input.toString();
    int _length = input.length();
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      int _length_1 = input.length();
      int _minus = (_length_1 - 2);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for (final Integer i : _upTo) {
        String _substring = string.substring(0, (i).intValue());
        String _substring_1 = string.substring(((i).intValue() + 1));
        String _plus = (_substring + _substring_1);
        this.processFile(_plus);
      }
    }
  }
}
