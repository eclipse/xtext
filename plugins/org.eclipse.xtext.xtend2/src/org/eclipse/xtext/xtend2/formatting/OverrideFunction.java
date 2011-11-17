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
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xtend2.formatting.OrganizeImports.ReferenceAcceptor;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OverrideFunction {

	public static final String DEFAULT_BODY = "throw new UnsupportedOperationException(\"Auto-generated function stub\")";

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private CustomTypeReferenceSerializer typeReferenceSerializer;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private IXtend2JvmAssociations associations;

	@Inject
	private IIndentationInformation indentationInformation;

	public String createOverrideFunction(final XtendClass overrider, JvmOperation overriddenOperation, ReferenceAcceptor acceptor) {
		StringBuilderBasedAppendable b = new StringBuilderBasedAppendable(new ImportManager(true),
				indentationInformation.getIndentString());
		b.increaseIndentation();
		final JvmGenericType overridingType = associations.getInferredType(overrider);
		typeReferenceSerializer.setOverridingType(overridingType);
		final ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider
				.getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmTypeReference getReceiverType() {
						return typeReferences.createTypeRef(overridingType);
					}
				});
		b.append("\n").append("override ");
		if(overriddenOperation.getVisibility() == JvmVisibility.PROTECTED) {
			b.append("protected ");
		}
		boolean isFirst = true;
		if (!isEmpty(overriddenOperation.getTypeParameters())) {
			b.append("<");
			for (JvmTypeParameter typeParameter : overriddenOperation.getTypeParameters()) {
				if (!isFirst)
					b.append(", ");
				isFirst = false;
				b.append(typeParameter);
			}
			b.append("> ");
		}
		b.append(overriddenOperation.getSimpleName()).append("(");
		isFirst = true;
		for (JvmFormalParameter param : overriddenOperation.getParameters()) {
			if (!isFirst)
				b.append(", ");
			isFirst = false;
			JvmTypeReference overriddenParameterType = typeArgumentContext.getLowerBound(param.getParameterType());
			acceptor.acceptType(overriddenParameterType);
			typeReferenceSerializer.serialize(overriddenParameterType,
					overriddenOperation, b);
			b.append(" ").append(param.getName());
		}
		b.append(")");
		if (!overriddenOperation.getExceptions().isEmpty()) {
			b.append(" throws ");
			isFirst = true;
			for (JvmTypeReference exception : overriddenOperation.getExceptions()) {
				if (!isFirst)
					b.append(", ");
				isFirst = false;
				typeReferenceSerializer.serialize(exception, overridingType, b);
				acceptor.acceptType(exception);
			}
		}
		b.append(" {").increaseIndentation()
				.append("\n" + DEFAULT_BODY)
				.decreaseIndentation().append("\n}").decreaseIndentation().append("\n\n");
		return b.toString();
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
	
	protected static class CustomTypeReferenceSerializer extends TypeReferenceSerializer {

		private JvmGenericType overridingType;

		public void setOverridingType(JvmGenericType overridingType) {
			this.overridingType = overridingType;
		}
		
		@Override
		public boolean isLocalTypeParameter(EObject context, JvmTypeParameter parameter) {
			return super.isLocalTypeParameter(context, parameter) || super.isLocalTypeParameter(overridingType, parameter);
		}
	}

}
