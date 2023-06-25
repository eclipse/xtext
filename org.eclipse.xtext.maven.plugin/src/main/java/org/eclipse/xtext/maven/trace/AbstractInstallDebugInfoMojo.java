/*******************************************************************************
 * Copyright (c) 2021, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.maven.trace;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceToBytecodeInstaller;
import org.eclipse.xtext.generator.trace.TraceAsPrimarySourceInstaller;
import org.eclipse.xtext.generator.trace.TraceAsSmapInstaller;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.maven.AbstractXtextMojo;
import org.eclipse.xtext.maven.Language;
import org.eclipse.xtext.maven.MavenLog4JConfigurator;
import org.eclipse.xtext.maven.MavenStandaloneBuilderModule;
import org.eclipse.xtext.resource.FileExtensionProvider;

import com.google.common.io.Files;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @since 2.26
 * @author Heinrich Weichert - initial contribution and API
 */
public abstract class AbstractInstallDebugInfoMojo extends AbstractXtextMojo {

	@Inject
	private Provider<TraceAsPrimarySourceInstaller> traceAsPrimarySourceInstallerProvider;
	@Inject
	private Provider<TraceAsSmapInstaller> traceAsSmapInstaller;
	@Inject
	private TraceRegionSerializer traceRegionSerializer;
	@Inject
	private ClassFileDebugSourceExtractor debugSourceExtractor;

	@Parameter(property = "project.basedir")
	private File baseDirectory;

	@Override
	public void execute() throws MojoExecutionException {

		synchronized (lock) {

			new MavenLog4JConfigurator().configureLog4j(getLog());

			Injector injector = Guice.createInjector(new MavenStandaloneBuilderModule());
			injector.injectMembers(this);

			for (Language language : getLanguages()) {

				Set<OutputConfiguration> outputConfigurations = language.getOutputConfigurations();
				if (outputConfigurations == null) {
					getLog().warn("No output configurations available for language " + language.getSetup()
							+ ", assuming default layout and using SMAP trace.");
					outputConfigurations = new OutputConfigurationProvider().getOutputConfigurations();
				}

				try {
					Class<?> setup = getClass().getClassLoader().loadClass(language.getSetup());
					ISetup languageSetup = (ISetup) setup.getDeclaredConstructor().newInstance();
					Injector languageInjector = languageSetup.createInjectorAndDoEMFRegistration();
					FileExtensionProvider fileExtensionProvider = languageInjector
							.getInstance(FileExtensionProvider.class);
					TraceFileNameProvider traceFileNameProvider = languageInjector
							.getInstance(TraceFileNameProvider.class);

					for (OutputConfiguration config : outputConfigurations) {
						ITraceToBytecodeInstaller traceInstaller = getTraceInstaller(config);
						List<Trace> traces = createTraceInformation(getOutputDirectories(config),
								traceFileNameProvider);
						installTraces(fileExtensionProvider.getFileExtensions(), traceInstaller, traces,
								traceFileNameProvider);
					}

				} catch (Exception e) {
					throw new MojoExecutionException("Failed to install traces for " + language.getSetup(), e);
				}
			}
		}
	}

	private Set<File> getOutputDirectories(OutputConfiguration config) {
		return config.getOutputDirectories().stream().map(this::resolveFilePath).collect(Collectors.toSet());
	}

	protected abstract File getOutputDirectory();

	private ITraceToBytecodeInstaller getTraceInstaller(OutputConfiguration config) {
		ITraceToBytecodeInstaller bytecodeInstaller = config.isInstallDslAsPrimarySource()
				? traceAsPrimarySourceInstallerProvider.get()
				: traceAsSmapInstaller.get();
		if (bytecodeInstaller instanceof TraceAsPrimarySourceInstaller) {
			boolean hideSyntheticLocalVariables = config.isHideSyntheticLocalVariables();
			((TraceAsPrimarySourceInstaller) bytecodeInstaller).setHideSyntheticVariables(hideSyntheticLocalVariables);
		}
		return bytecodeInstaller;
	}

	/**
	 * Holds information for an {@link ITraceToBytecodeInstaller}
	 *
	 */
	private class Trace {
		File traceFile;
		File classFile;
	}

