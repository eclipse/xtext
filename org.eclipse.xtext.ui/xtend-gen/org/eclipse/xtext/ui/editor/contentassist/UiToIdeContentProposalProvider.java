/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.contentassist;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.AbstractCompletionProposalFactory;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalLabelProvider;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Delegates to the generic IDE content proposal provider. Use this Implementation to share the same content assist
 * code between Eclipse and other editors for your DSL.
 * 
 * @author Titouan Vervack - Initial contribution and API
 * 
 * @since 2.13
 */
@SuppressWarnings("all")
public class UiToIdeContentProposalProvider extends AbstractCompletionProposalFactory implements IContentProposalProvider {
  @Inject
  private IdeContentProposalProvider ideProvider;
  
  @Inject
  private Provider<ContentAssistContext.Builder> builderProvider;
  
  @Inject
  @ContentProposalLabelProvider
  private ILabelProvider labelProvider;
  
  @Override
  public void createProposals(final org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final ArrayList<Pair<ContentAssistEntry, Integer>> entries = new ArrayList<Pair<ContentAssistEntry, Integer>>();
    final IIdeContentProposalAcceptor ideAcceptor = new IIdeContentProposalAcceptor() {
      @Override
      public void accept(final ContentAssistEntry entry, final int priority) {
        if ((entry != null)) {
          Pair<ContentAssistEntry, Integer> _mappedTo = Pair.<ContentAssistEntry, Integer>of(entry, Integer.valueOf(priority));
          entries.add(_mappedTo);
        }
      }
      
      @Override
      public boolean canAcceptMoreProposals() {
        int _size = entries.size();
        int _maxProposals = UiToIdeContentProposalProvider.this.getMaxProposals();
        return (_size < _maxProposals);
      }
    };
    ContentAssistContext _ideContext = this.getIdeContext(context);
    this.ideProvider.createProposals(Collections.<ContentAssistContext>unmodifiableList(CollectionLiterals.<ContentAssistContext>newArrayList(_ideContext)), ideAcceptor);
    final AbstractContentProposalProvider.NullSafeCompletionProposalAcceptor uiAcceptor = new AbstractContentProposalProvider.NullSafeCompletionProposalAcceptor(acceptor);
    final Procedure2<Pair<ContentAssistEntry, Integer>, Integer> _function = (Pair<ContentAssistEntry, Integer> p, Integer idx) -> {
      final ContentAssistEntry entry = p.getKey();
      final ConfigurableCompletionProposal proposal = this.doCreateProposal(entry.getProposal(), this.getDisplayString(entry), this.getImage(entry), (p.getValue()).intValue(), context);
      uiAcceptor.accept(proposal);
    };
    IterableExtensions.<Pair<ContentAssistEntry, Integer>>forEach(entries, _function);
  }
  
  protected int getMaxProposals() {
    return 1000;
  }
  
  private ContentAssistContext getIdeContext(final org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext c) {
    final ContentAssistContext.Builder builder = this.builderProvider.get();
    final Region replaceRegion = c.getReplaceRegion();
    ContentAssistContext.Builder _setOffset = builder.setPrefix(c.getPrefix()).setSelectedText(c.getSelectedText()).setRootModel(c.getRootModel()).setRootNode(c.getRootNode()).setCurrentModel(c.getCurrentModel()).setPreviousModel(c.getPreviousModel()).setCurrentNode(c.getCurrentNode()).setLastCompleteNode(c.getLastCompleteNode()).setOffset(c.getOffset());
    int _offset = replaceRegion.getOffset();
    int _length = replaceRegion.getLength();
    TextRegion _textRegion = new TextRegion(_offset, _length);
    _setOffset.setReplaceRegion(_textRegion).setResource(c.getResource());
    ImmutableList<AbstractElement> _firstSetGrammarElements = c.getFirstSetGrammarElements();
    for (final AbstractElement grammarElement : _firstSetGrammarElements) {
      builder.accept(grammarElement);
    }
    return builder.toContext();
  }
  
  protected StyledString getDisplayString(final ContentAssistEntry entry) {
    String _elvis = null;
    String _label = entry.getLabel();
    if (_label != null) {
      _elvis = _label;
    } else {
      String _proposal = entry.getProposal();
      _elvis = _proposal;
    }
    final StyledString result = new StyledString(_elvis);
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(entry.getDescription());
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      String _description = entry.getDescription();
      String _plus = (" \u2013 " + _description);
      StyledString _styledString = new StyledString(_plus, StyledString.QUALIFIER_STYLER);
      result.append(_styledString);
    }
    return result;
  }
  
  protected Image getImage(final ContentAssistEntry entry) {
    Image _switchResult = null;
    Object _source = entry.getSource();
    final Object source = _source;
    boolean _matched = false;
    if (source instanceof IEObjectDescription) {
      _matched=true;
      _switchResult = this.getImage(((IEObjectDescription)source));
    }
    if (!_matched) {
      if (source instanceof EObject) {
        _matched=true;
        _switchResult = this.getImage(((EObject)source));
      }
    }
    return _switchResult;
  }
  
  /**
   * Returns the image for the label of the given element.
   * @param description the {@link IEObjectDescription} for which to provide the label image
   * @return the image used to label the element, or <code>null</code> if there is no image for the given object
   * @noreference This method is not intended to be referenced by clients.
   */
  protected Image getImage(final IEObjectDescription description) {
    return this.getImage(description.getEObjectOrProxy());
  }
  
  /**
   * Returns the image for the label of the given element.
   * @param eObject the element for which to provide the label image
   * @return the image used to label the element, or <code>null</code> if there is no image for the given object
   */
  protected Image getImage(final EObject eObject) {
    return this.labelProvider.getImage(eObject);
  }
}
