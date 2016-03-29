package org.eclipse.xtext.xbase.imports;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractGrammarElement;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.types.JvmConstructor;
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
import org.eclipse.xtext.parser.IParseResult;
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
import org.eclipse.xtext.xbase.imports.ImportsAcceptor;
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
    IParseResult _parseResult = state.getParseResult();
    ICompositeNode rootNode = _parseResult.getRootNode();
    final EObject selectedSemanticObj = this.findActualSemanticObjectFor(rootNode, selectedRegion);
    ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(selectedSemanticObj);
    final Iterable<ILeafNode> contentsIterator = _findActualNodeFor.getLeafNodes();
    for (final ILeafNode node : contentsIterator) {
      {
        final ITextRegion nodeRegion = node.getTotalTextRegion();
        boolean _contains = selectedRegion.contains(nodeRegion);
        if (_contains) {
          final EObject semanticElement = node.getSemanticElement();
          boolean _notEquals = (!Objects.equal(semanticElement, null));
          if (_notEquals) {
            ICompositeNode _findActualNodeFor_1 = NodeModelUtils.findActualNodeFor(semanticElement);
            this.visit(semanticElement, _findActualNodeFor_1, acceptor);
          }
        }
        boolean _and = false;
        boolean _isHidden = node.isHidden();
        if (!_isHidden) {
          _and = false;
        } else {
          TerminalRule _mL_COMMENTRule = this.grammarAccess.getML_COMMENTRule();
          AbstractGrammarElement _grammarElement = node.getGrammarElement();
          boolean _equals = _mL_COMMENTRule.equals(_grammarElement);
          _and = _equals;
        }
        if (_and) {
          this.addJavaDocReferences(node, selectedRegion, acceptor);
        }
      }
    }
  }
  
  public EObject findActualSemanticObjectFor(final ICompositeNode rootNode, final ITextRegion textRegion) {
    int _offset = textRegion.getOffset();
    ILeafNode leafNodeAtOffset = NodeModelUtils.findLeafNodeAtOffset(rootNode, _offset);
    EObject semanticElementOffset = leafNodeAtOffset.getSemanticElement();
    ICompositeNode actualOffsetNode = NodeModelUtils.findActualNodeFor(semanticElementOffset);
    int _offset_1 = textRegion.getOffset();
    int _length = textRegion.getLength();
    final int endOffset = (_offset_1 + _length);
    while (((!Objects.equal(actualOffsetNode.getParent(), null)) && (actualOffsetNode.getTotalEndOffset() < endOffset))) {
      ICompositeNode _parent = actualOffsetNode.getParent();
      actualOffsetNode = _parent;
    }
    final EObject actualSemanticObj = actualOffsetNode.getSemanticElement();
    return actualSemanticObj;
  }
  
  protected void _visit(final EObject semanticObj, final INode originNode, final ImportsAcceptor acceptor) {
  }
  
  protected void _visit(final JvmTypeReference semanticElement, final INode originNode, final ImportsAcceptor acceptor) {
    JvmType _type = semanticElement.getType();
    this.visit(_type, originNode, acceptor);
  }
  
  protected void _visit(final XAbstractFeatureCall semanticObj, final INode originNode, final ImportsAcceptor acceptor) {
    this.collectStaticImportsFrom(semanticObj, acceptor);
  }
  
  protected void _visit(final XMemberFeatureCall semanticObj, final INode originNode, final ImportsAcceptor acceptor) {
    boolean _and = false;
    JvmIdentifiableElement _feature = semanticObj.getFeature();
    if (!(_feature instanceof JvmType)) {
      _and = false;
    } else {
      boolean _isTypeLiteral = semanticObj.isTypeLiteral();
      _and = _isTypeLiteral;
    }
    if (_and) {
      JvmIdentifiableElement _feature_1 = semanticObj.getFeature();
      this.visit(((JvmType) _feature_1), originNode, acceptor);
    }
    boolean _isExplicitStatic = semanticObj.isExplicitStatic();
    boolean _not = (!_isExplicitStatic);
    if (_not) {
      final XExpression target = semanticObj.getMemberCallTarget();
      if ((target instanceof XAbstractFeatureCall)) {
        boolean _isTypeLiteral_1 = ((XAbstractFeatureCall)target).isTypeLiteral();
        if (_isTypeLiteral_1) {
          return;
        }
      }
      this.collectStaticImportsFrom(semanticObj, acceptor);
    }
  }
  
  protected void _visit(final XFeatureCall semanticObj, final INode originNode, final ImportsAcceptor acceptor) {
    boolean _and = false;
    JvmIdentifiableElement _feature = semanticObj.getFeature();
    if (!(_feature instanceof JvmType)) {
      _and = false;
    } else {
      boolean _isTypeLiteral = semanticObj.isTypeLiteral();
      _and = _isTypeLiteral;
    }
    if (_and) {
      JvmIdentifiableElement _feature_1 = semanticObj.getFeature();
      this.visit(((JvmType) _feature_1), originNode, acceptor);
    } else {
      this.collectStaticImportsFrom(semanticObj, acceptor);
    }
  }
  
  protected void _visit(final JvmGenericType jvmType, final INode originNode, final ImportsAcceptor acceptor) {
    boolean _isAnonymous = jvmType.isAnonymous();
    if (_isAnonymous) {
      EList<JvmTypeReference> _superTypes = jvmType.getSuperTypes();
      JvmTypeReference _last = IterableExtensions.<JvmTypeReference>last(_superTypes);
      JvmType _type = _last.getType();
      this.visit(_type, originNode, acceptor);
    } else {
      this._visit(((JvmDeclaredType) jvmType), originNode, acceptor);
    }
  }
  
  protected void _visit(final JvmDeclaredType jvmType, final INode originNode, final ImportsAcceptor acceptor) {
    JvmDeclaredType _declaringType = jvmType.getDeclaringType();
    boolean _equals = Objects.equal(_declaringType, null);
    if (_equals) {
      this.collectTypeImportFrom(jvmType, acceptor);
    }
    final String text = NodeModelUtils.getTokenText(originNode);
    final String outerSegment = this.getFirstNameSegment(text);
    final JvmDeclaredType outerType = this.findDeclaringTypeBySimpleName(jvmType, outerSegment);
    boolean _equals_1 = Objects.equal(outerType, null);
    if (_equals_1) {
      throw new IllegalStateException();
    }
    this.collectTypeImportFrom(outerType, acceptor);
  }
  
  private JvmDeclaredType findDeclaringTypeBySimpleName(final JvmDeclaredType referencedType, final String outerSegment) {
    boolean _or = false;
    JvmDeclaredType _declaringType = referencedType.getDeclaringType();
    boolean _equals = Objects.equal(_declaringType, null);
    if (_equals) {
      _or = true;
    } else {
      String _simpleName = referencedType.getSimpleName();
      boolean _equals_1 = outerSegment.equals(_simpleName);
      _or = _equals_1;
    }
    if (_or) {
      return referencedType;
    }
    JvmDeclaredType _declaringType_1 = referencedType.getDeclaringType();
    return this.findDeclaringTypeBySimpleName(_declaringType_1, outerSegment);
  }
  
  protected void _visit(final XConstructorCall semanticElement, final INode originNode, final ImportsAcceptor acceptor) {
    JvmConstructor _constructor = semanticElement.getConstructor();
    JvmDeclaredType _declaringType = _constructor.getDeclaringType();
    this.visit(_declaringType, originNode, acceptor);
  }
  
  protected void _visit(final XAnnotation semanticElement, final INode originNode, final ImportsAcceptor acceptor) {
    JvmType _annotationType = semanticElement.getAnnotationType();
    this.visit(_annotationType, originNode, acceptor);
  }
  
  protected void _visit(final XTypeLiteral semanticElement, final INode originNode, final ImportsAcceptor acceptor) {
    final List<INode> elementNode = NodeModelUtils.findNodesForFeature(semanticElement, XbasePackage.Literals.XTYPE_LITERAL__TYPE);
    JvmType _type = semanticElement.getType();
    INode _head = IterableExtensions.<INode>head(elementNode);
    this.visit(_type, _head, acceptor);
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
    Character _valueOf = Character.valueOf('.');
    char _charValue = _valueOf.charValue();
    int firstDelimiter = text.indexOf(_charValue);
    if ((firstDelimiter == (-1))) {
      Character _valueOf_1 = Character.valueOf('$');
      char _charValue_1 = _valueOf_1.charValue();
      int _indexOf = text.indexOf(_charValue_1);
      firstDelimiter = _indexOf;
    } else {
      Character _valueOf_2 = Character.valueOf('$');
      char _charValue_2 = _valueOf_2.charValue();
      int dollar = text.indexOf(_charValue_2);
      if ((dollar != (-1))) {
        int _min = Math.min(firstDelimiter, dollar);
        firstDelimiter = _min;
      }
    }
    if ((firstDelimiter == (-1))) {
      int _indexOf_1 = text.indexOf("::");
      firstDelimiter = _indexOf_1;
      boolean _and = false;
      int _length = text.length();
      int _minus = (_length - 2);
      boolean _equals = (firstDelimiter == _minus);
      if (!_equals) {
        _and = false;
      } else {
        _and = (firstDelimiter >= 0);
      }
      if (_and) {
        String _substring = text.substring(0, firstDelimiter);
        text = _substring;
        firstDelimiter = (-1);
      }
    } else {
      int colon = text.indexOf("::");
      boolean _and_1 = false;
      int _length_1 = text.length();
      int _minus_1 = (_length_1 - 2);
      boolean _notEquals = (colon != _minus_1);
      if (!_notEquals) {
        _and_1 = false;
      } else {
        _and_1 = (colon != (-1));
      }
      if (_and_1) {
        int _min_1 = Math.min(firstDelimiter, colon);
        firstDelimiter = _min_1;
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
          QualifiedName _create = QualifiedName.create(docTypeText);
          IEObjectDescription singleElement = scope.getSingleElement(_create);
          JvmType referencedType = null;
          boolean _notEquals = (!Objects.equal(singleElement, null));
          if (_notEquals) {
            EObject _eObjectOrProxy = singleElement.getEObjectOrProxy();
            referencedType = ((JvmType) _eObjectOrProxy);
          }
          boolean _and = false;
          if (!(referencedType instanceof JvmDeclaredType)) {
            _and = false;
          } else {
            boolean _eIsProxy = referencedType.eIsProxy();
            boolean _not = (!_eIsProxy);
            _and = _not;
          }
          if (_and) {
            JvmDeclaredType casted = ((JvmDeclaredType) referencedType);
            String _qualifiedName = casted.getQualifiedName();
            boolean _equals = _qualifiedName.equals(docTypeText);
            boolean _not_1 = (!_equals);
            if (_not_1) {
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
