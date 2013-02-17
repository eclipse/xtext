package org.xpect.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.xpect.XpectJavaModel;
import org.xpect.util.XpectJavaModelFactory;

public class XpectJavaModelScope implements IScope {

	private IScope delegate;
	private ResourceSet resourceSet;

	public XpectJavaModelScope(ResourceSet resourceSet, IScope delegate) {
		super();
		this.resourceSet = resourceSet;
		this.delegate = delegate;
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
		XpectJavaModelFactory fac = new XpectJavaModelFactory();
		URI uri = fac.createURI(name.toString());
		Resource res = resourceSet.getResource(uri, false);
		if (res == null) {
			IEObjectDescription element = delegate.getSingleElement(name);
			if (element != null) {
				EObject eObject = element.getEObjectOrProxy();
				if (eObject != null) {
					eObject = EcoreUtil.resolve(eObject, resourceSet);
					if (eObject instanceof JvmDeclaredType) {
						XpectJavaModel javaModel = fac.createJavaModel(resourceSet, (JvmDeclaredType) eObject);
						return EObjectDescription.create(name, javaModel);
					}
				}
			}
		} else
			return EObjectDescription.create(name, res.getContents().get(0));
		return null;
	}

}
