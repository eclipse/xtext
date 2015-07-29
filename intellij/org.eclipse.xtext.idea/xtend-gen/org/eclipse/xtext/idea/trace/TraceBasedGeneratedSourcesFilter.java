/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.trace;

import com.google.inject.Inject;
import com.intellij.ide.projectView.impl.ProjectViewPane;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.GeneratedSourcesFilter;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import java.util.List;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.VirtualFileInProject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
    Thread _currentThread = Thread.currentThread();
    final StackTraceElement[] currentStack = _currentThread.getStackTrace();
    List<StackTraceElement> _subList = ((List<StackTraceElement>)Conversions.doWrapArray(currentStack)).subList(15, 20);
    final Function1<StackTraceElement, Boolean> _function = new Function1<StackTraceElement, Boolean>() {
      @Override
      public Boolean apply(final StackTraceElement frame) {
        String _className = frame.getClassName();
        String _name = ProjectViewPane.class.getName();
        return Boolean.valueOf(_className.startsWith(_name));
      }
    };
    boolean _exists = IterableExtensions.<StackTraceElement>exists(_subList, _function);
    if (_exists) {
      return CollectionLiterals.<PsiElement>emptyList();
    }
    return this.traceProvider.getOriginalElements(element);
  }
  
  public List<? extends PsiElement> getGeneratedElements(final PsiElement element) {
    return this.traceProvider.getGeneratedElements(element);
  }
}
