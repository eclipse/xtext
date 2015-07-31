package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import java.util.List
import java.util.regex.Pattern
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtext.generator.trace.AbstractTraceRegion
import org.eclipse.xtext.generator.trace.ITraceRegionProvider
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.util.TextRegionWithLineInformation
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.junit.Ignore
import org.junit.Test
import org.eclipse.xtext.generator.IFilePostProcessor
import org.eclipse.xtext.generator.trace.SourceRelativeURI
import org.eclipse.emf.common.util.URI

/**
 * @author Sebastian Zarnekow
 */
class CompilerTraceTest extends AbstractXtendTestCase {
	
	@Inject JvmModelGenerator generator
	
	@Inject IGeneratorConfigProvider generatorConfigProvider

	@Inject extension IXtendJvmAssociations

	@Inject protected IFilePostProcessor postProcessor

	@Test
	def void testClassComment() throws Exception {
		'''
			package pack
			/**
			 * # my comment #
			 */
			class Zonk {}
		'''.tracesTo('''
			package pack;
			
			#/**
			 * my comment
			 */#
			@SuppressWarnings("all")
			public class Zonk {
			}
		''')
	}
	
	@Test
	def void testClassName() throws Exception {
		'''
			package pack
			/**
			 * my comment
			 */
			class Z#o#nk {}
		'''.tracesTo('''
			package pack;
			
			/**
			 * my comment
			 */
			@SuppressWarnings("all")
			public class #Zonk# {
			}
		''')
	}
	
	@Test
	def void testClassKeyword() throws Exception {
		'''
			package pack
			/**
			 * my comment
			 */
			cl#a#ss Zonk {}
		'''.tracesTo('''
			package pack;
			
			/**
			 * my comment
			 */
			#@SuppressWarnings("all")
			public class Zonk {
			}#
		''')
	}
	
	// TODO: this one should actually fail
	@Test
	def void testClassWithComment() throws Exception {
		'''
			package pack
			/**
			 *# my comment
			 */
			cla#ss Zonk {}
		'''.tracesTo('''
			#package pack;
			
			/**
			 * my comment
			 */
			@SuppressWarnings("all")
			public class Zonk {
			}
			#''')
	}
	
	@Test
	@Ignore("This one should succeed as soon as the case above is fixed")
	def void testClassWithComment_Ignored() throws Exception {
		'''
			package pack
			/**
			 *# my comment
			 */
			cla#ss Zonk {}
		'''.tracesTo('''
			package pack;
			#/**
			 * my comment
			 */
			@SuppressWarnings("all")
			public class Zonk {
			}#
			''')
	}
	
	@Test
	def void testClassTypeParamWithConstraint() throws Exception {
		'''
			package pack
			/**
			 * my comment
			 */
			class Zonk<P#ara#m extends Object> {}
		'''.tracesTo('''
			package pack;
			
			/**
			 * my comment
			 */
			@SuppressWarnings("all")
			public class Zonk<#Param# extends Object> {
			}
			''')
	}
	
	@Test
	def void testClassTypeParamUpperBound() throws Exception {
		'''
			package pack
			/**
			 * my comment
			 */
			class Zonk<Param extends O#bje#ct> {}
		'''.tracesTo('''
			package pack;
			
			/**
			 * my comment
			 */
			@SuppressWarnings("all")
			public class Zonk<Param extends #Object#> {
			}
			''')
	}
	
	// TODO: should this expect <#Param# extends Object> instead?
	@Test
	def void testClassTypeParamWithoutConstraint() throws Exception {
		'''
			package pack
			/**
			 * my comment
			 */
			class Zonk<P#ara#m> {}
		'''.tracesTo('''
			package pack;
			
			/**
			 * my comment
			 */
			@SuppressWarnings("all")
			public class Zonk<#Param extends Object#> {
			}
			''')
	}
	
