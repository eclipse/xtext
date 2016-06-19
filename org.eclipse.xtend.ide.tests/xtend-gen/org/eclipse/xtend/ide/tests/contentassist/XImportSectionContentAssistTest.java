/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XImportSectionContentAssistTest extends AbstractXtendContentAssistBugTest {
  @Test
  public void testMemberName() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.");
      int _length = "Foo.".length();
      final ContentAssistProcessorTestBuilder builder = _append.assertTextAtCursorPosition("Foo.", _length, "publicStaticMethod", "publicStaticField");
      ContentAssistProcessorTestBuilder _applyProposal = builder.applyProposal("publicStaticMethod");
      _applyProposal.expectContent("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticMethod");
      ContentAssistProcessorTestBuilder _applyProposal_1 = builder.applyProposal("publicStaticField");
      _applyProposal_1.expectContent("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticField");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMemberName_2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticM");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar {}");
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      int _length = "publicStaticM".length();
      _append.assertTextAtCursorPosition("publicStaticM", _length, "publicStaticMethod");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMemberName_3() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.");
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      final ContentAssistProcessorTestBuilder builder = _append.assertText("publicStaticMethod", "defaultStaticMethod", "protectedStaticMethod", 
        "publicStaticField", "defaultStaticField", "protectedStaticField");
      ContentAssistProcessorTestBuilder _applyProposal = builder.applyProposal("publicStaticMethod");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticMethod");
      _applyProposal.expectContent(_builder_1.toString());
      ContentAssistProcessorTestBuilder _applyProposal_1 = builder.applyProposal("defaultStaticMethod");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.defaultStaticMethod");
      _applyProposal_1.expectContent(_builder_2.toString());
      ContentAssistProcessorTestBuilder _applyProposal_2 = builder.applyProposal("protectedStaticMethod");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.protectedStaticMethod");
      _applyProposal_2.expectContent(_builder_3.toString());
      ContentAssistProcessorTestBuilder _applyProposal_3 = builder.applyProposal("publicStaticField");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.publicStaticField");
      _applyProposal_3.expectContent(_builder_4.toString());
      ContentAssistProcessorTestBuilder _applyProposal_4 = builder.applyProposal("defaultStaticField");
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_5.newLine();
      _builder_5.newLine();
      _builder_5.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.defaultStaticField");
      _applyProposal_4.expectContent(_builder_5.toString());
      ContentAssistProcessorTestBuilder _applyProposal_5 = builder.applyProposal("protectedStaticField");
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder_6.newLine();
      _builder_6.newLine();
      _builder_6.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.protectedStaticField");
      _applyProposal_5.expectContent(_builder_6.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMemberName_4() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package org.eclipse.xtend.ide.tests.data.contentassist");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import static org.eclipse.xtend.ide.tests.data.contentassist.Foo.default");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar {}");
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      int _length = "default".length();
      _append.assertTextAtCursorPosition("default", _length, "defaultStaticMethod", "defaultStaticField");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
