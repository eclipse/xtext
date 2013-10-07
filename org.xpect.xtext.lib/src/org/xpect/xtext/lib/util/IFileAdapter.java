package org.xpect.xtext.lib.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.xpect.parameter.IParameterProvider;
import org.xpect.state.StateContainer;

public class IFileAdapter implements IParameterProvider {

	private final IFile file;

	public IFileAdapter(IFile file) {
		super();
		this.file = file;
	}

	public boolean canProvide(Class<?> expectedType) {
		return get(expectedType, null) != null;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> expectedType, StateContainer context) {
		if (expectedType.isInstance(file))
			return (T) file;
		if (expectedType.isAssignableFrom(IPath.class))
			return (T) file.getFullPath();
		if (expectedType.isAssignableFrom(String.class))
			return (T) file.getFullPath().toString();
		if (expectedType.isAssignableFrom(URI.class))
			return (T) URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		if (expectedType.isAssignableFrom(java.io.File.class))
			return (T) file.getLocation().toFile();
		return null;
	}

	public IFile getFile() {
		return file;
	}

}