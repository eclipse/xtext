package org.eclipse.xtend.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import com.google.inject.Inject;

public abstract class AbstractXtendMojo extends AbstractMojo {

	@Inject
	protected MavenLog4JConfigurator log4jConfigurator;

	/**
	 * The project itself. This parameter is set by maven.
	 * 
	 * @parameter expression="${project}"
	 * @required
	 */
	protected MavenProject project;

	/**
	 * Set this to true to skip compiling Xtend sources.
	 * 
	 * @parameter default-value="false" expression="${skipXtend}"
	 */
	protected boolean skipXtend;

	public AbstractXtendMojo() {
		injectMembers();
	}

	public void execute() throws MojoExecutionException, MojoFailureException {
		if (isSkipped()) {
			getLog().info("skipped.");
		} else {
			log4jConfigurator.configureLog4j(getLog());
			internalExecute();
		}
	}

	protected void injectMembers() {
		new XtendMavenStandaloneSetup().createInjectorAndDoEMFRegistration().injectMembers(this);
	}

	protected abstract void internalExecute() throws MojoExecutionException, MojoFailureException;

	protected boolean isSkipped() {
		return skipXtend;
	}

}
