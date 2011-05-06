/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

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
public class JvmElementFinder {

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Inject
	private TypeURIHelper typeURIHelper;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IResourceDescriptions resourceDescriptions;

	public EObject getCorrespondingJvmElement(IJavaElement javaElement, ResourceSet resourceSet) {
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		URI jvmElementURI = typeURIHelper.getFullURI(javaElement);
		return resourceSet.getEObject(jvmElementURI, true);
	}
	
	public JvmIdentifiableElement findJvmElementDeclarationInIndex(EObject jvmElement, IProject project) {
		QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(jvmElement);
		if (qualifiedName != null) {
			IEObjectDescription indexedElementDescription = findIndexedElement(project, qualifiedName, jvmElement.eClass());
			if (indexedElementDescription != null)
				return (JvmIdentifiableElement) EcoreUtil.resolve(indexedElementDescription.getEObjectOrProxy(),
						jvmElement);
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
}
