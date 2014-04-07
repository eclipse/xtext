/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.ui.tests.editor.ContentAssistTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ContentAssistForTest5 extends ContentAssistTest {
  protected String getPrefix() {
    return "for( var x = 1; x < 10; x++,";
  }
  
  protected String[] getKeywordsAndStatics() {
    String[] _keywordsAndStatics = super.getKeywordsAndStatics();
    final ArrayList<String> result = CollectionLiterals.<String>newArrayList(_keywordsAndStatics);
    result.add("x");
    return ((String[])Conversions.unwrapArray(result, String.class));
  }
}
