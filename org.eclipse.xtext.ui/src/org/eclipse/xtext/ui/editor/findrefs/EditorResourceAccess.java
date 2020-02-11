/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public class EditorResourceAccess implements IReferenceFinder.ILocalResourceAccess {

	@Inject
	private LoadingResourceAccess delegate;

	@Inject
	private OpenDocumentTracker openDocumentTracker;
	
	@Override
	public <R> R readOnly(final URI targetURI, final IUnitOfWork<R, ResourceSet> work) {
		IXtextDocument document = openDocumentTracker.getOpenDocument(targetURI.trimFragment());
		if (document != null) {
			return document.tryReadOnly(new IUnitOfWork<R, XtextResource>() {
				@Override
				public R exec(XtextResource state) throws Exception {
					ResourceSet localContext = state.getResourceSet();
					if (localContext != null)
						return work.exec(localContext);
					return null;
				}
			}, () -> { return null; });
		} else {
			return delegate.readOnly(targetURI, work);
		}
	}

}
