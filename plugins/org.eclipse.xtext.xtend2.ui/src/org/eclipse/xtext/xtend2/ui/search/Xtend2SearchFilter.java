package org.eclipse.xtext.xtend2.ui.search;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.search.IXtextSearchFilter;

import com.google.inject.Inject;

public class Xtend2SearchFilter implements IXtextSearchFilter {

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	public boolean reject(IEObjectDescription element) {
		if (fileExtensionProvider.isValid(element.getEObjectURI().fileExtension())) {
			return element.getEClass() == TypesPackage.Literals.JVM_GENERIC_TYPE
				|| (TypesPackage.Literals.JVM_MEMBER.isSuperTypeOf(element.getEClass()));
		}
		return false;
	}

}
