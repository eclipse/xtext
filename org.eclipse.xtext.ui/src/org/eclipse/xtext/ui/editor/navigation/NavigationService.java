/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.navigation;

import java.util.Iterator;

import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.OpenAndLinkWithEditorHelper;
import org.eclipse.xtext.ide.editor.navigation.INavigatable;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @since 2.10
 * 
 * @author kosyakov - Initial contribution and API
 */
@Singleton
public class NavigationService {

	@Inject
	private IURIEditorOpener uriEditorOpener;

	public void open(OpenEvent openEvent) {
		open(openEvent, true);
	}

	public void open(OpenEvent openEvent, boolean select) {
		ISelection selection = openEvent.getSelection();
		if (selection instanceof IStructuredSelection) {
			Iterator<?> iterator = ((IStructuredSelection) selection).iterator();
			while (iterator.hasNext()) {
				Object element = iterator.next();
				if (element instanceof INavigatable) {
					open((INavigatable) element, select);
				}
			}
		}
	}

	public void open(INavigatable navigatable) {
		open(navigatable, true);
	}

	public void open(INavigatable navigatable, boolean select) {
		if (navigatable != null) {
			Object navigatableElement = navigatable.getNavigationElement();
			if (navigatableElement instanceof IReferenceDescription) {
				IReferenceDescription referenceDescription = (IReferenceDescription) navigatableElement;
				uriEditorOpener.open(referenceDescription.getSourceEObjectUri(), //
						referenceDescription.getEReference(), //
						referenceDescription.getIndexInList(), //
						select);
			} else if (navigatableElement instanceof IEObjectDescription) {
				uriEditorOpener.open(((IEObjectDescription) navigatableElement).getEObjectURI(), select);
			} else if (navigatableElement instanceof IResourceDescription) {
				uriEditorOpener.open(((IResourceDescription) navigatableElement).getURI(), select);
			} else if (navigatableElement instanceof INavigatable) {
				open((INavigatable) navigatableElement, select);
			}
		}
	}

	public OpenAndLinkWithEditorHelper installNavigationSupport(StructuredViewer viewer) {
		return installNavigationSupport(viewer, true);
	}

	public OpenAndLinkWithEditorHelper installNavigationSupport(StructuredViewer viewer, boolean select) {
		return installNavigationSupport(viewer, (OpenEvent openEvent) -> open(openEvent, select));
	}

	public OpenAndLinkWithEditorHelper installNavigationSupport(StructuredViewer viewer, Procedure1<? super OpenEvent> opener) {
		return new OpenAndLinkWithEditorHelper(viewer) {

			@Override
			protected void activate(ISelection selection) {
				int currentMode = OpenStrategy.getOpenMethod();
				try {
					OpenStrategy.setOpenMethod(OpenStrategy.DOUBLE_CLICK);
					opener.apply(new OpenEvent(viewer, selection));
				} finally {
					OpenStrategy.setOpenMethod(currentMode);
				}
			}

			@Override
			protected void open(ISelection selection, boolean activate) {
				opener.apply(new OpenEvent(viewer, selection));
			}

			@Override
			protected void linkToEditor(ISelection selection) {
			}
		};
	}
}
