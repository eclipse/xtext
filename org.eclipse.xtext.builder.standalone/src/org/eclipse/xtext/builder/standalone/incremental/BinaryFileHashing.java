/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.function.BiConsumer;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

public class BinaryFileHashing {
	
	static final Logger LOG = Logger.getLogger(BinaryFileHashing.class);
	
	private static final HashFunction HASH_FUNCTION = Hashing.murmur3_128(0);
	
	public static void processDirectory(String directory, Map<IPath, HashCode> result, String fileExtension) {
		Files.fileTraverser().breadthFirst(new File(directory)).forEach(file -> {
			if (file.isFile() && (fileExtension == null || file.getName().endsWith(fileExtension))) {
				processFile(file, result::put);
			}
		});
	}
	
	public static void processFile(File file, BiConsumer<IPath, HashCode> result) {
		result.accept(new Path(file.getAbsolutePath()), processFile(file));
	}
	
	public static HashCode processFile(File file) {
		try {
			HashCode hash = Files.asByteSource(file).hash(HASH_FUNCTION);
			LOG.trace("Hashed file " + file.getName() + " to " + hash);
			return hash;
		} catch (IOException e) {
			LOG.warn("Failed to hash file " + file.getAbsolutePath());
			return unknownHashCode();
		}
	}
	
	public static HashFunction hashFunction() {
		return HASH_FUNCTION;
	}
	
	public static HashCode unknownHashCode() {
		return HashCode.fromInt(0);
	}

}
