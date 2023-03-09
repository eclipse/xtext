/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.nio.charset.Charset;

import org.eclipse.emf.common.util.URI;

import com.google.inject.Singleton;

/**
 * Provides the file encoding for a language.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IEncodingProvider {

	/**
	 * Returns the encoding that should be used to read a resource
	 * from the given uri.
	 * If the uri is <code>null</code>, the default encoding for the language
	 * is returned.
	 * 
	 * At runtime, the default encoding was either configured externally or
	 * it is obtained from the class {@link Charset#defaultCharset() Charset}.
	 * In the UI environment, the encoding should usually be read from the workspace
	 * metadata.  
	 * 
	 * @param uri the uri of the specific resource or <code>null</code> to obtain the default encoding.
	 */
	String getEncoding(URI uri);

	@Singleton
	class Runtime implements IEncodingProvider {

		private String defaultEncoding = null;

		@Override
		public String getEncoding(URI uri) {
			if (defaultEncoding != null)
				return defaultEncoding;
			return Charset.defaultCharset().name();
		}

		/**
		 * @since 2.4
		 */
		public String getDefaultEncoding() {
			return defaultEncoding;
		}

		/**
		 * @since 2.4
		 */
		public void setDefaultEncoding(String defaultEncoding) {
			this.defaultEncoding = defaultEncoding;
		}

	}

}
