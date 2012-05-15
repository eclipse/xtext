/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.xbase.ui.editor.StacktraceBasedEditorDecider.Decision;

import com.google.inject.Inject;

/**
 * This strategy matches existing Xbase editors to Java editor input.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaEditorInputMatcher implements IEditorMatchingStrategy {

	private static final Logger logger = Logger.getLogger(JavaEditorInputMatcher.class);
	
	@Inject
	private ITraceInformation traceInformation;
	
	@Inject
	private XtextEditorInfo editorInfo;
	
	@Inject
	private StacktraceBasedEditorDecider decisions;
	
	public boolean matches(IEditorReference editorRef, IEditorInput newInput) {
		try {
			if (!editorInfo.getEditorId().equals(editorRef.getId())) {
				return false;
			}
			IEditorInput currentInput = editorRef.getEditorInput();
			if (newInput.equals(currentInput)) {
				return true;
			}
			if (decisions.decideAccordingToCaller() == Decision.FORCE_JAVA)
				return false;
			IFile newResource = ResourceUtil.getFile(newInput);
			if (newResource == null) {
				return false;
			}
			IResource currentResource = ResourceUtil.getResource(currentInput);
			ITrace traceToSource = traceInformation.getTraceToSource(newResource);
			if (traceToSource == null) {
				return false;
			}
			Iterable<ILocationInResource> allLocations = traceToSource.getAllAssociatedLocations();
			boolean thisIsTheOnlyOne = false;
			for(ILocationInResource location: allLocations) {
				// more than one source found - this is unlikely to be the correct editor
				if (!currentResource.equals(location.getStorage())) {
					return false;
				}
				thisIsTheOnlyOne = true;
			}
			if (thisIsTheOnlyOne) {
				IEditorPart existingEditor = editorRef.getEditor(true);
				if (existingEditor instanceof XbaseEditor) {
					((XbaseEditor)existingEditor).markNextSelectionAsJavaOffset(newResource);
					return true;
				}
			}
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

}
