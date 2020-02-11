/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Arrays;
import java.util.List;
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
    String _scheme = fsa.getURI("").scheme();
    boolean _equals = Objects.equal(_scheme, "inmemory");
    if (_equals) {
      return;
    }
    List<TypeDeclaration> _list = IteratorExtensions.<TypeDeclaration>toList(Iterators.<TypeDeclaration>filter(resource.getAllContents(), TypeDeclaration.class));
    for (final TypeDeclaration type : _list) {
      String _name = type.getName();
      String _plus = (_name + ".java");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("public class ");
      String _name_1 = type.getName();
      _builder.append(_name_1);
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        Iterable<Property> _filter = Iterables.<Property>filter(type.getMembers(), Property.class);
        for(final Property p : _filter) {
          _builder.append("\t");
          _builder.append("private ");
          String _java = this.toJava(p.getType());
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
          String _firstUpper = StringExtensions.toFirstUpper(p.getName());
          _builder.append(_firstUpper, "\t");
          _builder.append("(");
          String _java_1 = this.toJava(p.getType());
          _builder.append(_java_1, "\t");
          _builder.append(" ");
          String _name_3 = p.getName();
          _builder.append(_name_3, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          String _name_4 = p.getName();
          _builder.append(_name_4, "\t\t");
          _builder.append(" = ");
          String _name_5 = p.getName();
          _builder.append(_name_5, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public ");
          String _java_2 = this.toJava(p.getType());
          _builder.append(_java_2, "\t");
          _builder.append(" get");
          String _firstUpper_1 = StringExtensions.toFirstUpper(p.getName());
          _builder.append(_firstUpper_1, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return this.");
          String _name_6 = p.getName();
          _builder.append(_name_6, "\t\t");
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
    String _name = type.getTypeRef().getName();
    final Function1<String, String> _function = (String it) -> {
      return "[]";
    };
    String _join = IterableExtensions.join(ListExtensions.<String, String>map(type.getArrayDiemensions(), _function), "");
    return (_name + _join);
  }
  
  protected String _toJava(final PrimitiveType type) {
    String _name = type.getName();
    final Function1<String, String> _function = (String it) -> {
      return "[]";
    };
    String _join = IterableExtensions.join(ListExtensions.<String, String>map(type.getArrayDiemensions(), _function), "");
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
