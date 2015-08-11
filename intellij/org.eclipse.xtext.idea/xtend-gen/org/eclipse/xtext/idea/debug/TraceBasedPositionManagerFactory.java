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
import com.intellij.debugger.NoDataException;
import com.intellij.debugger.PositionManager;
import com.intellij.debugger.PositionManagerFactory;
import com.intellij.debugger.SourcePosition;
import com.intellij.debugger.engine.DebugProcess;
import com.intellij.debugger.engine.PositionManagerImpl;
import com.intellij.debugger.requests.ClassPrepareRequestor;
import com.intellij.debugger.requests.RequestManager;
import com.intellij.lang.Language;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtil;
import com.intellij.util.DocumentUtil;
import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.Location;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.request.ClassPrepareRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.idea.debug.DebugProcessExtensions;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.trace.IIdeaTrace;
import org.eclipse.xtext.idea.trace.ILocationInVirtualFile;
import org.eclipse.xtext.idea.trace.TraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.VirtualFileInProject;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceBasedPositionManagerFactory extends PositionManagerFactory {
  public static class TraceBasedPositionManager implements PositionManager {
    private final DebugProcess process;
    
    private final IXtextLanguage language;
    
    @Inject
    @Extension
    private DebugProcessExtensions _debugProcessExtensions;
    
    @Inject
    private TraceForVirtualFileProvider traceForVirtualFileProvider;
    
    public TraceBasedPositionManager(final DebugProcess process, final IXtextLanguage language) {
      this.process = process;
      this.language = language;
    }
    
    /**
     * This one is called
     */
    @Override
    public ClassPrepareRequest createPrepareRequest(final ClassPrepareRequestor requestor, final SourcePosition source) throws NoDataException {
      PsiFile _file = source.getFile();
      Language _language = _file.getLanguage();
      boolean _notEquals = (!Objects.equal(_language, this.language));
      if (_notEquals) {
        throw NoDataException.INSTANCE;
      }
      Application _application = ApplicationManager.getApplication();
      final Computable<Set<String>> _function = new Computable<Set<String>>() {
        @Override
        public Set<String> compute() {
          try {
            PsiElement _elementAt = source.getElementAt();
            VirtualFileInProject _forPsiElement = VirtualFileInProject.forPsiElement(_elementAt);
            final IIdeaTrace trace = TraceBasedPositionManager.this.traceForVirtualFileProvider.getTraceToTarget(_forPsiElement);
            boolean _equals = Objects.equal(trace, null);
            if (_equals) {
              throw NoDataException.INSTANCE;
            }
            Iterable<? extends ILocationInVirtualFile> _allAssociatedLocations = trace.getAllAssociatedLocations();
            final Function1<ILocationInVirtualFile, String> _function = new Function1<ILocationInVirtualFile, String>() {
              @Override
              public String apply(final ILocationInVirtualFile it) {
                SourceRelativeURI _srcRelativeResourceURI = it.getSrcRelativeResourceURI();
                URI _uRI = _srcRelativeResourceURI.getURI();
                return _uRI.lastSegment();
              }
            };
            Iterable<String> _map = IterableExtensions.map(_allAssociatedLocations, _function);
            return IterableExtensions.<String>toSet(_map);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final Set<String> names = _application.<Set<String>>runReadAction(_function);
      boolean _isEmpty = names.isEmpty();
      if (_isEmpty) {
        throw NoDataException.INSTANCE;
      }
      RequestManager _requestsManager = this.process.getRequestsManager();
      final ClassPrepareRequestor _function_1 = new ClassPrepareRequestor() {
        @Override
        public void processClassPrepare(final DebugProcess process, final ReferenceType refType) {
          try {
            String _sourceName = refType.sourceName();
            boolean _contains = names.contains(_sourceName);
            if (_contains) {
              requestor.processClassPrepare(process, refType);
            }
          } catch (final Throwable _t) {
            if (_t instanceof AbsentInformationException) {
              final AbsentInformationException ignore = (AbsentInformationException)_t;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
      return _requestsManager.createClassPrepareRequest(_function_1, "*");
    }
    
    @Override
    public List<ReferenceType> getAllClasses(final SourcePosition source) throws NoDataException {
      PsiFile _file = source.getFile();
      Language _language = _file.getLanguage();
      boolean _notEquals = (!Objects.equal(_language, this.language));
      if (_notEquals) {
        throw NoDataException.INSTANCE;
      }
      final Map<URI, AbstractTraceRegion> traces = this._debugProcessExtensions.getTracesForSource(this.process, source);
      final ArrayList<ReferenceType> allClasses = CollectionLiterals.<ReferenceType>newArrayList();
      final int line = source.getLine();
      Set<Map.Entry<URI, AbstractTraceRegion>> _entrySet = traces.entrySet();
      for (final Map.Entry<URI, AbstractTraceRegion> uri2trace : _entrySet) {
        {
          AbstractTraceRegion _value = uri2trace.getValue();
          TreeIterator<AbstractTraceRegion> _treeIterator = _value.treeIterator();
          final Function1<AbstractTraceRegion, Boolean> _function = new Function1<AbstractTraceRegion, Boolean>() {
            @Override
            public Boolean apply(final AbstractTraceRegion it) {
              List<ILocationData> _associatedLocations = it.getAssociatedLocations();
              ILocationData _head = IterableExtensions.<ILocationData>head(_associatedLocations);
              int _lineNumber = 0;
              if (_head!=null) {
                _lineNumber=_head.getLineNumber();
              }
              return Boolean.valueOf((_lineNumber == line));
            }
          };
          final AbstractTraceRegion region = IteratorExtensions.<AbstractTraceRegion>findFirst(_treeIterator, _function);
          boolean _notEquals_1 = (!Objects.equal(region, null));
          if (_notEquals_1) {
            URI _key = uri2trace.getKey();
            final PsiFile psiFile = this._debugProcessExtensions.getPsiFile(this.process, _key);
            PositionManagerImpl _javaPositionManger = this._debugProcessExtensions.getJavaPositionManger(this.process);
            int _myLineNumber = region.getMyLineNumber();
            int _plus = (_myLineNumber + 1);
            SourcePosition _createFromLine = SourcePosition.createFromLine(psiFile, _plus);
            final List<ReferenceType> classes = _javaPositionManger.getAllClasses(_createFromLine);
            allClasses.addAll(classes);
          }
        }
      }
      return allClasses;
    }
    
    @Override
    public SourcePosition getSourcePosition(final Location location) throws NoDataException {
      int _lineNumber = location.lineNumber();
      final int line = (_lineNumber - 1);
      final PsiFile psiFile = this._debugProcessExtensions.getPsiFile(this.process, location);
      boolean _equals = Objects.equal(psiFile, null);
      if (_equals) {
        throw NoDataException.INSTANCE;
      }
      SourcePosition _createFromLine = SourcePosition.createFromLine(psiFile, line);
      final AbstractTraceRegion trace = this._debugProcessExtensions.getTraceForJava(_createFromLine);
      boolean _equals_1 = Objects.equal(trace, null);
      if (_equals_1) {
        throw NoDataException.INSTANCE;
      }
      final URI sourceURI = this._debugProcessExtensions.findOriginalDeclaration(this.process, location);
      SourcePosition fallBack = null;
      SourcePosition secondaryFallBack = null;
      TreeIterator<AbstractTraceRegion> iter = trace.treeIterator();
      while (iter.hasNext()) {
        {
          final AbstractTraceRegion n = iter.next();
          int _myLineNumber = n.getMyLineNumber();
          boolean _tripleEquals = (_myLineNumber == line);
          if (_tripleEquals) {
            final ILocationData mergedAssociatedLocation = n.getMergedAssociatedLocation();
            boolean _and = false;
            boolean _and_1 = false;
            boolean _isUseForDebugging = n.isUseForDebugging();
            if (!_isUseForDebugging) {
              _and_1 = false;
            } else {
              int _myEndLineNumber = n.getMyEndLineNumber();
              boolean _tripleEquals_1 = (_myEndLineNumber == line);
              _and_1 = _tripleEquals_1;
            }
            if (!_and_1) {
              _and = false;
            } else {
              int _lineNumber_1 = mergedAssociatedLocation.getLineNumber();
              int _endLineNumber = mergedAssociatedLocation.getEndLineNumber();
              boolean _equals_2 = (_lineNumber_1 == _endLineNumber);
              _and = _equals_2;
            }
            if (_and) {
              final PsiFile psi = this._debugProcessExtensions.getPsiFile(this.process, sourceURI);
              int _offset = mergedAssociatedLocation.getOffset();
              return SourcePosition.createFromOffset(psi, _offset);
            } else {
              final PsiFile psi_1 = this._debugProcessExtensions.getPsiFile(this.process, sourceURI);
              int _offset_1 = mergedAssociatedLocation.getOffset();
              SourcePosition _createFromOffset = SourcePosition.createFromOffset(psi_1, _offset_1);
              fallBack = _createFromOffset;
            }
          }
          int _myEndLineNumber_1 = n.getMyEndLineNumber();
          boolean _tripleEquals_2 = (_myEndLineNumber_1 == line);
          if (_tripleEquals_2) {
            final ILocationData mergedAssociatedLocation_1 = n.getMergedAssociatedLocation();
            final PsiFile psi_2 = this._debugProcessExtensions.getPsiFile(this.process, sourceURI);
            int _endLineNumber_1 = mergedAssociatedLocation_1.getEndLineNumber();
            SourcePosition _createFromLine_1 = SourcePosition.createFromLine(psi_2, _endLineNumber_1);
            secondaryFallBack = _createFromLine_1;
          }
        }
      }
      return ObjectExtensions.<SourcePosition>operator_elvis(fallBack, secondaryFallBack);
    }
    
    @Override
    public List<Location> locationsOfLine(final ReferenceType type, final SourcePosition position) throws NoDataException {
      PsiFile _file = position.getFile();
      Language _language = _file.getLanguage();
      boolean _notEquals = (!Objects.equal(_language, this.language));
      if (_notEquals) {
        throw NoDataException.INSTANCE;
      }
      Application _application = ApplicationManager.getApplication();
      final Computable<List<Location>> _function = new Computable<List<Location>>() {
        @Override
        public List<Location> compute() {
          try {
            final PsiElement psi = position.getElementAt();
            Project _project = psi.getProject();
            PsiDocumentManager _instance = PsiDocumentManager.getInstance(_project);
            PsiFile _containingFile = psi.getContainingFile();
            final Document document = _instance.getDocument(_containingFile);
            int _line = position.getLine();
            final TextRange range = DocumentUtil.getLineTextRange(document, _line);
            VirtualFile _virtualFile = PsiUtil.getVirtualFile(psi);
            Project _project_1 = psi.getProject();
            VirtualFileInProject _virtualFileInProject = new VirtualFileInProject(_virtualFile, _project_1);
            final IIdeaTrace traceToTarget = TraceBasedPositionManager.this.traceForVirtualFileProvider.getTraceToTarget(_virtualFileInProject);
            boolean _equals = Objects.equal(traceToTarget, null);
            if (_equals) {
              throw NoDataException.INSTANCE;
            }
            final ArrayList<Location> result = CollectionLiterals.<Location>newArrayList();
            int _startOffset = range.getStartOffset();
            int _length = range.getLength();
            TextRegion _textRegion = new TextRegion(_startOffset, _length);
            Iterable<? extends ILocationInVirtualFile> _allAssociatedLocations = traceToTarget.getAllAssociatedLocations(_textRegion);
            final Function1<ILocationInVirtualFile, Integer> _function = new Function1<ILocationInVirtualFile, Integer>() {
              @Override
              public Integer apply(final ILocationInVirtualFile it) {
                ITextRegionWithLineInformation _textRegion = it.getTextRegion();
                return Integer.valueOf(_textRegion.getLineNumber());
              }
            };
            List<? extends ILocationInVirtualFile> _sortBy = IterableExtensions.sortBy(_allAssociatedLocations, _function);
            for (final ILocationInVirtualFile location : _sortBy) {
              boolean _and = false;
              String _sourceName = type.sourceName();
              SourceRelativeURI _srcRelativeResourceURI = location.getSrcRelativeResourceURI();
              URI _uRI = _srcRelativeResourceURI.getURI();
              String _lastSegment = _uRI.lastSegment();
              String _string = _lastSegment.toString();
              boolean _equals_1 = Objects.equal(_sourceName, _string);
              if (!_equals_1) {
                _and = false;
              } else {
                ITextRegionWithLineInformation _textRegion_1 = location.getTextRegion();
                int _lineNumber = _textRegion_1.getLineNumber();
                ITextRegionWithLineInformation _textRegion_2 = location.getTextRegion();
                int _endLineNumber = _textRegion_2.getEndLineNumber();
                boolean _equals_2 = (_lineNumber == _endLineNumber);
                _and = _equals_2;
              }
              if (_and) {
                ITextRegionWithLineInformation _textRegion_3 = location.getTextRegion();
                int _lineNumber_1 = _textRegion_3.getLineNumber();
                int _plus = (_lineNumber_1 + 1);
                final List<Location> locationsOfLine = type.locationsOfLine(_plus);
                boolean _isEmpty = locationsOfLine.isEmpty();
                boolean _not = (!_isEmpty);
                if (_not) {
                  result.addAll(locationsOfLine);
                  return result;
                }
              }
            }
            throw NoDataException.INSTANCE;
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      return _application.<List<Location>>runReadAction(_function);
    }
  }
  
  private IXtextLanguage language;
  
  public TraceBasedPositionManagerFactory(final IXtextLanguage language) {
    this.language = language;
  }
  
  @Override
  public PositionManager createPositionManager(final DebugProcess process) {
    final TraceBasedPositionManagerFactory.TraceBasedPositionManager manager = new TraceBasedPositionManagerFactory.TraceBasedPositionManager(process, this.language);
    this.language.injectMembers(manager);
    return manager;
  }
}
