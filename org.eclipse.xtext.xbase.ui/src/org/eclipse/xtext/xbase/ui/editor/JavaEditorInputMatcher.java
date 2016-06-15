/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.common.types.ui.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ILocationInEclipseResource;
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
	private ITraceForTypeRootProvider traceInformation;
	
	@Inject
	private XtextEditorInfo editorInfo;
	
	@Inject
	private StacktraceBasedEditorDecider decisions;
	
	@Inject
	private XbaseEditorInputRedirector editorInputRedirector;
	
	@Override
	public boolean matches(IEditorReference editorRef, IEditorInput inputToCheck) {
		try {
			if (!editorInfo.getEditorId().equals(editorRef.getId())) {
				return false;
			}
			IEditorInput newInput = editorInputRedirector.findOriginalSourceForOuputFolderCopy(inputToCheck);
			IEditorInput currentInput = editorRef.getEditorInput();
			if (newInput.equals(currentInput)) {
				if (decisions.decideAccordingToCaller() != Decision.FORCE_JAVA) {
					ITypeRoot newTypeRoot = editorInputRedirector.getTypeRoot(newInput);
					if (newTypeRoot != null) {
						IEditorPart existingEditor = editorRef.getEditor(true);
						if (existingEditor instanceof XbaseEditor) {
							((XbaseEditor)existingEditor).markNextSelectionAsJavaOffset(newTypeRoot);
						}
					}
				}
				return true;
			}
			if (decisions.decideAccordingToCaller() == Decision.FORCE_JAVA)
				return false;
			ITypeRoot newTypeRoot = editorInputRedirector.getTypeRoot(newInput);
			if (newTypeRoot == null) {
				return false;
			}
			IResource currentResource = ResourceUtil.getResource(currentInput);
			if (currentResource == null) {
				return false;
			}
			IEclipseTrace traceToSource = traceInformation.getTraceToSource(newTypeRoot);
			if (traceToSource == null) {
				return false;
			}
			if (isCurrentResource(currentResource, traceToSource)) {
				IEditorPart existingEditor = editorRef.getEditor(true);
				if (existingEditor instanceof XbaseEditor) {
					((XbaseEditor)existingEditor).markNextSelectionAsJavaOffset(newTypeRoot);
					return true;
				}
			}
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	protected boolean isCurrentResource(IResource currentResource, IEclipseTrace traceToSource) {
		Iterator<? extends ILocationInEclipseResource> iterator = traceToSource.getAllAssociatedLocations().iterator();
		if (!iterator.hasNext()) {
			return false;
		}
		IStorage storage = iterator.next().getPlatformResource();
		return currentResource.equals(storage);
	}

}
