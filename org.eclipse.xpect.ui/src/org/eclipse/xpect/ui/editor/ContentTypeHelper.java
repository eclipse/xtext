package org.eclipse.xpect.ui.editor;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

public class ContentTypeHelper {

	public enum XpectContentType {
		BINARY, TEXT, XPECT
	}

	public XpectContentType getContentType(IFile file) {
		if (file == null)
			return XpectContentType.BINARY;
		InputStream contents = null;
		try {
			contents = file.getContents();
			byte[] buf = new byte[1024];
			int len = contents.read(buf);
			for (int i = 0; i < len; i++) {
				byte c = buf[i];
				if (c < ' ' && c != '\n' && c != '\r' && c != '\t')
					return XpectContentType.BINARY;
			}
			String stringBuf = new String(buf, file.getCharset());
			if (stringBuf.contains("XPECT"))
				return XpectContentType.XPECT;
			return XpectContentType.TEXT;
		} catch (CoreException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (contents != null)
				try {
					contents.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		}

	}
}
