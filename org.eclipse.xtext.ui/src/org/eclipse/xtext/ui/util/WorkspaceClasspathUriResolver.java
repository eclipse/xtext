/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;


/**
 * TODO: implement JDT independent strategy, maybe ignoring JARs
 *
 * @author Jan Köhnlein
 */
public class WorkspaceClasspathUriResolver extends JdtClasspathUriResolver {

    @Override
    public URI resolve(Object context, URI classpathUri) {
        if(!(context instanceof IResource)) {
            throw new IllegalArgumentException("Context must implement IResource");
        }
        IResource resource = (IResource) context;
        try {
            if (ClasspathUriUtil.isClasspathUri(classpathUri)) {
                IProject project = resource.getProject();
                IJavaProject javaProject = JavaCore.create(project);
                URI result = findResourceInWorkspace(javaProject, classpathUri);
 				if (classpathUri.fragment() != null)
 					result = result.appendFragment(classpathUri.fragment());
 				return result;
            }
        } catch (Exception exc) {
            throw new ClasspathUriResolutionException(exc);
        }
        return classpathUri;
    }
}
