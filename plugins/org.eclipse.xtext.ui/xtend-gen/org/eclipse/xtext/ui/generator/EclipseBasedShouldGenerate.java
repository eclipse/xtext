/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.generator;

import com.google.common.base.Objects;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IShouldGenerate;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class EclipseBasedShouldGenerate implements IShouldGenerate {
  @Override
  public boolean shouldGenerate(final Resource resource, final String projectName, final CancelIndicator cancelIndicator) {
    try {
      final URI uri = resource.getURI();
      boolean _or = false;
      if ((uri == null)) {
        _or = true;
      } else {
        boolean _isPlatformResource = uri.isPlatformResource();
        boolean _not = (!_isPlatformResource);
        _or = _not;
      }
      if (_or) {
        return false;
      }
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      String _platformString = uri.toPlatformString(true);
      Path _path = new Path(_platformString);
      final IResource member = _root.findMember(_path);
      boolean _and = false;
      boolean _and_1 = false;
      if (!(member != null)) {
        _and_1 = false;
      } else {
        int _type = member.getType();
        boolean _tripleEquals = (_type == IResource.FILE);
        _and_1 = _tripleEquals;
      }
      if (!_and_1) {
        _and = false;
      } else {
        IProject _project = member.getProject();
        String _name = _project.getName();
        boolean _equals = Objects.equal(_name, projectName);
        _and = _equals;
      }
      if (_and) {
        int _findMaxProblemSeverity = member.findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE);
        return (_findMaxProblemSeverity != IMarker.SEVERITY_ERROR);
      }
      return false;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
