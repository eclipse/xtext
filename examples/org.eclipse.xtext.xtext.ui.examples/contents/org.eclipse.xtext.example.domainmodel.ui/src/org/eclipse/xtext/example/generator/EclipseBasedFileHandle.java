package org.eclipse.xtext.example.generator;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtext.util.StringInputStream;

public class EclipseBasedFileHandle implements FileHandle {

	private Outlet outlet;
	private CharSequence buffer = new StringBuilder();
	private IFile file;

	public EclipseBasedFileHandle(IFile file, Outlet outlet) {
		this.file = file;
		this.outlet = outlet;
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public CharSequence getBuffer() {
		return buffer;
	}

	public void setBuffer(CharSequence buffer) {
		this.buffer = buffer;
	}

	@Deprecated
	public File getTargetFile() {
		throw new UnsupportedOperationException();
	}

	public String getAbsolutePath() {
		return file.getFullPath().toString();
	}

	public boolean isAppend() {
		return false;
	}

	public boolean isOverwrite() {
		return false;
	}

	public String getFileEncoding() {
		try {
			return file.getCharset();
		} catch (CoreException e) {
			return "UTF-8";
		}
	}

	public void writeAndClose() {
		try {
			outlet.beforeWriteAndClose(this);
			if (file.exists()) {
				file.setContents(new StringInputStream(getBuffer().toString()), true, true, new NullProgressMonitor());
			} else {
				ensureExists(file.getParent());
				file.create(new StringInputStream(getBuffer().toString()), true, new NullProgressMonitor());
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	protected void ensureExists(IContainer parent) {
		if (parent instanceof IFolder && !parent.exists()) {
			ensureExists(parent.getParent());
			try {
				((IFolder)parent).create(true, true, null);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
