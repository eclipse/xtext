/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.navigation

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.jface.util.OpenStrategy
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.OpenEvent
import org.eclipse.jface.viewers.StructuredViewer
import org.eclipse.ui.OpenAndLinkWithEditorHelper
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.ui.editor.IURIEditorOpener
import org.eclipse.xtext.ide.editor.navigation.INavigatable

/**
 * @since 2.10
 * 
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class NavigationService {

	@Inject
	IURIEditorOpener uriEditorOpener

	def void open(OpenEvent openEvent) {
		open(openEvent, true)
	}

	def void open(OpenEvent openEvent, boolean select) {
		val selection = openEvent.selection
		if (selection instanceof IStructuredSelection) {
			for (navigatable : selection.iterator.toIterable.filter(INavigatable)) {
				open(navigatable, select)
			}
		}
	}

	def void open(INavigatable navigatable) {
		open(navigatable, true)
	}

	def void open(INavigatable navigatable, boolean select) {
		switch navigatableElement : navigatable?.navigationElement {
			IReferenceDescription:
				uriEditorOpener.open(
					navigatableElement.sourceEObjectUri,
					navigatableElement.EReference,
					navigatableElement.indexInList,
					select
				)
			IEObjectDescription:
				uriEditorOpener.open(navigatableElement.EObjectURI, select)
			IResourceDescription:
				uriEditorOpener.open(navigatableElement.URI, select)
			INavigatable:
				open(navigatableElement, select)
		}
	}
	
	def installNavigationSupport(StructuredViewer viewer) {
		installNavigationSupport(viewer, true)
	}
	
	def installNavigationSupport(StructuredViewer viewer, boolean select) {
		installNavigationSupport(viewer) [ open(select) ]
	}

	def installNavigationSupport(StructuredViewer viewer, (OpenEvent)=>void opener) {
		return new OpenAndLinkWithEditorHelper(viewer) {

			override protected activate(ISelection selection) {
				val int currentMode = OpenStrategy.getOpenMethod()
				try {
					OpenStrategy.setOpenMethod(OpenStrategy.DOUBLE_CLICK)
					opener.apply(new OpenEvent(viewer, selection))
				} finally {
					OpenStrategy.setOpenMethod(currentMode)
				}
			}

			override protected linkToEditor(ISelection selection) {}

			override protected open(ISelection selection, boolean activate) {
				opener.apply(new OpenEvent(viewer, selection))
			}

		}
	}

}
