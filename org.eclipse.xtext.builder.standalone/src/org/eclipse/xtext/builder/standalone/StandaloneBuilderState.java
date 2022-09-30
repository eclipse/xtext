/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.builder.standalone.incremental.BinaryFileHashing;
import org.eclipse.xtext.builder.standalone.incremental.ExtendedEObjectInputStream;
import org.eclipse.xtext.builder.standalone.incremental.ExtendedEObjectOutputStream;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Stopwatch;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.io.CountingOutputStream;
import com.google.common.io.Files;

class StandaloneBuilderState {

	// Intentionally use the same logger as the EclipseJavaCompiler
	private static final Logger LOG = Logger.getLogger(StandaloneBuilder.class);

	private static final HashFunction HASH_FUNCTION = Hashing.murmur3_128(0);

	private static final int SERIALIZATION_VERSION = 1;

	private static final int HASH_CODE = 0;
	private static final int PATH = 1;
	private static final int PATHS = 2;
	private static final int URI = 3;

	HashCode libraryPathHash;

	final ResourceDescriptionsData index;

	final Map<URI, HashCode> sourceFiles = new HashMap<>();

	final Map<URI, HashCode> libraryFiles = new HashMap<>();

	final Map<IPath, HashCode> outputFiles = new HashMap<>();

	final Map<URI, IPath[]> inputToOutputFiles = new HashMap<>();

	final Map<IPath, URI> outputToInputFile = new HashMap<>();

	final Map<IPath, HashCode> stubFiles = new HashMap<>();

	final Map<URI, IPath[]> inputToStubFiles = new HashMap<>();

	final Map<IPath, URI> stubToInputFile = new HashMap<>();

	final Multimap<URI, Issue> issues = TreeMultimap.create(Comparator.comparing(Object::toString),
			Comparator.comparingInt(Issue::getLineNumber).thenComparingInt(Issue::getColumn)
					.thenComparing(Issue::getMessage).thenComparing(Issue::hashCode));

	StandaloneBuilderState() {
		index = new ResourceDescriptionsData(new ArrayList<>());
	}

	boolean updateLibraryHash(HashCode libraryPathHash) {
		if (libraryPathHash.equals(this.libraryPathHash)) {
			return false;
		}
		this.libraryPathHash = libraryPathHash;
		return true;
	}

	// Delete the known information about the source files for which the output
	// files are outdated
	// which effectively treats them as new files when sourceChanges are
	// collected
	void processOutputDirectories(Set<String> outputFolders) {
		Map<IPath, HashCode> currentOutputFiles = new HashMap<>();
		for (String directory : outputFolders) {
			BinaryFileHashing.processDirectory(directory, currentOutputFiles, null);
		}
		syncOutputFiles(this.outputFiles, currentOutputFiles);
	}

	void processStubDirectory(String stubDirectory) {
		Map<IPath, HashCode> currentStubFiles = new HashMap<>();
		BinaryFileHashing.processDirectory(stubDirectory, currentStubFiles, ".java");
		syncOutputFiles(this.stubFiles, currentStubFiles);
	}

	private void syncOutputFiles(Map<IPath, HashCode> originalFiles, Map<IPath, HashCode> newFiles) {
		MapDifference<IPath, HashCode> difference = Maps.difference(originalFiles, newFiles);

		// Handle all files that are expected to be there but missing
		for (IPath missing : difference.entriesOnlyOnLeft().keySet()) {
			discardOutputAndStubData(outputToInputFile.remove(missing));
			discardOutputAndStubData(stubToInputFile.remove(missing));
		}
		// Handle all files that are present but different
		for (IPath different : difference.entriesDiffering().keySet()) {
			discardOutputAndStubData(outputToInputFile.remove(different));
			discardOutputAndStubData(stubToInputFile.remove(different));
		}
	}

