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
 * Goal which compiles Xtend2 test sources.
 * 
 * @author Michael Clay - Initial contribution and API
 */
@Mojo(name="testCompile", defaultPhase=LifecyclePhase.GENERATE_TEST_SOURCES, requiresDependencyResolution=ResolutionScope.TEST, threadSafe=true)
public class XtendTestCompile extends AbstractXtendCompilerMojo {
	/**
	 * Location of the generated test files.
	 */
	@Parameter(defaultValue="${basedir}/src/test/generated-sources/xtend", required=true)
	private String testOutputDirectory;
	/**
	 * Location of the temporary compiler directory.
	 */
	@Parameter(defaultValue="${project.build.directory}/xtend-test", required=true)
	private String testTempDirectory;

	@Override
	protected void internalExecute() throws MojoExecutionException {
		final String defaultValue = project.getBasedir() + "/src/test/generated-sources/xtend";
		getLog().debug("Output directory '" + testOutputDirectory + "'");
		getLog().debug("Default directory '" + defaultValue + "'");
		if (defaultValue.equals(testOutputDirectory)) {
			readXtendEclipseSetting(project.getBuild().getTestSourceDirectory(), new Procedure1<String>() {
				public void apply(String xtendOutputDir) {
					testOutputDirectory = xtendOutputDir;
					getLog().info("Using Xtend output directory '" + testOutputDirectory + "'");
				}
			});
		}
		testOutputDirectory = resolveToBaseDir(testOutputDirectory);
		List<String> testCompileSourceRoots = Lists.newArrayList(project.getTestCompileSourceRoots());
		testCompileSourceRoots.remove(testOutputDirectory);
		String testClassPath = concat(File.pathSeparator, getTestClassPath());
		project.addTestCompileSourceRoot(testOutputDirectory);
		compile(testClassPath, testCompileSourceRoots, testOutputDirectory);
	}

	protected List<String> getTestClassPath() {
		Set<String> classPath = Sets.newLinkedHashSet();
		classPath.add(project.getBuild().getTestSourceDirectory());
		try {
			classPath.addAll(project.getTestClasspathElements());
		} catch (DependencyResolutionRequiredException e) {
			throw new WrappedException(e);
		}
		classPath.remove(project.getBuild().getTestOutputDirectory());
		return newArrayList(filter(classPath, FILE_EXISTS));
	}

	@Override
	protected String getTempDirectory() {
		return testTempDirectory;
	}

}
