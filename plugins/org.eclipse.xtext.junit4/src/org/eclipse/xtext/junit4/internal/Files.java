/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.internal;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import com.google.common.io.ByteStreams;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class Files {

	public static byte[] toByteArray(IFile file) throws CoreException, IOException {
		InputStream contents = null;
		try {
			contents = file.getContents();
			return ByteStreams.toByteArray(contents);
		} finally {
			if (contents != null)
				contents.close();
		}
	}

	public static String toString(IFile file) throws CoreException, IOException {
		return new String(toByteArray(file), file.getCharset());
	}

	public static boolean isEmpty(IFile file) throws IOException, CoreException {
		InputStream contents = null;
		try {
			contents = file.getContents();
			return contents.read() == -1;
		} finally {
			if (contents != null)
				contents.close();
		}
	}
}
