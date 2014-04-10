package org.eclipse.xtend.maven;

import java.io.File;
import java.util.List;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.google.common.collect.Multimap;

/**
 * Goal which installs debug information into Java class files that have been generated from Xtend.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @goal xtend-test-install-debug-info
 * @phase process-test-classes
 * @requiresDependencyResolution compile
 */
public class XtendTestInstallDebugInfo extends AbstractXtendInstallDebugInfoMojo {

	@Override
	protected void installDebugInfo() throws MojoExecutionException, MojoFailureException {
		List<String> compileSourceRoots = project.getTestCompileSourceRoots();
		String outputDirectory = project.getBuild().getTestOutputDirectory();
		Multimap<File, File> trace2class = createTraceToClassFileMap(compileSourceRoots, outputDirectory);
		logStatus(outputDirectory, trace2class);
		installTraces(trace2class);
	}
}
