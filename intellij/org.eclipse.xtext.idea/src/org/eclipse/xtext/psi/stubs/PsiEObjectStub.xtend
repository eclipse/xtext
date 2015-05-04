/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.stubs

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement
import org.eclipse.xtext.psi.PsiEObject

class PsiEObjectStub extends StubBase<PsiEObject> {
	
	protected new(StubElement<?> parent, IStubElementType<?, PsiEObject> elementType) {
		super(parent, elementType)
	}
	
}