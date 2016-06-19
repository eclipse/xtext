/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests;

import com.google.inject.Inject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtend.ide.tests.RefactoringTestParameters;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;
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
  private static /* SWTWorkbenchBot */Object bot;
  
  @BeforeClass
  public static void initialize() {
    throw new Error("Unresolved compilation problems:"
      + "\nSWTWorkbenchBot cannot be resolved."
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nnewXtendProject cannot be resolved");
  }
  
  @AfterClass
  public static void terminate() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\ncloseAllEditors cannot be resolved");
  }
  
  @Inject
  private RefactoringPreferences preferences;
  
  @Inject
  private RenameRefactoringController controller;
  
  protected RefactoringTestParameters testParams;
  
  @Before
  public void setUp() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\ncloseAllEditors cannot be resolved"
      + "\nclearSourceFolderContents cannot be resolved");
  }
  
  @After
  public void tearDown() {
    Display _default = Display.getDefault();
    final Runnable _function = () -> {
      this.preferences.setUseInlineRefactoring(true);
      this.preferences.setSaveAllBeforeRefactoring(true);
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
    final Runnable _function = () -> {
      boolean _isUseInlineRefactoring = this.testParams.isUseInlineRefactoring();
      preferences.setUseInlineRefactoring(_isUseInlineRefactoring);
      boolean _isSaveAllBeforeRefactoring = this.testParams.isSaveAllBeforeRefactoring();
      preferences.setSaveAllBeforeRefactoring(_isSaveAllBeforeRefactoring);
    };
    _default.syncExec(_function);
  }
  
  public Object renameInXtendEditor(final /* SWTBotEclipseEditor */Object xtendEditor, final String newName, final String dialogName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method textWithLabel(String) is undefined"
      + "\nThe method button(String) is undefined"
      + "\nThe method button(String) is undefined"
      + "\nThe method waitForLinkedMode() from the type AbstractRefactoringSwtBotTest refers to the missing type Object"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nclickableContextMenu cannot be resolved"
      + "\nclick cannot be resolved"
      + "\ntypeText cannot be resolved"
      + "\npressShortcut cannot be resolved"
      + "\nshell cannot be resolved"
      + "\nactivate cannot be resolved"
      + "\nbutton cannot be resolved"
      + "\nclick cannot be resolved"
      + "\npressShortcut cannot be resolved"
      + "\nshell cannot be resolved"
      + "\nactivate cannot be resolved"
      + "\nbot cannot be resolved"
      + "\n=> cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nclick cannot be resolved"
      + "\nclick cannot be resolved"
      + "\nwaitForRefactoring cannot be resolved");
  }
  
  public Object renameInJavaEditor(final /* SWTBotEclipseEditor */Object javaEditor, final String newName, final String dialogName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method textWithLabel(String) is undefined"
      + "\nThe method button(String) is undefined"
      + "\nThe method button(String) is undefined"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nclickableContextMenu cannot be resolved"
      + "\nclick cannot be resolved"
      + "\ntypeText cannot be resolved"
      + "\npressShortcut cannot be resolved"
      + "\nshell cannot be resolved"
      + "\nactivate cannot be resolved"
      + "\nbutton cannot be resolved"
      + "\nclick cannot be resolved"
      + "\npressShortcut cannot be resolved"
      + "\nshell cannot be resolved"
      + "\nactivate cannot be resolved"
      + "\nbot cannot be resolved"
      + "\n=> cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nclick cannot be resolved"
      + "\nclick cannot be resolved"
      + "\nwaitForRefactoring cannot be resolved");
  }
  
  public Object undo(final /* SWTBotEclipseEditor */Object editor) {
    throw new Error("Unresolved compilation problems:"
      + "\nSWTBot cannot be resolved."
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot"
      + "\nThe constructor WaitForRefactoringCondition(SWTBotEclipseEditor, boolean) refers to the missing type SWTBotEclipseEditor"
      + "\nsetFocus cannot be resolved"
      + "\npressShortcut cannot be resolved"
      + "\nshell cannot be resolved"
      + "\nactivate cannot be resolved"
      + "\nbutton cannot be resolved"
      + "\nclick cannot be resolved"
      + "\nwaitUntil cannot be resolved");
  }
  
  protected Object waitForLinkedMode() {
    throw new Error("Unresolved compilation problems:"
      + "\nSWTBot cannot be resolved."
      + "\nwaitUntil cannot be resolved");
  }
  
  protected Object waitForRefactoring(final /* SWTBotEclipseEditor */Object editor) {
    throw new Error("Unresolved compilation problems:"
      + "\nSWTBot cannot be resolved."
      + "\nThe constructor WaitForRefactoringCondition(SWTBotEclipseEditor, boolean) refers to the missing type SWTBotEclipseEditor"
      + "\nwaitUntil cannot be resolved");
  }
  
  protected SWTWorkbenchBot getBot() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractRefactoringSwtBotTest.bot refers to the missing type SWTWorkbenchBot");
  }
  
  protected void assertEquals(final CharSequence expected, final CharSequence value) {
    String _string = expected.toString();
    String _string_1 = value.toString();
    Assert.assertEquals(_string, _string_1);
  }
}
