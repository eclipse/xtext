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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.ui.refactoring.JdtRefactoringContext;
import org.eclipse.xtext.common.types.ui.refactoring.JvmRenameElementHandler;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
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
				List<IJavaElement> javaElements = newArrayList(filter(
						transform(filter(jvmElements, JvmIdentifiableElement.class),
								new Function<JvmIdentifiableElement, IJavaElement>() {
									public IJavaElement apply(JvmIdentifiableElement from) {
										return getJavaElementFinder().findExactElementFor(from);
									}
								}), Predicates.notNull()));
				if (!javaElements.isEmpty()) {
					return new JdtRefactoringContext(targetElement, javaElements, editor, selection,
							resource, false);
				}
			}
		}
		if(operatorMappingUtil.isMappedOperator(targetElement))
			return null;
		if(targetElement instanceof JvmFormalParameter) {
			EObject sourceParameter = associations.getPrimarySourceElement(targetElement);
			if(sourceParameter != null)
				return super.createRenameElementContext(sourceParameter, editor, selection, resource);
		}
		return super.createRenameElementContext(targetElement, editor, selection, resource);
	}

}
