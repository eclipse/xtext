/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xtype.XImportDeclaration;

import com.google.inject.Inject;
/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
public class XtypeProposalProvider extends AbstractXtypeProposalProvider {
	
	@Inject 
	private CommonTypeComputationServices services;
	
	@Inject
	private StaticallyImportedMemberProvider staticallyImportedMemberProvider;

	@Override
	public void completeXImportDeclaration_MemberName(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof XImportDeclaration) {
			XImportDeclaration importDeclaration = (XImportDeclaration) model;
			for (JvmFeature feature : staticallyImportedMemberProvider.findAllFeatures(importDeclaration)) {
				Image image = getImage(feature);
				LightweightTypeReferenceFactory typeConverter = getTypeConverter(context.getResource());
				StyledString displayString = getStyledDisplayString(feature, false, 0, feature.getQualifiedName(), feature.getSimpleName(), typeConverter);
				acceptor.accept(createCompletionProposal(feature.getSimpleName(), displayString, image, context));
			}
		}
	}

	protected StyledString getStyledDisplayString(JvmFeature feature, boolean withParents, int insignificantParameters, String qualifiedNameAsString, String shortName,
			LightweightTypeReferenceFactory converter) {
		StyledString result = new StyledString(shortName);
		if (feature instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) feature;
			if (withParents) {
				result.append('(');
				appendParameters(result, (JvmExecutable)feature, insignificantParameters, converter);
				result.append(')');
			}
			JvmTypeReference returnType = operation.getReturnType();
			if (returnType != null && returnType.getSimpleName() != null) {
				result.append(" : ");
				result.append(converter.toLightweightReference(returnType).getHumanReadableName());
			}
			result.append(" - ", StyledString.QUALIFIER_STYLER);
			result.append(converter.toPlainTypeReference(feature.getDeclaringType()).getHumanReadableName(), StyledString.QUALIFIER_STYLER);
			if (!withParents) {
				result.append(".", StyledString.QUALIFIER_STYLER);
				result.append(feature.getSimpleName(), StyledString.QUALIFIER_STYLER);
				result.append("()", StyledString.QUALIFIER_STYLER);
			}
		} else if (feature instanceof JvmField) {
			JvmField field = (JvmField) feature;
			result.append(" : ");
			if (field.getType() != null) {
				String fieldType = converter.toLightweightReference(field.getType()).getHumanReadableName();
				if (fieldType != null)
					result.append(fieldType);
			}
			result.append(" - ", StyledString.QUALIFIER_STYLER);
			result.append(converter.toPlainTypeReference(feature.getDeclaringType()).getHumanReadableName(), StyledString.QUALIFIER_STYLER);
		} else if (feature instanceof JvmConstructor) {
			if (withParents) {
				result.append('(');
				appendParameters(result, (JvmExecutable)feature, insignificantParameters, converter);
				result.append(')');
			}
		}
		return result;
	}

	protected void appendParameters(StyledString result, JvmExecutable executable, int insignificantParameters, LightweightTypeReferenceFactory ownedConverter) {
		List<JvmFormalParameter> declaredParameters = executable.getParameters();
		List<JvmFormalParameter> relevantParameters = declaredParameters.subList(Math.min(insignificantParameters, declaredParameters.size()), declaredParameters.size());
		for(int i = 0; i < relevantParameters.size(); i++) {
			JvmFormalParameter parameter = relevantParameters.get(i);
			if (i != 0)
				result.append(", ");
			if (i == relevantParameters.size() - 1 && executable.isVarArgs() && parameter.getParameterType() instanceof JvmGenericArrayTypeReference) {
				JvmGenericArrayTypeReference parameterType = (JvmGenericArrayTypeReference) parameter.getParameterType();
				result.append(ownedConverter.toLightweightReference(parameterType.getComponentType()).getHumanReadableName());
				result.append("...");
			} else {
				if (parameter.getParameterType()!= null) {
					String simpleName = ownedConverter.toLightweightReference(parameter.getParameterType()).getHumanReadableName();
					if (simpleName != null) // is null if the file is not on the class path
						result.append(simpleName);
				}
			}
			result.append(' ');
			result.append(notNull(parameter.getName()));
		}
	}

	protected LightweightTypeReferenceFactory getTypeConverter(XtextResource context) {
		return new LightweightTypeReferenceFactory(new StandardTypeReferenceOwner(services, context)) {
			@Override
			public LightweightTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
				LightweightTypeReference result = super.doVisitParameterizedTypeReference(reference);
				if (result.isFunctionType()) {
					FunctionTypeReference functionTypeReference = result.tryConvertToFunctionTypeReference(false);
					return functionTypeReference;
				}
				return result;
			}
		};
	}

}
