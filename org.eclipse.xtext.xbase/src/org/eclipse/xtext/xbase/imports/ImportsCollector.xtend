/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class ImportsCollector {
	@Inject XbaseGrammarAccess grammarAccess

	/**
	 * Collects import declarations in XtextResource for the given range (selectedRegion) 
	 */
	def void collectImports(XtextResource state, ITextRegion selectedRegion, ImportsAcceptor acceptor) {
		var ICompositeNode rootNode = state.getParseResult().getRootNode()
		val selectedSemanticObj = findActualSemanticObjectFor(rootNode, selectedRegion)

		val contentsIterator = NodeModelUtils.findActualNodeFor(selectedSemanticObj).leafNodes
		for (ILeafNode node : contentsIterator) {
			val nodeRegion = node.totalTextRegion
			if (selectedRegion.contains(nodeRegion)) {
				val semanticElement = node.semanticElement
				if (semanticElement !== null) {
					visit(semanticElement, NodeModelUtils.findActualNodeFor(semanticElement), acceptor)
				}
			}
			// Handle javadoc
			if (node.isHidden && grammarAccess.ML_COMMENTRule.equals(node.grammarElement)) {
				node.addJavaDocReferences(selectedRegion, acceptor)
			}
		}
	}

	def EObject findActualSemanticObjectFor(ICompositeNode rootNode, ITextRegion textRegion) {
		var ILeafNode leafNodeAtOffset = NodeModelUtils.findLeafNodeAtOffset(rootNode, textRegion.offset)
		var EObject semanticElementOffset = leafNodeAtOffset.getSemanticElement()
		var ICompositeNode actualOffsetNode = NodeModelUtils.findActualNodeFor(semanticElementOffset)
		val endOffset = textRegion.offset + textRegion.length
		while (actualOffsetNode.getParent() !== null && actualOffsetNode.getTotalEndOffset() < endOffset) {
			actualOffsetNode = actualOffsetNode.getParent()
		}
		val actualSemanticObj = actualOffsetNode.semanticElement
		return actualSemanticObj
	}

	dispatch def void visit(EObject semanticObj, INode originNode, ImportsAcceptor acceptor) {
	}

	dispatch def void visit(JvmTypeReference semanticElement, INode originNode, ImportsAcceptor acceptor) {
		visit(semanticElement.getType(), originNode, acceptor)
	}

	dispatch def void visit(XAbstractFeatureCall semanticObj, INode originNode, ImportsAcceptor acceptor) {
		collectStaticImportsFrom(semanticObj, acceptor)
	}

	dispatch def void visit(XMemberFeatureCall semanticObj, INode originNode, ImportsAcceptor acceptor) {
		if (semanticObj.getFeature() instanceof JvmType && semanticObj.isTypeLiteral()) {
			visit(semanticObj.getFeature() as JvmType, originNode, acceptor)
		}
		if (!semanticObj.isExplicitStatic()) {
			val target = semanticObj.getMemberCallTarget();
			if (target instanceof XAbstractFeatureCall) {
				if (target.typeLiteral) {
					return
				}
			}
			collectStaticImportsFrom(semanticObj, acceptor)
		}
	}

	dispatch def void visit(XFeatureCall semanticObj, INode originNode, ImportsAcceptor acceptor) {
		if (semanticObj.getFeature() instanceof JvmType && semanticObj.isTypeLiteral()) {
			visit(semanticObj.getFeature() as JvmType, originNode, acceptor)
		} else {
			collectStaticImportsFrom(semanticObj, acceptor)
		}
	}

	dispatch def void visit(JvmGenericType jvmType, INode originNode, ImportsAcceptor acceptor) {
		if (jvmType.anonymous) {
			visit(jvmType.superTypes.last.type, originNode, acceptor)
		} else {
			_visit(jvmType as JvmDeclaredType, originNode, acceptor)
		}
	}

	dispatch def void visit(JvmDeclaredType jvmType, INode originNode, ImportsAcceptor acceptor) {
		if (jvmType.getDeclaringType() === null) {
			collectTypeImportFrom(jvmType, acceptor)
		}
		val text = NodeModelUtils.getTokenText(originNode);
		val outerSegment = getFirstNameSegment(text);
		val outerType = findDeclaringTypeBySimpleName(jvmType, outerSegment);
		if (outerType === null) {
			throw new IllegalStateException();
		}
		collectTypeImportFrom(outerType, acceptor)
	}

	def private JvmDeclaredType findDeclaringTypeBySimpleName(JvmDeclaredType referencedType, String outerSegment) {
		if (referencedType.getDeclaringType() === null || outerSegment.equals(referencedType.getSimpleName())) {
			return referencedType
		}
		return findDeclaringTypeBySimpleName(referencedType.getDeclaringType(), outerSegment)
	}

	dispatch def void visit(XConstructorCall semanticElement, INode originNode, ImportsAcceptor acceptor) {
		visit(semanticElement.constructor.declaringType, originNode, acceptor)
	}

	dispatch def void visit(XAnnotation semanticElement, INode originNode, ImportsAcceptor acceptor) {
		visit(semanticElement.getAnnotationType(), originNode, acceptor)
	}

	dispatch def void visit(XTypeLiteral semanticElement, INode originNode, ImportsAcceptor acceptor) {
		val elementNode = NodeModelUtils.findNodesForFeature(semanticElement, XbasePackage.Literals.XTYPE_LITERAL__TYPE)
		visit(semanticElement.type, elementNode.head, acceptor)
	}

	dispatch def void visit(Void nullCase, INode originNode, ImportsAcceptor acceptor) {
	}

	def protected collectTypeImportFrom(JvmDeclaredType type, ImportsAcceptor acceptor) {
		acceptor.acceptTypeImport(type)
	}

	def  protected void collectStaticImportsFrom(XAbstractFeatureCall abstractFeatureCall, ImportsAcceptor acceptor) {
		if (abstractFeatureCall.isStatic()) {
			if (abstractFeatureCall.isExtension()) {
				acceptor.acceptStaticExtensionImport(abstractFeatureCall)
			} else {
				acceptor.acceptStaticImport(abstractFeatureCall)
			}
		}
	}

	def protected String getFirstNameSegment(String text_finalParam_) {
		var text = text_finalParam_
		var int firstDelimiter = text.indexOf(Character.valueOf('.').charValue)
		if (firstDelimiter == -1) {
			firstDelimiter = text.indexOf(Character.valueOf('$').charValue)
		} else {
			var int dollar = text.indexOf(Character.valueOf('$').charValue)
			if (dollar != -1) {
				firstDelimiter = Math.min(firstDelimiter, dollar)
			}
		}
		if (firstDelimiter == -1) {
			firstDelimiter = text.indexOf("::")
			if (firstDelimiter == text.length() - 2 && firstDelimiter >= 0) {
				text = text.substring(0, firstDelimiter)
				firstDelimiter = -1
			}
		} else {
			var int colon = text.indexOf("::")
			if (colon != text.length() - 2 && colon != -1) {
				firstDelimiter = Math.min(firstDelimiter, colon)
			}
		}
		if (firstDelimiter != -1) {
			return text.substring(0, firstDelimiter)
		}
		return text
	}

	// TODO Javadoc inspection could be refactored out somewhere 
	@Inject IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider

	@Inject IScopeProvider scopeProvider

	def private void addJavaDocReferences(INode documentationNode, ITextRegion selectedRegion,
		ImportsAcceptor acceptor) {
		for (ReplaceRegion docTypeReference : javaDocTypeReferenceProvider.computeTypeRefRegions(documentationNode)) {
			val referenceRange = new TextRegion(docTypeReference.offset, docTypeReference.length)
			if (selectedRegion.contains(referenceRange)) {
				var String docTypeText = docTypeReference.getText()
				val element = NodeModelUtils.findActualSemanticObjectFor(documentationNode)
				var IScope scope = scopeProvider.getScope(element,
					TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
				var IEObjectDescription singleElement = scope.getSingleElement(QualifiedName.create(docTypeText))
				var JvmType referencedType = null
				if (singleElement !== null) {
					referencedType = singleElement.getEObjectOrProxy() as JvmType
				}
				if (referencedType instanceof JvmDeclaredType && !referencedType.eIsProxy()) {
					var casted = referencedType as JvmDeclaredType
					if (!casted.qualifiedName.equals(docTypeText)) {
						acceptor.acceptTypeImport(casted)
					}
				}
			}
		}
	}

}
