package org.xpect.xtext.lib.util;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

public class IFileUtil {

	public static IFile create(IContainer container, String name, InputStream inputStream) {
		IFile file = container.getFile(new Path(name));
		try {
			try {
				file.create(inputStream, true, new NullProgressMonitor());
			} finally {
				if (inputStream != null)
					inputStream.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		return file;
	}
}
