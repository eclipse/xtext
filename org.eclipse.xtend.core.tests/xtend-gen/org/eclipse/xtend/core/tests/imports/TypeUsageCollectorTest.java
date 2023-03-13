/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.imports;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.imports.TypeUsage;
import org.eclipse.xtext.xbase.imports.TypeUsageCollector;
import org.eclipse.xtext.xbase.imports.TypeUsages;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeUsageCollectorTest extends AbstractXtendTestCase {
  @Inject
  private TypeUsageCollector typeUsageCollector;

  private void hasUnresolvedType(final CharSequence xtendFile, final String... typeNames) {
    try {
      final Resource resource = this.file(xtendFile.toString()).eResource();
      this.hasUnresolvedType(resource, typeNames);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private void hasUnresolvedType(final Resource resource, final String... typeNames) {
    final TypeUsages typeUsages = this.typeUsageCollector.collectTypeUsages(((XtextResource) resource));
    final Function1<TypeUsage, String> _function = (TypeUsage it) -> {
      return it.getUsedTypeName();
    };
    final Set<String> usedNames = IterableExtensions.<String>toSet(ListExtensions.<TypeUsage, String>map(typeUsages.getUnresolvedTypeUsages(), _function));
    Assert.assertEquals(IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(typeNames))), usedNames);
  }

  private void hasUnresolvedTypesWithErrors(final CharSequence xtendFile, final String... typeNames) {
    try {
      final Resource resource = this.fileWithErrors(xtendFile.toString()).eResource();
      this.hasUnresolvedType(resource, typeNames);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private void hasUnresolvedTypeSuffix(final CharSequence xtendFile, final String... suffix) {
    try {
      final Resource resource = this.file(xtendFile.toString()).eResource();
      final TypeUsages typeUsages = this.typeUsageCollector.collectTypeUsages(((XtextResource) resource));
      final Function1<TypeUsage, String> _function = (TypeUsage it) -> {
        return it.getSuffix();
      };
      final Set<String> foundSuffix = IterableExtensions.<String>toSet(ListExtensions.<TypeUsage, String>map(typeUsages.getUnresolvedTypeUsages(), _function));
      Assert.assertEquals(IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(suffix))), foundSuffix);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSimpleName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C implements Serializable {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedType(_builder, "Serializable");
  }

  @Test
  public void testNestedType_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C implements Map$Entry {}");
    _builder.newLine();
    this.hasUnresolvedType(_builder, "Map");
  }

  @Test
  public void testNestedType_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C implements Map.Entry {}");
    _builder.newLine();
    this.hasUnresolvedType(_builder, "Map");
  }

  @Test
  public void testNestedType_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = Map::Entry::DoesNotMatter");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedType(_builder, "Map");
  }

  @Test
  public void testNestedType_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = Map.Entry::DoesNotMatter");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedType(_builder, "Map");
  }

  @Test
  public void testNestedType_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = Map$Entry::DoesNotMatter");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedType(_builder, "Map");
  }

  @Test
  public void testNestedType_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = new Map.Entry");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedType(_builder, "Map");
  }

  @Test
  public void testNestedType_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = new Map$Entry");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedType(_builder, "Map");
  }

  @Test
  public void testSuffixSimpleName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C implements Serializable {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, "");
  }

  @Test
  public void testSuffixNestedType_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C implements Map$Entry {}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, "$Entry");
  }

  @Test
  public void testSuffixNestedType_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C implements Map.Entry {}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, ".Entry");
  }

  @Test
  public void testSuffixNestedType_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = Map::Entry::DoesNotMatter");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, "::Entry");
  }

  @Test
  public void testSuffixNestedType_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = Map::Entry::A::DoesNotMatter");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, "::Entry::A");
  }

  @Test
  public void testSuffixNestedType_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = Map.Entry.A::DoesNotMatter");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, ".Entry.A");
  }

  @Test
  public void testSuffixNestedType_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = Map.Entry::DoesNotMatter");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, ".Entry");
  }

  @Test
  public void testSuffixNestedType_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = Map$Entry::DoesNotMatter");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, "$Entry");
  }

  @Test
  public void testSuffixNestedType_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = new Map.Entry");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, ".Entry");
  }

  @Test
  public void testSuffixNestedType_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val entry = new Map$Entry");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedTypeSuffix(_builder, "$Entry");
  }

  @Test
  public void testBug470235() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object o = new () { // missing type is intentional");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List list = null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.hasUnresolvedTypesWithErrors(_builder, "List");
  }
}
