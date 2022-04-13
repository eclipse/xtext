/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests;

import java.util.Collection;
import java.util.Collections;
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
 * @author Christian Dietrich - Initial contribution and API
 */
@RunWith(ParameterizedSWTBotRunner.class)
@Ignore
@SuppressWarnings("all")
public class RenameXtendClassBug516096SwtBotTest extends AbstractRefactoringSwtBotTest {
  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    RefactoringTestParameters _refactoringTestParameters = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(false);
      it.setUsePreview(false);
    };
    RefactoringTestParameters _doubleArrow = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters, _function);
    return Collections.<Object[]>unmodifiableList(CollectionLiterals.<Object[]>newArrayList(new Object[] { _doubleArrow }));
  }

  public RenameXtendClassBug516096SwtBotTest(final RefactoringTestParameters testParams) {
    super(testParams);
  }

  @Test
  public void testBug516096() {
    final String projectName = "this is a test";
    SwtBotProjectHelper.newXtendProject(this.getBot(), projectName);
    SWTBotEclipseEditor _newXtendEditor = SwtBotProjectHelper.newXtendEditor(this.getBot(), "Foo", "", (projectName + "/src"));
    final Procedure1<SWTBotEclipseEditor> _function = (SWTBotEclipseEditor it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class ?Foo? {}");
      _builder.newLine();
      SwtBotProjectHelper.setContent(it, _builder);
    };
    final SWTBotEclipseEditor fooEditor = ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newXtendEditor, _function);
    this.renameInXtendEditor(fooEditor, "Bar", "Rename Element");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bar {}");
    _builder.newLine();
    this.assertEquals(_builder, fooEditor.getText());
    this.assertEquals("Bar.xtend", fooEditor.getTitle());
  }
}
