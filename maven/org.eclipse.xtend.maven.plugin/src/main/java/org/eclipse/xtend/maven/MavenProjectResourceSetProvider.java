package org.eclipse.xtend.maven;

import org.apache.maven.project.MavenProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt
 */
public class MavenProjectResourceSetProvider implements Provider<ResourceSet> {

	private MavenProject project;

	public MavenProjectResourceSetProvider(MavenProject project) {
		super();
		this.project = project;
	}

	public ResourceSet get() {
		ResourceSet rs = new XtextResourceSet();
		MavenProjectAdapter.install(rs, project);
		return rs;
	}
}
