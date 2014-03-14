package org.eclipse.xtend.core.tests.imports;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public abstract class AbstractRewritableImportSectionTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private RewritableImportSection.Factory _rewritableImportSection$Factory;
  
  @Inject
  @Extension
  private TypeReferences _typeReferences;
  
  private XtendFile xtendFile;
  
  private String model;
  
  @Inject
  private IWhitespaceInformationProvider whitespaceInformationProvider;
  
  @Test
  public void testSimpleAdd() {
    final RewritableImportSection section = this.getSection(Set.class);
    this.addImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testVariousAdd() {
    final RewritableImportSection section = this.getSection();
    this.addExtensionImport(section, Set.class);
    this.addStaticImport(section, Collections.class);
    this.addImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension java.util.Set.*");
    _builder.newLine();
    _builder.append("import static java.util.Collections.*");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testVariousAdd_2() {
    final RewritableImportSection section = this.getSection();
    this.addExtensionImport(section, Set.class);
    this.addStaticImport(section, Set.class);
    this.addImport(section, Set.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension java.util.Set.*");
    _builder.newLine();
    _builder.append("import java.util.Set");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testDoubleAdd() {
    final RewritableImportSection section = this.getSection(List.class);
    this.addImport(section, List.class);
    this.addImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testDoubleAdd_2() {
    final RewritableImportSection section = this.getSection();
    this.addExtensionImport(section, Collections.class);
    this.addExtensionImport(section, Collections.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension java.util.Collections.*");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testDoubleAdd_3() {
    final RewritableImportSection section = this.getSection();
    this.addStaticImport(section, Collections.class);
    this.addStaticImport(section, Collections.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static java.util.Collections.*");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testSort() {
    final RewritableImportSection section = this.getSection();
    this.addExtensionImport(section, Set.class);
    this.addImport(section, Set.class);
    this.addStaticImport(section, Collections.class);
    this.addImport(section, List.class);
    section.setSort(true);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static java.util.Collections.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static extension java.util.Set.*");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testSimpleRemove() {
    final RewritableImportSection section = this.getSection(List.class, Set.class);
    this.removeImport(section, Set.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testRemoveAll() {
    final RewritableImportSection section = this.getSection(List.class, Set.class);
    this.removeImport(section, Set.class);
    this.removeImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testRemoveAdd() {
    final RewritableImportSection section = this.getSection(List.class);
    this.removeImport(section, List.class);
    this.addImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testRemoveAdd_2() {
    final RewritableImportSection section = this.getSection(List.class, Set.class);
    this.removeImport(section, List.class);
    this.addImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testRemoveAddRemove() {
    final RewritableImportSection section = this.getSection(List.class);
    this.removeImport(section, List.class);
    this.addImport(section, List.class);
    this.removeImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testRemoveAddRemoveAdd() {
    final RewritableImportSection section = this.getSection(List.class);
    this.removeImport(section, List.class);
    this.addImport(section, List.class);
    this.removeImport(section, List.class);
    this.addImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testRemoveAdd_3() {
    final RewritableImportSection section = this.getSection(List.class);
    this.removeImport(section, List.class);
    this.addStaticImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static java.util.List.*");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testRemoveAdd_4() {
    final RewritableImportSection section = this.getSection(List.class);
    this.removeImport(section, List.class);
    this.addStaticImport(section, List.class);
    this.addExtensionImport(section, List.class);
    this.removeStaticImport(section, List.class);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension java.util.List.*");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  @Test
  public void testRenameRefactoringScenario() {
    final RewritableImportSection section = this.getSection(List.class);
    List<JvmDeclaredType> _importedTypes = section.getImportedTypes("List");
    final JvmDeclaredType importedType = IterableExtensions.<JvmDeclaredType>head(_importedTypes);
    Assert.assertNotNull(importedType);
    importedType.setSimpleName("NewList");
    section.removeImport(importedType);
    section.addImport(importedType);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.NewList");
    _builder.newLine();
    this.assertEquals(section, _builder);
  }
  
  protected RewritableImportSection getImportSection(final CharSequence model) {
    try {
      String _string = model.toString();
      XtendFile _file = this.file(_string);
      Resource _eResource = _file.eResource();
      return this._rewritableImportSection$Factory.parse(((XtextResource) _eResource));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected boolean addImport(final RewritableImportSection section, final Class<?> javaClass) {
    JvmDeclaredType _jvmType = this.jvmType(javaClass);
    return section.addImport(_jvmType);
  }
  
  protected boolean removeImport(final RewritableImportSection section, final Class<?> javaClass) {
    JvmDeclaredType _jvmType = this.jvmType(javaClass);
    return section.removeImport(_jvmType);
  }
  
  protected boolean addStaticImport(final RewritableImportSection section, final Class<?> javaClass) {
    JvmDeclaredType _jvmType = this.jvmType(javaClass);
    return section.addStaticImport(_jvmType);
  }
  
  protected boolean removeStaticImport(final RewritableImportSection section, final Class<?> javaClass) {
    JvmDeclaredType _jvmType = this.jvmType(javaClass);
    return section.removeStaticImport(_jvmType, null);
  }
  
  protected boolean addExtensionImport(final RewritableImportSection section, final Class<?> javaClass) {
    JvmDeclaredType _jvmType = this.jvmType(javaClass);
    return section.addStaticExtensionImport(_jvmType);
  }
  
  protected boolean removeExtensionImport(final RewritableImportSection section, final Class<?> javaClass) {
    JvmDeclaredType _jvmType = this.jvmType(javaClass);
    return section.removeStaticExtensionImport(_jvmType, null);
  }
  
  protected JvmDeclaredType jvmType(final Class<?> javaClass) {
    JvmDeclaredType _xblockexpression = null;
    {
      final JvmType type = this._typeReferences.findDeclaredType(javaClass, this.xtendFile);
      Assert.assertTrue((type instanceof JvmDeclaredType));
      _xblockexpression = ((JvmDeclaredType) type);
    }
    return _xblockexpression;
  }
  
  protected RewritableImportSection getSection(final Class<?>... types) {
    try {
      RewritableImportSection _xblockexpression = null;
      {
        CharSequence _model = this.getModel(types);
        String _string = _model.toString();
        this.model = _string;
        XtendFile _file = this.file(this.model);
        this.xtendFile = _file;
        Resource _eResource = this.xtendFile.eResource();
        _xblockexpression = this._rewritableImportSection$Factory.parse(((XtextResource) _eResource));
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void assertEquals(final RewritableImportSection section, final CharSequence sectionAsString) {
    final StringBuilder builder = new StringBuilder(this.model);
    final List<ReplaceRegion> changes = section.rewrite();
    final Function1<ReplaceRegion, Integer> _function = new Function1<ReplaceRegion, Integer>() {
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
    String _string = sectionAsString.toString();
    CharSequence _expectedModel = this.getExpectedModel(_string);
    String _processLinebreaks = this.processLinebreaks(_expectedModel);
    String _processLinebreaks_1 = this.processLinebreaks(builder);
    Assert.assertEquals(_processLinebreaks, _processLinebreaks_1);
  }
  
  protected String processLinebreaks(final CharSequence sequence) {
    String _xblockexpression = null;
    {
      Resource _eResource = this.xtendFile.eResource();
      URI _uRI = _eResource.getURI();
      ILineSeparatorInformation _lineSeparatorInformation = this.whitespaceInformationProvider.getLineSeparatorInformation(_uRI);
      final String lineSeparator = _lineSeparatorInformation.getLineSeparator();
      String _xifexpression = null;
      boolean _isIgnoreLinebreaks = this.isIgnoreLinebreaks();
      if (_isIgnoreLinebreaks) {
        String _string = sequence.toString();
        _xifexpression = _string.replaceAll((("(" + lineSeparator) + ")+"), " ");
      } else {
        _xifexpression = sequence.toString();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected boolean isIgnoreLinebreaks() {
    return false;
  }
  
  protected abstract CharSequence getModel(final Class<?>[] types);
  
  protected abstract CharSequence getExpectedModel(final String sectionAsString);
}
