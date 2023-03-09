/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.URI;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@ImplementedBy(IFileSystemScanner.JavaIoFileSystemScanner.class)
public interface IFileSystemScanner {
	public static class JavaIoFileSystemScanner implements IFileSystemScanner {
		@Inject
		private UriExtensions uriExtensions;

		@Override
		public void scan(URI root, IAcceptor<URI> acceptor) {
			File file = new File(root.toFileString());
			scanRec(file, acceptor);
		}

		public void scanRec(File file, IAcceptor<URI> acceptor) {
			// we need to convert the given file to a decoded emf file uri
			// e.g. file:///Users/x/y/z
			// or file:///C:/x/y/z
			Path path = Paths.get(file.getAbsoluteFile().toURI());
			URI uri = uriExtensions.toEmfUri(path.toUri());
			acceptor.accept(uri);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				if (files != null) {
					for (File f : files) {
						scanRec(f, acceptor);
					}
				}
			}
		}
	}

	void scan(URI root, IAcceptor<URI> acceptor);
}
