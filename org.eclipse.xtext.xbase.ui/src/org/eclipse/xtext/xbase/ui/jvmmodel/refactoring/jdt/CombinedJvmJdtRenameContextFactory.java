/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.corext.util.MethodOverrideTester;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.ui.refactoring.JdtRefactoringContextFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class CombinedJvmJdtRenameContextFactory extends JdtRefactoringContextFactory {

	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private OverrideHelper overrideHelper;
	
	@Override
	public IRenameElementContext createLocalRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		EObject declarationTarget = getDeclarationTarget(targetElement);
		Set<EObject> jvmElements = filterJvmElements(associations.getJvmElements(declarationTarget));
		
		if (!jvmElements.isEmpty()) {
			Map<URI, IJavaElement> jvm2javaElement = newLinkedHashMap();
			for (JvmIdentifiableElement jvmElement : filter(jvmElements, JvmIdentifiableElement.class)) {
				JvmIdentifiableElement jvmElementToBeRenamed = (jvmElement instanceof JvmConstructor) 
						? ((JvmConstructor) jvmElement).getDeclaringType()
						: jvmElement;
				IJavaElement javaElement = getJavaElementFinder().findExactElementFor(jvmElementToBeRenamed);
				if (javaElement != null)
					if (javaElement instanceof IMethod)
						addDeclaringMethod(jvmElementToBeRenamed, javaElement, jvm2javaElement);
					else
						jvm2javaElement.put(EcoreUtil.getURI(jvmElementToBeRenamed), javaElement);
			}
			if (!jvm2javaElement.isEmpty()) {
				return new CombinedJvmJdtRenameContext(declarationTarget, jvm2javaElement, editor, selection, resource);
			}
		}
		if (targetElement instanceof JvmFormalParameter || targetElement instanceof JvmTypeParameter) {
			EObject sourceParameter = associations.getPrimarySourceElement(targetElement);
			if (sourceParameter != null)
				return super.createLocalRenameElementContext(sourceParameter, editor, selection, resource);
		}
		return super.createLocalRenameElementContext(targetElement, editor, selection, resource);
	}

	protected EObject getDeclarationTarget(EObject targetElement) {
		EObject target;
		if (targetElement instanceof JvmConstructor)
			target = ((JvmConstructor) targetElement).getDeclaringType();
		else
			target = targetElement;
		EObject declarationTarget = associations.getPrimarySourceElement(target);
		return (declarationTarget != null) ? declarationTarget : target;
	}

	protected void addDeclaringMethod(JvmIdentifiableElement jvmElement, IJavaElement javaElement,
			Map<URI, IJavaElement> jvm2javaElement) {
		try {
			IType declaringType = ((IMethod) javaElement).getDeclaringType();
			ITypeHierarchy typeHierarchy = declaringType.newSupertypeHierarchy(new NullProgressMonitor());
			MethodOverrideTester methodOverrideTester = new MethodOverrideTester(declaringType, typeHierarchy);
			IMethod declaringMethod = methodOverrideTester.findDeclaringMethod((IMethod) javaElement, true);
			if (declaringMethod != null)
				jvm2javaElement.put(EcoreUtil.getURI(jvmElement), declaringMethod);
			else
				jvm2javaElement.put(EcoreUtil.getURI(jvmElement), javaElement);
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected Set<EObject> filterJvmElements(Set<EObject> unfiltered) {
		Set<EObject> filtered = newLinkedHashSet();
		for (EObject element : unfiltered) {
			if (isAcceptedElement(element)) {
				filtered.add(element);
			}
		}
		return filtered;
	}
	
	protected boolean isAcceptedElement(EObject jvmElement) {
		if (jvmElement instanceof JvmOperation) {
			JvmOperation op = (JvmOperation) jvmElement;
			if (!associations.isPrimaryJvmElement(op) && overrideHelper.findOverriddenOperation(op) != null) {
				return false;
			}
		}
		return true;
	}
}
