package org.eclipse.xtext.idea.completion;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.codeInsight.completion.CompletionContext;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionInitializationContext;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionSorter;
import com.intellij.codeInsight.completion.LegacyCompletionContributor;
import com.intellij.codeInsight.completion.OffsetMap;
import com.intellij.codeInsight.completion.PrefixMatcher;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementWeigher;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.util.Computable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
      int result = super.hashCode();
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
      if (!super.equals(obj))
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
    
    public Boolean weigh(final LookupElement element) {
      return Boolean.valueOf((element instanceof AbstractCompletionContributor.KeywordLookupElement));
    }
  }
  
  @Inject
  private Provider<ContentAssistContextFactory> delegates;
  
  private ExecutorService pool = Executors.newFixedThreadPool(3);
  
  public AbstractCompletionContributor(final AbstractXtextLanguage lang) {
    lang.injectMembers(this);
  }
  
  @Override
  public void fillCompletionVariants(final CompletionParameters parameters, final CompletionResultSet result) {
    CompletionSorter _completionSorter = this.getCompletionSorter(parameters, result);
    final CompletionResultSet sortedResult = result.withRelevanceSorter(_completionSorter);
    this.createMatcherBasedProposals(parameters, sortedResult);
    this.createReferenceBasedProposals(parameters, sortedResult);
    this.createParserBasedProposals(parameters, sortedResult);
    result.stopHere();
  }
  
  protected CompletionSorter getCompletionSorter(final CompletionParameters parameters, final CompletionResultSet result) {
    PrefixMatcher _prefixMatcher = result.getPrefixMatcher();
    CompletionSorter _defaultSorter = CompletionSorter.defaultSorter(parameters, _prefixMatcher);
    AbstractCompletionContributor.DispreferKeywordsWeigher _dispreferKeywordsWeigher = new AbstractCompletionContributor.DispreferKeywordsWeigher();
    return _defaultSorter.weighBefore("liftShorter", _dispreferKeywordsWeigher);
  }
  
  protected void createMatcherBasedProposals(final CompletionParameters parameters, final CompletionResultSet sortedResult) {
    super.fillCompletionVariants(parameters, sortedResult);
  }
  
  protected boolean createReferenceBasedProposals(final CompletionParameters parameters, final CompletionResultSet sortedResult) {
    return LegacyCompletionContributor.completeReference(parameters, sortedResult);
  }
  
  protected void createParserBasedProposals(final CompletionParameters parameters, final CompletionResultSet result) {
    ContentAssistContextFactory _newParserBasedFactory = this.newParserBasedFactory();
    String _text = this.getText(parameters);
    TextRegion _selection = this.getSelection(parameters);
    int _offset = parameters.getOffset();
    XtextResource _resource = this.getResource(parameters);
    final ContentAssistContext[] contexts = _newParserBasedFactory.create(_text, _selection, _offset, _resource);
    final Procedure1<ContentAssistContext> _function = new Procedure1<ContentAssistContext>() {
      public void apply(final ContentAssistContext c) {
        ImmutableList<AbstractElement> _firstSetGrammarElements = c.getFirstSetGrammarElements();
        final Procedure1<AbstractElement> _function = new Procedure1<AbstractElement>() {
          public void apply(final AbstractElement e) {
            AbstractCompletionContributor.this.createProposal(e, c, parameters, result);
          }
        };
        IterableExtensions.<AbstractElement>forEach(_firstSetGrammarElements, _function);
      }
    };
    IterableExtensions.<ContentAssistContext>forEach(((Iterable<ContentAssistContext>)Conversions.doWrapArray(contexts)), _function);
  }
  
  protected ContentAssistContextFactory newParserBasedFactory() {
    ContentAssistContextFactory _get = this.delegates.get();
    final Procedure1<ContentAssistContextFactory> _function = new Procedure1<ContentAssistContextFactory>() {
      public void apply(final ContentAssistContextFactory it) {
        it.setPool(AbstractCompletionContributor.this.pool);
      }
    };
    return ObjectExtensions.<ContentAssistContextFactory>operator_doubleArrow(_get, _function);
  }
  
  protected String getText(final CompletionParameters parameters) {
    final Function1<CompletionParameters, String> _function = new Function1<CompletionParameters, String>() {
      public String apply(final CompletionParameters it) {
        PsiFile _originalFile = it.getOriginalFile();
        return _originalFile.getText();
      }
    };
    return this.<String>readOnly(parameters, _function);
  }
  
  protected TextRegion getSelection(final CompletionParameters parameters) {
    final Function1<CompletionParameters, TextRegion> _function = new Function1<CompletionParameters, TextRegion>() {
      public TextRegion apply(final CompletionParameters it) {
        TextRegion _xblockexpression = null;
        {
          PsiElement _position = parameters.getPosition();
          CompletionContext _userData = _position.<CompletionContext>getUserData(CompletionContext.COMPLETION_CONTEXT_KEY);
          final CompletionContext context = ((CompletionContext) _userData);
          final int startOffset = context.getStartOffset();
          OffsetMap _offsetMap = context.getOffsetMap();
          final int endOffset = _offsetMap.getOffset(CompletionInitializationContext.SELECTION_END_OFFSET);
          _xblockexpression = new TextRegion(startOffset, (endOffset - startOffset));
        }
        return _xblockexpression;
      }
    };
    return this.<TextRegion>readOnly(parameters, _function);
  }
  
  protected XtextResource getResource(final CompletionParameters parameters) {
    final Function1<CompletionParameters, XtextResource> _function = new Function1<CompletionParameters, XtextResource>() {
      public XtextResource apply(final CompletionParameters it) {
        PsiFile _originalFile = it.getOriginalFile();
        Resource _resource = ((BaseXtextFile) _originalFile).getResource();
        return ((XtextResource) _resource);
      }
    };
    return this.<XtextResource>readOnly(parameters, _function);
  }
  
  protected final <T extends Object> T readOnly(final CompletionParameters parameters, final Function1<? super CompletionParameters, ? extends T> reader) {
    Application _application = ApplicationManager.getApplication();
    final Computable<T> _function = new Computable<T>() {
      public T compute() {
        return reader.apply(parameters);
      }
    };
    return _application.<T>runReadAction(_function);
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
    AbstractCompletionContributor.KeywordLookupElement _keywordLookupElement = new AbstractCompletionContributor.KeywordLookupElement(keyword);
    result.addElement(_keywordLookupElement);
  }
}
