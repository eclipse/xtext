/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.nio.charset.Charset;

import org.eclipse.emf.common.util.URI;

import com.google.inject.Singleton;

/**
 * Provides the default file encoding for a language.
 * 
 * @author koehnlein - Initial contribution and API
 */
public interface IEncodingProvider {

	String getEncoding(URI uri);

	@Singleton
	class Runtime implements IEncodingProvider {

		public String getEncoding(URI uri) {
			return Charset.defaultCharset().name();
		}

	}
	
}
