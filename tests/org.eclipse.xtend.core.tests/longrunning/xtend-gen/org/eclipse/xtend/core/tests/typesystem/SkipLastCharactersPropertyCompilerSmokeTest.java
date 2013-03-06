/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtend.core.tests.typesystem.AbstractPropertyCompilerSmokeTest;
import org.eclipse.xtext.xbase.lib.IntegerRange;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SkipLastCharactersPropertyCompilerSmokeTest extends AbstractPropertyCompilerSmokeTest {
  public void assertNonSmoking(final CharSequence input) throws Exception {
    final String string = input.toString();
    int _length = input.length();
    int _minus = (_length - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    for (final Integer i : _upTo) {
      String _substring = string.substring(0, (i).intValue());
      this.processFile(_substring);
    }
  }
}
