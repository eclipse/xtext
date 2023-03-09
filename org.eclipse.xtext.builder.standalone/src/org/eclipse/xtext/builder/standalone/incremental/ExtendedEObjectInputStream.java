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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectInputStream;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescription;
import org.eclipse.xtext.resource.persistence.SerializableReferenceDescription;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;

import com.google.common.hash.HashCode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.29
 */
public class ExtendedEObjectInputStream extends EObjectInputStream {

	private final byte[] hashBuffer;
	private final List<IPath> paths;
	private final List<char[][]> charchars;
	private final List<char[]> chars;
	
	public ExtendedEObjectInputStream(InputStream source, int hashBits) throws IOException {
		super(source, Collections.emptyMap());
		this.hashBuffer = new byte[hashBits / 8];
		paths = new ArrayList<>();
		charchars = new ArrayList<char[][]>();
		chars = new ArrayList<char[]>();
	}
	
	public HashCode readHashCode() throws IOException {
		for (int i = 0; i < hashBuffer.length; i++) {
			hashBuffer[i] = readByte();
		}
		return HashCode.fromBytes(hashBuffer);
	}
	
	public IPath readPath() throws IOException {
		int idx = readCompressedInt();
		if (idx < paths.size()) {
			return paths.get(idx);
		} else {
			IPath result = Path.fromPortableString(readSegmentedString());
			paths.add(result);
			return result;
		}
	}
	
	public char[][] readCharCharArray()
			throws IOException {
		int idx = readCompressedInt();
		if (idx < charchars.size()) {
			return charchars.get(idx);
		}
		char[][] result = new char[readCompressedInt()][];
		for (int i = 0; i < result.length; i++) {
			idx = readCompressedInt();
			if (idx < chars.size()) {
				result[i] = chars.get(idx);
			} else {
				char[] cs = readString().toCharArray();
				chars.add(cs);
				result[i] = cs;
			}
		}
		charchars.add(result);
		return result;
	}
	
	public SerializableResourceDescription readResourceDescription() throws IOException {
		SerializableResourceDescription result = new SerializableResourceDescription();
		result.setURI(readURI());
		result.setDescriptions(readEObjectDescriptions());
		result.setReferences(readReferenceDescriptions());
		result.setImportedNames(readImportedNames());
		return result;
	}

	protected List<SerializableEObjectDescription> readEObjectDescriptions()
			throws IOException {
		int size = readCompressedInt();
		if (size == 0) {
			return Collections.emptyList();
		}
		List<SerializableEObjectDescription> result = new ArrayList<>(size);
		while (size > 0) {
			size--;
			SerializableEObjectDescription object = new SerializableEObjectDescription();
			object.setEObjectURI(readURI());
			object.setEClass(readEClass().eClass);
			object.setQualifiedName(QualifiedName.createFromStream(this));
			int userDataSize = readCompressedInt();
			HashMap<String, String> userData = new HashMap<>(userDataSize);
			while (userDataSize > 0) {
				userDataSize--;
				String key = readString();
				userData.put(key, readString());
			}
			object.setUserData(userData);
			result.add(object);
		}
		return result;
	}
	
	protected List<SerializableReferenceDescription> readReferenceDescriptions()
			throws IOException {
		int size = readCompressedInt();
		if (size == 0) {
			return Collections.emptyList();
		}
		List<SerializableReferenceDescription> result = new ArrayList<>(size);
		while (size > 0) {
			size--;
			SerializableReferenceDescription reference = new SerializableReferenceDescription();
			reference.setSourceEObjectUri(readURI());
			reference.setTargetEObjectUri(readURI());
			reference.setContainerEObjectURI(readURI());
			reference.setEReference((EReference) readEStructuralFeature().eStructuralFeature);
			reference.setIndexInList(readCompressedInt());
			result.add(reference);
		}
		return result;
	}
	
	protected List<QualifiedName> readImportedNames() throws IOException {
		int size = readCompressedInt();
		if (size == 0) {
			return Collections.emptyList();
		}
		List<QualifiedName> result = new ArrayList<>(size);
		while (size > 0) {
			size--;
			result.add(QualifiedName.createFromStream(this));
		}
		return result;
	}

}
