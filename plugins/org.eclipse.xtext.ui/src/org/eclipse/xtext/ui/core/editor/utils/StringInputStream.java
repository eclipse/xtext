/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.utils;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class StringInputStream extends ByteArrayInputStream {

	private StringInputStream(byte[] buf) {
		super(buf);
	}

	public StringInputStream(String string, String encoding) throws UnsupportedEncodingException {
		this(string.getBytes());
	}

	public StringInputStream(String string) throws UnsupportedEncodingException {
		this(string, System.getProperty("file.encoding"));
	}

}
