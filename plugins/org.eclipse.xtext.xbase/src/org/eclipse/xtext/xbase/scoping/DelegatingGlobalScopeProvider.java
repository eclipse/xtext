package org.eclipse.xtext.xbase.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

import com.google.inject.Inject;

public class DelegatingGlobalScopeProvider extends DefaultGlobalScopeProvider {
	@Inject
	private AbstractTypeScopeProvider typesScopeProvider;

	public IScope getScope(EObject context, EReference reference) {
		if (TypesPackage.eINSTANCE.getType().isSuperTypeOf(
				(EClass) reference.getEType())) {
			return typesScopeProvider.getScope(context, reference);
		}
		return super.getScope(context, reference);
	}

}
