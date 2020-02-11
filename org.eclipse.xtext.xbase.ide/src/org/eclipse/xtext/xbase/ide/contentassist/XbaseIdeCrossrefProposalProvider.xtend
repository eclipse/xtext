/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.contentassist

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

class XbaseIdeCrossrefProposalProvider extends IdeCrossrefProposalProvider {
	
	@Inject CommonTypeComputationServices typeComputationServices
	
	override createProposal(IEObjectDescription candidate, CrossReference crossRef, ContentAssistContext context) {
		if (crossRef.hasIdRule) {
			val bracketInfo = getProposalBracketInfo(candidate, context)
			val proposalString = qualifiedNameConverter.toString(candidate.name) + bracketInfo.brackets
			val insignificantParameters =
				if (candidate instanceof IIdentifiableElementDescription)
					candidate.numberOfIrrelevantParameters
				else
					0
			val converter = getTypeConverter(context.resource)
			val objectOrProxy = candidate.getEObjectOrProxy
			return proposalCreator.createProposal(proposalString, context) [ result |
				result.kind = ContentAssistEntry.KIND_REFERENCE
				if (objectOrProxy instanceof JvmFeature) {
					if (bracketInfo.brackets.startsWith(" =")) {
						addNameAndDescription(result, objectOrProxy,
							false, insignificantParameters,
							qualifiedNameConverter.toString(candidate.name) + bracketInfo.brackets,
							converter)
					} else {
						addNameAndDescription(result, objectOrProxy,
							!bracketInfo.brackets.nullOrEmpty, insignificantParameters,
							qualifiedNameConverter.toString(candidate.name),
							converter);
					}
				} else {
					addNameAndDescription(result, objectOrProxy,
						qualifiedNameConverter.toString(candidate.qualifiedName),
						qualifiedNameConverter.toString(candidate.name))
				}
				var offset = context.offset - context.prefix.length + proposalString.length
				result.escapePosition = offset + bracketInfo.caretOffset
				if (bracketInfo.selectionOffset != 0) {
					offset += bracketInfo.selectionOffset
					result.editPositions += new TextRegion(offset, bracketInfo.selectionLength)
				}
				if (objectOrProxy instanceof JvmExecutable) {
					val parameterList = new StringBuilder
					appendParameters(parameterList, objectOrProxy, insignificantParameters, converter)
				}
			]
		}
		return super.createProposal(candidate, crossRef, context)
	}
	
	protected def hasIdRule(CrossReference crossRef) {
		if (crossRef.terminal instanceof RuleCall) {
			val ruleName = (crossRef.terminal as RuleCall).rule.name
			return ruleName == 'IdOrSuper' || ruleName == 'ValidID' || ruleName == 'FeatureCallID'
		}
	}
	
	static class ProposalBracketInfo {
		String brackets = "";
		int selectionOffset = 0;
		int selectionLength = 0;
		int caretOffset = 0;
	}
	
	protected def getProposalBracketInfo(IEObjectDescription proposedDescription, ContentAssistContext contentAssistContext) {
		val info = new ProposalBracketInfo
		if (proposedDescription instanceof IIdentifiableElementDescription) {
			val jvmFeature = proposedDescription.elementOrProxy
			if (jvmFeature instanceof JvmExecutable) {
				val parameters = jvmFeature.parameters
				if (proposedDescription.numberOfParameters == 1) {
					if (jvmFeature.simpleName.startsWith('set') && !proposedDescription.name.firstSegment.startsWith('set')) {
						info.brackets = ' = value'
						info.selectionOffset = -'value'.length
						info.selectionLength = 'value'.length
						return info
					}
					val parameterType = parameters.last.parameterType
					val light = getTypeConverter(contentAssistContext.resource).toLightweightReference(parameterType)
					if (light.isFunctionType) {
						val numParameters = light.asFunctionTypeReference.parameterTypes.size
						if (numParameters == 1) {
							info.brackets = '[]'
							info.caretOffset = -1
							return info
						} else if (numParameters == 0) {
					 		info.brackets = '[|]'
							info.caretOffset = -1
							return info
						} else {
					 		val b = new StringBuilder
					 		for (var i = 0; i < numParameters; i++) {
					 			if (i != 0) {
					 				b.append(', ')
					 			}
					 			b.append('p' + (i + 1))
					 		}
					 		info.brackets = '[' + b.toString + '|]'
					 		info.caretOffset = -1
					 		info.selectionOffset = -b.length - 2
					 		info.selectionLength = b.length
					 		return info
					 	}
					}
				}
			}
			if (isExplicitOperationCall(proposedDescription)) {
				info.brackets = '()'
				info.selectionOffset = -1
			}
		}
		return info
	}

