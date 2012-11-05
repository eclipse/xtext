/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtend.core.dispatch.DispatchingSupport;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContext;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContextFactory;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendRenameContextFactory extends CombinedJvmJdtRenameContextFactory {
	
	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private DispatchingSupport dispatchingSupport;

	@Override
	public IRenameElementContext createLocalRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		if (!isJvmMember(targetElement) || !isTypeResource(targetElement)) {
			EObject declarationTarget = getDeclarationTarget(targetElement);
			if (declarationTarget instanceof XtendFunction && ((XtendFunction) declarationTarget).isDispatch()) {
				JvmOperation dispatcher = associations.getDispatchOperation((XtendFunction) declarationTarget);
				XtendClass xtendClass = ((XtendClass) declarationTarget.eContainer());
				Collection<JvmOperation> dispatchCases = dispatchingSupport.getDispatcher2dispatched(xtendClass, true)
						.get(dispatcher);
				Map<URI, IJavaElement> jvm2javaElement = newLinkedHashMap();
				for (JvmOperation jvmOperation : concat(dispatchCases, singleton(dispatcher))) {
					IJavaElement javaElement = getJavaElementFinder().findExactElementFor(jvmOperation);
					if (javaElement != null)
						addDeclaringMethod(jvmOperation, javaElement, jvm2javaElement);
				}
				if (!jvm2javaElement.isEmpty()) {
					return new CombinedJvmJdtRenameContext(declarationTarget, jvm2javaElement, editor, selection, resource);
				}
			}
		}
		return super.createLocalRenameElementContext(targetElement, editor, selection, resource);
	}

	@Override
	protected EObject getDeclarationTarget(EObject targetElement) {
		EObject declarationTarget = super.getDeclarationTarget(targetElement);
		if (declarationTarget instanceof XtendConstructor)
			return declarationTarget.eContainer();
		else
			return declarationTarget;
	}
}
