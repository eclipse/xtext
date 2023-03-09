/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.incremental.BinaryFileHashing;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess.IFileCallback;

import com.google.common.hash.HashCode;

public class StandaloneBuilderFileCallback implements IFileCallback {
	private final List<IPath> generatedFiles;
	private final URI resourceURI;
	private final Map<IPath, HashCode> genFiles;
	private final Map<URI, IPath[]> inputToGenFiles;
	private final Map<IPath, URI> genFileToInput;

	protected StandaloneBuilderFileCallback(URI resourceURI, Map<IPath, HashCode> genFiles, Map<URI, IPath[]> inputToGenFiles, Map<IPath, URI> genFileToInput) {
		this.generatedFiles = new ArrayList<>();
		this.resourceURI = resourceURI;
		this.inputToGenFiles = inputToGenFiles;
		this.genFiles = genFiles;
		this.genFileToInput = genFileToInput;
	}

	@Override
	public void fileDeleted(File file) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void fileAdded(File file) {
		generatedFiles.add(new Path(file.getAbsolutePath()));
	}

	protected void done() {
		IPath[] prev = inputToGenFiles.remove(resourceURI);
		if (!generatedFiles.isEmpty()) {
			inputToGenFiles.put(resourceURI, generatedFiles.toArray(new IPath[0]));
			for(IPath generatedFile: generatedFiles) {
				BinaryFileHashing.processFile(generatedFile.toFile(), genFiles::put);
				genFileToInput.put(generatedFile, resourceURI);
			}
		}
		if (prev != null) {
			for(IPath prevPath: prev) {
				if (!generatedFiles.contains(prevPath)) {
					if (resourceURI.equals(genFileToInput.get(prevPath))) {
						prevPath.toFile().delete();
						genFileToInput.remove(prevPath);
						genFiles.remove(prevPath);
					}
				}
			}
		}
	}
}