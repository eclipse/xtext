/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.nio.charset.Charset;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * Provides the default file encoding for a language.
 * 
 * @author koehnlein - Initial contribution and API
 */
@ImplementedBy(IDefaultEncodingProvider.Runtime.class)
public interface IDefaultEncodingProvider {

	String getEncoding();

	@Singleton
	public class Runtime implements IDefaultEncodingProvider {

		public String getEncoding() {
			return Charset.defaultCharset().name();
		}

	}

}
