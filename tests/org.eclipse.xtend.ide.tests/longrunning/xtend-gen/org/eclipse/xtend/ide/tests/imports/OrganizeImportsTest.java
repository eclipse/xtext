package org.eclipse.xtend.ide.tests.imports;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.imports.ImportOrganizer;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class OrganizeImportsTest extends AbstractXtendUITestCase {
  @Inject
  private ImportOrganizer importOrganizer;
  
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;
  
  protected void assertIsOrganizedTo(final CharSequence model, final CharSequence expected) {
    this.assertIsOrganizedTo(model, "Foo", expected);
  }
  
  protected void assertIsOrganizedTo(final CharSequence model, final String fileName, final CharSequence expected) {
    try {
      String _string = expected.toString();
      boolean _contains = _string.contains("$");
      Assert.assertFalse(_contains);
      String _string_1 = model.toString();
      final XtendFile xtendFile = this._workbenchTestHelper.xtendFile(fileName, _string_1);
      Resource _eResource = xtendFile.eResource();
      final List<ReplaceRegion> changes = this.importOrganizer.getOrganizedImportChanges(((XtextResource) _eResource));
      final StringBuilder builder = new StringBuilder(model);
      final Function1<ReplaceRegion, Integer> _function = new Function1<ReplaceRegion, Integer>() {
        @Override
        public Integer apply(final ReplaceRegion it) {
          return Integer.valueOf(it.getOffset());
        }
      };
      List<ReplaceRegion> _sortBy = IterableExtensions.<ReplaceRegion, Integer>sortBy(changes, _function);
      List<ReplaceRegion> _reverse = ListExtensions.<ReplaceRegion>reverse(_sortBy);
      for (final ReplaceRegion it : _reverse) {
        int _offset = it.getOffset();
        int _offset_1 = it.getOffset();
        int _length = it.getLength();
        int _plus = (_offset_1 + _length);
        String _text = it.getText();
        builder.replace(_offset, _plus, _text);
      }
      String _string_2 = expected.toString();
      String _string_3 = builder.toString();
      Assert.assertEquals(_string_2, _string_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void assertIsOrganizedWithErrorsTo(final CharSequence model, final CharSequence expected) {
    try {
      String _string = expected.toString();
      boolean _contains = _string.contains("$");
      Assert.assertFalse(_contains);
      String _string_1 = model.toString();
      final XtendFile xtendFile = this.xtendFileWithError(_string_1);
      Resource _eResource = xtendFile.eResource();
      final List<ReplaceRegion> changes = this.importOrganizer.getOrganizedImportChanges(((XtextResource) _eResource));
      final StringBuilder builder = new StringBuilder(model);
      final Function1<ReplaceRegion, Integer> _function = new Function1<ReplaceRegion, Integer>() {
        @Override
        public Integer apply(final ReplaceRegion it) {
          return Integer.valueOf(it.getOffset());
        }
      };
      List<ReplaceRegion> _sortBy = IterableExtensions.<ReplaceRegion, Integer>sortBy(changes, _function);
      List<ReplaceRegion> _reverse = ListExtensions.<ReplaceRegion>reverse(_sortBy);
      for (final ReplaceRegion it : _reverse) {
        int _offset = it.getOffset();
        int _offset_1 = it.getOffset();
        int _length = it.getLength();
        int _plus = (_offset_1 + _length);
        String _text = it.getText();
        builder.replace(_offset, _plus, _text);
      }
      String _string_2 = expected.toString();
      String _string_3 = builder.toString();
      Assert.assertEquals(_string_2, _string_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XtendFile xtendFileWithError(final String content) throws Exception {
    IFile file = this._workbenchTestHelper.createFile("HasErrors", content);
    ResourceSet _resourceSet = this._workbenchTestHelper.getResourceSet();
    URI _uri = this._workbenchTestHelper.uri(file);
    Resource resource = _resourceSet.createResource(_uri);
    StringInputStream _stringInputStream = new StringInputStream(content);
    resource.load(_stringInputStream, null);
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    String _string = _errors.toString();
    EList<Resource.Diagnostic> _errors_1 = resource.getErrors();
    int _size = _errors_1.size();
    boolean _greaterThan = (_size > 0);
    Assert.assertTrue(_string, _greaterThan);
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    XtendFile xtendFile = ((XtendFile) _get);
    return xtendFile;
  }
  
  @Test
  public void testBug470235() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.Data");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class O {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object o = new () {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("BigDecimal list = null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.math.BigDecimal");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class O {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Object o = new () {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("BigDecimal list = null");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("} ");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedWithErrorsTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedArrayType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Serializable[] elements");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Serializable[] elements");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedArrayType2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("HashSet<Serializable>[] elements");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.append("import java.util.HashSet");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("HashSet<Serializable>[] elements");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo implements Serializable {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo implements Serializable {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedNestedType_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo implements Map$Entry {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo implements Map.Entry {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedNestedType_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Map$Entry::DoesNotMatter");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def m() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Map.Entry::DoesNotMatter");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedNestedType_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo implements Map.Entry {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo implements Map.Entry {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedNestedType_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Map.Entry::DoesNotMatter");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def m() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Map.Entry::DoesNotMatter");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedNestedType_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Map::Entry::DoesNotMatter");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def m() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Map.Entry::DoesNotMatter");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedConstructorCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object bar = new ArrayList");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Object bar = new ArrayList");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testConstructorCallToEnum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.lang.annotation.RetentionPolicy");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object bar = new RetentionPolicy");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.annotation.RetentionPolicy");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Object bar = new RetentionPolicy");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testFullyQualifiedConstructorCallToEnum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object bar = new java.lang.annotation.RetentionPolicy");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.annotation.RetentionPolicy");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Object bar = new RetentionPolicy");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedConstructorCallToEnum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object bar = new RetentionPolicy");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.annotation.RetentionPolicy");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Object bar = new RetentionPolicy");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testWildcardType_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Class<?> bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Class<?> bar");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testWildcardType_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Class<? extends Serializable> bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Class<? extends Serializable> bar");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testWildcardType_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Class<Serializable> bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("Class<Serializable> bar");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testStaticTypeUsedTwice() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Collections");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(Collections::singleton)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(Collections::singleton)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(Collections::singleton)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def m() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("println(Collections::singleton)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("println(Collections::singleton)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("println(Collections::singleton)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testDontChangeDanglingFeatureCalls() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("field.x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("field.x");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testKeepRequiredStaticExtensionImport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package repro");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static extension repro.B.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("A.ext");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class B {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void ext(Class<?> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package repro");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import static extension repro.B.*");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class A {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void m() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("A.ext");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("class B {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def static void ext(Class<?> c) {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, "repro/Foo", _builder_1);
  }
  
  @Test
  public void testJavaDocReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package repro");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see java.lang.String");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@SupressWarnings(\'all\')");
    _builder.newLine();
    _builder.append("class Foo {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package repro");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* @see String");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@SupressWarnings(\'all\')");
    _builder_1.newLine();
    _builder_1.append("class Foo {}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, "repro/Foo", _builder_1);
  }
  
  @Test
  public void testJavaDocReference2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package repro");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @see java.lang.String");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@SupressWarnings(\'all\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void foo() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package repro");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("* @see String");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@SupressWarnings(\'all\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void foo() {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, "repro/Foo", _builder_1);
  }
  
  @Test
  public void implicitImport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package repro");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Pair<Integer, Integer> m() {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package repro");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def Pair<Integer, Integer> m() {}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, "repro/Foo", _builder_1);
  }
  
  @Test
  public void implicitImport_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package repro");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.lang.Integer;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.lib.Pair;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Pair<Integer, Integer> m() {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package repro");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def Pair<Integer, Integer> m() {}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, "repro/Foo", _builder_1);
  }
  
  @Test
  public void testMemberImport_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static java.lang.String.valueOf");
    _builder.newLine();
    _builder.append("import static java.lang.Integer.valueOf");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("valueOf(1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import static java.lang.Integer.valueOf");
    _builder_1.newLine();
    _builder_1.append("import static java.lang.String.valueOf");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("valueOf(1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, "repro/Foo", _builder_1);
  }
  
  @Test
  public void testMemberImport_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static java.lang.Integer.*");
    _builder.newLine();
    _builder.append("import static java.lang.Integer.valueOf");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("valueOf(1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import static java.lang.Integer.valueOf");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("valueOf(1)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, "repro/Foo", _builder_1);
  }
  
  @Test
  public void testAnonymousClass_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val bar = new Bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override bar() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val bar = new Bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("override bar() {}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("interface Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testAnonymousClass_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val bar = new Serializable() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val bar = new Serializable() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testAnonymousClass_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val bar = new Iterable<Serializable>() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override java.util.Iterator<Serializable> iterator() { null }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.append("import java.util.Iterator");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val bar = new Iterable<Serializable>() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("override Iterator<Serializable> iterator() { null }");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testAnonymousClass_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.Serializable");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val bar = new Serializable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val additionalField = 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val bar = new Serializable() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val additionalField = 1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug447227() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class InnerTypeLostOnImport {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("enum E {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("A, B, C");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo extends InnerTypeLostOnImport {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def bar(E e) { // <--- Point B");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val Map m // <--- Point A");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class InnerTypeLostOnImport {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("enum E {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("A, B, C");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo extends InnerTypeLostOnImport {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("def bar(E e) { // <--- Point B");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("val Map m // <--- Point A");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIsOrganizedTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug447227_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package p");
      _builder.newLine();
      _builder.append("public class class Outer {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static class Inner {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._workbenchTestHelper.createFile("/p/Outer.java", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package p");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import p.Outer.Inner");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class Client {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Inner inner;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package p");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import p.Outer.Inner");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("public class Client {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Inner inner;");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.assertIsOrganizedTo(_builder_1, _builder_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Ignore
  public void testBug482371_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package p");
      _builder.newLine();
      _builder.append("class Outer {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("annotation Inner {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._workbenchTestHelper.createFile("/p/Outer.xtend", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package p");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import p.Outer.Inner");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@Inner");
      _builder_1.newLine();
      _builder_1.append("class Client extends Outer {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package p");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import p.Outer.Inner");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@Inner");
      _builder_2.newLine();
      _builder_2.append("class Client extends Outer {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.assertIsOrganizedTo(_builder_1, _builder_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Ignore
  public void testBug482371_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package p");
      _builder.newLine();
      _builder.append("class Outer {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("annotation Inner {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._workbenchTestHelper.createFile("/p/Outer.xtend", _builder.toString());
      IResourcesSetupUtil.waitForBuild();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package p");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import p.Outer.Inner");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Client extends Outer {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("@Inner");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void foo() {}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package p");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("class Client extends Outer {");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("@Inner");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def void foo() {}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this.assertIsOrganizedTo(_builder_1, _builder_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
