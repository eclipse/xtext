/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
    	setURIResourceMap(new HashMap<URI,Resource>());
    }

    private URI resolveClasspathURI(URI uri) {
        return getClasspathUriResolver().resolve(getClasspathURIContext(), uri);
    }
    
    public void addLoadOption(Object key, Object value) {
    	getLoadOptions().put(key, value);
    }
    
    public void removeLoadOption(Object key) {
    	getLoadOptions().remove(key);
    }
    
    /**
     * Retrieves the resource from the {@link #getURIResourceMap()}.
     * If loadOnDemand is <code>true</code> the resource will be loaded and if not present
     * in the {@link #getURIResourceMap()} it will be created and added.
     * 
     * This method assumes that the given {@link URI} is present in the same form than the one stored in the map.
     * This method will not check against the normalized version of all the uris of the resource sin {@link #getResources()}
     * 
     * @param uri - the uri
     * @param loadOnDemand - whether the resource should be loaded and created
     * 
	 * @since 2.3
	 */
	public Resource getResourceWithoutNormalization(URI uri, boolean loadOnDemand) {
		Map<URI, Resource> map = getURIResourceMap();
		if (map == null)
			throw new IllegalStateException("A fully maintained uri resource map is required, but getURIResourceMap() was null.");
		Resource resource = map.get(uri);
		if (resource != null) {
			if (loadOnDemand && !resource.isLoaded()) {
				demandLoadHelper(resource);
			}
			return resource;
		}

		if (loadOnDemand) {
			resource = demandCreateResource(uri);
			if (resource == null) {
				throw new RuntimeException("Cannot create a resource for '" + uri
						+ "'; a registered resource factory is needed");
			}

			demandLoadHelper(resource);

			map.put(uri, resource);
			return resource;
		}

		return null;
	}
    
	@Override
	public Resource createResource(URI uri, String contentType) {
		final Resource resource = super.createResource(uri, contentType);
		Map<URI, Resource> map = getURIResourceMap();
		if (map != null) {
			map.put(uri, resource);
		}
		return resource;
	}
    
    @Override
    public URIConverter getURIConverter() {
        if (uriConverter == null) {
            uriConverter = new ExtensibleURIConverterImpl() {
                @Override
                public URI normalize(URI uri) {
                    if (ClasspathUriUtil.isClasspathUri(uri)) {
                        URI result = XtextResourceSet.this.resolveClasspathURI(uri);
                        if (ClasspathUriUtil.isClasspathUri(result))
                        	throw new ClasspathUriResolutionException(result);
                        result = super.normalize(result);
                        return result;
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
