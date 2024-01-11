/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.maven;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.xtext.util.Strings.concat;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Goal which compiles Xtend sources.
 * 
 * @author Michael Clay - Initial contribution and API
 */
@Mojo (name="compile", defaultPhase=LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution=ResolutionScope.COMPILE, threadSafe=true)
public class XtendCompile extends AbstractXtendCompilerMojo {
	/**
	 * Location of the generated source files.
	 */
	@Parameter(defaultValue="${basedir}/src/main/generated-sources/xtend", required=true)
	private String outputDirectory;
	/**
	 * Location of the temporary compiler directory.
	 */
	@Parameter(defaultValue="${project.build.directory}/xtend", required=true)
	private String tempDirectory;

	@Override
	protected void internalExecute() throws MojoExecutionException {
		final String defaultValue = project.getBasedir() + "/src/main/generated-sources/xtend";
		getLog().debug("Output directory '" + outputDirectory + "'");
		getLog().debug("Default directory '" + defaultValue + "'");
		// IF output is not explicitly set try to read xtend prefs from eclipse .settings folder
		if (defaultValue.equals(outputDirectory)) {
			readXtendEclipseSetting(project.getBuild().getSourceDirectory(), new Procedure1<String>() {
				public void apply(String xtendOutputDir) {
					outputDirectory = xtendOutputDir;
					getLog().info("Using Xtend output directory '" + outputDirectory + "'");
				}
			});
		}
		outputDirectory = resolveToBaseDir(outputDirectory);
		List<String> compileSourceRoots = Lists.newArrayList(project.getCompileSourceRoots());
		compileSourceRoots.remove(outputDirectory);
		String classPath = concat(File.pathSeparator, getClassPath());
		project.addCompileSourceRoot(outputDirectory);
		compile(classPath, compileSourceRoots, outputDirectory);
	}

	protected List<String> getClassPath() {
		Set<String> classPath = Sets.newLinkedHashSet();
		classPath.add(project.getBuild().getSourceDirectory());
		try {
			classPath.addAll(project.getCompileClasspathElements());
		} catch (DependencyResolutionRequiredException e) {
			throw new WrappedException(e);
		}
		classPath.remove(project.getBuild().getOutputDirectory());
		return newArrayList(filter(classPath, FILE_EXISTS));
	}

	@Override
	protected String getTempDirectory() {
		return tempDirectory;
	}

}
