/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.common.base.Strings;
import com.google.inject.Inject;

public class XbaseIdeCrossrefProposalProvider extends IdeCrossrefProposalProvider {
	public static class ProposalBracketInfo {
		private String brackets = "";

		private int selectionOffset = 0;

		private int selectionLength = 0;

		private int caretOffset = 0;
	}

	@Inject
	private CommonTypeComputationServices typeComputationServices;

	@Override
	public ContentAssistEntry createProposal(IEObjectDescription candidate, CrossReference crossRef,
			ContentAssistContext context) {
		if (hasIdRule(crossRef)) {
			ProposalBracketInfo bracketInfo = getProposalBracketInfo(candidate, context);
			String proposalString = getQualifiedNameConverter().toString(candidate.getName()) + bracketInfo.brackets;
			final int insignificantParameters;
			if (candidate instanceof IIdentifiableElementDescription) {
				insignificantParameters = ((IIdentifiableElementDescription) candidate)
						.getNumberOfIrrelevantParameters();
			} else {
				insignificantParameters = 0;
			}
			LightweightTypeReferenceFactory converter = getTypeConverter(context.getResource());
			EObject objectOrProxy = candidate.getEObjectOrProxy();
			return getProposalCreator().createProposal(proposalString, context, (ContentAssistEntry result) -> {
				result.setKind(ContentAssistEntry.KIND_REFERENCE);
				if (objectOrProxy instanceof JvmFeature) {
					if (bracketInfo.brackets.startsWith(" =")) {
						addNameAndDescription(result, (JvmFeature) objectOrProxy, false, insignificantParameters,
								getQualifiedNameConverter().toString(candidate.getName()) + bracketInfo.brackets,
								converter);
					} else {
						addNameAndDescription(result, (JvmFeature) objectOrProxy,
								!Strings.isNullOrEmpty(bracketInfo.brackets), insignificantParameters,
								getQualifiedNameConverter().toString(candidate.getName()), converter);
					}
				} else {
					addNameAndDescription(result, objectOrProxy,
							getQualifiedNameConverter().toString(candidate.getQualifiedName()),
							getQualifiedNameConverter().toString(candidate.getName()));
				}
				int offset = context.getOffset() - context.getPrefix().length() + proposalString.length();
				result.setEscapePosition(offset + bracketInfo.caretOffset);
				if (bracketInfo.selectionOffset != 0) {
					offset = offset + bracketInfo.selectionOffset;
					result.getEditPositions().add(new TextRegion(offset, bracketInfo.selectionLength));
				}
				if (objectOrProxy instanceof JvmExecutable) {
					StringBuilder parameterList = new StringBuilder();
					appendParameters(parameterList, (JvmExecutable) objectOrProxy, insignificantParameters, converter);
				}
			});
		}
		return super.createProposal(candidate, crossRef, context);
	}

	protected boolean hasIdRule(CrossReference crossRef) {
		if (crossRef.getTerminal() instanceof RuleCall) {
			String ruleName = ((RuleCall) crossRef.getTerminal()).getRule().getName();
			return "IdOrSuper".equals(ruleName) || "ValidID".equals(ruleName) || "FeatureCallID".equals(ruleName);
		}
		return false;
	}

	protected ProposalBracketInfo getProposalBracketInfo(IEObjectDescription proposedDescription,
			ContentAssistContext contentAssistContext) {
		ProposalBracketInfo info = new ProposalBracketInfo();
		if (proposedDescription instanceof IIdentifiableElementDescription) {
			JvmIdentifiableElement jvmFeature = ((IIdentifiableElementDescription) proposedDescription)
					.getElementOrProxy();
			if (jvmFeature instanceof JvmExecutable) {
				List<JvmFormalParameter> parameters = ((JvmExecutable) jvmFeature).getParameters();
				if (((IIdentifiableElementDescription) proposedDescription).getNumberOfParameters() == 1) {
					if (((JvmExecutable) jvmFeature).getSimpleName().startsWith("set")
							&& !((IIdentifiableElementDescription) proposedDescription).getName().getFirstSegment()
									.startsWith("set")) {
						info.brackets = " = value";
						info.selectionOffset = -"value".length();
						info.selectionLength = "value".length();
						return info;
					}
					JvmTypeReference parameterType = IterableExtensions.<JvmFormalParameter>lastOrNull(parameters)
							.getParameterType();
					LightweightTypeReference light = getTypeConverter(contentAssistContext.getResource())
							.toLightweightReference(parameterType);
					if (light.isFunctionType()) {
						int numParameters = light.getAsFunctionTypeReference().getParameterTypes().size();
						if (numParameters == 1) {
							info.brackets = "[]";
							info.caretOffset = -1;
							return info;
						} else if (numParameters == 0) {
							info.brackets = "[|]";
							info.caretOffset = -1;
							return info;
						} else {
							StringBuilder b = new StringBuilder();
							for (int i = 0; (i < numParameters); i++) {
								if (i != 0) {
									b.append(", ");
								}
								b.append("p" + (i + 1));
							}
							info.brackets = ("[" + b.toString() + "|]");
							info.caretOffset = -1;
							info.selectionOffset = (-b.length()) - 2;
							info.selectionLength = b.length();
							return info;
						}
					}
				}
			}
			if (isExplicitOperationCall((IIdentifiableElementDescription) proposedDescription)) {
				info.brackets = "()";
				info.selectionOffset = -1;
			}
		}
		return info;
	}

