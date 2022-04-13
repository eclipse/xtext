/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.debug;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccessExtension;
import org.eclipse.xtext.generator.IFileSystemAccessExtension2;

@SuppressWarnings("all")
public class TraceRegionFSAForTest implements IFileSystemAccessExtension2, IFileSystemAccessExtension, IFileSystemAccess {
  @Override
  public URI getURI(final String fileName, final String outputConfiguration) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }

  @Override
  public URI getURI(final String fileName) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }

  @Override
  public void deleteFile(final String fileName, final String outputConfigurationName) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }

  @Override
  public void deleteFile(final String fileName) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }

  @Override
  public void generateFile(final String fileName, final CharSequence contents) {
    this.charSequence = contents;
  }

  @Override
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    throw new UnsupportedOperationException("Auto-generated function stub");
  }

  public CharSequence charSequence;
}
