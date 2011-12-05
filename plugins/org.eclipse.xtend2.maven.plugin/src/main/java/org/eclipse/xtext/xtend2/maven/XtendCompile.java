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
 * Goal which compiles Xtend2 sources.
 * 
 * @goal compile
 * @phase generate-sources
 * @requiresDependencyResolution compile
 */
public class XtendCompile extends AbstractXtend2CompilerMojo {
	/**
	 * Location of the generated source files.
	 * 
	 * @parameter default-value="${basedir}/src/main/xtend-gen"
	 * @required
	 */
	private String outputDirectory;
	/**
	 * Location of the temporary compiler directory.
	 * 
	 * @parameter default-value="${project.build.directory}/xtend"
	 * @required
	 */
	private String tempDirectory;

	@Override
	protected void internalExecute(Xtend2BatchCompiler xtend2BatchCompiler) throws MojoExecutionException {
		compileSources(xtend2BatchCompiler);
	}

	private void compileSources(Xtend2BatchCompiler xtend2BatchCompiler) throws MojoExecutionException {
		String sourceDirectory = project.getBuild().getSourceDirectory();
		String classPath = concat(File.pathSeparator, getClassPath());
		project.addCompileSourceRoot(outputDirectory);
		compile(xtend2BatchCompiler, classPath, Collections.singletonList(sourceDirectory), outputDirectory);
	}


	@SuppressWarnings("unchecked")
	protected List<String> getClassPath() {
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

	
	@Override
	protected String getTempDirectory() {
		return tempDirectory;
	}

}
