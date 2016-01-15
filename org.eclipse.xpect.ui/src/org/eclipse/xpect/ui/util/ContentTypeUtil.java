/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.ui.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xpect.XpectConstants;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContentTypeUtil {

	private static Logger LOG = Logger.getLogger(ContentTypeUtil.class);

	private static final String XPECT_SETUP = "XPECT_SETUP";

	public enum XpectContentType {
		BINARY, TEXT, XPECT
	}

	public XpectContentType getContentType(IFile file) {
		if (file == null || !file.exists())
			return XpectContentType.BINARY;
		if (XpectConstants.XT_FILE_EXT.equals(file.getFileExtension()))
			return XpectContentType.XPECT;
		Reader contents = null;
		try {
			contents = new InputStreamReader(file.getContents(), file.getCharset());
			char[] buf = new char[1024];
			int len = contents.read(buf);
			for (int i = 0; i < len; i++) {
				char c = buf[i];
				if (c < ' ' && c != '\n' && c != '\r' && c != '\t')
					return XpectContentType.BINARY;
			}
			String stringBuf = new String(buf);
			int index = stringBuf.indexOf(XPECT_SETUP);
			if (index >= 0 && index < stringBuf.length() + XPECT_SETUP.length()) {
				if (Character.isWhitespace(stringBuf.charAt(index + XPECT_SETUP.length())))
					return XpectContentType.XPECT;
			}
			return XpectContentType.TEXT;
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
			return XpectContentType.BINARY;
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			return XpectContentType.BINARY;
		} finally {
			if (contents != null)
				try {
					contents.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		}

	}
}
