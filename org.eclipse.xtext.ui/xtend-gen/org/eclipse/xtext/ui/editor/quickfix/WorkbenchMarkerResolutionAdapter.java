/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.quickfix;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ui.editor.model.edit.IContextFreeModification;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.refactoring2.ChangeConverter;
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * MarkerResolution which extends WorkbenchMarkerResolution and can be applied on multiple markers.
 * 
 * @author dhuebner - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class WorkbenchMarkerResolutionAdapter extends WorkbenchMarkerResolution {
  @Inject
  private MarkerResolutionGenerator resolutionsGenerator;
  
  @Inject
  private IssueUtil issueUtil;
  
  @Inject
  private IResourceSetProvider resSetProvider;
  
  @Inject
  private Provider<ChangeSerializer> serializerProvider;
  
  private final static Logger LOG = Logger.getLogger(WorkbenchMarkerResolutionAdapter.class);
  
  @Accessors
  private IssueResolution primaryResolution;
  
  @Accessors
  private IMarker primaryMarker;
  
  @Override
  public IMarker[] findOtherMarkers(final IMarker[] markers) {
    final Function1<IMarker, Boolean> _function = (IMarker it) -> {
      String _code = this.issueUtil.getCode(this.primaryMarker);
      String _code_1 = this.issueUtil.getCode(it);
      return Boolean.valueOf(Objects.equal(_code, _code_1));
    };
    return ((IMarker[])Conversions.unwrapArray(IterableExtensions.<IMarker>filter(((Iterable<IMarker>)Conversions.doWrapArray(markers)), _function), IMarker.class));
  }
  
  @Override
  public String getLabel() {
    return this.primaryResolution.getLabel();
  }
  
  @Override
  public void run(final IMarker[] markers, final IProgressMonitor monitor) {
    try {
      new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
          monitor.beginTask("Applying resolutions", ((List<IMarker>)Conversions.doWrapArray(markers)).size());
          final Consumer<IMarker> _function = (IMarker it) -> {
            String _name = it.getResource().getName();
            String _plus = ("Applying resolution for: " + _name);
            monitor.setTaskName(_plus);
            WorkbenchMarkerResolutionAdapter.this.run(it, monitor);
            monitor.internalWorked(1);
          };
          ((List<IMarker>)Conversions.doWrapArray(markers)).forEach(_function);
          monitor.done();
        }
      }.run(monitor);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Inject
  private ChangeConverter.Factory converterFactory;
  
  @Inject
  private LtkIssueAcceptor issueAcceptor;
  
  @Override
  public void run(final IMarker marker) {
    boolean _exists = marker.exists();
    boolean _not = (!_exists);
    if (_not) {
      return;
    }
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    this.run(marker, _nullProgressMonitor);
  }
  
  public void run(final IMarker marker, final IProgressMonitor monitor) {
    try {
      final URI uri = this.issueUtil.getUriToProblem(marker);
      final Resource resource = this.resSetProvider.get(marker.getResource().getProject()).getResource(uri.trimFragment(), true);
      final EObject targetObject = resource.getEObject(uri.fragment());
      if ((targetObject != null)) {
        final Issue issue = this.issueUtil.createIssue(marker);
        final Function1<IssueResolution, Boolean> _function = (IssueResolution it) -> {
          return Boolean.valueOf(this.isSameResolution(it, this.primaryResolution));
        };
        final IssueResolution resolution = IterableExtensions.<IssueResolution>head(IterableExtensions.<IssueResolution>filter(this.resolutionsGenerator.getResolutionProvider().getResolutions(issue), _function));
        if ((resolution == null)) {
          String _code = issue.getCode();
          String _plus = ("Resolution missing for " + _code);
          WorkbenchMarkerResolutionAdapter.LOG.warn(_plus);
          return;
        }
        final ChangeSerializer serializer = this.serializerProvider.get();
        final ChangeConverter converter = this.converterFactory.create(issue.getCode(), null, this.issueAcceptor);
        final IChangeSerializer.IModification<EObject> _function_1 = (EObject it) -> {
          IModification _modification = resolution.getModification();
          ((IContextFreeModification.Wrapper) _modification).apply(targetObject);
        };
        serializer.<EObject>addModification(targetObject, _function_1);
        serializer.applyModifications(converter);
        final Change ltkChange = converter.getChange();
        ltkChange.initializeValidationData(monitor);
        new PerformChangeOperation(ltkChange).run(monitor);
        String _code_1 = issue.getCode();
        String _plus_1 = ("Resolution applied for " + _code_1);
        String _plus_2 = (_plus_1 + " in ");
        URI _uriToProblem = issue.getUriToProblem();
        String _plus_3 = (_plus_2 + _uriToProblem);
        WorkbenchMarkerResolutionAdapter.LOG.debug(_plus_3);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public String getDescription() {
    return this.primaryResolution.getDescription();
  }
  
  @Override
  public Image getImage() {
    return this.resolutionsGenerator.getImage(this.primaryResolution);
  }
  
  private boolean isSameResolution(final IssueResolution it, final IssueResolution other) {
    return (((((it != null) && (other != null)) && Objects.equal(it.getDescription(), other.getDescription())) && Objects.equal(it.getLabel(), other.getLabel())) && 
      Objects.equal(it.getImage(), other.getImage()));
  }
  
  @Pure
  public IssueResolution getPrimaryResolution() {
    return this.primaryResolution;
  }
  
  public void setPrimaryResolution(final IssueResolution primaryResolution) {
    this.primaryResolution = primaryResolution;
  }
  
  @Pure
  public IMarker getPrimaryMarker() {
    return this.primaryMarker;
  }
  
  public void setPrimaryMarker(final IMarker primaryMarker) {
    this.primaryMarker = primaryMarker;
  }
}
