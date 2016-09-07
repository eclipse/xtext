/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.generator;

import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Type;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class TestLanguageGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field properties is undefined for the type TypeDeclaration"
      + "\ntype cannot be resolved"
      + "\ntoJava cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntoFirstUpper cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ntoJava cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntype cannot be resolved"
      + "\ntoJava cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntoFirstUpper cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  protected String _toJava(final TypeReference type) {
    TypeDeclaration _typeRef = type.getTypeRef();
    String _name = _typeRef.getName();
    EList<String> _arrayDiemensions = type.getArrayDiemensions();
    final Function1<String, String> _function = (String it) -> {
      return "[]";
    };
    List<String> _map = ListExtensions.<String, String>map(_arrayDiemensions, _function);
    String _join = IterableExtensions.join(_map, "");
    return (_name + _join);
  }
  
  protected String _toJava(final PrimitiveType type) {
    String _name = type.getName();
    EList<String> _arrayDiemensions = type.getArrayDiemensions();
    final Function1<String, String> _function = (String it) -> {
      return "[]";
    };
    List<String> _map = ListExtensions.<String, String>map(_arrayDiemensions, _function);
    String _join = IterableExtensions.join(_map, "");
    return (_name + _join);
  }
  
  public String toJava(final Type type) {
    if (type instanceof PrimitiveType) {
      return _toJava((PrimitiveType)type);
    } else if (type instanceof TypeReference) {
      return _toJava((TypeReference)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
}
