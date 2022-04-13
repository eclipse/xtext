/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests;

import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.xtext.ui.refactoring.ui.RenameLinkedMode;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;

@SuppressWarnings("all")
public class WaitForLinkedModeCondition extends DefaultCondition {
  private RenameRefactoringController controller;

  public WaitForLinkedModeCondition(final RenameRefactoringController controller) {
    this.controller = controller;
  }

  @Override
  public String getFailureMessage() {
    return "Linked mode not entered";
  }

  @Override
  public boolean test() throws Exception {
    RenameLinkedMode _activeLinkedMode = this.controller.getActiveLinkedMode();
    return (_activeLinkedMode != null);
  }
}
