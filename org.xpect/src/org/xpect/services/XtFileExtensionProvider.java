package org.xpect.services;

import org.eclipse.xtext.resource.FileExtensionProvider;

public class XtFileExtensionProvider extends FileExtensionProvider {

	@Override
	public boolean isValid(String fileExtension) {
		if ("xt".equals(fileExtension))
			return true;
		return super.isValid(fileExtension);
	}

}
