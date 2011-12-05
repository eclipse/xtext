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
import java.util.List;
import java.util.Set;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.compiler.batch.Xtend2BatchCompiler;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;

public abstract class AbstractXtend2CompilerMojo extends AbstractMojo {
	protected static final Predicate<String> FILE_EXISTS = new Predicate<String>() {

		public boolean apply(String filePath) {
			return new File(filePath).exists();
		}
	};
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
		internalExecute(xtend2BatchCompiler);
	}

	protected abstract void internalExecute(Xtend2BatchCompiler xtend2BatchCompiler) throws MojoExecutionException;

	protected Xtend2BatchCompiler createXtend2BatchCompiler() {
		Injector injector = new Xtend2StandaloneSetup().createInjectorAndDoEMFRegistration();
		return injector.getInstance(Xtend2BatchCompiler.class);
	}

	protected void compile(Xtend2BatchCompiler xtend2BatchCompiler, String classPath, List<String> sourceDirectories,
			String outputPath) throws MojoExecutionException {
		Iterable<String> filtered = filter(sourceDirectories, FILE_EXISTS);
		if (Iterables.isEmpty(filtered)) {
			getLog().info(
					"skip compiling sources because (test)sourceDirectory '" + Iterables.toString(sourceDirectories)
							+ "' does not exists.");
			return;
		}
		xtend2BatchCompiler.setTempDirectory(getTempDirectory());
		xtend2BatchCompiler.setDeleteTempDirectory(false);
		xtend2BatchCompiler.setClassPath(classPath);
		xtend2BatchCompiler.setSourcePath(concat(File.pathSeparator, newArrayList(filtered)));
		xtend2BatchCompiler.setOutputPath(outputPath);
		if (!xtend2BatchCompiler.compile()) {
			throw new MojoExecutionException("Error compiling xtend sources in '"
					+ concat(File.pathSeparator, newArrayList(filtered)) + "'.");
		}
	}

	protected abstract String getTempDirectory();

	protected void configureLog4j() {
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

	protected AppenderSkeleton createMojoLogAppender() {
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

	protected void addDependencies(Set<String> classPath, List<Artifact> dependencies) {
		for (Artifact artifact : dependencies) {
			classPath.add(artifact.getFile().getAbsolutePath());
		}
	}
}
