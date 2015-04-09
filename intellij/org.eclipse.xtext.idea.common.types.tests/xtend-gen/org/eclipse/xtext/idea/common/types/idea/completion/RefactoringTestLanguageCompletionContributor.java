/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types.idea.completion;

import org.eclipse.xtext.idea.common.types.idea.completion.AbstractRefactoringTestLanguageCompletionContributor;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

@SuppressWarnings("all")
public class RefactoringTestLanguageCompletionContributor extends AbstractRefactoringTestLanguageCompletionContributor {
  public RefactoringTestLanguageCompletionContributor() {
    this(RefactoringTestLanguageLanguage.INSTANCE);
  }
  
  public RefactoringTestLanguageCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
  }
}
