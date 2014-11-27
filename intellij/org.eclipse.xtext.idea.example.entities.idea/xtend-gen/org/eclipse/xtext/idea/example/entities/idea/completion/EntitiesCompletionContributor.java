package org.eclipse.xtext.idea.example.entities.idea.completion;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResult;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionSorter;
import com.intellij.codeInsight.completion.PrefixMatcher;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementWeigher;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.Consumer;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
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
public class EntitiesCompletionContributor extends CompletionContributor {
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
      EntitiesCompletionContributor.KeywordLookupElement other = (EntitiesCompletionContributor.KeywordLookupElement) obj;
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
  
  @Inject
  private Provider<ContentAssistContextFactory> delegates;
  
  private ExecutorService pool = Executors.newFixedThreadPool(3);
  
  public EntitiesCompletionContributor() {
    EntitiesLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  public void fillCompletionVariants(final CompletionParameters parameters, final CompletionResultSet result) {
    final CompletionResultSet sortedResult = this.getSortedResult(parameters, result);
    final Consumer<CompletionResult> _function = new Consumer<CompletionResult>() {
      public void consume(final CompletionResult it) {
        LookupElement _lookupElement = it.getLookupElement();
        sortedResult.addElement(_lookupElement);
      }
    };
    sortedResult.runRemainingContributors(parameters, _function);
    final Function1<CompletionParameters, String> _function_1 = new Function1<CompletionParameters, String>() {
      public String apply(final CompletionParameters it) {
        PsiFile _originalFile = it.getOriginalFile();
        return _originalFile.getText();
      }
    };
    final String text = this.<String>readOnly(parameters, _function_1);
    final Function1<CompletionParameters, TextRegion> _function_2 = new Function1<CompletionParameters, TextRegion>() {
      public TextRegion apply(final CompletionParameters it) {
        TextRegion _xifexpression = null;
        PsiElement _originalPosition = it.getOriginalPosition();
        boolean _equals = Objects.equal(_originalPosition, null);
        if (_equals) {
          PsiElement _position = it.getPosition();
          TextRange _textRange = _position.getTextRange();
          int _startOffset = _textRange.getStartOffset();
          _xifexpression = new TextRegion(_startOffset, 0);
        } else {
          TextRegion _xblockexpression = null;
          {
            PsiElement _originalPosition_1 = it.getOriginalPosition();
            final TextRange textRange = _originalPosition_1.getTextRange();
            int _startOffset_1 = textRange.getStartOffset();
            int _length = textRange.getLength();
            _xblockexpression = new TextRegion(_startOffset_1, _length);
          }
          _xifexpression = _xblockexpression;
        }
        return _xifexpression;
      }
    };
    TextRegion region = this.<TextRegion>readOnly(parameters, _function_2);
    final Function1<CompletionParameters, XtextResource> _function_3 = new Function1<CompletionParameters, XtextResource>() {
      public XtextResource apply(final CompletionParameters it) {
        PsiFile _originalFile = it.getOriginalFile();
        Resource _resource = ((BaseXtextFile) _originalFile).getResource();
        return ((XtextResource) _resource);
      }
    };
    final XtextResource resource = this.<XtextResource>readOnly(parameters, _function_3);
    ContentAssistContextFactory _get = this.delegates.get();
    final Procedure1<ContentAssistContextFactory> _function_4 = new Procedure1<ContentAssistContextFactory>() {
      public void apply(final ContentAssistContextFactory it) {
        it.setPool(EntitiesCompletionContributor.this.pool);
      }
    };
    final ContentAssistContextFactory delegate = ObjectExtensions.<ContentAssistContextFactory>operator_doubleArrow(_get, _function_4);
    int _offset = parameters.getOffset();
    final ContentAssistContext[] contexts = delegate.create(text, region, _offset, resource);
    final Procedure1<ContentAssistContext> _function_5 = new Procedure1<ContentAssistContext>() {
      public void apply(final ContentAssistContext c) {
        ImmutableList<AbstractElement> _firstSetGrammarElements = c.getFirstSetGrammarElements();
        final Procedure1<AbstractElement> _function = new Procedure1<AbstractElement>() {
          public void apply(final AbstractElement e) {
            EntitiesCompletionContributor.this.createProposal(e, c, sortedResult);
          }
        };
        IterableExtensions.<AbstractElement>forEach(_firstSetGrammarElements, _function);
      }
    };
    IterableExtensions.<ContentAssistContext>forEach(((Iterable<ContentAssistContext>)Conversions.doWrapArray(contexts)), _function_5);
  }
  
  private CompletionResultSet getSortedResult(final CompletionParameters parameters, final CompletionResultSet result) {
    CompletionResultSet _xblockexpression = null;
    {
      PrefixMatcher _prefixMatcher = result.getPrefixMatcher();
      CompletionSorter _defaultSorter = CompletionSorter.defaultSorter(parameters, _prefixMatcher);
      final CompletionSorter xtextSorter = _defaultSorter.weighBefore("liftShorter", 
        new LookupElementWeigher("xtext") {
          @Override
          public Comparable<?> weigh(final LookupElement element) {
            if ((element instanceof EntitiesCompletionContributor.KeywordLookupElement)) {
              return Integer.valueOf(1);
            } else {
              return Integer.valueOf((-1));
            }
          }
        });
      _xblockexpression = result.withRelevanceSorter(xtextSorter);
    }
    return _xblockexpression;
  }
  
  private <T extends Object> T readOnly(final CompletionParameters parameters, final Function1<? super CompletionParameters, ? extends T> reader) {
    Application _application = ApplicationManager.getApplication();
    final Computable<T> _function = new Computable<T>() {
      public T compute() {
        return reader.apply(parameters);
      }
    };
    return _application.<T>runReadAction(_function);
  }
  
  private Object _createProposal(final AbstractElement grammarElement, final ContentAssistContext context, final CompletionResultSet result) {
    return null;
  }
  
  private Object _createProposal(final Keyword keyword, final ContentAssistContext context, final CompletionResultSet result) {
    EntitiesCompletionContributor.KeywordLookupElement _keywordLookupElement = new EntitiesCompletionContributor.KeywordLookupElement(keyword);
    result.addElement(_keywordLookupElement);
    return null;
  }
  
  private Object createProposal(final AbstractElement keyword, final ContentAssistContext context, final CompletionResultSet result) {
    if (keyword instanceof Keyword) {
      return _createProposal((Keyword)keyword, context, result);
    } else if (keyword != null) {
      return _createProposal(keyword, context, result);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(keyword, context, result).toString());
    }
  }
}
