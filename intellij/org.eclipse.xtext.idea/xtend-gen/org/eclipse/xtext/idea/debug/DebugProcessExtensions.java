/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.debug;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.debugger.SourcePosition;
import com.intellij.debugger.engine.DebugProcess;
import com.intellij.debugger.engine.DebugProcessImpl;
import com.intellij.debugger.engine.PositionManagerImpl;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.sun.jdi.Location;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class DebugProcessExtensions {
  @Inject
  private TraceRegionSerializer traceRegionSerializer;
  
  @Inject
  private TraceFileNameProvider traceFileNameProvider;
  
  public PsiFile getPsiFile(final DebugProcess process, final Location location) {
    final PositionManagerImpl delegate = this.getJavaPositionManger(process);
    Application _application = ApplicationManager.getApplication();
    final Computable<PsiFile> _function = new Computable<PsiFile>() {
      @Override
      public PsiFile compute() {
        try {
          final Method method = PositionManagerImpl.class.getDeclaredMethod("getPsiFileByLocation", Project.class, Location.class);
          method.setAccessible(true);
          Project _project = process.getProject();
          final Object result = method.invoke(delegate, _project, location);
          return ((PsiFile) result);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    return _application.<PsiFile>runReadAction(_function);
  }
  
  public AbstractTraceRegion getTraceForJava(final SourcePosition javaSource) {
    try {
      PsiFile _file = javaSource.getFile();
      VirtualFile _virtualFile = _file.getVirtualFile();
      final URI uri = VirtualFileURIUtil.getURI(_virtualFile);
      String _lastSegment = uri.lastSegment();
      final String lastSegmentOfTrace = this.traceFileNameProvider.getTraceFromJava(_lastSegment);
      URI _trimSegments = uri.trimSegments(1);
      URI _appendSegment = _trimSegments.appendSegment(lastSegmentOfTrace);
      final VirtualFile virtualFile = VirtualFileURIUtil.getVirtualFile(_appendSegment);
      if ((Objects.equal(virtualFile, null) || (!virtualFile.exists()))) {
        return null;
      }
      InputStream _inputStream = virtualFile.getInputStream();
      final AbstractTraceRegion trace = this.traceRegionSerializer.readTraceRegionFrom(_inputStream);
      return trace;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public PsiFile getPsiFile(final DebugProcess process, final URI uri) {
    Application _application = ApplicationManager.getApplication();
    final Computable<PsiFile> _function = new Computable<PsiFile>() {
      @Override
      public PsiFile compute() {
        Project _project = process.getProject();
        PsiManager _instance = PsiManager.getInstance(_project);
        VirtualFile _virtualFile = VirtualFileURIUtil.getVirtualFile(uri);
        return _instance.findFile(_virtualFile);
      }
    };
    return _application.<PsiFile>runReadAction(_function);
  }
  
  public Map<URI, AbstractTraceRegion> getTracesForSource(final DebugProcess process, final SourcePosition source) {
    try {
      Project _project = process.getProject();
      final XtextAutoBuilderComponent builder = _project.<XtextAutoBuilderComponent>getComponent(XtextAutoBuilderComponent.class);
      PsiFile _file = source.getFile();
      VirtualFile _virtualFile = _file.getVirtualFile();
      URI _uRI = VirtualFileURIUtil.getURI(_virtualFile);
      final Iterable<URI> generated = builder.getGeneratedSources(_uRI);
      final HashMap<URI, AbstractTraceRegion> result = CollectionLiterals.<URI, AbstractTraceRegion>newHashMap();
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
          String _lastSegment = uri.lastSegment();
          final String lastSegmentOfTrace = this.traceFileNameProvider.getTraceFromJava(_lastSegment);
          URI _trimSegments = uri.trimSegments(1);
          URI _appendSegment = _trimSegments.appendSegment(lastSegmentOfTrace);
          final VirtualFile virtualFile = VirtualFileURIUtil.getVirtualFile(_appendSegment);
          if (((!Objects.equal(virtualFile, null)) && virtualFile.exists())) {
            InputStream _inputStream = virtualFile.getInputStream();
            final AbstractTraceRegion trace = this.traceRegionSerializer.readTraceRegionFrom(_inputStream);
            result.put(uri, trace);
          }
        }
      }
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public PositionManagerImpl getJavaPositionManger(final DebugProcess process) {
    return new PositionManagerImpl(((DebugProcessImpl) process));
  }
  
  public URI findOriginalDeclaration(final DebugProcess process, final Location location) {
    final PsiFile psiFile = this.getPsiFile(process, location);
    boolean _equals = Objects.equal(psiFile, null);
    if (_equals) {
      return null;
    } else {
      Project _project = process.getProject();
      XtextAutoBuilderComponent _component = _project.<XtextAutoBuilderComponent>getComponent(XtextAutoBuilderComponent.class);
      VirtualFile _virtualFile = psiFile.getVirtualFile();
      URI _uRI = VirtualFileURIUtil.getURI(_virtualFile);
      Iterable<URI> _source4GeneratedSource = _component.getSource4GeneratedSource(_uRI);
      return IterableExtensions.<URI>head(_source4GeneratedSource);
    }
  }
}
