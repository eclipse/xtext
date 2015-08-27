/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.execution;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.execution.filters.ExceptionFilter;
import com.intellij.execution.filters.FileHyperlinkInfo;
import com.intellij.execution.filters.Filter;
import com.intellij.execution.filters.HyperlinkInfo;
import com.intellij.execution.filters.OpenFileHyperlinkInfo;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.RangeMarker;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.DocumentUtil;
import java.util.List;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.idea.trace.IIdeaTrace;
import org.eclipse.xtext.idea.trace.ILocationInVirtualFile;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.VirtualFileInProject;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TraceBasedExceptionFilter extends ExceptionFilter {
  @Inject
  private ITraceForVirtualFileProvider traceProvider;
  
  public TraceBasedExceptionFilter(final GlobalSearchScope scope) {
    super(scope);
    IdeaSharedInjectorProvider.injectMembers(this);
  }
  
  @Override
  public Filter.Result applyFilter(final String line, final int textEndOffset) {
    final Filter.Result result = super.applyFilter(line, textEndOffset);
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      return null;
    }
    List<Filter.ResultItem> _resultItems = result.getResultItems();
    final Function1<Filter.ResultItem, Boolean> _function = new Function1<Filter.ResultItem, Boolean>() {
      @Override
      public Boolean apply(final Filter.ResultItem it) {
        HyperlinkInfo _hyperlinkInfo = it.getHyperlinkInfo();
        return Boolean.valueOf((!Objects.equal(_hyperlinkInfo, null)));
      }
    };
    final Filter.ResultItem resultItem = IterableExtensions.<Filter.ResultItem>findFirst(_resultItems, _function);
    final HyperlinkInfo hyperlinkInfo = resultItem.getHyperlinkInfo();
    if ((hyperlinkInfo instanceof FileHyperlinkInfo)) {
      final OpenFileDescriptor descriptor = ((FileHyperlinkInfo)hyperlinkInfo).getDescriptor();
      boolean _notEquals = (!Objects.equal(descriptor, null));
      if (_notEquals) {
        VirtualFile _file = descriptor.getFile();
        Project _project = descriptor.getProject();
        final VirtualFileInProject fileInProject = new VirtualFileInProject(_file, _project);
        boolean _isGenerated = this.traceProvider.isGenerated(fileInProject);
        if (_isGenerated) {
          final IIdeaTrace trace = this.traceProvider.getTraceToSource(fileInProject);
          final RangeMarker rangeMarker = descriptor.getRangeMarker();
          boolean _and = false;
          boolean _notEquals_1 = (!Objects.equal(trace, null));
          if (!_notEquals_1) {
            _and = false;
          } else {
            boolean _notEquals_2 = (!Objects.equal(rangeMarker, null));
            _and = _notEquals_2;
          }
          if (_and) {
            Application _application = ApplicationManager.getApplication();
            final Computable<Integer> _function_1 = new Computable<Integer>() {
              @Override
              public Integer compute() {
                int _xblockexpression = (int) 0;
                {
                  FileDocumentManager _instance = FileDocumentManager.getInstance();
                  VirtualFile _file = descriptor.getFile();
                  final Document document = _instance.getDocument(_file);
                  int _startOffset = rangeMarker.getStartOffset();
                  final int lineNumber = document.getLineNumber(_startOffset);
                  _xblockexpression = DocumentUtil.getFirstNonSpaceCharOffset(document, lineNumber);
                }
                return Integer.valueOf(_xblockexpression);
              }
            };
            final Integer nonSpaceCharOffset = _application.<Integer>runReadAction(_function_1);
            TextRegion _textRegion = new TextRegion((nonSpaceCharOffset).intValue(), (nonSpaceCharOffset).intValue());
            final ILocationInVirtualFile location = trace.getBestAssociatedLocation(_textRegion);
            boolean _notEquals_3 = (!Objects.equal(location, null));
            if (_notEquals_3) {
              VirtualFileInProject _platformResource = location.getPlatformResource();
              Project _project_1 = _platformResource.getProject();
              VirtualFileInProject _platformResource_1 = location.getPlatformResource();
              VirtualFile _file_1 = _platformResource_1.getFile();
              ITextRegionWithLineInformation _textRegion_1 = location.getTextRegion();
              int _lineNumber = _textRegion_1.getLineNumber();
              final OpenFileDescriptor sourceFileDescriptor = new OpenFileDescriptor(_project_1, _file_1, _lineNumber, 
                0);
              final OpenFileHyperlinkInfo linkInfo = new OpenFileHyperlinkInfo(sourceFileDescriptor);
              int _highlightStartOffset = resultItem.getHighlightStartOffset();
              int _highlightEndOffset = resultItem.getHighlightEndOffset();
              TextAttributes _highlightAttributes = resultItem.getHighlightAttributes();
              return new Filter.Result(_highlightStartOffset, _highlightEndOffset, linkInfo, _highlightAttributes);
            }
          }
        }
      }
    }
    return result;
  }
}
