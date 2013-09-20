/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests;

import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.xtend.ide.tests.AbstractRefactoringSwtBotTest;
import org.eclipse.xtend.ide.tests.ParameterizedSWTBotRunner;
import org.eclipse.xtend.ide.tests.RefactoringTestParameters;
import org.eclipse.xtend.ide.tests.SwtBotProjectHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@RunWith(ParameterizedSWTBotRunner.class)
@SuppressWarnings("all")
public class RenameJavaClassSwtBotTest extends AbstractRefactoringSwtBotTest {
  @Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    RefactoringTestParameters _refactoringTestParameters = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function = new Procedure1<RefactoringTestParameters>() {
      public void apply(final RefactoringTestParameters it) {
        it.setUseInlineRefactoring(true);
        it.setUsePreview(false);
      }
    };
    RefactoringTestParameters _doubleArrow = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters, _function);
    return Collections.<Object[]>unmodifiableList(Lists.<Object[]>newArrayList(new Object[] { _doubleArrow }));
  }
  
  public RenameJavaClassSwtBotTest(final RefactoringTestParameters testParams) {
    super(testParams);
  }
  
  @Test
  public void renameJavaClass() {
    SWTWorkbenchBot _bot = this.getBot();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class XtendClass extends JavaClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final SWTBotEclipseEditor xtendEditor = SwtBotProjectHelper.newXtendEditor(_bot, "XtendClass", _builder);
    SWTWorkbenchBot _bot_1 = this.getBot();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class ?JavaClass? {}");
    _builder_1.newLine();
    final SWTBotEclipseEditor javaEditor = SwtBotProjectHelper.newJavaEditor(_bot_1, "JavaClass", _builder_1);
    this.renameInJavaEditor(javaEditor, "NewJavaClass", "Rename Type");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("class XtendClass extends NewJavaClass {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    String _text = xtendEditor.getText();
    this.assertEquals(_builder_2, _text);
    boolean _isDirty = xtendEditor.isDirty();
    Assert.assertFalse(_isDirty);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("public class NewJavaClass {}");
    _builder_3.newLine();
    String _text_1 = javaEditor.getText();
    this.assertEquals(_builder_3, _text_1);
    boolean _isDirty_1 = javaEditor.isDirty();
    Assert.assertFalse(_isDirty_1);
    String _title = javaEditor.getTitle();
    this.assertEquals("NewJavaClass.java", _title);
  }
  
  @Test
  public void renameJavaClassXtendReference() {
    SWTWorkbenchBot _bot = this.getBot();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class JavaClass {}");
    _builder.newLine();
    final SWTBotEclipseEditor javaEditor = SwtBotProjectHelper.newJavaEditor(_bot, "JavaClass", _builder);
    SWTWorkbenchBot _bot_1 = this.getBot();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class XtendClass extends ?JavaClass? {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final SWTBotEclipseEditor xtendEditor = SwtBotProjectHelper.newXtendEditor(_bot_1, "XtendClass", _builder_1);
    this.renameInXtendEditor(xtendEditor, "NewJavaClass", "Rename Type");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("class XtendClass extends NewJavaClass {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    String _text = xtendEditor.getText();
    this.assertEquals(_builder_2, _text);
    boolean _isDirty = xtendEditor.isDirty();
    Assert.assertFalse(_isDirty);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("public class NewJavaClass {}");
    _builder_3.newLine();
    String _text_1 = javaEditor.getText();
    this.assertEquals(_builder_3, _text_1);
    boolean _isDirty_1 = javaEditor.isDirty();
    Assert.assertFalse(_isDirty_1);
    String _title = javaEditor.getTitle();
    this.assertEquals("NewJavaClass.java", _title);
  }
}
