/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.LanguageDescriptorFactory;

public class DummyLanguageResourceFactory implements IResourceFactory {

	public String[] getModelFileExtensions() {
		return new String[] { "dummylanguage" };
	}
	
	 /* (non-Javadoc)
     * @see org.eclipse.emf.ecore.resource.Resource.Factory#createResource(org.eclipse.emf.common.util.URI)
     */
    public Resource createResource(URI uri) {
        XtextResource resource = new XtextResource(uri);
        ServiceRegistry.injectServices(LanguageDescriptorFactory.get("org.eclipse.xtext.dummy.DummyLanguage"), resource);
        return resource;
    }
    
} 