	@Test
	def void testFieldComment() throws Exception {
		'''
			class Zonk {
				#/**
				 * my comment
				 *#/
				String s;
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  #/**
			   * my comment
			   */#
			  private String s;
			}
		''')
	}
	
	@Test
	def void testFieldName() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				String #s#;
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  private String #s#;
			}
		''')
	}
	
	@Test
	def void testFieldType() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				java.util.List<S#tri#ng> s;
			}
		'''.tracesTo('''
			import java.util.List;
			
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  private List<#String#> s;
			}
		''')
	}
	
	@Test
	def void testFieldDeclaration() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				Str#ing s#;
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  #private String s;#
			}
		''')
	}
	
	@Test
	def void testFieldDeclarationAndComment() throws Exception {
		'''
			class Zonk {
				/**
				 *# my comment
				 */
				String s#;
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  #/**
			   * my comment
			   */
			  private String s;#
			}
		''')
	}
	
	@Test
	def void testMethodComment() throws Exception {
		'''
			class Zonk {
				/#**
				 * my comment
				 */#
				def void s() {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  #/**
			   * my comment
			   */#
			  public void s() {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodName() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				def void #meth#od() {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public void #method#() {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodDeclaration() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				#def# void method() {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  #public void method() {
			  }#
			}
		''')
	}
	
	@Test
	def void testMethodDeclarationAndComment() throws Exception {
		'''
			class Zonk {
				#/**
				 * my comment
				 */
				d#ef void method() {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  #/**
			   * my comment
			   */
			  public void method() {
			  }#
			}
		''')
	}
	
	@Test
	def void testMethodReturnType() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				def v#oid# method() {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public #void# method() {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodParameter() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				def void method(Str#ing stri#ng) {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public void method(#final String string#) {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodParameterName() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				def void method(String s#tring#) {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public void method(final String #string#) {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodParameterType() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				def void method(java.lan#g.St#ring string) {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public void method(final #String# string) {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodParameterTypeWithGenerics() throws Exception {
		'''
			import java.util.List
			
			class Zonk {
				/**
				 * my comment
				 */
				def void method(Li#s#t<String> strings) {}
			}
		'''.tracesTo('''
			import java.util.List;
			
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public void method(final #List#<String> strings) {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodParameterFunctionType() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				def void method((S#tri#ng)=>int fun) {}
			}
		'''.tracesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public void method(final Function1<? super #String#, ? extends Integer> fun) {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodParameterFunctionTypeComplete() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				def void method((#String)=>i#nt fun) {}
			}
		'''.tracesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public void method(final #Function1<? super String, ? extends Integer># fun) {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodWithThrowsClause() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				def void method() throws Ex#cept#ion {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public void method() throws #Exception# {
			  }
			}
		''')
	}
	
	@Test
	def void testMethodWithThrowsClauseTwoExceptions() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				def void method() throws java.io.IOException, RuntimeEx#cept#ion {}
			}
		'''.tracesTo('''
			import java.io.IOException;
			
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public void method() throws IOException, #RuntimeException# {
			  }
			}
		''')
	}
	
	@Test
	def void testConstructorComment() throws Exception {
		'''
			class Zonk {
				/#**
				 * my comment
				 */#
				new() {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  #/**
			   * my comment
			   */#
			  public Zonk() {
			  }
			}
		''')
	}
	
	@Test
	def void testConstructorName() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				#ne#w() {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  public #Zonk#() {
			  }
			}
		''')
	}
	
	@Test
	def void testConstructorDeclaration() throws Exception {
		'''
			class Zonk {
				/**
				 * my comment
				 */
				#new(#) {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  /**
			   * my comment
			   */
			  #public Zonk() {
			  }#
			}
		''')
	}
	
	@Test
	def void testConstructorDeclarationAndComment() throws Exception {
		'''
			class Zonk {
				#/**
				 * my comment
				 */
				n#ew() {}
			}
		'''.tracesTo('''
			@SuppressWarnings("all")
			public class Zonk {
			  #/**
			   * my comment
			   */
			  public Zonk() {
			  }#
			}
		''')
	}
	
	@Test
	def void testDispatchMethodName_01() throws Exception {
		'''
			class Zonk {
				def dispatch void #meth#od(String s) {}
				def dispatch void method(Integer i) {}
			}
		'''.tracesTo('''
			import java.util.Arrays;

			@SuppressWarnings("all")
			public class Zonk {
			  protected void #_method#(final String s) {
			  }
			  
			  protected void _method(final Integer i) {
			  }
			  
			  public void method(final Object i) {
			    if (i instanceof Integer) {
			      _method((Integer)i);
			      return;
			    } else if (i instanceof String) {
			      _method((String)i);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(i).toString());
			    }
			  }
			}
		''')
	}
	
	@Test
	def void testDispatchMethodName_02() throws Exception {
		'''
			class Zonk {
				def dispatch void #meth#od(String s) {}
				def dispatch void method(Integer i) {}
			}
		'''.tracesTo('''
			import java.util.Arrays;

			@SuppressWarnings("all")
			public class Zonk {
			  protected void _method(final String s) {
			  }
			  
			  protected void _method(final Integer i) {
			  }
			  
			  public void #method#(final Object i) {
			    if (i instanceof Integer) {
			      _method((Integer)i);
			      return;
			    } else if (i instanceof String) {
			      _method((String)i);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(i).toString());
			    }
			  }
			}
		''')
	}
	
	@Test
	def void testDispatchMethodName_03() throws Exception {
		'''
			class Zonk {
				def dispatch void #meth#od(String s) {}
				def dispatch void method(Integer i) {}
			}
		'''.tracesTo('''
			import java.util.Arrays;

			@SuppressWarnings("all")
			public class Zonk {
			  protected void _method(final String s) {
			  }
			  
			  protected void _method(final Integer i) {
			  }
			  
			  public void method(final Object i) {
			    if (i instanceof Integer) {
			      _method((Integer)i);
			      return;
			    } #else if (i instanceof String) {
			      _method((String)i);
			      return;#
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(i).toString());
			    }
			  }
			}
		''')
	}
	
	private Pattern p = Pattern::compile("([^#]*)#([^#]*)#([^#]*)", Pattern::DOTALL);
	
	def tracesTo(CharSequence xtend, CharSequence java) {
		val xtendWithSpaces = " " + xtend + " "
		val xtendMatcher = p.matcher(xtendWithSpaces)
		assertTrue("xtendMatcher.matches", xtendMatcher.matches)
		val xtendGroup1 = xtendMatcher.group(1)
		val xtendGroup2 = xtendMatcher.group(2)
		val xtendGroup3 = xtendMatcher.group(3)
		
		val actualXtendCode = xtendGroup1 + xtendGroup2 + xtendGroup3 
		val file = file(actualXtendCode, true)
		val inferredType = (file.getXtendTypes.head as XtendClass).getInferredType
		var compiledCode = generator.generateType(inferredType, generatorConfigProvider.get(inferredType));
		compiledCode = postProcessor.postProcess(null, compiledCode);

		val javaMatcher = p.matcher(java.toString);
		assertTrue("javaMatcher.matches", javaMatcher.matches());
		val javaGroup1 = javaMatcher.group(1);
		val javaGroup2 = javaMatcher.group(2);
		val javaGroup3 = javaMatcher.group(3);
		val actualJavaExpectation = javaGroup1 + javaGroup2 + javaGroup3;
		assertEquals(actualJavaExpectation, compiledCode.toString);
		val trace = new SimpleTrace((compiledCode as ITraceRegionProvider).traceRegion.invertFor(
			new SourceRelativeURI(URI.createURI(file.eResource.URI.path)),
			new SourceRelativeURI(URI.createURI(file.eResource.URI.path))
		).merge)
		val locations = trace.getAllAssociatedLocations(new TextRegion(xtendGroup1.length(), xtendGroup2.length()));
		val expectedRegion = new TextRegion(javaGroup1.length(), javaGroup2.length())
		assertFalse(locations.empty)
		for(location: locations) {
			if (location.textRegion == expectedRegion)
				return
		}
		fail("locations did not match expectation: "+ locations + " / " + expectedRegion);
	}
	
	def AbstractTraceRegion merge(List<AbstractTraceRegion> regions) {
		assertTrue(!regions.empty)
		if (regions.size > 1) {
			var rootLocation = ITextRegionWithLineInformation::EMPTY_REGION;
			var associated = ITextRegionWithLineInformation::EMPTY_REGION;
			for(AbstractTraceRegion child: regions) {
				rootLocation = rootLocation.merge(new TextRegionWithLineInformation(child.getMyOffset(), child.getMyLength(), child.getMyLineNumber(), child.getMyEndLineNumber()));
				var childAssociation = child.getMergedAssociatedLocation();
				if (childAssociation != null)
					associated = associated.merge(childAssociation);
			}
			val root = new RootTraceRegionForTesting(rootLocation, associated)
			for(AbstractTraceRegion child: regions) {
				child.setParent(root);
			}
			return root;
		} else {
			return regions.head
		}
	}
	
}