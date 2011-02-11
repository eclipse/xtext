package org.eclipse.xtext.xtend2.typing;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.linking.JvmModelInferrer;
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
	private JvmModelInferrer jvmModelInferrer;
	
	protected JvmTypeReference _expectedType(XtendFunction function, EReference reference, int index) {
		if (reference==Xtend2Package.Literals.XTEND_FUNCTION__EXPRESSION) {
			if (function.getReturnType()==null || typeRefs.is(function.getReturnType(), Void.TYPE))
				return null;
			return function.getReturnType();
		}
		return null;
	}
	
	protected JvmTypeReference _type(RichString richString) {
		return typeRefs.getTypeForName(StringConcatenation.class, richString);
	}
	
	protected JvmTypeReference _type(RichStringLiteral stringLiteral) {
		return typeRefs.getTypeForName(String.class, stringLiteral);
	}
	
	protected JvmTypeReference _typeForIdentifiable(XtendClass clazz) {
		JvmParameterizedTypeReference typeReference = factory.createJvmParameterizedTypeReference();
		typeReference.setType(xtend2jvmAssociations.getInferredType(clazz));
		return typeReference;
	}

	private ThreadLocal<Set<XtendFunction>> currentComputation = new ThreadLocal<Set<XtendFunction>>();
	
	protected JvmTypeReference _typeForIdentifiable(XtendFunction func) {
		if (func.getReturnType() != null)
			return func.getReturnType();
		Set<XtendFunction> computations = getCurrentComputation(); 
		if (computations.add(func)) {
			try {
				return typeProvider.getType(func.getExpression());
			} finally {
				computations.remove(func);
			}
		} else {
			return typeRefs.getTypeForName(Object.class, func);
		}
	}

	protected Set<XtendFunction> getCurrentComputation() {
		Set<XtendFunction> set = currentComputation.get();
		if (set == null) {
			set = newHashSet();
			currentComputation.set(set);
		}
		return set;
	}

	protected JvmTypeReference _typeForIdentifiable(JvmGenericType type) {
		XtendClass xtendClass = xtend2jvmAssociations.getXtendClass(type);
		return (xtendClass != null) ? _typeForIdentifiable(xtendClass) : null;
	}

	@Override
	protected JvmTypeReference _typeForIdentifiable(JvmOperation operation) {
		if(operation.getReturnType() != null) 
			return operation.getReturnType();
		return jvmModelInferrer.inferReturnType(operation);
	}
	
}
