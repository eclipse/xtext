/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.tests.issues;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType;
import org.eclipse.xtext.idea.tests.LightToolingTest;

@SuppressWarnings("all")
public class IssueAnnotatorTest extends LightToolingTest {
  public IssueAnnotatorTest() {
    super(SDomainFileType.INSTANCE);
  }
  
  public void testErrorsAndWarnings() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity <warning descr=\"Name should start with a capital\">foo</warning> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<error descr=\"Couldn\'t resolve reference to Type \'Bar\'.\">Bar</error> bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.myFixture.checkHighlighting();
  }
  
  public void testNoDuplicateSyntaxErrors() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<error descr=\"missing EOF at \'{\'\">{</error>}");
    this.configureByText(_builder.toString());
    this.myFixture.checkHighlighting();
  }
}
