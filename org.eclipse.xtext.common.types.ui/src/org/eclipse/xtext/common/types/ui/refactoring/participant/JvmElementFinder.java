/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.inject.Inject;

/**
 * Helps to resolve {@link JvmIdentifiableElement}s corresponding to {@link IJavaElement}s.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmElementFinder {

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Inject
	private TypeURIHelper typeURIHelper;

	@Inject
	private IResourceDescriptions resourceDescriptions;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	public EObject getCorrespondingJvmElement(IJavaElement javaElement, ResourceSet resourceSet) {
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		URI jvmElementURI = typeURIHelper.getFullURI(javaElement);
		return (jvmElementURI != null) ? resourceSet.getEObject(jvmElementURI, true) : null;
	}

	public EObject findJvmElementDeclarationInIndex(EObject jvmElement, IProject project, ResourceSet resourceSet) {
		JvmType type = EcoreUtil2.getContainerOfType(jvmElement, JvmType.class);
		if (type == null)
			return null;
		QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(type);
		if (qualifiedName != null) {
			Iterator<IEObjectDescription> exportedObjects = resourceDescriptions.getExportedObjects(type.eClass(), qualifiedName, false).iterator();
			if (exportedObjects.hasNext()) {
				URI eObjectURI = exportedObjects.next().getEObjectURI();
				EObject eObject = resourceSet.getEObject(eObjectURI, true);
				if (type != jvmElement) {
					TreeIterator<EObject> contents = eObject.eAllContents();
					QualifiedName nameOfActualElement = qualifiedNameProvider.getFullyQualifiedName(jvmElement);
					while (contents.hasNext()) {
						EObject next = contents.next();
						if (jvmElement.eClass().isInstance(next) && 
							nameOfActualElement.equals(qualifiedNameProvider.getFullyQualifiedName(next))) {
							return next;
						}
					}
				}
				return eObject;
			}
		}
		return null;
	}
	
	
}
