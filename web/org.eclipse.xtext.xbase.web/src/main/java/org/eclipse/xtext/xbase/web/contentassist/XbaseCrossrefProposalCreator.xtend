package org.eclipse.xtext.xbase.web.contentassist

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.eclipse.xtext.web.server.contentassist.CrossrefProposalCreator
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

class XbaseCrossrefProposalCreator extends CrossrefProposalCreator {
	
	val String ruleName
	
	val CommonTypeComputationServices typeComputationServices
	
	new(ContentAssistContext contentAssistContext, IQualifiedNameConverter qualifiedNameConverter,
			CommonTypeComputationServices typeComputationServices, String ruleName) {
		super(contentAssistContext, qualifiedNameConverter)
		this.typeComputationServices = typeComputationServices
		this.ruleName = ruleName
	}
	
	override apply(IEObjectDescription candidate) {
		if (candidate instanceof IIdentifiableElementDescription && ruleName.isIdRule) {
			val bracketInfo = getProposalBracketInfo(candidate, contentAssistContext)
			val proposalString = qualifiedNameConverter.toString(candidate.name) + bracketInfo.brackets
			var int insignificantParameters = 0
			if (candidate instanceof IIdentifiableElementDescription) {
				insignificantParameters = candidate.numberOfIrrelevantParameters
			}
			val converter = getTypeConverter(contentAssistContext.resource)
			val objectOrProxy = candidate.EObjectOrProxy
			val result = new ContentAssistResult.Entry(ContentAssistResult.CROSSREF, contentAssistContext.prefix) => [
				proposal = proposalString
			]
			if (objectOrProxy instanceof JvmFeature) {
				if (bracketInfo.brackets.startsWith(" =")) {
					addNameAndDescription(result, objectOrProxy as JvmFeature,
						false, insignificantParameters,
						qualifiedNameConverter.toString(candidate.name) + bracketInfo.brackets,
						converter)
				} else {
					addNameAndDescription(result, objectOrProxy as JvmFeature,
						!bracketInfo.brackets.nullOrEmpty, insignificantParameters,
						qualifiedNameConverter.toString(candidate.name),
						converter);
				}
			} else {
				addNameAndDescription(result, objectOrProxy,
					qualifiedNameConverter.toString(candidate.qualifiedName),
					qualifiedNameConverter.toString(candidate.name))
			}
			var offset = contentAssistContext.offset + proposalString.length
			result.escapePosition = offset + bracketInfo.caretOffset
			if (bracketInfo.selectionOffset != 0) {
				offset += bracketInfo.selectionOffset
				result.editPositions += new ContentAssistResult.EditPosition(offset, bracketInfo.selectionLength)
			}
			if (objectOrProxy instanceof JvmExecutable) {
				val parameterList = new StringBuilder
				appendParameters(parameterList, objectOrProxy, insignificantParameters, converter)
			}
			return result
		}
		return super.apply(candidate)
	}
	
	protected def isIdRule(String ruleName) {
		ruleName == 'IdOrSuper' || ruleName == 'ValidID' || ruleName == 'FeatureCallID'
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

	protected def addNameAndDescription(ContentAssistResult.Entry entry, JvmFeature feature, boolean withParents,
			int insignificantParameters, String shortName, LightweightTypeReferenceFactory converter) {
		val nameBuilder = new StringBuilder(shortName)
		val descriptionBuilder = new StringBuilder
		if (feature instanceof JvmOperation) {
			if (withParents) {
				nameBuilder.append('(')
				appendParameters(nameBuilder, feature, insignificantParameters, converter)
				nameBuilder.append(')')
			}
			val returnType = feature.returnType
			if (returnType != null && returnType.simpleName != null) {
				nameBuilder.append(' : ')
				nameBuilder.append(converter.toLightweightReference(returnType).humanReadableName)
			}
			descriptionBuilder.append(converter.toPlainTypeReference(feature.declaringType).humanReadableName)
			if (!withParents) {
				descriptionBuilder.append('.')
				descriptionBuilder.append(feature.simpleName)
				descriptionBuilder.append('()')
			}
		} else if (feature instanceof JvmField) {
			nameBuilder.append(' : ')
			if (feature.type != null) {
				val fieldType = converter.toLightweightReference(feature.type).humanReadableName
				if (fieldType != null)
					nameBuilder.append(fieldType)
			}
			descriptionBuilder.append(converter.toPlainTypeReference(feature.declaringType).humanReadableName)
		} else if (feature instanceof JvmConstructor) {
			if (withParents) {
				nameBuilder.append('(')
				appendParameters(nameBuilder, feature, insignificantParameters, converter)
				nameBuilder.append(')')
			}
		}
		entry.name = nameBuilder.toString
		entry.description = descriptionBuilder.toString
	}

	protected def addNameAndDescription(ContentAssistResult.Entry entry, EObject element, String qualifiedNameAsString, String shortName) {
		val qualifiedName = qualifiedNameConverter.toQualifiedName(qualifiedNameAsString)
		if (qualifiedName.segmentCount > 1) {
			entry.name = qualifiedName.lastSegment
			entry.description = qualifiedNameAsString
		} else {
			entry.name =  qualifiedNameAsString
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
				if (parameter.parameterType != null) {
					val simpleName = ownedConverter.toLightweightReference(parameter.parameterType).humanReadableName
					if (simpleName != null)
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