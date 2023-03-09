/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.compiler;

import static org.eclipse.xtext.util.Strings.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.eclipse.xtext.builder.standalone.incremental.ClasspathInfos;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class EclipseJavaCompiler implements IJavaCompiler {

	private static final Logger LOG = Logger.getLogger(EclipseJavaCompiler.class);
	
	@Inject
	private CompilerConfiguration configuration;
	@Inject
	private ClasspathInfos classpathInfos;
	
	private Iterable<String> classPath;

	private Writer errorWriter;
	private Writer outputWriter;

	@Override
	public CompilationResult compile(Iterable<String> sourceRoots, File outputClassDirectory) {
		Iterable<String> validSourceRoots = IterableExtensions.filter(sourceRoots, new EmptyOrMissingFilter());
		if (!containsJavaFiles(validSourceRoots)) {
			return CompilationResult.SKIPPED;
		}
		List<String> commandLine = Lists.newArrayList();
		if (configuration.isVerbose()) {
			commandLine.add("-verbose");
		}
		if (configuration.isSkipAnnotationProcessing()) {
			commandLine.add("-proc:none");
		}
		if (configuration.isPreserveInformationAboutFormalParameters()) {
			commandLine.add("-parameters");
		}
		if (classPath != null) {
			List<String> validClasspath = new ArrayList<String>();
			Iterables.addAll(validClasspath, IterableExtensions.filter(classPath, new EmptyOrMissingFilter()));
			if (!validClasspath.isEmpty()) {
				commandLine.add("-cp \"" + concat(File.pathSeparator, validClasspath) + "\"");
			}
		}
		commandLine.add("-d \"" + outputClassDirectory.getAbsolutePath() + "\"");
		commandLine.add("-source " + configuration.getSourceLevel());
		commandLine.add("-target " + configuration.getTargetLevel());
		commandLine.add("-proceedOnError");
		for (String src : validSourceRoots) {
			commandLine.add("\"" + src + "\"");
		}
		String cmdLine = concat(" ", commandLine);
		debugLog("invoke batch compiler with '" + cmdLine + "'");
		boolean result = compile(cmdLine);
		return result ? CompilationResult.SUCCEEDED : CompilationResult.FAILED;
	}

	private boolean compile(String cmdLine) {
		String[] tokenizedCommandLine = Main.tokenize(cmdLine);

		return newCompiler().compile(tokenizedCommandLine);
	}

	@SuppressWarnings("resource")
	private Main newCompiler() {
		File stateDirectory = getConfiguration().getCompilerStateDirectory();
		IResourceDescription.Event.Listener eventListener = getConfiguration().getEventListener();
		if (stateDirectory == null && eventListener == null) {
			return new Main(new PrintWriter(getOutputWriter()), new PrintWriter(getErrorWriter()),
					false /* systemExit */, null /* options */, null);
		} else {
			LOG.info("Perform incremental compilation");
			return new InternalIncrementalCompiler(getOutputWriter(), getErrorWriter(), stateDirectory, eventListener, classpathInfos);
		}
	}

	public Writer getOutputWriter() {
		if (outputWriter == null) {
			outputWriter = new Writer() {
				@Override
				public void write(char[] data, int offset, int count) throws IOException {
					String message = String.copyValueOf(data, offset, count);
					if (!Strings.isEmpty(message.trim())) {
						if (configuration.isVerbose())
							LOG.info(message);
					}
				}

				@Override
				public void flush() throws IOException {
				}

				@Override
				public void close() throws IOException {
				}
			};
		}
		return outputWriter;
	}

	public void setOutputWriter(Writer ouputWriter) {
		this.outputWriter = ouputWriter;
	}

	public Writer getErrorWriter() {
		if (errorWriter == null) {
			errorWriter = new Writer() {
				@Override
				public void write(char[] data, int offset, int count) throws IOException {
					String message = String.copyValueOf(data, offset, count);
					if (!Strings.isEmpty(message.trim())) {
						if (configuration.isVerbose())
							LOG.warn(message);
					}
				}

				@Override
				public void flush() throws IOException {
				}

				@Override
				public void close() throws IOException {
				}
			};
		}
		return errorWriter;
	}

	public void setErrorWriter(Writer errorWriter) {
		this.errorWriter = errorWriter;
	}

	@Override
	public void setClassPath(Iterable<String> classPath) {
		this.classPath = classPath;
	}

	private boolean containsJavaFiles(Iterable<String> roots) {
		final String javaExt = "java";
		Multimap<String, URI> uris = new PathTraverser().resolvePathes(Lists.newArrayList(roots), new Predicate<URI>() {
			@Override
			public boolean apply(URI input) {
				return javaExt.equals(input.fileExtension());
			}
		});
		return uris.values().size() > 0;
	}

	/**
	 * @author Dennis Huebner - Initial contribution and API
	 */
	private final class EmptyOrMissingFilter implements Function1<String, Boolean> {

		@Override
		public Boolean apply(final String path) {
			final File file = new File(path);
			boolean useEntry = file.exists();
			if (!useEntry) {
				debugLog("File \'" + path + "\' is missing. Skipping.");
			}
			return useEntry;
		}

	}

	private void debugLog(final String message) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(message);
		} else if (configuration.isVerbose()) {
			LOG.info(message);
		}
	}

	@Override
	public CompilerConfiguration getConfiguration() {
		return configuration;
	}
}
