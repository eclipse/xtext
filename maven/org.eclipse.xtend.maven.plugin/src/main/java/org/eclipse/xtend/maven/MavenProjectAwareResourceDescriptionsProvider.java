package org.eclipse.xtend.maven;

import org.apache.maven.project.MavenProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.xtext.AbstractProjectAwareResourceDescriptionsProvider;

public class MavenProjectAwareResourceDescriptionsProvider extends AbstractProjectAwareResourceDescriptionsProvider {

	@Override
	protected String getProjectName(ResourceSet resourceSet) {
		MavenProject mavenProject = MavenProjectAdapter.get(resourceSet);
		return mavenProject.getBasedir().getName();
	}

}
