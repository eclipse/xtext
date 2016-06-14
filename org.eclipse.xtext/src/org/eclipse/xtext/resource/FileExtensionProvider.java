/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Set;

import org.eclipse.xtext.Constants;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class FileExtensionProvider {

	private Set<String> fileExtensions;
	
	@Inject
	protected void setExtensions(@Named(Constants.FILE_EXTENSIONS)String extensions) {
		String[] split = extensions.split(",");
		this.fileExtensions = Sets.newLinkedHashSet();
		for (String string : split) {
			this.fileExtensions.add(string);
		}
	}
	
	public Set<String> getFileExtensions() {
		return fileExtensions;
	}
	
	public String getPrimaryFileExtension() {
		return fileExtensions.iterator().next();
	}

	public boolean isValid(String fileExtension) {
		return fileExtensions.contains(fileExtension);
	}
}
