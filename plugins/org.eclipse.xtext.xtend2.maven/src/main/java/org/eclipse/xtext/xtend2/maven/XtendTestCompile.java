package org.eclipse.xtext.xtend2.maven;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.xtext.util.Strings.concat;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.MojoExecutionException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.xtend2.compiler.batch.Xtend2BatchCompiler;

import com.google.common.collect.Sets;

/**
 * Goal which compiles Xtend2 test sources.
 * 
 * @goal testCompile
 * @phase generate-test-sources
 * @requiresDependencyResolution test
 */
public class XtendTestCompile extends AbstractXtend2CompilerMojo {
	/**
	 * Location of the generated test files.
	 * 
	 * @parameter default-value="${basedir}/src/test/xtend-gen"
	 * @required
	 */
	private String testOutputDirectory;
	/**
	 * Location of the temporary compiler directory.
	 * 
	 * @parameter default-value="${project.build.directory}/xtend-test"
	 * @required
	 */
	private String testTempDirectory;

	@Override
	protected void internalExecute(Xtend2BatchCompiler xtend2BatchCompiler) throws MojoExecutionException {
		compileTestSources(xtend2BatchCompiler);
	}

	protected void compileTestSources(Xtend2BatchCompiler xtend2BatchCompiler) throws MojoExecutionException {
		String testSourceDirectory = project.getBuild().getTestSourceDirectory();
		String testClassPath = concat(File.pathSeparator, getTestClassPath());
		project.addTestCompileSourceRoot(testOutputDirectory);
		compile(xtend2BatchCompiler, testClassPath, Collections.singletonList(testSourceDirectory), testOutputDirectory);
	}

	@SuppressWarnings("unchecked")
	protected List<String> getTestClassPath() {
		Set<String> classPath = Sets.newLinkedHashSet();
		classPath.add(project.getBuild().getTestSourceDirectory());
		try {
			classPath.addAll(project.getTestClasspathElements());
		} catch (DependencyResolutionRequiredException e) {
			throw new WrappedException(e);
		}
		addDependencies(classPath, project.getTestArtifacts());
		return newArrayList(filter(classPath, FILE_EXISTS));
	}

	@Override
	protected String getTempDirectory() {
		return testTempDirectory;
	}

}
