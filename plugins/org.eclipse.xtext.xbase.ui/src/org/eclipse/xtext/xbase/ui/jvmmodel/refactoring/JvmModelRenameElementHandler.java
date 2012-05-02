/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;

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
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.ui.refactoring.JvmRenameElementHandler;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContext;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelRenameElementHandler extends JvmRenameElementHandler {

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private OperatorMappingUtil operatorMappingUtil;

	@Override
	public IRenameElementContext createRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		if (!isRealJvmMember(targetElement)) {
			Set<EObject> jvmElements = associations.getJvmElements(targetElement);
			if (!jvmElements.isEmpty()) {
				Map<URI, IJavaElement> jvm2javaElement = newLinkedHashMap();
				for (JvmIdentifiableElement jvmElement : filter(jvmElements, JvmIdentifiableElement.class)) {
					IJavaElement javaElement = getJavaElementFinder().findExactElementFor(jvmElement);
					if (javaElement != null)
						if (javaElement instanceof IMethod)
							addDeclaringMethod(jvmElement, javaElement, jvm2javaElement);
						else 
							jvm2javaElement.put(EcoreUtil.getURI(jvmElement), javaElement);
				}
				if (!jvm2javaElement.isEmpty()) {
					return new CombinedJvmJdtRenameContext(targetElement, jvm2javaElement, editor, selection, resource);
				}
			}
		}
		if (operatorMappingUtil.isMappedOperator(targetElement))
			return null;
		if (targetElement instanceof JvmFormalParameter) {
			EObject sourceParameter = associations.getPrimarySourceElement(targetElement);
			if (sourceParameter != null)
				return super.createRenameElementContext(sourceParameter, editor, selection, resource);
		}
		return super.createRenameElementContext(targetElement, editor, selection, resource);
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

}
