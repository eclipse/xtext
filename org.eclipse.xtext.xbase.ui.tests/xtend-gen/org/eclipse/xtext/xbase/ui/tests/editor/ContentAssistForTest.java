/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import org.eclipse.xtext.xbase.ui.tests.editor.ContentAssistTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ContentAssistForTest extends ContentAssistTest {
  @Override
  protected String getPrefix() {
    return "for(";
  }
  
  @Override
  protected String getSuffix() {
    return ", var z = 1";
  }
  
  @Override
  public void testEmptyInput() throws Exception {
    this.newBuilder().assertText(this.expect(this.getKeywordsAndStatics(), new String[] { "var", "val" }));
  }
}
