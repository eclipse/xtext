package org.eclipse.xtend.maven;

import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtend.core.macro.fsaccess.FileSystemAccessImpl;
import org.eclipse.xtend.maven.macro.fsaccess.MavenFileSystemAccessImpl;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;

public class XtendMavenModule extends XtendRuntimeModule {

	public Class<? extends ITraceURIConverter> bindITraceURIConverter() {
		return MavenTraceURIConverter.class;
	}

	public Class<? extends FileSystemAccessImpl> bindFileSystemAccessImpl() {
		return MavenFileSystemAccessImpl.class;
	}

}
