/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;

import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class ClasspathInfos {
	
	private static final Logger logger = Logger.getLogger(ClasspathInfos.class);
	
	private static final int _16_KB = 16384;
	
	private ConcurrentHashMap<IPath, HashCode> hashes = new ConcurrentHashMap<>();
	
	public byte[] hashClassesOrJar(IPath path) {
		return hashes.computeIfAbsent(path, any->{
			if ("jar".equalsIgnoreCase(path.getFileExtension())) {
				List<String> segments = Arrays.asList(path.segments());
				if (segments.contains(".gradle")) {
					String maybeHash = segments.get(segments.size() - 2);
					if (maybeHash.length() >= 36) {
						return BinaryFileHashing.hashFunction().hashString(maybeHash, StandardCharsets.ISO_8859_1);
					}
				}
				File mavenSha1 = path.addFileExtension("sha1").toFile();
				if (mavenSha1.isFile()) {
					try {
						byte[] bytes = java.nio.file.Files.readAllBytes(mavenSha1.toPath());
						return BinaryFileHashing.hashFunction().hashBytes(bytes);
					} catch (IOException e) {
						logger.debug(e.getMessage(), e);
					}
				}
			} 
			Hasher hasher = BinaryFileHashing.hashFunction().newHasher();
			try (OutputStream hasherAsStream = Funnels.asOutputStream(hasher)) {
				Files.fileTraverser().breadthFirst(path.toFile()).forEach(file -> {
					if (file.isFile()) {
						String fileName = file.getName().toLowerCase();
						if (fileName.endsWith(".class") || fileName.endsWith(".jar")) {
							try (InputStream in = new BufferedInputStream(new FileInputStream(file), _16_KB)) {
								ByteStreams.copy(in, hasherAsStream);
							} catch (IOException e) {
								hasher.putBoolean(false);
							}
						}
					}
				});
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
			return hasher.hash();
			
			
		}).asBytes();
	}
	
}
