/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.psi.XtextPsiUtils;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaClasspathURIResolver implements IClasspathUriResolver {
  @Override
  public URI resolve(final Object context, final URI classpathUri) {
    if ((!(context instanceof Module))) {
      throw new IllegalArgumentException(("Expected a module as context but got " + context));
    }
    boolean _isClasspathUri = ClasspathUriUtil.isClasspathUri(classpathUri);
    boolean _not = (!_isClasspathUri);
    if (_not) {
      return classpathUri;
    }
    final Module module = ((Module) context);
    final GlobalSearchScope scope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module);
    Application _application = ApplicationManager.getApplication();
    final Function1<Object, URI> _function = new Function1<Object, URI>() {
      @Override
      public URI apply(final Object it) {
        Project _project = module.getProject();
        String _lastSegment = classpathUri.lastSegment();
        final PsiFile[] files = FilenameIndex.getFilesByName(_project, _lastSegment, scope);
        for (final PsiFile file : files) {
          {
            final VirtualFile vf = XtextPsiUtils.findVirtualFile(file);
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(vf, null));
            if (!_notEquals) {
              _and = false;
            } else {
              boolean _exists = vf.exists();
              _and = _exists;
            }
            if (_and) {
              final URI uri = VirtualFileURIUtil.getURI(vf);
              String _string = uri.toString();
              String _path = classpathUri.path();
              boolean _endsWith = _string.endsWith(_path);
              if (_endsWith) {
                return uri;
              }
            }
          }
        }
        return null;
      }
    };
    final URI uri = _application.<URI>runReadAction(
      ((Computable<URI>) new Computable<URI>() {
          public URI compute() {
            return _function.apply(null);
          }
      }));
    URI _elvis = null;
    if (uri != null) {
      _elvis = uri;
    } else {
      _elvis = classpathUri;
    }
    return _elvis;
  }
}
