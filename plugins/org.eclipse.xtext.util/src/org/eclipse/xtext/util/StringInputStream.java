/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Dennis Hübner - Initial contribution and API
 * @author Jan Koehnlein
 */
public class StringInputStream extends ByteArrayInputStream {

	public StringInputStream(String string) {
		super(string.getBytes());
	}
	
	public StringInputStream(String content, String encoding) throws UnsupportedEncodingException {
		super(content.getBytes(encoding));
	}

}