	protected void collectTraceInformationForClassFiles(File sourceFolder, List<Trace> traces,
			TraceFileNameProvider traceFileNameProvider) throws IOException {

		File root = getOutputDirectory();
		if (!root.exists()) {
			getLog().info("Unable to attach trace files, output directory " + root + " does not exist");
			return;
		}

		try (Stream<Path> walker = java.nio.file.Files.walk(root.toPath())) {
			walker.forEach(path -> {
				File file = path.toFile();
				boolean isClassFile = "class".equals(Files.getFileExtension(file.getName()));
				if (isClassFile) {
					try {
						String javaSourceName = debugSourceExtractor.getDebugSourceFileName(file);
						Path relativeJavaFilePath = root.toPath().relativize(path);
						Path srcGenRelativeFolder = sourceFolder.toPath().resolve(relativeJavaFilePath).getParent();
						Path javaFilePath = srcGenRelativeFolder.resolve(javaSourceName);
						if (javaFilePath.toFile().exists()) {
							String traceFileName = traceFileNameProvider
									.getTraceFromJava(javaFilePath.toFile().getName());
							Path traceFilePath = srcGenRelativeFolder.resolve(traceFileName);
							if (traceFilePath.toFile().exists()) {
								Trace trace = new Trace();
								trace.classFile = file;
								trace.traceFile = traceFilePath.toFile();
								traces.add(trace);
							} else {
								getLog().debug("Trace file for file " + file + "not found");
							}
						}
					} catch (Exception e) {
						getLog().error("Failed to analyze file " + file, e);
					}

				}
			});
		}
	}

	private List<Trace> createTraceInformation(Set<File> sourceDirectories, TraceFileNameProvider traceFileNameProvider)
			throws IOException {

		List<Trace> traces = new ArrayList<>();
		for (File sourceDirectory : sourceDirectories) {
			collectTraceInformationForClassFiles(sourceDirectory, traces, traceFileNameProvider);
		}

		return traces;
	}

	private void installTrace(Set<String> fileExtensions, ITraceToBytecodeInstaller traceToBytecodeInstaller,
			Trace trace, TraceFileNameProvider traceFileNameProvider) throws IOException {

		File traceFile = trace.traceFile;
		File classFile = trace.classFile;

		try (InputStream fis = new FileInputStream(traceFile); BufferedInputStream in = new BufferedInputStream(fis)) {

			AbstractTraceRegion traceRegion = traceRegionSerializer.readTraceRegionFrom(in);
			if (!isRelevantFile(fileExtensions, traceRegion)) {
				return;
			}
			traceToBytecodeInstaller.setTrace(traceFileNameProvider.getJavaFromTrace(traceFile.getName()), traceRegion);
			if (getLog().isDebugEnabled()) {
				getLog().debug("Installing trace " + traceFile + " into:");
			}
			byte[] bytecodeWithTraces = traceToBytecodeInstaller.installTrace(Files.toByteArray(classFile));
			if (bytecodeWithTraces != null) {
				Files.write(bytecodeWithTraces, classFile);
				if (getLog().isDebugEnabled()) {
					getLog().debug("  " + classFile);
				}
			} else {
				if (getLog().isDebugEnabled()) {
					getLog().debug("  No trace installed for " + classFile);
				}
			}
		}

	}

	protected void installTraces(Set<String> fileExtensions, ITraceToBytecodeInstaller traceToBytecodeInstaller,
			List<Trace> traceToClassFileMap, TraceFileNameProvider traceFileNameProvider) {
		for (Trace trace : traceToClassFileMap) {
			try {
				installTrace(fileExtensions, traceToBytecodeInstaller, trace, traceFileNameProvider);
			} catch (Exception e) {
				getLog().error("Error installing trace into " + trace.classFile, e);
			}
		}
	}

	protected boolean isRelevantFile(Set<String> fileExtensions, AbstractTraceRegion traceRegion) {
		String fileExtension = traceRegion.getAssociatedSrcRelativePath().getURI().fileExtension();
		return fileExtensions.contains(fileExtension);
	}

}