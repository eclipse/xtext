/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.generator.trace.DefaultTraceURIConverter;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultUITraceURIConverter extends DefaultTraceURIConverter {

	private final static Logger LOG = Logger.getLogger(DefaultUITraceURIConverter.class);

	@Override
	public URI getURIForTrace(XtextResource context) {
		ResourceSet rs = context.getResourceSet();
		if (!(rs instanceof XtextResourceSet && ((XtextResourceSet) rs).getClasspathURIContext() instanceof IJavaProject))
			return super.getURIForTrace(context);
		IJavaProject javaProject = (IJavaProject) ((XtextResourceSet) rs).getClasspathURIContext();
		try {
			URI uri = context.getURI();
			for (IPackageFragmentRoot root : javaProject.getPackageFragmentRoots())
				if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
					URI prefix = URI.createPlatformResourceURI(root.getResource().getFullPath().toString() + "/", true);
					if (isPrefix(prefix, uri))
						return uri.deresolve(prefix).trimFragment().trimQuery();
				}
		} catch (JavaModelException e) {
			LOG.error(e);
		}
		return super.getURIForTrace(context);
	}
	
	@Override
	public URI getURIForTrace(URI uri) {
		if (uri.isPlatform()) {
			// create a URI that is relative to the contained projects sourcefolder.
			List<String> segments = uri.segmentsList().subList(3, uri.segmentCount());
			return URI.createHierarchicalURI(segments.toArray(new String[segments.size()]), null, null);
		}
		return uri.trimFragment().trimQuery();
	}

}
