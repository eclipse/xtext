/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.compiler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.incremental.ExtendedEObjectInputStream;
import org.eclipse.xtext.builder.standalone.incremental.ExtendedEObjectOutputStream;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.google.common.hash.HashCode;
import com.google.common.io.CountingOutputStream;
import com.google.common.io.Files;

class SerializedCompilerState {

	// Intentionally use the same logger as the EclipseJavaCompiler
	private static final Logger LOG = Logger.getLogger(EclipseJavaCompiler.class);

	private static final int SERIALIZATION_VERSION = 1;

	private static final int HASH_CODE = 0;
	private static final int PATH = 1;
	private static final int PATHS = 2;
	private static final int STRING = 3;

	long duration;

	HashCode hashedClasspath;
	/**
	 * The input java files. The map-key is the absolute path for the source
	 * file.
	 */
	final Map<IPath, HashCode> inputFiles = new HashMap<>();
	/**
	 * The output class files. The map-key is the absolute path for the class
	 * file.
	 */
	final Map<IPath, HashCode> outputFiles = new HashMap<>();

	final Map<IPath, AccessibleReferenceCollection> referenceInformation = new HashMap<>();

	final Map<IPath, IPath[]> inputToOutputFiles = new HashMap<>();

	final Map<IPath, IPath> outputToInputFile = new HashMap<>();

	final Map<IPath, String> outputToTypeName = new HashMap<>();

	Map<URI, ClassFileResourceDescription> resourceDescriptions() {
		Stopwatch sw = Stopwatch.createStarted();
		try {
			Map<URI, ClassFileResourceDescription> result = new HashMap<>();
			for (IPath[] outputFiles : inputToOutputFiles.values()) {
				if (outputFiles != null && outputFiles.length > 0) {
					List<IPath> sorted = new ArrayList<IPath>(Arrays.asList(outputFiles));
					Collections.sort(sorted, Comparator.comparing(p -> p.removeFileExtension().toString()));
					// At this point we do have something along these lines:
					// [
					// Abc.class,
					// Abc$Nested.class,
					// Secondary.class,
					// Third.class,
					// Third$Nested.class
					// ]
					// We walk the list from left to right, starting new
					// resource descriptions as soon as "head" + "$" is not
					// a prefix of "next"
					ClassFileResourceDescription currentDescription = null;
					String currentType = "";
					int i = 0;
					do {
						IPath outputFile = sorted.get(i);
						String typeName = outputToTypeName.get(outputFile).replace('/', '.');
						if (currentType.equals("") || !typeName.startsWith(currentType + "$")) {
							currentType = typeName;
							currentDescription = new ClassFileResourceDescription(
									ClassURIHelper.OBJECTS_URI.appendSegment(typeName), new HashSet<>());
							result.put(currentDescription.uri, currentDescription);
						}
						currentDescription.descriptions.add(new ClassFileEObjectDescription(
								currentDescription.uri.appendFragment(typeName), this.outputFiles.get(outputFile)));
						i++;
					} while (i < sorted.size());
				}
			}
			return result;
		} finally {
			LOG.trace("Created Xtext index for Java class files in " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms.");
		}
	}

	static SerializedCompilerState from(File file) {
		SerializedCompilerState result = new SerializedCompilerState();
		if (file.exists()) {
			Stopwatch sw = Stopwatch.createStarted();
			boolean failed = false;
			try (BufferedInputStream buffy = new BufferedInputStream(
					new GZIPInputStream(new BufferedInputStream(new FileInputStream(file))))) {
				ExtendedEObjectInputStream in = new ExtendedEObjectInputStream(buffy, 128);
				result.read(in);
			} catch (IOException e) {
				failed = true;
				LOG.error("Failed to read compiler state.", e);
			} finally {
				if (!failed) {
					LOG.trace("Read compiler state in " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms.");
				}
			}
		} else {
			result.hashedClasspath = HashCode.fromInt(0);
		}
		return result;
	}

	private void read(ExtendedEObjectInputStream in) throws IOException {
		if (in.readCompressedInt() != SERIALIZATION_VERSION) {
			hashedClasspath = HashCode.fromInt(0);
			return;
		}
		hashedClasspath = in.readHashCode();
		
		readFiles(in, inputFiles, HASH_CODE, HashCode.class);
		readFiles(in, outputFiles, HASH_CODE, HashCode.class);
		readFiles(in, outputToInputFile, PATH, IPath.class);
		readFiles(in, inputToOutputFiles, PATHS, IPath[].class);
		readFiles(in, outputToTypeName, STRING, String.class);
		readReferences(in);
		duration = in.readLong();
	}

	private void readReferences(ExtendedEObjectInputStream in) throws IOException {
		int size = in.readCompressedInt();
		for (int i = 0; i < size; i++) {
			IPath p = in.readPath();

			char[][][] qn = new char[in.readCompressedInt()][][];
			for (int j = 0; j < qn.length; j++) {
				qn[j] = in.readCharCharArray();
			}
			char[][] roots = in.readCharCharArray();
			char[][] simpleNames = in.readCharCharArray();

			AccessibleReferenceCollection referenceCollection = new AccessibleReferenceCollection(qn, simpleNames,
					roots);
			this.referenceInformation.put(p, referenceCollection);
		}
	}

	private <T> void readFiles(ExtendedEObjectInputStream in, Map<IPath, T> files, int mode, Class<T> type)
			throws IOException {
		int size = in.readCompressedInt();
		for (int i = 0; i < size; i++) {
			IPath p = in.readPath();
			switch (mode) {
			case HASH_CODE:
				files.put(p, type.cast(in.readHashCode()));
				break;
			case PATH:
				files.put(p, type.cast(in.readPath()));
				break;
			case PATHS: {
				IPath[] pathArray = new IPath[in.readCompressedInt()];
				for (int j = 0; j < pathArray.length; j++) {
					pathArray[j] = in.readPath();
				}
				files.put(p, type.cast(pathArray));
				break;
			}
			case STRING:
				files.put(p, type.cast(in.readSegmentedString()));
				break;
			}
		}
	}

	void to(File file, Stopwatch rootStopwatch) {
		Stopwatch sw = Stopwatch.createStarted();
		boolean failed = false;
		try {
			Files.createParentDirs(file);
		} catch (IOException e) {
			LOG.error("Failed to store compiler state.", e);
			return;
		}

		long uncompressedCount = 0;
		long compressedCount = 0;
		try (CountingOutputStream baseOut = new CountingOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)));
				CountingOutputStream countingOut = new CountingOutputStream(
						new BufferedOutputStream(new GZIPOutputStream(baseOut)))) {

			ExtendedEObjectOutputStream out = new ExtendedEObjectOutputStream(countingOut, 128);
			out.writeCompressedInt(SERIALIZATION_VERSION);
			out.writeHashCode(hashedClasspath);

			writeFiles(out, inputFiles, HASH_CODE);
			writeFiles(out, outputFiles, HASH_CODE);
			writeFiles(out, outputToInputFile, PATH);
			writeFiles(out, inputToOutputFiles, PATHS);
			writeFiles(out, outputToTypeName, STRING);
			writeReferences(out);
			rootStopwatch.stop();
			if (this.duration == 0) {
				this.duration = rootStopwatch.elapsed(TimeUnit.MILLISECONDS);
			}
			out.writeLong(this.duration);
			out.flush();
			countingOut.flush();
			countingOut.close();
			compressedCount = baseOut.getCount();
			uncompressedCount = countingOut.getCount();
		} catch (IOException e) {
			failed = true;
			LOG.error("Failed to store compiler state.", e);
		} finally {
			if (!failed) {
				LOG.trace("Stored compiler state in " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms (" + uncompressedCount
						+ " bytes compressed to " + compressedCount + " bytes).");
			}
		}
	}