	private void discardOutputAndStubData(URI inputFile) {
		if (inputFile != null && sourceFiles.put(inputFile, null) != null) {
			IPath[] outputFiles = inputToOutputFiles.remove(inputFile);
			if (outputFiles != null) {
				for (IPath outputFile : outputFiles) {
					outputFile.toFile().delete();
					outputToInputFile.remove(outputFile);
					this.outputFiles.remove(outputFile);
				}
			}
			IPath[] stubFiles = inputToStubFiles.remove(inputFile);
			if (stubFiles != null) {
				for (IPath stubFile : stubFiles) {
					stubFile.toFile().delete();
					stubToInputFile.remove(stubFile);
					this.stubFiles.remove(stubFile);
				}
			}
		}
	}

	IResourceDescription.Event sourceChanges(List<URI> resourceURIs, Collection<URI> newResources) {
		Map<URI, HashCode> newSourceFiles = new HashMap<>();
		for (URI sourceResource : resourceURIs) {
			newSourceFiles.put(sourceResource, hash(sourceResource));
		}
		return diffDslResources(sourceFiles, newSourceFiles, newResources);
	}

	/**
	 * Returns the delta of deleted resources and an accumulation of newly
	 * available resources.
	 */
	IResourceDescription.Event libraryChanges(List<URI> resourceURIs, Collection<URI> newResources) {
		Map<URI, HashCode> newBinaryFiles = new HashMap<>();
		for (URI binaryResource : resourceURIs) {
			newBinaryFiles.put(binaryResource, hash(binaryResource));
		}
		return diffDslResources(libraryFiles, newBinaryFiles, newResources);
	}

	private IResourceDescription.Event diffDslResources(Map<URI, HashCode> originalFiles, Map<URI, HashCode> newFiles,
			Collection<URI> accumulator) {
		MapDifference<URI, HashCode> difference = Maps.difference(originalFiles, newFiles);
		List<IResourceDescription.Delta> deltas = new ArrayList<>();
		for (URI removed : difference.entriesOnlyOnLeft().keySet()) {
			IResourceDescription oldDescription = index.getResourceDescription(removed);
			if (oldDescription != null) {
				deltas.add(new DefaultResourceDescriptionDelta(oldDescription, null));
				index.removeDescription(removed);
			}
			issues.removeAll(removed);
			processRemovedFiles(removed, inputToOutputFiles, outputToInputFile, outputFiles);
			processRemovedFiles(removed, inputToStubFiles, stubToInputFile, stubFiles);
		}
		accumulator.addAll(difference.entriesOnlyOnRight().keySet());
		accumulator.addAll(difference.entriesDiffering().keySet());

		originalFiles.clear();
		originalFiles.putAll(newFiles);
		return new ResourceDescriptionChangeEvent(deltas);
	}

	private void processRemovedFiles(URI removed, Map<URI, IPath[]> inputToOutput, Map<IPath, URI> outputToInput,
			Map<IPath, HashCode> outputHashes) {
		IPath[] outputFiles = inputToOutput.remove(removed);
		if (outputFiles != null) {
			for (IPath outputFile : outputFiles) {
				outputFile.toFile().delete();
				outputToInput.remove(outputFile);
				outputHashes.remove(outputFile);
			}
		}
	}

