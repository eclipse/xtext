package org.eclipse.xtend.core.tests.javaconverter;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class JavaConverterTest extends AbstractXtendTestCase {
  @Inject
  private Provider<JavaConverter> javaConverterProvider;
  
  protected JavaConverter j2x;
  
  protected static boolean DUMP = true;
  
  @Before
  public void setUp() {
    JavaConverter _get = this.javaConverterProvider.get();
    this.j2x = _get;
  }
  
  @Test
  public void testSimpleCalssDeclarationCase() throws Exception {
    String javaCode = "package pack; import java.lang.Object; public class JavaToConvert<T,U> {}";
    XtendFile xtendFile = this.toValidXtendFile("pack/JavaToConvert", javaCode);
    String _package = xtendFile.getPackage();
    Assert.assertEquals("pack", _package);
    XImportSection _importSection = xtendFile.getImportSection();
    EList<XImportDeclaration> _importDeclarations = _importSection.getImportDeclarations();
    XImportDeclaration _get = _importDeclarations.get(0);
    String _importedName = _get.getImportedName();
    Assert.assertEquals("java.lang.Object", _importedName);
    EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
    XtendTypeDeclaration typeDeclaration = _xtendTypes.get(0);
    String _name = typeDeclaration.getName();
    Assert.assertEquals("JavaToConvert", _name);
    Assert.assertTrue("Compiles to class", (typeDeclaration instanceof XtendClass));
    XtendClass xtendClass = ((XtendClass) typeDeclaration);
    JvmVisibility _visibility = xtendClass.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    boolean _isFinal = xtendClass.isFinal();
    Assert.assertFalse("Non Final", _isFinal);
    boolean _isStatic = xtendClass.isStatic();
    Assert.assertFalse("Non Static", _isStatic);
    EList<JvmTypeParameter> _typeParameters = xtendClass.getTypeParameters();
    JvmTypeParameter _get_1 = _typeParameters.get(0);
    String _simpleName = _get_1.getSimpleName();
    Assert.assertEquals("T", _simpleName);
    EList<JvmTypeParameter> _typeParameters_1 = xtendClass.getTypeParameters();
    JvmTypeParameter _get_2 = _typeParameters_1.get(1);
    String _simpleName_1 = _get_2.getSimpleName();
    Assert.assertEquals("U", _simpleName_1);
  }
  
  @Test
  public void testSimpleInterfaceDeclarationCase() throws Exception {
    String javaCode = "public interface JavaToConvert<T> {}";
    XtendInterface xtendInterface = this.toValidXtendInterface(javaCode);
    boolean _isFinal = xtendInterface.isFinal();
    Assert.assertFalse("Non Final", _isFinal);
    boolean _isStatic = xtendInterface.isStatic();
    Assert.assertFalse("Non Static", _isStatic);
  }
  
  @Test
  public void testFieldDeclarationCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "public class JavaToConvert { private String str = \"myString\";}");
    EList<XtendMember> members = xtendClazz.getMembers();
    int _size = members.size();
    Assert.assertEquals("Simple fields count", 1, _size);
    XtendMember _get = members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    JvmVisibility _visibility = xtendMember.getVisibility();
    Assert.assertEquals(JvmVisibility.PRIVATE, _visibility);
    JvmTypeReference _type = xtendMember.getType();
    String _simpleName = _type.getSimpleName();
    Assert.assertEquals("String", _simpleName);
    String _name = xtendMember.getName();
    Assert.assertEquals("str", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    String _value = ((XStringLiteral) _initialValue).getValue();
    Assert.assertEquals("myString", _value);
  }
  
  @Test
  public void testFieldVisibility() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class JavaToConvert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String priv;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String pub;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String prot;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String def;");
    _builder.newLine();
    _builder.append("}");
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    this.checkVisibility(xtendClazz);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class JavaToConvert2 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("private static String priv;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public static String pub;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected static String prot;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("static String def;");
    _builder_1.newLine();
    _builder_1.append("}");
    XtendClass _validXtendClass = this.toValidXtendClass(_builder_1);
    xtendClazz = _validXtendClass;
    this.checkVisibility(xtendClazz);
  }
  
  private void checkVisibility(final XtendClass xtendClazz) {
    EList<XtendMember> _members = xtendClazz.getMembers();
    int _size = _members.size();
    Assert.assertEquals("Simple fields count", 4, _size);
    XtendField xtendMember = this.field(xtendClazz, 0);
    String _name = xtendMember.getName();
    Assert.assertEquals("priv", _name);
    JvmVisibility _visibility = xtendMember.getVisibility();
    Assert.assertEquals("field PRIVATE visibility", JvmVisibility.PRIVATE, _visibility);
    JvmTypeReference _type = xtendMember.getType();
    String _simpleName = _type.getSimpleName();
    Assert.assertEquals("String", _simpleName);
    XtendField _field = this.field(xtendClazz, 1);
    xtendMember = _field;
    String _name_1 = xtendMember.getName();
    Assert.assertEquals("pub", _name_1);
    JvmVisibility _visibility_1 = xtendMember.getVisibility();
    Assert.assertEquals("field public visibility", JvmVisibility.PUBLIC, _visibility_1);
    JvmTypeReference _type_1 = xtendMember.getType();
    String _simpleName_1 = _type_1.getSimpleName();
    Assert.assertEquals("String", _simpleName_1);
    XtendField _field_1 = this.field(xtendClazz, 2);
    xtendMember = _field_1;
    String _name_2 = xtendMember.getName();
    Assert.assertEquals("prot", _name_2);
    JvmVisibility _visibility_2 = xtendMember.getVisibility();
    Assert.assertEquals("field PROTECTED visibility", JvmVisibility.PROTECTED, _visibility_2);
    JvmTypeReference _type_2 = xtendMember.getType();
    String _simpleName_2 = _type_2.getSimpleName();
    Assert.assertEquals("String", _simpleName_2);
    XtendField _field_2 = this.field(xtendClazz, 3);
    xtendMember = _field_2;
    String _name_3 = xtendMember.getName();
    Assert.assertEquals("def", _name_3);
    JvmVisibility _visibility_3 = xtendMember.getVisibility();
    Assert.assertEquals("field DEFAULT visibility", JvmVisibility.DEFAULT, _visibility_3);
    JvmTypeReference _type_3 = xtendMember.getType();
    String _simpleName_3 = _type_3.getSimpleName();
    Assert.assertEquals("String", _simpleName_3);
  }
  
  @Test
  public void testFieldVisibility1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public interface JavaToConvert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static String pub;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final String fin;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static String def;");
    _builder.newLine();
    _builder.append("}");
    final XtendInterface interfaze = this.toValidXtendInterface(_builder.toString());
    XtendField _field = this.field(interfaze, 0);
    JvmVisibility _visibility = _field.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    XtendField _field_1 = this.field(interfaze, 1);
    JvmVisibility _visibility_1 = _field_1.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
    XtendField _field_2 = this.field(interfaze, 2);
    JvmVisibility _visibility_2 = _field_2.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_2);
  }
  
  @Test
  public void testOverrideMethodeDeclarationCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "public class JavaToConvert {  @Override public String toString() {} }");
    EList<XtendMember> _members = xtendClazz.getMembers();
    int _size = _members.size();
    Assert.assertEquals("Simple methods count", 1, _size);
    XtendFunction xtendMember = this.method(xtendClazz, 0);
    JvmVisibility _visibility = xtendMember.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    boolean _isOverride = xtendMember.isOverride();
    Assert.assertTrue(_isOverride);
    JvmTypeReference _returnType = xtendMember.getReturnType();
    String _simpleName = _returnType.getSimpleName();
    Assert.assertEquals("String", _simpleName);
    String _name = xtendMember.getName();
    Assert.assertEquals("toString", _name);
  }
  
  @Test
  public void testMethodDeclarationCase() throws Exception {
    final String java = "public class JavaToConvert { public boolean visit(final Object node) throws Error, Exception { return true;}}";
    XtendClass xtendClazz = this.toValidXtendClass(java);
    EList<XtendMember> _members = xtendClazz.getMembers();
    int _size = _members.size();
    Assert.assertEquals("Simple methods count", 1, _size);
    XtendFunction xtendMember = this.method(xtendClazz, 0);
    JvmVisibility _visibility = xtendMember.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    JvmTypeReference _returnType = xtendMember.getReturnType();
    String _simpleName = _returnType.getSimpleName();
    Assert.assertEquals("boolean", _simpleName);
    String _name = xtendMember.getName();
    Assert.assertEquals("visit", _name);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class JavaToConvert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean visit(Object node) throws Error, Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return true ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    String _string = _builder.toString();
    String _xtendCode = this.toXtendCode(java);
    Assert.assertEquals(_string, _xtendCode);
  }
  
  @Test
  public void testNonFinalMethodParameterCase_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class JavaToConvert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean visit(Object node, Object node2, int[] array, int[] array2, String... varArgs) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("node = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("node2 = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("array[0] = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("array2 = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("varArgs = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    XtendFunction xtendMember = this.method(xtendClazz, 0);
    JvmVisibility _visibility = xtendMember.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    EList<XtendParameter> _parameters = xtendMember.getParameters();
    XtendParameter _get = _parameters.get(0);
    String _name = _get.getName();
    Assert.assertEquals("node_finalParam_", _name);
    EList<XtendParameter> _parameters_1 = xtendMember.getParameters();
    XtendParameter _get_1 = _parameters_1.get(1);
    String _name_1 = _get_1.getName();
    Assert.assertEquals("node2_finalParam_", _name_1);
    EList<XtendParameter> _parameters_2 = xtendMember.getParameters();
    XtendParameter _get_2 = _parameters_2.get(2);
    String _name_2 = _get_2.getName();
    Assert.assertEquals("array", _name_2);
    EList<XtendParameter> _parameters_3 = xtendMember.getParameters();
    XtendParameter _get_3 = _parameters_3.get(3);
    String _name_3 = _get_3.getName();
    Assert.assertEquals("array2_finalParam_", _name_3);
    EList<XtendParameter> _parameters_4 = xtendMember.getParameters();
    XtendParameter _get_4 = _parameters_4.get(4);
    String _name_4 = _get_4.getName();
    Assert.assertEquals("varArgs_finalParam_", _name_4);
  }
  
  @Test
  public void testNonFinalMethodParameterCase_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test {void foo(int x) { x++; }}");
    final XtendClass xtendClass = this.toValidXtendClass(_builder);
    Assert.assertNotNull(xtendClass);
  }
  
  @Test
  public void testBasicForStatementCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Iterator;");
    _builder.newLine();
    _builder.append("public class JavaToConvert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("StringBuffer fBuffer=null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void visit(Node node) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.fBuffer.append(\"{\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (Iterator<Statement> it= node.statements().iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Statement s= it.next();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("s.accept(this);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.fBuffer.append(\"}\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("interface Node {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Iterable statements();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("interface Statement {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("void accept(JavaToConvert v); ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    EList<XtendMember> members = xtendClazz.getMembers();
    int _size = members.size();
    Assert.assertEquals("Simple methods count", 4, _size);
    XtendFunction xtendMember = this.method(xtendClazz, 1);
    JvmVisibility _visibility = xtendMember.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    JvmTypeReference _returnType = xtendMember.getReturnType();
    String _simpleName = _returnType.getSimpleName();
    Assert.assertEquals("void", _simpleName);
    String _name = xtendMember.getName();
    Assert.assertEquals("visit", _name);
  }
  
  @Test
  public void testBasicForStatementCase_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class JavaToConvert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void visit() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (int a = 1, b = 2; true; a++) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.toValidXtendClass(_builder);
  }
  
  @Test
  public void testBasicForStatementCase_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class JavaToConvert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void visit() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (final int a = 1, b = 2; true; ) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.toValidXtendClass(_builder);
  }
  
  @Test
  public void testBasicForStatementCase_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class JavaToConvert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void visit() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (val int a=1, val int b=2; true; ) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    String _string = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class JavaToConvert {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void visit() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("for (final int a = 1, b = 2; true; ) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    String _xtendCode = this.toXtendCode(_builder_1);
    Assert.assertEquals(_string, _xtendCode);
  }
  
  @Test
  public void testBasicForStatementCase_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class JavaToConvert {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public void visit() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for(char c=0; c<10; ++c) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String javaCode = _builder.toString();
    this.toValidXtendClass(javaCode);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class JavaToConvert {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void visit() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("for (var char c=(0) as char; c < 10; {c=(c + 1) as char}) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    String _xtendCode = this.toXtendCode(javaCode);
    Assert.assertEquals(_string, _xtendCode);
  }
  
  @Test
  public void testExtendedForStatementCase_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("public class JavaToConvert {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void visit(List<?> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (final Object o:list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.toValidXtendClass(_builder);
  }
  
  @Test
  public void testOverride() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Iterator;");
    _builder.newLine();
    _builder.append("public class JavaToConvert implements Statement {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Iterable statements() { return null;} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String toString() { return null;} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void accept(JavaToConvert v){}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public <DH> Iterator<DH> doAnonymousClass() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Iterator<DH>() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public int hashCode() {return super.hashCode();}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public boolean hasNext() { return true;}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public DH next() { return null;}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public void remove() {}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface Node {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Iterable statements();");
    _builder.newLine();
    _builder.append("} ");
    _builder.newLine();
    _builder.append("interface Statement extends Node {");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("void accept(JavaToConvert v);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    EList<XtendMember> members = xtendClazz.getMembers();
    int _size = members.size();
    Assert.assertEquals("Simple methods count", 4, _size);
    XtendFunction _method = this.method(xtendClazz, 0);
    boolean _isOverride = _method.isOverride();
    Assert.assertTrue(_isOverride);
    XtendFunction _method_1 = this.method(xtendClazz, 1);
    boolean _isOverride_1 = _method_1.isOverride();
    Assert.assertTrue(_isOverride_1);
    XtendFunction _method_2 = this.method(xtendClazz, 2);
    boolean _isOverride_2 = _method_2.isOverride();
    Assert.assertTrue(_isOverride_2);
    XtendFunction _method_3 = this.method(xtendClazz, 3);
    boolean _isOverride_3 = _method_3.isOverride();
    Assert.assertFalse(_isOverride_3);
  }
  
  @Test
  public void testStringLiteralCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass("class TestStringLiteral { \n\t\t\t\tString withLineWrap=\"string with wrap\\n\";\n\t\t\t\tString str2 = new String(\"\\1\\2\\3\");\n\t\t\t}");
    XtendField xtendMember = this.field(xtendClazz, 0);
    String _name = xtendMember.getName();
    Assert.assertEquals("withLineWrap", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    String _value = ((XStringLiteral) _initialValue).getValue();
    Assert.assertEquals("string with wrap\n", _value);
  }
  
  @Test
  public void testNumberLiteralCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestStringLiteral {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("long l= 0x0000000000000000L;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("double d= 2.5d;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("long l2= 0x000000000000A;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("long l3= 0x000000000000B;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("long l4= 0x000000000000c;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("long l5= 0x000000000000d;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("long l6= 0x000000000000e;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("long l7= 0x000000000000f;");
    _builder.newLine();
    _builder.append("}");
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    XtendField xtendMember = this.field(xtendClazz, 0);
    String _name = xtendMember.getName();
    Assert.assertEquals("l", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    String _value = ((XNumberLiteral) _initialValue).getValue();
    Assert.assertEquals("0x0000000000000000#L", _value);
    XtendField _field = this.field(xtendClazz, 1);
    xtendMember = _field;
    String _name_1 = xtendMember.getName();
    Assert.assertEquals("d", _name_1);
    XExpression _initialValue_1 = xtendMember.getInitialValue();
    String _value_1 = ((XNumberLiteral) _initialValue_1).getValue();
    Assert.assertEquals("2.5d", _value_1);
  }
  
  @Test
  public void testNumberLiteralCase2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestStringLiteral {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("long l= 0x598df91c;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("double d = 0x43p-43;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("float f = 0x43p-43f;");
    _builder.newLine();
    _builder.append("}");
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    XtendField xtendMember = this.field(xtendClazz, 0);
    String _name = xtendMember.getName();
    Assert.assertEquals("l", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    String _value = ((XNumberLiteral) _initialValue).getValue();
    Assert.assertEquals("0x598df91c", _value);
    XtendField _field = this.field(xtendClazz, 1);
    xtendMember = _field;
    String _name_1 = xtendMember.getName();
    Assert.assertEquals("d", _name_1);
    XExpression _initialValue_1 = xtendMember.getInitialValue();
    String _value_1 = ((XNumberLiteral) _initialValue_1).getValue();
    Assert.assertEquals("7.617018127348274E-12", _value_1);
    XtendField _field_1 = this.field(xtendClazz, 2);
    xtendMember = _field_1;
    String _name_2 = xtendMember.getName();
    Assert.assertEquals("f", _name_2);
    XExpression _initialValue_2 = xtendMember.getInitialValue();
    String _value_2 = ((XNumberLiteral) _initialValue_2).getValue();
    Assert.assertEquals("7.617018E-12f", _value_2);
  }
  
  @Test
  public void testSimpleTypeParameterCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class TestTypeParameter <T,U extends T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<D extends T>  T doStuff(Iterable<? super U> us, Iterable<? extends D> d, T t) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    EList<JvmTypeParameter> _typeParameters = xtendClazz.getTypeParameters();
    JvmTypeParameter typeParameter = _typeParameters.get(0);
    String _name = typeParameter.getName();
    Assert.assertEquals("T", _name);
    EList<JvmTypeParameter> _typeParameters_1 = xtendClazz.getTypeParameters();
    JvmTypeParameter _get = _typeParameters_1.get(1);
    typeParameter = _get;
    String _name_1 = typeParameter.getName();
    Assert.assertEquals("U", _name_1);
    EList<JvmTypeConstraint> _constraints = typeParameter.getConstraints();
    JvmTypeConstraint _get_1 = _constraints.get(0);
    String _simpleName = _get_1.getSimpleName();
    Assert.assertEquals("extends T", _simpleName);
    XtendFunction xtendMember = this.method(xtendClazz, 0);
    String _name_2 = xtendMember.getName();
    Assert.assertEquals("doStuff", _name_2);
    EList<JvmTypeParameter> _typeParameters_2 = xtendMember.getTypeParameters();
    JvmTypeParameter _get_2 = _typeParameters_2.get(0);
    typeParameter = _get_2;
    String _name_3 = typeParameter.getName();
    Assert.assertEquals("D", _name_3);
    EList<JvmTypeConstraint> _constraints_1 = typeParameter.getConstraints();
    JvmTypeConstraint _get_3 = _constraints_1.get(0);
    String _simpleName_1 = _get_3.getSimpleName();
    Assert.assertEquals("extends T", _simpleName_1);
  }
  
  @Test
  public void testSimpleAssigmentCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass("class TestAssiment {  \n\t\t\t\tvoid doStuff() {\n\t\t\t\t\tString x = null;\n\t\t\t\t\tx = new String();\n\t\t\t\t}\n\t\t\t}");
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testMultiDeclaration() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass("class Test { \n\t\t\t\tint i,j=0;\n\t\t\t\tvoid doStuff() {\n\t\t\t\t\tString x,y = null;\n\t\t\t\t}\n\t\t\t}");
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testAssertCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass("class Test {  \n\t\t\t\tvoid doStuff() {\n\t\t\t\t\tString x = null;\n\t\t\t\t\tassert(x!=null);\n\t\t\t\t}\n\t\t\t}");
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testSimpleInstanceOfCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "class Test {  void doStuff() { String x = null; if(!(x instanceof String)) x = \"\";}");
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testCommentsCase_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append("* javadoc");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class TestComment {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* ML */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private int i = 1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//singleline");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("multiline");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void doStuff2() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/* some comments */");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return; // rt SL comment");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    String xtendCode = this.toXtendCode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/** ");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* javadoc");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("class TestComment {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/* ML */");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("int i=1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("//singleline");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def package void doStuff() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append("\t\t ");
    _builder_1.append("multiline");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/**/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def package void doStuff2() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("/* some comments */");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return;// rt SL comment");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    final String expected = _builder_1.toString();
    Assert.assertEquals(expected, xtendCode);
  }
  
  @Test
  public void testCommentsCase_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class TestComment {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String field = \"d\"; // last SL comment");
    _builder.newLine();
    _builder.append("}");
    String xtendCode = this.toXtendCode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class TestComment {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("package String field=\"d\"// last SL comment");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    final String expected = _builder_1.toString();
    Assert.assertEquals(expected, xtendCode);
  }
  
  @Test
  public void testJavadocCase_01() throws Exception {
    JavaConverter.ConversionResult _bodyDeclarationToXtend = this.j2x.bodyDeclarationToXtend("/**@param p Param p*/public abstract void foo();", null, 
      null);
    String xtendCode = _bodyDeclarationToXtend.getXtendCode();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Javadoc Parameter well formed: ");
    _builder.append(xtendCode, "");
    boolean _contains = xtendCode.contains("@param p Param p");
    Assert.assertTrue(_builder.toString(), _contains);
  }
  
  @Test
  public void testJavadocCase_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright (c) 2015 - javadocteststring");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("**/");
    _builder.newLine();
    _builder.append("package foo.javadoc;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Simple value");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @author Dennis Huebner - Initial contribution and API");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class TestJavadoc {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String xtendCode = this.toXtendCode(_builder);
    this.dump(xtendCode);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Classfile Doc not copied");
    boolean _contains = xtendCode.contains("javadocteststring");
    Assert.assertTrue(_builder_1.toString(), _contains);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("Classfile Doc copied once");
    Splitter _on = Splitter.on("javadocteststring");
    Iterable<String> _split = _on.split(xtendCode);
    int _size = IterableExtensions.size(_split);
    Assert.assertEquals(_builder_2.toString(), 2, _size);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("Type Javadoc not copied");
    boolean _contains_1 = xtendCode.contains("@author");
    Assert.assertTrue(_builder_3.toString(), _contains_1);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("Type Javadoc not copied once");
    Splitter _on_1 = Splitter.on("@author");
    Iterable<String> _split_1 = _on_1.split(xtendCode);
    int _size_1 = IterableExtensions.size(_split_1);
    Assert.assertEquals(_builder_4.toString(), 2, _size_1);
  }
  
  @Test
  public void testJavadocCase_03() throws Exception {
    JavaConverter.ConversionResult _bodyDeclarationToXtend = this.j2x.bodyDeclarationToXtend("public abstract void foo() { /** orphaned javadoc */ };", null, null);
    String xtendCode = _bodyDeclarationToXtend.getXtendCode();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Javadoc Parameter well formed: ");
    _builder.append(xtendCode, "");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("def abstract void foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("/** ");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("* orphaned javadoc ");
    _builder_1.newLine();
    _builder_1.append("\t ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    Assert.assertEquals(_builder.toString(), _string, xtendCode);
  }
  
  @Test
  public void testCastCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "public class TestCast { void doStuff() { Object o = (Object)this;}");
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testIfElseCase_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class TestCast {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Object o=null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String it = (o==null)?\"true\":\"false\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String other = it;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public void fooo() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.it = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testIfElseCase_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var Class<?> c=String ");
    _builder.newLine();
    _builder.append("if (c instanceof Class) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c=null ");
    _builder.newLine();
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c=Boolean ");
    _builder.newLine();
    _builder.append("}");
    String _string = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Class<?> c = String.class;");
    _builder_1.newLine();
    _builder_1.append("if(c instanceof Class) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("c = null;");
    _builder_1.newLine();
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("c = Boolean.class;");
    _builder_1.newLine();
    _builder_1.append("}");
    String _xtendStatement = this.toXtendStatement(_builder_1);
    Assert.assertEquals(_string, _xtendStatement);
  }
  
  @Test
  public void testStaticImportCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "import static java.awt.AWTEvent.*; public class Test { long o= ACTION_EVENT_MASK;}");
    EList<XtendMember> _members = xtendClazz.getMembers();
    XtendMember _get = _members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("o", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    XFeatureCall xFeatureCall = ((XFeatureCall) _initialValue);
    JvmIdentifiableElement _feature = xFeatureCall.getFeature();
    String _simpleName = _feature.getSimpleName();
    Assert.assertEquals("ACTION_EVENT_MASK", _simpleName);
  }
  
  @Test
  public void testStaticAccessCase() throws Exception {
    this.j2x.useRobustSyntax();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Test2 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("URI getURI(){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int i = URI.FRAGMENT_FIRST_SEPARATOR;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if(URI.FRAGMENT_FIRST_SEPARATOR==0) return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return URI.createURI(\"myURI\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class URI {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static int FRAGMENT_FIRST_SEPARATOR=0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static URI createURI(String str) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return (URI)null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    XtendFunction xtendMember = this.method(xtendClazz, 0);
    String _name = xtendMember.getName();
    Assert.assertEquals("getURI", _name);
  }
  
  @Test
  public void testStaticAccessCase2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.append("import java.util.Map.Entry;");
    _builder.newLine();
    _builder.append("public abstract class Test implements Map.Entry<String,String>{}");
    _builder.newLine();
    XtendClass xtendClazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testInnerClassCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class Inner {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void inMeth() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class OuterImpl extends Outer {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    JavaConverter.ConversionResult conversionResult = this.j2x.toXtend("Clazz", _builder.toString());
    String xtendCode = conversionResult.getXtendCode();
    boolean _isEmpty = xtendCode.isEmpty();
    Assert.assertFalse(_isEmpty);
    Iterable<String> _problems = conversionResult.getProblems();
    int _size = Iterables.size(_problems);
    Assert.assertEquals(2, _size);
  }
  
  @Test
  public void testInnerIntefaceCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("interface Inner {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("void test();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface Test{}");
    XtendClass type = this.toValidXtendClass(_builder);
    EList<XtendMember> _members = type.getMembers();
    final XtendMember inner = _members.get(0);
    Assert.assertTrue((inner instanceof XtendInterface));
    final XtendInterface xtendInterfaze = ((XtendInterface) inner);
    JvmVisibility _visibility = xtendInterfaze.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    XtendFunction _method = this.method(xtendInterfaze, 0);
    JvmVisibility _visibility_1 = _method.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
  }
  
  @Test
  public void testStaticBlockCase() throws Exception {
    XtendClass conversionResult = this.toValidXtendClass("public class Clazz { static String foo;static{foo=\"\";}}");
    XtendField _field = this.field(conversionResult, 0);
    String _name = _field.getName();
    Assert.assertEquals("foo", _name);
  }
  
  @Test
  public void testStaticBlockCase1() throws Exception {
    JavaConverter.ConversionResult conversionResult = this.j2x.toXtend("Clazz", 
      "public class Clazz { static final String foo;static{foo=\"\";}}");
    String xtendCode = conversionResult.getXtendCode();
    boolean _isEmpty = xtendCode.isEmpty();
    Assert.assertFalse(_isEmpty);
    this.dump(xtendCode);
    Iterable<String> _problems = conversionResult.getProblems();
    int _size = Iterables.size(_problems);
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testStaticBlockCase2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final String foo=null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String foo;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo = \"bar\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//Clazz.foo = \"\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendClass conversionResult = this.toValidXtendClass(_builder);
    XtendField _field = this.field(conversionResult, 0);
    String _name = _field.getName();
    Assert.assertEquals("foo", _name);
  }
  
  @Test
  public void testStaticBlockCase3() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final String foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String foo;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo = \"bar\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Clazz.foo = \"\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    JavaConverter.ConversionResult conversionResult = this.j2x.toXtend("Clazz", _builder.toString());
    String xtendCode = conversionResult.getXtendCode();
    boolean _isEmpty = xtendCode.isEmpty();
    Assert.assertFalse(_isEmpty);
    this.dump(xtendCode);
    Iterable<String> _problems = conversionResult.getProblems();
    int _size = Iterables.size(_problems);
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testConstructorCase() throws Exception {
    XtendClass clazz = this.toValidXtendClass("public class Clazz { public Clazz(){this(1);}public Clazz(int i){}}");
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    JvmVisibility _visibility = ((XtendConstructor) _get).getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    EList<XtendMember> _members_1 = clazz.getMembers();
    XtendMember _get_1 = _members_1.get(1);
    JvmVisibility _visibility_1 = ((XtendConstructor) _get_1).getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
  }
  
  @Test
  public void testSuperCalls() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.awt.TextField;");
    _builder.newLine();
    _builder.append("public class Clazz extends TextField {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Clazz() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Clazz(String txt) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(txt);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String toString() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Object o = super.textListener;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return super.toString();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendClass clazz = this.toValidXtendClass(_builder);
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    JvmVisibility _visibility = ((XtendConstructor) _get).getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
  }
  
  @Test
  public void testEnumCase() throws Exception {
    XtendEnum enum_ = this.toValidXtendEnum("public enum MyEnum { NEW,OLD }");
    EList<XtendMember> _members = enum_.getMembers();
    XtendMember _get = _members.get(0);
    JvmVisibility _visibility = ((XtendEnumLiteral) _get).getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    EList<XtendMember> _members_1 = enum_.getMembers();
    XtendMember _get_1 = _members_1.get(1);
    JvmVisibility _visibility_1 = ((XtendEnumLiteral) _get_1).getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
  }
  
  @Test
  public void testEnumCase1() throws Exception {
    XtendClass enum_ = this.toValidXtendClass("public class MyClazz{\n\t \t\t\tenum MyEnum { NEW }\n\t\t\t}");
    EList<XtendMember> _members = enum_.getMembers();
    XtendMember _get = _members.get(0);
    JvmVisibility _visibility = ((XtendEnum) _get).getVisibility();
    Assert.assertEquals(JvmVisibility.DEFAULT, _visibility);
  }
  
  @Test
  public void testEnumNotSupportedCase() throws Exception {
    JavaConverter.ConversionResult enum_ = this.j2x.toXtend("MyEnum", "public enum MyEnum {\n\t\t\t\tNEW(1), OLD(2);\n\t\t\t\tprivate MyEnum(int value) {}\n\t\t\t}\n\t\t\t");
    Iterable<String> _problems = enum_.getProblems();
    int _size = IterableExtensions.size(_problems);
    Assert.assertEquals(3, _size);
  }
  
  @Test
  public void testEnumNotSupportedCase2() throws Exception {
    JavaConverter.ConversionResult enum_ = this.j2x.toXtend("MyEnum", "public enum MyEnum  implements Enumerator {\n\t\t\t\tNEW\n\t\t\t}\n\t\t\t");
    Iterable<String> _problems = enum_.getProblems();
    int _size = IterableExtensions.size(_problems);
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testEnumNotSupportedCase3() throws Exception {
    JavaConverter.ConversionResult enum_ = this.j2x.toXtend("MyClazz", "public class MyClazz{\n\t \t\t\tenum MyEnum implements Enumerator{ NEW }\n\t\t\t}\n\t\t\t");
    Iterable<String> _problems = enum_.getProblems();
    int _size = IterableExtensions.size(_problems);
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testArrayAccessCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String foo(String... strAr) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(strAr[0] + \"\"); ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String a = (strAr[0] =\"2\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("strAr[1]=a;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("a=strAr[0]+strAr[1];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return strAr[i++]=\"\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testArrayAccessCaseConstantIndex_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("String[] ar = new String[]{};");
    _builder.newLine();
    _builder.append("String n = ar[1];");
    _builder.newLine();
    String xtendCode = this.toXtendStatement(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var String[] ar=#[] ");
    _builder_1.newLine();
    _builder_1.append("var String n=ar.get(1)");
    String _string = _builder_1.toString();
    Assert.assertEquals(_string, xtendCode);
  }
  
  @Test
  public void testArrayAccessCaseConstantIndex_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("String[] ar = new String[]{};");
    _builder.newLine();
    _builder.append("ar[1] = null;");
    _builder.newLine();
    String xtendCode = this.toXtendStatement(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var String[] ar=#[] ");
    _builder_1.newLine();
    _builder_1.append("{ val _wrVal_ar=ar _wrVal_ar.set(1,null)}");
    String _string = _builder_1.toString();
    Assert.assertEquals(_string, xtendCode);
  }
  
  @Test
  public void testArrayCreationCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Arrays");
    _builder.newLine();
    _builder.append("import java.util.HashSet");
    _builder.newLine();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int as[] = new int[1];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// int[] as2;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// int[][] as4;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// int[] as5 = as;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] as2,as4[],as5 = as[];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final int callCount[] = new int[]{0};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("byte[] buffer = new byte[512];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String[] arr = new String[]{\"\",\"\"};");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Class<?>[] argTypes = new Class[arr.length];");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testArrayCreationCase2() throws Exception {
    this.j2x.useRobustSyntax();
    String xtendCode = this.toXtendClassBodyDeclr(
      "private List<String> l=Arrays.asList(new String[] { \"AType\", \"RootRule\" });");
    Assert.assertEquals("List<String> l=Arrays.asList((#[\"AType\", \"RootRule\"] as String[]))", xtendCode);
  }
  
  @Test
  public void testArrayShiftDimensionCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private int ar[] = new int[1];");
    _builder.newLine();
    _builder.append("public void arDim() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int ar2[] = new int[2];");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String xtendCode = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("int[] ar=newIntArrayOfSize(1)");
    _builder_1.newLine();
    _builder_1.append("def void arDim() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("var int[] ar2=newIntArrayOfSize(2) ");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(xtendCode);
    Assert.assertEquals(_string, _xtendClassBodyDeclr);
  }
  
  @Test
  public void testArrayPrefixMinusCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i =3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int[] ints = new int[]{1,2,3,4,5};");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.print(\"2=\"+(--ints[--i]));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testArrayDimensionOnFragmentAsParameter() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String sa[];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static main(String args[]) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i[] = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testPrefixPlusMinusCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i=3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.print(\"4=\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(++i);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.print(\"3=\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(--i);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testPrefixPlusMinusSimpleArrayCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int[] ints = new int[]{1,2,40,44,5,6,7};");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int in = 3;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("System.out.println(\"44=\"+(ints[in]++));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("System.out.println(\"45=\"+(ints[in]--));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("System.out.println(\"43=\"+(--ints[in]));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("System.out.println(\"44=\"+(++ints[in]));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testPrefixPlusMinusArrayCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int[] ints = new int[]{1,2,3,4,5};");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int in = 2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"3=\"+(ints[in++]++));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"4=\"+(ints[in--]--));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"1=\"+(--ints[--in]));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"5=\"+(++ints[++in]));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testPostfixArrayAccess() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private int ar[] = new int[1];");
    _builder.newLine();
    _builder.append("public void arPostReturn() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.println(ar[0]++);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public void arPostNoReturn() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ar[0]++;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String javaCode = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("int[] ar=newIntArrayOfSize(1)");
    _builder_1.newLine();
    _builder_1.append("def void arPostReturn() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("System.out.println({ var _postIndx_ar=0 var  _postVal_ar={val _rdIndx_ar=_postIndx_ar ar.get(_rdIndx_ar)}{ val _wrVal_ar=ar val _wrIndx_ar=_postIndx_ar _wrVal_ar.set(_wrIndx_ar,_postVal_ar + 1)}_postVal_ar }) ");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("def void arPostNoReturn() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("{ var _postIndx_ar=0 var  _postVal_ar={val _rdIndx_ar=_postIndx_ar ar.get(_rdIndx_ar)}{ val _wrVal_ar=ar val _wrIndx_ar=_postIndx_ar _wrVal_ar.set(_wrIndx_ar,_postVal_ar + 1)} } ");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(javaCode);
    Assert.assertEquals(_string, _xtendClassBodyDeclr);
  }
  
  @Test
  public void testRichStringCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static int i = 2;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static String a = (i-i)+i+\"4=\"+(--i)+\"1=\"+(i++)+i;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static String b =\"4=\"+\"1=\";");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(1);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("a", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    Assert.assertTrue((_initialValue instanceof RichString));
    EList<XtendMember> _members_1 = clazz.getMembers();
    XtendMember _get_1 = _members_1.get(2);
    XExpression _initialValue_1 = ((XtendField) _get_1).getInitialValue();
    Assert.assertTrue((_initialValue_1 instanceof RichString));
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr("static String a = (i-i)+i+\"4=\"+(--i)+\"1=\"+(i++)+i;");
    Assert.assertEquals("static package String a=\'\'\'«(i - i)»«i»4=«({i=i - 1})»1=«(i++)»«i»\'\'\'", _xtendClassBodyDeclr);
  }
  
  @Test
  public void testRichStringCase1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private int i = 0;");
    _builder.newLine();
    _builder.append("private String richTxt = \"int \"+\"i=\"+i+\".\";");
    _builder.newLine();
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(_builder);
    Assert.assertEquals("int i=0\nString richTxt=\'\'\'int i=«i».\'\'\'", _xtendClassBodyDeclr);
  }
  
  @Test
  public void testRichStringCase2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("String str = \"Step: \" + info + \" memory: free / total / max MB \" + runtime.freeMemory() / (1000 * 1000) + \" / \" + runtime.totalMemory() / (1000 * 1000) + \" / \" + runtime.maxMemory() / (1000 * 1000)");
    _builder.newLine();
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(_builder);
    Assert.assertEquals(
      "package String str=\'\'\'Step: «info» memory: free / total / max MB «runtime.freeMemory() / (1000 * 1000)» / «runtime.totalMemory() / (1000 * 1000)» / «runtime.maxMemory() / (1000 * 1000)»\'\'\'", _xtendClassBodyDeclr);
  }
  
  @Test
  public void testRichStringCase3() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("static String a = \"first line\\n\"+\"second line\\n\"+\"third line\\n\"+\"fourth line\";");
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(_builder);
    Assert.assertEquals("static package String a=\'\'\'first line\nsecond line\nthird line\nfourth line\'\'\'", _xtendClassBodyDeclr);
  }
  
  @Test
  public void testRichStringCase4() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public String someVar=\".\";");
    _builder.newLine();
    _builder.append("public String loadingURI = \"classpath:/\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("+ (someVar + \"LoadingResourceWithError\").replace(\'.\', \'/\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("+ \".xtexterror\";");
    _builder.newLine();
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(_builder);
    Assert.assertEquals(
      "public String someVar=\".\"\npublic String loadingURI=\'\'\'classpath:/«(\'\'\'«someVar»LoadingResourceWithError\'\'\').replace(Character.valueOf(\'.\').charValue, Character.valueOf(\'/\').charValue)».xtexterror\'\'\'", _xtendClassBodyDeclr);
  }
  
  @Test
  public void testRichStringSpecialCase() throws Exception {
    XtendClass clazz = this.toValidXtendClass(
      "class Z { String richTxt = \"a\" +\"\" +\"\'\" +\"s \" + \"\'\'\' no «\'foo\'.length» side-effect \'\'\'\";}");
    Assert.assertNotNull(clazz);
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("richTxt", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    Assert.assertFalse((_initialValue instanceof RichString));
  }
  
  @Test
  public void testRichStringSpecialCase2() throws Exception {
    XtendClass clazz = this.toValidXtendClass(
      (("class Z { String richTxt = \"test\" + \"\'\'\'«FOR a: \'123\'.toCharArray SEPARATOR \',\\n  \\t\'»\\n" + "a\\n") + 
        "«ENDFOR»\'\'\'\";}"));
    Assert.assertNotNull(clazz);
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("richTxt", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    Assert.assertFalse((_initialValue instanceof RichString));
  }
  
  @Test
  public void testRichStringSpecialCase3() throws Exception {
    XtendClass clazz = this.toValidXtendClass(
      "class Z {String richTxt = \"x(p1)} def dispatch x(int s) {\'int\'} def dispatch x(boolean s)\"+\" {\'boolean\'} def dispatch x(double s) {\'double\'\";}");
    Assert.assertNotNull(clazz);
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("richTxt", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    Assert.assertTrue((_initialValue instanceof RichString));
  }
  
  @Test
  public void testRichStringSpecialCase4() throws Exception {
    XtendInterface interfaze = this.toValidXtendInterface("interface Z {\n\t\t\t\tString CONSTANT_VAL = \"SOMEVALUE\" + \"ADDITION\";\n\t\t\t\tString CONSTANT_VAL2 = \"SOMEVALUE\" + CONSTANT_VAL;\n\t\t\t}");
    Assert.assertNotNull(interfaze);
    XtendField xtendMember = this.field(interfaze, 0);
    String _name = xtendMember.getName();
    Assert.assertEquals("CONSTANT_VAL", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    Assert.assertFalse((_initialValue instanceof RichString));
    XtendField _field = this.field(interfaze, 1);
    xtendMember = _field;
    String _name_1 = xtendMember.getName();
    Assert.assertEquals("CONSTANT_VAL2", _name_1);
    XExpression _initialValue_1 = xtendMember.getInitialValue();
    Assert.assertFalse((_initialValue_1 instanceof RichString));
  }
  
  @Test
  public void testReturnVoidCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Z {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void ret() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(true)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testReturnVoidCase_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def void foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (true) return else System.out.println() ");
    _builder.newLine();
    _builder.append("}");
    String _string = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public void foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("if(true) ");
    _builder_1.newLine();
    _builder_1.append("\t    ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("\t  ");
    _builder_1.append("else");
    _builder_1.newLine();
    _builder_1.append("\t    ");
    _builder_1.append("System.out.println();");
    _builder_1.newLine();
    _builder_1.append("}");
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(_builder_1);
    Assert.assertEquals(_string, _xtendClassBodyDeclr);
  }
  
  @Test
  public void testReturnCase_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(true) ");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("return \"s\";");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("return \"d\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    final String java = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def String foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (true) return \"s\"  else return \"d\" ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    String _xtendCode = this.toXtendCode(java);
    Assert.assertEquals(_string, _xtendCode);
    XtendClass _validXtendClass = this.toValidXtendClass(java);
    Assert.assertNotNull(_validXtendClass);
  }
  
  @Test
  public void testAnonymousClassCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.awt.event.ActionEvent;");
    _builder.newLine();
    _builder.append("import java.awt.event.ActionListener;");
    _builder.newLine();
    _builder.append("class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ActionListener listener = new ActionListener() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{/*not allowed*/}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public void actionPerformed(ActionEvent arg0) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("arg0.getID();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("}");
    JavaConverter.ConversionResult result = this.j2x.toXtend("Clazz", _builder.toString());
    Iterable<String> _problems = result.getProblems();
    int _size = IterableExtensions.size(_problems);
    Assert.assertEquals(_size, 1);
    Iterable<String> _problems_1 = result.getProblems();
    String _get = ((String[])Conversions.unwrapArray(_problems_1, String.class))[0];
    boolean _startsWith = _get.startsWith("Initializer is not supported in AnonymousClassDeclaration");
    Assert.assertTrue(_startsWith);
  }
  
  @Test
  public void testLambdaCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.awt.event.ActionEvent;");
    _builder.newLine();
    _builder.append("import java.awt.event.ActionListener;");
    _builder.newLine();
    _builder.append("class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ActionListener listener = new ActionListener() {");
    _builder.newLine();
    _builder.append("\t \t");
    _builder.append("public void actionPerformed(ActionEvent arg0) {");
    _builder.newLine();
    _builder.append("\t \t\t");
    _builder.append("arg0.getID();");
    _builder.newLine();
    _builder.append("\t \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("listener", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    Assert.assertTrue((_initialValue instanceof XClosure));
  }
  
  @Test
  public void testLambdaCase2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import com.google.common.base.Function;");
    _builder.newLine();
    _builder.append("import com.google.common.collect.Iterables;");
    _builder.newLine();
    _builder.append("class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final int callCount[] = new int[]{0};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object fun = Iterables.transform(new ArrayList<String>(), new Function<String, String>(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public String apply(String param) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("callCount[0]++;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}));");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
    XtendField xtendMember = this.field(clazz, 1);
    String _name = xtendMember.getName();
    Assert.assertEquals("fun", _name);
  }
  
  @Test
  public void testLambdaCase3() throws Exception {
    this.j2x.useRobustSyntax();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Iterator;");
    _builder.newLine();
    _builder.append("class Clazz {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Iterable<String> iter = new AbstractIterable<String>() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public Iterator<String> internalIterator() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("abstract static class AbstractIterable<T> implements Iterable<T> {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public Iterator<T> iterator() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return internalIterator();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public abstract Iterator<T> internalIterator();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
    XtendField xtendMember = this.field(clazz, 0);
    String _name = xtendMember.getName();
    Assert.assertEquals("iter", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    Assert.assertTrue((_initialValue instanceof XCastedExpression));
    XExpression _initialValue_1 = xtendMember.getInitialValue();
    XExpression _target = ((XCastedExpression) _initialValue_1).getTarget();
    Assert.assertTrue((_target instanceof XClosure));
  }
  
  @Test
  public void testSLCommentCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Single Line comment");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String str;");
    _builder.newLine();
    _builder.append("}");
    String clazz = this.toXtendCode(_builder);
    this.dump(clazz);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package class Clazz {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("//Single Line comment");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("package String str");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    Assert.assertEquals(_string, clazz);
  }
  
  @Test
  public void testSwitchCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private String doSwitch() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("switch (i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 1:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// switch int");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("i++");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return \"1\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case 2: {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return \"2\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return \"0\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    String clazz = this.toXtendClassBodyDeclr(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("def private String doSwitch() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("var int i=0 ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("switch (i) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("case 1:{");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("// switch int");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("i++ return \"1\" ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("case 2:{");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return \"2\" ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("default :{");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return \"0\" ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    Assert.assertEquals(_string, clazz);
  }
  
  @Test
  public void testSwitchCase2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class FooSwitch {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void doSwitch2() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (i) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 1:");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("i++;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 2: {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testSwitchCase3() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (1) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 1:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 2:");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("System.out.println();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 3: {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void doStuff2() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (1) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 1:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 2:");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("System.out.println();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 3:");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("System.out.println();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void doStuff3() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (1) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 1:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 2:");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("System.out.println();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 3:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder);
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testThrowExpressionCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("void foo(byte[] bytes) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (true) throw new RuntimeException();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bytes[1] = (byte) 2;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    final String java = _builder.toString();
    XtendClass clazz = this.toValidXtendClass(java);
    Assert.assertNotNull(clazz);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def package void foo(byte[] bytes) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (true) throw new RuntimeException();");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("{ val _wrVal_bytes=bytes _wrVal_bytes.set(1,2 as byte)} ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    String _xtendCode = this.toXtendCode(java);
    Assert.assertEquals(_string, _xtendCode);
  }
  
  @Test
  public void testXORExpressionCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class XorCase {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void doXorOperation() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("boolean b = true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(true ^ b) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(b ^ b) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(b ^ false) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int i = 1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (((1 ^ 2 ^ 4) + (i ^ 2) - (3 ^ i) ^ 2) > i) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    final String java = _builder.toString();
    XtendClass clazz = this.toValidXtendClass(java);
    Assert.assertNotNull(clazz);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class XorCase {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void doXorOperation() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var boolean b=true ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (true.xor(b)) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (b.xor(b)) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (b.xor(false)) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var int i=1 ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (((1.bitwiseXor(2).bitwiseXor(4)) + (i.bitwiseXor(2)) - (3.bitwiseXor(i)).bitwiseXor(2)) > i) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    String _xtendCode = this.toXtendCode(java);
    Assert.assertEquals(_string, _xtendCode);
  }
  
  @Test
  public void testFinalVariableEmptyInitializer() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("final List<String> values, values2=null, values3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("values = new ArrayList<String>();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    JavaConverter.ConversionResult conversionResult = this.j2x.toXtend("Foo", _builder.toString());
    String xtendCode = conversionResult.getXtendCode();
    boolean _isEmpty = xtendCode.isEmpty();
    Assert.assertFalse(_isEmpty);
    this.dump(xtendCode);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def protected void doStuff() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val List<String> values/* FIXME empty initializer for final variable is not supported */ val List<String> values2=null val List<String> values3/* FIXME empty initializer for final variable is not supported */ ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("values=new ArrayList<String>() ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    Assert.assertEquals(xtendCode, _string);
    Iterable<String> _problems = conversionResult.getProblems();
    int _size = Iterables.size(_problems);
    Assert.assertEquals(2, _size);
    Iterable<String> _problems_1 = conversionResult.getProblems();
    Object _get = ((Object[])Conversions.unwrapArray(_problems_1, Object.class))[0];
    Assert.assertEquals("Empty initializer for final variables is not supported. (start: 70, length: 6)", _get);
    Iterable<String> _problems_2 = conversionResult.getProblems();
    Object _get_1 = ((Object[])Conversions.unwrapArray(_problems_2, Object.class))[1];
    Assert.assertEquals("Empty initializer for final variables is not supported. (start: 92, length: 7)", _get_1);
  }
  
  @Test
  public void testIntegerBitwiseOperatorsCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void doBitwiseOperation() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if ((1 & 2) > 0) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if ((1 | 2) > 0) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    final String java = _builder.toString();
    String body = this.toXtendClassBodyDeclr(java);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("def void doBitwiseOperation() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("if ((1.bitwiseAnd(2)) > 0) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("if ((1.bitwiseOr(2)) > 0) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    Assert.assertEquals(_string, body);
  }
  
  @Test
  public void testBooleanBitwiseOperatorsCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("boolean foo = true & false;");
    _builder.newLine();
    _builder.append("public void doBitwiseOperation() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (true | false) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (true ^ false) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    final String java = _builder.toString();
    String body = this.toXtendClassBodyDeclr(java);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package boolean foo=true && false");
    _builder_1.newLine();
    _builder_1.append("def void doBitwiseOperation() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("if (true || false) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("if (true.xor(false)) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    Assert.assertEquals(_string, body);
  }
  
  @Test
  public void testBitwiseComplementCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void doBitwiseOperation() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i = 1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("i = ~i;");
    _builder.newLine();
    _builder.append("}");
    final String javaBody = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Test {");
    _builder_1.append(javaBody, "");
    _builder_1.append("}");
    final XtendClass clazz = this.toValidXtendClass(_builder_1);
    Assert.assertNotNull(clazz);
    String body = this.toXtendClassBodyDeclr(javaBody);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("def void doBitwiseOperation() {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("var int i=1 ");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("i=i.bitwiseNot ");
    _builder_2.newLine();
    _builder_2.append("}");
    String _string = _builder_2.toString();
    Assert.assertEquals(_string, body);
  }
  
  @Test
  public void testBytePrimitive_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private byte b = -1");
    final String x = this.toXtendClassBodyDeclr(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("byte b=(-1) as byte");
    String _string = _builder_1.toString();
    Assert.assertEquals(_string, x);
  }
  
  @Test
  public void testBytePrimitive_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private byte b = 1");
    final String x = this.toXtendClassBodyDeclr(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("byte b=(1) as byte");
    String _string = _builder_1.toString();
    Assert.assertEquals(_string, x);
  }
  
  @Test
  public void testBytePrimitive_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private byte b = 1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void doStuff(byte bytes[]) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("byte b2 = 1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b = -2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b = (-5 + 3);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bytes[0] = -8;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    final XtendClass x = this.toValidXtendClass(_builder);
    Assert.assertNotNull(x);
  }
  
  @Test
  public void testTryCatchCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void checkTryCatch() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} catch (final Exception e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw e;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    final String javaBody = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Test {");
    _builder_1.append(javaBody, "");
    _builder_1.append("}");
    final XtendClass clazz = this.toValidXtendClass(_builder_1);
    Assert.assertNotNull(clazz);
    String body = this.toXtendClassBodyDeclr(javaBody);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("def void checkTryCatch() {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("try {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("} catch (Exception e) {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("throw e");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("} finally {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("System.out.println() ");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    String _string = _builder_2.toString();
    Assert.assertEquals(_string, body);
  }
  
  @Test
  public void testTryCatchCaseAsStatement() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("} catch (final Exception e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw new Exception();");
    _builder.newLine();
    _builder.append("} catch (final Error e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw new Exception();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throw new Exception();");
    _builder.newLine();
    _builder.append("}");
    final String javaBody = _builder.toString();
    String statement = this.toXtendStatement(javaBody);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try {");
    _builder_1.newLine();
    _builder_1.append("} catch (Exception e) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("throw new Exception()");
    _builder_1.newLine();
    _builder_1.append("} catch (Error e) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("throw new Exception()");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("try {");
    _builder_1.newLine();
    _builder_1.append("} finally {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("throw new Exception()");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    Assert.assertEquals(_string, statement);
  }
  
  @Test
  public void testDoWhileStatement() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("do{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.println(i); ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("i++; ");
    _builder.newLine();
    _builder.append("} while(i < 0);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("while(i < 10) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.print(i);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("i++;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String javaBody = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var int i=0 ");
    _builder_1.newLine();
    _builder_1.append("do {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("System.out.println(i) ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("i++ ");
    _builder_1.newLine();
    _builder_1.append("} while (i < 0)");
    _builder_1.newLine();
    _builder_1.append("while (i < 10) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("System.out.print(i) ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("i++ ");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    String _xtendStatement = this.toXtendStatement(javaBody);
    Assert.assertEquals(_string, _xtendStatement);
  }
  
  @Test
  public void testSynchronizedStatement() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void add(int value){");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("synchronized(this){");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("this.count += value;   ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    final String javaBody = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("def void add(int value) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("synchronized (this) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.count+=value ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    String _string = _builder_1.toString();
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(javaBody);
    Assert.assertEquals(_string, _xtendClassBodyDeclr);
  }
  
  @Test
  public void testAnnotationDeclaration() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.lang.annotation.Documented;");
    _builder.newLine();
    _builder.append("import java.lang.annotation.ElementType;");
    _builder.newLine();
    _builder.append("import java.lang.annotation.Target;");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("@Documented");
    _builder.newLine();
    _builder.append("@Target(ElementType.METHOD)");
    _builder.newLine();
    _builder.append("public @interface MyAnno{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String author() default \"me\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String date();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int revision() default 1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String comments();");
    _builder.newLine();
    _builder.append("}");
    final String javaBody = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(javaBody, "");
    final XtendAnnotationType clazz = this.toValidXtendAnnotation(_builder_1.toString());
    Assert.assertNotNull(clazz);
    String body = this.toXtendCode(javaBody);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("import java.lang.annotation.Documented");
    _builder_2.newLine();
    _builder_2.append("import java.lang.annotation.ElementType");
    _builder_2.newLine();
    _builder_2.append("import java.lang.annotation.Target");
    _builder_2.newLine();
    _builder_2.append("@Documented @Target(ElementType.METHOD)public annotation MyAnno {");
    _builder_2.newLine();
    _builder_2.append("String author = \"me\"");
    _builder_2.newLine();
    _builder_2.append("String date");
    _builder_2.newLine();
    _builder_2.append("int revision = 1");
    _builder_2.newLine();
    _builder_2.append("String comments");
    _builder_2.newLine();
    _builder_2.append("}");
    String _string = _builder_2.toString();
    Assert.assertEquals(_string, body);
  }
  
  @Test
  public void testBug462099() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int foo(Object obj) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (obj == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else if (obj == \"test\") {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return 1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else if (obj != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return 2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return 3;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String xtendCode = this.toXtendCode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def int foo(Object obj) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (obj === null) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return 0 ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("} else if (obj === \"test\") {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return 1 ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("} else if (obj !== null) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return 2 ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return 3 ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    final String expected = _builder_1.toString();
    Assert.assertEquals(expected, xtendCode);
  }
  
  @Test
  public void testBug462100() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String toString() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"bar\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String xtendCode = this.toXtendCode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("override String toString() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return \"bar\" ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    final String expected = _builder_1.toString();
    Assert.assertEquals(expected, xtendCode);
  }
  
  protected XtendClass toValidXtendClass(final CharSequence javaCode) throws Exception {
    XtendTypeDeclaration _validTypeDeclaration = this.toValidTypeDeclaration("Clazz", javaCode);
    return ((XtendClass) _validTypeDeclaration);
  }
  
  protected XtendAnnotationType toValidXtendAnnotation(final String javaCode) throws Exception {
    XtendTypeDeclaration _validTypeDeclaration = this.toValidTypeDeclaration("Anno", javaCode);
    return ((XtendAnnotationType) _validTypeDeclaration);
  }
  
  protected XtendInterface toValidXtendInterface(final String javaCode) throws Exception {
    XtendTypeDeclaration _validTypeDeclaration = this.toValidTypeDeclaration("Interfaze", javaCode);
    return ((XtendInterface) _validTypeDeclaration);
  }
  
  protected XtendEnum toValidXtendEnum(final String javaCode) throws Exception {
    XtendTypeDeclaration _validTypeDeclaration = this.toValidTypeDeclaration("EnumClazz", javaCode);
    return ((XtendEnum) _validTypeDeclaration);
  }
  
  protected XtendTypeDeclaration toValidTypeDeclaration(final String unitName, final CharSequence javaCode) throws Exception {
    XtendFile file = this.toValidXtendFile(unitName, javaCode);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    XtendTypeDeclaration typeDeclaration = _xtendTypes.get(0);
    return typeDeclaration;
  }
  
  protected String toXtendClassBodyDeclr(final CharSequence string) {
    String _string = string.toString();
    JavaConverter.ConversionResult _bodyDeclarationToXtend = this.j2x.bodyDeclarationToXtend(_string, null, null);
    String _xtendCode = _bodyDeclarationToXtend.getXtendCode();
    final String xtendCode = _xtendCode.trim();
    this.dump(xtendCode);
    return xtendCode;
  }
  
  protected String toXtendStatement(final CharSequence string) {
    String _string = string.toString();
    JavaConverter.ConversionResult _statementToXtend = this.j2x.statementToXtend(_string, null);
    String _xtendCode = _statementToXtend.getXtendCode();
    final String xtendCode = _xtendCode.trim();
    this.dump(xtendCode);
    return xtendCode;
  }
  
  protected XtendFile toValidXtendFile(final String unitName, final CharSequence javaCode) throws Exception {
    String _string = javaCode.toString();
    JavaConverter.ConversionResult conversionResult = this.j2x.toXtend(unitName, _string);
    String xtendCode = conversionResult.getXtendCode();
    boolean _isEmpty = xtendCode.isEmpty();
    Assert.assertFalse(_isEmpty);
    this.dump(xtendCode);
    Iterable<String> _problems = conversionResult.getProblems();
    for (final String problem : _problems) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("ERROR: ");
      _builder.append(problem, "");
      this.dump(_builder.toString());
    }
    return this.file(xtendCode, true);
  }
  
  private String toXtendCode(final CharSequence javaCode) throws Exception {
    String _string = javaCode.toString();
    JavaConverter.ConversionResult _xtend = this.j2x.toXtend("Temp", _string);
    return _xtend.getXtendCode();
  }
  
  public XtendField field(final XtendTypeDeclaration typeDecl, final int i) {
    EList<XtendMember> _members = typeDecl.getMembers();
    XtendMember _get = _members.get(i);
    return ((XtendField) _get);
  }
  
  public XtendFunction method(final XtendTypeDeclaration typeDecl, final int i) {
    EList<XtendMember> _members = typeDecl.getMembers();
    XtendMember _get = _members.get(i);
    return ((XtendFunction) _get);
  }
  
  public String dump(final String text) {
    String _xifexpression = null;
    if (JavaConverterTest.DUMP) {
      _xifexpression = InputOutput.<String>println(text);
    }
    return _xifexpression;
  }
}
