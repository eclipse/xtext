/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.trace;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FolderAwareTrace extends AbstractTraceWithoutStorage {

	private String folder;

	public void setRootFolder(String folder) {
		if (!folder.endsWith("/"))
			folder = folder + "/";
		this.folder = folder;
	}

	protected File findFile(File container, String candiadate) {
		File[] files = container.listFiles();
		if (files != null) {
			for (File child : files) {
				if (child.isFile()) {
					if (child.getAbsolutePath().replace("\\", "/").endsWith(candiadate))
						return child;
				} else if (child.isDirectory()) {
					File result = findFile(child, candiadate);
					if (result != null)
						return result;
				}
			}
		}
		return null;
	}

	@Override
	public InputStream getContents(SourceRelativeURI uri, IProject project) throws IOException {
		File container = new File(folder);
		if (!container.exists())
			return null;
		File file = findFile(container, uri.getURI().toString());
		if (file == null)
			return null;
		return new FileInputStream(file);
	}

	@Override
	protected Reader getContentsAsText(SourceRelativeURI uri, IProject project) throws IOException {
		InputStream contents = getContents(uri, project);
		return new InputStreamReader(contents, getEncoding());
	}
}
