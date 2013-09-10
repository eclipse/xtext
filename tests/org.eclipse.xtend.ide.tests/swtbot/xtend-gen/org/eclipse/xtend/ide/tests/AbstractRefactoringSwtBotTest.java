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
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtend.ide.tests.SwtBotProjectHelper;
import org.eclipse.xtend.ide.tests.WaitForLinkedModeCondition;
import org.eclipse.xtend.ide.tests.WaitForRefactoringCondition;
import org.eclipse.xtext.junit4.swtbot.ParameterizedSWTBotRunner;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@RunWith(ParameterizedSWTBotRunner.class)
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
      IResourcesSetupUtil.cleanWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Before
  public void setUp() {
    XtendActivator _instance = XtendActivator.getInstance();
    Injector _injector = _instance.getInjector(XtendActivator.ORG_ECLIPSE_XTEND_CORE_XTEND);
    _injector.injectMembers(this);
  }
  
  @After
  public void tearDown() {
    SwtBotProjectHelper.clearSourceFolderContents(AbstractRefactoringSwtBotTest.bot);
    AbstractRefactoringSwtBotTest.bot.closeAllEditors();
  }
  
  @Inject
  private RenameRefactoringController controller;
  
  protected void waitForLinkedMode() {
    SWTBot _sWTBot = new SWTBot();
    WaitForLinkedModeCondition _waitForLinkedModeCondition = new WaitForLinkedModeCondition(this.controller);
    _sWTBot.waitUntil(_waitForLinkedModeCondition);
  }
  
  protected void waitForRefactoring(final SWTBotEclipseEditor editor) {
    SWTBot _sWTBot = new SWTBot();
    WaitForRefactoringCondition _waitForRefactoringCondition = new WaitForRefactoringCondition(editor);
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
