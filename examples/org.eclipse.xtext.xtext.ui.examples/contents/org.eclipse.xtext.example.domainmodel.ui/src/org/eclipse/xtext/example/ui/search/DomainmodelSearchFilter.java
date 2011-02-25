package org.eclipse.xtext.example.ui.search;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.search.IXtextSearchFilter;

public class DomainmodelSearchFilter implements IXtextSearchFilter {

	public boolean reject(IEObjectDescription input) {
		return DomainmodelPackage.Literals.FEATURE.isSuperTypeOf(input.getEClass())
				|| TypesPackage.Literals.JVM_FORMAL_PARAMETER.equals(input.getEClass());
	}

}
