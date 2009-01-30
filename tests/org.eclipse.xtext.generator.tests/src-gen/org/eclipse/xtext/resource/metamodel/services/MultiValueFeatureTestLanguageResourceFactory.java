/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.ServiceRegistry;

public class MultiValueFeatureTestLanguageResourceFactory implements IResourceFactory {

	public String[] getModelFileExtensions() {
		return new String[] { "multivaluefeaturetestlanguage" };
	}
	
	 /* (non-Javadoc)
     * @see org.eclipse.emf.ecore.resource.Resource.Factory#createResource(org.eclipse.emf.common.util.URI)
     */
    public Resource createResource(URI uri) {
        XtextResource resource = new XtextResource(uri);
        ServiceRegistry.getInjector(org.eclipse.xtext.resource.metamodel.IMultiValueFeatureTestLanguage.SCOPE).injectMembers(resource);
        return resource;
    }
    
} 
