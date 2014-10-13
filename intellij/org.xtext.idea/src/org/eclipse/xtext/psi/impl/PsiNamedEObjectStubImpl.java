package org.eclipse.xtext.psi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.PsiNamedEObjectStub;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;

public class PsiNamedEObjectStubImpl<T extends PsiNamedEObject> extends StubBase<T> implements PsiNamedEObjectStub<T> {
	
	private final EClass type;

	private final StringRef name;

	private final QualifiedName qualifiedName;

	@SuppressWarnings("rawtypes")
	public PsiNamedEObjectStubImpl(StubElement parent, StringRef name, QualifiedName qualifiedName, EClass type, IStubElementType<? extends PsiNamedEObjectStub, ? extends PsiNamedEObject> elementType) {
		super(parent, elementType);
		this.name = name;
		this.type = type;
		this.qualifiedName = qualifiedName;
	}

	public QualifiedName getQualifiedName() {
		return qualifiedName;
	}

	public String getName() {
		return StringRef.toString(name);
	}

	public EClass getEClass() {
		return type;
	}

}