	private HashCode hash(URI resource) {
		Hasher hasher = newHasher();
		try (OutputStream hasherAsStream = Funnels.asOutputStream(hasher)) {
			try (InputStream in = new BufferedInputStream(URIConverter.INSTANCE.createInputStream(resource), 16384)) {
				ByteStreams.copy(in, hasherAsStream);
			} catch (IOException e) {
				hasher.putBoolean(false);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return hasher.hash();
	}

	void setIssues(URI resource, Iterable<Issue> issues) {
		this.issues.replaceValues(resource, issues);
	}

	boolean processIssues(IIssueHandler issueHandler) {
		boolean result = true;
		for (Collection<Issue> issues : issues.asMap().values()) {
			if (!issueHandler.handleIssue(issues)) {
				result = false;
			}
		}
		return result;
	}

	static StandaloneBuilderState from(File file) {
		StandaloneBuilderState result = new StandaloneBuilderState();
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
			result.libraryPathHash = HashCode.fromInt(0);
		}
		return result;
	}

	private void read(ExtendedEObjectInputStream in) throws IOException {
		if (in.readCompressedInt() != SERIALIZATION_VERSION) {
			libraryPathHash = HashCode.fromInt(0);
			return;
		}
		libraryPathHash = in.readHashCode();

		readResourceDescriptions(in);
		
		readMap(in, sourceFiles, URI, URI.class, HASH_CODE, HashCode.class);
		readMap(in, libraryFiles, URI, URI.class, HASH_CODE, HashCode.class);
		readMap(in, outputFiles, PATH, IPath.class, HASH_CODE, HashCode.class);
		readMap(in, inputToOutputFiles, URI, URI.class, PATHS, IPath[].class);
		readMap(in, outputToInputFile, PATH, IPath.class, URI, URI.class);
		readMap(in, stubFiles, PATH, IPath.class, HASH_CODE, HashCode.class);
		readMap(in, inputToStubFiles, URI, URI.class, PATHS, IPath[].class);
		readMap(in, stubToInputFile, PATH, IPath.class, URI, URI.class);
		
		readIssues(in);
	}
	
	private void readIssues(ExtendedEObjectInputStream input)
			throws IOException {
		int numberOfSources = input.readCompressedInt();
		while (numberOfSources > 0) {
			numberOfSources--;
			URI source = input.readURI();
			int numberOfIssues = input.readCompressedInt();
			while (numberOfIssues > 0) {
				numberOfIssues--;
				issues.put(source, readIssue(input));
			}
		}
	}
	
	private void readResourceDescriptions(ExtendedEObjectInputStream input)
			throws IOException {
		int size = input.readCompressedInt();
		while (size > 0) {
			size--;
			SerializableResourceDescription description = input.readResourceDescription();
			index.addDescription(description.getURI(), description);
		}
	}

	void to(File file) {
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

			out.writeHashCode(libraryPathHash);
			
			writeResourceDescriptions(out);

			writeMap(out, sourceFiles, URI, HASH_CODE);
			writeMap(out, libraryFiles, URI, HASH_CODE);
			writeMap(out, outputFiles, PATH, HASH_CODE);
			writeMap(out, inputToOutputFiles, URI, PATHS);
			writeMap(out, outputToInputFile, PATH, URI);
			writeMap(out, stubFiles, PATH, HASH_CODE);
			writeMap(out, inputToStubFiles, URI, PATHS);
			writeMap(out, stubToInputFile, PATH, URI);

			writeIssues(out);
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

	private void writeMap(ExtendedEObjectOutputStream out, Map<?, ?> files, int keyMode, int valueMode)
			throws IOException {
		out.writeCompressedInt(files.size());
		for (Map.Entry<?, ?> entry : files.entrySet()) {
			switch (keyMode) {
			case URI:
				out.writeURI((URI) entry.getKey());
				break;
			case PATH:
				out.writePath((IPath) entry.getKey());
				break;
			}
			switch (valueMode) {
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
			case URI:
				out.writeURI((URI) entry.getValue());
				break;
			default:
				throw new IllegalArgumentException();
			}
		}
	}

	private <K, V> void readMap(ExtendedEObjectInputStream in, Map<K, V> map, int keyMode, Class<K> key, int valueMode,
			Class<V> value) throws IOException {
		int size = in.readCompressedInt();
		for (int i = 0; i < size; i++) {
			K k;
			switch (keyMode) {
			case URI:
				k = key.cast(in.readURI());
				break;
			case PATH:
				k = key.cast(in.readPath());
				break;
			default:
				throw new IllegalArgumentException();
			}

			switch (valueMode) {
			case HASH_CODE:
				map.put(k, value.cast(in.readHashCode()));
				break;
			case PATH:
				map.put(k, value.cast(in.readPath()));
				break;
			case PATHS: {
				IPath[] pathArray = new IPath[in.readCompressedInt()];
				for (int j = 0; j < pathArray.length; j++) {
					pathArray[j] = in.readPath();
				}
				map.put(k, value.cast(pathArray));
				break;
			}
			case URI:
				map.put(k, value.cast(in.readURI()));
				break;
			}
		}
	}

	private void writeResourceDescriptions(ExtendedEObjectOutputStream out) throws IOException {
		out.writeCompressedInt(index.getAllURIs().size());
		for (IResourceDescription description : FluentIterable.from(index.getAllResourceDescriptions())
				.toSortedList(Comparator.comparing(rd -> rd.getURI().toString()))) {
			if (description instanceof SerializableResourceDescription) {
				out.writeResourceDescription((SerializableResourceDescription) description);
			} else {
				out.writeResourceDescription(SerializableResourceDescription.createCopy(description));
			}
		}
	}

	private void writeIssues(ExtendedEObjectOutputStream out) throws IOException {
		int numberSources = issues.keySet().size();
		out.writeCompressedInt(numberSources);
		for (URI source : issues.keySet()) {
			Collection<Issue> issues = this.issues.get(source);

			out.writeURI(source);

			int numberIssues = issues.size();
			out.writeCompressedInt(numberIssues);
			for (Issue issue : issues) {
				writeIssue(issue, out);
			}
		}
	}

	private static void writeIssue(Issue issue, ExtendedEObjectOutputStream out) throws IOException {
		out.writeCompressedInt(issue.getOffset());
		out.writeCompressedInt(issue.getLength());
		out.writeCompressedInt(issue.getColumn());
		out.writeCompressedInt(issue.getColumnEnd());
		out.writeCompressedInt(issue.getLineNumber());
		out.writeCompressedInt(issue.getLineNumberEnd());
		out.writeSegmentedString(issue.getCode());
		out.writeSegmentedString(issue.getMessage());

		URI uriToProblem = issue.getUriToProblem();
		if (uriToProblem == null) {
			out.writeURI(null, null);
		} else {
			out.writeURI(uriToProblem);
		}

		Severity severity = issue.getSeverity();
		int severityKey = severity == null ? -1 : severity.ordinal();
		out.writeCompressedInt(severityKey);

		CheckType checkType = issue.getType();
		int checkTypeKey = checkType == null ? -1 : checkType.ordinal();
		out.writeCompressedInt(checkTypeKey);

		String[] data = issue.getData();
		if (data == null) {
			out.writeCompressedInt(-1);
		} else {
			out.writeCompressedInt(data.length);
			for (String s : data) {
				out.writeSegmentedString(s);
			}
		}
	}

	private static Issue readIssue(ExtendedEObjectInputStream in) throws IOException {
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setOffset(in.readCompressedInt());
		issue.setLength(in.readCompressedInt());
		issue.setColumn(in.readCompressedInt());
		issue.setColumnEnd(in.readCompressedInt());
		issue.setLineNumber(in.readCompressedInt());
		issue.setLineNumberEnd(in.readCompressedInt());
		issue.setCode(in.readSegmentedString());
		issue.setMessage(in.readSegmentedString());

		issue.setUriToProblem(in.readURI());

		int severityKey = in.readCompressedInt();
		Severity severity = severityFromKey(severityKey);
		issue.setSeverity(severity);

		int checkTypeKey = in.readCompressedInt();
		CheckType checkType = checkTypeFromKey(checkTypeKey);
		issue.setType(checkType);

		int dataLength = in.readCompressedInt();
		if (dataLength >= 0) {
			String[] data = new String[dataLength];
			for (int i = 0; i < dataLength; i++) {
				data[i] = in.readSegmentedString();
			}
			issue.setData(data);
		}
		return issue;
	}

	private static final Severity[] severities = Severity.values();

	private static Severity severityFromKey(int severityKey) {
		switch (severityKey) {
		case -1:
			return null;
		default:
			return severities[severityKey];
		}
	}

	private static final CheckType[] checkTypes = CheckType.values();

	private static CheckType checkTypeFromKey(int checkTypeKey) {
		switch (checkTypeKey) {
		case -1:
			return null;
		default:
			return checkTypes[checkTypeKey];
		}
	}

	private Hasher newHasher() {
		return HASH_FUNCTION.newHasher();
	}

}
