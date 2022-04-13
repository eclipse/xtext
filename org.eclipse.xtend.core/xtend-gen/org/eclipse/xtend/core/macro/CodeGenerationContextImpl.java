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

  public Path getProjectFolder(final Path path) {
    return this.getFileLocations().getProjectFolder(path);
  }

  public Set<Path> getProjectSourceFolders(final Path path) {
    return this.getFileLocations().getProjectSourceFolders(path);
  }

  public Path getSourceFolder(final Path path) {
    return this.getFileLocations().getSourceFolder(path);
  }

  public Path getTargetFolder(final Path sourceFolder) {
    return this.getFileLocations().getTargetFolder(sourceFolder);
  }

  public void delete(final Path path) {
    this.getFileSystemSupport().delete(path);
  }

  public boolean exists(final Path path) {
    return this.getFileSystemSupport().exists(path);
  }

  public String getCharset(final Path path) {
    return this.getFileSystemSupport().getCharset(path);
  }

  public Iterable<? extends Path> getChildren(final Path path) {
    return this.getFileSystemSupport().getChildren(path);
  }

  public CharSequence getContents(final Path path) {
    return this.getFileSystemSupport().getContents(path);
  }

  public InputStream getContentsAsStream(final Path path) {
    return this.getFileSystemSupport().getContentsAsStream(path);
  }

  public long getLastModification(final Path path) {
    return this.getFileSystemSupport().getLastModification(path);
  }

  public boolean isFile(final Path path) {
    return this.getFileSystemSupport().isFile(path);
  }

  public boolean isFolder(final Path path) {
    return this.getFileSystemSupport().isFolder(path);
  }

  public void mkdir(final Path path) {
    this.getFileSystemSupport().mkdir(path);
  }

  public void setContents(final Path path, final CharSequence contents) {
    this.getFileSystemSupport().setContents(path, contents);
  }

  public void setContentsAsStream(final Path path, final InputStream source) {
    this.getFileSystemSupport().setContentsAsStream(path, source);
  }

  public URI toURI(final Path path) {
    return this.getFileSystemSupport().toURI(path);
  }

  public Type findTypeGlobally(final Class<?> clazz) {
    return this.getGlobalTypeLookup().findTypeGlobally(clazz);
  }

  public Type findTypeGlobally(final String typeName) {
    return this.getGlobalTypeLookup().findTypeGlobally(typeName);
  }

  public Element getPrimaryGeneratedJavaElement(final Element source) {
    return this.getTracability().getPrimaryGeneratedJavaElement(source);
  }

  public Element getPrimarySourceElement(final Element target) {
    return this.getTracability().getPrimarySourceElement(target);
  }

  public boolean isExternal(final Element element) {
    return this.getTracability().isExternal(element);
  }

  public boolean isGenerated(final Element element) {
    return this.getTracability().isGenerated(element);
  }

  public boolean isSource(final Element element) {
    return this.getTracability().isSource(element);
  }

  public boolean isThePrimaryGeneratedJavaElement(final Element target) {
    return this.getTracability().isThePrimaryGeneratedJavaElement(target);
  }
}
