/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.osgi.framework.Bundle;

public class BundleClasspathUriResolver implements IClasspathUriResolver {

    @Override
	public URI resolve(Object context, URI classpathUri) {
        if (context instanceof Plugin) {
            context = ((Plugin) context).getBundle();
        }
        if (!(context instanceof Bundle)) {
            throw new IllegalArgumentException("Context must implement Bundle");
        }
        Bundle bundle = (Bundle) context;
        try {
            if (ClasspathUriUtil.isClasspathUri(classpathUri)) {
                URI result = findResourceInBundle(bundle, classpathUri);
 				if (classpathUri.fragment() != null)
 					result = result.appendFragment(classpathUri.fragment());
 				return result;
            }
        } catch (Exception exc) {
            throw new ClasspathUriResolutionException(exc);
        }
        return classpathUri;
    }


    private URI findResourceInBundle(Bundle bundle, URI classpathUri)
            throws MalformedURLException, IOException {
        Path fullPath = new Path(classpathUri.path());
        if (bundle != null) {
            String projectRelativePath = "/" + fullPath;
            URL resourceUrl = bundle.getResource(projectRelativePath);
            if (resourceUrl != null) {
            	URL resolvedUrl = FileLocator.resolve(resourceUrl);
                URI normalizedURI = URI.createURI(
                        resolvedUrl.toString(), true);
                return normalizedURI;
            }
        }
        return classpathUri;
    }

}
