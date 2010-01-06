/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model.edit;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.IImageHelper;
import org.eclipse.xtext.ui.core.MarkerUtil;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.internal.XtextPluginImages;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.IssueResolution;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public final class IssueUtil {
	
	public static final Iterable<IssueResolution> getDocumentAwareResolutions(final IXtextDocument document, final IDocumentEditor documentEditor, Iterable<IssueResolution> resolutions) {
		return Iterables.transform(resolutions, new Function<IssueResolution, IssueResolution>() {

			public IssueResolution apply(final IssueResolution delegate) {
				return new IssueResolution() {
					
					public void run() {
						IUnitOfWork<Object, XtextResource> uow = new IUnitOfWork.Void<XtextResource>() {
							@Override
							public void process(XtextResource state) throws Exception {
								delegate.run();
							}
						};
						
						documentEditor.process(uow, document);
					}
					
					public String getLabel() {
						return delegate.getLabel();
					}
					
					public String getDescription() {
						return delegate.getDescription();
					}
					
					public String getImage() {
						return delegate.getImage();
					}
				};
			}
		});
	}

	public static Issue createIssue(IMarker marker) {
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setMessage(MarkerUtilities.getMessage(marker));
		
		issue.setLineNumber(MarkerUtilities.getLineNumber(marker) - 1);
		issue.setOffset(MarkerUtilities.getCharStart(marker));
		issue.setLength(MarkerUtilities.getCharEnd(marker)-MarkerUtilities.getCharStart(marker));
		
		issue.setCode(MarkerUtil.getCode(marker));
		issue.setUriToProblem(MarkerUtil.getUriToProblem(marker));
		issue.setSeverity(MarkerUtil.getSeverity(marker));
		
		// Note, isSyntaxError is unset, but currently the api does not allow fixing
		// syntax errors anyway.
		return issue;
	}

	public static final Image getImage(IssueResolution resolution, IImageHelper imageHelper) {
		if(Strings.isEmpty(resolution.getImage()))
			return XtextPluginImages.get(XtextPluginImages.OBJ_CORRECTION_CHANGE);
		else
			return imageHelper.getImage(resolution.getImage());
	}



}
