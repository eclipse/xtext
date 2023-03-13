/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.compiler.batch;

import java.io.File;
import java.util.Iterator;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.Java;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.types.Resource;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendCompilerAntTask extends Java {

	private File destdir, tempdir;

	private Path srcdir;
	private String encoding;

	@Override
	public void execute() throws BuildException {

		createArgs();

		setClassname(Main.class.getName());
		createArg().setValue(getSrcdir().toString());

		//log(getCommandLine().toString());

		try {
			super.execute();
		} catch (Exception ex) {
			if (ex.getCause() != null) {
				ex.getCause().printStackTrace();
			}
			String message = "Compilation failed: " + String.valueOf(ex.getMessage());
			if (ex.getCause() != null) {
				message += " cause: " + String.valueOf(ex.getCause().getMessage());
			}
			throw new BuildException(message, ex);
		}

	}

	private void createArgs() {
		
		validateArgs();
		
		createArg().setValue("-d");
		createArg().setValue(getDestdir().getAbsolutePath());

		if (getTempdir() != null) {
			createArg().setValue("-tp");
			createArg().setValue(getTempdir().getAbsolutePath());
		}
		if (getCommandLine().getClasspath() != null) {
			createArg().setValue("-cp");
			createArg().setValue(getCommandLine().getClasspath().toString());
		}
		if (getEncoding() != null) {
			createArg().setValue("-encoding");
			createArg().setValue(getEncoding());
		}
	}

	private void validateArgs() {
		if (getDestdir() == null) {
			throw new BuildException("Destination directory 'destdir' is required.");
		}
		Path srcDirs = getSrcdir();
		if (srcDirs == null) {
			throw new BuildException("Sources directory 'srcdir' is required.");
		}
		Iterator<?> pathIter = srcDirs.iterator();
		while (pathIter.hasNext()) {
			Object next = pathIter.next();
			if (!(next instanceof Resource && ((Resource) next).isDirectory())) {
				throw new BuildException("Source directory must be a directory. Check 'srcdir' entry: " + next);
			}
		}
	}

	public Path createSrcdir() {
		if (srcdir == null) {
			srcdir = new Path(getProject());
		}
		return srcdir;
	}

	public Path getSrcdir() {
		return srcdir;
	}

	public void setSrcdir(Path srcdir) {
		createSrcdir().add(srcdir);
	}

	public File getDestdir() {
		return destdir;
	}

	public void setDestdir(File destdir) {
		this.destdir = destdir;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setTempdir(File tempdir) {
		this.tempdir = tempdir;
	}

	public File getTempdir() {
		return tempdir;
	}
}
