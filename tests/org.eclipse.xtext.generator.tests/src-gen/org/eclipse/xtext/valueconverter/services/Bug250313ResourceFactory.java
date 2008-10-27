/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;

public class Bug250313ResourceFactory implements IResourceFactory {

	public String[] getModelFileExtensions() {
		return new String[] { "bug250313" };
	}
	
	 /* (non-Javadoc)
     * @see org.eclipse.emf.ecore.resource.Resource.Factory#createResource(org.eclipse.emf.common.util.URI)
     */
    public Resource createResource(URI uri) {
        XtextResource resource = new XtextResource(uri);
        ServiceRegistry.injectServices(ServiceScopeFactory.get("org.eclipse.xtext.valueconverter.Bug250313"), resource);
        return resource;
    }
    
} 
