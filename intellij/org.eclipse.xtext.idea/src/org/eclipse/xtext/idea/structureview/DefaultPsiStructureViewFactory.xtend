/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.psi.PsiFile
import org.eclipse.xtext.psi.impl.BaseXtextFile

class DefaultPsiStructureViewFactory implements PsiStructureViewFactory {
	
	@Inject
	Provider<XtextFileAwareStructureViewBuilder> structureViewBuilderProvider
	
	override getStructureViewBuilder(PsiFile psiFile) {
		if (psiFile instanceof BaseXtextFile) {
			structureViewBuilderProvider.get => [
				xtextFile = psiFile
			]
		}
	}
	
}