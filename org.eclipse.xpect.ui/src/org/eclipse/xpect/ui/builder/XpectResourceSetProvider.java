package org.eclipse.xpect.ui.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

public class XpectResourceSetProvider extends XtextResourceSetProvider {

	@Override
	public ResourceSet get(IProject project) {
		ResourceSet result = super.get(project);
		result.setResourceFactoryRegistry(new XpectResourceFactoryRegistry(result.getResourceFactoryRegistry()));
		return result;
	}
}
