package org.eclipse.xtext.services;

import org.eclipse.xtext.resource.AbstractXtextResourceFactory;

public class XtextResourceFactory extends AbstractXtextResourceFactory {

    /* (non-Javadoc)
     * @see org.eclipse.xtext.resource.IResourceFactory#getModelFileExtension()
     */
    public String getModelFileExtension() {
        return "xtext";
    }
	
} 
