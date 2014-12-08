/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng.debug;

import com.google.common.base.Objects;
import java.util.IdentityHashMap;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.builder.ng.debug.JobInfo;
import org.eclipse.xtext.builder.ng.debug.XtextCompilerConsole;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class JobConsoleLogger implements IJobChangeListener {
  private final IdentityHashMap<Job, JobInfo> jobs = new IdentityHashMap<Job, JobInfo>();
  
  public JobConsoleLogger() {
    IJobManager _jobManager = Job.getJobManager();
    _jobManager.addJobChangeListener(this);
  }
  
  private boolean isInteresting(final Job job) {
    boolean _or = false;
    boolean _belongsTo = job.belongsTo(ResourcesPlugin.FAMILY_AUTO_BUILD);
    if (_belongsTo) {
      _or = true;
    } else {
      boolean _belongsTo_1 = job.belongsTo(ResourcesPlugin.FAMILY_MANUAL_BUILD);
      _or = _belongsTo_1;
    }
    return _or;
  }
  
  private void log(final String eventName, final IJobChangeEvent event) {
    final Job job = event.getJob();
    boolean _isInteresting = this.isInteresting(job);
    boolean _not = (!_isInteresting);
    if (_not) {
      return;
    }
    final JobInfo current = new JobInfo(job);
    final JobInfo old = this.jobs.get(job);
    this.jobs.put(job, current);
    String _xifexpression = null;
    boolean _notEquals = (!Objects.equal(old, null));
    if (_notEquals) {
      _xifexpression = old.compareWithNew(current);
    } else {
      _xifexpression = current.toString();
    }
    final String msg = _xifexpression;
    XtextCompilerConsole.log(("Job: " + msg));
  }
  
  public void aboutToRun(final IJobChangeEvent event) {
    this.log("aboutToRun", event);
  }
  
  public void awake(final IJobChangeEvent event) {
    this.log("awake", event);
  }
  
  public void done(final IJobChangeEvent event) {
    this.log("done", event);
  }
  
  public void running(final IJobChangeEvent event) {
    this.log("running", event);
  }
  
  public void scheduled(final IJobChangeEvent event) {
    this.log("scheduled", event);
  }
  
  public void sleeping(final IJobChangeEvent event) {
    this.log("sleeping", event);
  }
}