	protected def getTypeConverter(XtextResource context) {
		new LightweightTypeReferenceFactory(new StandardTypeReferenceOwner(typeComputationServices, context)) {
			override doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
				val result = super.doVisitParameterizedTypeReference(reference)
				if (result.isFunctionType) {
					return result.tryConvertToFunctionTypeReference(false)
				}
				return result
			}
		}
	}

	protected def addNameAndDescription(ContentAssistEntry entry, JvmFeature feature, boolean withParents,
			int insignificantParameters, String shortName, LightweightTypeReferenceFactory converter) {
		val labelBuilder = new StringBuilder(shortName)
		val descriptionBuilder = new StringBuilder
		if (feature instanceof JvmOperation) {
			if (withParents) {
				labelBuilder.append('(')
				appendParameters(labelBuilder, feature, insignificantParameters, converter)
				labelBuilder.append(')')
			}
			val returnType = feature.returnType
			if (returnType !== null && returnType.simpleName !== null) {
				labelBuilder.append(' : ')
				labelBuilder.append(converter.toLightweightReference(returnType).humanReadableName)
			}
			descriptionBuilder.append(converter.toPlainTypeReference(feature.declaringType).humanReadableName)
			if (!withParents) {
				descriptionBuilder.append('.')
				descriptionBuilder.append(feature.simpleName)
				descriptionBuilder.append('()')
			}
		} else if (feature instanceof JvmField) {
			labelBuilder.append(' : ')
			if (feature.type !== null) {
				val fieldType = converter.toLightweightReference(feature.type).humanReadableName
				if (fieldType !== null)
					labelBuilder.append(fieldType)
			}
			descriptionBuilder.append(converter.toPlainTypeReference(feature.declaringType).humanReadableName)
		} else if (feature instanceof JvmConstructor) {
			if (withParents) {
				labelBuilder.append('(')
				appendParameters(labelBuilder, feature, insignificantParameters, converter)
				labelBuilder.append(')')
			}
		}
		entry.label = labelBuilder.toString
		entry.description = descriptionBuilder.toString
	}

	protected def addNameAndDescription(ContentAssistEntry entry, EObject element, String qualifiedNameAsString, String shortName) {
		val qualifiedName = qualifiedNameConverter.toQualifiedName(qualifiedNameAsString)
		if (qualifiedName.segmentCount > 1) {
			entry.label = qualifiedName.lastSegment
			entry.description = qualifiedNameAsString
		} else {
			entry.label =  qualifiedNameAsString
		}
	}
	
	protected def appendParameters(StringBuilder result, JvmExecutable executable, int insignificantParameters,
			LightweightTypeReferenceFactory ownedConverter) {
		val declaredParameters = executable.parameters
		val relevantParameters = declaredParameters.subList(Math.min(insignificantParameters, declaredParameters.size), declaredParameters.size)
		for (var i = 0; i < relevantParameters.size; i++) {
			val parameter = relevantParameters.get(i)
			if (i != 0)
				result.append(', ')
			if (i == relevantParameters.size - 1 && executable.isVarArgs && parameter.parameterType instanceof JvmGenericArrayTypeReference) {
				val parameterType = parameter.parameterType as JvmGenericArrayTypeReference
				result.append(ownedConverter.toLightweightReference(parameterType.componentType).humanReadableName)
				result.append('...')
			} else {
				if (parameter.parameterType !== null) {
					val simpleName = ownedConverter.toLightweightReference(parameter.parameterType).humanReadableName
					if (simpleName !== null)
						result.append(simpleName)
				}
			}
			result.append(' ')
			result.append(String.valueOf(parameter.name))
		}
	}
	
	protected def isExplicitOperationCall(IIdentifiableElementDescription desc) {
		desc.numberOfParameters > 0
	}
	
}
			
