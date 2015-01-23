/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types.completion

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor

class RefactoringTestLanguageCompletionContributor extends AbstractCompletionContributor {
	new() {
		super(RefactoringTestLanguageLanguage.INSTANCE)
	}
}
