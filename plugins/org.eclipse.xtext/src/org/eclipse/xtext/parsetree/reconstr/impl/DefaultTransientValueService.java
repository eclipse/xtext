package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultTransientValueService implements ITransientValueService {

	public boolean isMixedList(EObject owner, EStructuralFeature feature) {
		return false;
	}

	public boolean isTransient(EObject owner, EStructuralFeature feature,
			int index) {
		return false;
	}

}
