package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SimpleTransientValueService extends DefaultTransientValueService {
	public boolean isTransient(EObject owner, EStructuralFeature feature,
			int index) {
		return !owner.eIsSet(feature);
	}

}
