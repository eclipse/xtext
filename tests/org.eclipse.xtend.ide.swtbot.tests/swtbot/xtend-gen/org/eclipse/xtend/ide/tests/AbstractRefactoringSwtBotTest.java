/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtend.ide.tests.RefactoringTestParameters;
import org.eclipse.xtend.ide.tests.SwtBotProjectHelper;
import org.eclipse.xtend.ide.tests.WaitForLinkedModeCondition;
import org.eclipse.xtend.ide.tests.WaitForRefactoringCondition;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractRefactoringSwtBotTest {
  private static SWTWorkbenchBot bot;
  
  @BeforeClass
  public static void initialize() {
    try {
      IResourcesSetupUtil.cleanWorkspace();
      SWTWorkbenchBot _sWTWorkbenchBot = new SWTWorkbenchBot();
      AbstractRefactoringSwtBotTest.bot = _sWTWorkbenchBot;
      SwtBotProjectHelper.newXtendProject(AbstractRefactoringSwtBotTest.bot, "test");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @AfterClass
  public static void terminate() {
    try {
      AbstractRefactoringSwtBotTest.bot.closeAllEditors();
      IResourcesSetupUtil.cleanWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Inject
  private RefactoringPreferences preferences;
  
  @Inject
  private RenameRefactoringController controller;
  
  protected RefactoringTestParameters testParams;
  
  @Before
  public void setUp() {
    XtendActivator _instance = XtendActivator.getInstance();
    Injector _injector = _instance.getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND);
    _injector.injectMembers(this);
    AbstractRefactoringSwtBotTest.bot.closeAllEditors();
    SwtBotProjectHelper.clearSourceFolderContents(AbstractRefactoringSwtBotTest.bot);
  }
  
  @After
  public void tearDown() {
    Display _default = Display.getDefault();
    final Runnable _function = new Runnable() {
      public void run() {
        AbstractRefactoringSwtBotTest.this.preferences.setUseInlineRefactoring(true);
        AbstractRefactoringSwtBotTest.this.preferences.setSaveAllBeforeRefactoring(true);
      }
    };
    _default.syncExec(_function);
  }
  
  public AbstractRefactoringSwtBotTest() {
    RefactoringTestParameters _refactoringTestParameters = new RefactoringTestParameters();
    this.testParams = _refactoringTestParameters;
  }
  
  public AbstractRefactoringSwtBotTest(final RefactoringTestParameters testParams) {
    this.testParams = testParams;
  }
  
  @Inject
  public void initialize(final RefactoringPreferences preferences) {
    this.preferences = preferences;
    Display _default = Display.getDefault();
    final Runnable _function = new Runnable() {
      public void run() {
        boolean _isUseInlineRefactoring = AbstractRefactoringSwtBotTest.this.testParams.isUseInlineRefactoring();
        preferences.setUseInlineRefactoring(_isUseInlineRefactoring);
        boolean _isSaveAllBeforeRefactoring = AbstractRefactoringSwtBotTest.this.testParams.isSaveAllBeforeRefactoring();
        preferences.setSaveAllBeforeRefactoring(_isSaveAllBeforeRefactoring);
      }
    };
    _default.syncExec(_function);
  }
  
  public void renameInXtendEditor(final SWTBotEclipseEditor xtendEditor, final String newName, final String dialogName) {
    final SWTBotMenu renameMenuItem = SwtBotProjectHelper.clickableContextMenu(xtendEditor, "Rename Element");
    renameMenuItem.click();
    boolean _isUseInlineRefactoring = this.testParams.isUseInlineRefactoring();
    if (_isUseInlineRefactoring) {
      this.waitForLinkedMode();
      xtendEditor.typeText(newName);
      boolean _isUsePreview = this.testParams.isUsePreview();
      if (_isUsePreview) {
        xtendEditor.pressShortcut(SWT.CTRL, SWT.CR);
        SWTBotShell _shell = AbstractRefactoringSwtBotTest.bot.shell(dialogName);
        _shell.activate();
        SWTBotButton _button = AbstractRefactoringSwtBotTest.bot.button("OK");
        _button.click();
      } else {
        KeyStroke _instance = KeyStroke.getInstance(SWT.LF);
        xtendEditor.pressShortcut(_instance);
      }
    } else {
      SWTBotShell _shell_1 = AbstractRefactoringSwtBotTest.bot.shell(dialogName);
      SWTBotShell _activate = _shell_1.activate();
      SWTBot _bot = _activate.bot();
      final Procedure1<SWTBot> _function = new Procedure1<SWTBot>() {
        public void apply(final SWTBot it) {
          SWTBotText _textWithLabel = it.textWithLabel("New name:");
          _textWithLabel.setText(newName);
          boolean _isUsePreview = AbstractRefactoringSwtBotTest.this.testParams.isUsePreview();
          if (_isUsePreview) {
            SWTBotButton _button = it.button("Preview >");
            _button.click();
          }
          SWTBotButton _button_1 = it.button("OK");
          _button_1.click();
        }
      };
      ObjectExtensions.<SWTBot>operator_doubleArrow(_bot, _function);
    }
    this.waitForRefactoring(xtendEditor);
  }
  
  public void renameInJavaEditor(final SWTBotEclipseEditor javaEditor, final String newName, final String dialogName) {
    final SWTBotMenu renameMenuItem = SwtBotProjectHelper.clickableContextMenu(javaEditor, "Refactor", "Rename...");
    renameMenuItem.click();
    boolean _isUseInlineRefactoring = this.testParams.isUseInlineRefactoring();
    if (_isUseInlineRefactoring) {
      javaEditor.typeText(newName);
      boolean _isUsePreview = this.testParams.isUsePreview();
      if (_isUsePreview) {
        javaEditor.pressShortcut(SWT.CTRL, SWT.CR);
        SWTBotShell _shell = AbstractRefactoringSwtBotTest.bot.shell(dialogName);
        _shell.activate();
        SWTBotButton _button = AbstractRefactoringSwtBotTest.bot.button("OK");
        _button.click();
      } else {
        KeyStroke _instance = KeyStroke.getInstance(SWT.LF);
        javaEditor.pressShortcut(_instance);
      }
    } else {
      SWTBotShell _shell_1 = AbstractRefactoringSwtBotTest.bot.shell(dialogName);
      SWTBotShell _activate = _shell_1.activate();
      SWTBot _bot = _activate.bot();
      final Procedure1<SWTBot> _function = new Procedure1<SWTBot>() {
        public void apply(final SWTBot it) {
          SWTBotText _textWithLabel = it.textWithLabel("New name:");
          _textWithLabel.setText(newName);
          boolean _isUsePreview = AbstractRefactoringSwtBotTest.this.testParams.isUsePreview();
          if (_isUsePreview) {
            SWTBotButton _button = it.button("Next");
            _button.click();
          }
          SWTBotButton _button_1 = it.button("Finish");
          _button_1.click();
        }
      };
      ObjectExtensions.<SWTBot>operator_doubleArrow(_bot, _function);
    }
    this.waitForRefactoring(javaEditor);
  }
  
  public void undo(final SWTBotEclipseEditor editor) {
    editor.setFocus();
    editor.pressShortcut(SWT.MOD1, 'Z');
    SWTBotShell _shell = AbstractRefactoringSwtBotTest.bot.shell("Undo");
    _shell.activate();
    SWTBotButton _button = AbstractRefactoringSwtBotTest.bot.button("OK");
    _button.click();
    SWTBot _sWTBot = new SWTBot();
    WaitForRefactoringCondition _waitForRefactoringCondition = new WaitForRefactoringCondition(editor, true);
    _sWTBot.waitUntil(_waitForRefactoringCondition, 15000);
  }
  
  protected void waitForLinkedMode() {
    SWTBot _sWTBot = new SWTBot();
    WaitForLinkedModeCondition _waitForLinkedModeCondition = new WaitForLinkedModeCondition(this.controller);
    _sWTBot.waitUntil(_waitForLinkedModeCondition);
  }
  
  protected void waitForRefactoring(final SWTBotEclipseEditor editor) {
    SWTBot _sWTBot = new SWTBot();
    WaitForRefactoringCondition _waitForRefactoringCondition = new WaitForRefactoringCondition(editor, false);
    _sWTBot.waitUntil(_waitForRefactoringCondition, 15000);
  }
  
  protected SWTWorkbenchBot getBot() {
    return AbstractRefactoringSwtBotTest.bot;
  }
  
  protected void assertEquals(final CharSequence expected, final CharSequence value) {
    String _string = expected.toString();
    String _string_1 = value.toString();
    Assert.assertEquals(_string, _string_1);
  }
}
