package org.eclipse.xtend.ide.quickfix;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;

import com.google.inject.Inject;

public class NewTypePageConfigurer {

	private static final Logger LOG = Logger.getLogger(NewTypePageConfigurer.class);
	@Inject private ProjectProvider projectProvider;
	
	public void configure(NewTypeWizardPage page, URI contextUri, String typeName){
		setPackageName(page, contextUri);
		page.setTypeName(typeName, true);
	}

	public void setPackageName(NewTypeWizardPage page, URI contextUri) {
		IJavaProject javaProject = projectProvider.getJavaProject(contextUri);
		String path = contextUri.trimSegments(1).toPlatformString(true);
		try {
			IPackageFragment packageFragment = javaProject.findPackageFragment(new Path(path));
			IPackageFragmentRoot root = (IPackageFragmentRoot) packageFragment.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
			page.setPackageFragment(packageFragment, true);
			page.setPackageFragmentRoot(root, true);
		} catch (JavaModelException e) {
			LOG.error("Could not find package for " + path, e);
		}
	}
	
}
