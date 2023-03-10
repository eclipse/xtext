/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import static org.eclipse.xtext.EcoreUtil2.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class XtextCallHierarchyBuilder extends DefaultCallHierarchyBuilder {

	@Inject
	private XtextCallHierarchyNodeLocationProvider callHierarchyNodeLocationProvider;

	@Override
	protected IHierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
		return callHierarchyNodeLocationProvider;
	}

	@Override
	protected IEObjectDescription findDeclaration(URI objectURI) {
		IEObjectDescription description = getDescription(objectURI);
		if (description != null && description.getEClass() != null && isRule(description.getEClass())) {
			return description;
		}

		return readOnly(objectURI, (object) -> getDescription(getContainerOfType(object, AbstractRule.class)));
	}

	@Override
	protected boolean filterReference(IReferenceDescription reference) {
		return reference != null && isRule(reference.getEReference().getEType());
	}

	@Override
	protected IEObjectDescription findSourceDeclaration(IReferenceDescription reference) {
		return getDescription(reference.getContainerEObjectURI());
	}

	protected boolean isRule(EClassifier type) {
		return isAssignable(XtextPackage.Literals.ABSTRACT_RULE, type);
	}

	@Override
	protected IHierarchyNode createRoot(IEObjectDescription declaration) {
		XtextCallHierarchyNode node = new XtextCallHierarchyNode();
		node.setElement(declaration);
		node.setGrammarDescription(getGrammarDescription(declaration));
		node.setMayHaveChildren(true);
		return node;
	}

	@Override
	protected IHierarchyNode createChild(IEObjectDescription declaration, IHierarchyNode parent) {
		XtextCallHierarchyNode node = new XtextCallHierarchyNode();
		node.setParent(parent);
		node.setElement(declaration);
		node.setGrammarDescription(getGrammarDescription(declaration));
		node.setMayHaveChildren(isRule(declaration.getEClass()) && !node.isRecursive());
		return node;
	}

	protected IEObjectDescription getGrammarDescription(IEObjectDescription description) {
		URI resourceURI = description.getEObjectURI().trimFragment();
		Iterable<IEObjectDescription> exportedObjectsByType = getIndexData().getResourceDescription(resourceURI)
				.getExportedObjectsByType(XtextPackage.Literals.GRAMMAR);
		return Iterables.getFirst(exportedObjectsByType, null);
	}
}
