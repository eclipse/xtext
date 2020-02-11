/**
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.editor.syntaxcoloring;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Parameter;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class SemanticHighlightingCalculatorImpl extends DefaultSemanticHighlightingCalculator {
  private static final String IDENTIFIER_STYLE = "identifier";
  
  private static final String PRIMITIVE_TYPE_STYLE = "primitiveType";
  
  private static final String TYPE_STYLE = "type";
  
  private static final String TYPE_DECLARATION_STYLE = "typeDeclaration";
  
  private static final String PARAMETER_NAME_STYLE = "parameterName";
  
  private static final String OP_BODY_STYLE = "opBody";
  
  public static final Set<String> STYLES = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(SemanticHighlightingCalculatorImpl.IDENTIFIER_STYLE, SemanticHighlightingCalculatorImpl.PRIMITIVE_TYPE_STYLE, SemanticHighlightingCalculatorImpl.TYPE_STYLE, SemanticHighlightingCalculatorImpl.TYPE_DECLARATION_STYLE, SemanticHighlightingCalculatorImpl.PARAMETER_NAME_STYLE, SemanticHighlightingCalculatorImpl.OP_BODY_STYLE));
  
  @Override
  protected boolean highlightElement(final EObject object, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    return this.doHighlightElement(object, acceptor);
  }
  
  protected boolean _doHighlightElement(final EObject it, final IHighlightedPositionAcceptor acceptor) {
    return false;
  }
  
  protected boolean _doHighlightElement(final Property it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNode(acceptor, it, TestLanguagePackage.Literals.MEMBER__NAME, SemanticHighlightingCalculatorImpl.IDENTIFIER_STYLE);
  }
  
  protected boolean _doHighlightElement(final Operation it, final IHighlightedPositionAcceptor acceptor) {
    final boolean canStop = this.doHighlightNode(acceptor, it, TestLanguagePackage.Literals.MEMBER__NAME, SemanticHighlightingCalculatorImpl.IDENTIFIER_STYLE);
    final ICompositeNode opNode = NodeModelUtils.findActualNodeFor(it);
    if ((opNode != null)) {
      final Function1<ILeafNode, Boolean> _function = (ILeafNode it_1) -> {
        boolean _isHidden = it_1.isHidden();
        return Boolean.valueOf((!_isHidden));
      };
      final List<ILeafNode> inverseChildren = ListExtensions.<ILeafNode>reverse(IterableExtensions.<ILeafNode>toList(IterableExtensions.<ILeafNode>filter(opNode.getLeafNodes(), _function)));
      int endOffset = (-1);
      int startOffset = (-1);
      ILeafNode _head = IterableExtensions.<ILeafNode>head(inverseChildren);
      String _text = null;
      if (_head!=null) {
        _text=_head.getText();
      }
      boolean _equals = Objects.equal(_text, "}");
      if (_equals) {
        int _endOffset = IterableExtensions.<ILeafNode>head(inverseChildren).getEndOffset();
        int _minus = (_endOffset - 1);
        endOffset = _minus;
      }
      if ((endOffset != (-1))) {
        final Function1<ILeafNode, Boolean> _function_1 = (ILeafNode it_1) -> {
          String _trim = it_1.getText().trim();
          return Boolean.valueOf(Objects.equal(_trim, "{"));
        };
        final ILeafNode opStartNode = IterableExtensions.<ILeafNode>findFirst(inverseChildren, _function_1);
        if ((opStartNode != null)) {
          int _offset = opStartNode.getOffset();
          int _plus = (_offset + 1);
          startOffset = _plus;
        }
      }
      if (((startOffset >= 0) && (endOffset >= 0))) {
        acceptor.addPosition(startOffset, (endOffset - startOffset), SemanticHighlightingCalculatorImpl.OP_BODY_STYLE);
      }
    }
    return canStop;
  }
  
  protected boolean _doHighlightElement(final TypeDeclaration it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNode(acceptor, it, TestLanguagePackage.Literals.ABSTRACT_ELEMENT__NAME, SemanticHighlightingCalculatorImpl.TYPE_DECLARATION_STYLE);
  }
  
  protected boolean _doHighlightElement(final PrimitiveType it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNode(acceptor, it, TestLanguagePackage.Literals.PRIMITIVE_TYPE__NAME, SemanticHighlightingCalculatorImpl.PRIMITIVE_TYPE_STYLE);
  }
  
  protected boolean _doHighlightElement(final TypeReference it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNode(acceptor, it, TestLanguagePackage.Literals.TYPE_REFERENCE__TYPE_REF, SemanticHighlightingCalculatorImpl.TYPE_STYLE);
  }
  
  protected boolean _doHighlightElement(final Parameter it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNode(acceptor, it, TestLanguagePackage.Literals.PARAMETER__NAME, SemanticHighlightingCalculatorImpl.PARAMETER_NAME_STYLE);
  }
  
  public boolean doHighlightNode(final IHighlightedPositionAcceptor acceptor, final EObject object, final EStructuralFeature feature, final String style) {
    final Consumer<INode> _function = (INode it) -> {
      acceptor.addPosition(it.getOffset(), it.getLength(), style);
    };
    NodeModelUtils.findNodesForFeature(object, feature).forEach(_function);
    return false;
  }
  
  public boolean doHighlightElement(final EObject it, final IHighlightedPositionAcceptor acceptor) {
    if (it instanceof Operation) {
      return _doHighlightElement((Operation)it, acceptor);
    } else if (it instanceof PrimitiveType) {
      return _doHighlightElement((PrimitiveType)it, acceptor);
    } else if (it instanceof Property) {
      return _doHighlightElement((Property)it, acceptor);
    } else if (it instanceof TypeDeclaration) {
      return _doHighlightElement((TypeDeclaration)it, acceptor);
    } else if (it instanceof TypeReference) {
      return _doHighlightElement((TypeReference)it, acceptor);
    } else if (it instanceof Parameter) {
      return _doHighlightElement((Parameter)it, acceptor);
    } else if (it != null) {
      return _doHighlightElement(it, acceptor);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, acceptor).toString());
    }
  }
}
