package org.eclipse.xtend.core.tests.annotations;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class AnnotationTest extends AbstractXtendTestCase {
  @Test
  public void testAnnotationValue_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(2)");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    CharSequence _compileToJavaCode = this.compileToJavaCode(_builder);
    this.assertContains(_compileToJavaCode, "@Click(2)");
  }
  
  @Test
  public void testAnnotationValue_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(#[2])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    CharSequence _compileToJavaCode = this.compileToJavaCode(_builder);
    this.assertContains(_compileToJavaCode, "@Click({ 2 })");
  }
  
  @Test
  public void testAnnotationValue_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(#[2,3])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    CharSequence _compileToJavaCode = this.compileToJavaCode(_builder);
    this.assertContains(_compileToJavaCode, "@Click({ 2, 3 })");
  }
  
  @Test
  public void testAnnotationValue_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(value = 2)");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    CharSequence _compileToJavaCode = this.compileToJavaCode(_builder);
    this.assertContains(_compileToJavaCode, "@Click(value = 2)");
  }
  
  @Test
  public void testAnnotationValue_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(value = #[2])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    CharSequence _compileToJavaCode = this.compileToJavaCode(_builder);
    this.assertContains(_compileToJavaCode, "@Click(value = { 2 })");
  }
  
  @Test
  public void testAnnotationValue_5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Click(value = #[2,3])");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    CharSequence _compileToJavaCode = this.compileToJavaCode(_builder);
    this.assertContains(_compileToJavaCode, "@Click(value = { 2, 3 })");
  }
  
  protected void assertContains(final CharSequence code, final String text) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Substring \'");
    _builder.append(text, "");
    _builder.append("\' not found in \'");
    _builder.append(code, "");
    _builder.append("\' ");
    String _string = code.toString();
    boolean _contains = _string.contains(text);
    Assert.assertTrue(_builder.toString(), _contains);
  }
  
  @Inject
  private ParseHelper<XtendFile> parseHelper;
  
  @Inject
  private ValidationTestHelper validationHelper;
  
  @Inject
  private IXtendJvmAssociations associations;
  
  @Inject
  private JvmModelGenerator generator;
  
  @Inject
  private IGeneratorConfigProvider generatorConfigProvider;
  
  protected CharSequence compileToJavaCode(final CharSequence xtendCode) {
    try {
      CharSequence _xblockexpression = null;
      {
        final XtendFile file = this.parseHelper.parse(xtendCode);
        this.validationHelper.assertNoErrors(file);
        EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
        XtendTypeDeclaration _get = _xtendTypes.get(0);
        final JvmDeclaredType inferredType = this.associations.getInferredType(_get);
        GeneratorConfig _get_1 = this.generatorConfigProvider.get(inferredType);
        CharSequence _generateType = this.generator.generateType(inferredType, _get_1);
        _xblockexpression = (_generateType);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
