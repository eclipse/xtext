package org.eclipse.xtext.xbase.imports

import com.google.inject.Inject
import org.eclipse.emf.common.util.TreeIterator
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class ImportsCollector {
	@Inject ILocationInFileProvider locationInFileProvider

	/**
	 * Collects import declarations in XtextResource for the given range (offset -> endOffset) 
	 */
	def void collectImports(XtextResource state, int offset, int endOffset, ImportsAcceptor acceptor) {

		var ICompositeNode rootNode = state.getParseResult().getRootNode()

		var ILeafNode leafNodeAtOffset = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset)
		var EObject semanticElementOffset = leafNodeAtOffset.getSemanticElement()
		var ICompositeNode actualOffsetNode = NodeModelUtils.findActualNodeFor(semanticElementOffset)
		while (actualOffsetNode.getParent() != null && actualOffsetNode.getTotalEndOffset() < endOffset) {
			actualOffsetNode = actualOffsetNode.getParent()
		}
		val actualSemanticObj = actualOffsetNode.semanticElement
		actualSemanticObj.visitIfInRange(offset, endOffset, acceptor);

		val TreeIterator<EObject> contentsIterator = EcoreUtil.getAllContents(actualSemanticObj, true)
		while (contentsIterator.hasNext) {
			contentsIterator.next().visitIfInRange(offset, endOffset, acceptor)
		}

	}

	def visitIfInRange(EObject object, int offset, int endOffset, ImportsAcceptor acceptor) {
		val region = locationInFileProvider.getSignificantTextRegion(object)
		if (region.offset >= offset && region.offset + region.length <= endOffset) {
			val compositeNode = NodeModelUtils.findActualNodeFor(object)
			visit(object, compositeNode.children, acceptor)
		}
	}

	dispatch def void visit(EObject semanticObj, Iterable<INode> originNode, ImportsAcceptor acceptor) {
		addJavaDocReferences(semanticObj, acceptor)
	}

	dispatch def void visit(JvmTypeReference semanticElement, Iterable<INode> originNode, ImportsAcceptor acceptor) {
		visit(semanticElement.getType(), originNode, acceptor)
	}

	dispatch def void visit(XAbstractFeatureCall semanticObj, Iterable<INode> originNode, ImportsAcceptor acceptor) {
		collectStaticImportsFrom(semanticObj, acceptor)
	}

	dispatch def void visit(XMemberFeatureCall semanticObj, Iterable<INode> originNode, ImportsAcceptor acceptor) {
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

	dispatch def void visit(XFeatureCall semanticObj, Iterable<INode> originNode, ImportsAcceptor acceptor) {
		if (semanticObj.getFeature() instanceof JvmType && semanticObj.isTypeLiteral()) {
			visit(semanticObj.getFeature() as JvmType, originNode, acceptor)
		} else {
			collectStaticImportsFrom(semanticObj, acceptor)
		}
	}

	dispatch def void visit(JvmGenericType jvmType, Iterable<INode> originNode, ImportsAcceptor acceptor) {
		if (jvmType.anonymous) {
			visit(jvmType.superTypes.last.type, originNode, acceptor)
		} else {
			_visit(jvmType as JvmDeclaredType, originNode, acceptor)
		}
	}

	dispatch def void visit(JvmDeclaredType jvmType, Iterable<INode> originNode, ImportsAcceptor acceptor) {
		if (jvmType.getDeclaringType() == null) {
			collectTypeImportFrom(jvmType, acceptor)
		}
		val text = NodeModelUtils.getTokenText(originNode.get(0));
		val outerSegment = getFirstNameSegment(text);
		val outerType = findDeclaringTypeBySimpleName(jvmType, outerSegment);
		if (outerType == null) {
			throw new IllegalStateException();
		}
		collectTypeImportFrom(outerType, acceptor)
	}

	def private JvmDeclaredType findDeclaringTypeBySimpleName(JvmDeclaredType referencedType, String outerSegment) {
		if (referencedType.getDeclaringType() == null || outerSegment.equals(referencedType.getSimpleName())) {
			return referencedType
		}
		return findDeclaringTypeBySimpleName(referencedType.getDeclaringType(), outerSegment)
	}

	dispatch def void visit(XConstructorCall semanticElement, Iterable<INode> originNode, ImportsAcceptor acceptor) {
		visit(semanticElement.constructor.declaringType, originNode, acceptor)
	}

	dispatch def void visit(XAnnotation semanticElement, Iterable<INode> originNode, ImportsAcceptor acceptor) {
		visit(semanticElement.getAnnotationType(), originNode, acceptor)
	}

	dispatch def void visit(XTypeLiteral semanticElement, Iterable<INode> originNode, ImportsAcceptor acceptor) {
		val elementNode = NodeModelUtils.findNodesForFeature(semanticElement, XbasePackage.Literals.XTYPE_LITERAL__TYPE)
		visit(semanticElement.type, elementNode, acceptor)
	}

	dispatch def void visit(Void nullCase, Iterable<INode> originNode, ImportsAcceptor acceptor) {
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
	IEObjectDocumentationProviderExtension documentationProvider

	@Inject def  void setDocumentationProvider(IEObjectDocumentationProvider documentationProvider) {
		if (documentationProvider instanceof IEObjectDocumentationProviderExtension)
			this.documentationProvider = documentationProvider as IEObjectDocumentationProviderExtension
	}

	def private void addJavaDocReferences(EObject element, ImportsAcceptor acceptor) {
		if (element != null && documentationProvider != null) {
			for (INode documentationNode : documentationProvider.getDocumentationNodes(element)) {
				for (ReplaceRegion docTypeReference : javaDocTypeReferenceProvider.
					computeTypeRefRegions(documentationNode)) {
					var String docTypeText = docTypeReference.getText()
					var IScope scope = scopeProvider.getScope(element,
						TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
					var IEObjectDescription singleElement = scope.getSingleElement(QualifiedName.create(docTypeText))
					var JvmType referencedType = null
					if (singleElement != null) {
						referencedType = singleElement.getEObjectOrProxy() as JvmType
					}
					if (referencedType instanceof JvmDeclaredType && !referencedType.eIsProxy()) {
						var JvmDeclaredType casted = referencedType as JvmDeclaredType
						acceptor.acceptTypeImport(casted)
					}
				}
			}
		}
	}

}
