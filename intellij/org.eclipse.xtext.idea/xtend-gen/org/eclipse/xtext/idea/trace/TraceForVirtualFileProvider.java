/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.trace;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.internal.AbstractTraceForURIProvider;
import org.eclipse.xtext.idea.trace.IIdeaTrace;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.VirtualFileBasedTrace;
import org.eclipse.xtext.workspace.IProjectConfig;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceForVirtualFileProvider extends AbstractTraceForURIProvider<VirtualFile, VirtualFileBasedTrace> implements ITraceForVirtualFileProvider {
  @Override
  protected VirtualFile asFile(final AbsoluteURI absoluteURI) {
    VirtualFileManager _instance = VirtualFileManager.getInstance();
    URI _uRI = absoluteURI.getURI();
    String _string = _uRI.toString();
    return _instance.findFileByUrl(_string);
  }
  
  @Override
  protected List<AbstractTraceForURIProvider.PersistedTrace> findInverseTraceFiles(final VirtualFile sourceFile) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  protected AbstractTraceForURIProvider.PersistedTrace findPersistedTrace(final VirtualFile generatedFile) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  protected AbsoluteURI getAbsoluteLocation(final VirtualFile file) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  protected IProjectConfig getProjectConfig(final VirtualFile sourceFile) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  protected VirtualFileBasedTrace newAbstractTrace(final VirtualFile file) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IIdeaTrace getTraceToTarget(final VirtualFile sourceResource) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
