/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.fowlerdsl.ui.folding;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author miklossy - Initial contribution and API
 */
@SuppressWarnings("all")
public class StatemachineFoldingRegionProvider extends DefaultFoldingRegionProvider {
  @Inject
  @Extension
  private StatemachineGrammarAccess _statemachineGrammarAccess;
  
  @Override
  protected void computeObjectFolding(final EObject eObject, final IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
    if ((eObject instanceof Statemachine)) {
      Resource _eResource = ((Statemachine)eObject).eResource();
      final XtextResource it = ((XtextResource) _eResource);
      this.computeEventsFolding(it, foldingRegionAcceptor);
      this.computeResetEventsFolding(it, foldingRegionAcceptor);
      this.computeCommandsFolding(it, foldingRegionAcceptor);
    } else {
      super.computeObjectFolding(eObject, foldingRegionAcceptor);
    }
  }
  
  @Override
  protected boolean isHandled(final EObject eObject) {
    return (super.isHandled(eObject) || (eObject instanceof Statemachine));
  }
  
  private void computeEventsFolding(final XtextResource it, final IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
    this.computeFoldingRegionBetweenKeywords(it, this._statemachineGrammarAccess.getStatemachineAccess().getEventsKeyword_1_0(), this._statemachineGrammarAccess.getStatemachineAccess().getEndKeyword_1_2(), foldingRegionAcceptor);
  }
  
  private void computeResetEventsFolding(final XtextResource it, final IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
    this.computeFoldingRegionBetweenKeywords(it, this._statemachineGrammarAccess.getStatemachineAccess().getResetEventsKeyword_2_0(), this._statemachineGrammarAccess.getStatemachineAccess().getEndKeyword_2_2(), foldingRegionAcceptor);
  }
  
  private void computeCommandsFolding(final XtextResource it, final IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
    this.computeFoldingRegionBetweenKeywords(it, this._statemachineGrammarAccess.getStatemachineAccess().getCommandsKeyword_3_0(), this._statemachineGrammarAccess.getStatemachineAccess().getEndKeyword_3_2(), foldingRegionAcceptor);
  }
  
  private void computeFoldingRegionBetweenKeywords(final XtextResource it, final Keyword startKeyword, final Keyword endKeyword, final IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
    final ITextRegion region = this.textRegionBetween(it, startKeyword, endKeyword);
    if ((region != null)) {
      foldingRegionAcceptor.accept(region.getOffset(), region.getLength());
    }
  }
  
  /**
   * Determine the text region between the start keyword and the end keyword.
   */
  private ITextRegion textRegionBetween(final XtextResource it, final Keyword startKeyword, final Keyword endKeyword) {
    INode startNode = null;
    BidiTreeIterable<INode> _asTreeIterable = it.getParseResult().getRootNode().getAsTreeIterable();
    for (final INode node : _asTreeIterable) {
      {
        final EObject grammarElement = node.getGrammarElement();
        boolean _equals = Objects.equal(grammarElement, startKeyword);
        if (_equals) {
          startNode = node;
        }
        if ((Objects.equal(grammarElement, endKeyword) && (startNode != null))) {
          return this.textRegionBetween(it, startNode, node);
        }
      }
    }
    return null;
  }
  
  /**
   * Determine the text region between the start node and the end node.
   */
  private ITextRegion textRegionBetween(final XtextResource it, final INode startNode, final INode endNode) {
    TextRegion _xblockexpression = null;
    {
      final int offset = startNode.getOffset();
      int _endOffset = endNode.getEndOffset();
      final int length = (_endOffset - offset);
      _xblockexpression = new TextRegion(offset, length);
    }
    return _xblockexpression;
  }
}
