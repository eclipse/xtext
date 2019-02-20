package org.eclipse.xtend.maven;

import java.io.File;
import java.util.List;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

import com.google.common.collect.Multimap;

/**
 * Goal which installs debug information into Java class files that have been generated from Xtend.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Mojo(name="xtend-install-debug-info", defaultPhase=LifecyclePhase.PROCESS_CLASSES, requiresDependencyResolution=ResolutionScope.COMPILE, threadSafe=true)
public class XtendInstallDebugInfo extends AbstractXtendInstallDebugInfoMojo {

	@Override
	protected void internalExecute() {
		List<String> compileSourceRoots = project.getCompileSourceRoots();
		String outputDirectory = project.getBuild().getOutputDirectory();
		Multimap<File, File> trace2class = createTraceToClassFileMap(compileSourceRoots, outputDirectory);
		logStatus(outputDirectory, trace2class);
		installTraces(trace2class);
	}

}
