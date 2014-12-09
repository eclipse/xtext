/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.macro;

import com.google.inject.Inject;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class IdeaProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  public Object getProcessorInstance(final JvmType type) {
    try {
      Object _xblockexpression = null;
      {
        PsiElement _psiElement = this._iPsiModelAssociations.getPsiElement(type);
        final PsiFile file = _psiElement.getContainingFile();
        PsiElement _psiElement_1 = this._iPsiModelAssociations.getPsiElement(type);
        final Project project = _psiElement_1.getProject();
        ProjectRootManager _instance = ProjectRootManager.getInstance(project);
        ProjectFileIndex _fileIndex = _instance.getFileIndex();
        VirtualFile _virtualFile = file.getVirtualFile();
        VirtualFile _classRootForFile = _fileIndex.getClassRootForFile(_virtualFile);
        final String path = _classRootForFile.getPath();
        File _file = new File(path);
        final URL url = _file.toURL();
        ClassLoader _classLoader = TransformationContext.class.getClassLoader();
        final URLClassLoader classLoader = new URLClassLoader(new URL[] { url }, _classLoader);
        String _identifier = type.getIdentifier();
        Class<?> _loadClass = classLoader.loadClass(_identifier);
        _xblockexpression = _loadClass.newInstance();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
