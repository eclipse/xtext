/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;

public class TransientValuesTestResourceFactory implements IResourceFactory {

	public String[] getModelFileExtensions() {
		return new String[] { "transientvaluestest" };
	}
	
	 /* (non-Javadoc)
     * @see org.eclipse.emf.ecore.resource.Resource.Factory#createResource(org.eclipse.emf.common.util.URI)
     */
    public Resource createResource(URI uri) {
        XtextResource resource = new XtextResource(uri);
        ServiceRegistry.injectServices(ServiceScopeFactory.get("org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest"), resource);
        return resource;
    }
    
} 
