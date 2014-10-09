package org.eclipse.xtend.core.tests.conversion

import org.eclipse.emf.common.util.EList
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.xtend.core.conversion.JavaConverter
import org.eclipse.xtend.core.conversion.JavaConverter.ConversionResult
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.junit.Before
import org.junit.Test
import com.google.common.collect.Iterables
import com.google.inject.Inject
import com.google.inject.Provider

class JavaConverterTest extends AbstractXtendTestCase {
	@Inject Provider<JavaConverter> javaConverterProvider
	JavaConverter j2x

	@Before def void setUp() {
		j2x = javaConverterProvider.get()
	}

	@Test def void testSimpleCalssDeclarationCase() throws Exception {

		var String javaCode = "package pack; import java.lang.Object; public class JavaToConvert<T,U> {}"

		var XtendFile xtendFile = toValidFile("JavaToConvert", javaCode)
		assertEquals("pack", xtendFile.getPackage())
		assertEquals("java.lang.Object", xtendFile.getImportSection().getImportDeclarations().get(0).getImportedName())
		var XtendTypeDeclaration typeDeclaration = xtendFile.getXtendTypes().get(0)
		assertEquals("JavaToConvert", typeDeclaration.getName())
		assertTrue("Compiles to class", typeDeclaration instanceof XtendClass)
		var XtendClass xtendClass = typeDeclaration as XtendClass
		assertEquals(JvmVisibility.PUBLIC, xtendClass.getVisibility())
		assertFalse("Non Final", xtendClass.isFinal())
		assertFalse("Non Static", xtendClass.isStatic())
		assertEquals("T", xtendClass.getTypeParameters().get(0).getSimpleName())
		assertEquals("U", xtendClass.getTypeParameters().get(1).getSimpleName())
	}

	@Test def void testSimpleInterfaceDeclarationCase() throws Exception {

		var String javaCode = "public interface JavaToConvert<T> {}"

		var XtendTypeDeclaration typeDeclaration = toValidTypeDeclaration("JavaToConvert", javaCode)
		assertTrue("Compiles to interface", typeDeclaration instanceof XtendInterface)
		var XtendInterface xtendInterface = typeDeclaration as XtendInterface
		assertFalse("Non Final", xtendInterface.isFinal())
		assertFalse("Non Static", xtendInterface.isStatic())
	}

	@Test def void testFieldDeclarationCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass("public class JavaToConvert { private String str = \"myString\";}")

