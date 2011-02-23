package org.eclipse.xtext.xtend2.typing;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Xtend2TypeProvider extends XbaseTypeProvider {

	@Inject
	private TypeReferences typeRefs;

	@Inject
	private TypesFactory factory;

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private IXtend2JvmAssociations xtend2jvmAssociations;

	@Inject
	private FeatureOverridesService featureOverridesService;

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	protected JvmTypeReference _expectedType(XtendFunction function, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.XTEND_FUNCTION__EXPRESSION) {
			JvmTypeReference declaredOrInferredReturnType = getDeclaredOrInferredReturnType(function);
			if (declaredOrInferredReturnType == null || typeRefs.is(declaredOrInferredReturnType, Void.TYPE))
				return null;
			return function.getReturnType();
		}
		return null;
	}

	protected JvmTypeReference _type(RichString richString, boolean rawType) {
		return typeRefs.getTypeForName(StringConcatenation.class, richString);
	}

	protected JvmTypeReference _type(RichStringLiteral stringLiteral, boolean rawType) {
		return typeRefs.getTypeForName(String.class, stringLiteral);
	}

	protected JvmTypeReference _typeForIdentifiable(XtendClass clazz, boolean rawType) {
		JvmParameterizedTypeReference typeReference = factory.createJvmParameterizedTypeReference();
		typeReference.setType(xtend2jvmAssociations.getInferredType(clazz));
		return typeReference;
	}

	private ThreadLocal<Set<XtendFunction>> currentComputation = new ThreadLocal<Set<XtendFunction>>();

	protected JvmTypeReference _typeForIdentifiable(XtendFunction func, boolean rawType) {
		JvmTypeReference declaredOrInferredReturnType = getDeclaredOrInferredReturnType(func);
		if (declaredOrInferredReturnType != null)
			return declaredOrInferredReturnType;
		Set<XtendFunction> computations = getCurrentComputation();
		if (computations.add(func)) {
			try {
				return typeProvider.getType(func.getExpression(), rawType);
			} finally {
				computations.remove(func);
			}
		} else {
			return typeRefs.getTypeForName(Object.class, func);
		}
	}

	protected JvmTypeReference getDeclaredOrInferredReturnType(XtendFunction func) {
		if (func.getReturnType() != null)
			return func.getReturnType();
		if (func.isOverride()) {
			JvmOperation inferredOperation = xtend2jvmAssociations.getDirectlyInferredOperation(func);
			JvmDeclaredType inferredType = inferredOperation.getDeclaringType();
			TypeArgumentContext typeArgumentContext = typeArgumentContextProvider.getReceiverContext(typeRefs
					.createTypeRef(inferredType));
			JvmTypeReference superType = func.getDeclaringType().getExtends();
			if (superType != null) {
				for (JvmFeature superFeature : featureOverridesService.getAllJvmFeatures(superType)) {
					if (superFeature instanceof JvmOperation) {
						JvmOperation superOperation = (JvmOperation) superFeature;
						if (featureOverridesService.isOverridden(inferredOperation, superOperation,
								typeArgumentContext, false))
							return superOperation.getReturnType();
					}
				}
			}
		}
		return null;
	}

	protected Set<XtendFunction> getCurrentComputation() {
		Set<XtendFunction> set = currentComputation.get();
		if (set == null) {
			set = newHashSet();
			currentComputation.set(set);
		}
		return set;
	}

	protected JvmTypeReference _typeForIdentifiable(JvmGenericType type, boolean rawType) {
		XtendClass xtendClass = xtend2jvmAssociations.getXtendClass(type);
		return (xtendClass != null) ? _typeForIdentifiable(xtendClass, rawType) : null;
	}

}
