/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.generator;

import com.google.common.collect.Iterators;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Type;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class TestLanguageGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    TreeIterator<EObject> _allContents = resource.getAllContents();
    Iterator<TypeDeclaration> _filter = Iterators.<TypeDeclaration>filter(_allContents, TypeDeclaration.class);
    List<TypeDeclaration> _list = IteratorExtensions.<TypeDeclaration>toList(_filter);
    for (final TypeDeclaration type : _list) {
      String _name = type.getName();
      String _plus = (_name + ".java");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class ");
      String _name_1 = type.getName();
      _builder.append(_name_1, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        EList<Property> _properties = type.getProperties();
        for(final Property p : _properties) {
          _builder.append("\t");
          _builder.append("private ");
          Type _type = p.getType();
          String _java = this.toJava(_type);
          _builder.append(_java, "\t");
          _builder.append(" ");
          String _name_2 = p.getName();
          _builder.append(_name_2, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void set");
          String _name_3 = p.getName();
          String _firstUpper = StringExtensions.toFirstUpper(_name_3);
          _builder.append(_firstUpper, "\t");
          _builder.append("(");
          Type _type_1 = p.getType();
          String _java_1 = this.toJava(_type_1);
          _builder.append(_java_1, "\t");
          _builder.append(" ");
          String _name_4 = p.getName();
          _builder.append(_name_4, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          String _name_5 = p.getName();
          _builder.append(_name_5, "\t\t");
          _builder.append(" = ");
          String _name_6 = p.getName();
          _builder.append(_name_6, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public ");
          Type _type_2 = p.getType();
          String _java_2 = this.toJava(_type_2);
          _builder.append(_java_2, "\t");
          _builder.append(" get");
          String _name_7 = p.getName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_name_7);
          _builder.append(_firstUpper_1, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return this.");
          String _name_8 = p.getName();
          _builder.append(_name_8, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      fsa.generateFile(_plus, _builder);
    }
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