	protected LightweightTypeReferenceFactory getTypeConverter(XtextResource context) {
		return new LightweightTypeReferenceFactory(new StandardTypeReferenceOwner(typeComputationServices, context)) {
			@Override
			public LightweightTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
				LightweightTypeReference result = super.doVisitParameterizedTypeReference(reference);
				if (result.isFunctionType()) {
					return result.tryConvertToFunctionTypeReference(false);
				}
				return result;
			}
		};
	}

	protected void addNameAndDescription(ContentAssistEntry entry, JvmFeature feature, boolean withParents,
			int insignificantParameters, String shortName, LightweightTypeReferenceFactory converter) {
		StringBuilder labelBuilder = new StringBuilder(shortName);
		StringBuilder descriptionBuilder = new StringBuilder();
		if (feature instanceof JvmOperation) {
			if (withParents) {
				labelBuilder.append("(");
				appendParameters(labelBuilder, (JvmExecutable) feature, insignificantParameters, converter);
				labelBuilder.append(")");
			}
			JvmOperation jvmOperation = (JvmOperation) feature;
			JvmTypeReference returnType = jvmOperation.getReturnType();
			if (returnType != null && returnType.getSimpleName() != null) {
				labelBuilder.append(" : ");
				labelBuilder.append(converter.toLightweightReference(returnType).getHumanReadableName());
			}
			descriptionBuilder.append(
					converter.toPlainTypeReference(jvmOperation.getDeclaringType()).getHumanReadableName());
			if (!withParents) {
				descriptionBuilder.append(".");
				descriptionBuilder.append(jvmOperation.getSimpleName());
				descriptionBuilder.append("()");
			}
		} else {
			if (feature instanceof JvmField) {
				labelBuilder.append(" : ");
				JvmField jvmField = (JvmField) feature;
				if (jvmField.getType() != null) {
					String fieldType = converter.toLightweightReference(jvmField.getType())
							.getHumanReadableName();
					if (fieldType != null) {
						labelBuilder.append(fieldType);
					}
				}
				descriptionBuilder.append(
						converter.toPlainTypeReference(jvmField.getDeclaringType()).getHumanReadableName());
			} else if (feature instanceof JvmConstructor) {
				if (withParents) {
					labelBuilder.append("(");
					appendParameters(labelBuilder, ((JvmExecutable) feature), insignificantParameters, converter);
					labelBuilder.append(")");
				}
			}
		}
		entry.setLabel(labelBuilder.toString());
		entry.setDescription(descriptionBuilder.toString());
	}

	protected void addNameAndDescription(ContentAssistEntry entry, EObject element, String qualifiedNameAsString,
			String shortName) {
		QualifiedName qualifiedName = getQualifiedNameConverter().toQualifiedName(qualifiedNameAsString);
		if (qualifiedName.getSegmentCount() > 1) {
			entry.setLabel(qualifiedName.getLastSegment());
			entry.setDescription(qualifiedNameAsString);
		} else {
			entry.setLabel(qualifiedNameAsString);
		}
	}

	protected void appendParameters(StringBuilder result, JvmExecutable executable, int insignificantParameters,
			LightweightTypeReferenceFactory ownedConverter) {
		List<JvmFormalParameter> declaredParameters = executable.getParameters();
		List<JvmFormalParameter> relevantParameters = declaredParameters
				.subList(Math.min(insignificantParameters, declaredParameters.size()), declaredParameters.size());
		for (int i = 0; i < relevantParameters.size(); i++) {
			JvmFormalParameter parameter = relevantParameters.get(i);
			if (i != 0) {
				result.append(", ");
			}
			if (i == relevantParameters.size() - 1 && executable.isVarArgs()
					&& parameter.getParameterType() instanceof JvmGenericArrayTypeReference) {
				JvmGenericArrayTypeReference parameterType = (JvmGenericArrayTypeReference) parameter
						.getParameterType();
				result.append(
						ownedConverter.toLightweightReference(parameterType.getComponentType()).getHumanReadableName());
				result.append("...");
			} else {
				if (parameter.getParameterType() != null) {
					String simpleName = ownedConverter.toLightweightReference(parameter.getParameterType())
							.getHumanReadableName();
					if (simpleName != null) {
						result.append(simpleName);
					}
				}
			}
			result.append(" ");
			result.append(String.valueOf(parameter.getName()));
		}
	}

	protected boolean isExplicitOperationCall(IIdentifiableElementDescription desc) {
		return desc.getNumberOfParameters() > 0;
	}
}
