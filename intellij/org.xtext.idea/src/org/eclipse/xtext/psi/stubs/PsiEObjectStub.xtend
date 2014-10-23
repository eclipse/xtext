package org.eclipse.xtext.psi.stubs

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement
import org.eclipse.xtext.psi.PsiEObject

class PsiEObjectStub extends StubBase<PsiEObject> {
	
	protected new(StubElement parent, IStubElementType elementType) {
		super(parent, elementType)
	}
	
}