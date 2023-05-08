/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import java.io.InputStream;
import java.net.URI;
import java.util.Set;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend.lib.macro.services.GlobalTypeLookup;
import org.eclipse.xtend.lib.macro.services.Tracability;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodeGenerationContextImpl implements CodeGenerationContext {
  @Accessors
  private CompilationUnitImpl unit;

  @Delegate
  public FileLocations getFileLocations() {
    return this.unit.getFileLocations();
  }

  @Delegate
  public MutableFileSystemSupport getFileSystemSupport() {
    return this.unit.getFileSystemSupport();
  }

  @Delegate
  public GlobalTypeLookup getGlobalTypeLookup() {
    return this.unit.getTypeLookup();
  }

  @Delegate
  public Tracability getTracability() {
    return this.unit.getTracability();
  }

  @Pure
  public CompilationUnitImpl getUnit() {
    return this.unit;
  }

  public void setUnit(final CompilationUnitImpl unit) {
    this.unit = unit;
  }

  public Path getProjectFolder(final Path arg0) {
    return this.getFileLocations().getProjectFolder(arg0);
  }

  public Set<Path> getProjectSourceFolders(final Path arg0) {
    return this.getFileLocations().getProjectSourceFolders(arg0);
  }

  public Path getSourceFolder(final Path arg0) {
    return this.getFileLocations().getSourceFolder(arg0);
  }

  public Path getTargetFolder(final Path arg0) {
    return this.getFileLocations().getTargetFolder(arg0);
  }

  public void delete(final Path arg0) {
    this.getFileSystemSupport().delete(arg0);
  }

  public boolean exists(final Path arg0) {
    return this.getFileSystemSupport().exists(arg0);
  }

  public String getCharset(final Path arg0) {
    return this.getFileSystemSupport().getCharset(arg0);
  }

  public Iterable<? extends Path> getChildren(final Path arg0) {
    return this.getFileSystemSupport().getChildren(arg0);
  }

  public CharSequence getContents(final Path arg0) {
    return this.getFileSystemSupport().getContents(arg0);
  }

  public InputStream getContentsAsStream(final Path arg0) {
    return this.getFileSystemSupport().getContentsAsStream(arg0);
  }

  public long getLastModification(final Path arg0) {
    return this.getFileSystemSupport().getLastModification(arg0);
  }

  public boolean isFile(final Path arg0) {
    return this.getFileSystemSupport().isFile(arg0);
  }

  public boolean isFolder(final Path arg0) {
    return this.getFileSystemSupport().isFolder(arg0);
  }

  public void mkdir(final Path arg0) {
    this.getFileSystemSupport().mkdir(arg0);
  }

  public void setContents(final Path arg0, final CharSequence arg1) {
    this.getFileSystemSupport().setContents(arg0, arg1);
  }

  public void setContentsAsStream(final Path arg0, final InputStream arg1) {
    this.getFileSystemSupport().setContentsAsStream(arg0, arg1);
  }

  public URI toURI(final Path arg0) {
    return this.getFileSystemSupport().toURI(arg0);
  }

  public Type findTypeGlobally(final Class<?> arg0) {
    return this.getGlobalTypeLookup().findTypeGlobally(arg0);
  }

  public Type findTypeGlobally(final String arg0) {
    return this.getGlobalTypeLookup().findTypeGlobally(arg0);
  }

  public Element getPrimaryGeneratedJavaElement(final Element arg0) {
    return this.getTracability().getPrimaryGeneratedJavaElement(arg0);
  }

  public Element getPrimarySourceElement(final Element arg0) {
    return this.getTracability().getPrimarySourceElement(arg0);
  }

  public boolean isExternal(final Element arg0) {
    return this.getTracability().isExternal(arg0);
  }

  public boolean isGenerated(final Element arg0) {
    return this.getTracability().isGenerated(arg0);
  }

  public boolean isSource(final Element arg0) {
    return this.getTracability().isSource(arg0);
  }

  public boolean isThePrimaryGeneratedJavaElement(final Element arg0) {
    return this.getTracability().isThePrimaryGeneratedJavaElement(arg0);
  }
}
