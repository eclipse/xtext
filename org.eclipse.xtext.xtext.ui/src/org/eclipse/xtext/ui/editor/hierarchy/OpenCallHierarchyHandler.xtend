/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.IGlobalServiceProvider
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.ui.editor.findrefs.EditorResourceAccess

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
class OpenCallHierarchyHandler extends AbstractOpenHierarchyHandler {

	public static val HIERARCHY_VIEW_PART_ID = 'org.eclipse.xtext.ui.XtextCallHierarchy'

	@Inject
	extension IGlobalServiceProvider

	@Inject
	EditorResourceAccess resourceAccess

	override protected getHierarchyViewPartID() {
		HIERARCHY_VIEW_PART_ID
	}

	override protected createHierarchyBuilder(EObject target) {
		val xtextCallHierarchyBuilder = target.findService(XtextCallHierarchyBuilder)
		xtextCallHierarchyBuilder.resourceAccess = resourceAccess
		xtextCallHierarchyBuilder.indexData = target.findService(IResourceDescriptions)

		val deferredHierarchyBuilder = target.findService(DeferredHierarchyBuilder)
		deferredHierarchyBuilder.hierarchyBuilder = xtextCallHierarchyBuilder
		return deferredHierarchyBuilder
	}

}
