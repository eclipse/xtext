/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.trace;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtilCore;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.jetbrains.annotations.NotNull;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceUtils {
  @Inject
  private TraceRegionSerializer traceRegionSerializer;
  
  @Inject
  private TraceFileNameProvider traceFileNameProvider;
  
  public Iterable<? extends PsiElement> getBestJavaElementMatch(@NotNull final PsiElement xtextElement) {
    try {
      if ((xtextElement instanceof BaseXtextFile)) {
        return this.getJavaFiles(xtextElement);
      }
      final ArrayList<PsiElement> javaElements = CollectionLiterals.<PsiElement>newArrayList();
      Iterable<PsiFile> _javaFiles = this.getJavaFiles(xtextElement);
      for (final PsiFile javaFile : _javaFiles) {
        {
          VirtualFile _virtualFile = javaFile.getVirtualFile();
          final URI uri = VirtualFileURIUtil.getURI(_virtualFile);
          String _lastSegment = uri.lastSegment();
          final String lastSegmentOfTrace = this.traceFileNameProvider.getTraceFromJava(_lastSegment);
          URI _trimSegments = uri.trimSegments(1);
          URI _appendSegment = _trimSegments.appendSegment(lastSegmentOfTrace);
          final VirtualFile traceFile = VirtualFileURIUtil.getVirtualFile(_appendSegment);
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(traceFile, null));
          if (!_notEquals) {
            _and = false;
          } else {
            boolean _exists = traceFile.exists();
            _and = _exists;
          }
          if (_and) {
            InputStream _inputStream = traceFile.getInputStream();
            final AbstractTraceRegion traces = this.traceRegionSerializer.readTraceRegionFrom(_inputStream);
            TextRange _textRange = xtextElement.getTextRange();
            final ITextRegion sourceRegion = this.toTextRegion(_textRange);
            TreeIterator<AbstractTraceRegion> _treeIterator = traces.treeIterator();
            final Function1<AbstractTraceRegion, Boolean> _function = new Function1<AbstractTraceRegion, Boolean>() {
              @Override
              public Boolean apply(final AbstractTraceRegion it) {
                ILocationData _mergedAssociatedLocation = it.getMergedAssociatedLocation();
                return Boolean.valueOf(_mergedAssociatedLocation.contains(sourceRegion));
              }
            };
            final Iterator<AbstractTraceRegion> matches = IteratorExtensions.<AbstractTraceRegion>filter(_treeIterator, _function);
            boolean _isEmpty = IteratorExtensions.isEmpty(matches);
            boolean _not = (!_isEmpty);
            if (_not) {
              final Comparator<AbstractTraceRegion> _function_1 = new Comparator<AbstractTraceRegion>() {
                @Override
                public int compare(final AbstractTraceRegion t1, final AbstractTraceRegion t2) {
                  ILocationData _mergedAssociatedLocation = t1.getMergedAssociatedLocation();
                  int _length = _mergedAssociatedLocation.getLength();
                  ILocationData _mergedAssociatedLocation_1 = t2.getMergedAssociatedLocation();
                  int _length_1 = _mergedAssociatedLocation_1.getLength();
                  return Integer.valueOf(_length).compareTo(Integer.valueOf(_length_1));
                }
              };
              final AbstractTraceRegion bestTrace = IteratorExtensions.<AbstractTraceRegion>min(matches, _function_1);
              int _myOffset = bestTrace.getMyOffset();
              PsiElement _elementAtOffset = PsiUtilCore.getElementAtOffset(javaFile, _myOffset);
              javaElements.add(_elementAtOffset);
            }
          }
          return javaElements;
        }
      }
      return CollectionLiterals.<PsiElement>emptySet();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Iterable<PsiFile> getJavaFiles(@NotNull final PsiElement xtextElement) {
    final BaseXtextFile xtextFile = PsiTreeUtil.<BaseXtextFile>getParentOfType(xtextElement, BaseXtextFile.class, false);
    boolean _equals = Objects.equal(xtextFile, null);
    if (_equals) {
      return CollectionLiterals.<PsiFile>emptySet();
    }
    Project _project = xtextFile.getProject();
    final XtextAutoBuilderComponent builder = _project.<XtextAutoBuilderComponent>getComponent(XtextAutoBuilderComponent.class);
    VirtualFile _virtualFile = xtextFile.getVirtualFile();
    URI _uRI = VirtualFileURIUtil.getURI(_virtualFile);
    final Iterable<URI> generated = builder.getGeneratedSources(_uRI);
    boolean _notEquals = (!Objects.equal(generated, null));
    if (_notEquals) {
      final ArrayList<PsiFile> javaFiles = CollectionLiterals.<PsiFile>newArrayList();
      final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
        @Override
        public Boolean apply(final URI it) {
          String _fileExtension = it.fileExtension();
          return Boolean.valueOf(Objects.equal(_fileExtension, "java"));
        }
      };
      Iterable<URI> _filter = IterableExtensions.<URI>filter(generated, _function);
      for (final URI uri : _filter) {
        {
          Project _project_1 = xtextFile.getProject();
          PsiManager _instance = PsiManager.getInstance(_project_1);
          VirtualFile _virtualFile_1 = VirtualFileURIUtil.getVirtualFile(uri);
          final PsiFile javaPsiFile = _instance.findFile(_virtualFile_1);
          javaFiles.add(javaPsiFile);
        }
      }
      return javaFiles;
    }
    return CollectionLiterals.<PsiFile>emptySet();
  }
  
  public ITextRegion toTextRegion(final TextRange range) {
    int _startOffset = range.getStartOffset();
    int _length = range.getLength();
    return new TextRegion(_startOffset, _length);
  }
}
