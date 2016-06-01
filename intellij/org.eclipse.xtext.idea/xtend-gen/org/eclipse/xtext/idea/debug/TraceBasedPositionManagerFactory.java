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
import com.intellij.lang.Language;
import com.intellij.psi.PsiFile;
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
import org.eclipse.xtext.idea.debug.DebugProcessExtensions;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

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
    private ITraceForVirtualFileProvider traceForVirtualFileProvider;
    
    public TraceBasedPositionManager(final DebugProcess process, final IXtextLanguage language) {
      this.process = process;
      this.language = language;
    }
    
    /**
     * This one is called
     */
    @Override
    public ClassPrepareRequest createPrepareRequest(final ClassPrepareRequestor requestor, final SourcePosition source) throws NoDataException {
      throw new Error("Unresolved compilation problems:"
        + "\nAccess restriction: The type AbsentInformationException is not accessible due to restriction on required project org.eclipse.xtext.idea");
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
            if (((n.isUseForDebugging() && (n.getMyEndLineNumber() == line)) && (mergedAssociatedLocation.getLineNumber() == mergedAssociatedLocation.getEndLineNumber()))) {
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
          int _myEndLineNumber = n.getMyEndLineNumber();
          boolean _tripleEquals_1 = (_myEndLineNumber == line);
          if (_tripleEquals_1) {
            final ILocationData mergedAssociatedLocation_1 = n.getMergedAssociatedLocation();
            final PsiFile psi_2 = this._debugProcessExtensions.getPsiFile(this.process, sourceURI);
            int _endLineNumber = mergedAssociatedLocation_1.getEndLineNumber();
            SourcePosition _createFromLine_1 = SourcePosition.createFromLine(psi_2, _endLineNumber);
            secondaryFallBack = _createFromLine_1;
          }
        }
      }
      SourcePosition _elvis = null;
      if (fallBack != null) {
        _elvis = fallBack;
      } else {
        _elvis = secondaryFallBack;
      }
      return _elvis;
    }
    
    @Override
    public List<Location> locationsOfLine(final ReferenceType type, final SourcePosition position) throws NoDataException {
      throw new Error("Unresolved compilation problems:"
        + "\nAccess restriction: The type Location is not accessible due to restriction on required project org.eclipse.xtext.idea");
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
