/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.compiler;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.batch.FileSystem;
import org.eclipse.jdt.internal.compiler.batch.FileSystem.Classpath;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.eclipse.jdt.internal.compiler.util.SuffixConstants;
import org.eclipse.jdt.internal.core.builder.ReferenceCollection;
import org.eclipse.xtext.builder.standalone.incremental.BinaryFileHashing;
import org.eclipse.xtext.builder.standalone.incremental.ClasspathEntryHash;
import org.eclipse.xtext.builder.standalone.incremental.ClasspathEntryHashVisitor;
import org.eclipse.xtext.builder.standalone.incremental.ClasspathInfos;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.CoarseGrainedChangeEvent;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;

import com.google.common.base.Stopwatch;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.io.Files;

class InternalIncrementalCompiler extends Main {

	// Intentionally use the same logger as the EclipseJavaCompiler
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(EclipseJavaCompiler.class);

	private final File stateDirectory;
	private final Map<IPath, CompilationUnit> remainingCompilationUnits;
	private final IResourceDescription.Event.Listener eventListener;
	private final ClasspathInfos classpathInfos;

	private boolean fullBuild = false;
	private CompilationUnit[] toCompile;
	private SerializedCompilerState serializedCompileResult;
	private HashCode classpathArchiveHash;
	private Map<IPath, HashCode> classpathClassHashes;
	private List<IResourceDescription.Delta> deltas;

	private Set<String> qualifiedNames;
	private Set<String> simpleNames;
	private Set<String> rootNames;

	private Stopwatch rootStopwatch;

	InternalIncrementalCompiler(Writer outputWriter, Writer errorWriter, File stateDirectory,
			IResourceDescription.Event.Listener eventListener, ClasspathInfos classpathInfos) {
		super(new PrintWriter(outputWriter), new PrintWriter(errorWriter),
				false /* systemExit */, null /* options */, null);
		this.stateDirectory = stateDirectory;
		this.eventListener = eventListener;
		this.classpathInfos = classpathInfos;
		this.remainingCompilationUnits = new HashMap<>();
		this.qualifiedNames = new HashSet<>(3);
		this.simpleNames = new HashSet<>(3);
		this.rootNames = new HashSet<>(3);
	}

	/*
	 * Return the compilation units that are supposed to be considered for the
	 * next round of compilation.
	 */
	@Override
	public CompilationUnit[] getCompilationUnits() {
		compilerOptions.produceReferenceInfo = true;
		if (toCompile == null) {
			CompilationUnit[] allCompilationUnits = super.getCompilationUnits();
			if (stateDirectory == null) {
				this.fullBuild = true;
				return allCompilationUnits;
			}
			toCompile = diff(allCompilationUnits);
		}
		return toCompile;
	}

