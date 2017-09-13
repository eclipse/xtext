/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Singleton
import java.util.regex.Pattern
import org.eclipse.emf.common.util.URI

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class UriExtensions {

	/**
	 * Pattern for the {@code file:/} scheme. 
	 */
	static val FILE_SCHEME_1_PATTERN = Pattern.compile('^file:\\/[^\\/].*');
	
	/**
	 * Pattern for the {@code file://} scheme. 
	 */
	static val FILE_SCHEME_2_PATTERN = Pattern.compile('^file:\\/\\/[^\\/].*');

	/**
	 * Converts a URI (given as a string) into an EMF URI.
	 * 
	 * <p>
	 * If the argument URI has a {@code file} scheme, it makes sure that the {@code file} scheme
	 * is followed by three forward-slashes. Leaves other schemes untouched. 
	 */
	def URI toUri(String pathWithScheme) {
		return URI.createURI(pathWithScheme.adjustURI);
	}

	/**
	 * Converts the EMF URI argument into a string path.
	 */
	def String toPath(URI uri) {
		return uri.toString.adjustURI;
	}

	/**
	 * Converts the {@code java.net} URI argument into a string path.
	 */
	def String toPath(java.net.URI uri) {
		return URI.createURI(uri.toString).toPath;
	}

	/**
	 * Ensures that the {@code file} URI scheme is followed by three (forward) slashes.
	 * Returns with the argument if the URI does not start with a {@code file} scheme. 
	 */
	private def adjustURI(String uri) {
		return if (FILE_SCHEME_1_PATTERN.matcher(uri).matches) {
			uri.replaceFirst('file:/', 'file:///');
		} else if (FILE_SCHEME_2_PATTERN.matcher(uri).matches) {
			uri.replaceFirst('file://', 'file:///');
		} else {
			uri;
		}
	}

}
