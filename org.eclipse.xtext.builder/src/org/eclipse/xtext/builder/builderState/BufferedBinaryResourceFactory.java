/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * Use only with EMF 2.5!
 * 
 * Creates a binary resource that is buffered for better performance. Since EMF 2.6 buffering has been integrated into
 * the BinaryResourceImpl.
 * This class also contains a bugfix that will only work for 2.5 and break the 2.6 implementation.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class BufferedBinaryResourceFactory extends ResourceFactoryImpl {
	@Override
	public Resource createResource(URI uri) {
		BinaryResourceImpl binaryResource = new BinaryResourceImpl(uri) {
			@Override
			protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192 * 2 * 2 * 2);
				try {
					super.doSave(bufferedOutputStream, options);
				} finally {
					bufferedOutputStream.close();
				}
			}

			@Override
			protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
				InputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192 * 2 * 2 * 2);
				try {
					EObjectInputStream eObjectInputStream = new EObjectInputStream(bufferedInputStream, options) {
						/**
						 * Bugfix. Will break EMF 2.6 or higher
						 */
						@Override
						public String readString() throws IOException {
							int length = readCompressedInt();
							if (length == -1) {
								return null;
							} else {
								if (characters == null || characters.length < length) {
									characters = new char[length];
								}
								LOOP: for (int i = 0; i < length; ++i) {
									byte value = readByte();
									if (value == 0) {
										do {
											characters[i] = readChar();
										} while (++i < length);
										break LOOP;
									} else {
										// bugfix for characters > 127
										characters[i] = (char) (value & 0xFF);
									}
								}
								return new String(characters, 0, length);
							}
						}
					};
					eObjectInputStream.loadResource(this);
				} finally {
					bufferedInputStream.close();
				}
			}
		};
		return binaryResource;
	}

}