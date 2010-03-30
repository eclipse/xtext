package org.eclipse.xtext.example.arithmetics.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.google.common.base.Predicate;

public class ArithmeticsScopeProvider extends AbstractDeclarativeScopeProvider {
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope scope = super.getScope(context, reference);
		return new FilteringScope(scope,
				new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						return input!=null && input.getName()!=null && input.getName().indexOf('.')==-1;
					};
				});
	}

}
