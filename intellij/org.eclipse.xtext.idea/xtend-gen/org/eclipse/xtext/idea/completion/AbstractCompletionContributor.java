/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.completion;

import com.google.common.base.Objects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.codeInsight.completion.CompletionContext;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionInitializationContext;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResult;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionService;
import com.intellij.codeInsight.completion.CompletionSorter;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.LegacyCompletionContributor;
import com.intellij.codeInsight.completion.OffsetMap;
import com.intellij.codeInsight.completion.PrefixMatcher;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementWeigher;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.Consumer;
import com.intellij.util.ProcessingContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElementComputer;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.idea.completion.CompletionExtensions;
import org.eclipse.xtext.idea.editorActions.TokenSetProvider;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public abstract class AbstractCompletionContributor extends CompletionContributor {
  @Data
  public static class KeywordLookupElement extends LookupElement {
    private final Keyword keyword;
    
    @Override
    public String getLookupString() {
      return this.keyword.getValue();
    }
    
    public KeywordLookupElement(final Keyword keyword) {
      super();
      this.keyword = keyword;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.keyword== null) ? 0 : this.keyword.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      AbstractCompletionContributor.KeywordLookupElement other = (AbstractCompletionContributor.KeywordLookupElement) obj;
      if (this.keyword == null) {
        if (other.keyword != null)
          return false;
      } else if (!this.keyword.equals(other.keyword))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      String result = new ToStringBuilder(this)
      	.addAllFields()
      	.toString();
      return result;
    }
    
    @Pure
    public Keyword getKeyword() {
      return this.keyword;
    }
  }
  
  public static class DispreferKeywordsWeigher extends LookupElementWeigher {
    public DispreferKeywordsWeigher() {
      super("dispreferKeywords");
    }
    
    @Override
    public Boolean weigh(final LookupElement element) {
      return Boolean.valueOf((element instanceof AbstractCompletionContributor.KeywordLookupElement));
    }
  }
  
  @Inject(optional = true)
  private Provider<ContentAssistContextFactory> delegates;
  
  @Inject
  @Extension
  protected CompletionExtensions _completionExtensions;
  
  @Inject
  protected IGrammarAccess grammarAccess;
  
  @Inject
  @Extension
  protected TokenSetProvider _tokenSetProvider;
  
  @Inject(optional = true)
  private IContentAssistParser contentAssistParser;
  
  @Inject(optional = true)
  private FollowElementComputer followElementComputer;
  
  private ExecutorService pool = Executors.newFixedThreadPool(3);
  
  private final Map<CompletionType, Multimap<TokenSet, CompletionProvider<CompletionParameters>>> myContributors = CollectionLiterals.<CompletionType, Multimap<TokenSet, CompletionProvider<CompletionParameters>>>newHashMap();
  
  private final Map<CompletionType, Map<TokenSet, Multimap<AbstractElement, CompletionProvider<CompletionParameters>>>> myFollowElementBasedContributors = CollectionLiterals.<CompletionType, Map<TokenSet, Multimap<AbstractElement, CompletionProvider<CompletionParameters>>>>newHashMap();
  
  public AbstractCompletionContributor(final AbstractXtextLanguage lang) {
    lang.injectMembers(this);
  }
  
  protected void extend(final CompletionType type, final CompletionProvider<CompletionParameters> contrib) {
    TokenSet _defaultTokens = this._tokenSetProvider.getDefaultTokens();
    this.extend(type, new TokenSet[] { _defaultTokens }, contrib);
  }
  
  protected void extend(final CompletionType type, final TokenSet[] tokenSets, final CompletionProvider<CompletionParameters> contrib) {
    boolean _containsKey = this.myContributors.containsKey(type);
    boolean _not = (!_containsKey);
    if (_not) {
      ArrayListMultimap<TokenSet, CompletionProvider<CompletionParameters>> _create = ArrayListMultimap.<TokenSet, CompletionProvider<CompletionParameters>>create();
      this.myContributors.put(type, _create);
    }
    for (final TokenSet tokenSet : tokenSets) {
      Multimap<TokenSet, CompletionProvider<CompletionParameters>> _get = this.myContributors.get(type);
      _get.put(tokenSet, contrib);
    }
  }
  
  protected void extend(final CompletionType type, final EStructuralFeature feature, final CompletionProvider<CompletionParameters> contrib) {
    TokenSet _defaultTokens = this._tokenSetProvider.getDefaultTokens();
    this.extend(type, new TokenSet[] { _defaultTokens }, feature, contrib);
  }
  
  protected void extend(final CompletionType type, final TokenSet[] tokenSets, final EStructuralFeature feature, final CompletionProvider<CompletionParameters> contrib) {
    if ((this.followElementComputer == null)) {
      throw new IllegalStateException("followElementComputer is not injected, probably IDE project is missing");
    }
    Grammar _grammar = this.grammarAccess.getGrammar();
    final IFollowElementAcceptor _function = new IFollowElementAcceptor() {
      @Override
      public void accept(final AbstractElement it) {
        AbstractCompletionContributor.this.extend(type, tokenSets, it, contrib);
      }
    };
    this.followElementComputer.collectAbstractElements(_grammar, feature, _function);
  }
  
  protected void extend(final CompletionType type, final AbstractElement followElement, final CompletionProvider<CompletionParameters> contrib) {
    TokenSet _defaultTokens = this._tokenSetProvider.getDefaultTokens();
    this.extend(type, new TokenSet[] { _defaultTokens }, followElement, contrib);
  }
  
  protected void extend(final CompletionType type, final TokenSet[] tokenSets, final AbstractElement followElement, final CompletionProvider<CompletionParameters> contrib) {
    boolean _containsKey = this.myFollowElementBasedContributors.containsKey(type);
    boolean _not = (!_containsKey);
    if (_not) {
      HashMap<TokenSet, Multimap<AbstractElement, CompletionProvider<CompletionParameters>>> _newHashMap = CollectionLiterals.<TokenSet, Multimap<AbstractElement, CompletionProvider<CompletionParameters>>>newHashMap();
      this.myFollowElementBasedContributors.put(type, _newHashMap);
    }
    final Map<TokenSet, Multimap<AbstractElement, CompletionProvider<CompletionParameters>>> map = this.myFollowElementBasedContributors.get(type);
    for (final TokenSet tokenSet : tokenSets) {
      {
        boolean _containsKey_1 = map.containsKey(tokenSet);
        boolean _not_1 = (!_containsKey_1);
        if (_not_1) {
          ArrayListMultimap<AbstractElement, CompletionProvider<CompletionParameters>> _create = ArrayListMultimap.<AbstractElement, CompletionProvider<CompletionParameters>>create();
          map.put(tokenSet, _create);
        }
        final Multimap<AbstractElement, CompletionProvider<CompletionParameters>> providers = map.get(tokenSet);
        providers.put(followElement, contrib);
      }
    }
  }
  
  @Override
  public void fillCompletionVariants(final CompletionParameters parameters, final CompletionResultSet result) {
    CompletionSorter _completionSorter = this.getCompletionSorter(parameters, result);
    final CompletionResultSet sortedResult = result.withRelevanceSorter(_completionSorter);
    final Procedure1<CompletionResult> _function = new Procedure1<CompletionResult>() {
      @Override
      public void apply(final CompletionResult it) {
        LookupElement _lookupElement = it.getLookupElement();
        boolean _isValidProposal = AbstractCompletionContributor.this.isValidProposal(_lookupElement, parameters);
        if (_isValidProposal) {
          LookupElement _lookupElement_1 = it.getLookupElement();
          sortedResult.addElement(_lookupElement_1);
        }
      }
    };
    final Procedure1<CompletionResult> filteredConsumer = _function;
    CompletionService _completionService = CompletionService.getCompletionService();
    final CompletionResultSet filteredResult = _completionService.createResultSet(parameters, new Consumer<CompletionResult>() {
        public void consume(CompletionResult arg0) {
          filteredConsumer.apply(arg0);
        }
    }, this);
    this.createMatcherBasedProposals(parameters, filteredResult);
    this.createReferenceBasedProposals(parameters, filteredResult);
    this.createTokenSetBasedProposals(parameters, filteredResult);
    this.createFollowElementBasedProposals(parameters, filteredResult);
    this.createParserBasedProposals(parameters, filteredResult);
    result.stopHere();
  }
  
  protected void createTokenSetBasedProposals(final CompletionParameters parameters, final CompletionResultSet result) {
    boolean _or = false;
    boolean _isEmpty = this.myContributors.isEmpty();
    if (_isEmpty) {
      _or = true;
    } else {
      CompletionType _completionType = parameters.getCompletionType();
      boolean _containsKey = this.myContributors.containsKey(_completionType);
      boolean _not = (!_containsKey);
      _or = _not;
    }
    if (_or) {
      return;
    }
    Editor _editor = parameters.getEditor();
    int _offset = parameters.getOffset();
    final TokenSet tokenSet = this._tokenSetProvider.getTokenSet(((EditorEx) _editor), _offset);
    CompletionType _completionType_1 = parameters.getCompletionType();
    Multimap<TokenSet, CompletionProvider<CompletionParameters>> _get = this.myContributors.get(_completionType_1);
    final Collection<CompletionProvider<CompletionParameters>> providers = _get.get(tokenSet);
    boolean _equals = Objects.equal(providers, null);
    if (_equals) {
      return;
    }
    final HashSet<CompletionProvider<CompletionParameters>> calledProviders = CollectionLiterals.<CompletionProvider<CompletionParameters>>newHashSet();
    final ProcessingContext context = new ProcessingContext();
    for (final CompletionProvider<CompletionParameters> provider : providers) {
      boolean _add = calledProviders.add(provider);
      if (_add) {
        provider.addCompletionVariants(parameters, context, result);
        boolean _isStopped = result.isStopped();
        if (_isStopped) {
          return;
        }
      }
    }
  }
  
  protected void createFollowElementBasedProposals(final CompletionParameters parameters, final CompletionResultSet result) {
    boolean _or = false;
    boolean _isEmpty = this.myFollowElementBasedContributors.isEmpty();
    if (_isEmpty) {
      _or = true;
    } else {
      CompletionType _completionType = parameters.getCompletionType();
      boolean _containsKey = this.myFollowElementBasedContributors.containsKey(_completionType);
      boolean _not = (!_containsKey);
      _or = _not;
    }
    if (_or) {
      return;
    }
    Editor _editor = parameters.getEditor();
    int _offset = parameters.getOffset();
    final TokenSet tokenSet = this._tokenSetProvider.getTokenSet(((EditorEx) _editor), _offset);
    CompletionType _completionType_1 = parameters.getCompletionType();
    Map<TokenSet, Multimap<AbstractElement, CompletionProvider<CompletionParameters>>> _get = this.myFollowElementBasedContributors.get(_completionType_1);
    final Multimap<AbstractElement, CompletionProvider<CompletionParameters>> element2provider = _get.get(tokenSet);
    boolean _equals = Objects.equal(element2provider, null);
    if (_equals) {
      return;
    }
    final Set<AbstractElement> followElements = this.computeFollowElements(parameters);
    final HashSet<CompletionProvider<CompletionParameters>> calledProviders = CollectionLiterals.<CompletionProvider<CompletionParameters>>newHashSet();
    Set<AbstractElement> _keySet = element2provider.keySet();
    for (final AbstractElement followElement : _keySet) {
      {
        final ProcessingContext context = new ProcessingContext();
        boolean _contains = followElements.contains(followElement);
        if (_contains) {
          final Collection<CompletionProvider<CompletionParameters>> providers = element2provider.get(followElement);
          for (final CompletionProvider<CompletionParameters> provider : providers) {
            boolean _add = calledProviders.add(provider);
            if (_add) {
              provider.addCompletionVariants(parameters, context, result);
              boolean _isStopped = result.isStopped();
              if (_isStopped) {
                return;
              }
            }
          }
        }
      }
    }
  }
  
  protected Set<AbstractElement> computeFollowElements(final CompletionParameters parameters) {
    Editor _editor = parameters.getEditor();
    Document _document = _editor.getDocument();
    PsiElement _position = parameters.getPosition();
    ASTNode _node = _position.getNode();
    int _startOffset = _node.getStartOffset();
    TextRange _textRange = new TextRange(0, _startOffset);
    final String text = _document.getText(_textRange);
    final Collection<FollowElement> followElements = this.contentAssistParser.getFollowElements(text, false);
    final HashSet<AbstractElement> allElements = CollectionLiterals.<AbstractElement>newHashSet();
    this.followElementComputer.computeFollowElements(followElements, allElements);
    return allElements;
  }
  
  protected CompletionSorter getCompletionSorter(final CompletionParameters parameters, final CompletionResultSet result) {
    PrefixMatcher _prefixMatcher = result.getPrefixMatcher();
    CompletionSorter _defaultSorter = CompletionSorter.defaultSorter(parameters, _prefixMatcher);
    AbstractCompletionContributor.DispreferKeywordsWeigher _dispreferKeywordsWeigher = new AbstractCompletionContributor.DispreferKeywordsWeigher();
    return _defaultSorter.weighBefore("liftShorter", _dispreferKeywordsWeigher);
  }
  
  protected boolean isValidProposal(final LookupElement proposal, final CompletionParameters parameters) {
    return true;
  }
  
  protected void createMatcherBasedProposals(final CompletionParameters parameters, final CompletionResultSet result) {
    super.fillCompletionVariants(parameters, result);
  }
  
  protected boolean createReferenceBasedProposals(final CompletionParameters parameters, final CompletionResultSet result) {
    return LegacyCompletionContributor.completeReference(parameters, result);
  }
  
  protected void createParserBasedProposals(final CompletionParameters parameters, final CompletionResultSet result) {
    Editor _editor = parameters.getEditor();
    int _offset = parameters.getOffset();
    final TokenSet tokenSet = this._tokenSetProvider.getTokenSet(((EditorEx) _editor), _offset);
    boolean _supportParserBasedProposals = this.supportParserBasedProposals(tokenSet);
    boolean _not = (!_supportParserBasedProposals);
    if (_not) {
      return;
    }
    final ContentAssistContextFactory delegate = this.getParserBasedDelegate();
    boolean _equals = Objects.equal(delegate, null);
    if (_equals) {
      return;
    }
    String _text = this.getText(parameters);
    TextRegion _selection = this.getSelection(parameters);
    int _offset_1 = parameters.getOffset();
    XtextResource _resource = this.getResource(parameters);
    final ContentAssistContext[] contexts = delegate.create(_text, _selection, _offset_1, _resource);
    final Procedure1<ContentAssistContext> _function = new Procedure1<ContentAssistContext>() {
      @Override
      public void apply(final ContentAssistContext c) {
        ImmutableList<AbstractElement> _firstSetGrammarElements = c.getFirstSetGrammarElements();
        final Procedure1<AbstractElement> _function = new Procedure1<AbstractElement>() {
          @Override
          public void apply(final AbstractElement e) {
            AbstractCompletionContributor.this.createProposal(e, c, parameters, result);
          }
        };
        IterableExtensions.<AbstractElement>forEach(_firstSetGrammarElements, _function);
      }
    };
    IterableExtensions.<ContentAssistContext>forEach(((Iterable<ContentAssistContext>)Conversions.doWrapArray(contexts)), _function);
  }
  
  protected boolean supportParserBasedProposals(final TokenSet tokenSet) {
    TokenSet _defaultTokens = this._tokenSetProvider.getDefaultTokens();
    return Objects.equal(tokenSet, _defaultTokens);
  }
  
  protected ContentAssistContextFactory getParserBasedDelegate() {
    ContentAssistContextFactory _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this.delegates, null);
      if (_equals) {
        return null;
      }
      ContentAssistContextFactory _get = this.delegates.get();
      final Procedure1<ContentAssistContextFactory> _function = new Procedure1<ContentAssistContextFactory>() {
        @Override
        public void apply(final ContentAssistContextFactory it) {
          it.setPool(AbstractCompletionContributor.this.pool);
        }
      };
      _xblockexpression = ObjectExtensions.<ContentAssistContextFactory>operator_doubleArrow(_get, _function);
    }
    return _xblockexpression;
  }
  
  protected String getText(final CompletionParameters parameters) {
    final Computable<String> _function = new Computable<String>() {
      @Override
      public String compute() {
        PsiFile _originalFile = parameters.getOriginalFile();
        return _originalFile.getText();
      }
    };
    return this.<String>runReadAction(_function);
  }
  
  protected TextRegion getSelection(final CompletionParameters parameters) {
    TextRegion _xblockexpression = null;
    {
      final OffsetMap offsets = this.getOffsets(parameters);
      final int startOffset = offsets.getOffset(CompletionInitializationContext.START_OFFSET);
      final int endOffset = offsets.getOffset(CompletionInitializationContext.SELECTION_END_OFFSET);
      _xblockexpression = new TextRegion(startOffset, (endOffset - startOffset));
    }
    return _xblockexpression;
  }
  
  protected OffsetMap getOffsets(final CompletionParameters parameters) {
    final Computable<OffsetMap> _function = new Computable<OffsetMap>() {
      @Override
      public OffsetMap compute() {
        PsiElement _position = parameters.getPosition();
        CompletionContext _userData = _position.<CompletionContext>getUserData(CompletionContext.COMPLETION_CONTEXT_KEY);
        return _userData.getOffsetMap();
      }
    };
    return this.<OffsetMap>runReadAction(_function);
  }
  
  protected XtextResource getResource(final CompletionParameters parameters) {
    final Computable<XtextResource> _function = new Computable<XtextResource>() {
      @Override
      public XtextResource compute() {
        PsiFile _originalFile = parameters.getOriginalFile();
        return ((BaseXtextFile) _originalFile).getResource();
      }
    };
    return this.<XtextResource>runReadAction(_function);
  }
  
  protected <T extends Object> T runReadAction(final Computable<T> computable) {
    Application _application = ApplicationManager.getApplication();
    return _application.<T>runReadAction(computable);
  }
  
  protected void createProposal(final AbstractElement grammarElement, final ContentAssistContext context, final CompletionParameters parameters, final CompletionResultSet result) {
    boolean _matched = false;
    if (!_matched) {
      if (grammarElement instanceof Keyword) {
        _matched=true;
        this.createKeyWordProposal(((Keyword)grammarElement), context, parameters, result);
      }
    }
  }
  
  protected void createKeyWordProposal(final Keyword keyword, final ContentAssistContext context, final CompletionParameters parameters, final CompletionResultSet result) {
    boolean _isKeywordWorthyToPropose = this.isKeywordWorthyToPropose(keyword);
    if (_isKeywordWorthyToPropose) {
      AbstractCompletionContributor.KeywordLookupElement _keywordLookupElement = new AbstractCompletionContributor.KeywordLookupElement(keyword);
      this._completionExtensions.operator_add(result, _keywordLookupElement);
    }
  }
  
  protected boolean isKeywordWorthyToPropose(final Keyword keyword) {
    boolean _and = false;
    String _value = keyword.getValue();
    int _length = _value.length();
    boolean _greaterThan = (_length > 1);
    if (!_greaterThan) {
      _and = false;
    } else {
      String _value_1 = keyword.getValue();
      char _charAt = _value_1.charAt(0);
      boolean _isLetter = Character.isLetter(_charAt);
      _and = _isLetter;
    }
    return _and;
  }
}
