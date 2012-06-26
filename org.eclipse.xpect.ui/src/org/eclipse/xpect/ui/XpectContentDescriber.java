package org.eclipse.xpect.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.ITextContentDescriber;

public class XpectContentDescriber implements ITextContentDescriber {

	@Override
	public int describe(InputStream contents, IContentDescription description)
			throws IOException {
		return isValid(new BufferedReader(new InputStreamReader(contents)));
	}

	@Override
	public QualifiedName[] getSupportedOptions() {
		return new QualifiedName[0];
	}

	@Override
	public int describe(Reader contents, IContentDescription description)
			throws IOException {
		return isValid(new BufferedReader(contents));
	}

	private int isValid(BufferedReader br) throws IOException {
		String line;
		int i = 0, max = 10;
		while ((line = br.readLine()) != null && i++ < max)
			if (line.contains("XPECT"))
				return IContentDescriber.VALID;
		return IContentDescriber.INVALID;
	}

}
