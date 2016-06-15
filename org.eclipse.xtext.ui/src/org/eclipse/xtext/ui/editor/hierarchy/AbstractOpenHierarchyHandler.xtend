/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.ITextSelection
import org.eclipse.ui.IWorkbenchWindow
import org.eclipse.xtext.resource.EObjectAtOffsetHelper

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.ui.editor.utils.EditorUtils.*
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
abstract class AbstractOpenHierarchyHandler extends AbstractHandler {

	@Inject
	extension EObjectAtOffsetHelper

	override execute(ExecutionEvent event) throws ExecutionException {
		val editor = event.activeXtextEditor
		if (editor !== null) {
			val selection = editor.selectionProvider.selection
			if (selection instanceof ITextSelection) {
				val workbenchWindow = editor.site.workbenchWindow
				editor.document.priorityReadOnly [
					resolveElementAt(selection.offset).openHierarchy(workbenchWindow)
					null
				]
			}
		}
	}

	protected def void openHierarchy(EObject target, IWorkbenchWindow workbenchWindow) {
		val viewPart = workbenchWindow.activePage.showView(hierarchyViewPartID)
		if (viewPart instanceof AbstractHierarchyViewPart) {
			viewPart.builder = target.createHierarchyBuilder
			viewPart.rootURI = target.platformResourceOrNormalizedURI
			viewPart.refresh(null)
		}
	}

	protected def String getHierarchyViewPartID();

	protected def IHierarchyBuilder createHierarchyBuilder(EObject target)

}
