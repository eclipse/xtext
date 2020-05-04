/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.EditorResourceAccess;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractOpenHierarchyHandler;
import org.eclipse.xtext.ui.editor.hierarchy.DeferredHierarchyBuilder;

import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 */
public class OpenAssociationHierarchyHandler extends AbstractOpenHierarchyHandler {
	private static final String HIERARCHY_VIEW_PART_ID = "org.eclipse.xtext.example.domainmodel.ui.editor.AssociationHierarchy";

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	@Inject
	private EditorResourceAccess resourceAccess;

	@Override
	protected String getHierarchyViewPartID() {
		return OpenAssociationHierarchyHandler.HIERARCHY_VIEW_PART_ID;
	}

	@Override
	protected IHierarchyBuilder createHierarchyBuilder(EObject target) {
		AssociationHierarchyBuilder xtextCallHierarchyBuilder = globalServiceProvider.findService(target,
				AssociationHierarchyBuilder.class);
		xtextCallHierarchyBuilder.setResourceAccess(resourceAccess);
		xtextCallHierarchyBuilder.setIndexData(globalServiceProvider.findService(target, IResourceDescriptions.class));
		DeferredHierarchyBuilder deferredHierarchyBuilder = globalServiceProvider.findService(target, DeferredHierarchyBuilder.class);
		deferredHierarchyBuilder.setHierarchyBuilder(xtextCallHierarchyBuilder);
		return deferredHierarchyBuilder;
	}
}
