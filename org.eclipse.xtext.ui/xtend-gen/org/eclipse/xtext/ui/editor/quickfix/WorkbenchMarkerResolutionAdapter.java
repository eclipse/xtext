/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.quickfix;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ui.editor.model.edit.BatchModification;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.util.IssueUtil;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * MarkerResolution which extends WorkbenchMarkerResolution and can be applied on multiple markers.
 * 
 * @author dhuebner - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class WorkbenchMarkerResolutionAdapter extends WorkbenchMarkerResolution {
  public static class Factory {
    @Inject
    private Provider<WorkbenchMarkerResolutionAdapter> provider;
    
    public IMarkerResolution create(final IMarker marker, final IssueResolution resolution) {
      final WorkbenchMarkerResolutionAdapter resolutionFix = this.provider.get();
      resolutionFix.primaryResolution = resolution;
      resolutionFix.primaryMarker = marker;
      return resolutionFix;
    }
  }
  
  @Inject
  private MarkerResolutionGenerator resolutionsGenerator;
  
  @Inject
  private IssueUtil issueUtil;
  
  @Inject
  private Provider<BatchModification> batchModificationProvider;
  
  private static final Logger LOG = Logger.getLogger(WorkbenchMarkerResolutionAdapter.class);
  
  @Accessors
  private IssueResolution primaryResolution;
  
  @Accessors
  private IMarker primaryMarker;
  
  @Override
  public IMarker[] findOtherMarkers(final IMarker[] markers) {
    final Function1<IMarker, Boolean> _function = (IMarker it) -> {
      return Boolean.valueOf(((!Objects.equal(it, this.primaryMarker)) && Objects.equal(this.issueUtil.getCode(this.primaryMarker), this.issueUtil.getCode(it))));
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
  public void run(final IMarker[] markers, final IProgressMonitor progressMonitor) {
    final Function1<IMarker, IProject> _function = (IMarker it) -> {
      return it.getResource().getProject();
    };
    final Map<IProject, List<IMarker>> markersByProject = IterableExtensions.<IProject, IMarker>groupBy(((Iterable<? extends IMarker>)Conversions.doWrapArray(markers)), _function);
    final SubMonitor monitor = SubMonitor.convert(progressMonitor);
    monitor.beginTask("Applying resolutions", markersByProject.size());
    Set<Map.Entry<IProject, List<IMarker>>> _entrySet = markersByProject.entrySet();
    for (final Map.Entry<IProject, List<IMarker>> g : _entrySet) {
      {
        final BatchModification batch = this.batchModificationProvider.get();
        batch.setProject(g.getKey());
        final List<IMarker> markersInProject = g.getValue();
        final Function1<IMarker, IssueResolution> _function_1 = (IMarker it) -> {
          return this.resolution(it);
        };
        final List<IssueResolution> resolutions = IterableExtensions.<IssueResolution>toList(IterableExtensions.<IssueResolution>filterNull(ListExtensions.<IMarker, IssueResolution>map(markersInProject, _function_1)));
        this.cancelIfNeeded(monitor);
        final Function1<IssueResolution, IModification> _function_2 = (IssueResolution it) -> {
          return it.getModification();
        };
        final Iterable<BatchModification.IBatchableModification> modifications = Iterables.<BatchModification.IBatchableModification>filter(ListExtensions.<IssueResolution, IModification>map(resolutions, _function_2), BatchModification.IBatchableModification.class);
        this.cancelIfNeeded(monitor);
        batch.apply(modifications, monitor.newChild(1));
        this.cancelIfNeeded(monitor);
      }
    }
    monitor.done();
  }
  
  protected void cancelIfNeeded(final IProgressMonitor monitor) {
    boolean _isCanceled = monitor.isCanceled();
    if (_isCanceled) {
      throw new OperationCanceledException();
    }
  }
  
  public IssueResolution resolution(final IMarker marker) {
    boolean _exists = marker.exists();
    boolean _not = (!_exists);
    if (_not) {
      return null;
    }
    final Issue issue = this.issueUtil.createIssue(marker);
    final List<IssueResolution> resolutions = this.resolutionsGenerator.getResolutionProvider().getResolutions(issue);
    final Function1<IssueResolution, Boolean> _function = (IssueResolution it) -> {
      return Boolean.valueOf(this.isSameResolution(it, this.primaryResolution));
    };
    final IssueResolution resolution = IterableExtensions.<IssueResolution>head(IterableExtensions.<IssueResolution>filter(resolutions, _function));
    if ((resolution == null)) {
      String _code = issue.getCode();
      String _plus = ("Resolution missing for " + _code);
      WorkbenchMarkerResolutionAdapter.LOG.warn(_plus);
    }
    return resolution;
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
