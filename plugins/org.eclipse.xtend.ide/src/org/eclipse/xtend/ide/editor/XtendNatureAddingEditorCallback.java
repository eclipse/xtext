/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.nature.ToggleXtextNatureAction;
import org.eclipse.xtext.ui.editor.AbstractDirtyStateAwareEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.UriValidator;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendNatureAddingEditorCallback extends AbstractDirtyStateAwareEditorCallback {
	
	@Inject
	private IStorage2UriMapper mapper;
	
	@Inject
	private UriValidator uriValidator;

	@Inject
	private ToggleXtextNatureAction toggleNature;

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		super.afterCreatePartControl(editor);
		IResource resource = editor.getResource();
		if (resource!=null && !toggleNature.hasNature(resource.getProject()) 
				&& resource.getProject().isAccessible() && !resource.getProject().isHidden() && canBuild(editor)) {
			toggleNature.toggleNature(resource.getProject());
		}
	}

	private boolean canBuild(XtextEditor editor) {
		IResource resource = editor.getResource();
		if (!(resource instanceof IStorage)) {
			return false;
		}
		IStorage storage = (IStorage) resource;
		URI uri = mapper.getUri(storage);
		return uriValidator.canBuild(uri, storage);
	}

}