	/*
	 * Ensure the output directory is also on the CP for incremental compilation
	 * such that we can find previously compiled class files.
	 */
	@Override
	protected ArrayList<Classpath> handleClasspath(ArrayList<String> classpaths, String customEncoding) {
		Stopwatch sw = Stopwatch.createStarted();
		ArrayList<Classpath> result = super.handleClasspath(classpaths, customEncoding);
		IPath destinationPath = new Path(this.destinationPath);
		boolean found = false;
		List<ForkJoinTask<ClasspathEntryHash>> classpathEntryHashes = new ArrayList<>();
		for (Classpath cp : result) {
			IPath path = new Path(cp.getPath());
			if (destinationPath.equals(path)) {
				found = true;
			} else {
				classpathEntryHashes.add(ForkJoinPool.commonPool().submit(() -> classpathInfos.hashClassesOrJar(path)));
			}
		}
		classpathClassHashes = new HashMap<>();
		Hasher archiveHasher = newHasher();
		ClasspathEntryHashVisitor visitor = new ClasspathEntryHashVisitor() {
			public void visitArchive(HashCode archiveHash) {
				archiveHasher.putBytes(archiveHash.asBytes());
			}
			public void visitClassFile(IPath fqn, HashCode classHash) {
				classpathClassHashes.put(fqn, classHash);
			}
		};
		for (ForkJoinTask<ClasspathEntryHash> classpathEntryHash : classpathEntryHashes) {
			try {
				classpathEntryHash.get(60, TimeUnit.SECONDS).accept(visitor);
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				archiveHasher.putBoolean(false);
			}
		}
		classpathArchiveHash = archiveHasher.hash();
		
		LOG.trace("Processed first stage classpath in " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms.");
		if (found) {
			return result;
		}
		File destinationFile = destinationPath.toFile();
		try {
			java.nio.file.Files.createDirectories(destinationFile.toPath());
			FileSystem.Classpath outputDir = FileSystem.getClasspath(destinationFile.getAbsolutePath(), customEncoding,
					null, this.options, this.releaseVersion);
			result.add(0, outputDir);
		} catch (IOException e) {
			// ignore
		}
		return result;
	}

	private CompilationUnit[] scheduleAffected() {
		List<CompilationUnit> result = new ArrayList<CompilationUnit>();
		scheduleAffected(result);
		return result.toArray(new CompilationUnit[0]);
	}

	// see IncrementalImageBuilder.addAffectedSourceFiles
	private void scheduleAffected(List<CompilationUnit> result) {
		if (this.qualifiedNames.size() == 0 && this.simpleNames.size() == 0) {
			return;
		}
		// the qualifiedStrings are of the form 'p1/p2' & the simpleStrings
		// are just 'X'
		char[][][] internedQualifiedNames = ReferenceCollection.internQualifiedNames(this.qualifiedNames);
		// if a well known qualified name was found then we can skip over
		// these
		if (internedQualifiedNames.length < this.qualifiedNames.size())
			internedQualifiedNames = null;
		char[][] internedSimpleNames = ReferenceCollection.internSimpleNames(this.simpleNames, true);
		// if a well known name was found then we can skip over these
		if (internedSimpleNames.length < this.simpleNames.size())
			internedSimpleNames = null;
		char[][] internedRootNames = ReferenceCollection.internSimpleNames(this.rootNames, false);

		for (IPath filename : serializedCompileResult.inputFiles.keySet()) {
			if (remainingCompilationUnits.containsKey(filename)) {
				AccessibleReferenceCollection refs = serializedCompileResult.referenceInformation.get(filename);
				if (refs.includes(internedQualifiedNames, internedSimpleNames, internedRootNames)) {
					schedule(filename, result, null, true);
				}
			}
		}
	}

	private void addDependentsOf(IPath path) {
		path = path.setDevice(null);
		this.rootNames.add(path.segment(0));
		String packageName = path.removeLastSegments(1).toString();
		qualifiedNames.add(packageName);
		String typeName = path.lastSegment();
		int memberIndex = typeName.indexOf('$');
		if (memberIndex > 0)
			typeName = typeName.substring(0, memberIndex);
		simpleNames.add(typeName);
	}

	private CompilationUnit[] diff(CompilationUnit[] allCompilationUnits) {
		Map<IPath, HashCode> inputFiles = processInputFiles(allCompilationUnits);
		try {
			if (classpathArchiveHash.equals(serializedCompileResult.classpathArchiveHash)) {
				LOG.info("Archives on the classpath are equal to previous round. Attempt to reuse up-to-date compile results.");
				
				List<CompilationUnit> result = new ArrayList<CompilationUnit>();
				List<String> changedTypes = fineGrainedClasspathDiff();
				
				
				/*
				 * Find all files amongst the previously compiled files that are
				 * now absent or did change and remove the cached artifacts of
				 * all files that have been detected as changed. If the filename
				 * is still known, add its compilation unit to the queued units.
				 */
				serializedCompileResult.inputFiles.forEach((filename, prevHashCode) -> {
					HashCode hashCode = inputFiles.get(filename);
					if (!prevHashCode.equals(hashCode)) {
						schedule(filename, result, changedTypes, true);
					}
				});
				/*
				 * Find all input files that haven't been present in the
				 * previous round
				 */
				inputFiles.forEach((filename, hashCode) -> {
					if (!serializedCompileResult.inputFiles.containsKey(filename)) {
						schedule(filename, result, changedTypes, false);
					}
				});
				/*
				 * Scan the remaining output directory for class files that do
				 * no longer match the expected content and schedule their input
				 * files as changes
				 */
				Map<IPath, HashCode> outputDirectoryContent = processOutputDirectories();
				outputDirectoryContent.forEach((outputFile, currentHashCode) -> {
					HashCode hashCode = serializedCompileResult.outputFiles.get(outputFile);
					if (!currentHashCode.equals(hashCode)) {
						IPath filename = serializedCompileResult.outputToInputFile.remove(outputFile);
						schedule(filename, result, changedTypes, true);
					}
				});
				/*
				 * Check that all seemingly known class files are present.
				 * Schedule their input files if the class file is missing.
				 */
				serializedCompileResult.outputFiles.entrySet().removeIf(entry -> {
					IPath expectedOutputFile = entry.getKey();
					if (!outputDirectoryContent.containsKey(expectedOutputFile)) {
						IPath filename = serializedCompileResult.outputToInputFile.remove(expectedOutputFile);
						schedule(filename, result, changedTypes, false);
						return true;
					}
					return false;
				});
				/*
				 * Check that the class files for the unchanged input files are
				 * still present. If not, treat them as affected
				 */
				serializedCompileResult.inputFiles.forEach((filename, prevHashCode) -> {
					HashCode hashCode = inputFiles.get(filename);
					if (prevHashCode.equals(hashCode)) {
						IPath[] outputFiles = serializedCompileResult.inputToOutputFiles.get(filename);
						if (outputFiles != null
								&& !outputDirectoryContent.keySet().containsAll(Arrays.asList(outputFiles))) {
							schedule(filename, result, changedTypes, true);
						}
					}
				});
				/*
				 * Schedule all compilation units that are affected by the
				 * changed types
				 */
				for (String typeName : changedTypes) {
					addDependentsOf(new Path(typeName));
				}
				scheduleAffected(result);
				logCount(result.size(), "Everything up-to-date.");
				return result.toArray(new CompilationUnit[0]);
			} else {
				LOG.info("No valid previous result detected. Compile all source files.");
				deleteClassFiles();
				remainingCompilationUnits.clear();
				serializedCompileResult.outputFiles.clear();
				serializedCompileResult.inputToOutputFiles.clear();
				serializedCompileResult.outputToInputFile.clear();
				serializedCompileResult.referenceInformation.clear();
				serializedCompileResult.outputToTypeName.clear();
				logCount(allCompilationUnits.length, "No sources found.");
				return allCompilationUnits;
			}
		} finally {
			serializedCompileResult.inputFiles.clear();
			serializedCompileResult.inputFiles.putAll(inputFiles);
			serializedCompileResult.classpathArchiveHash = classpathArchiveHash;
			serializedCompileResult.classpathClassHashes = classpathClassHashes;
		}
	}

	private List<String> fineGrainedClasspathDiff() {
		deltas = new ArrayList<>();
		
		Stopwatch sw = Stopwatch.createStarted();
		List<String> result = new ArrayList<String>();
		MapDifference<IPath, HashCode> fineGrainedClasspathDiff = Maps.difference(classpathClassHashes, serializedCompileResult.classpathClassHashes);
		
		fineGrainedClasspathDiff.entriesOnlyOnLeft().keySet().forEach(fqn->result.add(fqn.toString()));
		fineGrainedClasspathDiff.entriesOnlyOnRight().keySet().forEach(fqn->result.add(fqn.toString()));
		fineGrainedClasspathDiff.entriesDiffering().keySet().forEach(fqn->result.add(fqn.toString()));
		if (result.size() > 0) {
			collectDeltas(indexClassFiles(serializedCompileResult.classpathClassHashes), indexClassFiles(classpathClassHashes));
		}
		LOG.trace("Compared class files on class-path in " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms");
		return result;
	}

	private void collectDeltas(Map<URI, ClassFileResourceDescription> oldDescriptions,
			Map<URI, ClassFileResourceDescription> newDescriptions) {
		MapDifference<URI,ClassFileResourceDescription> difference = Maps.difference(oldDescriptions, newDescriptions);
		for (ClassFileResourceDescription removed : difference.entriesOnlyOnLeft().values()) {
			deltas.add(new DefaultResourceDescriptionDelta(removed, null));
		}
		for (ClassFileResourceDescription added : difference.entriesOnlyOnRight().values()) {
			deltas.add(new DefaultResourceDescriptionDelta(null, added));
		}
		for (ValueDifference<ClassFileResourceDescription> diff : difference.entriesDiffering().values()) {
			deltas.add(new DefaultResourceDescriptionDelta(diff.leftValue(), diff.rightValue()));
		}
	}
	
	private Map<URI, ClassFileResourceDescription> indexClassFiles(Map<IPath, HashCode> fqnToHash) {
		if (fqnToHash.size() > 0) {
			Map<URI, ClassFileResourceDescription> result = new HashMap<>();
			SerializedCompilerState.collectResourceDescriptions(fqnToHash.keySet(), fqn->fqn.toString().replace('/', '.'), fqnToHash::get, result);
			return result;
		}
		return Collections.emptyMap();
	}

	private void logCount(int count, String zeroMessage) {
		switch (count) {
		case 0:
			LOG.info(zeroMessage);
			break;
		case 1:
			LOG.info("Found 1 source file to compile.");
			break;
		default:
			LOG.info("Found " + count + " source files to compile.");
			break;
		}
	}

	private void schedule(IPath filename, List<CompilationUnit> compilationUnits, List<String> changedTypes,
			boolean removeFromOutputFiles) {
		CompilationUnit compilationUnit = remainingCompilationUnits.remove(filename);
		if (compilationUnit != null) {
			LOG.debug("Add to build queue: " + filename);
			compilationUnits.add(compilationUnit);
		}
		serializedCompileResult.referenceInformation.remove(filename);
		IPath[] outputFiles = serializedCompileResult.inputToOutputFiles.remove(filename);
		if (outputFiles != null) {
			for (IPath prevClassFile : outputFiles) {
				String typeName = serializedCompileResult.outputToTypeName.remove(prevClassFile);
				if (typeName != null && changedTypes != null) {
					changedTypes.add(typeName);
				}
				serializedCompileResult.outputToInputFile.remove(prevClassFile);
				if (removeFromOutputFiles) {
					serializedCompileResult.outputFiles.remove(prevClassFile);
				}
				File file = prevClassFile.toFile();
				if (file.exists()) {
					LOG.debug("Delete outdated class file: " + prevClassFile);
					file.delete();
				}
			}
		}
	}

	private void deleteClassFiles() {
		Set<String> seen = new HashSet<>();
		seen.add(destinationPath);
		deleteClassFiles(this.destinationPath);
		for (String path : destinationPaths) {
			if (path != null && seen.add(path)) {
				deleteClassFiles(path);
			}
		}
	}

	private void deleteClassFiles(String filename) {
		Files.fileTraverser().breadthFirst(new File(filename)).forEach(file -> {
			if (file.isFile() && file.getName().endsWith(".class")) {
				LOG.debug("Delete outdated class file: " + file.getAbsolutePath());
				file.delete();
			}
		});
	}

	private Map<IPath, HashCode> processInputFiles(CompilationUnit[] allCompilationUnits) {
		LOG.trace("Scannning sources");
		Stopwatch sw = Stopwatch.createStarted();
		Map<IPath, HashCode> result = new HashMap<>();
		for (CompilationUnit compilationUnit : allCompilationUnits) {
			IPath filename = new Path(String.valueOf(compilationUnit.getFileName()));
			char[] contents = compilationUnit.getContents();
			try {
				HashCode hash = BinaryFileHashing.hashFunction().hashUnencodedChars(CharBuffer.wrap(contents));
				result.put(filename, hash);
				LOG.trace("Hashed source file " + filename.lastSegment() + " to " + hash);
			} catch (Exception e) {
				result.put(filename, BinaryFileHashing.unknownHashCode());
			} finally {
				remainingCompilationUnits.put(filename, compilationUnit);
			}
		}
		LOG.trace("Scanned sources in " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms");
		return result;
	}

	private Map<IPath, HashCode> processOutputDirectories() {
		LOG.trace("Scannning class directories");
		Stopwatch sw = Stopwatch.createStarted();
		Map<IPath, HashCode> result = new HashMap<>();
		Set<String> seen = new HashSet<>();
		seen.add(destinationPath);
		processOutputDirectory(this.destinationPath, result);
		for (String path : destinationPaths) {
			if (path != null && seen.add(path)) {
				processOutputDirectory(path, result);
			}
		}
		LOG.trace("Scanned class " + (seen.size() == 1 ? "directory" : "directories") + " in "
				+ sw.elapsed(TimeUnit.MILLISECONDS) + "ms");
		return result;
	}

	private static void processOutputDirectory(String directory, Map<IPath, HashCode> result) {
		LOG.debug("Scanning class directory " + directory);
		BinaryFileHashing.processDirectory(directory, result, ".class");
	}

	@Override
	public void outputClassFiles(org.eclipse.jdt.internal.compiler.CompilationResult unitResult) {
		if (serializedCompileResult != null) {
			hashCompiledClassFiles(unitResult);
		}
		super.outputClassFiles(unitResult);
	}

	private void hashCompiledClassFiles(org.eclipse.jdt.internal.compiler.CompilationResult unitResult) {
		ClassFile[] classFiles = unitResult.getClassFiles();
		if (classFiles != null) {
			IPath inputFilename = new Path(String.valueOf(unitResult.getFileName()));
			AccessibleReferenceCollection referenceCollection = new AccessibleReferenceCollection(
					unitResult.qualifiedReferences, unitResult.simpleNameReferences, unitResult.rootReferences);
			serializedCompileResult.referenceInformation.put(inputFilename, referenceCollection);
			String currentDestinationPath = null;
			CompilationUnit compilationUnit = (CompilationUnit) unitResult.compilationUnit;
			if (compilationUnit.destinationPath == null) {
				if (this.destinationPath == null) {
					currentDestinationPath = extractDestinationPathFromSourceFile(unitResult);
				} else if (this.destinationPath != NONE) {
					currentDestinationPath = this.destinationPath;
				}
			} else if (compilationUnit.destinationPath != NONE) {
				currentDestinationPath = compilationUnit.destinationPath;
			}
			if (currentDestinationPath != null) {
				List<IPath> paths = new ArrayList<>(classFiles.length);
				for (ClassFile classFile : classFiles) {
					char[] filename = classFile.fileName();
					if (filename != null) {
						String filenameString = new String(filename);
						addDependentsOf(new Path(filenameString));
						int length = filename.length;
						char[] relativeName = new char[length + 6];
						System.arraycopy(filename, 0, relativeName, 0, length);
						System.arraycopy(SuffixConstants.SUFFIX_class, 0, relativeName, length, 6);
						CharOperation.replace(relativeName, '/', File.separatorChar);
						String relativeStringName = new String(relativeName);

						Hasher hasher = newHasher();
						hasher.putBytes(classFile.header, 0, classFile.headerOffset);
						hasher.putBytes(classFile.contents, 0, classFile.contentsOffset);
						IPath outputFilename = new Path(currentDestinationPath).append(relativeStringName);
						HashCode hash = hasher.hash();
						serializedCompileResult.outputFiles.put(outputFilename, hash);
						LOG.trace("Hashed compiled class file " + outputFilename.lastSegment() + " to " + hash);

						paths.add(outputFilename);
						serializedCompileResult.outputToTypeName.put(outputFilename, filenameString);
						serializedCompileResult.outputToInputFile.put(outputFilename, inputFilename);
					} else {
						LOG.trace("EEEK");
					}
				}
				serializedCompileResult.inputToOutputFiles.put(inputFilename, paths.toArray(new IPath[0]));
			}
		}
	}

	private Hasher newHasher() {
		return BinaryFileHashing.hashFunction().newHasher();
	}

	@Override
	public void performCompilation() {
		if (stateDirectory == null) {
			super.performCompilation();
			eventListener.descriptionsChanged(new CoarseGrainedChangeEvent());
			return;
		}
		File stateFile = new File(stateDirectory, "java.state");
		serializedCompileResult = SerializedCompilerState.from(stateFile);
		Map<URI, ClassFileResourceDescription> originalIndex = eventListener != null
				? serializedCompileResult.resourceDescriptions()
				: null;
		int round = 1;
		do {
			this.qualifiedNames = new HashSet<>(3);
			this.simpleNames = new HashSet<>(3);
			this.rootNames = new HashSet<>(3);

			Stopwatch sw = Stopwatch.createStarted();
			super.performCompilation();
			LOG.trace("Compilation round " + round + " took " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms");
			sw.reset();
			sw.start();
			toCompile = scheduleAffected();
			LOG.trace("Finding affected source files took " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms");
			sw.stop();
			round++;
		} while (toCompile.length > 0);
		if (eventListener != null) {
			if (fullBuild) {
				eventListener.descriptionsChanged(new CoarseGrainedChangeEvent());
			} else {
				if (deltas == null) {
					deltas = new ArrayList<>();
				}
				Stopwatch sw = Stopwatch.createStarted();
				collectDeltas(originalIndex, serializedCompileResult.resourceDescriptions());
				LOG.trace("Compared Xtext index for compiled Java files in " + sw.elapsed(TimeUnit.MILLISECONDS) + "ms");
				eventListener.descriptionsChanged(new ResourceDescriptionChangeEvent(deltas));
			}
		}
		serializedCompileResult.to(stateFile, rootStopwatch);
	}

	@Override
	public boolean compile(String[] argv) {
		rootStopwatch = Stopwatch.createStarted();
		try {
			return super.compile(argv);
		} finally {
			long duration = rootStopwatch.elapsed(TimeUnit.MILLISECONDS);
			LOG.info("Compilation took " + duration + "ms.");
			LOG.info("Detected up-to-date source files: " + remainingCompilationUnits.size());
			if (duration != serializedCompileResult.duration) {
				LOG.info("Estimated time saved: " + Math.max(0, serializedCompileResult.duration - duration) + "ms.");
			}
		}
	}
}