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
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.IPath;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.hash.HashCode;
import com.google.common.io.Files;
import com.google.inject.Singleton;

/**
 * @see BinaryFileHashing
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class ClasspathInfos {

	private ConcurrentHashMap<IPath, ClasspathEntryHash> classpathEntries = new ConcurrentHashMap<>();

	public ClasspathEntryHash hashClassesOrJar(IPath classpathEntry) {
		return classpathEntries.computeIfAbsent(classpathEntry, any -> {
			File classpathEntryAsFile = classpathEntry.toFile();
			if ("jar".equalsIgnoreCase(classpathEntry.getFileExtension()) && classpathEntryAsFile.isFile()) {
				List<String> segments = Arrays.asList(classpathEntry.segments());
				if (segments.contains(".gradle")) {
					String maybeHash = segments.get(segments.size() - 2);
					if (maybeHash.length() >= 36) {
						HashCode hash = BinaryFileHashing.hashFunction().hashString(maybeHash, StandardCharsets.ISO_8859_1);
						BinaryFileHashing.LOG.trace("Hashed file " + classpathEntryAsFile.getName() + " to " + hash);
						return new CoarseGrainedEntryHash(hash);
					}
				}
				File mavenSha1 = classpathEntry.addFileExtension("sha1").toFile();
				if (mavenSha1.isFile()) {
					return new CoarseGrainedEntryHash(BinaryFileHashing.processFile(mavenSha1));
				}
				return new CoarseGrainedEntryHash(BinaryFileHashing.processFile(classpathEntryAsFile));
			}
			Map<IPath, HashCode> classHashes = new HashMap<>();
			Files.fileTraverser().breadthFirst(classpathEntryAsFile).forEach(file -> {
				if (file.isFile()) {
					String fileName = file.getName().toLowerCase();
					if (fileName.endsWith(".class")) {
						BinaryFileHashing.processFile(file, (path, hash)->{
							IPath fqn = path.makeRelativeTo(classpathEntry).removeFileExtension();
							classHashes.put(fqn, hash);
						});
					}
				}
			});
			return new FineGrainedEntryHash(classHashes);
		});
	}

	@VisibleForTesting
	public void clear() {
		classpathEntries.clear();
	}

}
