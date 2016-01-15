package org.eclipse.xpect.xtext.lib.util;

import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import com.google.common.io.Closeables;

public class IFileUtil {

	public static IFile create(IContainer container, URI localURI, InputStream inputStream) {
		return createFile(findFolder(container, localURI), localURI.lastSegment(), inputStream);
	}

	public static IFile createFile(IContainer container, String name, InputStream inputStream) {
		IFile file = container.getFile(new Path(name));
		try {
			file.create(inputStream, true, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		} finally {
			Closeables.closeQuietly(inputStream);
		}
		return file;
	}

	public static IFolder createFolder(IContainer container, String name) {
		IFolder file = container.getFolder(new Path(name));
		try {
			file.create(true, true, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		return file;
	}

	public static IContainer findFolder(IContainer container, URI localURI) {
		if (localURI.segmentCount() > 1) {
			Path path = new Path(localURI.trimSegments(1).toString());
			IFolder folder = container.getFolder(path);
			if (!folder.exists())
				try {
					folder.create(true, true, new NullProgressMonitor());
					return folder;
				} catch (CoreException e) {
					throw new RuntimeException();
				}
		}
		return container;
	}
}
