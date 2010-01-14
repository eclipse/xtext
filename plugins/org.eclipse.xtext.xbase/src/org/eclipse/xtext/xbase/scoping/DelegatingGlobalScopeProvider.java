package org.eclipse.xtext.xbase.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.xbase.Function;

import com.google.inject.Inject;

public class DelegatingGlobalScopeProvider extends DefaultGlobalScopeProvider {
	@Inject
	private AbstractTypeScopeProvider typesScopeProvider;

	public IScope getScope(EObject context, EReference reference) {
		if (TypesPackage.eINSTANCE.getType().isSuperTypeOf(
				(EClass) reference.getEType())) {
			return localTypes(context, typesScopeProvider.getScope(context,
					reference));
		}
		return super.getScope(context, reference);
	}

	protected IScope localTypes(EObject context, IScope outerScope) {
		Function function = EcoreUtil2.getContainerOfType(context,
				Function.class);
		if (function == null || function.getTypeParams().isEmpty())
			return outerScope;
		return Scopes.scopeFor(function.getTypeParams(), outerScope);
	}
}
