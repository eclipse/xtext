/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.findusages;

import com.google.inject.Inject;
import com.intellij.find.findUsages.CustomUsageSearcher;
import com.intellij.find.findUsages.FindUsagesOptions;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.psi.search.SearchRequestCollector;
import com.intellij.psi.search.SearchSession;
import com.intellij.usageView.UsageInfo;
import com.intellij.usages.Usage;
import com.intellij.usages.UsageInfoToUsageConverter;
import com.intellij.util.Processor;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratedSourceAwareUsageSearcher extends CustomUsageSearcher {
  @Inject
  private ITraceForVirtualFileProvider traceProvider;
  
  public GeneratedSourceAwareUsageSearcher() {
    IdeaSharedInjectorProvider.injectMembers(this);
  }
  
  @Override
  public void processElementUsages(final PsiElement element, final Processor<Usage> processor, final FindUsagesOptions options) {
    try {
      Project _project = element.getProject();
      PsiSearchHelper _instance = PsiSearchHelper.SERVICE.getInstance(_project);
      final Processor<PsiReference> _function = new Processor<PsiReference>() {
        @Override
        public boolean process(final PsiReference reference) {
          Application _application = ApplicationManager.getApplication();
          Computable<Collection<Usage>> _convert = GeneratedSourceAwareUsageSearcher.this.convert(element, reference);
          final Collection<Usage> usages = _application.<Collection<Usage>>runReadAction(_convert);
          boolean _isEmpty = usages.isEmpty();
          if (_isEmpty) {
            return false;
          }
          for (final Usage usage : usages) {
            boolean _process = processor.process(usage);
            boolean _not = (!_process);
            if (_not) {
              return false;
            }
          }
          return true;
        }
      };
      _instance.processRequests(options.fastTrack, _function);
    } finally {
      SearchSession _searchSession = new SearchSession();
      SearchRequestCollector _searchRequestCollector = new SearchRequestCollector(_searchSession);
      options.fastTrack = _searchRequestCollector;
    }
  }
  
  protected Computable<Collection<Usage>> convert(final PsiElement element, final PsiReference reference) {
    final Computable<Collection<Usage>> _function = new Computable<Collection<Usage>>() {
      @Override
      public Collection<Usage> compute() {
        List<Usage> _xblockexpression = null;
        {
          final PsiElement referencingElement = reference.getElement();
          boolean _isValid = referencingElement.isValid();
          boolean _not = (!_isValid);
          if (_not) {
            return CollectionLiterals.<Usage>emptyList();
          }
          final List<? extends PsiElement> originalElements = GeneratedSourceAwareUsageSearcher.this.traceProvider.getOriginalElements(referencingElement);
          boolean _isEmpty = originalElements.isEmpty();
          if (_isEmpty) {
            Usage _usage = GeneratedSourceAwareUsageSearcher.this.toUsage(element, reference);
            return Collections.<Usage>unmodifiableList(CollectionLiterals.<Usage>newArrayList(_usage));
          }
          final Function1<PsiElement, Usage> _function = new Function1<PsiElement, Usage>() {
            @Override
            public Usage apply(final PsiElement originalElement) {
              return GeneratedSourceAwareUsageSearcher.this.toUsage(element, originalElement);
            }
          };
          _xblockexpression = ListExtensions.map(originalElements, _function);
        }
        return _xblockexpression;
      }
    };
    return _function;
  }
  
  protected Usage toUsage(final PsiElement element, final PsiReference reference) {
    Usage _xblockexpression = null;
    {
      final UsageInfo usageInfo = new UsageInfo(reference);
      _xblockexpression = UsageInfoToUsageConverter.convert(new PsiElement[] { element }, usageInfo);
    }
    return _xblockexpression;
  }
  
  protected Usage toUsage(final PsiElement element, final PsiElement originalElement) {
    Usage _xblockexpression = null;
    {
      final UsageInfo usageInfo = new UsageInfo(originalElement);
      _xblockexpression = UsageInfoToUsageConverter.convert(new PsiElement[] { element }, usageInfo);
    }
    return _xblockexpression;
  }
}
