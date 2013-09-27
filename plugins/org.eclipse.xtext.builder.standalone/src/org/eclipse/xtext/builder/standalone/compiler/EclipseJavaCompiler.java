/**
 * 
 */
package org.eclipse.xtext.builder.standalone.compiler;

import static org.eclipse.xtext.util.Strings.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.compiler.batch.BatchCompiler;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class EclipseJavaCompiler implements IJavaCompiler {

	@Inject
	private CompilerConfiguration configuration;
	private Iterable<String> classPath;

	private Writer errorWriter;
	private Writer outputWriter;
	private static final Logger LOG = Logger.getLogger(EclipseJavaCompiler.class);

	public CompilationResult compile(Iterable<String> sourceRoots, File outputClassDirectory) {
		Iterable<String> validSourceRoots = IterableExtensions.filter(sourceRoots, new EmptyOrMissingFilter());
		if (!containsJavaFiles(validSourceRoots)) {
			return CompilationResult.SKIPPED;
		}
		List<String> commandLine = Lists.newArrayList();
		if (configuration.isVerbose()) {
			commandLine.add("-verbose");
		}
		if (classPath != null) {
			Iterable<String> validClasspath = IterableExtensions.filter(classPath, new EmptyOrMissingFilter());
			if (validClasspath.iterator().hasNext()) {
				commandLine.add("-cp \"" + concat(File.pathSeparator, Lists.newArrayList(validClasspath)) + "\"");
			}
		}
		commandLine.add("-d \"" + outputClassDirectory.toString() + "\"");
		commandLine.add("-source " + configuration.getSourceLevel());
		commandLine.add("-target " + configuration.getTargetLevel());
		commandLine.add("-proceedOnError");
		commandLine.add(IterableExtensions.join(validSourceRoots, " "));
		String cmdLine = concat(" ", commandLine);
		if (LOG.isDebugEnabled()) {
			// FIXME any debug logs when using -X-e in maven
			LOG.debug("invoke batch compiler with '" + cmdLine + "'");
		}
		boolean result = BatchCompiler.compile(cmdLine, new PrintWriter(getOutputWriter()), new PrintWriter(
				getErrorWriter()), null);
		return result ? CompilationResult.SUCCEEDED : CompilationResult.FAILED;
	}

	public Writer getOutputWriter() {
		if (outputWriter == null) {
			outputWriter = new Writer() {
				@Override
				public void write(char[] data, int offset, int count) throws IOException {
					String message = String.copyValueOf(data, offset, count);
					if (!Strings.isEmpty(message.trim())) {
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

	public void setClassPath(Iterable<String> classPath) {
		this.classPath = classPath;
	}

	private boolean containsJavaFiles(Iterable<String> roots) {
		final String javaExt = "java";
		Multimap<String, URI> uris = new PathTraverser().resolvePathes(Lists.newArrayList(roots), new Predicate<URI>() {
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

		public Boolean apply(final String path) {
			final File file = new File(path);
			boolean useEntry = file.exists();
			if (LOG.isDebugEnabled() && !useEntry) {
				LOG.debug("File \'" + path + "\' is missing. Skipping.");
			}
			return useEntry;
		}

	}

	public CompilerConfiguration getConfiguration() {
		return configuration;
	}
}
