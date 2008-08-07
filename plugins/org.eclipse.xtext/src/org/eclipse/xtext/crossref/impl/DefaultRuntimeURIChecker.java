package org.eclipse.xtext.crossref.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.crossref.IURIChecker;

public class DefaultRuntimeURIChecker implements IURIChecker {

	public boolean exists(URI uri, EObject context) {
		return context.eResource().getResourceSet().getEObject(uri, true)!=null;
	}

}
