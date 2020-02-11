/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContextFactory;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendRenameContextFactory extends CombinedJvmJdtRenameContextFactory {

	@Inject
	private DispatchRenameSupport dispatchRenameSupport;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private ProjectUtil projectUtil;

	@Override
	public IRenameElementContext createLocalRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		EObject declarationTarget = getDeclarationTarget(targetElement);
		if (declarationTarget instanceof XtendFunction && ((XtendFunction) declarationTarget).isDispatch()) {
			IProject project = projectUtil.getProject(declarationTarget.eResource().getURI());
			ResourceSet resourceSet = resourceSetProvider.get(project);
			XtendFunction relaodedDispatchFunction = (XtendFunction) resourceSet.getEObject(
					EcoreUtil2.getPlatformResourceOrNormalizedURI(declarationTarget), true);
			Iterable<JvmOperation> allDispatchOperations = dispatchRenameSupport
					.getAllDispatchOperations(relaodedDispatchFunction);
			Map<URI, IJavaElement> jvm2javaElement = newLinkedHashMap();
			for (JvmOperation jvmOperation : allDispatchOperations) {
				IJavaElement javaElement = getJavaElementFinder().findExactElementFor(jvmOperation);
				if (javaElement != null) {
					URI jvmOperationURI = EcoreUtil.getURI(jvmOperation);
					jvm2javaElement.put(jvmOperationURI, javaElement);
				}
			}
			if (!jvm2javaElement.isEmpty()) {
				return new DispatchMethodRenameContext(relaodedDispatchFunction, jvm2javaElement, editor, selection,
						resource);
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