	private void writeReferences(ExtendedEObjectOutputStream out) throws IOException {
		out.writeCompressedInt(referenceInformation.size());
		for (Map.Entry<IPath, AccessibleReferenceCollection> entry : referenceInformation.entrySet()) {
			out.writePath(entry.getKey());
			AccessibleReferenceCollection referenceCollection = entry.getValue();
			char[][][] qn = referenceCollection.qualifiedNameReferences();
			out.writeCompressedInt(qn.length);
			for (char[][] n : qn) {
				out.writeCharCharArray(n);
			}
			out.writeCharCharArray(referenceCollection.rootReferences());
			out.writeCharCharArray(referenceCollection.simpleNameReferences());
		}
	}

	private void writeFiles(ExtendedEObjectOutputStream out, Map<IPath, ?> files, int mode)
			throws IOException {
		out.writeCompressedInt(files.size());
		for (Map.Entry<IPath, ?> entry : files.entrySet()) {
			out.writePath(entry.getKey());
			switch (mode) {
			case HASH_CODE:
				out.writeHashCode((HashCode) entry.getValue());
				break;
			case PATH:
				out.writePath((IPath) entry.getValue());
				break;
			case PATHS: {
				IPath[] pathArray = (IPath[]) entry.getValue();
				out.writeCompressedInt(pathArray.length);
				for (IPath path : pathArray) {
					out.writePath(path);
				}
				break;
			}
			case STRING:
				out.writeSegmentedString((String) entry.getValue());
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(hashedClasspath, inputFiles, Maps.transformValues(inputToOutputFiles, Arrays::asList),
				outputFiles, outputToInputFile, outputToTypeName, referenceInformation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SerializedCompilerState other = (SerializedCompilerState) obj;
		return Objects.equals(hashedClasspath, other.hashedClasspath) && Objects.equals(inputFiles, other.inputFiles)
				&& Objects.equals(Maps.transformValues(inputToOutputFiles, Arrays::asList),
						Maps.transformValues(other.inputToOutputFiles, Arrays::asList))
				&& Objects.equals(outputFiles, other.outputFiles)
				&& Objects.equals(outputToInputFile, other.outputToInputFile)
				&& Objects.equals(outputToTypeName, other.outputToTypeName)
				&& Objects.equals(referenceInformation, other.referenceInformation);
	}

}