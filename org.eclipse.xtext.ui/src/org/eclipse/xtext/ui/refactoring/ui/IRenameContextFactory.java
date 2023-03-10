/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * Creates the context of a refactoring.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IRenameContextFactory.Default.class)
public interface IRenameContextFactory {

	IRenameElementContext createRenameElementContext(EObject targetElement, XtextEditor triggeringEditor,
			ITextSelection selection, XtextResource triggeringResource);

	static class Default implements IRenameContextFactory {

		@Inject
		private IGlobalServiceProvider globalServiceProvider;

		@Inject
		private IResourceServiceProvider resourceServiceProvider;

		@Override
		public IRenameElementContext createRenameElementContext(EObject targetElement, final XtextEditor editor,
				final ITextSelection selection, XtextResource resource) {
			if(!resourceServiceProvider.canHandle(EcoreUtil2.getPlatformResourceOrNormalizedURI(targetElement))) {
				IRenameElementContext externalRenameElementContext = createExternalRenameElementContext(targetElement,
					editor, selection, resource);
				if (externalRenameElementContext != null)
					return externalRenameElementContext;
			}
			return createLocalRenameElementContext(targetElement, editor, selection, resource);
		}

		protected IRenameElementContext createExternalRenameElementContext(EObject targetElement, XtextEditor editor,
				ITextSelection selection, XtextResource resource) {
			if (!resourceServiceProvider.canHandle(EcoreUtil2.getPlatformResourceOrNormalizedURI(targetElement))) {
				IRenameContextFactory contextFactory = globalServiceProvider.findService(targetElement,
						IRenameContextFactory.class);
				if (contextFactory != null)
					return contextFactory.createRenameElementContext(targetElement, editor, selection, resource);
			}
			return null;
		}

		protected IRenameElementContext createLocalRenameElementContext(EObject targetElement, XtextEditor editor,
				ITextSelection selection, XtextResource resource) {
			final URI targetElementURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(targetElement);
			IRenameElementContext.Impl renameElementContext = new IRenameElementContext.Impl(targetElementURI,
					targetElement.eClass(), editor, selection, resource.getURI());
			return renameElementContext;
		}
	}

}