		var EList<XtendMember> members = xtendClazz.getMembers()
		assertEquals("Simple fields count", 1, members.size())
		var XtendField xtendMember = members.get(0) as XtendField
		assertEquals(JvmVisibility.PRIVATE, xtendMember.getVisibility())
		assertEquals("String", xtendMember.getType().getSimpleName())
		assertEquals("str", xtendMember.getName())
		assertEquals("myString", (xtendMember.getInitialValue() as XStringLiteral).getValue())
	}

	@Test def void testFieldVisibility() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			'''
			public class JavaToConvert {
				private String priv;
				public String pub;
				protected String prot;
				String def;
			}''')
		checkVisibility(xtendClazz)
		xtendClazz = toValidXtendClass(
			'''
			public class JavaToConvert {
				private static String priv;
				public static String pub;
				protected static String prot;
				static String def;
			}''')
		checkVisibility(xtendClazz)
	}

	def private void checkVisibility(XtendClass xtendClazz) {

		var EList<XtendMember> members = xtendClazz.getMembers()
		assertEquals("Simple fields count", 4, members.size())
		var XtendField xtendMember = members.get(0) as XtendField
		assertEquals("priv", xtendMember.getName())
		assertEquals("field PRIVATE visibility", JvmVisibility.PRIVATE, xtendMember.getVisibility())
		assertEquals("String", xtendMember.getType().getSimpleName())
		xtendMember = members.get(1) as XtendField
		assertEquals("pub", xtendMember.getName())
		assertEquals("field public visibility", JvmVisibility.PUBLIC, xtendMember.getVisibility())
		assertEquals("String", xtendMember.getType().getSimpleName())
		xtendMember = members.get(2) as XtendField
		assertEquals("prot", xtendMember.getName())
		assertEquals("field PROTECTED visibility", JvmVisibility.PROTECTED, xtendMember.getVisibility())
		assertEquals("String", xtendMember.getType().getSimpleName())
		xtendMember = members.get(3) as XtendField
		assertEquals("def", xtendMember.getName())
		assertEquals("field DEFAULT visibility", JvmVisibility.DEFAULT, xtendMember.getVisibility())
		assertEquals("String", xtendMember.getType().getSimpleName())
	}

	@Test def void testOverrideMethodeDeclarationCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"public class JavaToConvert {  @Override public String toString() {} }")

		var EList<XtendMember> members = xtendClazz.getMembers()
		assertEquals("Simple methods count", 1, members.size())
		var XtendFunction xtendMember = members.get(0) as XtendFunction
		assertEquals(JvmVisibility.PUBLIC, xtendMember.getVisibility())
		assertTrue(xtendMember.isOverride())
		assertEquals("String", xtendMember.getReturnType().getSimpleName())
		assertEquals("toString", xtendMember.getName())
	}

	@Test def void testMethodeDeclarationCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"public class JavaToConvert { public boolean visit(final Object node) { return true;}}")

		var EList<XtendMember> members = xtendClazz.getMembers()
		assertEquals("Simple methods count", 1, members.size())
		var XtendFunction xtendMember = members.get(0) as XtendFunction
		assertEquals(JvmVisibility.PUBLIC, xtendMember.getVisibility())
		assertEquals("boolean", xtendMember.getReturnType().getSimpleName())
		assertEquals("visit", xtendMember.getName())
	}

	@Test def void testBasicForStatementCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			'''
			import java.util.Iterator;
			public class JavaToConvert {
				StringBuffer fBuffer=null;
				public void visit(Node node) {
					this.fBuffer.append("{");
					for (Iterator<Statement> it= node.statements().iterator(); it.hasNext();) {
						Statement s= it.next();
						s.accept(this);
						this.fBuffer.append("}");
					}
				}
				interface Node {
					Iterable statements();
				}
				interface Statement {
					void accept(JavaToConvert v); 
				}
			}''')

		var EList<XtendMember> members = xtendClazz.getMembers()
		assertEquals("Simple methods count", 4, members.size())
		var XtendFunction xtendMember = members.get(1) as XtendFunction
		assertEquals(JvmVisibility.PUBLIC, xtendMember.getVisibility())
		assertEquals("void", xtendMember.getReturnType().getSimpleName())
		assertEquals("visit", xtendMember.getName())
	}

	@Test def void testOverride() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			'''
				public class JavaToConvert implements Statement {
					public Iterable statements() { return null;} 
					public String toString() { return null;} 
					public void accept(JavaToConvert v){}
				}
				interface Node {
					Iterable statements();
				} 
				interface Statement extends Node {
					 void accept(JavaToConvert v);
				}
			''')

		var EList<XtendMember> members = xtendClazz.getMembers()
		assertEquals("Simple methods count", 3, members.size())
		assertTrue((members.get(0) as XtendFunction).isOverride())
		assertTrue((members.get(1) as XtendFunction).isOverride())
		assertTrue((members.get(2) as XtendFunction).isOverride())
	}

	@Test def void testStringLiteralCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"class TestStringLiteral { String withLineWrap=\"string with wrap\\n\";}")

		var XtendField xtendMember = xtendClazz.getMembers().get(0) as XtendField
		assertEquals("withLineWrap", xtendMember.getName())
		assertEquals("string with wrap\n", (xtendMember.getInitialValue() as XStringLiteral).getValue())
	}

	@Test def void testNumberLiteralCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			'''
			class TestStringLiteral {
				long l= 0x0000000000000000L;
				double d= 2.5d;
			}''')

		var XtendField xtendMember = xtendClazz.getMembers().get(0) as XtendField
		assertEquals("l", xtendMember.getName())
		assertEquals("0x0000000000000000#L", (xtendMember.getInitialValue() as XNumberLiteral).getValue())
		xtendMember = xtendClazz.getMembers().get(1) as XtendField
		assertEquals("d", xtendMember.getName())
		assertEquals("2.5d", (xtendMember.getInitialValue() as XNumberLiteral).getValue())
	}

	@Test def void testSimpleTypeParameterCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			'''
			public class TestTypeParameter <T,U extends T> {
				<D extends T>  T doStuff(Iterable<? super U> us, Iterable<? extends D> d, T t) {
					return t;
				}
			}''')

		var JvmTypeParameter typeParameter = xtendClazz.getTypeParameters().get(0)
		assertEquals("T", typeParameter.getName())
		typeParameter = xtendClazz.getTypeParameters().get(1)
		assertEquals("U", typeParameter.getName())
		assertEquals("extends T", typeParameter.getConstraints().get(0).getSimpleName())
		var XtendFunction xtendMember = xtendClazz.getMembers().get(0) as XtendFunction
		assertEquals("doStuff", xtendMember.getName())
		typeParameter = xtendMember.getTypeParameters().get(0)
		assertEquals("D", typeParameter.getName())
		assertEquals("extends T", typeParameter.getConstraints().get(0).getSimpleName())
	}

	@Test def void testSimpleAssigmentCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"class TestAssiment {  void doStuff() { String x = null; x = new String();}")
		assertNotNull(xtendClazz)
	}

	@Test def void testSimpleInstanceOfCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"class Test {  void doStuff() { String x = null; if(!(x instanceof String)) x = \"\";}")
		assertNotNull(xtendClazz)
	}

	@Test def void testCommentsCase() throws Exception {
		var xtendCode = toXtendCode(
			'''
			/**
			* javadoc
			*/
			public class TestComment {
				/* ML */
				private int i = 1;
				//singleline
				void doStuff() {
					/*
					 multiline
					*/
				}
				/**/
				void doStuff2() {
					/* some comments */
					return;
				}
			}''')
		val expected = '''
		/** 
		 * javadoc
		 */
		class TestComment {
			/* ML */
			int i=1
			//singleline
			def package void doStuff(){
				/*
				 multiline
				*/
				
			}
			/**/
			def package void doStuff2(){
				/* some comments */
				return 
			}
			
		}'''
		assertEquals(expected, xtendCode)
	}

	@Test def void testJavadocCase() throws Exception {

		var String xtendCode = j2x.toXtend("Clazz", "/**@param p Param p*/public abstract void foo();",
			ASTParser.K_CLASS_BODY_DECLARATIONS).getXtendCode()
		assertTrue('''Javadoc Parameter well formed: «xtendCode»''', xtendCode.contains("@param p Param p"))
	}

	@Test def void testCastCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"public class TestCast { void doStuff() { Object o = (Object)this;}")
		assertNotNull(xtendClazz)
	}

	@Test def void testIfElseCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			'''
			public class TestCast {
					Object o=null;
					String it = (o==null)?"true":"false";
					String other = it;
					public void fooo() {
						this.it = null;
					}
			}''')
		assertNotNull(xtendClazz)
	}

	@Test def void testStaticImportCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"package foo; import static java.awt.AWTEvent.*; public class Test { long o= ACTION_EVENT_MASK;}")

		var XtendField xtendMember = xtendClazz.getMembers().get(0) as XtendField
		assertEquals("o", xtendMember.getName())
		var XFeatureCall xFeatureCall = xtendMember.getInitialValue() as XFeatureCall
		assertEquals("ACTION_EVENT_MASK", xFeatureCall.getFeature().getSimpleName())
	}

	@Test def void testInnerClassCase() throws Exception {

		var ConversionResult conversionResult = j2x.toXtend("Clazz",
			'''
			public class Clazz {
				class Inner {
				}
				public void inMeth() {
					class OuterImpl extends Outer {
					}
				}
			}''')

		var String xtendCode = conversionResult.getXtendCode()
		assertFalse(xtendCode.isEmpty())
		assertEquals(2, Iterables.size(conversionResult.getProblems()))
	}

	@Test def void testStaticBlockCase() throws Exception {

		var ConversionResult conversionResult = j2x.toXtend("Clazz",
			"public class Clazz { static String foo;static{foo=\"\";}}")

		var String xtendCode = conversionResult.getXtendCode()
		assertFalse(xtendCode.isEmpty())
		assertEquals(0, Iterables.size(conversionResult.getProblems()))
	}

	@Test def void testConstructorCase() throws Exception {

		var XtendClass clazz = toValidXtendClass("public class Clazz { public Clazz(){}}")
		assertEquals(JvmVisibility.PUBLIC, (clazz.getMembers().get(0) as XtendConstructor).getVisibility())
	}

	@Test def void testArrayAccessCase() throws Exception {
		var XtendClass clazz = toValidXtendClass(
			'''
			public class Clazz {
				String foo(String... strAr) {
					int i = 0;
					System.out.println(strAr[0] + ""); 
					String a = (strAr[0] ="2");
					strAr[1]=a;
					a=strAr[0]+strAr[1];
					return strAr[i++]="";
				}
			}''')
		assertNotNull(clazz)
	}

	@Test def void testArrayCreationCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
			public class Clazz {
				String[] arr = new String[]{"",""};
				Class<?>[] argTypes = new Class[arr.length];
			}''')
		assertNotNull(clazz)
	}

	@Test def void testArrayPrefixMinusCase() throws Exception {
		var XtendClass clazz = toValidXtendClass(
			'''
			public class Clazz {
				public static main(String[] args) {
					int i =3;
					int[] ints = new int[]{1,2,3,4,5};
					System.out.print("2="+(--ints[--i]));
				}
			}''')
		assertNotNull(clazz)
	}

	@Test def void testPrefixPlusMinusCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
				public class Clazz { 
					public static main(String[] args) {
						int i=3;
						System.out.print("4=");
						System.out.println(++i);
						System.out.print("3=");
						System.out.println(--i);
					}
				}
			''')
		assertNotNull(clazz)
	}

	@Test def void testPrefixPlusMinusSimpleArrayCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
			public class Clazz { 
				public static main(String[] args) {
					int[] ints = new int[]{1,2,3,4,5};
					int in = 2;
					System.out.println("3="+(ints[in]++));
					System.out.println("4="+(ints[in]--));
					System.out.println("1="+(--ints[in]));
					System.out.println("5="+(++ints[in]));
				}
			}''')
		assertNotNull(clazz)
	}

	@Test def void testPrefixPlusMinusArrayCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
			public class Clazz { 
				public static main(String[] args) {
					int[] ints = new int[]{1,2,3,4,5};
					int in = 2;
					System.out.println("3="+(ints[in++]++));
					System.out.println("4="+(ints[in--]--));
					System.out.println("1="+(--ints[--in]));
					System.out.println("5="+(++ints[++in]));
				}
			}''')
		assertNotNull(clazz)
	}

	@Test def void testRichStringCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
			public class Clazz {
				static int i = 2;
				static String a = (i-i)+i+"4="+(--i)+"1="+(i++)+i;
				static String b ="4="+"1=";
			}''')
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.getMembers().get(1) as XtendField
		assertEquals("a", xtendMember.getName())
		assertTrue(xtendMember.getInitialValue() instanceof RichString)
		assertTrue((clazz.getMembers().get(2) as XtendField).getInitialValue() instanceof RichString)
		assertEquals("static package String a='''«(i - i)»«i»4=«((i=i - 1))»1=«(i++)»«i»'''",
			classBodyDeclToXtend("static String a = (i-i)+i+\"4=\"+(--i)+\"1=\"+(i++)+i;"))
	}

	@Test def void testRichStringCase1() throws Exception {
		assertEquals("int i=0\nString richTxt='''int \ni=«i».'''",
			classBodyDeclToXtend(
				'''
					private int i = 0;
					private String richTxt = "int "+"i="+i+".";
				'''))
	}

	@Test def void testRichStringCase2() throws Exception {
		assertEquals(
			"package String str='''Step: «info» memory: free / total / max MB «runtime.freeMemory() / (1000 * 1000)» / «runtime.totalMemory() / (1000 * 1000)» / «runtime.maxMemory() / (1000 * 1000)»'''",
			classBodyDeclToXtend(
				'''
					String str = "Step: " + info + " memory: free / total / max MB " + runtime.freeMemory() / (1000 * 1000) + " / " + runtime.totalMemory() / (1000 * 1000) + " / " + runtime.maxMemory() / (1000 * 1000)
				'''))
	}

	@Test def void testRichStringCase3() throws Exception {
		assertEquals("static package String a='''first line\nsecond line\nthird line\nfourth line'''",
			classBodyDeclToXtend('''static String a = "first line"+"second line"+"third line"+"fourth line";'''))
	}

	@Test def void testRichStringSpecialCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			"class Z { String richTxt = \"a\" +\"\" +\"'\" +\"s \" + \"''' no «'foo'.length» side-effect '''\";}")
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.getMembers().get(0) as XtendField
		assertEquals("richTxt", xtendMember.getName())
		assertTrue(xtendMember.getInitialValue() instanceof RichString)
		assertEquals("package String richTxt='''a\n«\"'''\"» no «\"«\"» 'foo'.length«\"»\"» side-effect «\"'''\"»'''",
			classBodyDeclToXtend("String richTxt = \"a\" + \"''' no «'foo'.length» side-effect '''\";"))
	}

	@Test def void testRichStringSpecialCase2() throws Exception {
		var clazz = toValidXtendClass(
			"class Z { String richTxt = \"test\" + \"''' «FOR a: '123'.toCharArray SEPARATOR ',\\n  \\t'»\\n" +
				"      a\\n" + " «ENDFOR»'''\";}")
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.getMembers().get(0) as XtendField
		assertEquals("richTxt", xtendMember.getName())
		assertTrue(xtendMember.getInitialValue() instanceof RichString)
		assertEquals(
			"package String richTxt='''test\n«\"'''\"» «\"«\"» FOR a: '123'.toCharArray SEPARATOR ',\n  \t'«\"»\"»\n      a\n «\"«\"» ENDFOR«\"»\"»«\"'''\"»'''",
			classBodyDeclToXtend(
				"String richTxt = \"test\" + \"''' «FOR a: '123'.toCharArray SEPARATOR ',\\n  \\t'»\\n" + "      a\\n" +
					" «ENDFOR»'''\";"))
	}

	@Test def void testRichStringSpecialCase3() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			"class Z { String richTxt = \"x(p1)} def dispatch x(int s) {'int'} def dispatch x(boolean s)\"+\" {'boolean'} def dispatch x(double s) {'double'\";}")
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.getMembers().get(0) as XtendField
		assertEquals("richTxt", xtendMember.getName())
		assertTrue(xtendMember.getInitialValue() instanceof RichString)
	}

	@Test def void testAnonymousClassCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
			import java.awt.event.ActionEvent;
			import java.awt.event.ActionListener;
			class Clazz {
				ActionListener listener = new ActionListener() {
				 	public void actionPerformed(ActionEvent arg0) {
				 		arg0.getID();
				 	}
				};
			}''')
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.getMembers().get(0) as XtendField
		assertEquals("listener", xtendMember.getName())
		assertTrue(xtendMember.getInitialValue() instanceof XClosure)
	}

	@Test def void testSLCommentCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
			class Clazz {
				//Single Line comment
				String str;
			}''')
		assertNotNull(clazz)
	}

	def private XtendClass toValidXtendClass(String javaCode) throws Exception {
		return toValidTypeDeclaration("Clazz", javaCode) as XtendClass
	}

	def private XtendTypeDeclaration toValidTypeDeclaration(String unitName, String javaCode) throws Exception {

		var XtendFile file = toValidFile(unitName, javaCode)

		var XtendTypeDeclaration typeDeclaration = file.getXtendTypes().get(0)
		return typeDeclaration
	}

	def private classBodyDeclToXtend(String string) {
		val xtendCode = j2x.toXtend("ClassBodyDeclToXtend", string, ASTParser.K_CLASS_BODY_DECLARATIONS).getXtendCode().
			trim()
		println(xtendCode)
		return xtendCode
	}

	def private XtendFile toValidFile(String unitName, String javaCode) throws Exception {

		var ConversionResult conversionResult = j2x.toXtend(unitName, javaCode)

		var String xtendCode = conversionResult.getXtendCode()
		System.out.println(xtendCode)
		for (String problem : conversionResult.getProblems()) {
			System.out.println('''ERROR: «problem»''')
		}
		return file(xtendCode, true)
	}

	def private String toXtendCode(String javaCode) throws Exception {
		return j2x.toXtend("Temp", javaCode).getXtendCode()
	}

}
