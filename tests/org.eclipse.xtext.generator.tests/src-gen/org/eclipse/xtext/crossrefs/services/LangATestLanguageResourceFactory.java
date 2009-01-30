/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.ServiceRegistry;

public class LangATestLanguageResourceFactory implements IResourceFactory {

	public String[] getModelFileExtensions() {
		return new String[] { "langatestlanguage" };
	}
	
	 /* (non-Javadoc)
     * @see org.eclipse.emf.ecore.resource.Resource.Factory#createResource(org.eclipse.emf.common.util.URI)
     */
    public Resource createResource(URI uri) {
        XtextResource resource = new XtextResource(uri);
        ServiceRegistry.getInjector(org.eclipse.xtext.crossrefs.ILangATestLanguage.SCOPE).injectMembers(resource);
        return resource;
    }
    
} 
