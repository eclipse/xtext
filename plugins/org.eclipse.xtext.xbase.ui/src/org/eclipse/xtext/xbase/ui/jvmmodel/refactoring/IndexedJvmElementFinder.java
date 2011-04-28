/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class IndexedJvmElementFinder {

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Inject
	private TypeURIHelper typeURIHelper;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IResourceDescriptions resourceDescriptions;

	protected JvmIdentifiableElement findIndexedJvmElement(IJavaElement javaElement, EClass expectedJvmType,
			ResourceSet resourceSet) {
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		QualifiedName qualifiedName = getQualifiedNameForJavaElement(javaElement, resourceSet);
		if (qualifiedName != null) {
			IEObjectDescription indexedElementDescription = findIndexedElement(javaElement.getJavaProject()
					.getProject(), qualifiedName, expectedJvmType);
			if (indexedElementDescription != null)
				return (JvmIdentifiableElement) EcoreUtil.resolve(indexedElementDescription.getEObjectOrProxy(),
						resourceSet);
		}
		return null;

	}

	protected IEObjectDescription findIndexedElement(IProject project, QualifiedName qualifiedName,
			EClass expectedJvmType) {
		for (IEObjectDescription candidate : resourceDescriptions.getExportedObjects(expectedJvmType, qualifiedName,
				true)) {
			if (candidate.getEObjectURI().isPlatformResource()
					&& Strings.equal(project.getName(), candidate.getEObjectURI().segment(1)))
				return candidate;
		}
		return null;
	}

	protected QualifiedName getQualifiedNameForJavaElement(IJavaElement javaElement, ResourceSet resourceSet) {
		URI elementURI = typeURIHelper.getFullURI(javaElement);
		EObject eObject = resourceSet.getEObject(elementURI, true);
		return (eObject != null) ? qualifiedNameProvider.getFullyQualifiedName(eObject) : null;
	}

}
