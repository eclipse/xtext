package org.eclipse.xtext.idea.lang;

import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.PsiNamedEObjectStub;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;

public interface IElementTypeProvider {

	IFileElementType getFileType();

	IElementType getObjectType();

	IStubElementType<? extends PsiNamedEObjectStub, ? extends PsiNamedEObject> getNamedObjectType();

	IElementType getCrossReferenceType();

	IElementType getNameType();

}
