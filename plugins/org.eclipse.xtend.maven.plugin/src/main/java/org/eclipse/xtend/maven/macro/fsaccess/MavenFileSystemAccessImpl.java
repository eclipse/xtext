package org.eclipse.xtend.maven.macro.fsaccess;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.fsaccess.FileSystemAccessImpl;
import org.eclipse.xtend.core.macro.fsaccess.RuntimeFolderHandle;
import org.eclipse.xtend.lib.macro.services.FolderHandle;
import org.eclipse.xtend.maven.MavenProjectAdapter;

import com.google.inject.Singleton;

@Singleton
public class MavenFileSystemAccessImpl implements FileSystemAccessImpl {

	private String targetDirectory;

	public String getTargetDirectory() {
		return targetDirectory;
	}

	public void setTargetDirectory(String targetDirectory) {
		this.targetDirectory = targetDirectory;
	}

	public FolderHandle getRootFolder(CompilationUnitImpl impl) {
		return new RuntimeFolderHandle(getManenProject(impl).getBasedir());
	}

	public FolderHandle getSourceFolder(CompilationUnitImpl impl) {
		Resource eResource = impl.getXtendFile().eResource();
		URI uri = eResource.getURI();
		MavenProject project = MavenProjectAdapter.get(eResource.getResourceSet());
		for (String rootString : project.getCompileSourceRoots()) {
			if (!rootString.endsWith("/"))
				rootString += "/";
			URI root = URI.createFileURI(rootString);
			if (isPrefix(root, uri)) {
				return new RuntimeFolderHandle(new File(rootString));
			}
		}
		throw new RuntimeException("Could not find source folder for '" + uri + "'.");
	}

	public FolderHandle getTargetFolder(CompilationUnitImpl impl) {
		if (targetDirectory == null) {
			throw new IllegalStateException("Target directory was not declared.");
		}
		return new RuntimeFolderHandle(new File(targetDirectory));
	}

	private boolean isPrefix(URI prefix, URI uri) {
		if (prefix.scheme() == null || !prefix.scheme().equals(uri.scheme()))
			return false;
		String[] prefixSeg = prefix.segments();
		String[] uriSeg = uri.segments();
		if (prefixSeg.length == 0 || uriSeg.length == 0)
			return false;
		if (!"".equals(prefixSeg[prefixSeg.length - 1])) // this is true when the URI has a trailing slash ("/").
			return false;
		if (uriSeg.length < prefixSeg.length - 1)
			return false;
		for (int i = 0; i < prefixSeg.length - 1; i++)
			if (!uriSeg[i].equals(prefixSeg[i]))
				return false;
		return true;
	}

	private MavenProject getManenProject(CompilationUnitImpl impl) {
		return MavenProjectAdapter.get(impl.getXtendFile().eResource().getResourceSet());
	}

}
