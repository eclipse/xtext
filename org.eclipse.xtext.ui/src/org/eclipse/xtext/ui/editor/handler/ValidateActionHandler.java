/*******************************************************************************
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.editor.validation.MarkerIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Michael Clay
 * @author Peter Friese
 */
public class ValidateActionHandler extends AbstractHandler {
	@Inject
	private IResourceValidator resourceValidator;
	@Inject 
	private MarkerCreator markerCreator;
	@Inject
	private MarkerTypeProvider markerTypeProvider;
	@Inject
	private IssueResolutionProvider issueResolutionProvider;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (xtextEditor != null) {
			IXtextDocument xtextDocument = xtextEditor.getDocument();
			IResource resource = xtextEditor.getResource();
			if(resource != null) {
				IValidationIssueProcessor issueProcessor = new MarkerIssueProcessor(resource, xtextEditor.getInternalSourceViewer().getAnnotationModel(), markerCreator, markerTypeProvider);
				IValidationIssueProcessor issueProcessorFastIssues = new AnnotationIssueProcessor(xtextDocument, xtextEditor.getInternalSourceViewer().getAnnotationModel(), issueResolutionProvider);
				ValidationJob validationJob = new ValidationJob(resourceValidator, xtextDocument, new IValidationIssueProcessor() {
					
					@Override
					public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
						List<Issue> fast = new ArrayList<Issue>();
						for (Issue i : issues) {
							if (CheckType.FAST == i.getType()) {
								fast.add(i);
							}
						}
						SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
						issueProcessor.processIssues(issues, subMonitor.split(1));
						issueProcessorFastIssues.processIssues(fast, subMonitor.split(1));
					}
				},
						CheckMode.ALL);
				validationJob.schedule();
			} else {
				IValidationIssueProcessor issueProcessor = new AnnotationIssueProcessor(xtextDocument, xtextEditor.getInternalSourceViewer().getAnnotationModel(), issueResolutionProvider);
				ValidationJob validationJob = new ValidationJob(resourceValidator, xtextDocument, issueProcessor,
						CheckMode.ALL);
				validationJob.schedule();
			}
		}
		return this;
	}

}
