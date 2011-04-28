/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.ui.refactoring.impl.AbstractProcessorBasedRenameParticipant;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JDTRenamePartcipant extends AbstractProcessorBasedRenameParticipant {

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject 
	private IndexedJvmElementFinder jvmElementFinder;
	
	@Inject
	private IJvmModelAssociations associations;


	private IJavaElement javaElement;

	private ResourceSet resourceSet;

	private Set<EObject> sourceElements;

	@Override
	protected List<IRenameElementContext> createRenameElementContexts(Object element) {
		if (element instanceof IMethod) {
			javaElement = (IJavaElement) element;
			IJavaProject javaProject = javaElement.getJavaProject();
			IProject project = javaProject.getProject();
			resourceSet = resourceSetProvider.get(project);
			JvmIdentifiableElement jvmElement = jvmElementFinder.findIndexedJvmElement(javaElement, TypesPackage.Literals.JVM_OPERATION, resourceSet);
			if (jvmElement != null) {
				sourceElements = associations.getSourceElements(jvmElement);
				if(!isEmpty(sourceElements)) {
					// source is xtend
					List<IRenameElementContext> contexts = newArrayList();
					for(EObject sourceElement: sourceElements) 
						contexts.add(createRenameElementContext(sourceElement));
					return contexts;
				}
			} else {
				// TODO: handle reference from xtend
				// TODO: handle xtend overrides
			}
		}
		return null;
	}

	protected IRenameElementContext createRenameElementContext(EObject sourceElement) {
		// TODO: new constructor?
		return new IRenameElementContext.Impl(EcoreUtil2.getNormalizedURI(sourceElement), sourceElement.eClass(), null, null, null);
	}

	@Override
	protected List<EObject> getRenamedElementsOrProxies(EObject originalTarget) {
		// obsolete
		return null;
	}

}
