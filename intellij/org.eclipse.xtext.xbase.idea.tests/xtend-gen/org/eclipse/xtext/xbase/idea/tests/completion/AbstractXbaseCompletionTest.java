/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.tests.completion;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.LibraryUtil;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.xbase.idea.lang.XbaseFileType;

@SuppressWarnings("all")
public abstract class AbstractXbaseCompletionTest extends LightToolingTest {
  public void testMemberFeatureCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"\".toSt");
    this.myFixture.type(_builder.toString());
    this.myFixture.completeBasic();
    this.assertLookupStrings("toString");
  }
  
  public void testFeatureCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("printl");
    this.myFixture.type(_builder.toString());
    this.myFixture.completeBasic();
    this.assertLookupStrings("println");
  }
  
  public AbstractXbaseCompletionTest() {
    super(XbaseFileType.INSTANCE);
  }
  
  @Override
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
    LibraryUtil.addXbaseLibrary(model);
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    String _prefix = this.getPrefix();
    String _plus = (_prefix + "<caret>");
    String _suffix = this.getSuffix();
    String _plus_1 = (_plus + _suffix);
    this.configureByText(_plus_1);
  }
  
  protected abstract String getPrefix();
  
  protected abstract String getSuffix();
}
