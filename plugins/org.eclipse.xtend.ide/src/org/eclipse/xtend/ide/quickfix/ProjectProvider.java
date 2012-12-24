package org.eclipse.xtend.ide.quickfix;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

import com.google.inject.Inject;

public class ProjectProvider {
	
	@Inject IWorkspaceRoot workspaceRoot;
	
	public IJavaProject getJavaProject(URI uri){
		IProject project = getProject(uri);
		if(project == null){
			return null;
		}
		return JavaCore.create(project);
	}
	
	public IProject getProject(URI uri){
		IFile file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)));
		if(file == null){
			return null;
		}
		return file.getProject();
	}

}
