/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
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
	private JvmElementFinder jvmElementFinder;

	@Inject
	private IJvmModelAssociations associations;

	@Inject 
	private IRenameRefactoringProvider ownRenamRefactoringProvider;
	
	private IJavaElement javaElement;

	private ResourceSet resourceSet;

	private Set<EObject> sourceElements;

	@Override
	protected List<? extends IRenameElementContext> createRenameElementContexts(Object element) {
		if (element instanceof IJavaElement) {
			javaElement = (IJavaElement) element;
			EClass expectedJvmType = getExpectedJvmType(javaElement);
			if (expectedJvmType != null) {
				IJavaProject javaProject = javaElement.getJavaProject();
				IProject project = javaProject.getProject();
				resourceSet = resourceSetProvider.get(project);
				EObject correspondingJvmElement = jvmElementFinder.getCorrespondingJvmElement(javaElement, resourceSet);
				JvmIdentifiableElement jvmElementDeclaration = jvmElementFinder.findJvmElementDeclarationInIndex(correspondingJvmElement, project);
				if (jvmElementDeclaration != null) {
					// jvmElement is inferred from some Xtext based element
					sourceElements = associations.getSourceElements(jvmElementDeclaration);
					if (!isEmpty(sourceElements)) {
						// source is xtend
						List<IRenameElementContext> contexts = newArrayList();
						for (EObject sourceElement : sourceElements)
							contexts.add(createRenameDeclarationContext(sourceElement));
						return contexts;
					}
				} else if(correspondingJvmElement instanceof JvmMember){
					// there is no declaration in the index, so search for references only
					return singletonList(createRenameReferenceContext((JvmMember)correspondingJvmElement));
				}
			}
		}
		return null;
	}

	protected RenameJvmReferenceContext createRenameReferenceContext(JvmMember jvmMember) {
		return new RenameJvmReferenceContext(jvmMember, javaElement, null, null, null);
	}
	
	protected IRenameElementContext createRenameDeclarationContext(EObject jvmElement) {
		// TODO: new constructor?
		return new IRenameElementContext.Impl(EcoreUtil2.getNormalizedURI(jvmElement), jvmElement.eClass(), null,
				null, null);
	}

	@Override
	protected IRenameRefactoringProvider getRenameRefactoringProvider(IRenameElementContext renameElementContext) {
		return ownRenamRefactoringProvider;
	}
	
	@Override
	protected List<EObject> getRenamedElementsOrProxies(EObject originalTarget) {
		// obsolete
		return null;
	}

	protected EClass getExpectedJvmType(IJavaElement javaElement) {
		try {
			switch (javaElement.getElementType()) {
				case IJavaElement.TYPE:
					return TypesPackage.Literals.JVM_TYPE;
				case IJavaElement.METHOD:
					IMethod method = (IMethod) javaElement;
					if (method.isConstructor())
						return TypesPackage.Literals.JVM_CONSTRUCTOR;
					else
						return TypesPackage.Literals.JVM_OPERATION;
				case IJavaElement.FIELD:
					return TypesPackage.Literals.JVM_FIELD;
				default:
					return null;
			}
		} catch (JavaModelException exc) {
			throw new WrappedException(exc);
		}
	}
}
