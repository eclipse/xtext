/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.TypeLookupImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.FileSystemSupport;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class RegisterGlobalsContextImpl implements RegisterGlobalsContext {
  /* @Accessors
   */private IJvmDeclaredTypeAcceptor acceptor;
  
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method superTypes is undefined for the type RegisterGlobalsContextImpl"
      + "\nThe method getTypeForName is undefined for the type RegisterGlobalsContextImpl"
      + "\nThe field typeReferences is not visible"
      + "\nThe field xtendFile is not visible"
      + "\n+= cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Preconditions is undefined for the type RegisterGlobalsContextImpl"
      + "\n== cannot be resolved."
      + "\nThe method getFileHeader is undefined for the type RegisterGlobalsContextImpl"
      + "\nThe method eResource is undefined for the type RegisterGlobalsContextImpl"
      + "\n!= cannot be resolved."
      + "\n!= cannot be resolved."
      + "\nThe method members is undefined for the type RegisterGlobalsContextImpl"
      + "\nThe field fileHeaderProvider is not visible"
      + "\nThe field xtendFile is not visible"
      + "\nThe field jvmTypesBuilder is not visible"
      + "\ncheckArgument cannot be resolved"
      + "\n+= cannot be resolved");
  }
  
  private JvmDeclaredType findType(final String string) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method eResource is undefined for the type RegisterGlobalsContextImpl"
      + "\nThe field xtendFile is not visible"
      + "\ncontents cannot be resolved"
      + "\nfilter cannot be resolved");
  }
  
  private JvmDeclaredType findRecursively(final String string, final Iterable<? extends JvmDeclaredType> types) {
    throw new Error("Unresolved compilation problems:"
      + "\n== cannot be resolved."
      + "\nThe method members is undefined for the type RegisterGlobalsContextImpl"
      + "\n!= cannot be resolved."
      + "\nfilter cannot be resolved");
  }
  
  private Pair<String, String> getNameParts(final String string) {
    throw new Error("Unresolved compilation problems:"
      + "\n-> cannot be resolved."
      + "\n-> cannot be resolved.");
  }
  
  /* @Delegate
   */public FileSystemSupport getFileSystemSupport() {
    return this.compilationUnit.getFileSystemSupport();
  }
  
  @Delegate
  public FileLocations getFileLocations() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field fileLocations is not visible");
  }
  
  @Delegate
  public TypeLookupImpl getTypeLookup() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field typeLookup is not visible");
  }
}
