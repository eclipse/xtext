/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.BinaryIO;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescription;
import org.eclipse.xtext.resource.persistence.SerializableReferenceDescription;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;

import com.google.common.collect.Lists;
import com.google.common.hash.HashCode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.29
 */
public class ExtendedEObjectOutputStream extends EObjectOutputStream {

	private final byte[] hashBuffer;
	private final Map<IPath, Integer> paths;
	private final Map<char[][], Integer> charchars;
	private final Map<char[], Integer> chars;

	public ExtendedEObjectOutputStream(OutputStream target, int hashBits) throws IOException {
		super(target, Collections.emptyMap(), Version.VERSION_1_1, BinaryIO.STYLE_DATA_CONVERTER);
		this.hashBuffer = new byte[hashBits / 8];
		this.paths = new HashMap<IPath, Integer>();
		this.charchars = new HashMap<char[][], Integer>();
		this.chars = new HashMap<char[], Integer>();
	}

	public void writeHashCode(HashCode hash) throws IOException {
		hash.writeBytesTo(hashBuffer, 0, hash.bits() / 8);
		this.outputStream.write(hashBuffer);
	}

	public void writePath(IPath p) throws IOException {
		Integer idx = paths.get(p);
		if (idx != null) {
			writeCompressedInt(idx);
		} else {
			idx = paths.size();
			paths.put(p, idx);
			writeCompressedInt(idx);
			writeSegmentedString(p.toPortableString());
		}
	}

	public void writeCharCharArray(char[][] charchar) throws IOException {
		Integer idx = charchars.get(charchar);
		if (idx == null) {
			idx = charchars.size();
			charchars.put(charchar, idx);
			writeCompressedInt(idx);
			writeCompressedInt(charchar.length);
			for (char[] c : charchar) {
				idx = chars.get(c);
				if (idx == null) {
					idx = chars.size();
					chars.put(c, idx);
					writeCompressedInt(idx);
					writeString(String.valueOf(c));
				} else {
					writeCompressedInt(idx);
				}
			}
		} else {
			writeCompressedInt(idx);
		}
	}

	public void writeResourceDescription(SerializableResourceDescription description) throws IOException {
		writeURI(description.getURI());
		writeEObjectDescriptions(description);
		writeReferenceDescriptions(description);
		writeImportedNames(description);
	}

	protected void writeEObjectDescriptions(SerializableResourceDescription resourceDescription) throws IOException {
		List<SerializableEObjectDescription> objects = resourceDescription.getDescriptions();
		writeCompressedInt(objects.size());
		for (SerializableEObjectDescription object : objects) {
			writeURI(object.getEObjectURI());
			writeEClass(object.getEClass());
			object.getQualifiedName().writeToStream(this);
			Map<String, String> userData = object.getUserData();
			if (userData != null) {
				writeCompressedInt(userData.size());
				for (Map.Entry<String, String> entry : userData.entrySet()) {
					writeString(entry.getKey());
					writeString(entry.getValue());
				}
			} else {
				writeCompressedInt(0);
			}
		}
	}

	protected void writeReferenceDescriptions(SerializableResourceDescription resourceDescription) throws IOException {
		List<SerializableReferenceDescription> references = resourceDescription.getReferences();
		writeCompressedInt(references.size());
		for (SerializableReferenceDescription reference : references) {
			writeURI(reference.getSourceEObjectUri());
			writeURI(reference.getTargetEObjectUri());
			writeURI(reference.getContainerEObjectURI());
			writeEStructuralFeature(reference.getEReference());
			writeCompressedInt(reference.getIndexInList());
		}
	}

	protected void writeImportedNames(SerializableResourceDescription resourceDescription) throws IOException {
		List<QualifiedName> importedNames = Lists.newArrayList(resourceDescription.getImportedNames());
		writeCompressedInt(importedNames.size());
		for (QualifiedName importedName : importedNames) {
			importedName.writeToStream(this);
		}
	}

	@Override
	public void writeURI(URI uri) throws IOException {
		if (uri == null) {
			writeCompressedInt(-1);
		} else {
			writeURI(uri.trimFragment(), uri.fragment());
		}
	}

}
