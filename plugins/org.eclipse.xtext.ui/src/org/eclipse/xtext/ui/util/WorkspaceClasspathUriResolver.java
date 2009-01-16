package org.eclipse.xtext.ui.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;


/**
 * TODO: implement JDT independent strategy, maybe ignoring JARs
 * 
 * @author Jan Köhnlein
 */
public class WorkspaceClasspathUriResolver extends JdtClasspathUriResolver {

    @Override
    public URI resolve(Object context, URI classpathUri) {
        if(!(context instanceof IResource)) {
            throw new IllegalArgumentException("Context must implement IResource");
        }
        IResource resource = (IResource) context;
        try {
            if (ClasspathUriUtil.isClasspathUri(classpathUri)) {
                IProject project = resource.getProject();
                IJavaProject javaProject = JavaCore.create(project);
                return findResourceInWorkspace(javaProject, classpathUri);
            }
        } catch (Exception exc) {
            throw new ClasspathUriResolutionException(exc);
        }
        return classpathUri;
    }
}
