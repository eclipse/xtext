/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;

import com.google.inject.Inject;

/**
 * @author Sebastian Benz - Initial contribution and API
 */
public class NewTypePageConfigurer {

	private static final Logger LOG = Logger.getLogger(NewTypePageConfigurer.class);
	
	@Inject 
	private ProjectUtil projectUtil;
	
	public void configure(NewTypeWizardPage page, URI contextUri, String typeName) {
		setPackageName(page, contextUri);
		page.setTypeName(typeName, true);
	}

	public void setPackageName(NewTypeWizardPage page, URI contextUri) {
		IJavaProject javaProject = getJavaProject(contextUri);
		String path = contextUri.trimSegments(1).toPlatformString(true);
		try {
			IPackageFragment packageFragment = javaProject.findPackageFragment(new Path(path));
			IPackageFragmentRoot root = (IPackageFragmentRoot) packageFragment
					.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
			page.setPackageFragment(packageFragment, true);
			page.setPackageFragmentRoot(root, true);
		} catch (JavaModelException e) {
			LOG.error("Could not find package for " + path, e);
		}
	}

	protected IJavaProject getJavaProject(URI uri){
		IProject project = projectUtil.getProject(uri);
		if(project == null){
			return null;
		}
		return JavaCore.create(project);
	}
}
