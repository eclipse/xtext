/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autoedit;

import com.intellij.psi.PsiFile;
import org.eclipse.xtend.idea.autoedit.AutoEditTest;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AutoEditInMethodBodyTest extends AutoEditTest {
  private final static String PREFIX = "class Foo {\n\tfoo() {\n";
  
  private final static String SUFFIX = "\n}\n}";
  
  @Override
  protected PsiFile configureByText(final String code) {
    return super.configureByText(((AutoEditInMethodBodyTest.PREFIX + code) + AutoEditInMethodBodyTest.SUFFIX));
  }
  
  @Override
  protected void assertState(final String editorState) {
    super.assertState(((AutoEditInMethodBodyTest.PREFIX + editorState) + AutoEditInMethodBodyTest.SUFFIX));
  }
}
