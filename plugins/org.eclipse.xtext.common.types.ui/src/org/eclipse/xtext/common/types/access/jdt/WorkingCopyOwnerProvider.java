/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * Creates a working copy owner for a given javaProject and resourceset, 
 * which produces stubs for any inferred Java types which are in the index and on the project's classpath.
 * 
 * This allows for resolving Java elements against non existing (i.e. yet to be generated) Java types. 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class WorkingCopyOwnerProvider {
	
	@Inject private ResourceDescriptionsProvider descriptionsProvider;
	
	@Inject private IStorage2UriMapper storage2UriMapper;

	public WorkingCopyOwner getWorkingCopyOwner(final IJavaProject javaProject, final ResourceSet resourceset) {
		final IResourceDescriptions descriptions = descriptionsProvider.getResourceDescriptions(resourceset);
		return new WorkingCopyOwner() {
			@Override
			public String findSource(String typeName, String packageName) {
				if (packageName.startsWith("java"))
					return super.findSource(typeName, packageName);
				QualifiedName qn = toQualifiedName(packageName, typeName);
				Iterator<IEObjectDescription> exportedObjects = descriptions.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, qn, false).iterator();
				while (exportedObjects.hasNext()) {
					final IEObjectDescription candidate = exportedObjects.next();
					Iterator<Pair<IStorage, IProject>> storage = storage2UriMapper.getStorages(candidate.getEObjectURI().trimFragment()).iterator();
					while (storage.hasNext()) {
						IStorage next = storage.next().getFirst();
						if (isOnClassPath(javaProject, next))
							return getSource(typeName, packageName, candidate, resourceset);
					}
				}
				return super.findSource(typeName, packageName);
			}
		};
	}
	
	protected boolean isOnClassPath(IJavaProject javaProject, IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			javaProject.isOnClasspath(((IJarEntryResource) storage).getPackageFragmentRoot());
		}
		if (storage instanceof IResource) {
			return javaProject.isOnClasspath((IResource)storage);
		}
		return false;
	}

	protected String getSource(String typeName, String packageName, IEObjectDescription next, ResourceSet resourceset) {
		StringBuilder result = new StringBuilder();
		if (packageName != null) {
			result.append("package ").append(packageName).append("; public ");
		}
		if (next.getEClass() == TypesPackage.Literals.JVM_ANNOTATION_TYPE) {
			result.append("@interface ");
		} else if (next.getEClass() == TypesPackage.Literals.JVM_ENUMERATION_TYPE) {
			result.append("enum ");
		} else {
			// see org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy.IS_INTERFACE
			if (next.getUserData("interface") != null) {
				result.append("interface ");
			} else {
				result.append("class ");
			}
		}
		result.append(typeName).append("{}");
		return result.toString();
	}

	protected QualifiedName toQualifiedName(String packageName, String typeName) {
		QualifiedName qn = QualifiedName.create();
		if (packageName != null) {
			int from = -1;
			int to = packageName.indexOf('.');
			while (to != -1) {
				qn = qn.append(packageName.substring(from+1,  to));
				from = to;
				to = packageName.indexOf('.', from+1);
			}
			qn = qn.append(packageName.substring(from+1));
		}
		qn = qn.append(typeName);
		return qn;
	}
	
}
