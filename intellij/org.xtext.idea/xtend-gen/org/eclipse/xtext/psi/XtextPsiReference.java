package org.eclipse.xtext.psi;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.impl.source.codeStyle.CodeEditUtil;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.linking.lazy.CrossReferenceDescription;
import org.eclipse.xtext.linking.lazy.ICrossReferenceDescription;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.XtextPsiElement;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class XtextPsiReference extends PsiReferenceBase<XtextPsiElement> implements PsiReference {
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  @Extension
  private IPsiModelAssociations psiModelAssociations;
  
  @Inject
  private CrossReferenceDescription.CrossReferenceDescriptionProvider crossReferenceDescriptionProvider;
  
  public XtextPsiReference(final XtextPsiElement element) {
    super(element);
    final Language language = element.getLanguage();
    if ((language instanceof IXtextLanguage)) {
      ((IXtextLanguage)language).injectMembers(this);
    }
  }
  
  protected ASTNode getReferenceNode() {
    ASTNode _xblockexpression = null;
    {
      ASTNode referenceNode = this.myElement.getNode();
      while ((referenceNode instanceof CompositeElement)) {
        TreeElement _lastChildNode = ((CompositeElement)referenceNode).getLastChildNode();
        referenceNode = _lastChildNode;
      }
      _xblockexpression = referenceNode;
    }
    return _xblockexpression;
  }
  
  protected TextRange calculateDefaultRangeInElement() {
    TextRange _xblockexpression = null;
    {
      final ASTNode node = this.myElement.getNode();
      final ASTNode referenceNode = this.getReferenceNode();
      int _startOffset = referenceNode.getStartOffset();
      int _startOffset_1 = node.getStartOffset();
      final int startOffset = (_startOffset - _startOffset_1);
      int _textLength = referenceNode.getTextLength();
      final int endOffset = (startOffset + _textLength);
      _xblockexpression = new TextRange(startOffset, endOffset);
    }
    return _xblockexpression;
  }
  
  public PsiElement handleElementRename(final String newElementName) throws IncorrectOperationException {
    final ASTNode myNode = this.myElement.getNode();
    final ASTNode referenceNode = this.getReferenceNode();
    IElementType _elementType = referenceNode.getElementType();
    LeafElement _leaf = ASTFactory.leaf(_elementType, newElementName);
    final Procedure1<LeafElement> _function = new Procedure1<LeafElement>() {
      public void apply(final LeafElement it) {
        CodeEditUtil.setNodeGenerated(it, true);
      }
    };
    final LeafElement newReferenceNode = ObjectExtensions.<LeafElement>operator_doubleArrow(_leaf, _function);
    ASTNode _treeParent = referenceNode.getTreeParent();
    _treeParent.replaceChild(referenceNode, newReferenceNode);
    boolean _equals = Objects.equal(referenceNode, myNode);
    if (_equals) {
      return newReferenceNode.getPsi();
    }
    return this.myElement;
  }
  
  protected ICrossReferenceDescription getCrossReferenceDescription() {
    ICrossReferenceDescription _xblockexpression = null;
    {
      ASTNode _node = this.myElement.getNode();
      IElementType _elementType = _node.getElementType();
      EObject _grammarElement = ((IGrammarAwareElementType) _elementType).getGrammarElement();
      final CrossReference crossReference = ((CrossReference) _grammarElement);
      BaseXtextFile _containingFile = this.myElement.getContainingFile();
      ASTNode _node_1 = this.myElement.getNode();
      final INode node = _containingFile.getINode(_node_1);
      final EObject context = NodeModelUtils.findActualSemanticObjectFor(node);
      final EReference reference = GrammarUtil.getReference(crossReference);
      List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(context, reference);
      Iterable<Pair<Integer, INode>> _indexed = IterableExtensions.<INode>indexed(_findNodesForFeature);
      final Function1<Pair<Integer, INode>, Boolean> _function = new Function1<Pair<Integer, INode>, Boolean>() {
        public Boolean apply(final Pair<Integer, INode> it) {
          boolean _and = false;
          INode _value = it.getValue();
          int _totalOffset = _value.getTotalOffset();
          int _totalOffset_1 = node.getTotalOffset();
          boolean _lessEqualsThan = (_totalOffset <= _totalOffset_1);
          if (!_lessEqualsThan) {
            _and = false;
          } else {
            INode _value_1 = it.getValue();
            int _totalEndOffset = _value_1.getTotalEndOffset();
            int _totalEndOffset_1 = node.getTotalEndOffset();
            boolean _greaterEqualsThan = (_totalEndOffset >= _totalEndOffset_1);
            _and = _greaterEqualsThan;
          }
          return Boolean.valueOf(_and);
        }
      };
      Pair<Integer, INode> _findFirst = IterableExtensions.<Pair<Integer, INode>>findFirst(_indexed, _function);
      Integer _key = null;
      if (_findFirst!=null) {
        _key=_findFirst.getKey();
      }
      final Integer index = _key;
      _xblockexpression = this.crossReferenceDescriptionProvider.get(context, reference, index);
    }
    return _xblockexpression;
  }
  
  public Object[] getVariants() {
    ArrayList<LookupElementBuilder> _xblockexpression = null;
    {
      ProgressIndicatorProvider.checkCanceled();
      ICrossReferenceDescription crossReferenceDescription = this.getCrossReferenceDescription();
      boolean _equals = Objects.equal(crossReferenceDescription, null);
      if (_equals) {
        return ((Object[])Conversions.unwrapArray(CollectionLiterals.<Object>emptyList(), Object.class));
      }
      ArrayList<LookupElementBuilder> variants = CollectionLiterals.<LookupElementBuilder>newArrayList();
      Iterable<IEObjectDescription> _variants = crossReferenceDescription.getVariants();
      for (final IEObjectDescription objectDescription : _variants) {
        {
          ProgressIndicatorProvider.checkCanceled();
          QualifiedName _name = objectDescription.getName();
          String name = this.qualifiedNameConverter.toString(_name);
          BaseXtextFile _containingFile = this.myElement.getContainingFile();
          Resource _resource = _containingFile.getResource();
          PsiElement element = this.psiModelAssociations.getPsiElement(objectDescription, _resource);
          boolean _notEquals = (!Objects.equal(element, null));
          if (_notEquals) {
            LookupElementBuilder _create = LookupElementBuilder.create(name);
            PsiElement _navigationElement = element.getNavigationElement();
            PsiFile _containingFile_1 = _navigationElement.getContainingFile();
            String _name_1 = _containingFile_1.getName();
            LookupElementBuilder _withTypeText = _create.withTypeText(_name_1);
            variants.add(_withTypeText);
          }
        }
      }
      _xblockexpression = variants;
    }
    return ((Object[])Conversions.unwrapArray(_xblockexpression, Object.class));
  }
  
  public PsiElement resolve() {
    PsiElement _xblockexpression = null;
    {
      ProgressIndicatorProvider.checkCanceled();
      ICrossReferenceDescription crossReferenceDescription = this.getCrossReferenceDescription();
      boolean _equals = Objects.equal(crossReferenceDescription, null);
      if (_equals) {
        return null;
      }
      EObject object = crossReferenceDescription.resolve();
      ProgressIndicatorProvider.checkCanceled();
      _xblockexpression = this.psiModelAssociations.getPsiElement(object);
    }
    return _xblockexpression;
  }
}
