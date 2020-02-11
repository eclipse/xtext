/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
public class ContentAssistForTest7 extends ContentAssistTest {
  @Override
  protected String getPrefix() {
    return "for( var x = 1; x < 10; x++) (";
  }
  
  @Override
  protected String getSuffix() {
    return ")";
  }
  
  @Override
  protected String[] getKeywordsAndStatics() {
    final ArrayList<String> result = CollectionLiterals.<String>newArrayList(super.getKeywordsAndStatics());
    result.add("x");
    return ((String[])Conversions.unwrapArray(result, String.class));
  }
}
