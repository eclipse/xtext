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
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableElement;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.FileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceProvider;
import org.eclipse.xtend.lib.macro.services.Associator;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtend.lib.macro.services.ProblemSupport;
import org.eclipse.xtend.lib.macro.services.Tracability;
import org.eclipse.xtend.lib.macro.services.TypeLookup;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class TransformationContextImpl implements TransformationContext {
  @Accessors
  private CompilationUnitImpl unit;

  @Delegate
  public ProblemSupport getProblemSupport() {
    return this.unit.getProblemSupport();
  }

  @Delegate
  public TypeLookup getTypeLookup() {
    return this.unit.getTypeLookup();
  }

  @Delegate
  public TypeReferenceProvider getTypeReferenceProvider() {
    return this.unit.getTypeReferenceProvider();
  }

  @Delegate
  public AnnotationReferenceProvider getAnnotationReferenceProvider() {
    return this.unit.getAnnotationReferenceProvider();
  }

  @Delegate
  public FileSystemSupport getFileSystemSupport() {
    return this.unit.getFileSystemSupport();
  }

  @Delegate
  public FileLocations getFileLocations() {
    return this.unit.getFileLocations();
  }

  @Delegate
  public Tracability getTracability() {
    return this.unit.getTracability();
  }

  @Delegate
  public Associator getAssociator() {
    return this.unit.getAssociator();
  }

  @Pure
  public CompilationUnitImpl getUnit() {
    return this.unit;
  }

  public void setUnit(final CompilationUnitImpl unit) {
    this.unit = unit;
  }

  public void addError(final Element arg0, final String arg1) {
    this.getProblemSupport().addError(arg0, arg1);
  }

  public void addWarning(final Element arg0, final String arg1) {
    this.getProblemSupport().addWarning(arg0, arg1);
  }

  public List<? extends Problem> getProblems(final Element arg0) {
    return this.getProblemSupport().getProblems(arg0);
  }

  public void validateLater(final Procedure0 arg0) {
    this.getProblemSupport().validateLater(arg0);
  }

  public MutableAnnotationTypeDeclaration findAnnotationType(final String arg0) {
    return this.getTypeLookup().findAnnotationType(arg0);
  }

  public MutableClassDeclaration findClass(final String arg0) {
    return this.getTypeLookup().findClass(arg0);
  }

  public MutableEnumerationTypeDeclaration findEnumerationType(final String arg0) {
    return this.getTypeLookup().findEnumerationType(arg0);
  }

  public MutableInterfaceDeclaration findInterface(final String arg0) {
    return this.getTypeLookup().findInterface(arg0);
  }

  public Type findTypeGlobally(final Class<?> arg0) {
    return this.getTypeLookup().findTypeGlobally(arg0);
  }

  public Type findTypeGlobally(final String arg0) {
    return this.getTypeLookup().findTypeGlobally(arg0);
  }

  public TypeReference getAnyType() {
    return this.getTypeReferenceProvider().getAnyType();
  }

  public TypeReference getList(final TypeReference arg0) {
    return this.getTypeReferenceProvider().getList(arg0);
  }

  public TypeReference getObject() {
    return this.getTypeReferenceProvider().getObject();
  }

  public TypeReference getPrimitiveBoolean() {
    return this.getTypeReferenceProvider().getPrimitiveBoolean();
  }

  public TypeReference getPrimitiveByte() {
    return this.getTypeReferenceProvider().getPrimitiveByte();
  }

  public TypeReference getPrimitiveChar() {
    return this.getTypeReferenceProvider().getPrimitiveChar();
  }

  public TypeReference getPrimitiveDouble() {
    return this.getTypeReferenceProvider().getPrimitiveDouble();
  }

  public TypeReference getPrimitiveFloat() {
    return this.getTypeReferenceProvider().getPrimitiveFloat();
  }

  public TypeReference getPrimitiveInt() {
    return this.getTypeReferenceProvider().getPrimitiveInt();
  }

  public TypeReference getPrimitiveLong() {
    return this.getTypeReferenceProvider().getPrimitiveLong();
  }

  public TypeReference getPrimitiveShort() {
    return this.getTypeReferenceProvider().getPrimitiveShort();
  }

  public TypeReference getPrimitiveVoid() {
    return this.getTypeReferenceProvider().getPrimitiveVoid();
  }

  public TypeReference getSet(final TypeReference arg0) {
    return this.getTypeReferenceProvider().getSet(arg0);
  }

  public TypeReference getString() {
    return this.getTypeReferenceProvider().getString();
  }

  public TypeReference newArrayTypeReference(final TypeReference arg0) {
    return this.getTypeReferenceProvider().newArrayTypeReference(arg0);
  }

  public TypeReference newSelfTypeReference(final Type arg0) {
    return this.getTypeReferenceProvider().newSelfTypeReference(arg0);
  }

  public TypeReference newTypeReference(final Class<?> arg0, final TypeReference... arg1) {
    return this.getTypeReferenceProvider().newTypeReference(arg0, arg1);
  }

  public TypeReference newTypeReference(final String arg0, final TypeReference... arg1) {
    return this.getTypeReferenceProvider().newTypeReference(arg0, arg1);
  }

  public TypeReference newTypeReference(final Type arg0, final TypeReference... arg1) {
    return this.getTypeReferenceProvider().newTypeReference(arg0, arg1);
  }

  public TypeReference newWildcardTypeReference() {
    return this.getTypeReferenceProvider().newWildcardTypeReference();
  }

  public TypeReference newWildcardTypeReference(final TypeReference arg0) {
    return this.getTypeReferenceProvider().newWildcardTypeReference(arg0);
  }

  public TypeReference newWildcardTypeReferenceWithLowerBound(final TypeReference arg0) {
    return this.getTypeReferenceProvider().newWildcardTypeReferenceWithLowerBound(arg0);
  }

  public AnnotationReference newAnnotationReference(final AnnotationReference arg0) {
    return this.getAnnotationReferenceProvider().newAnnotationReference(arg0);
  }

  public AnnotationReference newAnnotationReference(final AnnotationReference arg0, final Procedure1<AnnotationReferenceBuildContext> arg1) {
    return this.getAnnotationReferenceProvider().newAnnotationReference(arg0, arg1);
  }

  public AnnotationReference newAnnotationReference(final Class<?> arg0) {
    return this.getAnnotationReferenceProvider().newAnnotationReference(arg0);
  }

  public AnnotationReference newAnnotationReference(final Class<?> arg0, final Procedure1<AnnotationReferenceBuildContext> arg1) {
    return this.getAnnotationReferenceProvider().newAnnotationReference(arg0, arg1);
  }

  public AnnotationReference newAnnotationReference(final String arg0) {
    return this.getAnnotationReferenceProvider().newAnnotationReference(arg0);
  }

  public AnnotationReference newAnnotationReference(final String arg0, final Procedure1<AnnotationReferenceBuildContext> arg1) {
    return this.getAnnotationReferenceProvider().newAnnotationReference(arg0, arg1);
  }

  public AnnotationReference newAnnotationReference(final Type arg0) {
    return this.getAnnotationReferenceProvider().newAnnotationReference(arg0);
  }

  public AnnotationReference newAnnotationReference(final Type arg0, final Procedure1<AnnotationReferenceBuildContext> arg1) {
    return this.getAnnotationReferenceProvider().newAnnotationReference(arg0, arg1);
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

  public URI toURI(final Path arg0) {
    return this.getFileSystemSupport().toURI(arg0);
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

  public void setPrimarySourceElement(final MutableElement arg0, final Element arg1) {
    this.getAssociator().setPrimarySourceElement(arg0, arg1);
  }
}
