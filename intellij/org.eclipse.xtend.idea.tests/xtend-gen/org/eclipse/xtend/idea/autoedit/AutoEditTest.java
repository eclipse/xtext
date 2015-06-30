/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autoedit;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend.idea.autoedit.AbstractCStyleLanguageAutoEditTest;
import org.eclipse.xtext.idea.tests.LibraryUtil;
import org.junit.Ignore;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AutoEditTest extends AbstractCStyleLanguageAutoEditTest {
  public AutoEditTest() {
    super(XtendFileType.INSTANCE);
  }
  
  @Override
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
    LibraryUtil.addXtendLibrary(model);
  }
  
  @Ignore
  @Override
  public void testSingleQuotedStringLiteral_15() {
  }
}
