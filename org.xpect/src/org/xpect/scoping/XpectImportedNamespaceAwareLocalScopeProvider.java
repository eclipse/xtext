package org.xpect.scoping;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.xpect.AbstractComponent;
import org.xpect.Assignment;
import org.xpect.Component;
import org.xpect.XpectPackage;
import org.xpect.XpectTest;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@SuppressWarnings("restriction")
public class XpectImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	protected static class IsAssigneableTo implements Predicate<IEObjectDescription> {

		private Set<JvmType> invalid = Sets.newHashSet();

		private Set<JvmType> validTypes;

		public IsAssigneableTo(Set<JvmType> validTypes) {
			super();
			this.validTypes = validTypes;
		}

		private boolean apply(EObject obj) {
			if (obj instanceof JvmTypeReference)
				obj = ((JvmTypeReference) obj).getType();
			if (obj instanceof JvmDeclaredType) {
				JvmDeclaredType type = (JvmDeclaredType) obj;
				if (invalid.contains(type))
					return false;
				if (validTypes.contains(type))
					return true;
				for (JvmTypeReference sup : type.getSuperTypes())
					if (apply(sup))
						return true;
				invalid.add(type);
			}
			return false;
		}

		public boolean apply(IEObjectDescription arg0) {
			return apply(EcoreUtil.resolve(arg0.getEObjectOrProxy(), validTypes.iterator().next()));

		}

	}

	private void collectAdders(JvmType type, List<JvmOperation> ops) {
		if (type instanceof JvmDeclaredType)
			for (JvmFeature feat : ((JvmDeclaredType) type).getAllFeatures())
				if (feat instanceof JvmOperation && "add".equals(feat.getSimpleName()))
					ops.add((JvmOperation) feat);
	}

	protected Predicate<IEObjectDescription> getFilter(EObject context, EReference reference) {
		if (reference == XpectPackage.Literals.COMPONENT__COMPONENT_CLASS) {
			Assignment assignment = EcoreUtil2.getContainerOfType(context, Assignment.class);
			if (assignment != null && !assignment.eIsProxy()) {
				Set<JvmType> validTypes = getValidTypes(assignment);
				if (validTypes != null && !validTypes.isEmpty())
					return new IsAssigneableTo(validTypes);
			}
		}
		return null;
	}

	public IScope getScope(EObject context, EReference reference) {
		if (context == null)
			throw new NullPointerException("context");
		Predicate<IEObjectDescription> filter = getFilter(context, reference);
		IScope globalScope = getGlobalScope(context.eResource(), reference, filter);
		List<ImportNormalizer> normalizers = getImplicitImports(isIgnoreCase(reference));
		if (!normalizers.isEmpty()) {
			globalScope = createImportScope(globalScope, normalizers, null, reference.getEReferenceType(), isIgnoreCase(reference));
		}
		return getResourceScope(globalScope, context, reference);
	}

	protected Set<JvmType> getValidTypes(Assignment assignment) {
		List<JvmOperation> ops = Lists.newArrayList();
		JvmOperation operation = assignment.getDeclaredTarget();
		if (operation != null) {
			if (operation.eIsProxy())
				return null;
			ops.add(operation);
		} else {
			AbstractComponent container = assignment.getInstance();
			if (container instanceof Component) {
				JvmDeclaredType type = ((Component) container).getComponentClass();
				if (type != null && !type.eIsProxy())
					collectAdders(type, ops);
			} else if (container instanceof XpectTest) {
				XtextResource resource = (XtextResource) assignment.eResource();
				IJvmTypeProvider typeProvider = resource.getResourceServiceProvider().get(IJvmTypeProvider.Factory.class).findOrCreateTypeProvider(resource.getResourceSet());
				collectAdders(typeProvider.findTypeByName("org.xpect.xtext.lib.setup.emf.ResourceSetDefaultsSetup"), ops);
				collectAdders(typeProvider.findTypeByName("org.xpect.xtext.lib.setup.workspace.WorkspaceDefaultsSetup"), ops);
			} else
				return null;
		}
		Set<JvmType> result = Sets.newHashSet();
		for (JvmOperation op : ops)
			if (op.getParameters().size() == 1) {
				JvmTypeReference paramType = op.getParameters().get(0).getParameterType();
				if (paramType != null && !paramType.eIsProxy() && paramType.getType() != null && !paramType.getType().eIsProxy())
					result.add(paramType.getType());
			}
		return result;
	}
}
