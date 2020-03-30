/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.EditorResourceAccess;

import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class OpenCallHierarchyHandler extends AbstractOpenHierarchyHandler {

	public static final String HIERARCHY_VIEW_PART_ID = "org.eclipse.xtext.ui.XtextCallHierarchy";

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	@Inject
	private EditorResourceAccess resourceAccess;

	@Override
	protected String getHierarchyViewPartID() {
		return HIERARCHY_VIEW_PART_ID;
	}

	@Override
	protected IHierarchyBuilder createHierarchyBuilder(EObject target) {
		XtextCallHierarchyBuilder xtextCallHierarchyBuilder = globalServiceProvider.findService(target, XtextCallHierarchyBuilder.class);
		xtextCallHierarchyBuilder.setResourceAccess(resourceAccess);
		xtextCallHierarchyBuilder.setIndexData(globalServiceProvider.findService(target, IResourceDescriptions.class));

		DeferredHierarchyBuilder deferredHierarchyBuilder = globalServiceProvider.findService(target, DeferredHierarchyBuilder.class);
		deferredHierarchyBuilder.setHierarchyBuilder(xtextCallHierarchyBuilder);
		return deferredHierarchyBuilder;
	}
}
