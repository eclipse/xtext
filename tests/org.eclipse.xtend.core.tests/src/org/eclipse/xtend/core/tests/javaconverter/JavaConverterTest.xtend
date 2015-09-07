package org.eclipse.xtend.core.tests.javaconverter

import com.google.common.base.Splitter
import com.google.common.collect.Iterables
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.EList
import org.eclipse.xtend.core.javaconverter.JavaConverter
import org.eclipse.xtend.core.javaconverter.JavaConverter.ConversionResult
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendEnumLiteral
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.common.types.JvmVisibility.*

class JavaConverterTest extends AbstractXtendTestCase {
	@Inject Provider<JavaConverter> javaConverterProvider
	protected JavaConverter j2x
	static protected boolean DUMP = true;

	@Before def void setUp() {
		j2x = javaConverterProvider.get()
	}

	@Test def void testSimpleCalssDeclarationCase() throws Exception {

		var String javaCode = "package pack; import java.lang.Object; public class JavaToConvert<T,U> {}"

		var XtendFile xtendFile = toValidXtendFile("pack/JavaToConvert", javaCode)
		assertEquals("pack", xtendFile.getPackage())
		assertEquals("java.lang.Object", xtendFile.getImportSection().getImportDeclarations().get(0).getImportedName())
		var XtendTypeDeclaration typeDeclaration = xtendFile.getXtendTypes().get(0)
		assertEquals("JavaToConvert", typeDeclaration.getName())
		assertTrue("Compiles to class", typeDeclaration instanceof XtendClass)
		var XtendClass xtendClass = typeDeclaration as XtendClass
		assertEquals(PUBLIC, xtendClass.getVisibility())
		assertFalse("Non Final", xtendClass.isFinal())
		assertFalse("Non Static", xtendClass.isStatic())
		assertEquals("T", xtendClass.getTypeParameters().get(0).getSimpleName())
		assertEquals("U", xtendClass.getTypeParameters().get(1).getSimpleName())
	}

	@Test def void testSimpleInterfaceDeclarationCase() throws Exception {
		var String javaCode = "public interface JavaToConvert<T> {}"
		var XtendInterface xtendInterface = toValidXtendInterface(javaCode)
		assertFalse("Non Final", xtendInterface.isFinal())
		assertFalse("Non Static", xtendInterface.isStatic())
	}

