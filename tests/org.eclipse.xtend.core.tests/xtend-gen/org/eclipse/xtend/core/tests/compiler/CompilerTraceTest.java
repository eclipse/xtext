package org.eclipse.xtend.core.tests.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.compiler.RootTraceRegionForTesting;
import org.eclipse.xtend.core.tests.compiler.SimpleTrace;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class CompilerTraceTest extends AbstractXtendTestCase {
  @Inject
  private JvmModelGenerator generator;
  
  @Inject
  private IGeneratorConfigProvider generatorConfigProvider;
  
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  protected IFilePostProcessor postProcessor;
  
  @Test
  public void testClassComment() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pack");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* # my comment #");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Zonk {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pack;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("#/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/#");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testClassName() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pack");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Z#o#nk {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pack;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class #Zonk# {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testClassKeyword() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pack");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("cl#a#ss Zonk {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pack;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("#@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("}#");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testClassWithComment() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pack");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*# my comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("cla#ss Zonk {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("#package pack;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("#");
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  @Ignore("This one should succeed as soon as the case above is fixed")
  public void testClassWithComment_Ignored() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pack");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*# my comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("cla#ss Zonk {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pack;");
    _builder_1.newLine();
    _builder_1.append("#/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("}#");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testClassTypeParamWithConstraint() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pack");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Zonk<P#ara#m extends Object> {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pack;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk<#Param# extends Object> {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testClassTypeParamUpperBound() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pack");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Zonk<Param extends O#bje#ct> {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pack;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk<Param extends #Object#> {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testClassTypeParamWithoutConstraint() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package pack");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Zonk<P#ara#m> {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package pack;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk<#Param extends Object#> {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testFieldComment() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*#/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("#/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/#");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private String s;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testFieldName() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String #s#;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private String #s#;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testFieldType() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.List<S#tri#ng> s;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private List<#String#> s;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testFieldDeclaration() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Str#ing s#;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("#private String s;#");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testFieldDeclarationAndComment() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*# my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s#;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("#/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private String s;#");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodComment() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/#**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/#");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void s() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("#/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/#");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void s() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodName() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void #meth#od() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void #method#() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodDeclaration() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#def# void method() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("#public void method() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}#");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodDeclarationAndComment() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d#ef void method() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("#/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}#");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodReturnType() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def v#oid# method() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public #void# method() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodParameter() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method(Str#ing stri#ng) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method(#final String string#) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodParameterName() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method(String s#tring#) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method(final String #string#) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodParameterType() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method(java.lan#g.St#ring string) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method(final #String# string) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodParameterTypeWithGenerics() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method(Li#s#t<String> strings) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method(final #List#<String> strings) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodParameterFunctionType() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method((S#tri#ng)=>int fun) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method(final Function1<? super #String#, ? extends Integer> fun) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodParameterFunctionTypeComplete() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method((#String)=>i#nt fun) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method(final #Function1<? super String, ? extends Integer># fun) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodWithThrowsClause() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method() throws Ex#cept#ion {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method() throws #Exception# {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodWithThrowsClauseTwoExceptions() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method() throws java.io.IOException, RuntimeEx#cept#ion {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.IOException;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method() throws IOException, #RuntimeException# {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testConstructorComment() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/#**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/#");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("#/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/#");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Zonk() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testConstructorName() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#ne#w() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public #Zonk#() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testConstructorDeclaration() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#new(#) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("#public Zonk() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}#");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testConstructorDeclarationAndComment() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("#/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* my comment");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("n#ew() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("#/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* my comment");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Zonk() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}#");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testDispatchMethodName_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void #meth#od(String s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void method(Integer i) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void #_method#(final String s) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _method(final Integer i) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method(final Object i) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (i instanceof Integer) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_method((Integer)i);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (i instanceof String) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_method((String)i);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Arrays.<Object>asList(i).toString());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testDispatchMethodName_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void #meth#od(String s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void method(Integer i) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _method(final String s) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _method(final Integer i) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void #method#(final Object i) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (i instanceof Integer) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_method((Integer)i);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (i instanceof String) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_method((String)i);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Arrays.<Object>asList(i).toString());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  @Test
  public void testDispatchMethodName_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Zonk {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void #meth#od(String s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void method(Integer i) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Zonk {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _method(final String s) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _method(final Integer i) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void method(final Object i) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (i instanceof Integer) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_method((Integer)i);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} #else if (i instanceof String) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_method((String)i);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;#");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Arrays.<Object>asList(i).toString());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.tracesTo(_builder, _builder_1);
  }
  
  private Pattern p = Pattern.compile("([^#]*)#([^#]*)#([^#]*)", Pattern.DOTALL);
  
  public void tracesTo(final CharSequence xtend, final CharSequence java) {
    try {
      final String xtendWithSpaces = ((" " + xtend) + " ");
      final Matcher xtendMatcher = this.p.matcher(xtendWithSpaces);
      boolean _matches = xtendMatcher.matches();
      Assert.assertTrue("xtendMatcher.matches", _matches);
      final String xtendGroup1 = xtendMatcher.group(1);
      final String xtendGroup2 = xtendMatcher.group(2);
      final String xtendGroup3 = xtendMatcher.group(3);
      final String actualXtendCode = ((xtendGroup1 + xtendGroup2) + xtendGroup3);
      final XtendFile file = this.file(actualXtendCode, true);
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      final JvmGenericType inferredType = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
      GeneratorConfig _get = this.generatorConfigProvider.get(inferredType);
      CharSequence compiledCode = this.generator.generateType(inferredType, _get);
      CharSequence _postProcess = this.postProcessor.postProcess(null, compiledCode);
      compiledCode = _postProcess;
      String _string = java.toString();
      final Matcher javaMatcher = this.p.matcher(_string);
      boolean _matches_1 = javaMatcher.matches();
      Assert.assertTrue("javaMatcher.matches", _matches_1);
      final String javaGroup1 = javaMatcher.group(1);
      final String javaGroup2 = javaMatcher.group(2);
      final String javaGroup3 = javaMatcher.group(3);
      final String actualJavaExpectation = ((javaGroup1 + javaGroup2) + javaGroup3);
      String _string_1 = compiledCode.toString();
      Assert.assertEquals(actualJavaExpectation, _string_1);
      AbstractTraceRegion _traceRegion = ((ITraceRegionProvider) compiledCode).getTraceRegion();
      Resource _eResource = file.eResource();
      URI _uRI = _eResource.getURI();
      String _path = _uRI.path();
      URI _createURI = URI.createURI(_path);
      SourceRelativeURI _sourceRelativeURI = new SourceRelativeURI(_createURI);
      Resource _eResource_1 = file.eResource();
      URI _uRI_1 = _eResource_1.getURI();
      String _path_1 = _uRI_1.path();
      URI _createURI_1 = URI.createURI(_path_1);
      SourceRelativeURI _sourceRelativeURI_1 = new SourceRelativeURI(_createURI_1);
      List<AbstractTraceRegion> _invertFor = _traceRegion.invertFor(_sourceRelativeURI, _sourceRelativeURI_1);
      AbstractTraceRegion _merge = this.merge(_invertFor);
      final SimpleTrace trace = new SimpleTrace(_merge);
      int _length = xtendGroup1.length();
      int _length_1 = xtendGroup2.length();
      TextRegion _textRegion = new TextRegion(_length, _length_1);
      final Iterable<? extends ILocationInResource> locations = trace.getAllAssociatedLocations(_textRegion);
      int _length_2 = javaGroup1.length();
      int _length_3 = javaGroup2.length();
      final TextRegion expectedRegion = new TextRegion(_length_2, _length_3);
      boolean _isEmpty = IterableExtensions.isEmpty(locations);
      Assert.assertFalse(_isEmpty);
      for (final ILocationInResource location : locations) {
        ITextRegionWithLineInformation _textRegion_1 = location.getTextRegion();
        boolean _equals = Objects.equal(_textRegion_1, expectedRegion);
        if (_equals) {
          return;
        }
      }
      Assert.fail(((("locations did not match expectation: " + locations) + " / ") + expectedRegion));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public AbstractTraceRegion merge(final List<AbstractTraceRegion> regions) {
    boolean _isEmpty = regions.isEmpty();
    boolean _not = (!_isEmpty);
    Assert.assertTrue(_not);
    int _size = regions.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      ITextRegionWithLineInformation rootLocation = ITextRegionWithLineInformation.EMPTY_REGION;
      ITextRegionWithLineInformation associated = ITextRegionWithLineInformation.EMPTY_REGION;
      for (final AbstractTraceRegion child : regions) {
        {
          int _myOffset = child.getMyOffset();
          int _myLength = child.getMyLength();
          int _myLineNumber = child.getMyLineNumber();
          int _myEndLineNumber = child.getMyEndLineNumber();
          TextRegionWithLineInformation _textRegionWithLineInformation = new TextRegionWithLineInformation(_myOffset, _myLength, _myLineNumber, _myEndLineNumber);
          ITextRegionWithLineInformation _merge = rootLocation.merge(_textRegionWithLineInformation);
          rootLocation = _merge;
          ILocationData childAssociation = child.getMergedAssociatedLocation();
          boolean _notEquals = (!Objects.equal(childAssociation, null));
          if (_notEquals) {
            ITextRegionWithLineInformation _merge_1 = associated.merge(childAssociation);
            associated = _merge_1;
          }
        }
      }
      final RootTraceRegionForTesting root = new RootTraceRegionForTesting(rootLocation, associated);
      for (final AbstractTraceRegion child_1 : regions) {
        child_1.setParent(root);
      }
      return root;
    } else {
      return IterableExtensions.<AbstractTraceRegion>head(regions);
    }
  }
}
