/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProviderFactory;
import org.eclipse.xtext.ui.service.IQuickFixGenerator;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextMarkerResolutionGenerator implements IMarkerResolutionGenerator2 {
	private XtextDocumentProvider documentProvider;
	private IQuickFixGenerator qfService;

	@Inject
	public void setServiceScope(IServiceScope scope) {
		documentProvider = XtextDocumentProviderFactory.getInstance().getDocumentProvider(scope);
		qfService = ServiceRegistry.getService(scope, IQuickFixGenerator.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.
	 * core.resources.IMarker)
	 */
	public IMarkerResolution[] getResolutions(final IMarker marker) {
		if (qfService != null)
			return qfService.getQuickFixes(marker, documentProvider);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse
	 * .core.resources.IMarker)
	 */
	public boolean hasResolutions(IMarker marker) {
		if (qfService != null)
			return qfService.hasQuickFixes(marker, documentProvider);
		return false;
	}

}
