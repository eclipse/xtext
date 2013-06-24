package org.xpect.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

public interface IFileForClassProvider {

	public static class Delegate implements IFileForClassProvider {
		private IFileForClassProvider delegate;

		public IFileForClassProvider getDelegate() {
			return delegate;
		}

		public File getFile(Class<?> clazz) {
			return delegate.getFile(clazz);
		}

		public void setDelegate(IFileForClassProvider delegate) {
			this.delegate = delegate;
		}
	}

	public static class RuntimeFileForClassProvider implements IFileForClassProvider {

		public File getFile(Class<?> clazz) {
			String name = clazz.getName().replace(".", "/") + ".class";
			URL resource = clazz.getClassLoader().getResource(name);
			try {
				File classFile = new File(resource.toURI());
				return classFile;
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static IFileForClassProvider INSTANCE = EcorePlugin.IS_ECLIPSE_RUNNING ? new Delegate() : new RuntimeFileForClassProvider();

	File getFile(Class<?> clazz);
}
