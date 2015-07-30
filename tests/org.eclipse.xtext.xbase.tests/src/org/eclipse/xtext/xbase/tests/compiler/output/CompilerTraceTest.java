/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler.output;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.internal.AbstractTrace;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompilerTraceTest extends AbstractXbaseTestCase {
	
	public static class SimpleTrace extends AbstractTrace {

		private final AbstractTraceRegion root;

		public SimpleTrace(AbstractTraceRegion root) {
			this.root = root;
		}
		
		@Override
		protected AbstractTraceRegion doGetRootTraceRegion() {
			return root;
		}
		
		@Override
		/* @NonNull */
		public IProjectConfig getLocalProjectConfig() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		/* @NonNull */
		public AbsoluteURI getLocalURI() {
			throw new UnsupportedOperationException();
		}

		@Override
		/* @NonNull */
		protected InputStream getContents(/* @NonNull */ SourceRelativeURI uri, /* @NonNull */ IProjectConfig project) throws IOException {
			throw new UnsupportedOperationException();
		}

		@Override
		protected Reader getContentsAsText(SourceRelativeURI uri, IProjectConfig projectConfig) throws IOException {
			return null;
		}

		@Override
		protected Reader getLocalContentsAsText(IProjectConfig projectConfig) throws IOException {
			return null;
		}
		
	}
	
	@Inject 
	private ITraceURIConverter converter;
	
	@Inject
	private ILocationInFileProvider locationProvider;
	
	@Inject
	private IJvmModelAssociations jvmModelAssociations;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Test 
	public void testNullLiteral() throws Exception {
		assertTrace("\nreturn #null#;", "#null#");
	}
	
	@Test 
	public void testStringLiteral() throws Exception {
		assertTrace("\nreturn #\"fo\\no\"#;", "#'fo\no'#");
	}
	
	@Test
	public void testStringLiteral_02() throws Exception {
		assertTrace("\nreturn \"f#o\\n#o\";", "#'fo\no'#");
	}
	
	@Test
	public void testFeatureCall_01() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _newArrayList = CollectionLiterals.<Object>newA#rray#List();\n" + 
				"return _newArrayList;", 
				"#newArrayList#");
	}
	
	@Test
	public void testFeatureCall_02() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _newArrayList = CollectionLiterals.<Object>newA#rrayList(#);\n" + 
				"return _newArrayList;", 
				"#newArrayList()#");
	}
	
	@Test
	public void testFeatureCall_03() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _newArrayList = CollectionLiterals.<Object>newA#rrayList#();\n" + 
				"return _newArrayList;", 
				"#newArrayList#()");
	}
	
	@Test
	public void testFeatureCall_04() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<String>newA#rrayList#();\n" + 
				"return _newArrayList;", 
				"<String>#newArrayList#()");
	}
	
	@Test
	public void testFeatureCall_05() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<Stri#ng>newArrayList#();\n" + 
				"return _newArrayList;", 
				"#<String>newArrayList()#");
	}
	
	@Test
	public void testFeatureCall_06() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<St#ri#ng>newArrayList();\n" + 
				"return _newArrayList;", 
				"<#String#>newArrayList()");
	}
	
	@Test
	public void testFeatureCall_07() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<String>newA#rrayList(\"a#\");\n" + 
				"return _newArrayList;", 
				"#newArrayList('a')#");
	}
	
	@Test
	public void testFeatureCall_08() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<String>ne#wArrayList(#);\n" + 
				"return _newArrayList;", 
				"<String>#newArrayList()#");
	}
	
	@Test
	public void testFeatureCall_09() throws Exception {
		assertTrace( 
				"\nArrayList<String> _newArrayList = CollectionLiterals.<String>#newArrayList()#;\n" + 
				"return _newArrayList;", 
				"<String>#newArrayList()#");
	}
	
	@Test
	public void testFeatureCall_10() throws Exception {
		assertTrace( 
				"\n" +
				"return CollectionLiterals.<String>new#ArrayL#ist();", 
				"{ <String>#newArrayList#(); }");
	}
	
	@Test
	public void testFeatureCall_11() throws Exception {
		assertTrace( 
				"\n" +
				"return CollectionLiterals.<Stri#ng>newAr#rayList();", 
				"{ #<String>newArrayList()#; }");
	}
	
	@Test
	public void testStaticFeatureCall_01() throws Exception {
		assertTrace( 
				"\nreturn String.CASE_INS#EN#SITIVE_ORDER;", 
				"String::#CASE_INSENSITIVE_ORDER#");
	}
	
	@Test
	public void testStaticFeatureCall_02() throws Exception {
		assertTrace( 
				"\nreturn St#r#ing.CASE_INSENSITIVE_ORDER;", 
				"#String#::CASE_INSENSITIVE_ORDER");
	}
	
	@Test
	public void testStaticFeatureCall_03() throws Exception {
		assertTrace( 
				"\nreturn Str#ing.CASE_INSEN#SITIVE_ORDER;", 
				"#String::CASE_INSENSITIVE_ORDER#");
	}
	
	@Test
	public void testStaticFeatureCall_04() throws Exception {
		assertTrace( 
				"\n" + 
				"List<Object> _emptyList = Collections.<Object>em#ptyL#ist();\n" + 
				"return _emptyList;", 
				"java::util::Collections::#emptyList#");
	}
	
	@Test
	public void testStaticFeatureCall_05() throws Exception {
		assertTrace( 
				"\n" + 
				"List<Object> _emptyList = Co#lle#ctions.<Object>emptyList();\n" + 
				"return _emptyList;", 
				"#java::util::Collections#::<Object>emptyList");
	}
	
	@Test
	public void testStaticFeatureCall_06() throws Exception {
		assertTrace( 
				"\n" + 
				"List<String> _singletonList = Collections.<S#tri#ng>singletonList(\"value\");\n" + 
				"return _singletonList;", 
				"java::util::Collections::<#String#>singletonList('value')");
	}
	
	@Test
	public void testStaticFeatureCall_07() throws Exception {
		assertTrace( 
				"\n" + 
				"List<String> _singletonList = Co#llections.<Stri#ng>singletonList(\"value\");\n" + 
				"return _singletonList;", 
				"#java::util::Collections::<String>singletonList('value')#");
	}
	
	@Test
	public void testStaticFeatureCall_08() throws Exception {
		assertTrace( 
				"\n" + 
				"List<String> _singletonList = Collections.<Stri#ng>singletonList(\"va#lue\");\n" + 
				"return _singletonList;", 
				"java::util::Collections::#<String>singletonList('value')#");
	}
	
	@Test
	public void testStaticFeatureCall_09() throws Exception {
		assertTrace( 
				"\n" + 
				"List<Object> _emptyList = Collections.<Object>em#ptyL#ist();\n" + 
				"return _emptyList;", 
				"java.util.Collections::#emptyList#");
	}
	
	@Test
	public void testStaticFeatureCall_10() throws Exception {
		assertTrace( 
				"\n" + 
				"List<Object> _emptyList = Co#lle#ctions.<Object>emptyList();\n" + 
				"return _emptyList;", 
				"#java.util.Collections#::<Object>emptyList");
	}
	
	@Test
	public void testStaticFeatureCall_11() throws Exception {
		assertTrace( 
				"\n" + 
				"List<String> _singletonList = Collections.<S#tri#ng>singletonList(\"value\");\n" + 
				"return _singletonList;", 
				"java.util.Collections::<#String#>singletonList('value')");
	}
	
	@Test
	public void testStaticFeatureCall_12() throws Exception {
		assertTrace( 
				"\n" + 
				"List<String> _singletonList = Co#llections.<Stri#ng>singletonList(\"value\");\n" + 
				"return _singletonList;", 
				"#java.util.Collections::<String>singletonList('value')#");
	}
	
	@Test
	public void testStaticFeatureCall_13() throws Exception {
		assertTrace( 
				"\n" + 
				"List<String> _singletonList = Collections.<Stri#ng>singletonList(\"va#lue\");\n" + 
				"return _singletonList;", 
				"java.util.Collections::#<String>singletonList('value')#");
	}
	
	@Test
	public void testStaticFeatureCallWithDot_01() throws Exception {
		assertTrace( 
				"\nreturn String.CASE_INS#EN#SITIVE_ORDER;", 
				"String.#CASE_INSENSITIVE_ORDER#");
	}
	
	@Test
	public void testStaticFeatureCallWithDot_02() throws Exception {
		assertTrace( 
				"\nreturn St#r#ing.CASE_INSENSITIVE_ORDER;", 
				"#String#.CASE_INSENSITIVE_ORDER");
	}
	
	@Test
	public void testStaticFeatureCallWithDot_03() throws Exception {
		assertTrace( 
				"\nreturn Str#ing.CASE_INSEN#SITIVE_ORDER;", 
				"#String.CASE_INSENSITIVE_ORDER#");
	}
	
	@Test
	public void testStaticFeatureCallWithDot_04() throws Exception {
		assertTrace( 
				"\n" + 
				"List<Object> _emptyList = Collections.<Object>em#ptyL#ist();\n" + 
				"return _emptyList;", 
				"java.util.Collections.#emptyList#");
	}
	
	@Test
	public void testStaticFeatureCallWithDot_05() throws Exception {
		assertTrace( 
				"\n" + 
				"List<Object> _emptyList = Co#lle#ctions.<Object>emptyList();\n" + 
				"return _emptyList;", 
				"#java.util.Collections#.<Object>emptyList");
	}
	
	@Test
	public void testStaticFeatureCallWithDot_06() throws Exception {
		assertTrace( 
				"\n" + 
				"List<String> _singletonList = Collections.<S#tri#ng>singletonList(\"value\");\n" + 
				"return _singletonList;", 
				"java.util.Collections.<#String#>singletonList('value')");
	}
	
	@Test
	public void testStaticFeatureCallWithDot_07() throws Exception {
		assertTrace( 
				"\n" + 
				"List<String> _singletonList = Co#llections.<Stri#ng>singletonList(\"value\");\n" + 
				"return _singletonList;", 
				"#java.util.Collections.<String>singletonList('value')#");
	}
	
	@Test
	public void testStaticFeatureCallWithDot_08() throws Exception {
		assertTrace( 
				"\n" + 
				"List<String> _singletonList = Collections.<Stri#ng>singletonList(\"va#lue\");\n" + 
				"return _singletonList;", 
				"java.util.Collections.#<String>singletonList('value')#");
	}
	
	@Test
	public void testConstructorCall_01() throws Exception {
		assertTrace( 
				"\nString _string = new S#tri#ng();\n" +
				"return _string;", 
				"new #String#");
	}
	
	@Test
	public void testConstructorCall_02() throws Exception {
		assertTrace( 
				"\nString _string = n#e#w String();\n" +
				"return _string;", 
				"#new String#()");
	}
	
	@Test
	public void testConstructorCall_03() throws Exception {
		assertTrace( 
				"\nString _string = new Str#ing(\"Ar#gs\");\n" +
				"return _string;", 
				"#new String('Args')#");
	}
	
	@Test
	public void testConstructorCall_04() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _arrayList = new Array#List<#Object>();\n" +
				"return _arrayList;", 
				"new #java.util.ArrayList#");
	}
	
	@Test
	public void testConstructorCall_05() throws Exception {
		assertTrace( 
				"\nArrayList<String> _arrayList = new ArrayList<S#trin#g>(5);\n" +
				"return _arrayList;", 
				"new java.util.ArrayList<#String#>(5)");
	}
	
	@Test
	public void testConstructorCall_06() throws Exception {
		assertTrace( 
				"\nArrayList<String> _arrayList = new Arr#ayLi#st<String>(5);\n" +
				"return _arrayList;", 
				"new #java.util.ArrayList#<String>(5)");
	}
	
	@Test
	public void testConstructorCall_07() throws Exception {
		assertTrace( 
				"\nArrayList<String> _a#rra#yList = new ArrayList<String>();\n" +
				"return _arrayList;", 
				"#new java.util.ArrayList<String>#");
	}
	
	@Test
	public void testConstructorCall_08() throws Exception {
		assertTrace( 
				"\nArrayList<String> _a#rra#yList = new ArrayList<String>(5);\n" +
				"return _arrayList;", 
				"#new java.util.ArrayList<String>(5)#");
	}
	
	@Test
	public void testConstructorCall_09() throws Exception {
		assertTrace( 
				"\nArrayList<Object> _arrayList = new Array#List<#Object>(5);\n" +
				"return _arrayList;", 
				"((new #java.util.ArrayList#(5)))");
	}
	
	@Test
	public void testConstructorCall_10() throws Exception {
		assertTrace( 
				"\nArrayList<String> _a#rra#yList = new ArrayList<String>(5);\n" +
				"return _arrayList;", 
				"((#new java.util.ArrayList<String>(5)#))");
	}
	
	@Test
	public void testMemberFeatureCall_01() throws Exception {
		assertTrace( 
				"\n" + 
				"String _string = \"\".toString();\n" + 
				"String _string_1 = _string.#toString#();\n" + 
				"return _string_1;", 
				"''.toString.#toString#()");
	}

	@Test
	public void testMemberFeatureCall_02() throws Exception {
		assertTrace( 
				"\n" + 
				"String _string = \"\".toS#tr#ing();\n" + 
				"String _string_1 = _string.toString();\n" + 
				"return _string_1;", 
				"''.#toString#().toString");
	}
	
	@Test
	public void testMemberFeatureCall_03() throws Exception {
		assertTrace( 
				"\n" + 
				"String _string = \"\".toString();\n" + 
				"String _string_1 = _stri#ng.to#String();\n" + 
				"return _string_1;", 
				"#''.toString.toString#");
	}
	
	@Test
	public void testMemberFeatureCall_04() throws Exception {
		assertTrace( 
				"\n" + 
				"St#ri#ng _string = \"\".toString();\n" + 
				"String _string_1 = _string.toString();\n" + 
				"return _string_1;", 
				"#''.toString()#.toString");
	}
	
	@Test
	public void testMemberFeatureCall_05() throws Exception {
		assertTrace( 
				"\n" + 
				"String _string = \"\".#toString()#;\n" + 
				"return _string;", 
				"''.#toString()#");
	}
	
	@Test
	public void testForLoop_01() throws Exception {
		assertTrace( 
				"\n" + 
				"IntegerRange _upTo = new IntegerRange(1, 2);\n" + 
				"for (final int lo#o#p : _upTo) {\n" + 
				"  Integer.valueOf(loop).toString();\n" + 
				"}", 
				"for(int #loop#: 1..2) loop.toString");
	}
	
	@Test
	public void testForLoop_02() throws Exception {
		assertTrace( 
				"\n" + 
				"IntegerRange _upTo = new IntegerRange(1, 2);\n" + 
				"for (final i#n#t loop : _upTo) {\n" + 
				"  Integer.valueOf(loop).toString();\n" + 
				"}", 
				"for(#int# loop: 1..2) loop.toString");
	}
	
	@Test
	public void testForLoop_03() throws Exception {
		assertTrace( 
				"\n" + 
				"IntegerRange _upTo = new IntegerRange(1, 2);\n" + 
				"for (fi#n#al int loop : _upTo) {\n" + 
				"  Integer.valueOf(loop).toString();\n" + 
				"}", 
				"for(#int loop#: 1..2) loop.toString");
	}
	
	@Test
	public void testForLoop_04() throws Exception {
		assertTrace( 
				"\n" + 
				"Int#egerRa#nge _upTo = new IntegerRange(1, 2);\n" + 
				"for (final Integer loop : _upTo) {\n" + 
				"  loop.toString();\n" + 
				"}", 
				"for(loop: #1..2#) loop.toString");
	}
	
	@Test
	public void testForLoop_05() throws Exception {
		assertTrace( 
				"\n" + 
				"IntegerRange _upTo = new IntegerRange(1, 2);\n" + 
				"f#o#r (final Integer loop : _upTo) {\n" + 
				"  loop.toString();\n" + 
				"}", 
				"(( #for(loop: 1..2) (loop.toString)# ))");
	}
	
	@Test
	public void testTryCatch_01() throws Exception {
		assertTrace( 
				"\n" + 
				"Object _xtrycatchfinallyexpression = null;\n" + 
				"try {\n" + 
				"  _xtrycatchfinallyexpression = null;\n" + 
				"} catch (final Throwable _t) {\n" + 
				"  if (_t instanceof NullPointerException) {\n" + 
				"    final NullPointerException n#p#e = (NullPointerException)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else if (_t instanceof Exception) {\n" + 
				"    final Exception exception = (Exception)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else {\n" + 
				"    throw Exceptions.sneakyThrow(_t);\n" + 
				"  }\n" + 
				"}\n" + 
				"return _xtrycatchfinallyexpression;", 
				"try {} catch(NullPointerException #npe#) {} catch(Exception exception) {}");
	}
	
	@Test
	public void testTryCatch_02() throws Exception {
		assertTrace( 
				"\n" + 
				"Object _xtrycatchfinallyexpression = null;\n" + 
				"try {\n" + 
				"  _xtrycatchfinallyexpression = null;\n" + 
				"} catch (final Throwable _t) {\n" + 
				"  if (_t instanceof NullPointerException) {\n" + 
				"    final NullPointerException npe = (NullPointerException)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else if (_t instanceof Exception) {\n" + 
				"    final Exception ex#c#eption = (Exception)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else {\n" + 
				"    throw Exceptions.sneakyThrow(_t);\n" + 
				"  }\n" + 
				"}\n" + 
				"return _xtrycatchfinallyexpression;", 
				"try {} catch(NullPointerException npe) {} catch(Exception #exception#) {}");
	}
	
	@Test
	public void testTryCatch_03() throws Exception {
		assertTrace( 
				"\n" + 
				"Object _xtrycatchfinallyexpression = null;\n" + 
				"try {\n" + 
				"  _xtrycatchfinallyexpression = null;\n" + 
				"} catch (final Throwable _t) {\n" + 
				"  if (_t instanceof N#ull#PointerException) {\n" + 
				"    final NullPointerException npe = (NullPointerException)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else if (_t instanceof Exception) {\n" + 
				"    final Exception exception = (Exception)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else {\n" + 
				"    throw Exceptions.sneakyThrow(_t);\n" + 
				"  }\n" + 
				"}\n" + 
				"return _xtrycatchfinallyexpression;", 
				"try {} catch(#NullPointerException# npe) {} catch(Exception exception) {}");
	}
	
	@Test
	public void testTryCatch_04() throws Exception {
		assertTrace( 
				"\n" + 
				"Object _xtrycatchfinallyexpression = null;\n" + 
				"try {\n" + 
				"  _xtrycatchfinallyexpression = null;\n" + 
				"} catch (final Throwable _t) {\n" + 
				"  i#f# (_t instanceof NullPointerException) {\n" + 
				"    final NullPointerException npe = (NullPointerException)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else if (_t instanceof Exception) {\n" + 
				"    final Exception exception = (Exception)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else {\n" + 
				"    throw Exceptions.sneakyThrow(_t);\n" + 
				"  }\n" + 
				"}\n" + 
				"return _xtrycatchfinallyexpression;", 
				"try {} #catch(NullPointerException npe) {}# catch(Exception exception) {}");
	}
	
	@Test
	public void testTryCatch_05() throws Exception {
		assertTrace( 
				"\n" + 
				"Object _xtrycatchfinallyexpression = null;\n" + 
				"try {\n" + 
				"  _xtrycatchfinallyexpression = null;\n" + 
				"} catch (final Throwable _t) {\n" + 
				"  if (_t instanceof NullPointerException) {\n" + 
				"    fi#n#al NullPointerException npe = (NullPointerException)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else if (_t instanceof Exception) {\n" + 
				"    final Exception exception = (Exception)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else {\n" + 
				"    throw Exceptions.sneakyThrow(_t);\n" + 
				"  }\n" + 
				"}\n" + 
				"return _xtrycatchfinallyexpression;", 
				"try {} catch(#NullPointerException npe#) {} catch(Exception exception) {}");
	}
	
	@Test
	public void testTryCatch_06() throws Exception {
		assertTrace( 
				"\n" + 
				"Object _xtrycatchfinallyexpression = null;\n" + 
				"try {\n" + 
				"  _xtrycatchfinallyexpression = null;\n" + 
				"} catch (final Throwable _t) {\n" + 
				"  if (_t instanceof NullPointerException) {\n" + 
				"    final NullPointerException npe = (NullPointerException)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else if (_t instanceof Exception) {\n" + 
				"    final Exception exception = (Exception)_t;\n" + 
				"    _xtrycatchfinallyexpression = null;\n" + 
				"  } else {\n" + 
				"    thr#o#w Exceptions.sneakyThrow(_t);\n" + 
				"  }\n" + 
				"}\n" + 
				"return _xtrycatchfinallyexpression;", 
				"(( #try {} catch(NullPointerException npe) {} catch(Exception exception) {}# ))");
	}
	
	@Test
	public void testBinaryExpression_01() throws Exception {
		assertTrace( 
				"\n" + 
				"return (1 #+# 1);", 
				"#1 + 1#");
	}
	
	@Test
	public void testBinaryExpression_02() throws Exception {
		assertTrace( 
				"\n" + 
				"return (1 + 1#)#;", 
				"#1 + 1#");
	}
	
	@Test
	public void testBinaryExpression_03() throws Exception {
		assertTrace( 
				"\n" + 
				"return (#1 +# 1);", 
				"#1 + 1#");
	}
	
	@Test
	public void testBinaryExpression_04() throws Exception {
		assertTrace( 
				"\n" + 
				"return (#1# + 1);", 
				"#1# + 1");
	}
	
	@Test
	public void testBinaryExpression_05() throws Exception {
		assertTrace( 
				"\n" + 
				"return (1## + 1);", 
				"#1# + 1");
	}
	
	@Test
	public void testBinaryExpression_06() throws Exception {
		assertTrace( 
				"\n" + 
				"return (##1 + 1);", 
				"#1# + 1");
	}
	
	@Test
	public void testBinaryExpression_07() throws Exception {
		assertTrace( 
				"\n" + 
				"return (1 + ##1);", 
				"1 + #1#");
	}
	
	@Test
	public void testBinaryExpression_08() throws Exception {
		assertTrace( 
				"\n" + 
				"return (1 + 1##);", 
				"1 + #1#");
	}
	
	@Test
	public void testBinaryExpression_09() throws Exception {
		assertTrace( 
				"\n" + 
				"return (1 + #1#);", 
				"( (( 1 )) + (  #1#/*comment*/  ))");
	}
	
	@Test
	public void testBinaryExpression_10() throws Exception {
		assertTrace( 
				"\n" + 
				"BigInteger _plus = #BigInteger.ONE#.add(BigInteger.valueOf(2L));\n" + 
				"return _plus;", 
				"#1bi# + 2bi");
	}
	
	@Test
	public void testBinaryExpression_11() throws Exception {
		assertTrace( 
				"\n" + 
				"BigInteger _plus = BigInteger.TEN.a#dd(new B#igInteger(\"12345678901234567890\"));\n" + 
				"return _plus;", 
				"#10bi + 12345678901234567890bi#");
	}
	
	@Test
	public void testBinaryExpression_12() throws Exception {
		assertTrace( 
				"\n" + 
				"BigInteger _plus = BigInteger.TEN.add(ne#w B#igInteger(\"99999999999999000000000\"));\n" + 
				"return _plus;", 
				"10bi + #99999999999999e+9bi#");
	}
	
	@Test
	public void testBinaryExpression_13() throws Exception {
		assertTrace( 
				"\n" + 
				"BigInteger _plus = BigInteger.TEN.add(ne#w B#igInteger(\"123\").multiply(BigInteger.TEN.pow(52)));\n" + 
				"return _plus;", 
				"10bi + #123e+52bi#");
	}
	
	@Test
	public void testUnaryExpression_01() throws Exception {
		assertTrace( 
				"\n" + 
				"return (#-#1);", 
				"#- 1#");
	}
	
	@Test
	public void testUnaryExpression_02() throws Exception {
		assertTrace( 
				"\n" + 
				"return (-#1#);", 
				"-\n#1#");
	}
	
	@Test
	public void testUnaryExpression_03() throws Exception {
		assertTrace( 
				"\n" + 
				"return #(#-1);", 
				"(( #- (1)#))");
	}
	
	@Test
	public void testUnaryExpression_04() throws Exception {
		assertTrace( 
				"\n" + 
				"Big#In#teger _minus = BigInteger.valueOf(1234L).negate();\n" + 
				"return _minus;", 
				"(( #- (1_234bi\n)#\n))");
	}
	
	@Test
	public void testSwitchExpression_01() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final String _switchValue = \"\";\n" + 
				"boolean _matched = false;\n" + 
				"if (!_m#a#tched) {\n" + 
				"  if (Objects.equal(_switchValue, \"\")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, \" \")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch('') { #case '': ''# case ' ': '' }");
	}
	
	@Test
	public void testSwitchExpression_02() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final String _switchValue = \"\";\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, #\"\"#)) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, \" \")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch('') { case #''#: '' case ' ': '' }");
	}
	
	@Test
	public void testSwitchExpression_03() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final String _switchValue = \"\";\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, \"\")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = #\"\"#;\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, \" \")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch('') { case '': #''# case ' ': '' }");
	}
	
	@Test
	public void testSwitchExpression_04() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final String _switchValue = #\"\"#;\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, \"\")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, \" \")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch(#''#) { case '': '' case ' ': '' }");
	}
	
	@Test
	public void testSwitchExpression_05() throws Exception {
		assertTrace( 
				"\n" + 
				"String _swi#tc#hResult = null;\n" + 
				"final String _switchValue = \"\";\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, \"\")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, \" \")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"#switch '' { case '': '' case ' ': '' }#");
	}
	
	@Test
	public void testSwitchExpression_06() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final String _switchValue = \"\";\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(_switchValue, \"\")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  _switch#R#esult = \"\";\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch '' { case '': '' #default: ''# }");
	}
	
	@Test
	public void testSwitchExpression_11() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final String it = \"\";\n" + 
				"boolean _matched = false;\n" + 
				"if (!_#mat#ched) {\n" + 
				"  int _length = it.length();\n" + 
				"  boolean _equals = (_length == 0);\n" + 
				"  if (_equals) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(it, \"\")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch it:'' { #case length==0: ''# case '': '' }");
	}
	
	@Test
	public void testSwitchExpression_12() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final String #it# = \"\";\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  int _length = it.length();\n" + 
				"  boolean _equals = (_length == 0);\n" + 
				"  if (_equals) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (Objects.equal(it, \"\")) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch #it#:'' { case length==0: '' case '': '' }");
	}
	
	@Test
	public void testSwitchExpression_21() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final Object it = null;\n" + 
				"boolean _matched = false;\n" + 
				"if (#!#_matched) {\n" + 
				"  if (it instanceof String) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch it:null { #String : ''# }");
	}
	
	@Test
	public void testSwitchExpression_22() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final Object it = null;\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (it instanceof St#ri#ng) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch it:null { #String# : '' }");
	}
	
	@Test
	public void testSwitchExpression_23() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final Object it = null;\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (it in#s#tanceof String) {\n" + 
				"    _matched=true;\n" + 
				"    _switchResult = \"\";\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch it:null { #String# : '' }");
	}
	
	@Test
	public void testSwitchExpression_31() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final Object it = null;\n" + 
				"boolean _matched = false;\n" + 
				"i#f (!_matched) {\n" + 
				"  if (it instanceof String) {\n" + 
				"    if (Objects.equal(it, \"\")) {\n" + 
				"      _matched=true;\n" + 
				"      _switchResult = \"\";\n" + 
				"    }\n" + 
				"  }#\n" + 
				"}\n" + 
				"return _switchResult;", 
				"switch it:null { #String case '': ''# }");
	}
	
	@Test
	public void testSwitchExpression_41() throws Exception {
		assertTrace( 
				"\n" + 
				"String _switchResult = null;\n" + 
				"final String s = \"\";\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (s instanceof String) {\n" + 
				"    int _length = s.length();\n" + 
				"    boolean _equals = (_length == 0);\n" + 
				"    if (_equals) {\n" + 
				"      _matched=true;\n" + 
				"      _switchResult = \"\";\n" + 
				"    }\n" + 
				"  }\n" + 
				"#}#\n" + 
				"return _switchResult;", 
				"switch s:'' { #String case s.length == 0: ''# }");
	}
	
	private static final Pattern p = Pattern.compile("([^#]*)#([^#]*)#([^#]*)", Pattern.DOTALL);
	
	protected void assertTrace(final String javaCodeWithMarker, String xbaseCodeWithMarker) throws Exception {
		xbaseCodeWithMarker = " " + xbaseCodeWithMarker + " ";
		Matcher xbaseMatcher = p.matcher(xbaseCodeWithMarker);
		assertTrue(xbaseMatcher.matches());
		String xbaseGroup1 = xbaseMatcher.group(1);
		String xbaseGroup2 = xbaseMatcher.group(2);
		String xbaseGroup3 = xbaseMatcher.group(3);
		String actualCode = xbaseGroup1 + xbaseGroup2 + xbaseGroup3; 
		XExpression model = expression(actualCode,true);
		TreeAppendable appendable = new TreeAppendable(new ImportManager(true), converter, locationProvider, jvmModelAssociations, model, "  ", "\n");
		XbaseCompiler compiler = get(XbaseCompiler.class);
		LightweightTypeReference returnType = typeResolver.resolveTypes(model).getReturnType(model);
		if (returnType == null) {
			throw new IllegalStateException();
		}
		compiler.compile(model, appendable, returnType);
		String compiledJavaCode = appendable.getContent();
		Matcher javaMatcher = p.matcher(javaCodeWithMarker);
		assertTrue(javaMatcher.matches());
		String javaGroup1 = javaMatcher.group(1);
		String javaGroup2 = javaMatcher.group(2);
		String javaGroup3 = javaMatcher.group(3);
		String actualExpectation = javaGroup1 + javaGroup2 + javaGroup3;
		assertEquals(actualExpectation, compiledJavaCode);
		ITrace trace = new SimpleTrace(appendable.getTraceRegion());
		ILocationInResource location = trace.getBestAssociatedLocation(new TextRegion(javaGroup1.length(), javaGroup2.length()));
		if (location == null) {
			throw new IllegalStateException("location may not be null");
		}
		assertEquals(new TextRegion(xbaseGroup1.length(), xbaseGroup2.length()), location.getTextRegion());
	}
}
