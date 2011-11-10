/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.ui.refactoring.impl.AbstractProcessorBasedRenameParticipant;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JdtRenameParticipant extends AbstractProcessorBasedRenameParticipant {

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private JvmElementFinder jvmElementFinder;

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
					EObject indexedJvmElement = jvmElementFinder.findJvmElementDeclarationInIndex(directJvmElement,
							project);
					if (indexedJvmElement != null)
						// jvmElement is indexed, thus contained in an XtextResurce and likely inferred from some Xtext-based elements
						return getContextFactory(indexedJvmElement).createJdtParticipantXtextSourceContexts(indexedJvmElement);
					else if (directJvmElement instanceof JvmMember)
						// jvmElement is only cross referenced by Xtext-based elements
						return createJdtRenameParticipantContext((JvmMember) directJvmElement, javaElement);
				}
			}
		}
		return null;
	}

	protected List<? extends IRenameElementContext> createJdtRenameParticipantContext(JvmMember renamedJvmMember,
			IJavaElement javaElement) {
		return singletonList(new JdtRenameParticipantContext(renamedJvmMember, javaElement));
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

	protected ContextFactory getContextFactory(EObject jvmMember) {
		return getGlobalServiceProvider().findService(getURI(jvmMember), ContextFactory.class);
	}
	
	public static class ContextFactory {
		protected List<? extends IRenameElementContext> createJdtParticipantXtextSourceContexts(
				EObject indexedJvmElement) {
			return Collections.emptyList();
		}
	}
}
