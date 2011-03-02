/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EclipseResourceFileSystemAccess extends AbstractFileSystemAccess {

	@Inject
	private IWorkspaceRoot root;

	public void setRoot(IWorkspaceRoot root) {
		this.root = root;
	}

	public void generateFile(String fileName, String slot, CharSequence contents) {
		String outletPath = getPathes().get(slot);
		IFile file = root.getFile(new Path(outletPath + "/" + fileName));
		try {
			final String defaultCharset = file.getCharset();
			if (file.exists())
				file.setContents(new StringInputStream(contents.toString(), defaultCharset), true, true, null);
			else
				file.create(new StringInputStream(contents.toString(), defaultCharset), true, null);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

}
