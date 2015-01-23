/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.pom

import com.intellij.pom.PomDeclarationSearcher
import com.intellij.pom.PomTarget
import com.intellij.psi.PsiElement
import com.intellij.util.Consumer
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.psi.PsiNamedEObject

abstract class AbstractXtextPomDeclarationSearcher extends PomDeclarationSearcher {

	val IXtextLanguage language

	new(IXtextLanguage language) {
		this.language = language
		language.injectMembers(this)
	}

	override findDeclarationsAt(PsiElement element, int offsetInElement, Consumer<PomTarget> consumer) {
		if (element.language != language) {
			return
		}
		if (element instanceof PsiNamedEObject) {
			val nameIdentifierRange = element.nameIdentifier?.textRange
			if (nameIdentifierRange != null) {
				val offsetInDocument = element.textRange.startOffset + offsetInElement
				if (nameIdentifierRange.contains(offsetInDocument)) {
					consumer.consume(element)
				}
			}
		}
	}

}