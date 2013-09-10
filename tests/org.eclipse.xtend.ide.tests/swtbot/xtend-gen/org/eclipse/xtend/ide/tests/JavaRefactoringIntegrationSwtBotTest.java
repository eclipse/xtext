/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.xtend.ide.tests.AbstractRefactoringSwtBotTest;
import org.eclipse.xtend.ide.tests.ParameterizedSWTBotRunner;
import org.eclipse.xtend.ide.tests.SwtBotProjectHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@RunWith(ParameterizedSWTBotRunner.class)
@SuppressWarnings("all")
public class JavaRefactoringIntegrationSwtBotTest extends AbstractRefactoringSwtBotTest {
  @Parameters
  public static Collection<Object[]> data() {
    return Collections.<Object[]>unmodifiableList(Lists.<Object[]>newArrayList(new Object[] { Boolean.valueOf(true) }, new Object[] { Boolean.valueOf(false) }));
  }
  
  private boolean useLinkedEditing;
  
  @Inject
  private RefactoringPreferences preferences;
  
  public JavaRefactoringIntegrationSwtBotTest(final boolean useLinkedEditing) {
    this.useLinkedEditing = useLinkedEditing;
  }
  
  @After
  public void resetPrefs() {
    this.setUseLinkedEditing(
      this.preferences, true);
  }
  
  @Inject
  public void initialize(final RefactoringPreferences prefs) {
    this.preferences = prefs;
    this.setUseLinkedEditing(prefs, this.useLinkedEditing);
  }
  
  protected void setUseLinkedEditing(final RefactoringPreferences prefs, final boolean useLinkedEditing) {
    Display _default = Display.getDefault();
    final Runnable _function = new Runnable() {
      public void run() {
        prefs.setUseInlineRefactoring(useLinkedEditing);
        JavaPlugin _default = JavaPlugin.getDefault();
        IPreferenceStore _preferenceStore = _default.getPreferenceStore();
        _preferenceStore.setValue(PreferenceConstants.REFACTOR_LIGHTWEIGHT, useLinkedEditing);
      }
    };
    _default.syncExec(_function);
  }
  
  @Test
  public void renameJavaClass() {
    SWTWorkbenchBot _bot = this.getBot();
    SWTBotEclipseEditor _newXtendEditor = SwtBotProjectHelper.newXtendEditor(_bot, "XtendClass");
    final Procedure1<SWTBotEclipseEditor> _function = new Procedure1<SWTBotEclipseEditor>() {
      public void apply(final SWTBotEclipseEditor it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class XtendClass extends JavaClass {");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        SwtBotProjectHelper.setContent(it, _builder);
      }
    };
    final SWTBotEclipseEditor xtendEditor = ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newXtendEditor, _function);
    SWTWorkbenchBot _bot_1 = this.getBot();
    SWTBotEclipseEditor _newJavaEditor = SwtBotProjectHelper.newJavaEditor(_bot_1, "JavaClass");
    final Procedure1<SWTBotEclipseEditor> _function_1 = new Procedure1<SWTBotEclipseEditor>() {
      public void apply(final SWTBotEclipseEditor it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("public class ?JavaClass? {}");
        _builder.newLine();
        SwtBotProjectHelper.setContent(it, _builder);
        JavaRefactoringIntegrationSwtBotTest.this.renameFromJava(it, "NewJavaClass", "Rename Type");
      }
    };
    final SWTBotEclipseEditor javaEditor = ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newJavaEditor, _function_1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class XtendClass extends NewJavaClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _text = xtendEditor.getText();
    this.assertEquals(_builder, _text);
    boolean _isDirty = xtendEditor.isDirty();
    Assert.assertFalse(_isDirty);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class NewJavaClass {}");
    _builder_1.newLine();
    String _text_1 = javaEditor.getText();
    this.assertEquals(_builder_1, _text_1);
    boolean _isDirty_1 = javaEditor.isDirty();
    Assert.assertFalse(_isDirty_1);
    String _title = javaEditor.getTitle();
    this.assertEquals("NewJavaClass.java", _title);
  }
  