	@Test def void testFieldDeclarationCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"public class JavaToConvert { private String str = \"myString\";}")

		var EList<XtendMember> members = xtendClazz.getMembers()
		assertEquals("Simple fields count", 1, members.size())
		var XtendField xtendMember = members.get(0) as XtendField
		assertEquals(PRIVATE, xtendMember.getVisibility())
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
		public class JavaToConvert2 {
			private static String priv;
			public static String pub;
			protected static String prot;
			static String def;
		}''')
		checkVisibility(xtendClazz)
	}

	def private void checkVisibility(XtendClass xtendClazz) {

		assertEquals("Simple fields count", 4, xtendClazz.getMembers().size())
		var XtendField xtendMember = xtendClazz.field(0)
		assertEquals("priv", xtendMember.getName())
		assertEquals("field PRIVATE visibility", PRIVATE, xtendMember.getVisibility())
		assertEquals("String", xtendMember.getType().getSimpleName())
		xtendMember = xtendClazz.field(1)
		assertEquals("pub", xtendMember.getName())
		assertEquals("field public visibility", PUBLIC, xtendMember.getVisibility())
		assertEquals("String", xtendMember.getType().getSimpleName())
		xtendMember = xtendClazz.field(2)
		assertEquals("prot", xtendMember.getName())
		assertEquals("field PROTECTED visibility", PROTECTED, xtendMember.getVisibility())
		assertEquals("String", xtendMember.getType().getSimpleName())
		xtendMember = xtendClazz.field(3)
		assertEquals("def", xtendMember.getName())
		assertEquals("field DEFAULT visibility", DEFAULT, xtendMember.getVisibility())
		assertEquals("String", xtendMember.getType().getSimpleName())
	}

	@Test def void testFieldVisibility1() throws Exception {
		val interfaze = toValidXtendInterface(
			'''
		public interface JavaToConvert {
			public static String pub;
			final String fin;
			static String def;
		}''')
		assertEquals(PUBLIC, interfaze.field(0).visibility)
		assertEquals(PUBLIC, interfaze.field(1).visibility)
		assertEquals(PUBLIC, interfaze.field(2).visibility)
	}

	@Test def void testOverrideMethodeDeclarationCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"public class JavaToConvert {  @Override public String toString() {} }")

		assertEquals("Simple methods count", 1, xtendClazz.getMembers().size())
		var xtendMember = xtendClazz.method(0)
		assertEquals(PUBLIC, xtendMember.getVisibility())
		assertTrue(xtendMember.isOverride())
		assertEquals("String", xtendMember.getReturnType().getSimpleName())
		assertEquals("toString", xtendMember.getName())
	}

	@Test def void testMethodDeclarationCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"public class JavaToConvert { public boolean visit(final Object node) throws Error, Exception { return true;}}"
		)

		assertEquals("Simple methods count", 1, xtendClazz.getMembers().size())
		var XtendFunction xtendMember = xtendClazz.method(0)
		assertEquals(PUBLIC, xtendMember.getVisibility())
		assertEquals("boolean", xtendMember.getReturnType().getSimpleName())
		assertEquals("visit", xtendMember.getName())
	}

	@Test def void testNonFinalMethodParameterCase_01() throws Exception {
		var XtendClass xtendClazz = toValidXtendClass(
			'''
		public class JavaToConvert {
			public boolean visit(Object node, Object node2, int[] array, int[] array2, String... varArgs) {
				node = null;
				node2 = null;
				array[0] = null;
				array2 = null
				varArgs = null
				return true;
			}
		}''')
		var XtendFunction xtendMember = xtendClazz.method(0)
		assertEquals(PUBLIC, xtendMember.getVisibility())
		assertEquals("node_finalParam_", xtendMember.parameters.get(0).getName())
		assertEquals("node2_finalParam_", xtendMember.parameters.get(1).getName())
		assertEquals("array", xtendMember.parameters.get(2).getName())
		assertEquals("array2_finalParam_", xtendMember.parameters.get(3).getName())
		assertEquals("varArgs_finalParam_", xtendMember.parameters.get(4).getName())
	}

	@Test def void testNonFinalMethodParameterCase_02() throws Exception {
		val xtendClass = '''class Test {void foo(int x) { x++; }}'''.toValidXtendClass
		assertNotNull(xtendClass)
		
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
		var XtendFunction xtendMember = xtendClazz.method(1)
		assertEquals(PUBLIC, xtendMember.getVisibility())
		assertEquals("void", xtendMember.getReturnType().getSimpleName())
		assertEquals("visit", xtendMember.getName())
	}

	@Test def void testBasicForStatementCase_02() throws Exception {

		toValidXtendClass('''
			public class JavaToConvert {
				public void visit() {
					for (int a = 1, b = 2; true; a++) {
					}
				}
			}
		''')

	}

	@Test def void testBasicForStatementCase_03() throws Exception {

		toValidXtendClass('''
			public class JavaToConvert {
				public void visit() {
					for (final int a = 1, b = 2; true; ) {
					}
				}
			}
		''')
	}
	@Test def void testBasicForStatementCase_04() throws Exception {
		assertEquals(
		'''
		class JavaToConvert {
			def void visit() {
				for (val int a=1, val int b=2; true; ) {
				}
			}
		}'''.toString, toXtendCode('''
			public class JavaToConvert {
				public void visit() {
					for (final int a = 1, b = 2; true; ) {
					}
				}
			}
		'''))
	}
	
	@Test def void testExtendedForStatementCase_01() throws Exception {

		toValidXtendClass('''
			import java.util.List;
			public class JavaToConvert {
				public void visit(List<?> list) {
					for (final Object o:list) {
					}
				}
			}
		''')

	}

	@Test def void testOverride() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			'''
			import java.util.Iterator;
			public class JavaToConvert implements Statement {
				public Iterable statements() { return null;} 
				public String toString() { return null;} 
				public void accept(JavaToConvert v){}
				public <DH> Iterator<DH> doAnonymousClass() {
					return new Iterator<DH>() {
						public int hashCode() {return super.hashCode();}
						public boolean hasNext() { return true;}
						public DH next() { return null;}
						public void remove() {}
					};
				}
			}
			interface Node {
				Iterable statements();
			} 
			interface Statement extends Node {
				 void accept(JavaToConvert v);
			}
		''')

		var EList<XtendMember> members = xtendClazz.getMembers()
		assertEquals("Simple methods count", 4, members.size())
		assertTrue(xtendClazz.method(0).isOverride())
		assertTrue(xtendClazz.method(1).isOverride())
		assertTrue(xtendClazz.method(2).isOverride())
		assertFalse(xtendClazz.method(3).isOverride())
	}

	@Test def void testStringLiteralCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass('class TestStringLiteral { 
				String withLineWrap="string with wrap\\n";
				String str2 = new String("\\1\\2\\3");
			}')

		var XtendField xtendMember = xtendClazz.field(0)
		assertEquals("withLineWrap", xtendMember.getName())
		assertEquals("string with wrap\n", (xtendMember.getInitialValue() as XStringLiteral).getValue())
	}

	@Test def void testNumberLiteralCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			'''
		class TestStringLiteral {
			long l= 0x0000000000000000L;
			double d= 2.5d;
			long l2= 0x000000000000A;
			long l3= 0x000000000000B;
			long l4= 0x000000000000c;
			long l5= 0x000000000000d;
			long l6= 0x000000000000e;
			long l7= 0x000000000000f;
		}''')

		var XtendField xtendMember = xtendClazz.field(0)
		assertEquals("l", xtendMember.getName())
		assertEquals("0x0000000000000000#L", (xtendMember.getInitialValue() as XNumberLiteral).getValue())
		xtendMember = xtendClazz.field(1)
		assertEquals("d", xtendMember.getName())
		assertEquals("2.5d", (xtendMember.getInitialValue() as XNumberLiteral).getValue())
	}

	@Test def void testNumberLiteralCase2() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			'''
		class TestStringLiteral {
			long l= 0x598df91c;
			double d = 0x43p-43;
			float f = 0x43p-43f;
		}''')

		var XtendField xtendMember = xtendClazz.field(0)
		assertEquals("l", xtendMember.getName())
		assertEquals("0x598df91c", (xtendMember.getInitialValue() as XNumberLiteral).getValue())
		xtendMember = xtendClazz.field(1)
		assertEquals("d", xtendMember.getName())
		assertEquals("7.617018127348274E-12", (xtendMember.getInitialValue() as XNumberLiteral).getValue())
		xtendMember = xtendClazz.field(2)
		assertEquals("f", xtendMember.getName())
		assertEquals("7.617018E-12f", (xtendMember.getInitialValue() as XNumberLiteral).getValue())

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
		var XtendFunction xtendMember = xtendClazz.method(0)
		assertEquals("doStuff", xtendMember.getName())
		typeParameter = xtendMember.getTypeParameters().get(0)
		assertEquals("D", typeParameter.getName())
		assertEquals("extends T", typeParameter.getConstraints().get(0).getSimpleName())
	}

	@Test def void testSimpleAssigmentCase() throws Exception {
		var XtendClass xtendClazz = toValidXtendClass("class TestAssiment {  
				void doStuff() {
					String x = null;
					x = new String();
				}
			}")
		assertNotNull(xtendClazz)
	}

	@Test def void testMultiDeclaration() throws Exception {
		var XtendClass xtendClazz = toValidXtendClass("class Test { 
				int i,j=0;
				void doStuff() {
					String x,y = null;
				}
			}")
		assertNotNull(xtendClazz)
	}

	@Test def void testAssertCase() throws Exception {
		var XtendClass xtendClazz = toValidXtendClass("class Test {  
				void doStuff() {
					String x = null;
					assert(x!=null);
				}
			}")
		assertNotNull(xtendClazz)
	}

	@Test def void testSimpleInstanceOfCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"class Test {  void doStuff() { String x = null; if(!(x instanceof String)) x = \"\";}")
		assertNotNull(xtendClazz)
	}

	@Test def void testCommentsCase_01() throws Exception {
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
				return; // rt SL comment
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
			def package void doStuff() {
				/*
				 multiline
				*/
				
			}
			/**/
			def package void doStuff2() {
				/* some comments */
				return;// rt SL comment
				
			}
		}'''
		assertEquals(expected, xtendCode)
	}
	
	@Test def void testCommentsCase_02() throws Exception {
		var xtendCode = toXtendCode(
			'''
		public class TestComment {
			String field = "d"; // last SL comment
		}''')
		val expected = '''
		class TestComment {
			package String field="d"// last SL comment
			
		}'''
		assertEquals(expected, xtendCode)
	}

	@Test def void testJavadocCase_01() throws Exception {

		var String xtendCode = j2x.bodyDeclarationToXtend("/**@param p Param p*/public abstract void foo();", null,
			null).xtendCode
		assertTrue('''Javadoc Parameter well formed: «xtendCode»''', xtendCode.contains("@param p Param p"))
	}
	
	@Test def void testJavadocCase_02() throws Exception {

		var String xtendCode = '''
			/**
			 * Copyright (c) 2015 - javadocteststring
			 **/
			package foo.javadoc;
				
			import java.util.Arrays;
				
			/**
			 * Simple value
			 * @author Dennis Huebner - Initial contribution and API
			 */
			public class TestJavadoc {
			}
		'''.toXtendCode
		dump(xtendCode)
		assertTrue('''Classfile Doc not copied''', xtendCode.contains("javadocteststring"))
		assertEquals('''Classfile Doc copied once''', 2, Splitter.on("javadocteststring").split(xtendCode).size)
		assertTrue('''Type Javadoc not copied''', xtendCode.contains("@author"))
		assertEquals('''Type Javadoc not copied once''', 2, Splitter.on("@author").split(xtendCode).size)
	}

	@Test def void testJavadocCase_03() throws Exception {

		var String xtendCode = j2x.bodyDeclarationToXtend("public abstract void foo() { /** orphaned javadoc */ };", null, null).
			xtendCode
		assertEquals('''Javadoc Parameter well formed: «xtendCode»''', 
		'''
		def abstract void foo() {
			/** 
			 * orphaned javadoc 
			 */
			
		}'''.toString, xtendCode)
	}

	@Test def void testCastCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"public class TestCast { void doStuff() { Object o = (Object)this;}")
		assertNotNull(xtendClazz)
	}

	@Test def void testIfElseCase_01() throws Exception {

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

	@Test def void testIfElseCase_02() throws Exception {
		assertEquals('''
		var Class<?> c=String 
		if (c instanceof Class) {
			c=null 
		} else {
			c=Boolean 
		}'''.toString, '''
		Class<?> c = String.class;
		if(c instanceof Class) {
			c = null;
		} else {
			c = Boolean.class;
		}'''.toXtendStatement)
	}



	@Test def void testStaticImportCase() throws Exception {

		var XtendClass xtendClazz = toValidXtendClass(
			"import static java.awt.AWTEvent.*; public class Test { long o= ACTION_EVENT_MASK;}")

		var XtendField xtendMember = xtendClazz.getMembers().get(0) as XtendField
		assertEquals("o", xtendMember.getName())
		var XFeatureCall xFeatureCall = xtendMember.getInitialValue() as XFeatureCall
		assertEquals("ACTION_EVENT_MASK", xFeatureCall.getFeature().getSimpleName())
	}

	@Test def void testStaticAccessCase() throws Exception {
		j2x.useRobustSyntax
		var XtendClass xtendClazz = toValidXtendClass(
			'''
		public class Test2 {
			URI getURI(){
					int i = URI.FRAGMENT_FIRST_SEPARATOR;
					if(URI.FRAGMENT_FIRST_SEPARATOR==0) return null;
				return URI.createURI("myURI")
			}
			static class URI {
				static int FRAGMENT_FIRST_SEPARATOR=0;
				static URI createURI(String str) {
					return (URI)null;
				}
			}
		}''')
		var xtendMember = xtendClazz.method(0)
		assertEquals("getURI", xtendMember.getName())
	}

	@Test def void testStaticAccessCase2() throws Exception {
		var XtendClass xtendClazz = toValidXtendClass(
		'''
		import java.util.Map;
		import java.util.Map.Entry;
		public abstract class Test implements Map.Entry<String,String>{}
		''')
		assertNotNull(xtendClazz)
	}

	@Test def void testInnerClassCase() throws Exception {

		var ConversionResult conversionResult = j2x.toXtend("Clazz", '''
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

	@Test def void testInnerIntefaceCase() throws Exception {

		var type = toValidXtendClass(
			'''
		public class Clazz {
			interface Inner {
				void test();
			}
		}
		interface Test{}''')
		val inner = type.members.get(0)
		assertTrue(inner instanceof XtendInterface)
		val xtendInterfaze = inner as XtendInterface
		assertEquals(PUBLIC, xtendInterfaze.visibility)
		assertEquals(PUBLIC, xtendInterfaze.method(0).visibility)

	}

	@Test def void testStaticBlockCase() throws Exception {
		var conversionResult = toValidXtendClass("public class Clazz { static String foo;static{foo=\"\";}}")
		assertEquals("foo", conversionResult.field(0).name)
	}

	@Test def void testStaticBlockCase1() throws Exception {
		var ConversionResult conversionResult = j2x.toXtend("Clazz",
			"public class Clazz { static final String foo;static{foo=\"\";}}")
		var String xtendCode = conversionResult.getXtendCode()
		assertFalse(xtendCode.isEmpty())
		dump(xtendCode)
		assertEquals(1, Iterables.size(conversionResult.getProblems()))
	}

	@Test def void testStaticBlockCase2() throws Exception {
		var conversionResult = toValidXtendClass(
			'''
			public class Clazz {
				static final String foo=null;
				static {
					String foo;
					foo = "bar";
					//Clazz.foo = "";
				}
			}
		''')
		assertEquals("foo", conversionResult.field(0).name)
	}

	@Test def void testStaticBlockCase3() throws Exception {
		var conversionResult = j2x.toXtend("Clazz", '''
			public class Clazz {
				static final String foo;
				static {
					String foo;
					foo = "bar";
					Clazz.foo = "";
				}
			}
		''')
		var String xtendCode = conversionResult.getXtendCode()
		assertFalse(xtendCode.isEmpty())
		dump(xtendCode)
		assertEquals(1, Iterables.size(conversionResult.getProblems()))
	}

	@Test def void testConstructorCase() throws Exception {
		var XtendClass clazz = toValidXtendClass("public class Clazz { public Clazz(){this(1);}public Clazz(int i){}}")
		assertEquals(PUBLIC, (clazz.getMembers().get(0) as XtendConstructor).getVisibility())
		assertEquals(PUBLIC, (clazz.getMembers().get(1) as XtendConstructor).getVisibility())
	}

	@Test def void testSuperCalls() throws Exception {

		var XtendClass clazz = toValidXtendClass('''
			import java.awt.TextField;
			public class Clazz extends TextField {
				public Clazz() {
					super();
				}
				
				public Clazz(String txt) {
					super(txt);
				}
				
				@Override
				public String toString() {
					Object o = super.textListener;
					return super.toString();
				}
			}
		''')
		assertEquals(PUBLIC, (clazz.getMembers().get(0) as XtendConstructor).getVisibility())
	}

	@Test def void testEnumCase() throws Exception {
		var enum = toValidXtendEnum('public enum MyEnum { NEW,OLD }')
		assertEquals(PUBLIC, (enum.getMembers().get(0) as XtendEnumLiteral).getVisibility())
		assertEquals(PUBLIC, (enum.getMembers().get(1) as XtendEnumLiteral).getVisibility())
	}

	@Test def void testEnumCase1() throws Exception {
		var enum = toValidXtendClass('public class MyClazz{
	 			enum MyEnum { NEW }
			}')
		assertEquals(DEFAULT, (enum.getMembers().get(0) as XtendEnum).getVisibility())
	}

	@Test def void testEnumNotSupportedCase() throws Exception {
		var enum = j2x.toXtend("MyEnum", 'public enum MyEnum {
				NEW(1), OLD(2);
				private MyEnum(int value) {}
			}
			')

		assertEquals(3, enum.problems.size)
	}

	@Test def void testEnumNotSupportedCase2() throws Exception {
		var enum = j2x.toXtend("MyEnum", 'public enum MyEnum  implements Enumerator {
				NEW
			}
			')

		assertEquals(1, enum.problems.size)
	}

	@Test def void testEnumNotSupportedCase3() throws Exception {
		var enum = j2x.toXtend("MyClazz", 'public class MyClazz{
	 			enum MyEnum implements Enumerator{ NEW }
			}
			')
		assertEquals(1, enum.problems.size)
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

	@Test def void testArrayAccessCaseConstantIndex_01() throws Exception {
		var String xtendCode = toXtendStatement('''
			String[] ar = new String[]{};
			String n = ar[1];
		''')
		assertEquals('''
		var String[] ar=#[] 
		var String n=ar.get(1)'''.toString, xtendCode)
	}

	@Test def void testArrayAccessCaseConstantIndex_02() throws Exception {
		var String xtendCode = toXtendStatement('''
			String[] ar = new String[]{};
			ar[1] = null;
		''')
		assertEquals('''
		var String[] ar=#[] 
		{ val _wrVal_ar=ar _wrVal_ar.set(1,null)}'''.toString, xtendCode)
	}

	@Test def void testArrayCreationCase() throws Exception {
		var XtendClass clazz = toValidXtendClass(
			'''
		import java.util.Arrays
		import java.util.HashSet
		import java.util.Set
		public class Clazz {
			int as[] = new int[1];
			// int[] as2;
			// int[][] as4;
			// int[] as5 = as;
			int[] as2,as4[],as5 = as[];
			final int callCount[] = new int[]{0};
			byte[] buffer = new byte[512];
			String[] arr = new String[]{"",""};
			
			Class<?>[] argTypes = new Class[arr.length];
		}''')
		assertNotNull(clazz)
	}

	@Test def void testArrayCreationCase2() throws Exception {
		j2x.useRobustSyntax
		var xtendCode = toXtendClassBodyDeclr(
			'private List<String> l=Arrays.asList(new String[] { "AType", "RootRule" });')
		assertEquals('List<String> l=Arrays.asList((#["AType", "RootRule"] as String[]))', xtendCode)
	}

	@Test def void testArrayShiftDimensionCase() throws Exception {
		val xtendCode = '''
			private int ar[] = new int[1];
			public void arDim() {
				int ar2[] = new int[2];
			}
		'''
		assertEquals('''
		int[] ar=newIntArrayOfSize(1)
		def void arDim() {
			var int[] ar2=newIntArrayOfSize(2) 
		}'''.toString, toXtendClassBodyDeclr(xtendCode))
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
	
	@Test def void testArrayDimensionOnFragmentAsParameter() throws Exception {
		//Bug 476735
		var XtendClass clazz = toValidXtendClass(
			'''
		public class Clazz {
			String sa[];
			public static main(String args[]) {
				int i[] = null;
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
			public static void main(String[] args) {
					int[] ints = new int[]{1,2,40,44,5,6,7};
					int in = 3;
					System.out.println("44="+(ints[in]++));
					System.out.println("45="+(ints[in]--));
					System.out.println("43="+(--ints[in]));
					System.out.println("44="+(++ints[in]));
				}
		}''')
		assertNotNull(clazz)
	}

	@Test def void testPrefixPlusMinusArrayCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
		public class Clazz { 
			public static void main(String[] args) {
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
	
	@Test def void testPostfixArrayAccess() throws Exception {
		val javaCode = '''
			private int ar[] = new int[1];
			public void arPostReturn() {
				System.out.println(ar[0]++);
			}
			public void arPostNoReturn() {
				ar[0]++;
			}
		'''
		assertEquals('''
		int[] ar=newIntArrayOfSize(1)
		def void arPostReturn() {
			System.out.println({ var _postIndx_ar=0 var  _postVal_ar={val _rdIndx_ar=_postIndx_ar ar.get(_rdIndx_ar)}{ val _wrVal_ar=ar val _wrIndx_ar=_postIndx_ar _wrVal_ar.set(_wrIndx_ar,_postVal_ar + 1)}_postVal_ar }) 
		}
		def void arPostNoReturn() {
			{ var _postIndx_ar=0 var  _postVal_ar={val _rdIndx_ar=_postIndx_ar ar.get(_rdIndx_ar)}{ val _wrVal_ar=ar val _wrIndx_ar=_postIndx_ar _wrVal_ar.set(_wrIndx_ar,_postVal_ar + 1)} } 
		}'''.toString, toXtendClassBodyDeclr(javaCode))
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
			toXtendClassBodyDeclr("static String a = (i-i)+i+\"4=\"+(--i)+\"1=\"+(i++)+i;"))
	}

	@Test def void testRichStringCase1() throws Exception {
		assertEquals("int i=0\nString richTxt='''int i=«i».'''", toXtendClassBodyDeclr(
				'''
			private int i = 0;
			private String richTxt = "int "+"i="+i+".";
		'''))
	}

	@Test def void testRichStringCase2() throws Exception {
		assertEquals(
			"package String str='''Step: «info» memory: free / total / max MB «runtime.freeMemory() / (1000 * 1000)» / «runtime.totalMemory() / (1000 * 1000)» / «runtime.maxMemory() / (1000 * 1000)»'''",
			toXtendClassBodyDeclr(
				'''
				String str = "Step: " + info + " memory: free / total / max MB " + runtime.freeMemory() / (1000 * 1000) + " / " + runtime.totalMemory() / (1000 * 1000) + " / " + runtime.maxMemory() / (1000 * 1000)
			'''))
	}

	@Test def void testRichStringCase3() throws Exception {
		assertEquals("static package String a='''first line\nsecond line\nthird line\nfourth line'''",
			toXtendClassBodyDeclr('''static String a = "first line\n"+"second line\n"+"third line\n"+"fourth line";'''))
	}

	@Test def void testRichStringCase4() throws Exception {
		assertEquals(
			"public String someVar=\".\"
public String loadingURI='''classpath:/«('''«someVar»LoadingResourceWithError''').replace(Character.valueOf('.').charValue, Character.valueOf('/').charValue)».xtexterror'''",
			toXtendClassBodyDeclr(
				'''
				public String someVar=".";
				public String loadingURI = "classpath:/"
					+ (someVar + "LoadingResourceWithError").replace('.', '/')
					+ ".xtexterror";
			'''))
	}

	@Test def void testRichStringSpecialCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			"class Z { String richTxt = \"a\" +\"\" +\"'\" +\"s \" + \"''' no «'foo'.length» side-effect '''\";}")
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.getMembers().get(0) as XtendField
		assertEquals("richTxt", xtendMember.getName())
		assertFalse(xtendMember.getInitialValue() instanceof RichString)
	}

	@Test def void testRichStringSpecialCase2() throws Exception {
		var clazz = toValidXtendClass(
			"class Z { String richTxt = \"test\" + \"'''«FOR a: '123'.toCharArray SEPARATOR ',\\n  \\t'»\\n" + "a\\n" +
				"«ENDFOR»'''\";}")
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.getMembers().get(0) as XtendField
		assertEquals("richTxt", xtendMember.getName())
		assertFalse(xtendMember.getInitialValue() instanceof RichString)
	}

	@Test def void testRichStringSpecialCase3() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			"class Z {String richTxt = \"x(p1)} def dispatch x(int s) {'int'} def dispatch x(boolean s)\"+\" {'boolean'} def dispatch x(double s) {'double'\";}"
		)
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.getMembers().get(0) as XtendField
		assertEquals("richTxt", xtendMember.getName())
		assertTrue(xtendMember.getInitialValue() instanceof RichString)
	}

	@Test def void testRichStringSpecialCase4() throws Exception {

		var interfaze = toValidXtendInterface('interface Z {
				String CONSTANT_VAL = "SOMEVALUE" + "ADDITION";
				String CONSTANT_VAL2 = "SOMEVALUE" + CONSTANT_VAL;
			}')
		assertNotNull(interfaze)
		var xtendMember = interfaze.field(0)
		assertEquals("CONSTANT_VAL", xtendMember.getName())
		assertFalse(xtendMember.getInitialValue() instanceof RichString)
		xtendMember = interfaze.field(1)
		assertEquals("CONSTANT_VAL2", xtendMember.getName())
		assertFalse(xtendMember.getInitialValue() instanceof RichString)
	}

	@Test def void testReturnVoidCase() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
		class Z {
			public void ret() {
				if(true)
					return;
				System.out.println("");
			}	
		}''')
		assertNotNull(clazz)
	}
	
	@Test def void testReturnVoidCase_01() throws Exception {
		assertEquals('''
		def void foo() {
			if (true) return else System.out.println() 
		}'''.toString, 
		'''
		public void foo() {
			if(true) 
			    return;
			  else
			    System.out.println();
		}'''.toXtendClassBodyDeclr)
	}
	@Test def void testAnonymousClassCase() throws Exception {

		var result = j2x.toXtend("Clazz", '''
		import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;
		class Clazz {
			ActionListener listener = new ActionListener() {
				{/*not allowed*/}
					public void actionPerformed(ActionEvent arg0) {
						arg0.getID();
					}
			};
		}''')

		assertEquals(result.problems.size, 1)
		assertTrue(result.problems.get(0).startsWith("Initializer is not supported in AnonymousClassDeclaration"))
	}

	@Test def void testLambdaCase() throws Exception {

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

	@Test def void testLambdaCase2() throws Exception {

		var XtendClass clazz = toValidXtendClass(
			'''
		
		import java.util.ArrayList;
		import com.google.common.base.Function;
		import com.google.common.collect.Iterables;
		class Clazz {
			final int callCount[] = new int[]{0};
			Object fun = Iterables.transform(new ArrayList<String>(), new Function<String, String>(){
				public String apply(String param) {
					callCount[0]++;
					return null;
				}
			}));
		}''')
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.field(1)
		assertEquals("fun", xtendMember.getName())
	}

	@Test def void testLambdaCase3() throws Exception {
		j2x.useRobustSyntax
		var XtendClass clazz = toValidXtendClass(
			'''
		import java.util.Iterator;
		class Clazz {
				Iterable<String> iter = new AbstractIterable<String>() {
					@Override
					public Iterator<String> internalIterator() {
						return null;
					}
				};
				abstract static class AbstractIterable<T> implements Iterable<T> {
					@Override
					public Iterator<T> iterator() {
						return internalIterator();
					}
					public abstract Iterator<T> internalIterator();
				}
		}''')
		assertNotNull(clazz)
		var XtendField xtendMember = clazz.field(0)
		assertEquals("iter", xtendMember.getName())
		assertTrue(xtendMember.getInitialValue() instanceof XCastedExpression)
		assertTrue((xtendMember.getInitialValue() as XCastedExpression).target instanceof XClosure)
	}

	@Test def void testSLCommentCase() throws Exception {
		var clazz = toXtendCode(
			'''
		class Clazz {
			//Single Line comment
			String str;
		}''')
		dump(clazz)
		assertEquals('''
		package class Clazz {
			//Single Line comment
			package String str
		}'''.toString, clazz)
	}

	@Test def void testSwitchCase() throws Exception {
		var clazz = toXtendClassBodyDeclr(
			'''
		private String doSwitch() {
			int i = 0;
			switch (i) {
				case 1:
					// switch int
					i++
					return "1";
				case 2: {
					return "2";
				}
				default:
					return "0";
			}
		}''')
		assertEquals('''
		def private String doSwitch() {
			var int i=0 
			
			switch (i) {
				case 1:{
					// switch int
					i++ return "1" 
				}
				case 2:{
					return "2" 
				}
				default :{
					return "0" 
				}
			}
		}'''.toString, clazz)
	}

	@Test def void testSwitchCase2() throws Exception {
		var clazz = toValidXtendClass(
			'''
		public class FooSwitch {
			private void doSwitch2() {
				int i = 0;
				switch (i) {
					case 1:
						i++;
						return;
					case 2: {
						return;
					}
					default:
						return;
				}
			}
		}''')
		assertNotNull(clazz)
	}
	
	@Test def void testSwitchCase3() throws Exception {
		var clazz = toValidXtendClass(
			'''
			public class Foo {
				public void doStuff() {
					switch (1) {
						case 1:
						case 2:
							System.out.println();
						case 3: {
						}
					}
				public void doStuff2() {
					switch (1) {
						case 1:
						case 2:
							System.out.println();
						case 3:
					}
				}
				public void doStuff3() {
					switch (1) {
						case 1:
						case 2:
							System.out.println();
						case 3:
						default:
					}
				}
			}''')
		assertNotNull(clazz)
	}

	@Test def void testXORExpressionCase() throws Exception {
		var clazz = toValidXtendClass(
			'''
		public class XorCase {
			public void doXorOperation() {
				boolean b = true;
				if(true ^ b) {
					return;
				}
				if(b ^ b) {
					return;
				}
				if(b ^ false) {
					return;
				}
				int i = 1;
				if (((1 ^ 2 ^ 4) + (i ^ 2) - (3 ^ i) ^ 2) > i) {
					return;
				}
			}
			
		}''')
		assertNotNull(clazz)
	}
	
	@Test def void testFinalVariableEmptyInitializer() throws Exception {
		
		var ConversionResult conversionResult = j2x.toXtend("Foo", '''
		public class Foo {
			
			protected void doStuff() {
				final List<String> values, values2=null, values3;
				values = new ArrayList<String>();
			}
		}''')

		var String xtendCode = conversionResult.getXtendCode()
		assertFalse(xtendCode.isEmpty())
		dump(xtendCode)
		assertEquals(xtendCode,
			'''
			class Foo {
				def protected void doStuff() {
					val List<String> values/* FIXME empty initializer for final variable is not supported */ val List<String> values2=null val List<String> values3/* FIXME empty initializer for final variable is not supported */ 
					values=new ArrayList<String>() 
				}
			}'''.toString
		)
		assertEquals(2, Iterables.size(conversionResult.getProblems()))
		assertEquals("Empty initializer for final variables is not supported. (start: 70, length: 6)",conversionResult.getProblems().get(0))
		assertEquals("Empty initializer for final variables is not supported. (start: 92, length: 7)",conversionResult.getProblems().get(1))
	}

	@Test def void testIntegerBitwiseOperatorsCase() throws Exception {
		val java = '''
		public void doBitwiseOperation() {
			if ((1 & 2) > 0) {
				return;
			}
			if ((1 | 2) > 0) {
				return;
			}
		}'''
		var body = toXtendClassBodyDeclr(java)
		assertEquals('''
		def void doBitwiseOperation() {
			if ((1.bitwiseAnd(2)) > 0) {
				return;
			}
			if ((1.bitwiseOr(2)) > 0) {
				return;
			}
		}'''.toString, body)

	}

	@Test def void testBitwiseComplementCase() throws Exception {
		val javaBody = '''
		public void doBitwiseOperation() {
			int i = 1;
			i = ~i;
		}'''
		val clazz = toValidXtendClass('''class Test {«javaBody»}''')
		assertNotNull(clazz)
		var body = toXtendClassBodyDeclr(javaBody)
		assertEquals('''
		def void doBitwiseOperation() {
			var int i=1 
			i=i.bitwiseNot 
		}'''.toString, body)
	}
	
	@Test def void testBytePrimitive_01() throws Exception {
		val java = '''byte b = -1'''.toXtendClassBodyDeclr
		assertEquals('''byte b = (-1) as byte'''.toString, java)
	}
	
	@Test def void testBytePrimitive_02() throws Exception {
		val java = '''byte b = 1'''.toXtendClassBodyDeclr
		assertEquals('''byte b = 1 as byte'''.toString, java)
	}

	@Test def void testTryCatchCase() throws Exception {
		val javaBody = '''
		public void checkTryCatch() {
			try {
			
			} catch (final Exception e) {
				throw e;
			} finally {
				System.out.println();
			}
		}'''
		val clazz = toValidXtendClass('''class Test {«javaBody»}''')
		assertNotNull(clazz)
		var body = toXtendClassBodyDeclr(javaBody)
		assertEquals('''
		def void checkTryCatch() {
			try {
			} catch (Exception e) {
				throw e
			} finally {
				System.out.println() 
			}
		}'''.toString, body)

	}

	@Test def void testTryCatchCaseAsStatement() throws Exception {
		val javaBody = '''
		try {
		
		} catch (final Exception e) {
			throw new Exception();
		} catch (final Error e) {
			throw new Exception();
		}
		try {
		} finally {
			throw new Exception();
		}'''

		var statement = toXtendStatement(javaBody)
		assertEquals('''
		try {
		} catch (Exception e) {
			throw new Exception()
		} catch (Error e) {
			throw new Exception()
		}
		
		try {
		} finally {
			throw new Exception()
		}'''.toString, statement)

	}

	@Test def void testDoWhileStatement() throws Exception {
		val javaBody = '''
			int i = 0;
			do{
				System.out.println(i); 
				i++; 
			} while(i < 0);
			
			while(i < 10) {
				System.out.print(i);
				i++;
			}
		'''
		assertEquals('''
		var int i=0 
		do {
			System.out.println(i) 
			i++ 
		} while (i < 0)
		while (i < 10) {
			System.out.print(i) 
			i++ 
		}'''.toString, toXtendStatement(javaBody))

	}

	@Test def void testSynchronizedStatement() throws Exception {
		val javaBody = '''
			public void add(int value){
			   synchronized(this){
			      this.count += value;   
			   }
			 }
		'''
		assertEquals('''
		def void add(int value) {
			synchronized (this) {
				this.count+=value 
			}
		}'''.toString, toXtendClassBodyDeclr(javaBody))

	}

	@Test def void testAnnotationDeclaration() throws Exception {
		val javaBody = '''
		import java.lang.annotation.Documented;
		import java.lang.annotation.ElementType;
		import java.lang.annotation.Target;
		 
		@Documented
		@Target(ElementType.METHOD)
		public @interface MyAnno{
			String author() default "me";
			String date();
			int revision() default 1;
			String comments();
		}'''
		val clazz = toValidXtendAnnotation('''«javaBody»''')
		assertNotNull(clazz)
		var body = toXtendCode(javaBody)
		assertEquals('''
		import java.lang.annotation.Documented
		import java.lang.annotation.ElementType
		import java.lang.annotation.Target
		@Documented @Target(ElementType.METHOD)public annotation MyAnno {
		String author = "me"
		String date
		int revision = 1
		String comments
		}'''.toString, body)

	}
	
	@Test def void testBug462099() throws Exception {
		var xtendCode = toXtendCode('''
			public class Foo {
				public int foo(Object obj) {
					if (obj == null) {
						return 0;
					} else if (obj == "test") {
						return 1;
					} else if (obj != null) {
						return 2;
					} else {
						return 3;
					}
				}
			}
		''')
		val expected = '''
			class Foo {
				def int foo(Object obj) {
					if (obj === null) {
						return 0 
					} else if (obj === "test") {
						return 1 
					} else if (obj !== null) {
						return 2 
					} else {
						return 3 
					}
				}
			}'''
		assertEquals(expected, xtendCode)
	}
	
	@Test def void testBug462100() throws Exception {
		var xtendCode = toXtendCode('''
			public class Foo {
				@Override
				public String toString() {
					return "bar";
				}
			}
		''')
		val expected = '''
			class Foo {
				override String toString() {
					return "bar" 
				}
			}'''
		assertEquals(expected, xtendCode)
	}

	def protected XtendClass toValidXtendClass(CharSequence javaCode) throws Exception {
		return toValidTypeDeclaration("Clazz", javaCode) as XtendClass
	}

	def protected XtendAnnotationType toValidXtendAnnotation(String javaCode) throws Exception {
		return toValidTypeDeclaration("Anno", javaCode) as XtendAnnotationType
	}

	def protected XtendInterface toValidXtendInterface(String javaCode) throws Exception {
		return toValidTypeDeclaration("Interfaze", javaCode) as XtendInterface
	}

	def protected XtendEnum toValidXtendEnum(String javaCode) throws Exception {
		return toValidTypeDeclaration("EnumClazz", javaCode) as XtendEnum
	}

	def protected XtendTypeDeclaration toValidTypeDeclaration(String unitName, CharSequence javaCode) throws Exception {
		var XtendFile file = toValidXtendFile(unitName, javaCode)
		var XtendTypeDeclaration typeDeclaration = file.getXtendTypes().get(0)
		return typeDeclaration
	}

	def protected toXtendClassBodyDeclr(CharSequence string) {
		val xtendCode = j2x.bodyDeclarationToXtend(string.toString, null, null).getXtendCode().trim()
		dump(xtendCode)
		return xtendCode
	}

	def protected toXtendStatement(CharSequence string) {
		val xtendCode = j2x.statementToXtend(string.toString,null ).getXtendCode().trim()
		dump(xtendCode)
		return xtendCode
	}

	def protected XtendFile toValidXtendFile(String unitName, CharSequence javaCode) throws Exception {
		var conversionResult = j2x.toXtend(unitName, javaCode.toString)
		var xtendCode = conversionResult.getXtendCode()
		assertFalse(xtendCode.empty)
		dump(xtendCode)
		for (String problem : conversionResult.getProblems()) {
			dump('''ERROR: «problem»''')
		}
		return file(xtendCode, true)
	}

	def private String toXtendCode(CharSequence javaCode) throws Exception {
		return j2x.toXtend("Temp", javaCode.toString).getXtendCode()
	}

	def XtendField field(XtendTypeDeclaration typeDecl, int i) {
		typeDecl.members.get(i) as XtendField
	}

	def XtendFunction method(XtendTypeDeclaration typeDecl, int i) {
		typeDecl.members.get(i) as XtendFunction
	}

	def dump(String text) {
		if (DUMP) {
			println(text)
		}
	}
	
}
