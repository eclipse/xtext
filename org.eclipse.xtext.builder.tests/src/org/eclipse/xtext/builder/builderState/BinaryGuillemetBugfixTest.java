/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class BinaryGuillemetBugfixTest extends Assert {

	@Test public void testEncodeGuillemet() throws IOException {
		String s = "«";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new BinaryResourceImpl.EObjectOutputStream(out, null).writeString(s);
		byte[] byteArray = out.toByteArray();
		ByteArrayInputStream in = new ByteArrayInputStream(byteArray);
		String newS = new BinaryResourceImpl.EObjectInputStream(in, null) {
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
							// here's the fix
							char charValue = (char) (value & 0xff);
							characters[i] = charValue;
						}
					}
					return new String(characters, 0, length);
				}
			}

		}.readString();
		assertEquals(s, newS);
	}
}
