package org.eclipse.xtext.idea.example.entities.idea.completion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResult;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionSorter;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementWeigher;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.util.Consumer;

public class EntitiesCompletionContributor extends CompletionContributor {

	@Inject
	private Provider<ContentAssistContextFactory> delegates;
	private ExecutorService pool = Executors.newFixedThreadPool(3);
	
	public EntitiesCompletionContributor() {
		EntitiesLanguage.INSTANCE.injectMembers(this);
	}
	
	@Override
	public void fillCompletionVariants(final CompletionParameters parameters, CompletionResultSet result) {
		final CompletionResultSet sortedResult = getSortedResult(parameters, result);
		sortedResult.runRemainingContributors(parameters, new Consumer<CompletionResult>() {
			public void consume(CompletionResult t) {
				sortedResult.addElement(t.getLookupElement());
			}
		});
		String text = ApplicationManager.getApplication().runReadAction(new Computable<String>() {
			public String compute() {
				return parameters.getOriginalFile().getText();
			}});
		ITextRegion region = ApplicationManager.getApplication().runReadAction(new Computable<ITextRegion>() {
			public ITextRegion compute() {
				PsiElement originalPosition = parameters.getOriginalPosition();
				if (originalPosition == null) {
					return new TextRegion(parameters.getPosition().getTextRange().getStartOffset(), 0);
				} else {
					TextRange textRange = originalPosition.getTextRange();
					return new TextRegion(textRange.getStartOffset(), textRange.getLength());
				}
		}});
		XtextResource resource = ApplicationManager.getApplication().runReadAction(new Computable<XtextResource>() {
			public XtextResource compute() {
				return (XtextResource) ((BaseXtextFile) parameters.getOriginalFile()).getResource();
		}});
		ContentAssistContextFactory delegate = delegates.get();
		delegate.setPool(pool);
		ContentAssistContext[] contexts = delegate.create(text, region, parameters.getOffset(), resource);
		for (ContentAssistContext context : contexts) {
			for (AbstractElement grammarElement : context.getFirstSetGrammarElements()) {
				createProposal(grammarElement, sortedResult);
			}
		}
	}

	private CompletionResultSet getSortedResult(final CompletionParameters parameters, CompletionResultSet result) {
		CompletionSorter xtextSorter = CompletionSorter.defaultSorter(parameters, result.getPrefixMatcher())
			.weighBefore("liftShorter", new LookupElementWeigher("xtext") {
				@Override
				public Comparable<?> weigh(LookupElement element) {
					if (element instanceof KeywordLookupElement) {
						return 1;
					} else {
						return -1;
					}
				}
			});
		return result.withRelevanceSorter(xtextSorter);
	}
	
	private void createProposal(AbstractElement grammarElement, CompletionResultSet result) {
		if (grammarElement instanceof Keyword) {
			addKeyWordProposal(result, (Keyword) grammarElement);
		}
	}
	
	private void addKeyWordProposal(CompletionResultSet result, Keyword keyword) {
		LookupElement lookupElement = new KeywordLookupElement(keyword);
		result.addElement(lookupElement);
	}
	
	public static class KeywordLookupElement extends LookupElement {
		private Keyword keyword;
		
		public KeywordLookupElement(Keyword keyword) {
			this.keyword = keyword;
		}

		@Override
		public String getLookupString() {
			return keyword.getValue();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((keyword == null) ? 0 : keyword.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			KeywordLookupElement other = (KeywordLookupElement) obj;
			if (keyword == null) {
				if (other.keyword != null)
					return false;
			} else if (!keyword.equals(other.keyword))
				return false;
			return true;
		}
		
	}
}
