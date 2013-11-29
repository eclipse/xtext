package org.eclipse.xtend.m2e;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2e.core.project.configurator.AbstractProjectConfigurator;
import org.eclipse.m2e.core.project.configurator.ProjectConfigurationRequest;
import org.eclipse.xtext.ui.XtextProjectHelper;

public class XtendProjectConfigurator extends AbstractProjectConfigurator {

	/**
	 * This is enough configuration for now, as Xtend will add the required
	 * source folders itself the moment it starts compiling.
	 */
	@Override
	public void configure(ProjectConfigurationRequest request,
			IProgressMonitor monitor) throws CoreException {
		addNature(request.getProject(), XtextProjectHelper.NATURE_ID, monitor);
	}
}