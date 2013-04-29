/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.AnnotationLookup;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
// TODO: reimplement using ICodeBuilder
@SuppressWarnings("deprecation")
public class MemberFromSuperImplementor {

	public static final String DEFAULT_BODY = "throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")";

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private XtypeTypeReferenceSerializer typeReferenceSerializer;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private AnnotationLookup annotationLookup;
	

	public void appendOverrideFunction(final XtendClass overrider, JvmOperation overriddenOperation,
			IAppendable appendable) {
		appendExecutable(overrider, overriddenOperation, appendable);
	}

	public void appendConstructorFromSuper(final XtendClass overrider, JvmConstructor superConstructor,
			IAppendable appendable) {
		appendExecutable(overrider, superConstructor, appendable);
	}

	protected void appendExecutable(final XtendClass overrider, JvmExecutable executableFromSuper,
			IAppendable appendable) {
		appendable.openScope();
		boolean isOperation = executableFromSuper instanceof JvmOperation;
		final JvmGenericType overridingType = associations.getInferredType(overrider);
		if (overridingType == null)
			return;
		final ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider
				.getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmTypeReference getReceiverType() {
						return typeReferences.createTypeRef(overridingType);
					}
				});
		if (isOperation)
			appendable.append("override ");
		if (executableFromSuper.getVisibility() == JvmVisibility.PROTECTED) {
			appendable.append("protected ");
		}
		appendSignature(executableFromSuper, overridingType, typeArgumentContext, appendable, false);
		boolean isFirst;
		if (!executableFromSuper.getExceptions().isEmpty()) {
			appendable.append(" throws ");
			isFirst = true;
			for (JvmTypeReference exception : executableFromSuper.getExceptions()) {
				if (!isFirst)
					appendable.append(", ");
				isFirst = false;
				typeReferenceSerializer.serialize(exception, overridingType, appendable);
			}
		}
		appendable.append(" {").increaseIndentation().newLine();
		if (isOperation) {
			if (((JvmOperation) executableFromSuper).isAbstract()) {
				appendable.append(DEFAULT_BODY);
			} else {
				appendable.append("super.");
				appendSignature(executableFromSuper, overridingType, typeArgumentContext, appendable, true);
			}
		} else if (!executableFromSuper.getParameters().isEmpty()) {
			appendSignature(executableFromSuper, overridingType, typeArgumentContext, appendable, true);
		}
		appendable.decreaseIndentation().newLine().append("}");
		appendable.closeScope();
	}
	
	protected void appendSignature(JvmExecutable overridden, EObject context,
			final ITypeArgumentContext typeArgumentContext, IAppendable appendable, boolean isCall) {
		boolean isFirst = true;
		if (!isEmpty(overridden.getTypeParameters())) {
			appendable.append("<");
			for (@NonNull JvmTypeParameter typeParameter : overridden.getTypeParameters()) {
				if (!isFirst)
					appendable.append(", ");
				isFirst = false;
				appendable.append(typeParameter);
				if(!isCall && !typeParameter.getConstraints().isEmpty() && !hasDefaultUpperBounds(typeParameter)) {
					appendable.append(" extends ");
					boolean isFirstConstraint = true;
					for(JvmTypeConstraint constraint: typeParameter.getConstraints()) {
						if(!isFirstConstraint)
							appendable.append(" & ");
						isFirstConstraint = false;
						typeReferenceSerializer.serialize(constraint.getTypeReference(), typeParameter, appendable);
					}
				}
				if (!isCall) {
					boolean firstConstraint = true;
					for(JvmTypeConstraint constraint: typeParameter.getConstraints()) {
						if (!typeReferences.is(constraint.getTypeReference(), Object.class)) {
							if (firstConstraint) {
								appendable.append(" extends ");
								firstConstraint = false;
							} else {
								appendable.append(" & ");
							}
							JvmTypeReference constraintType = typeArgumentContext.resolve(constraint.getTypeReference());
							typeReferenceSerializer.serialize(constraintType, context, appendable, false, false, false,	false);
						}
					}
				}
			}
			appendable.append(">");
			if (!isCall) {
				appendable.append(" ");
			}
		}
		if (overridden instanceof JvmConstructor) {
			if (isCall)
				appendable.append("super");
			else
				appendable.append("new");
		} else {
			appendable.append(overridden.getSimpleName());
		}
		appendable.append("(");
		List<JvmFormalParameter> parameterList = overridden.getParameters();
		for (int i = 0; i < parameterList.size(); i++) {
			JvmFormalParameter param = parameterList.get(i);
			if (i != 0)
				appendable.append(", ");
			isFirst = false;
			if (isCall) {
				appendable.append(appendable.getName(param));
			} else {
				JvmTypeReference overriddenParameterType = typeArgumentContext.getLowerBound(param.getParameterType());
				boolean insertDots = false;
				if (overridden.isVarArgs() && overriddenParameterType instanceof JvmGenericArrayTypeReference) {
					overriddenParameterType = ((JvmGenericArrayTypeReference) overriddenParameterType).getComponentType();
					insertDots = true;
				}
				if (overridden instanceof JvmOperation && annotationLookup.findAnnotation(param, Extension.class) != null) {
					appendable.append("extension ");
				}
				typeReferenceSerializer.serialize(overriddenParameterType, context, appendable, false, false, false,
						true);
				if (insertDots) {
					appendable.append("...");
				}
				String declareVariable = (appendable instanceof StringBuilderBasedAppendable) ? ((StringBuilderBasedAppendable) appendable)
						.declareSyntheticVariable(param, param.getName()) : appendable.declareVariable(param,
						param.getName());
				appendable.append(" ").append(declareVariable);
			}
		}
		appendable.append(")");
	}
	
	protected boolean hasDefaultUpperBounds(JvmTypeParameter typeParameter) {
		return typeParameter.getConstraints().size() == 1 
				&& typeParameter.getConstraints().get(0) instanceof JvmUpperBound 
				&& equal("java.lang.Object", typeParameter.getConstraints().get(0).getTypeReference().getIdentifier());
			
	}
}
