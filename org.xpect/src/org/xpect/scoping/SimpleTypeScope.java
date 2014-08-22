package org.xpect.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

@SuppressWarnings("restriction")
public class SimpleTypeScope implements IScope {

	private IJvmTypeProvider typeProvider;

	public SimpleTypeScope(IJvmTypeProvider typeProvider) {
		super();
		this.typeProvider = typeProvider;
	}

	public Iterable<IEObjectDescription> getAllElements() {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getElements(EObject object) {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		throw new UnsupportedOperationException();
	}

	public IEObjectDescription getSingleElement(EObject object) {
		return EObjectDescription.create(QualifiedName.create(object.eResource().getURI().segments()), object);
	}

	public IEObjectDescription getSingleElement(QualifiedName name) {
		JvmType eObject = typeProvider.findTypeByName(name.toString());
		if (eObject != null) {
			return EObjectDescription.create(name, eObject);
		}
		return null;
	}

}