  @Test
  public void renameJavaClassXtendReference() {
    SWTWorkbenchBot _bot = this.getBot();
    SWTBotEclipseEditor _newJavaEditor = SwtBotProjectHelper.newJavaEditor(_bot, "JavaClass");
    final Procedure1<SWTBotEclipseEditor> _function = new Procedure1<SWTBotEclipseEditor>() {
      public void apply(final SWTBotEclipseEditor it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("public class JavaClass {}");
        _builder.newLine();
        SwtBotProjectHelper.setContent(it, _builder);
      }
    };
    final SWTBotEclipseEditor javaEditor = ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newJavaEditor, _function);
    SWTWorkbenchBot _bot_1 = this.getBot();
    SWTBotEclipseEditor _newXtendEditor = SwtBotProjectHelper.newXtendEditor(_bot_1, "XtendClass");
    final Procedure1<SWTBotEclipseEditor> _function_1 = new Procedure1<SWTBotEclipseEditor>() {
      public void apply(final SWTBotEclipseEditor it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class XtendClass extends ?JavaClass? {");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        SwtBotProjectHelper.setContent(it, _builder);
        JavaRefactoringIntegrationSwtBotTest.this.renameFromXtend(it, "NewJavaClass", "Rename Type");
      }
    };
    final SWTBotEclipseEditor xtendEditor = ObjectExtensions.<SWTBotEclipseEditor>operator_doubleArrow(_newXtendEditor, _function_1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class XtendClass extends NewJavaClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _text = xtendEditor.getText();
    this.assertEquals(_builder, _text);
    boolean _isDirty = xtendEditor.isDirty();
    Assert.assertFalse(_isDirty);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class NewJavaClass {}");
    _builder_1.newLine();
    String _text_1 = javaEditor.getText();
    this.assertEquals(_builder_1, _text_1);
    boolean _isDirty_1 = javaEditor.isDirty();
    Assert.assertFalse(_isDirty_1);
    String _title = javaEditor.getTitle();
    this.assertEquals("NewJavaClass.java", _title);
  }
  
  public void renameFromXtend(final SWTBotEclipseEditor it, final String newName, final String dialogName) {
    final SWTBotMenu renameMenuItem = SwtBotProjectHelper.clickableContextMenu(it, "Rename Element");
    renameMenuItem.click();
    if (this.useLinkedEditing) {
      this.waitForLinkedMode();
      String _plus = (newName + "\n");
      it.typeText(_plus);
    } else {
      SWTBot _bot = it.bot();
      SWTBotShell _shell = _bot.shell(dialogName);
      SWTBotShell _activate = _shell.activate();
      SWTBot _bot_1 = _activate.bot();
      final Procedure1<SWTBot> _function = new Procedure1<SWTBot>() {
        public void apply(final SWTBot it) {
          SWTBotText _textWithLabel = it.textWithLabel("New name:");
          _textWithLabel.setText(newName);
          SWTBotButton _button = it.button("Finish");
          _button.click();
        }
      };
      ObjectExtensions.<SWTBot>operator_doubleArrow(_bot_1, _function);
    }
    this.waitForRefactoring(it);
  }
  
  public void renameFromJava(final SWTBotEclipseEditor it, final String newName, final String dialogName) {
    final SWTBotMenu renameMenuItem = SwtBotProjectHelper.clickableContextMenu(it, "Refactor", "Rename...");
    renameMenuItem.click();
    if (this.useLinkedEditing) {
      String _plus = (newName + "\n");
      it.typeText(_plus);
    } else {
      SWTBot _bot = it.bot();
      SWTBotShell _shell = _bot.shell(dialogName);
      SWTBotShell _activate = _shell.activate();
      SWTBot _bot_1 = _activate.bot();
      final Procedure1<SWTBot> _function = new Procedure1<SWTBot>() {
        public void apply(final SWTBot it) {
          SWTBotText _textWithLabel = it.textWithLabel("New name:");
          _textWithLabel.setText(newName);
          SWTBotButton _button = it.button("Finish");
          _button.click();
        }
      };
      ObjectExtensions.<SWTBot>operator_doubleArrow(_bot_1, _function);
    }
    this.waitForRefactoring(it);
  }
}
