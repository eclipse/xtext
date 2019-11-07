/**
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.EditorResourceAccess;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractOpenHierarchyHandler;
import org.eclipse.xtext.ui.editor.hierarchy.DeferredHierarchyBuilder;

import com.google.inject.Inject;

public class OpenCallHierarchyHandler extends AbstractOpenHierarchyHandler {
	private static String HIERARCHY_VIEW_PART_ID = "org.eclipse.xtext.example.arithmetics.ui.ArithmeticsCallHierarchy";

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	@Inject
	private EditorResourceAccess resourceAccess;

	@Override
	protected String getHierarchyViewPartID() {
		return OpenCallHierarchyHandler.HIERARCHY_VIEW_PART_ID;
	}

	@Override
	protected IHierarchyBuilder createHierarchyBuilder(EObject target) {
		ArithmeticsCallHierarchyBuilder xtextCallHierarchyBuilder = globalServiceProvider.findService(target,
				ArithmeticsCallHierarchyBuilder.class);
		xtextCallHierarchyBuilder.setResourceAccess(resourceAccess);
		IResourceDescriptions indexData = globalServiceProvider.findService(target, IResourceDescriptions.class);
		xtextCallHierarchyBuilder.setIndexData(indexData);
		DeferredHierarchyBuilder deferredHierarchyBuilder = globalServiceProvider.findService(target,
				DeferredHierarchyBuilder.class);
		deferredHierarchyBuilder.setHierarchyBuilder(xtextCallHierarchyBuilder);
		return deferredHierarchyBuilder;
	}
}
