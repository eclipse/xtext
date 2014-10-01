package org.eclipse.xtend.core.tests.conversion;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.xtend.core.conversion.JavaConverter;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class JavaConverterTest extends AbstractXtendTestCase {
  @Inject
  private Provider<JavaConverter> javaConverterProvider;
  
  private JavaConverter j2x;
  
  @Before
  public void setUp() {
    JavaConverter _get = this.javaConverterProvider.get();
    this.j2x = _get;
  }
  
  @Test
  public void testSimpleCalssDeclarationCase() throws Exception {
    String javaCode = "package pack; import java.lang.Object; public class JavaToConvert<T,U> {}";
    XtendFile xtendFile = this.toValidFile("JavaToConvert", javaCode);
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
    XtendTypeDeclaration typeDeclaration = this.toValidTypeDeclaration("JavaToConvert", javaCode);
    Assert.assertTrue("Compiles to interface", (typeDeclaration instanceof XtendInterface));
    XtendInterface xtendInterface = ((XtendInterface) typeDeclaration);
    boolean _isFinal = xtendInterface.isFinal();
    Assert.assertFalse("Non Final", _isFinal);
    boolean _isStatic = xtendInterface.isStatic();
    Assert.assertFalse("Non Static", _isStatic);
  }
  
  @Test
  public void testFieldDeclarationCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass("public class JavaToConvert { private String str = \"myString\";}");
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
    XtendClass xtendClazz = this.toValidXtendClass(_builder.toString());
    this.checkVisibility(xtendClazz);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class JavaToConvert {");
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
    XtendClass _validXtendClass = this.toValidXtendClass(_builder_1.toString());
    xtendClazz = _validXtendClass;
    this.checkVisibility(xtendClazz);
  }
  
  private void checkVisibility(final XtendClass xtendClazz) {
    EList<XtendMember> members = xtendClazz.getMembers();
    int _size = members.size();
    Assert.assertEquals("Simple fields count", 4, _size);
    XtendMember _get = members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("priv", _name);
    JvmVisibility _visibility = xtendMember.getVisibility();
    Assert.assertEquals("field PRIVATE visibility", JvmVisibility.PRIVATE, _visibility);
    JvmTypeReference _type = xtendMember.getType();
    String _simpleName = _type.getSimpleName();
    Assert.assertEquals("String", _simpleName);
    XtendMember _get_1 = members.get(1);
    xtendMember = ((XtendField) _get_1);
    String _name_1 = xtendMember.getName();
    Assert.assertEquals("pub", _name_1);
    JvmVisibility _visibility_1 = xtendMember.getVisibility();
    Assert.assertEquals("field public visibility", JvmVisibility.PUBLIC, _visibility_1);
    JvmTypeReference _type_1 = xtendMember.getType();
    String _simpleName_1 = _type_1.getSimpleName();
    Assert.assertEquals("String", _simpleName_1);
    XtendMember _get_2 = members.get(2);
    xtendMember = ((XtendField) _get_2);
    String _name_2 = xtendMember.getName();
    Assert.assertEquals("prot", _name_2);
    JvmVisibility _visibility_2 = xtendMember.getVisibility();
    Assert.assertEquals("field PROTECTED visibility", JvmVisibility.PROTECTED, _visibility_2);
    JvmTypeReference _type_2 = xtendMember.getType();
    String _simpleName_2 = _type_2.getSimpleName();
    Assert.assertEquals("String", _simpleName_2);
    XtendMember _get_3 = members.get(3);
    xtendMember = ((XtendField) _get_3);
    String _name_3 = xtendMember.getName();
    Assert.assertEquals("def", _name_3);
    JvmVisibility _visibility_3 = xtendMember.getVisibility();
    Assert.assertEquals("field DEFAULT visibility", JvmVisibility.DEFAULT, _visibility_3);
    JvmTypeReference _type_3 = xtendMember.getType();
    String _simpleName_3 = _type_3.getSimpleName();
    Assert.assertEquals("String", _simpleName_3);
  }
  
  @Test
  public void testOverrideMethodeDeclarationCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "public class JavaToConvert {  @Override public String toString() {} }");
    EList<XtendMember> members = xtendClazz.getMembers();
    int _size = members.size();
    Assert.assertEquals("Simple methods count", 1, _size);
    XtendMember _get = members.get(0);
    XtendFunction xtendMember = ((XtendFunction) _get);
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
  public void testMethodeDeclarationCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "public class JavaToConvert { public boolean visit(final Object node) { return true;}}");
    EList<XtendMember> members = xtendClazz.getMembers();
    int _size = members.size();
    Assert.assertEquals("Simple methods count", 1, _size);
    XtendMember _get = members.get(0);
    XtendFunction xtendMember = ((XtendFunction) _get);
    JvmVisibility _visibility = xtendMember.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    JvmTypeReference _returnType = xtendMember.getReturnType();
    String _simpleName = _returnType.getSimpleName();
    Assert.assertEquals("boolean", _simpleName);
    String _name = xtendMember.getName();
    Assert.assertEquals("visit", _name);
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
    XtendClass xtendClazz = this.toValidXtendClass(_builder.toString());
    EList<XtendMember> members = xtendClazz.getMembers();
    int _size = members.size();
    Assert.assertEquals("Simple methods count", 4, _size);
    XtendMember _get = members.get(1);
    XtendFunction xtendMember = ((XtendFunction) _get);
    JvmVisibility _visibility = xtendMember.getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    JvmTypeReference _returnType = xtendMember.getReturnType();
    String _simpleName = _returnType.getSimpleName();
    Assert.assertEquals("void", _simpleName);
    String _name = xtendMember.getName();
    Assert.assertEquals("visit", _name);
  }
  
  @Test
  public void testOverride() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
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
    XtendClass xtendClazz = this.toValidXtendClass(_builder.toString());
    EList<XtendMember> members = xtendClazz.getMembers();
    int _size = members.size();
    Assert.assertEquals("Simple methods count", 3, _size);
    XtendMember _get = members.get(0);
    boolean _isOverride = ((XtendFunction) _get).isOverride();
    Assert.assertTrue(_isOverride);
    XtendMember _get_1 = members.get(1);
    boolean _isOverride_1 = ((XtendFunction) _get_1).isOverride();
    Assert.assertTrue(_isOverride_1);
    XtendMember _get_2 = members.get(2);
    boolean _isOverride_2 = ((XtendFunction) _get_2).isOverride();
    Assert.assertTrue(_isOverride_2);
  }
  
  @Test
  public void testStringLiteralCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "class TestStringLiteral { String withLineWrap=\"string with wrap\\n\";}");
    EList<XtendMember> _members = xtendClazz.getMembers();
    XtendMember _get = _members.get(0);
    XtendField xtendMember = ((XtendField) _get);
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
    _builder.append("}");
    XtendClass xtendClazz = this.toValidXtendClass(_builder.toString());
    EList<XtendMember> _members = xtendClazz.getMembers();
    XtendMember _get = _members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("l", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    String _value = ((XNumberLiteral) _initialValue).getValue();
    Assert.assertEquals("0x0000000000000000#L", _value);
    EList<XtendMember> _members_1 = xtendClazz.getMembers();
    XtendMember _get_1 = _members_1.get(1);
    xtendMember = ((XtendField) _get_1);
    String _name_1 = xtendMember.getName();
    Assert.assertEquals("d", _name_1);
    XExpression _initialValue_1 = xtendMember.getInitialValue();
    String _value_1 = ((XNumberLiteral) _initialValue_1).getValue();
    Assert.assertEquals("2.5d", _value_1);
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
    XtendClass xtendClazz = this.toValidXtendClass(_builder.toString());
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
    EList<XtendMember> _members = xtendClazz.getMembers();
    XtendMember _get_2 = _members.get(0);
    XtendFunction xtendMember = ((XtendFunction) _get_2);
    String _name_2 = xtendMember.getName();
    Assert.assertEquals("doStuff", _name_2);
    EList<JvmTypeParameter> _typeParameters_2 = xtendMember.getTypeParameters();
    JvmTypeParameter _get_3 = _typeParameters_2.get(0);
    typeParameter = _get_3;
    String _name_3 = typeParameter.getName();
    Assert.assertEquals("D", _name_3);
    EList<JvmTypeConstraint> _constraints_1 = typeParameter.getConstraints();
    JvmTypeConstraint _get_4 = _constraints_1.get(0);
    String _simpleName_1 = _get_4.getSimpleName();
    Assert.assertEquals("extends T", _simpleName_1);
  }
  
  @Test
  public void testSimpleAssigmentCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "class TestAssiment {  void doStuff() { String x = null; x = new String();}");
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testSimpleInstanceOfCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "class Test {  void doStuff() { String x = null; if(!(x instanceof String)) x = \"\";}");
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testCommentsCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "/** javadoc */public class TestComment { //singleline \\n void doStuff() { /*multiline*/}");
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testJavadocCase() throws Exception {
    JavaConverter.ConversionResult _xtend = this.j2x.toXtend("Clazz", "/**@param p Param p*/public abstract void foo();", 
      ASTParser.K_CLASS_BODY_DECLARATIONS);
    String xtendCode = _xtend.getXtendCode();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Javadoc Parameter well formed: ");
    _builder.append(xtendCode, "");
    boolean _contains = xtendCode.contains("@param p Param p");
    Assert.assertTrue(_builder.toString(), _contains);
  }
  
  @Test
  public void testCastCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "public class TestCast { void doStuff() { Object o = (Object)this;}");
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testIfElseCase() throws Exception {
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
    XtendClass xtendClazz = this.toValidXtendClass(_builder.toString());
    Assert.assertNotNull(xtendClazz);
  }
  
  @Test
  public void testStaticImportCase() throws Exception {
    XtendClass xtendClazz = this.toValidXtendClass(
      "package foo; import static java.awt.AWTEvent.*; public class Test { long o= ACTION_EVENT_MASK;}");
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
  public void testStaticBlockCase() throws Exception {
    JavaConverter.ConversionResult conversionResult = this.j2x.toXtend("Clazz", 
      "public class Clazz { static String foo;static{foo=\"\";}}");
    String xtendCode = conversionResult.getXtendCode();
    boolean _isEmpty = xtendCode.isEmpty();
    Assert.assertFalse(_isEmpty);
    Iterable<String> _problems = conversionResult.getProblems();
    int _size = Iterables.size(_problems);
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void testConstructorCase() throws Exception {
    XtendClass clazz = this.toValidXtendClass("public class Clazz { public Clazz(){}}");
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    JvmVisibility _visibility = ((XtendConstructor) _get).getVisibility();
    Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
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
    XtendClass clazz = this.toValidXtendClass(_builder.toString());
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testArrayCreationCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String[] arr = new String[]{\"\",\"\"};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Class<?>[] argTypes = new Class[arr.length];");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder.toString());
    Assert.assertNotNull(clazz);
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
    XtendClass clazz = this.toValidXtendClass(_builder.toString());
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
    XtendClass clazz = this.toValidXtendClass(_builder.toString());
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testPrefixPlusMinusSimpleArrayCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int[] ints = new int[]{1,2,3,4,5};");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int in = 2;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"3=\"+(ints[in]++));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"4=\"+(ints[in]--));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"1=\"+(--ints[in]));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"5=\"+(++ints[in]));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    XtendClass clazz = this.toValidXtendClass(_builder.toString());
    Assert.assertNotNull(clazz);
  }
  
  @Test
  public void testPrefixPlusMinusArrayCase() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Clazz { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static main(String[] args) {");
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
    XtendClass clazz = this.toValidXtendClass(_builder.toString());
    Assert.assertNotNull(clazz);
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
    XtendClass clazz = this.toValidXtendClass(_builder.toString());
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
    JavaConverter.ConversionResult _xtend = this.j2x.toXtend("Clazz", "static String a = (i-i)+i+\"4=\"+(--i)+\"1=\"+(i++)+i;", 
      ASTParser.K_CLASS_BODY_DECLARATIONS);
    String _xtendCode = _xtend.getXtendCode();
    String _trim = _xtendCode.trim();
    Assert.assertEquals("static package String a=\'\'\'«(i - i)»«i»4=«((i=i - 1))»1=«(i++)»«i»\'\'\'", _trim);
  }
  
  @Test
  public void testRichStringSimpleCase() throws Exception {
    JavaConverter.ConversionResult _xtend = this.j2x.toXtend("Clazz", "static String a = \"first line\"+\"second line\"+\"third line\"+\"fourth line\";", 
      ASTParser.K_CLASS_BODY_DECLARATIONS);
    String _xtendCode = _xtend.getXtendCode();
    String _trim = _xtendCode.trim();
    Assert.assertEquals("static package String a=\'\'\'\nfirst line\nsecond line\nthird line\nfourth line\'\'\'", _trim);
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
    Assert.assertTrue((_initialValue instanceof RichString));
    JavaConverter.ConversionResult _xtend = this.j2x.toXtend("Clazz", "String richTxt = \"a\" + \"\'\'\' no «\'foo\'.length» side-effect \'\'\'\";", 
      ASTParser.K_CLASS_BODY_DECLARATIONS);
    String _xtendCode = _xtend.getXtendCode();
    String _trim = _xtendCode.trim();
    Assert.assertEquals("package String richTxt=\'\'\'a\n«\"\'\'\'\"» no «\"«\"» \'foo\'.length«\"»\"» side-effect «\"\'\'\'\"»\'\'\'", _trim);
  }
  
  @Test
  public void testRichStringSpecialCase2() throws Exception {
    XtendClass clazz = this.toValidXtendClass(
      (("class Z { String richTxt = \"test\" + \"\'\'\' «FOR a: \'123\'.toCharArray SEPARATOR \',\\n  \\t\'»\\n" + 
        "      a\\n") + " «ENDFOR»\'\'\'\";}"));
    Assert.assertNotNull(clazz);
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("richTxt", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    Assert.assertTrue((_initialValue instanceof RichString));
    JavaConverter.ConversionResult _xtend = this.j2x.toXtend("Clazz", 
      (("String richTxt = \"test\" + \"\'\'\' «FOR a: \'123\'.toCharArray SEPARATOR \',\\n  \\t\'»\\n" + "      a\\n") + 
        " «ENDFOR»\'\'\'\";"), ASTParser.K_CLASS_BODY_DECLARATIONS);
    String _xtendCode = _xtend.getXtendCode();
    String _trim = _xtendCode.trim();
    Assert.assertEquals(
      "package String richTxt=\'\'\'test\n«\"\'\'\'\"» «\"«\"» FOR a: \'123\'.toCharArray SEPARATOR \',\n  \t\'«\"»\"»\n      a\n «\"«\"» ENDFOR«\"»\"»«\"\'\'\'\"»\'\'\'", _trim);
  }
  
  @Test
  public void testRichStringSpecialCase3() throws Exception {
    XtendClass clazz = this.toValidXtendClass(
      "class Z { String richTxt = \"x(p1)} def dispatch x(int s) {\'int\'} def dispatch x(boolean s)\"+\" {\'boolean\'} def dispatch x(double s) {\'double\'\";}");
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
    XtendClass clazz = this.toValidXtendClass(_builder.toString());
    Assert.assertNotNull(clazz);
    EList<XtendMember> _members = clazz.getMembers();
    XtendMember _get = _members.get(0);
    XtendField xtendMember = ((XtendField) _get);
    String _name = xtendMember.getName();
    Assert.assertEquals("listener", _name);
    XExpression _initialValue = xtendMember.getInitialValue();
    Assert.assertTrue((_initialValue instanceof XClosure));
  }
  
  private XtendClass toValidXtendClass(final String javaCode) throws Exception {
    XtendTypeDeclaration _validTypeDeclaration = this.toValidTypeDeclaration("Clazz", javaCode);
    return ((XtendClass) _validTypeDeclaration);
  }
  
  private XtendTypeDeclaration toValidTypeDeclaration(final String unitName, final String javaCode) throws Exception {
    XtendFile file = this.toValidFile(unitName, javaCode);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    XtendTypeDeclaration typeDeclaration = _xtendTypes.get(0);
    return typeDeclaration;
  }
  
  private XtendFile toValidFile(final String unitName, final String javaCode) throws Exception {
    JavaConverter.ConversionResult conversionResult = this.j2x.toXtend(unitName, javaCode);
    String xtendCode = conversionResult.getXtendCode();
    System.out.println(xtendCode);
    Iterable<String> _problems = conversionResult.getProblems();
    for (final String problem : _problems) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("ERROR: ");
      _builder.append(problem, "");
      System.out.println(_builder);
    }
    return this.file(xtendCode, true);
  }
}
