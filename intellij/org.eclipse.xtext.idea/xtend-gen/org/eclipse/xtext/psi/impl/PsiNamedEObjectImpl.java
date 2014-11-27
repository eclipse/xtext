package org.eclipse.xtext.psi.impl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.util.IncorrectOperationException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.psi.PsiEObjectFactory;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.impl.PsiEObjectIdentifierImpl;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class PsiNamedEObjectImpl<T extends PsiNamedEObjectStub<?>> extends PsiEObjectImpl<T> implements PsiNamedEObject {
  @Inject
  @Extension
  private PsiEObjectFactory psiEObjectFactory;
  
  @Inject
  @Extension
  private ILocationInFileProvider locationInFileProvider;
  
  private final IGrammarAwareElementType nameType;
  
  public PsiNamedEObjectImpl(final T stub, final IStubElementType<?, ?> nodeType, final IGrammarAwareElementType nameType) {
    super(stub, nodeType);
    this.nameType = nameType;
  }
  
  public PsiNamedEObjectImpl(final ASTNode node, final IGrammarAwareElementType nameType) {
    super(node);
    this.nameType = nameType;
  }
  
  public PsiEObjectIdentifier getNameIdentifier() {
    PsiEObjectIdentifierImpl _xblockexpression = null;
    {
      final ASTNode nameNode = this.findNameNode();
      boolean _equals = Objects.equal(nameNode, null);
      if (_equals) {
        return null;
      }
      PsiElement _psi = nameNode.getPsi();
      _xblockexpression = new PsiEObjectIdentifierImpl(_psi);
    }
    return _xblockexpression;
  }
  
  public String getName() {
    String _xblockexpression = null;
    {
      final T stub = this.getStub();
      boolean _notEquals = (!Objects.equal(stub, null));
      if (_notEquals) {
        return stub.getName();
      }
      final ITextRegion significantTextRegion = this.getSignificantTextRegion();
      final int startIndex = significantTextRegion.getOffset();
      int _length = significantTextRegion.getLength();
      final int endIndex = (startIndex + _length);
      PsiFile _containingFile = this.getContainingFile();
      String _text = _containingFile.getText();
      _xblockexpression = _text.substring(startIndex, endIndex);
    }
    return _xblockexpression;
  }
  
  public int getTextOffset() {
    ITextRegion _significantTextRegion = this.getSignificantTextRegion();
    return _significantTextRegion.getOffset();
  }
  
  public PsiNamedEObject setName(final String name) throws IncorrectOperationException {
    PsiNamedEObjectImpl<T> _xblockexpression = null;
    {
      final ASTNode nameNode = this.findNameNode();
      EObject _grammarElement = this.nameType.getGrammarElement();
      boolean _isTerminalRuleCall = GrammarUtil.isTerminalRuleCall(_grammarElement);
      if (_isTerminalRuleCall) {
        final ASTNode newNameNode = this.psiEObjectFactory.createLeafIdentifier(name, nameNode);
        ASTNode _treeParent = nameNode.getTreeParent();
        _treeParent.replaceChild(nameNode, newNameNode);
      } else {
        String _name = this.getName();
        ASTNode _createCompositeIdentifier = this.psiEObjectFactory.createCompositeIdentifier(name, _name, nameNode);
        final ASTNode newNameNode_1 = _createCompositeIdentifier.getFirstChildNode();
        nameNode.replaceAllChildrenToChildrenOf(newNameNode_1);
      }
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  /**
   * @return
   */
  protected ASTNode findNameNode() {
    ASTNode _node = this.getNode();
    return _node.findChildByType(this.nameType);
  }
  
  /**
   * @return
   */
  protected ITextRegion getSignificantTextRegion() {
    EObject _eObject = this.getEObject();
    return this.locationInFileProvider.getSignificantTextRegion(_eObject);
  }
}
