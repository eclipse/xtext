/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.descriptions.EObjectDescriptionBasedStubGenerator;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * Creates a working copy owner for a given javaProject and resource set, 
 * which produces stubs for any inferred Java types which are in the index and on the project's classpath.
 * 
 * This allows for resolving Java elements against non existing (i.e. yet to be generated) Java types. 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Anton Kosyakov - Removed the check that a resource, that contains derived jvm types, is on the project's classpath.
 * @since 2.4
 */
public class WorkingCopyOwnerProvider implements IWorkingCopyOwnerProvider {
	
	@Inject private ResourceDescriptionsProvider descriptionsProvider;
	
	@Inject private EObjectDescriptionBasedStubGenerator stubGenerator;

	@Override
	public WorkingCopyOwner getWorkingCopyOwner(final IJavaProject javaProject, final ResourceSet resourceSet) {
		return new WorkingCopyOwner() {
			@Override
			public String findSource(String typeName, String packageName) {
				if (packageName.startsWith("java"))
					return super.findSource(typeName, packageName);
				QualifiedName qn = toQualifiedName(packageName, typeName);
				final IResourceDescriptions descriptions = descriptionsProvider.getResourceDescriptions(resourceSet);
				Iterator<IEObjectDescription> exportedObjects = descriptions.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, qn, false).iterator();
				while (exportedObjects.hasNext()) {
					IEObjectDescription candidate = exportedObjects.next();
					URI uri = candidate.getEObjectURI();
					if (uri.isPlatformResource() && URI.decode(uri.segment(1)).equals(javaProject.getElementName()))
						return getSource(typeName, packageName, candidate, resourceSet);
				}
				return super.findSource(typeName, packageName);
			}
			
			
			/**
			 * not implemented because we don't have a proper index for Java package names and the very rare cases in which this would
			 * cause trouble are not worth the general degrade in performance.
			 */
			@Override public boolean isPackage(String[] pkg) {
				return super.isPackage(pkg);
			}
		};
	}
	
	/**
	 * @deprecated This method is not used anymore. It is not necessary that a resource, that contains derived jvm types, is on the project's classpath. 
	 */
	@Deprecated
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
		return stubGenerator.getJavaStubSource(next);
	}

	protected QualifiedName toQualifiedName(String packageName, String typeName) {
		List<String> splitPackage = Strings.split(packageName, '.');
		splitPackage.add(typeName);
		QualifiedName qn = QualifiedName.create(splitPackage);
		return qn;
	}
	
}
