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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.PerformChangeOperation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IMultiModification;
import org.eclipse.xtext.ui.editor.model.edit.MultiModification;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.refactoring2.ChangeConverter;
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
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
  public void run(final IMarker marker) {
    boolean _exists = marker.exists();
    boolean _not = (!_exists);
    if (_not) {
      return;
    }
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    this.run(new IMarker[] { marker }, _nullProgressMonitor);
  }
  
  @Override
  public void run(final IMarker[] markers, final IProgressMonitor monitor) {
    try {
      new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
          monitor.beginTask("Applying resolutions", ((List<IMarker>)Conversions.doWrapArray(markers)).size());
          final Function1<IMarker, IProject> _function = (IMarker it) -> {
            return it.getResource().getProject();
          };
          final Map<IProject, List<IMarker>> grouped = IterableExtensions.<IProject, IMarker>groupBy(((Iterable<? extends IMarker>)Conversions.doWrapArray(markers)), _function);
          final BiConsumer<IProject, List<Pair<EObject, IssueResolution>>> _function_1 = (IProject proj, List<Pair<EObject, IssueResolution>> resolutions) -> {
            try {
              final ChangeSerializer serializer = WorkbenchMarkerResolutionAdapter.this.serializerProvider.get();
              final ChangeConverter converter = WorkbenchMarkerResolutionAdapter.this.converterFactory.create(WorkbenchMarkerResolutionAdapter.this.primaryResolution.getLabel(), null, WorkbenchMarkerResolutionAdapter.this.issueAcceptor);
              monitor.setTaskName("Applying resolution");
              final Consumer<Pair<EObject, IssueResolution>> _function_2 = (Pair<EObject, IssueResolution> it) -> {
                WorkbenchMarkerResolutionAdapter.this.run(it.getKey(), it.getValue(), serializer, monitor);
              };
              resolutions.forEach(_function_2);
              monitor.internalWorked(1);
              serializer.applyModifications(converter);
              final Change ltkChange = converter.getChange();
              ltkChange.initializeValidationData(monitor);
              new PerformChangeOperation(ltkChange).run(monitor);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          WorkbenchMarkerResolutionAdapter.this.collectResolutions(monitor, grouped).forEach(_function_1);
          monitor.done();
        }
      }.run(monitor);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public LinkedHashMap<IProject, List<Pair<EObject, IssueResolution>>> collectResolutions(final IProgressMonitor monitor, final Map<IProject, List<IMarker>> markersByProject) {
    final LinkedHashMap<IProject, List<Pair<EObject, IssueResolution>>> result = CollectionLiterals.<IProject, List<Pair<EObject, IssueResolution>>>newLinkedHashMap();
    final BiConsumer<IProject, List<IMarker>> _function = (IProject proj, List<IMarker> markers) -> {
      final ResourceSet resSet = this.resSetProvider.get(proj);
      final Function1<IMarker, Pair<EObject, IssueResolution>> _function_1 = (IMarker marker) -> {
        boolean _isCanceled = monitor.isCanceled();
        if (_isCanceled) {
          throw new OperationCanceledException();
        }
        return this.resolution(marker, resSet);
      };
      result.put(proj, IterableExtensions.<Pair<EObject, IssueResolution>>toList(IterableExtensions.<Pair<EObject, IssueResolution>>filterNull(ListExtensions.<IMarker, Pair<EObject, IssueResolution>>map(markers, _function_1))));
    };
    markersByProject.forEach(_function);
    return result;
  }
  
  public Pair<EObject, IssueResolution> resolution(final IMarker marker, final ResourceSet resSet) {
    final URI uri = this.issueUtil.getUriToProblem(marker);
    final Resource resource = resSet.getResource(uri.trimFragment(), true);
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
      }
      IModification _modification = resolution.getModification();
      if ((_modification instanceof MultiModification)) {
        IModification _modification_1 = resolution.getModification();
        ((MultiModification) _modification_1).init(targetObject);
      }
      return Pair.<EObject, IssueResolution>of(targetObject, resolution);
    }
    return null;
  }
  
  @Inject
  private ChangeConverter.Factory converterFactory;
  
  @Inject
  private LtkIssueAcceptor issueAcceptor;
  
  public void run(final EObject targetObject, final IssueResolution resolution, final IChangeSerializer serializer, final IProgressMonitor monitor) {
    IModification _modification = resolution.getModification();
    final IMultiModification modification = ((IMultiModification) _modification);
    if ((modification instanceof MultiModification)) {
      final EObject target = ((MultiModification)modification).getContext().getModificatioTarget();
      final IChangeSerializer.IModification<EObject> _function = (EObject it) -> {
        ((MultiModification)modification).apply(targetObject);
      };
      serializer.<EObject>addModification(target, _function);
    } else {
      final IChangeSerializer.IModification<Resource> _function_1 = (Resource it) -> {
        modification.apply(targetObject);
      };
      serializer.<Resource>addModification(targetObject.eResource(), _function_1);
    }
    String _label = resolution.getLabel();
    String _plus = ("Resolution applied for " + _label);
    String _plus_1 = (_plus + " in ");
    String _plus_2 = (_plus_1 + targetObject);
    WorkbenchMarkerResolutionAdapter.LOG.debug(_plus_2);
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
