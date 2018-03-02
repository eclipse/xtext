/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.refactoring2.TryWithResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class ReplaceFileContentChange extends ResourceChange {
  private final IFile file;
  
  private final byte[] newContents;
  
  @Accessors
  private String name;
  
  public ReplaceFileContentChange(final String name, final IFile file, final byte[] newContents) {
    this(file, newContents);
    this.name = name;
  }
  
  @Override
  protected IResource getModifiedResource() {
    return this.file;
  }
  
  @Override
  public RefactoringStatus isValid(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    final RefactoringStatus result = new RefactoringStatus();
    boolean _exists = this.file.exists();
    boolean _not = (!_exists);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("File \'");
      IPath _fullPath = this.file.getFullPath();
      _builder.append(_fullPath);
      _builder.append("\' does not exist");
      result.addFatalError(_builder.toString());
    }
    return result;
  }
  
  @Override
  public Change perform(final IProgressMonitor pm) throws CoreException {
    ReplaceFileContentChange _xblockexpression = null;
    {
      final byte[] oldContents = this.getOldContents();
      final ByteArrayInputStream newContentsIS = new ByteArrayInputStream(this.newContents);
      final Function0<ReplaceFileContentChange> _function = () -> {
        try {
          this.file.setContents(newContentsIS, true, true, pm);
          return new ReplaceFileContentChange(this.file, oldContents);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      _xblockexpression = TryWithResource.<ReplaceFileContentChange>tryWith(newContentsIS, _function);
    }
    return _xblockexpression;
  }
  
  protected byte[] getOldContents() {
    byte[] _xblockexpression = null;
    {
      final ByteArrayOutputStream oldContentsBAOS = new ByteArrayOutputStream();
      final Function0<byte[]> _function = () -> {
        try {
          byte[] _xblockexpression_1 = null;
          {
            final InputStream oldContentsIS = this.file.getContents();
            final Function0<byte[]> _function_1 = () -> {
              try {
                int readBytes = 0;
                final byte[] buffer = new byte[4096];
                while (((readBytes = oldContentsIS.read(buffer)) != (-1))) {
                  oldContentsBAOS.write(buffer, 0, readBytes);
                }
                return oldContentsBAOS.toByteArray();
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            };
            _xblockexpression_1 = TryWithResource.<byte[]>tryWith(oldContentsIS, _function_1);
          }
          return _xblockexpression_1;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      _xblockexpression = TryWithResource.<byte[]>tryWith(oldContentsBAOS, _function);
    }
    return _xblockexpression;
  }
  
  public ReplaceFileContentChange(final IFile file, final byte[] newContents) {
    super();
    this.file = file;
    this.newContents = newContents;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
}
