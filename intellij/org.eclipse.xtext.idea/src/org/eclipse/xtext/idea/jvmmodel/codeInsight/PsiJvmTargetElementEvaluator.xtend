/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.jvmmodel.codeInsight

import com.intellij.codeInsight.TargetElementEvaluator
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.light.LightElement

class PsiJvmTargetElementEvaluator implements TargetElementEvaluator {
	
	override getElementByReference(PsiReference ref, int flags) {
		switch element : ref.resolve {
			LightElement: element.navigationElement
			default: element
		}
	}
	
	override includeSelfInGotoImplementation(PsiElement element) {
		true
	}
	
}