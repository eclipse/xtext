/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
