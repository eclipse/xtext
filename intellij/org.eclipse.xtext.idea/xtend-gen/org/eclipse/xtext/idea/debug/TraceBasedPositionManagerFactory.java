/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.debug;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
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
import com.intellij.psi.PsiFile;
import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.Location;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.request.ClassPrepareRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.idea.debug.DebugProcessExtensions;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
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
      final Map<URI, AbstractTraceRegion> traces = this._debugProcessExtensions.getTracesForSource(this.process, source);
      final int line = source.getLine();
      final HashSet<String> names = CollectionLiterals.<String>newHashSet();
      Set<Map.Entry<URI, AbstractTraceRegion>> _entrySet = traces.entrySet();
      for (final Map.Entry<URI, AbstractTraceRegion> uri2trace : _entrySet) {
        {
          AbstractTraceRegion _value = uri2trace.getValue();
          TreeIterator<AbstractTraceRegion> _treeIterator = _value.treeIterator();
          final Function1<AbstractTraceRegion, Boolean> _function = new Function1<AbstractTraceRegion, Boolean>() {
            @Override
            public Boolean apply(final AbstractTraceRegion it) {
              ILocationData _mergedAssociatedLocation = it.getMergedAssociatedLocation();
              int _lineNumber = _mergedAssociatedLocation.getLineNumber();
              return Boolean.valueOf((_lineNumber == line));
            }
          };
          final AbstractTraceRegion region = IteratorExtensions.<AbstractTraceRegion>findFirst(_treeIterator, _function);
          boolean _notEquals_1 = (!Objects.equal(region, null));
          if (_notEquals_1) {
            URI _key = uri2trace.getKey();
            String _lastSegment = _key.lastSegment();
            names.add(_lastSegment);
          }
        }
      }
      boolean _isEmpty = names.isEmpty();
      if (_isEmpty) {
        throw NoDataException.INSTANCE;
      }
      RequestManager _requestsManager = this.process.getRequestsManager();
      final ClassPrepareRequestor _function = new ClassPrepareRequestor() {
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
      return _requestsManager.createClassPrepareRequest(_function, "*");
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
      PsiFile _psiFile = this._debugProcessExtensions.getPsiFile(this.process, location);
      SourcePosition _createFromLine = SourcePosition.createFromLine(_psiFile, line);
      final AbstractTraceRegion trace = this._debugProcessExtensions.getTraceForJava(_createFromLine);
      boolean _equals = Objects.equal(trace, null);
      if (_equals) {
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
              boolean _equals_1 = (_lineNumber_1 == _endLineNumber);
              _and = _equals_1;
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
      try {
        PsiFile _file = position.getFile();
        Language _language = _file.getLanguage();
        boolean _notEquals = (!Objects.equal(_language, this.language));
        if (_notEquals) {
          throw NoDataException.INSTANCE;
        }
        final Map<URI, AbstractTraceRegion> traces = this._debugProcessExtensions.getTracesForSource(this.process, position);
        Set<Map.Entry<URI, AbstractTraceRegion>> _entrySet = traces.entrySet();
        for (final Map.Entry<URI, AbstractTraceRegion> entry : _entrySet) {
          URI _key = entry.getKey();
          String _lastSegment = _key.lastSegment();
          String _sourceName = type.sourceName();
          boolean _equals = Objects.equal(_lastSegment, _sourceName);
          if (_equals) {
            AbstractTraceRegion _value = entry.getValue();
            Iterator<AbstractTraceRegion> _leafIterator = _value.leafIterator();
            final Function1<AbstractTraceRegion, Boolean> _function = new Function1<AbstractTraceRegion, Boolean>() {
              @Override
              public Boolean apply(final AbstractTraceRegion it) {
                List<ILocationData> _associatedLocations = it.getAssociatedLocations();
                final Function1<ILocationData, Boolean> _function = new Function1<ILocationData, Boolean>() {
                  @Override
                  public Boolean apply(final ILocationData it) {
                    int _lineNumber = it.getLineNumber();
                    int _line = position.getLine();
                    return Boolean.valueOf((_lineNumber == _line));
                  }
                };
                return Boolean.valueOf(IterableExtensions.<ILocationData>exists(_associatedLocations, _function));
              }
            };
            Iterator<AbstractTraceRegion> _filter = IteratorExtensions.<AbstractTraceRegion>filter(_leafIterator, _function);
            final List<AbstractTraceRegion> allLocations = IteratorExtensions.<AbstractTraceRegion>toList(_filter);
            final Function1<AbstractTraceRegion, List<Location>> _function_1 = new Function1<AbstractTraceRegion, List<Location>>() {
              @Override
              public List<Location> apply(final AbstractTraceRegion it) {
                try {
                  int _myLineNumber = it.getMyLineNumber();
                  int _plus = (_myLineNumber + 1);
                  return type.locationsOfLine(_plus);
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
            List<List<Location>> _map = ListExtensions.<AbstractTraceRegion, List<Location>>map(allLocations, _function_1);
            Iterable<Location> _flatten = Iterables.<Location>concat(_map);
            Set<Location> _set = IterableExtensions.<Location>toSet(_flatten);
            final List<Location> locations = IterableExtensions.<Location>toList(_set);
            return locations;
          }
        }
        throw NoDataException.INSTANCE;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
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
