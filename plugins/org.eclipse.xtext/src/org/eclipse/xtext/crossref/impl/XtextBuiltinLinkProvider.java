package org.eclipse.xtext.crossref.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.crossref.ILinkProvider;
import org.eclipse.xtext.parsetree.LeafNode;

public class XtextBuiltinLinkProvider implements ILinkProvider {

	public URI[] getLinks(LeafNode text, CrossReference ref, EObject model) {
		ResourceSet resourceSet = model.eResource().getResourceSet();
		EList<Resource> resources = resourceSet.getResources();
		for (Resource resource : resources) {
			EObject object = resource.getEObject(text.getText());
			if (object!=null)
				return new URI[]{resource.getURI().appendFragment(text.getText())};
		}
		return null;
	}

}
