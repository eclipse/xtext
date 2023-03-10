/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import static java.util.Collections.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import static org.eclipse.emf.ecore.util.EcoreUtil.*;

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.ui.refactoring.impl.AbstractProcessorBasedRenameParticipant;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * Participant for JDT refactorings. 
 * 
 * Is based on refactoring processors which are created using an
 * {@link org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider}. The participant is registered by the plug-in
 * org.eclipse.xtext.common.types.shared, and delegates to the declaring language if the equivalent JVM target element
 * is contained in the index.
 * 
 * Languages that do not define own JVM elements but refer to existing Java artifacts only, don't have to implement
 * anything additional to get their references updated. Languages that define own JvmElements should implement and bind
 * a {@link ContextFactory}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JdtRenameParticipant extends AbstractProcessorBasedRenameParticipant {

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private JvmElementFinder jvmElementFinder;

	@Inject
	private CompositeRefactoringProcessor.Access compositeRefactoringProcessorAccess;

	@Override
	public String getName() {
		return "Xtext JdtRenameParticipant";
	}

	@Override
	protected List<? extends IRenameElementContext> createRenameElementContexts(Object element) {
		if (element instanceof IJavaElement) {
			IJavaElement javaElement = (IJavaElement) element;
			EClass expectedJvmType = getExpectedJvmType(javaElement);
			if (expectedJvmType != null) {
				IJavaProject javaProject = javaElement.getJavaProject();
				IProject project = javaProject.getProject();
				ResourceSet resourceSet = resourceSetProvider.get(project);
				EObject directJvmElement = jvmElementFinder.getCorrespondingJvmElement(javaElement, resourceSet);
				if (directJvmElement != null && expectedJvmType.isSuperTypeOf(directJvmElement.eClass())) {
					ResourceSet resourceSet2 = resourceSetProvider.get(project);
					EObject indexedJvmElement = jvmElementFinder.findJvmElementDeclarationInIndex(directJvmElement,
							project, resourceSet2);
					if (indexedJvmElement != null)
						// jvmElement is indexed, thus contained in an XtextResurce and likely inferred from some Xtext-based elements
						return getContextFactory(indexedJvmElement).createJdtParticipantXtextSourceContexts(
								this, indexedJvmElement);
					else if (directJvmElement instanceof JvmMember)
						// jvmElement could only be cross referenced by Xtext-based elements
						return createJdtRenameParticipantContext((JvmMember) directJvmElement, javaElement);
				}
			}
		}
		return null;
	}

	@Override
	protected RenameProcessor getRenameProcessor(IRenameElementContext participantContext) {
		RenameProcessor renameProcessor = super.getRenameProcessor(participantContext);
		// We need to do all changes for one language inside the same processor in order to be able to 
		// restructure them to avoid collisions. That's why we add all processors to the same composite 
		// which is only returned in the first context.
		CompositeRefactoringProcessor current = compositeRefactoringProcessorAccess.getCurrent(getProcessor());
		current.addProcessor(renameProcessor);
		if (current.getNumProcessors() == 1)
			return current;
		else
			return null;
	}

	protected List<? extends IRenameElementContext> createJdtRenameParticipantContext(JvmMember renamedJvmMember,
			IJavaElement javaElement) {
		return singletonList(new JdtRenameParticipantContext(this, renamedJvmMember, javaElement));
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
					if (((IType) javaElement).isEnum())
						return TypesPackage.Literals.JVM_ENUMERATION_TYPE;
					else
						return TypesPackage.Literals.JVM_TYPE;
				case IJavaElement.METHOD:
					if (((IMethod) javaElement).isConstructor())
						return TypesPackage.Literals.JVM_CONSTRUCTOR;
					else
						return TypesPackage.Literals.JVM_OPERATION;
				case IJavaElement.FIELD:
					if (((IField) javaElement).isEnumConstant())
						return TypesPackage.Literals.JVM_ENUMERATION_LITERAL;
					else
						return TypesPackage.Literals.JVM_FIELD;
				default:
					return null;
			}
		} catch (JavaModelException exc) {
			throw new WrappedException(exc);
		}
	}

	protected ContextFactory getContextFactory(EObject jvmMember) {
		return getGlobalServiceProvider().findService(getURI(jvmMember), ContextFactory.class);
	}

	public static class ContextFactory {
		protected List<? extends IRenameElementContext> createJdtParticipantXtextSourceContexts(
				JdtRenameParticipant participant, EObject indexedJvmElement) {
			return Collections.emptyList();
		}
	}
	
	@Override
	protected void dispose() {
		super.dispose();
		compositeRefactoringProcessorAccess.disposeCurrent();
	}
}
