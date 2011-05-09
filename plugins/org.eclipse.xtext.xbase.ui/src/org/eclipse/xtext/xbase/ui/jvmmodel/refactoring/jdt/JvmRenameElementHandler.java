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

import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.RenameElementHandler;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmRenameElementHandler extends RenameElementHandler {

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private IJavaElementFinder javaElementFinder;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		return super.execute(event);
	}

	@Override
	public IRenameElementContext createRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		if (targetElement.eClass() != null && targetElement.eClass().getEPackage() == TypesPackage.eINSTANCE
				&& targetElement instanceof JvmMember) {
			IJavaElement javaElement = javaElementFinder.findElementFor((JvmMember) targetElement);
			if (javaElement != null)
				return new RenameJvmReferenceContext((JvmMember) targetElement, javaElement, editor, selection,
						resource.getURI());
		}
		Set<EObject> jvmElements = associations.getJvmElements(targetElement);
		if (!jvmElements.isEmpty()) {
			List<IJavaElement> javaElements = newArrayList(filter(
					transform(filter(jvmElements, JvmIdentifiableElement.class),
							new Function<JvmIdentifiableElement, IJavaElement>() {
								public IJavaElement apply(JvmIdentifiableElement from) {
									return javaElementFinder.findElementFor(from);
								}
							}), Predicates.notNull()));
			if (!javaElements.isEmpty()) {
				return new RenameJvmDeclarationContext(EcoreUtil2.getNormalizedURI(targetElement),
						targetElement.eClass(), javaElements, editor, selection,
						EcoreUtil2.getNormalizedResourceURI(targetElement));
			}
		}
		return super.createRenameElementContext(targetElement, editor, selection, resource);
	}

	@Override
	protected void startRenameElement(IRenameElementContext renameElementContext) throws InterruptedException {
		super.startRenameElement(renameElementContext);
	}
}
