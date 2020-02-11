/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;

/**
 * A classpath URI resolver that looks up a resource in the classpath of the
 * context attribute.
 * 
 * @author Jan Köhnlein
 */
public class ClassloaderClasspathUriResolver implements IClasspathUriResolver {

    /**
     * Locates a resource using a classloader.
     * 
     * @param context
     *      the classloader to be used, or an object whose classloader is used.
     *      If null, the context classloader of the current thread is used.
     */
    @Override
	public URI resolve(Object context, URI classpathUri) {
    	Object myContext = context;
        if (myContext == null) {
            myContext = Thread.currentThread().getContextClassLoader();
        }
        if (myContext instanceof Class<?>) {
            myContext = ((Class<?>)myContext).getClassLoader();
        }
        if (!(myContext instanceof ClassLoader)) {
        	myContext = myContext.getClass().getClassLoader();
        }
        ClassLoader classLoader = (ClassLoader) myContext;
        try {
            if (ClasspathUriUtil.isClasspathUri(classpathUri)) {
                return findResourceOnClasspath(classLoader, classpathUri);
            }
        } catch (Exception exc) {
            throw new ClasspathUriResolutionException(exc);
        }
        return classpathUri;
    }

    public URI findResourceOnClasspath(ClassLoader classLoader, URI classpathUri) throws URISyntaxException {
        String pathAsString = classpathUri.path();
        if (classpathUri.hasAbsolutePath()) {
            pathAsString = pathAsString.substring(1);
        }
        URL resource = classLoader.getResource(pathAsString);
        if (resource==null)
        	throw new FileNotFoundOnClasspathException("Couldn't find resource on classpath. URI was '"+classpathUri+"'");
        URI fileUri = URI.createURI(resource.toString(),true);
        return fileUri.appendFragment(classpathUri.fragment());
    }

}
