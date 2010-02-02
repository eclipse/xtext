/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.core.resources.IResource;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LanguageResourceHelper implements ILanguageResourceHelper {
	
	@Inject
	@Named("file.extensions")
	private String fileExtensions;

	public String[] getFileExtensions() {
		return fileExtensions.split(",");
	}
	
	public boolean isLanguageResource(IResource resource) {
		String fileExtension = resource.getFullPath().getFileExtension();
		for (String ext : getFileExtensions()) {
			if (ext.equals(fileExtension))
				return true;
		}
		return false;
	}
}