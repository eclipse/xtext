/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.label;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IStorageEditorInput;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultEditorInputLabelProvider extends DeclarativeLabelProvider {

	private static final Logger LOG = Logger.getLogger(DefaultEditorInputLabelProvider.class);

	@Inject 
	private DefaultEditorImageUtil imageUtil;
	
	public String text(IStorageEditorInput editorInput) {
		try {
			return editorInput.getStorage().getFullPath().lastSegment();
		} catch (CoreException e) {
			LOG.error("Error resolving IStorage from IStorageEditorInput", e);
		}
		return null;
	}

	public String text(URIEditorInput editorInput) {
		return editorInput.getURI().lastSegment();
	}

	public ImageDescriptor image(IStorageEditorInput editorInput) {
		return imageUtil.getDefaultEditorImageDescriptor(text(editorInput));
	}

	public ImageDescriptor image(URIEditorInput editorInput) {
		return imageUtil.getDefaultEditorImageDescriptor(text(editorInput));
	}

}
