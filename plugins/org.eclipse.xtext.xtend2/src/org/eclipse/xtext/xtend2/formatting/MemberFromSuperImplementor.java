/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.formatting;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class MemberFromSuperImplementor {

	public static final String DEFAULT_BODY = "throw new UnsupportedOperationException(\"Auto-generated function stub\")";

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private TypeReferenceSerializer typeReferenceSerializer;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private IXtend2JvmAssociations associations;

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
		appendable.append(" {").increaseIndentation().append("\n");
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
		appendable.decreaseIndentation().append("\n}");
		appendable.closeScope();
	}

	protected void appendSignature(JvmExecutable overridden, EObject context,
			final ITypeArgumentContext typeArgumentContext, IAppendable appendable, boolean isCall) {
		boolean isFirst = true;
		if (!isEmpty(overridden.getTypeParameters())) {
			appendable.append("<");
			for (JvmTypeParameter typeParameter : overridden.getTypeParameters()) {
				if (!isFirst)
					appendable.append(", ");
				isFirst = false;
				appendable.append(typeParameter);
			}
			appendable.append("> ");
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
		isFirst = true;
		for (JvmFormalParameter param : overridden.getParameters()) {
			if (!isFirst)
				appendable.append(", ");
			isFirst = false;
			if (isCall) {
				appendable.append(appendable.getName(param));
			} else {
				JvmTypeReference overriddenParameterType = typeArgumentContext.getLowerBound(param.getParameterType());
				typeReferenceSerializer.serialize(overriddenParameterType, context, appendable, false, false, false,
						true);
				String declareVariable = (appendable instanceof StringBuilderBasedAppendable) ? ((StringBuilderBasedAppendable) appendable)
						.declareSyntheticVariable(param, param.getName()) : appendable.declareVariable(param,
						param.getName());
				appendable.append(" ").append(declareVariable);
			}
		}
		appendable.append(")");
	}

	public int getFunctionInsertOffset(XtendClass clazz) {
		ICompositeNode clazzNode = NodeModelUtils.findActualNodeFor(clazz);
		int lastClosingBraceOffset = -1;
		for (ILeafNode leafNode : clazzNode.getLeafNodes()) {
			if (leafNode.getGrammarElement() instanceof Keyword
					&& equal("}", ((Keyword) leafNode.getGrammarElement()).getValue())) {
				lastClosingBraceOffset = leafNode.getOffset();
			}
		}
		return (lastClosingBraceOffset == -1) ? lastClosingBraceOffset = clazzNode.getTotalEndOffset()
				: lastClosingBraceOffset;
	}

	public int getConstructorInsertOffset(XtendClass clazz) {
		return getFunctionInsertOffset(clazz);
	}

}
