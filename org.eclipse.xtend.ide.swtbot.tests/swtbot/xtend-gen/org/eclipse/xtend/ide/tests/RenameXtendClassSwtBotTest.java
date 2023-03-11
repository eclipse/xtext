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
public class RenameXtendClassSwtBotTest extends AbstractRefactoringSwtBotTest {
  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    RefactoringTestParameters _refactoringTestParameters = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(true);
      it.setUsePreview(false);
    };
    RefactoringTestParameters _doubleArrow = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters, _function);
    RefactoringTestParameters _refactoringTestParameters_1 = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function_1 = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(false);
      it.setUsePreview(false);
    };
    RefactoringTestParameters _doubleArrow_1 = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters_1, _function_1);
    RefactoringTestParameters _refactoringTestParameters_2 = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function_2 = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(true);
      it.setUsePreview(true);
    };
    RefactoringTestParameters _doubleArrow_2 = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters_2, _function_2);
    RefactoringTestParameters _refactoringTestParameters_3 = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function_3 = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(false);
      it.setUsePreview(true);
    };
    RefactoringTestParameters _doubleArrow_3 = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters_3, _function_3);
    return Collections.<Object[]>unmodifiableList(CollectionLiterals.<Object[]>newArrayList(new Object[] { _doubleArrow }, new Object[] { _doubleArrow_1 }, new Object[] { _doubleArrow_2 }, new Object[] { _doubleArrow_3 }));
  }

  public RenameXtendClassSwtBotTest(final RefactoringTestParameters testParams) {
    super(testParams);
  }

  @Test
  public void renameXtendClass() {
    SWTWorkbenchBot _bot = this.getBot();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo extends Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final SWTBotEclipseEditor fooEditor = SwtBotProjectHelper.newXtendEditor(_bot, "Foo", _builder);
    SWTWorkbenchBot _bot_1 = this.getBot();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class ?Bar? {}");
    _builder_1.newLine();
    final SWTBotEclipseEditor barEditor = SwtBotProjectHelper.newXtendEditor(_bot_1, "Bar", _builder_1);
    this.renameInXtendEditor(barEditor, "NewBar", "Rename Element");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("class Foo extends NewBar {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertEquals(_builder_2, fooEditor.getText());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("class NewBar {}");
    _builder_3.newLine();
    this.assertEquals(_builder_3, barEditor.getText());
    this.assertEquals("NewBar.xtend", barEditor.getTitle());
  }

  @Test
  public void renameXtendClassReference() {
    SWTWorkbenchBot _bot = this.getBot();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bar {}");
    _builder.newLine();
    final SWTBotEclipseEditor barEditor = SwtBotProjectHelper.newXtendEditor(_bot, "Bar", _builder);
    SWTWorkbenchBot _bot_1 = this.getBot();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo extends ?Bar? {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final SWTBotEclipseEditor fooEditor = SwtBotProjectHelper.newXtendEditor(_bot_1, "Foo", _builder_1);
    this.renameInXtendEditor(fooEditor, "NewBar", "Rename Element");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("class Foo extends NewBar {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertEquals(_builder_2, fooEditor.getText());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("class NewBar {}");
    _builder_3.newLine();
    this.assertEquals(_builder_3, barEditor.getText());
    this.assertEquals("NewBar.xtend", barEditor.getTitle());
  }

  @Test
  public void renameXtendClassWithAA() {
    SWTWorkbenchBot _bot = this.getBot();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.Data");
    _builder.newLine();
    _builder.append("@Data");
    _builder.newLine();
    _builder.append("class ?Fonk? {}");
    _builder.newLine();
    final SWTBotEclipseEditor barEditor = SwtBotProjectHelper.newXtendEditor(_bot, "Fonk", _builder);
    this.renameInXtendEditor(barEditor, "NewFonk", "Rename Element");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.lib.annotations.Data");
    _builder_1.newLine();
    _builder_1.append("@Data");
    _builder_1.newLine();
    _builder_1.append("class NewFonk {}");
    _builder_1.newLine();
    this.assertEquals(_builder_1, barEditor.getText());
    this.assertEquals("NewFonk.xtend", barEditor.getTitle());
  }
}
