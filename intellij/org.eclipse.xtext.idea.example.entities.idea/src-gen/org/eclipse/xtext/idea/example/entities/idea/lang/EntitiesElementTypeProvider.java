package org.eclipse.xtext.idea.example.entities.idea.lang;

import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.PsiNamedEObjectStub;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectType;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.idea.example.entities.idea.lang.psi.impl.EntitiesFileImpl;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;

public class EntitiesElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<EntitiesFileImpl>>(EntitiesLanguage.INSTANCE);
	
	public static final IElementType NAME_TYPE = new IElementType("NAME", EntitiesLanguage.INSTANCE);
	
	public static final IElementType EOBJECT_TYPE = new IElementType("EOBJECT_TYPE", EntitiesLanguage.INSTANCE);
	
	public static final IStubElementType<PsiNamedEObjectStub, PsiNamedEObject> NAMED_EOBJECT_TYPE = new PsiNamedEObjectType("NAMED_EOBJECT", EntitiesLanguage.INSTANCE);
	
	public static final IElementType CROSS_REFERENCE_TYPE = new IElementType("CROSS_REFERENCE", EntitiesLanguage.INSTANCE);

	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	public IElementType getObjectType() {
		return EOBJECT_TYPE;
	}

	public IElementType getCrossReferenceType() {
		return CROSS_REFERENCE_TYPE;
	}

	public IElementType getNameType() {
		return NAME_TYPE;
	}

	public IStubElementType<PsiNamedEObjectStub, PsiNamedEObject> getNamedObjectType() {
		return NAMED_EOBJECT_TYPE;
	}

}
