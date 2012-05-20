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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * A resource set that is capable of resolving classpath URIs.
 * 
 * It maintains a {@link #getURIResourceMap()} containing the resource's URI as well as the normalized version of it as a key.
 * It assumes that the {@link URI} of a resource never changes while contained in the {@link #getResources()} list. 
 * 
 * @author Jan Köhnlein
 * @author Sven Efftinge
 */
public class XtextResourceSet extends ResourceSetImpl {
	
	/**
	 * adds the added resource to the {@link ResourceSetImpl#getURIResourceMap()}.
	 * 
	 * @since 2.3
	 */
	@SuppressWarnings("serial")
	protected class ResourcesList extends ResourceSetImpl.ResourcesEList<Resource> {
		@Override
		protected NotificationChain inverseAdd(Resource resource, NotificationChain notifications) {
			NotificationChain chain = super.inverseAdd(resource, notifications);
			Map<URI, Resource> map = getURIResourceMap();
			if (map != null) {
				final URI uri = resource.getURI();
				URI normalized = getURIConverter().normalize(uri);
				map.put(uri, resource);
				map.put(normalized, resource);
			}
			return chain;
		}
	}
	
    private IClasspathUriResolver resolver;

    private Object classpathURIContext;

    public XtextResourceSet() {
    	setURIResourceMap(new HashMap<URI,Resource>());
    	resources = new ResourcesList();
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
    
    @Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		Map<URI, Resource> map = getURIResourceMap();
		if (map == null)
			return super.getResource(uri, loadOnDemand);
		Resource resource = map.get(uri);
		if (resource == null) {
			URI normalizedURI = getURIConverter().normalize(uri);
			resource = map.get(normalizedURI);
		}
		if (resource != null) {
			if (loadOnDemand && !resource.isLoaded()) {
				demandLoadHelper(resource);
			}
			return resource;
		}
		
	    Resource delegatedResource = delegatedGetResource(uri, loadOnDemand);
	    if (delegatedResource != null)
	    {
	      return delegatedResource;
	    }

	    if (loadOnDemand)
	    {
	      resource = demandCreateResource(uri);
	      if (resource == null) {
	        throw new RuntimeException("Cannot create a resource for '" + uri + "'; a registered resource factory is needed");
	      }

	      demandLoadHelper(resource);

	      return resource;
	    }

	    return null;
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
