/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * A resource set that is capable of resolving classpath URIs.
 * 
 * @author Jan Köhnlein
 */
public class XtextResourceSet extends ResourceSetImpl {

    private IClasspathUriResolver resolver;

    private Object classpathURIContext;

    public XtextResourceSet() {
    }

    private URI resolveClasspathURI(URI uri) {
        return getClasspathUriResolver().resolve(getClasspathURIContext(), uri);
    }

    @Override
    public URIConverter getURIConverter() {
        if (uriConverter == null) {
            uriConverter = new ExtensibleURIConverterImpl() {
                @Override
                public URI normalize(URI uri) {
                    if (ClasspathUriUtil.isClassapthUri(uri)) {
                        return XtextResourceSet.this.resolveClasspathURI(uri);
                    }
                    return super.normalize(uri);
                }
            };
        }
        return uriConverter;
    }

    public Object getClasspathURIContext() {
        return classpathURIContext;
    }

    public void setClasspathURIContext(Object classpathURIContext) {
        this.classpathURIContext = classpathURIContext;
    }

    public IClasspathUriResolver getClasspathUriResolver() {
        if (resolver == null) {
            resolver = new ClassloaderClasspathUriResolver();
        }
        return resolver;
    }

    public void setClasspathUriResolver(IClasspathUriResolver resolver) {
        this.resolver = resolver;
    }

}
