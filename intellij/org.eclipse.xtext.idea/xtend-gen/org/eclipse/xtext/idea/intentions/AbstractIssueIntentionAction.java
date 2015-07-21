/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.intentions;

import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractIssueIntentionAction implements IntentionAction {
  @Accessors
  private Issue issue;
  
  @Override
  public String getFamilyName() {
    return this.getText();
  }
  
  @Override
  public boolean isAvailable(final Project project, final Editor editor, final PsiFile file) {
    return true;
  }
  
  @Override
  public boolean startInWriteAction() {
    return true;
  }
  
  @Pure
  public Issue getIssue() {
    return this.issue;
  }
  
  public void setIssue(final Issue issue) {
    this.issue = issue;
  }
}
