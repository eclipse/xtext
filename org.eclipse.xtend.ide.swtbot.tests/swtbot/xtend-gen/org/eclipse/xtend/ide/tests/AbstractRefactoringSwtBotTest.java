/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests;

import com.google.inject.Inject;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.util.Strings;
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
      TargetPlatformUtil.setTargetPlatform(AbstractRefactoringSwtBotTest.class);
      IResourcesSetupUtil.cleanWorkspace();
      SWTWorkbenchBot _sWTWorkbenchBot = new SWTWorkbenchBot();
      AbstractRefactoringSwtBotTest.bot = _sWTWorkbenchBot;
      UIThreadRunnable.syncExec(new VoidResult() {
        @Override
        public void run() {
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive();
        }
      });
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
    XtendActivator.getInstance().getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND).injectMembers(this);
    AbstractRefactoringSwtBotTest.bot.closeAllEditors();
    SwtBotProjectHelper.clearSourceFolderContents(AbstractRefactoringSwtBotTest.bot);
  }

  @After
  public void tearDown() {
    final Runnable _function = () -> {
      this.preferences.setUseInlineRefactoring(true);
      this.preferences.setSaveAllBeforeRefactoring(true);
    };
    Display.getDefault().syncExec(_function);
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
    final Runnable _function = () -> {
      preferences.setUseInlineRefactoring(this.testParams.isUseInlineRefactoring());
      preferences.setSaveAllBeforeRefactoring(this.testParams.isSaveAllBeforeRefactoring());
    };
    Display.getDefault().syncExec(_function);
  }

  public void renameInXtendEditor(final SWTBotEclipseEditor xtendEditor, final String newName, final String dialogName) {
    final SWTBotMenu renameMenuItem = SwtBotProjectHelper.clickableContextMenu(xtendEditor, "Refactor", "Rename Element");
    renameMenuItem.click();
    boolean _isUseInlineRefactoring = this.testParams.isUseInlineRefactoring();
    if (_isUseInlineRefactoring) {
      this.waitForLinkedMode();
      xtendEditor.typeText(newName);
      boolean _isUsePreview = this.testParams.isUsePreview();
      if (_isUsePreview) {
        xtendEditor.pressShortcut(SWT.CTRL, SWT.CR);
        AbstractRefactoringSwtBotTest.bot.shell(dialogName).activate();
        AbstractRefactoringSwtBotTest.bot.button("OK").click();
      } else {
        xtendEditor.pressShortcut(KeyStroke.getInstance(SWT.LF));
      }
    } else {
      SWTBot _bot = AbstractRefactoringSwtBotTest.bot.shell(dialogName).activate().bot();
      final Procedure1<SWTBot> _function = (SWTBot it) -> {
        SWTBotText _textWithLabel = it.textWithLabel("New name:");
        _textWithLabel.setText(newName);
        boolean _isUsePreview_1 = this.testParams.isUsePreview();
        if (_isUsePreview_1) {
          it.button("Preview >").click();
        }
        it.button("OK").click();
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
        AbstractRefactoringSwtBotTest.bot.shell(dialogName).activate();
        AbstractRefactoringSwtBotTest.bot.button("OK").click();
      } else {
        javaEditor.pressShortcut(KeyStroke.getInstance(SWT.LF));
      }
    } else {
      SWTBot _bot = AbstractRefactoringSwtBotTest.bot.shell(dialogName).activate().bot();
      final Procedure1<SWTBot> _function = (SWTBot it) -> {
        SWTBotText _textWithLabel = it.textWithLabel("New name:");
        _textWithLabel.setText(newName);
        boolean _isUsePreview_1 = this.testParams.isUsePreview();
        if (_isUsePreview_1) {
          it.button("Next").click();
        }
        it.button("Finish").click();
      };
      ObjectExtensions.<SWTBot>operator_doubleArrow(_bot, _function);
    }
    this.waitForRefactoring(javaEditor);
  }

  public void undo(final SWTBotEclipseEditor editor) {
    editor.setFocus();
    editor.pressShortcut(SWT.MOD1, 'Z');
    AbstractRefactoringSwtBotTest.bot.shell("Undo").activate();
    AbstractRefactoringSwtBotTest.bot.button("OK").click();
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
    Assert.assertEquals(Strings.toUnixLineSeparator(expected.toString()), Strings.toUnixLineSeparator(value.toString()));
  }
}
