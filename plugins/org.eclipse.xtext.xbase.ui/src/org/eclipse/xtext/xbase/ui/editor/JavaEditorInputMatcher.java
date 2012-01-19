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
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.inject.Inject;

/**
 * This strategy matches existing Xbase editors to Java editor input.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaEditorInputMatcher implements IEditorMatchingStrategy {

	private static final Logger logger = Logger.getLogger(JavaEditorInputMatcher.class);
	
	@Inject
	private IDerivedResourceMarkers derivedResourceMarkers;

	@Inject
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject
	private XtextEditorInfo editorInfo;
	
	public boolean matches(IEditorReference editorRef, IEditorInput newInput) {
		try {
			if (!editorInfo.getEditorId().equals(editorRef.getId())) {
				return false;
			}
			IEditorInput currentInput = editorRef.getEditorInput();
			if (newInput.equals(currentInput)) {
				return true;
			}
			IResource currentResource = ResourceUtil.getResource(currentInput);
			IResource newResource = ResourceUtil.getResource(newInput);
			if (newResource instanceof IFile) {
				IMarker[] markers = derivedResourceMarkers.findDerivedResourceMarkers((IFile) newResource);
				if (markers.length != 1) {
					return false;
				}
				IMarker marker = markers[0];
				String source = derivedResourceMarkers.getSource(marker);
				if (source != null) {
					URI sourceResourceURI = URI.createURI(source).trimFragment();
					Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(sourceResourceURI);
					for(Pair<IStorage, IProject> storage: storages) {
						if (currentResource.equals(storage.getFirst())) {
							IEditorPart existingEditor = editorRef.getEditor(false);
							if (existingEditor instanceof XbaseEditor) {
								((XbaseEditor)existingEditor).markNextSelectionAsJavaOffset(newResource);
							}
							return true;
						}
					}
				}
			}
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

}
