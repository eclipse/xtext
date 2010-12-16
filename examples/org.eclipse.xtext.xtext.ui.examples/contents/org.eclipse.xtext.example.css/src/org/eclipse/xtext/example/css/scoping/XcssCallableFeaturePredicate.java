package org.eclipse.xtext.example.css.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.example.css.xcss.TypeSelector;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.scoping.featurecalls.CallableFeaturePredicate;

public class XcssCallableFeaturePredicate extends CallableFeaturePredicate {

	protected boolean _case(TypeSelector input, XFeatureCall context, EReference reference,
			TypeArgumentContext typeArgContext) {
		return true;
	}
}
