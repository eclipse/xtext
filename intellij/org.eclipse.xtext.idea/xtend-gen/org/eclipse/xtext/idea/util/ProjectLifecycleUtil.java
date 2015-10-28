/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.util;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupManager;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ProjectLifecycleUtil {
  /**
   * Executes Runnable when project is fully initialized and the Index is ready (SmartMode).<br>
   * Runnable will be executed immediately when project in in initialized smart mode.
   */
  public void executeWhenProjectReady(final Project project, final Runnable fun) {
    boolean _isInitialized = project.isInitialized();
    if (_isInitialized) {
      DumbService _instance = DumbService.getInstance(project);
      boolean _isDumb = _instance.isDumb();
      if (_isDumb) {
        DumbService _instance_1 = DumbService.getInstance(project);
        _instance_1.runWhenSmart(fun);
      } else {
        fun.run();
      }
    } else {
      StartupManager _instance_2 = StartupManager.getInstance(project);
      _instance_2.registerPostStartupActivity(fun);
    }
  }
  
  /**
   * @returns <code>true</code> when  project is fully initialized and the Index is ready (SmartMode).<br>
   */
  public boolean isProjectReadyForPsiAccess(final Project project) {
    boolean _and = false;
    boolean _isInitialized = project.isInitialized();
    if (!_isInitialized) {
      _and = false;
    } else {
      DumbService _instance = DumbService.getInstance(project);
      boolean _isDumb = _instance.isDumb();
      boolean _not = (!_isDumb);
      _and = _not;
    }
    return _and;
  }
  
  /**
   * Executes Runnable with write access, when project is fully initialized and the Index is ready (SmartMode).<br>
   * Runnable will be executed immediately when project in in initialized smart mode.
   */
  public void executeWritableWhenProjectReady(final Project project, final Runnable runnable) {
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        Application _application = ApplicationManager.getApplication();
        _application.runWriteAction(runnable);
      }
    };
    this.executeWhenProjectReady(project, _function);
  }
}
