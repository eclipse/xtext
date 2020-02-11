/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.internal.XtextPluginImages;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public abstract class AbstractIssueResolutionProviderAdapter {

	public static final String DEFAULT_IMAGE = "org.eclipse.xtext.ui.editor.quickfix.AbstractIssueResolutionProviderAdapter.DEFAULT_IMAGE"; 
	
	@Named(DEFAULT_IMAGE)
	@Inject(optional=true)
	private String defaultImage = XtextPluginImages.OBJ_CORRECTION_CHANGE;  

	@Inject 
	private IssueResolutionProvider resolutionProvider;

	@Inject
	private IImageHelper imageHelper;

	protected IssueResolutionProvider getResolutionProvider() {
		return resolutionProvider;
	}
	
	/**
	 * @deprecated use {@link IssueResolutionProvider#getResolutions(Issue)} instead. 
	 */
	@Deprecated
	public Iterable<IssueResolution> getResolutions(Issue issue, IXtextDocument document) {
		Iterable<IssueResolution> result = resolutionProvider.getResolutions(issue);
		return result;
	}

	public Image getImage(IssueResolution resolution) {
		if(Strings.isEmpty(resolution.getImage()))
			return XtextPluginImages.get(defaultImage);
		else
			return imageHelper.getImage(resolution.getImage());
	}


}
