/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.common.util.URI;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
public class FileSystemAccessRequest implements Runnable {
	private final URI uri;
	private final Runnable runMe;

	/**
	 * @since 2.9
	 */
	public FileSystemAccessRequest(URI uri, Runnable runMe) {
		this.uri = uri;
		this.runMe = runMe;
	}

	/**
	 * @since 2.8
	 */
	public URI getUri() {
		return uri;
	}

	/**
	 * @since 2.9
	 */
	@Override
	public void run() {
		runMe.run();
	}

	@Override
	public String toString() {
		return "FileSystemAccessRequest [uri=" + uri + "]";
	}
}
