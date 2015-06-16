/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiClassType.ClassResolveResult
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
class UnresolvedPsiClassType extends Exception {

	@Accessors
	val PsiClassType psiClassType

	@Accessors
	val ClassResolveResult classResolveResult

}