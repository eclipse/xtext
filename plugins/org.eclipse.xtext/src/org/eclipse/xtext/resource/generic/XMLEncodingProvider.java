/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.generic;

import static com.google.common.collect.Maps.*;

import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.impl.XMLHandler;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XMLEncodingProvider implements IEncodingProvider {

	private static final int BUFFER_SIZE = 512;
	
	private static final Logger LOG = Logger.getLogger(XMLEncodingProvider.class);

	@Override
	public String getEncoding(URI uri) {
		if (uri == null) {
			return Charset.defaultCharset().name();
		}
		try {
			if(!URIConverter.INSTANCE.exists(uri, newHashMap())) {
				// TODO move up to first if in v2.10
				return Charset.defaultCharset().name();
			}
			byte[] buffer = null;
			InputStream inputStream = URIConverter.INSTANCE.createInputStream(uri);
			// Adopted from XMLLoadImpl
			try {
				if (inputStream.available() == 0) {
					buffer = new byte[0];
				} else {
					buffer = new byte[BUFFER_SIZE];
					int bytesRead = inputStream.read(buffer, 0, BUFFER_SIZE);
					int totalBytesRead = bytesRead;
					while (bytesRead != -1 && (totalBytesRead < BUFFER_SIZE)) {
						bytesRead = inputStream.read(buffer, totalBytesRead, BUFFER_SIZE - totalBytesRead);
						if (bytesRead != -1)
							totalBytesRead += bytesRead;
					}
					if (totalBytesRead < 0) {
						buffer = new byte[0];
					} else if (totalBytesRead < BUFFER_SIZE) {
						byte[] smallerBuffer = new byte[totalBytesRead];
						System.arraycopy(buffer, 0, smallerBuffer, 0, totalBytesRead);
						buffer = smallerBuffer;
					}
				}
			} finally {
				inputStream.close();
			}
			String result = XMLHandler.getXMLEncoding(buffer);
			if (result == null)
				return Charset.defaultCharset().name();
			return result;
		} catch (Exception e) {
			LOG.error("Error detecting encoding for " + Strings.notNull(uri), e);
			return Charset.defaultCharset().name();
		}
	}
}
