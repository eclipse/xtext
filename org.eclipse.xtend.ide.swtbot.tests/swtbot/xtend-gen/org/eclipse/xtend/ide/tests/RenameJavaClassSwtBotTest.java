/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests;

import java.util.Collection;
import java.util.Collections;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@RunWith(ParameterizedSWTBotRunner.class)
@Ignore
@SuppressWarnings("all")
public class RenameJavaClassSwtBotTest extends AbstractRefactoringSwtBotTest {
  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    RefactoringTestParameters _refactoringTestParameters = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(true);
      it.setUsePreview(false);
    };
    RefactoringTestParameters _doubleArrow = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters, _function);
    return Collections.<Object[]>unmodifiableList(CollectionLiterals.<Object[]>newArrayList(new Object[] { _doubleArrow }));
  }

  public RenameJavaClassSwtBotTest(final RefactoringTestParameters testParams) {
    super(testParams);
  }

  @Test
  public void renameJavaClass() {
    SWTWorkbenchBot _bot = this.getBot();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.append("class XtendClass extends JavaClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final SWTBotEclipseEditor xtendEditor = SwtBotProjectHelper.newXtendEditor(_bot, "XtendClass", "test", _builder);
    SWTWorkbenchBot _bot_1 = this.getBot();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test;");
    _builder_1.newLine();
    _builder_1.append("public class ?JavaClass? {}");
    _builder_1.newLine();
    final SWTBotEclipseEditor javaEditor = SwtBotProjectHelper.newJavaEditor(_bot_1, "JavaClass", "test", _builder_1);
    this.renameInJavaEditor(javaEditor, "NewJavaClass", "Rename Type");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package test");
    _builder_2.newLine();
    _builder_2.append("class XtendClass extends NewJavaClass {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertEquals(_builder_2, xtendEditor.getText());
    Assert.assertFalse(xtendEditor.isDirty());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("package test;");
    _builder_3.newLine();
    _builder_3.append("public class NewJavaClass {}");
    _builder_3.newLine();
    this.assertEquals(_builder_3, javaEditor.getText());
    Assert.assertFalse(javaEditor.isDirty());
    this.assertEquals("NewJavaClass.java", javaEditor.getTitle());
  }

  @Test
  public void renameJavaClassXtendReference() {
    SWTWorkbenchBot _bot = this.getBot();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test;");
    _builder.newLine();
    _builder.append("public class JavaClass {}");
    _builder.newLine();
    final SWTBotEclipseEditor javaEditor = SwtBotProjectHelper.newJavaEditor(_bot, "JavaClass", "test", _builder);
    SWTWorkbenchBot _bot_1 = this.getBot();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test");
    _builder_1.newLine();
    _builder_1.append("class XtendClass extends ?JavaClass? {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final SWTBotEclipseEditor xtendEditor = SwtBotProjectHelper.newXtendEditor(_bot_1, "XtendClass", "test", _builder_1);
    this.renameInXtendEditor(xtendEditor, "NewJavaClass", "Rename Type");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package test");
    _builder_2.newLine();
    _builder_2.append("class XtendClass extends NewJavaClass {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertEquals(_builder_2, xtendEditor.getText());
    Assert.assertFalse(xtendEditor.isDirty());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("package test;");
    _builder_3.newLine();
    _builder_3.append("public class NewJavaClass {}");
    _builder_3.newLine();
    this.assertEquals(_builder_3, javaEditor.getText());
    Assert.assertFalse(javaEditor.isDirty());
    this.assertEquals("NewJavaClass.java", javaEditor.getTitle());
  }
}
