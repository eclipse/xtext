package org.xpect.ui.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.util.Pair;

public class FileUtil {

	public static URI findURLInWorkspace(URI uri) {
		if (uri.isFile()) {
			java.net.URI javaURI = java.net.URI.create(uri.trimFragment().toString());
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(javaURI);
			if (files.length > 0) {
				IFile file = files[0];
				return URI.createPlatformResourceURI(file.getFullPath().toString(), true).appendFragment(uri.fragment());
			}
			throw new IllegalStateException("File not found in workspace: " + uri);
		}
		return uri;
	}

	public static IFile findFileInWorkspace(URI uri) {
		if (uri.isFile()) {
			java.net.URI javaURI = java.net.URI.create(uri.trimFragment().toString());
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(javaURI);
			if (files.length > 0)
				return files[0];
		}
		for (Pair<IStorage, IProject> p : Access.getIStorage2UriMapper().get().getStorages(uri)) {
			IStorage storage = p.getFirst();
			if (storage instanceof IFile)
				return (IFile) storage;
		}
		throw new IllegalStateException("File not found in workspace: " + uri);
	}
}
