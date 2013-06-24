package org.xpect.ui.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.xpect.util.IFileForClassProvider;

public class UIFileForClassProvider implements IFileForClassProvider {

	public File getFile(Class<?> clazz) {
		String name = clazz.getName().replace(".", "/") + ".class";
		URL resource = clazz.getClassLoader().getResource(name);
		try {
			URL find = FileLocator.resolve(resource);
			File classFile = new File(find.toURI());
			return classFile;
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
