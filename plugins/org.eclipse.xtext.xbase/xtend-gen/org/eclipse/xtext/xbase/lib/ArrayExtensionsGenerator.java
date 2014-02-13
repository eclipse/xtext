/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.lib;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ArrayExtensionsGenerator {
  public String startMarker() {
    return "// BEGIN generated code";
  }
  
  public String endMarker() {
    return "// END generated code";
  }
  
  private final ArrayList<String> primitiveTypes = CollectionLiterals.<String>newArrayList("boolean", "double", "float", "long", "int", "char", "short", "byte");
  
  public static void main(final String[] args) {
    ArrayExtensionsGenerator _arrayExtensionsGenerator = new ArrayExtensionsGenerator();
    _arrayExtensionsGenerator.generateFile();
  }
  
  public String generateFile() {
    try {
      String _xblockexpression = null;
      {
        final File file = new File("../org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/ArrayExtensions.java");
        boolean _exists = file.exists();
        boolean _not = (!_exists);
        if (_not) {
          throw new IllegalStateException((("file " + file) + " doesn\'t exist."));
        }
        String _absolutePath = file.getAbsolutePath();
        final String content = Files.readFileIntoString(_absolutePath);
        String _startMarker = this.startMarker();
        int _indexOf = content.indexOf(_startMarker);
        boolean _equals = (_indexOf == (-1));
        if (_equals) {
          throw new IllegalStateException((("File " + file) + " doesn\'t contain \'// BEGIN generated code\' marker."));
        }
        StringConcatenation _builder = new StringConcatenation();
        String _startMarker_1 = this.startMarker();
        int _indexOf_1 = content.indexOf(_startMarker_1);
        String _startMarker_2 = this.startMarker();
        int _length = _startMarker_2.length();
        int _plus = (_indexOf_1 + _length);
        String _substring = content.substring(0, _plus);
        _builder.append(_substring, "");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generateAllOperations = this.generateAllOperations();
        _builder.append(_generateAllOperations, "\t");
        _builder.newLineIfNotEmpty();
        String _endMarker = this.endMarker();
        int _indexOf_2 = content.indexOf(_endMarker);
        String _substring_1 = content.substring(_indexOf_2);
        _builder.append(_substring_1, "");
        _builder.newLineIfNotEmpty();
        final String newContent = _builder.toString();
        final FileWriter writer = new FileWriter(file);
        writer.append(newContent);
        writer.close();
        _xblockexpression = InputOutput.<String>println("generation finished");
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence generateAllOperations() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateLength = this.generateLength("Object");
    _builder.append(_generateLength, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generateHashCode = this.generateHashCode("Object");
    _builder.append(_generateHashCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generateEquals = this.generateEquals("Object");
    _builder.append(_generateEquals, "");
    _builder.newLineIfNotEmpty();
    {
      for(final String t : this.primitiveTypes) {
        _builder.newLine();
        CharSequence _generateGet = this.generateGet(t);
        _builder.append(_generateGet, "");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        CharSequence _generateSet = this.generateSet(t);
        _builder.append(_generateSet, "");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        CharSequence _generateLength_1 = this.generateLength(t);
        _builder.append(_generateLength_1, "");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        CharSequence _generateHashCode_1 = this.generateHashCode(t);
        _builder.append(_generateHashCode_1, "");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        CharSequence _generateEquals_1 = this.generateEquals(t);
        _builder.append(_generateEquals_1, "");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        CharSequence _generateClone = this.generateClone(t);
        _builder.append(_generateClone, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence generateClone(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Clones the array. @see {@link Object#clone}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return the cloned array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @since 2.5");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("@Inline(\"$1.clone()\")");
    _builder.newLine();
    _builder.append("public static ");
    _builder.append(string, "");
    _builder.append("[] clone(");
    _builder.append(string, "");
    _builder.append("[] array) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return array.clone();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateEquals(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Delegates to {@link Object#equals(Object)}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param other");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the other element to compare to");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return the hash code");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @since 2.5");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("@Inline(\"$1.equals($2)\")");
    _builder.newLine();
    _builder.append("public static boolean equals(");
    _builder.append(string, "");
    _builder.append("[] array, Object other) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return array.equals(other);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateHashCode(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Returns a hash code value for the given array.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return the hash code");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @since 2.5");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("@Inline(\"$1.hashCode()\")");
    _builder.newLine();
    _builder.append("public static int hashCode(");
    _builder.append(string, "");
    _builder.append("[] array) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return array.hashCode();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateLength(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return the length of the given array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("@Inline(\"$1.length\")");
    _builder.newLine();
    _builder.append("public static int length(");
    _builder.append(string, "");
    _builder.append("[] array) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return array.length;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateSet(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param index");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the index the value should be set at");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param value");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the value to set at the given index");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Inline(\"$1[$2] = $3\")");
    _builder.newLine();
    _builder.append("public static void set(");
    _builder.append(string, "");
    _builder.append("[] array, int index, ");
    _builder.append(string, "");
    _builder.append(" value) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("array[index] = value;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateGet(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the array");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param index");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*            the index");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @return the value at the given index");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("@Inline(\"$1[$2]\")");
    _builder.newLine();
    _builder.append("public static ");
    _builder.append(string, "");
    _builder.append(" get(");
    _builder.append(string, "");
    _builder.append("[] array, int index) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return array[index];");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
