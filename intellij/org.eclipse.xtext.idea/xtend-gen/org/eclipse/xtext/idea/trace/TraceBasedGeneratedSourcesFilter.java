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
import com.intellij.ide.DataManager;
import com.intellij.ide.projectView.impl.ProjectViewPane;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.GeneratedSourcesFilter;
import com.intellij.openapi.util.AsyncResult;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import java.util.List;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.VirtualFileInProject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceBasedGeneratedSourcesFilter extends GeneratedSourcesFilter {
  @Inject
  private ITraceForVirtualFileProvider traceProvider;
  
  public TraceBasedGeneratedSourcesFilter() {
    IdeaSharedInjectorProvider.injectMembers(this);
  }
  
  @Override
  public boolean isGeneratedSource(final VirtualFile file, final Project project) {
    VirtualFileInProject _virtualFileInProject = new VirtualFileInProject(file, project);
    return this.traceProvider.isGenerated(_virtualFileInProject);
  }
  
  @Override
  public List<? extends PsiElement> getOriginalElements(final PsiElement element) {
    Application _application = ApplicationManager.getApplication();
    boolean _isDispatchThread = _application.isDispatchThread();
    if (_isDispatchThread) {
      DataManager _instance = DataManager.getInstance();
      AsyncResult<DataContext> _dataContextFromFocus = _instance.getDataContextFromFocus();
      final DataContext ctx = _dataContextFromFocus.getResult();
      String _name = PlatformDataKeys.CONTEXT_COMPONENT.getName();
      final Object focus = ctx.getData(_name);
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(focus, null));
      if (!_notEquals) {
        _and = false;
      } else {
        Class<?> _class = focus.getClass();
        String _name_1 = _class.getName();
        String _name_2 = ProjectViewPane.class.getName();
        boolean _startsWith = _name_1.startsWith(_name_2);
        _and = _startsWith;
      }
      if (_and) {
        return CollectionLiterals.<PsiElement>emptyList();
      }
    }
    return this.traceProvider.getOriginalElements(element);
  }
  
  public List<? extends PsiElement> getGeneratedElements(final PsiElement element) {
    return this.traceProvider.getGeneratedElements(element);
  }
}
