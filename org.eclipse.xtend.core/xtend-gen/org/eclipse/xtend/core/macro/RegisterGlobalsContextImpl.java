/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.io.InputStream;
import java.net.URI;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.TypeLookupImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.FileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class RegisterGlobalsContextImpl implements RegisterGlobalsContext {
  @Accessors
  private IJvmDeclaredTypeAcceptor acceptor;

  @Accessors
  private CompilationUnitImpl compilationUnit;

  @Override
  public void registerAnnotationType(final String qualifiedName) throws IllegalArgumentException {
    final JvmAnnotationType newType = TypesFactory.eINSTANCE.createJvmAnnotationType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    this.setNameAndAccept(newType, qualifiedName);
  }

  @Override
  public void registerClass(final String qualifiedName) throws IllegalArgumentException {
    final JvmGenericType newType = TypesFactory.eINSTANCE.createJvmGenericType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    EList<JvmTypeReference> _superTypes = newType.getSuperTypes();
    JvmTypeReference _typeForName = this.compilationUnit.getTypeReferences().getTypeForName(Object.class, this.compilationUnit.getXtendFile());
    _superTypes.add(_typeForName);
    this.setNameAndAccept(newType, qualifiedName);
  }

  @Override
  public void registerEnumerationType(final String qualifiedName) throws IllegalArgumentException {
    final JvmEnumerationType newType = TypesFactory.eINSTANCE.createJvmEnumerationType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    this.setNameAndAccept(newType, qualifiedName);
  }

  @Override
  public void registerInterface(final String qualifiedName) throws IllegalArgumentException {
    final JvmGenericType newType = TypesFactory.eINSTANCE.createJvmGenericType();
    newType.setVisibility(JvmVisibility.PUBLIC);
    newType.setInterface(true);
    this.setNameAndAccept(newType, qualifiedName);
  }

  private void setNameAndAccept(final JvmDeclaredType newType, final String qualifiedName) {
    ConditionUtils.checkQualifiedName(qualifiedName, "qualifiedName");
    JvmDeclaredType _findType = this.findType(qualifiedName);
    boolean _tripleEquals = (_findType == null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The type \'");
    _builder.append(qualifiedName);
    _builder.append("\' has already been registered.");
    Preconditions.checkArgument(_tripleEquals, _builder);
    this.compilationUnit.checkCanceled();
    final Pair<String, String> namespaceAndName = this.getNameParts(qualifiedName);
    final String headerText = this.compilationUnit.getFileHeaderProvider().getFileHeader(this.compilationUnit.getXtendFile().eResource());
    this.compilationUnit.getJvmTypesBuilder().setFileHeader(newType, headerText);
    String _key = namespaceAndName.getKey();
    boolean _tripleNotEquals = (_key != null);
    if (_tripleNotEquals) {
      final JvmDeclaredType parentType = this.findType(namespaceAndName.getKey());
      if ((parentType != null)) {
        EList<JvmMember> _members = parentType.getMembers();
        _members.add(newType);
        newType.setStatic(true);
      } else {
        newType.setPackageName(namespaceAndName.getKey());
        this.acceptor.<JvmDeclaredType>accept(newType);
      }
    } else {
      this.acceptor.<JvmDeclaredType>accept(newType);
    }
    newType.setSimpleName(namespaceAndName.getValue());
  }

  private JvmDeclaredType findType(final String string) {
    return this.findRecursively(string, Iterables.<JvmDeclaredType>filter(this.compilationUnit.getXtendFile().eResource().getContents(), JvmDeclaredType.class));
  }

  private JvmDeclaredType findRecursively(final String string, final Iterable<? extends JvmDeclaredType> types) {
    for (final JvmDeclaredType type : types) {
      {
        final String candidateQualifiedName = type.getQualifiedName('.');
        boolean _equals = Objects.equal(string, candidateQualifiedName);
        if (_equals) {
          return type;
        }
        boolean _startsWith = string.startsWith(candidateQualifiedName);
        if (_startsWith) {
          final JvmDeclaredType result = this.findRecursively(string, Iterables.<JvmDeclaredType>filter(type.getMembers(), JvmDeclaredType.class));
          if ((result != null)) {
            return result;
          }
        }
      }
    }
    return null;
  }

  private Pair<String, String> getNameParts(final String string) {
    final char dot = '.';
    final int index = string.lastIndexOf(dot);
    if ((index != (-1))) {
      String _substring = string.substring(0, index);
      String _substring_1 = string.substring((index + 1));
      return Pair.<String, String>of(_substring, _substring_1);
    } else {
      return Pair.<String, String>of(null, string);
    }
  }

  @Delegate
  public FileSystemSupport getFileSystemSupport() {
    return this.compilationUnit.getFileSystemSupport();
  }

  @Delegate
  public FileLocations getFileLocations() {
    return this.compilationUnit.getFileLocations();
  }

  @Delegate
  public TypeLookupImpl getTypeLookup() {
    return this.compilationUnit.getTypeLookup();
  }

  @Pure
  public IJvmDeclaredTypeAcceptor getAcceptor() {
    return this.acceptor;
  }

  public void setAcceptor(final IJvmDeclaredTypeAcceptor acceptor) {
    this.acceptor = acceptor;
  }

  @Pure
  public CompilationUnitImpl getCompilationUnit() {
    return this.compilationUnit;
  }

  public void setCompilationUnit(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
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

  public URI toURI(final Path path) {
    return this.getFileSystemSupport().toURI(path);
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

  public AnnotationTypeDeclaration findSourceAnnotationType(final String qualifiedName) {
    return this.getTypeLookup().findSourceAnnotationType(qualifiedName);
  }

  public ClassDeclaration findSourceClass(final String qualifiedName) {
    return this.getTypeLookup().findSourceClass(qualifiedName);
  }

  public EnumerationTypeDeclaration findSourceEnumerationType(final String qualifiedName) {
    return this.getTypeLookup().findSourceEnumerationType(qualifiedName);
  }

  public InterfaceDeclaration findSourceInterface(final String qualifiedName) {
    return this.getTypeLookup().findSourceInterface(qualifiedName);
  }

  public Type findUpstreamType(final Class<?> clazz) {
    return this.getTypeLookup().findUpstreamType(clazz);
  }

  public Type findUpstreamType(final String typeName) {
    return this.getTypeLookup().findUpstreamType(typeName);
  }
}
