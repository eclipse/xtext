/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.imports;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ImportsCollector {
  @Inject
  private XbaseGrammarAccess grammarAccess;

  /**
   * Collects import declarations in XtextResource for the given range (selectedRegion)
   */
  public void collectImports(final XtextResource state, final ITextRegion selectedRegion, final ImportsAcceptor acceptor) {
    ICompositeNode rootNode = state.getParseResult().getRootNode();
    final EObject selectedSemanticObj = this.findActualSemanticObjectFor(rootNode, selectedRegion);
    final Iterable<ILeafNode> contentsIterator = NodeModelUtils.findActualNodeFor(selectedSemanticObj).getLeafNodes();
    for (final ILeafNode node : contentsIterator) {
      {
        final ITextRegion nodeRegion = node.getTotalTextRegion();
        boolean _contains = selectedRegion.contains(nodeRegion);
        if (_contains) {
          final EObject semanticElement = node.getSemanticElement();
          if ((semanticElement != null)) {
            this.visit(semanticElement, NodeModelUtils.findActualNodeFor(semanticElement), acceptor);
          }
        }
        if ((node.isHidden() && this.grammarAccess.getML_COMMENTRule().equals(node.getGrammarElement()))) {
          this.addJavaDocReferences(node, selectedRegion, acceptor);
        }
      }
    }
  }

  public EObject findActualSemanticObjectFor(final ICompositeNode rootNode, final ITextRegion textRegion) {
    ILeafNode leafNodeAtOffset = NodeModelUtils.findLeafNodeAtOffset(rootNode, textRegion.getOffset());
    EObject semanticElementOffset = leafNodeAtOffset.getSemanticElement();
    ICompositeNode actualOffsetNode = NodeModelUtils.findActualNodeFor(semanticElementOffset);
    int _offset = textRegion.getOffset();
    int _length = textRegion.getLength();
    final int endOffset = (_offset + _length);
    while (((actualOffsetNode.getParent() != null) && (actualOffsetNode.getTotalEndOffset() < endOffset))) {
      actualOffsetNode = actualOffsetNode.getParent();
    }
    final EObject actualSemanticObj = actualOffsetNode.getSemanticElement();
    return actualSemanticObj;
  }

  protected void _visit(final EObject semanticObj, final INode originNode, final ImportsAcceptor acceptor) {
  }

  protected void _visit(final JvmTypeReference semanticElement, final INode originNode, final ImportsAcceptor acceptor) {
    this.visit(semanticElement.getType(), originNode, acceptor);
  }

  protected void _visit(final XAbstractFeatureCall semanticObj, final INode originNode, final ImportsAcceptor acceptor) {
    this.collectStaticImportsFrom(semanticObj, acceptor);
  }

  protected void _visit(final XMemberFeatureCall semanticObj, final INode originNode, final ImportsAcceptor acceptor) {
    if (((semanticObj.getFeature() instanceof JvmType) && semanticObj.isTypeLiteral())) {
      JvmIdentifiableElement _feature = semanticObj.getFeature();
      this.visit(((JvmType) _feature), originNode, acceptor);
    }
    boolean _isExplicitStatic = semanticObj.isExplicitStatic();
    boolean _not = (!_isExplicitStatic);
    if (_not) {
      final XExpression target = semanticObj.getMemberCallTarget();
      if ((target instanceof XAbstractFeatureCall)) {
        boolean _isTypeLiteral = ((XAbstractFeatureCall)target).isTypeLiteral();
        if (_isTypeLiteral) {
          return;
        }
      }
      this.collectStaticImportsFrom(semanticObj, acceptor);
    }
  }

  protected void _visit(final XFeatureCall semanticObj, final INode originNode, final ImportsAcceptor acceptor) {
    if (((semanticObj.getFeature() instanceof JvmType) && semanticObj.isTypeLiteral())) {
      JvmIdentifiableElement _feature = semanticObj.getFeature();
      this.visit(((JvmType) _feature), originNode, acceptor);
    } else {
      this.collectStaticImportsFrom(semanticObj, acceptor);
    }
  }

  protected void _visit(final JvmGenericType jvmType, final INode originNode, final ImportsAcceptor acceptor) {
    boolean _isAnonymous = jvmType.isAnonymous();
    if (_isAnonymous) {
      this.visit(IterableExtensions.<JvmTypeReference>last(jvmType.getSuperTypes()).getType(), originNode, acceptor);
    } else {
      this._visit(((JvmDeclaredType) jvmType), originNode, acceptor);
    }
  }

  protected void _visit(final JvmDeclaredType jvmType, final INode originNode, final ImportsAcceptor acceptor) {
    JvmDeclaredType _declaringType = jvmType.getDeclaringType();
    boolean _tripleEquals = (_declaringType == null);
    if (_tripleEquals) {
      this.collectTypeImportFrom(jvmType, acceptor);
    }
    final String text = NodeModelUtils.getTokenText(originNode);
    final String outerSegment = this.getFirstNameSegment(text);
    final JvmDeclaredType outerType = this.findDeclaringTypeBySimpleName(jvmType, outerSegment);
    if ((outerType == null)) {
      throw new IllegalStateException();
    }
    this.collectTypeImportFrom(outerType, acceptor);
  }

  private JvmDeclaredType findDeclaringTypeBySimpleName(final JvmDeclaredType referencedType, final String outerSegment) {
    if (((referencedType.getDeclaringType() == null) || outerSegment.equals(referencedType.getSimpleName()))) {
      return referencedType;
    }
    return this.findDeclaringTypeBySimpleName(referencedType.getDeclaringType(), outerSegment);
  }

  protected void _visit(final XConstructorCall semanticElement, final INode originNode, final ImportsAcceptor acceptor) {
    this.visit(semanticElement.getConstructor().getDeclaringType(), originNode, acceptor);
  }

  protected void _visit(final XAnnotation semanticElement, final INode originNode, final ImportsAcceptor acceptor) {
    this.visit(semanticElement.getAnnotationType(), originNode, acceptor);
  }

  protected void _visit(final XTypeLiteral semanticElement, final INode originNode, final ImportsAcceptor acceptor) {
    final List<INode> elementNode = NodeModelUtils.findNodesForFeature(semanticElement, XbasePackage.Literals.XTYPE_LITERAL__TYPE);
    this.visit(semanticElement.getType(), IterableExtensions.<INode>head(elementNode), acceptor);
  }

  protected void _visit(final Void nullCase, final INode originNode, final ImportsAcceptor acceptor) {
  }

  protected void collectTypeImportFrom(final JvmDeclaredType type, final ImportsAcceptor acceptor) {
    acceptor.acceptTypeImport(type);
  }

  protected void collectStaticImportsFrom(final XAbstractFeatureCall abstractFeatureCall, final ImportsAcceptor acceptor) {
    boolean _isStatic = abstractFeatureCall.isStatic();
    if (_isStatic) {
      boolean _isExtension = abstractFeatureCall.isExtension();
      if (_isExtension) {
        acceptor.acceptStaticExtensionImport(abstractFeatureCall);
      } else {
        acceptor.acceptStaticImport(abstractFeatureCall);
      }
    }
  }

  protected String getFirstNameSegment(final String text_finalParam_) {
    String text = text_finalParam_;
    int firstDelimiter = text.indexOf(Character.valueOf('.').charValue());
    if ((firstDelimiter == (-1))) {
      firstDelimiter = text.indexOf(Character.valueOf('$').charValue());
    } else {
      int dollar = text.indexOf(Character.valueOf('$').charValue());
      if ((dollar != (-1))) {
        firstDelimiter = Math.min(firstDelimiter, dollar);
      }
    }
    if ((firstDelimiter == (-1))) {
      firstDelimiter = text.indexOf("::");
      if (((firstDelimiter == (text.length() - 2)) && (firstDelimiter >= 0))) {
        text = text.substring(0, firstDelimiter);
        firstDelimiter = (-1);
      }
    } else {
      int colon = text.indexOf("::");
      if (((colon != (text.length() - 2)) && (colon != (-1)))) {
        firstDelimiter = Math.min(firstDelimiter, colon);
      }
    }
    if ((firstDelimiter != (-1))) {
      return text.substring(0, firstDelimiter);
    }
    return text;
  }

  @Inject
  private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;

  @Inject
  private IScopeProvider scopeProvider;

  private void addJavaDocReferences(final INode documentationNode, final ITextRegion selectedRegion, final ImportsAcceptor acceptor) {
    List<ReplaceRegion> _computeTypeRefRegions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(documentationNode);
    for (final ReplaceRegion docTypeReference : _computeTypeRefRegions) {
      {
        int _offset = docTypeReference.getOffset();
        int _length = docTypeReference.getLength();
        final TextRegion referenceRange = new TextRegion(_offset, _length);
        boolean _contains = selectedRegion.contains(referenceRange);
        if (_contains) {
          String docTypeText = docTypeReference.getText();
          final EObject element = NodeModelUtils.findActualSemanticObjectFor(documentationNode);
          IScope scope = this.scopeProvider.getScope(element, 
            TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
          IEObjectDescription singleElement = scope.getSingleElement(QualifiedName.create(docTypeText));
          JvmType referencedType = null;
          if ((singleElement != null)) {
            EObject _eObjectOrProxy = singleElement.getEObjectOrProxy();
            referencedType = ((JvmType) _eObjectOrProxy);
          }
          if (((referencedType instanceof JvmDeclaredType) && (!referencedType.eIsProxy()))) {
            JvmDeclaredType casted = ((JvmDeclaredType) referencedType);
            boolean _equals = casted.getQualifiedName().equals(docTypeText);
            boolean _not = (!_equals);
            if (_not) {
              acceptor.acceptTypeImport(casted);
            }
          }
        }
      }
    }
  }

  public void visit(final EObject jvmType, final INode originNode, final ImportsAcceptor acceptor) {
    if (jvmType instanceof JvmGenericType) {
      _visit((JvmGenericType)jvmType, originNode, acceptor);
      return;
    } else if (jvmType instanceof JvmDeclaredType) {
      _visit((JvmDeclaredType)jvmType, originNode, acceptor);
      return;
    } else if (jvmType instanceof XFeatureCall) {
      _visit((XFeatureCall)jvmType, originNode, acceptor);
      return;
    } else if (jvmType instanceof XMemberFeatureCall) {
      _visit((XMemberFeatureCall)jvmType, originNode, acceptor);
      return;
    } else if (jvmType instanceof XAbstractFeatureCall) {
      _visit((XAbstractFeatureCall)jvmType, originNode, acceptor);
      return;
    } else if (jvmType instanceof XConstructorCall) {
      _visit((XConstructorCall)jvmType, originNode, acceptor);
      return;
    } else if (jvmType instanceof XTypeLiteral) {
      _visit((XTypeLiteral)jvmType, originNode, acceptor);
      return;
    } else if (jvmType instanceof XAnnotation) {
      _visit((XAnnotation)jvmType, originNode, acceptor);
      return;
    } else if (jvmType instanceof JvmTypeReference) {
      _visit((JvmTypeReference)jvmType, originNode, acceptor);
      return;
    } else if (jvmType != null) {
      _visit(jvmType, originNode, acceptor);
      return;
    } else if (jvmType == null) {
      _visit((Void)null, originNode, acceptor);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(jvmType, originNode, acceptor).toString());
    }
  }
}
