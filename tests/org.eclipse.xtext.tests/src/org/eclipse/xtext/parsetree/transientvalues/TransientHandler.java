/**
 *
 */
package org.eclipse.xtext.parsetree.transientvalues;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TransientHandler extends DefaultTransientValueService {

	@Override
	public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
		// System.out.println("isTransient " + feature.getName()
		// + ((index >= 0) ? "[" + index + "]" : ""));
		final String n = feature.getName();
		if ("required1".equals(n) || "required2".equals(n))
			return true;
		if ("opt1".equals(n) || "opt2".equals(n))
			return true;
		if ("item".equals(n)) {
			List<?> l = (List<?>) owner.eGet(feature);
			return ((Integer) l.get(index) % 2) == 0;
		}
		return super.isTransient(owner, feature, index);
	}

	@Override
	public boolean isCheckElementsIndividually(EObject owner, EStructuralFeature feature) {
		// System.out.println("isMixedList " + feature.getName());
		if ("TestList".equals(owner.eClass().getName()))
			return true;
		return super.isCheckElementsIndividually(owner, feature);
	}

}
