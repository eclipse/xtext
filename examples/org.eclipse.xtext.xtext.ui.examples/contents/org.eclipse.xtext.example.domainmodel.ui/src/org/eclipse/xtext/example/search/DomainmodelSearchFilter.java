package org.eclipse.xtext.example.search;

import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.core.search.IXtextSearchFilter;

public class DomainmodelSearchFilter implements IXtextSearchFilter {

	public boolean reject(IEObjectDescription input) {
		return DomainmodelPackage.eINSTANCE.getFeature().isSuperTypeOf(input.getEClass())
				|| DomainmodelPackage.eINSTANCE.getParameter().equals(input.getEClass());
	}

}
