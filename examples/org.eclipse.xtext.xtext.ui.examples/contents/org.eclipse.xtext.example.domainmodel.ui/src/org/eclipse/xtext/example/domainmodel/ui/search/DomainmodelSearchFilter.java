package org.eclipse.xtext.example.domainmodel.ui.search;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.search.IXtextSearchFilter;

public class DomainmodelSearchFilter implements IXtextSearchFilter {

	@Override
	public boolean reject(IEObjectDescription input) {
		return TypesPackage.Literals.JVM_FORMAL_PARAMETER.equals(input.getEClass());
	}

}
