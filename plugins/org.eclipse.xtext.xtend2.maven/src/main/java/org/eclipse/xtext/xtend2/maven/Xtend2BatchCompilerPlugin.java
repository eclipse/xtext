/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.maven;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.xtext.util.Strings.concat;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.compiler.batch.Xtend2BatchCompiler;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Injector;

/**
 * Goal which compiles Xtend2 sources.
 * 
 * @goal compile
 * @requiresDependencyResolution test
 * @phase process-sources
 */
public class Xtend2BatchCompilerPlugin extends AbstractMojo {
	private static final Predicate<String> FILE_EXISTS = new Predicate<String>() {

		public boolean apply(String filePath) {
			return new File(filePath).exists();
		}
	};
	/**
	 * Location of the generated source files.
	 * 
	 * @parameter default-value="${basedir}/src/main/xtend2-gen"
	 * @required
	 */
	private String outputDirectory;
	/**
	 * Location of the generated test files.
	 * 
	 * @parameter default-value="${basedir}/src/test/xtend2-gen"
	 * @required
	 */
	private String testOutputDirectory;
	/**
	 * Location of the temporary compiler directory.
	 * 
	 * @parameter default-value="${project.build.directory}/xtend2"
	 * @required
	 */
	private String tempDirectory;

	/**
	 * The project itself. This parameter is set by maven.
	 * 
	 * @parameter expression="${project}"
	 * @required
	 */
	protected MavenProject project;

	public void execute() throws MojoExecutionException {
		configureLog4j();
		Xtend2BatchCompiler xtend2BatchCompiler = createXtend2BatchCompiler();
		compileSources(xtend2BatchCompiler);
		compileTestSources(xtend2BatchCompiler);
	}

	protected Xtend2BatchCompiler createXtend2BatchCompiler() {
		Injector injector = new Xtend2StandaloneSetup().createInjectorAndDoEMFRegistration();
		return injector.getInstance(Xtend2BatchCompiler.class);
	}

	private void compileSources(Xtend2BatchCompiler xtend2BatchCompiler) throws MojoExecutionException {
		String sourceDirectory = project.getBuild().getSourceDirectory();
		String classPath = concat(File.pathSeparator, getClassPath());
		project.addCompileSourceRoot(outputDirectory);
		compile(xtend2BatchCompiler, classPath, Collections.singletonList(sourceDirectory), outputDirectory);
	}

	private void compileTestSources(Xtend2BatchCompiler xtend2BatchCompiler) throws MojoExecutionException {
		String sourceDirectory = project.getBuild().getSourceDirectory();
		String testSourceDirectory = project.getBuild().getTestSourceDirectory();
		String testClassPath = concat(File.pathSeparator, getTestClassPath());
		project.addTestCompileSourceRoot(testOutputDirectory);
		compile(xtend2BatchCompiler, testClassPath, newArrayList(sourceDirectory, testSourceDirectory),
				testOutputDirectory);
	}

	private void compile(Xtend2BatchCompiler xtend2BatchCompiler, String classPath, List<String> sourceDirectories,
			String outputPath) throws MojoExecutionException {
		Iterable<String> filtered = filter(sourceDirectories, FILE_EXISTS);
		if (Iterables.isEmpty(filtered)) {
			getLog().info(
					"skip compiling sources because (test)sourceDirectory '" + Iterables.toString(sourceDirectories)
							+ "' does not exists.");
			return;
		}
		xtend2BatchCompiler.setTempDirectory(tempDirectory);
		xtend2BatchCompiler.setDeleteTempDirectory(false);
		xtend2BatchCompiler.setClassPath(classPath);
		xtend2BatchCompiler.setSourcePath(concat(File.pathSeparator, newArrayList(filtered)));
		xtend2BatchCompiler.setOutputPath(outputPath);
		if (!xtend2BatchCompiler.compile()) {
			throw new MojoExecutionException("Error compiling xtend sources in '"
					+ concat(File.pathSeparator, newArrayList(filtered)) + "'.");
		}
	}

	private void configureLog4j() {
		if (!Logger.getRootLogger().getAllAppenders().hasMoreElements()) {
			Logger.getRootLogger().setLevel(Level.DEBUG);
			Logger.getRootLogger().addAppender(createMojoLogAppender());
		} else {
			Logger logger = Logger.getLogger("org.eclipse.xtext");
			logger.setAdditivity(false);
			logger.setLevel(Level.DEBUG);
			logger.removeAllAppenders();
			logger.addAppender(createMojoLogAppender());
		}
	}

	private AppenderSkeleton createMojoLogAppender() {
		return new AppenderSkeleton() {

			public void close() {
			}

			public boolean requiresLayout() {
				return false;
			}

			@Override
			protected void append(LoggingEvent event) {
				if (event.getMessage() == null) {
					return;
				}
				if (Level.DEBUG == event.getLevel()) {
					getLog().debug((CharSequence) event.getMessage(), getThrowable(event));
				} else if (Level.INFO == event.getLevel()) {
					getLog().info((CharSequence) event.getMessage(), getThrowable(event));
				} else if (Level.WARN == event.getLevel()) {
					getLog().warn((CharSequence) event.getMessage(), getThrowable(event));
				} else if (Level.ERROR == event.getLevel()) {
					getLog().error((CharSequence) event.getMessage(), getThrowable(event));
				}
			}

			private Throwable getThrowable(LoggingEvent event) {
				return event.getThrowableInformation() != null ? event.getThrowableInformation().getThrowable() : null;
			}
		};
	}

	@SuppressWarnings("unchecked")
	private List<String> getClassPath() {
		Set<String> classPath = Sets.newLinkedHashSet();
		classPath.add(project.getBuild().getSourceDirectory());
		try {
			classPath.addAll(project.getCompileClasspathElements());
		} catch (DependencyResolutionRequiredException e) {
			throw new WrappedException(e);
		}
		addDependencies(classPath, project.getCompileArtifacts());
		return newArrayList(filter(classPath, FILE_EXISTS));
	}

	@SuppressWarnings("unchecked")
	private List<String> getTestClassPath() {
		Set<String> classPath = Sets.newLinkedHashSet();
		classPath.add(project.getBuild().getSourceDirectory());
		classPath.add(project.getBuild().getTestSourceDirectory());
		try {
			classPath.addAll(project.getTestClasspathElements());
		} catch (DependencyResolutionRequiredException e) {
			throw new WrappedException(e);
		}
		addDependencies(classPath, project.getTestArtifacts());
		return newArrayList(filter(classPath, FILE_EXISTS));
	}

	private void addDependencies(Set<String> classPath, List<Artifact> dependencies) {
		for (Artifact artifact : dependencies) {
			classPath.add(artifact.getFile().getAbsolutePath());
		}
	}
}
