package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.DomainmodelInjectorProvider;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xtype.XtypePackage;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class ValidationTests {
  @Inject
  @Extension
  private ParseHelper<DomainModel> parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper validationTestHelper;
  
  @Test
  public void testImportUnused() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("entity X {}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertWarning(model, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
  }
  
  @Test
  public void testImportUnused_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("entity X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sb: java.util.List<String>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertWarning(model, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
  }
  
  @Test
  public void testImportUnused_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("entity X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sb : List<String>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op foo() : List<String> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sb");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertNoIssues(model);
  }
  
  @Test
  public void testImportUnused_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map$Entry");
    _builder.newLine();
    _builder.append("entity X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sb: Entry<String, String>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op foo() : Entry<String, String> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sb");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertNoIssues(model);
  }
  
  @Test
  public void testImportUnused_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("entity X { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sb: Map$Entry<String, String> ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op foo() : Map$Entry<String, String> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sb");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertNoIssues(model);
  }
  
  @Test
  public void testImportUnused_5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map$Entry");
    _builder.newLine();
    _builder.append("entity X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sb: Map$Entry<String, String>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op foo(): Map$Entry<String, String> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sb");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertNoIssues(model);
  }
  
  @Test
  public void testImportUnused_6() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.awt.Label");
    _builder.newLine();
    _builder.append("/** {@link Label} */ ");
    _builder.newLine();
    _builder.append("entity X{}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertNoIssues(model);
  }
  
  @Test
  public void testImportUnused_7() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.awt.Label");
    _builder.newLine();
    _builder.append("/** @see Label */");
    _builder.newLine();
    _builder.append("entity X{}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertNoIssues(model);
  }
  
  @Test
  public void testImportDuplicate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("entity X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sb: List<String>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op foo() : List<String> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sb");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertWarning(model, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_UNUSED);
  }
  
  @Test
  public void testImportCollision() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import java.awt.List");
    _builder.newLine();
    _builder.append("entity X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sb: List");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op foo() : List {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sb");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertError(model, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_COLLISION);
  }
  
  @Test
  public void testImportWildcard() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("entity X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("sb: List<String>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op foo() : List<String> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sb");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertWarning(model, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_WILDCARD_DEPRECATED);
  }
  
  @Test
  public void testImportConflictWithTypeInSameFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List ");
    _builder.newLine();
    _builder.append("entity List {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertError(model, XtypePackage.Literals.XIMPORT_DECLARATION, IssueCodes.IMPORT_CONFLICT);
  }
  
  @Test
  public void testImportNoConflictWithTypeInSameFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("entity List2 {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final DomainModel model = this.parse(_builder);
    this.validationTestHelper.assertNoErrors(model);
  }
  
  protected DomainModel parse(final CharSequence modelAsText) {
    try {
      return this.parseHelper.parse(modelAsText);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
