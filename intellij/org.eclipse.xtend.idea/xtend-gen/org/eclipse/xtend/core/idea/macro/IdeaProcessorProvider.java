/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.macro;

import com.google.inject.Inject;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class IdeaProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  public Object getProcessorInstance(final JvmType type) {
    try {
      Object _xblockexpression = null;
      {
        Resource _eResource = type.eResource();
        ResourceSet _resourceSet = _eResource.getResourceSet();
        EList<Resource> _resources = _resourceSet.getResources();
        Resource _head = IterableExtensions.<Resource>head(_resources);
        EList<EObject> _contents = _head.getContents();
        EObject _head_1 = IterableExtensions.<EObject>head(_contents);
        final PsiElement psiElement = this._iPsiModelAssociations.getPsiElement(_head_1);
        final Module module = ModuleUtil.findModuleForPsiElement(psiElement);
        OrderEnumerator _orderEntries = OrderEnumerator.orderEntries(module);
        OrderEnumerator _recursively = _orderEntries.recursively();
        final VirtualFile[] roots = _recursively.getClassesRoots();
        final Function1<VirtualFile, URL> _function = new Function1<VirtualFile, URL>() {
          public URL apply(final VirtualFile it) {
            try {
              String _path = it.getPath();
              File _file = new File(_path);
              return _file.toURL();
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        final List<URL> urls = ListExtensions.<VirtualFile, URL>map(((List<VirtualFile>)Conversions.doWrapArray(roots)), _function);
        ClassLoader _classLoader = TransformationContext.class.getClassLoader();
        final URLClassLoader classLoader = new URLClassLoader(((URL[])Conversions.unwrapArray(urls, URL.class)), _classLoader);
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
