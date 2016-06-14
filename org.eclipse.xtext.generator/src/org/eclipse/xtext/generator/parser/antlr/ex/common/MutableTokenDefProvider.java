/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.common;

import java.nio.charset.Charset;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MutableTokenDefProvider extends org.eclipse.xtext.xtext.generator.parser.antlr.MutableTokenDefProvider {

	/**
	 * @since 2.7
	 */
	public MutableTokenDefProvider(KeywordHelper keywordHelper, Charset encoding) {
		super(keywordHelper, encoding);
	}
	
	/**
	 * @deprecated use {@link #MutableTokenDefProvider(KeywordHelper, Charset)} instead.
	 */
	@Deprecated
	public MutableTokenDefProvider() {
		this(null, Charset.defaultCharset());
	}
}
