/**
 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
public class DomainmodelOutlineTreeProvider extends DefaultOutlineTreeProvider {
	@Override
	protected void _createChildren(DocumentRootNode parentNode, EObject rootElement) {
		for (EObject content : rootElement.eContents()) {
			createNode(parentNode, content);
		}
	}

	protected void _createNode(IOutlineNode parent, JvmParameterizedTypeReference modelElement) {
	}

	protected boolean _isLeaf(Entity entity) {
		return entity.getFeatures().isEmpty();
	}

	protected boolean _isLeaf(Feature feature) {
		return true;
	}
}
