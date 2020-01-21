package org.eclipse.xtext.maven;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Sets.newLinkedHashSet;

import java.util.List;
import java.util.Set;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution = ResolutionScope.COMPILE, threadSafe = true)
public class XtextGenerateMojo extends AbstractXtextGeneratorMojo {

	/**
	 * Project classpath.
	 */
	@Parameter(defaultValue = "${project.compileClasspathElements}", readonly = true, required = true)
	private List<String> classpathElements;

	public Set<String> getClasspathElements() {
		Set<String> classpathElements = newLinkedHashSet();
		classpathElements.addAll(this.classpathElements);
		classpathElements.remove(project.getBuild().getOutputDirectory());
		classpathElements.remove(project.getBuild().getTestOutputDirectory());
		Set<String> nonEmptyElements = newLinkedHashSet(filter(classpathElements, emptyStringFilter()));
		return nonEmptyElements;
	}
	
}
