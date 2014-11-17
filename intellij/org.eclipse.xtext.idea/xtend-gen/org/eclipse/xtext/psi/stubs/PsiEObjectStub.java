package org.eclipse.xtext.psi.stubs;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import org.eclipse.xtext.psi.PsiEObject;

@SuppressWarnings("all")
public class PsiEObjectStub extends StubBase<PsiEObject> {
  protected PsiEObjectStub(final StubElement parent, final IStubElementType elementType) {
    super(parent, elementType);
  }
}
