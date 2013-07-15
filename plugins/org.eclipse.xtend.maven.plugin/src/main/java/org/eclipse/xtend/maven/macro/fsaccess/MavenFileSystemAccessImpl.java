package org.eclipse.xtend.maven.macro.fsaccess;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.fsaccess.AbstractFileSystemAccessImpl;
import org.eclipse.xtend.core.macro.fsaccess.RuntimeFolderHandle;
import org.eclipse.xtend.lib.macro.services.FolderHandle;
import org.eclipse.xtend.maven.MavenProjectAdapter;
import org.eclipse.xtext.parser.IEncodingProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MavenFileSystemAccessImpl extends AbstractFileSystemAccessImpl {

	@Inject
	private IEncodingProvider encodingProvider;

	private String targetDirectory;

	public String getTargetDirectory() {
		return targetDirectory;
	}

	public void setTargetDirectory(String targetDirectory) {
		this.targetDirectory = targetDirectory;
	}

	public FolderHandle doGetRootFolder(CompilationUnitImpl impl) {
		MavenProject manenProject = getMavenProject(impl);
		if (manenProject == null) {
			return null;
		}
		return new RuntimeFolderHandle(manenProject.getBasedir(), encodingProvider);
	}

	public FolderHandle doGetSourceFolder(CompilationUnitImpl impl) {
		Resource eResource = impl.getXtendFile().eResource();
		URI uri = eResource.getURI();
		MavenProject manenProject = MavenProjectAdapter.get(eResource.getResourceSet());
		if (manenProject == null) {
			return null;
		}
		for (String rootString : manenProject.getCompileSourceRoots()) {
			if (!rootString.endsWith("/")) {
				rootString += "/";
			}
			URI root = URI.createFileURI(rootString);
			if (isPrefix(root, uri)) {
				return new RuntimeFolderHandle(new File(rootString), encodingProvider);
			}
		}
		return null;
	}

	public FolderHandle doGetTargetFolder(CompilationUnitImpl impl) {
		if (targetDirectory == null) {
			return null;
		}
		return new RuntimeFolderHandle(new File(targetDirectory), encodingProvider);
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

	private MavenProject getMavenProject(CompilationUnitImpl impl) {
		return MavenProjectAdapter.get(impl.getXtendFile().eResource().getResourceSet());
	}

}
