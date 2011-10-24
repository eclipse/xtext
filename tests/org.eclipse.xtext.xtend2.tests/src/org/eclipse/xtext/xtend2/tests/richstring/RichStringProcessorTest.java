/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.richstring;

import java.util.Stack;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xtend2.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.IRichStringIndentationHandler;
import org.eclipse.xtext.xtend2.richstring.IRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringProcessorTest extends AbstractRichStringTest {
	
	protected static class StackChecker implements IRichStringIndentationHandler {

		private int i = 0;
		boolean wasCompletelyPopped = false;
		
		public void pushTemplateIndentation(CharSequence completeIndentation) {
			i++;
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
		}

		public void pushSemanticIndentation(CharSequence completeIndentation) {
			i++;
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
		}

		public void popIndentation() {
			i--;
			wasCompletelyPopped = i == 0;
			assertTrue("i>=0", i>=0);
		}

		public void accept(IRichStringPartAcceptor acceptor) {
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
		}

		public CharSequence getTotalSemanticIndentation() {
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
			return "";
		}

		public CharSequence getTotalIndentation() {
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
			return "";
		}
		
		protected void done(IRichStringPartAcceptor acceptor) {
			assertTrue("size is: " + i + " / acceptor was: " + acceptor, wasCompletelyPopped);
		}
		
	}
	
	public static class ForLoopSkipped extends AbstractRichStringPartAcceptor {

		public boolean forLoopHasNext(XExpression before, XExpression separator, CharSequence indentation) {
			return false;
		}
		
		@Override
		public String toString() {
			return "ForLoopSkipped";
		}
		
	}
	
	public static class FixedCountForLoops extends AbstractRichStringPartAcceptor {

		private Stack<Integer> forLoopStack = new Stack<Integer>();
		private final int count;

		public FixedCountForLoops(int count) {
			this.count = count;
			
		}
		
		@Override
		public void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
			forLoopStack.push(count);
		}
		
		public boolean forLoopHasNext(XExpression before, XExpression separator, CharSequence indentation) {
			Integer peek = forLoopStack.peek();
			if (peek > 0) {
				forLoopStack.pop();
				forLoopStack.push(peek - 1);
				return true;
			}
			return false;
		}
		
		@Override
		public void acceptEndFor(XExpression after, CharSequence indentation) {
			forLoopStack.pop();
		}
		
		@Override
		public String toString() {
			return "FixedCountForLoops: " + count; 
		}
	}
	
	protected void doTestStackIsConsistent(String string) throws Exception {
		RichString richString = richString(string);
		doCheckStackIsConsistent(richString);
	}
	
	protected void doTestStackIsConsistentWithErroneousModel(String string) throws Exception {
		RichString richString = richStringWithError(string);
		doCheckStackIsConsistent(richString);
	}
	
	protected RichString richStringWithError(String string) throws Exception {
		XtextResourceSet set = get(XtextResourceSet.class);
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(getPrefix()+string+"}"), null);
		XtendFile file = (XtendFile) resource.getContents().get(0);
		XtendClass clazz = file.getXtendClass();
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		return (RichString) function.getExpression();
	}

	protected void doCheckStackIsConsistent(RichString richString) {
		doTestStackIsConsistent(richString, new ForLoopSkipped());
		doTestStackIsConsistent(richString, new AbstractRichStringPartAcceptor.ForLoopOnce());
		doTestStackIsConsistent(richString, new FixedCountForLoops(2));
		doTestStackIsConsistent(richString, new FixedCountForLoops(3));
	}

	protected void doTestStackIsConsistent(RichString richString, IRichStringPartAcceptor acceptor) {
		StackChecker stackChecker = new StackChecker();
		RichStringProcessor processor = new RichStringProcessor();
		processor.process(richString, acceptor, stackChecker);
		stackChecker.done(acceptor);
	}
	
	public void testStackIsConsistent_01() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «IF 'a'.charAt(0)!='a'»\n" +
			"\t  foobar«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_02() throws Exception {
		doTestStackIsConsistent(
			"'''«var max = 10»«FOR i: 1..max SEPARATOR ', '»«i»«ENDFOR»'''");
	}

	public void testStackIsConsistent_03() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: newArrayList(new testdata.OuterClass$InnerClass())»\n" +
			"   foo\n" +
			"«ENDFOR»'''");
	}

	public void testStackIsConsistent_04() throws Exception {
		doTestStackIsConsistent(
			"'''foobar'''");
	}

	public void testStackIsConsistent_05() throws Exception {
		doTestStackIsConsistent(
			"'''  foobar'''");
	}

	public void testStackIsConsistent_06() throws Exception {
		doTestStackIsConsistent(
			"'''foobar   '''");
	}

	public void testStackIsConsistent_07() throws Exception {
		doTestStackIsConsistent(
			"'''«'foobar'»'''");
	}

	public void testStackIsConsistent_08() throws Exception {
		doTestStackIsConsistent(
			"'''  «'foobar'»'''");
	}

	public void testStackIsConsistent_09() throws Exception {
		doTestStackIsConsistent(
			"'''«'foobar'»   '''");
	}

	public void testStackIsConsistent_10() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"  first line\n" +
			"  second line\n" +
			"\t\t'''");
	}

	public void testStackIsConsistent_11() throws Exception {
		doTestStackIsConsistent(
			"'''«'foo\n" +
			"bar'»'''");
	}

	public void testStackIsConsistent_12() throws Exception {
		doTestStackIsConsistent(
			"'''  «'foo\n" +
			"bar'»'''");
	}

	public void testStackIsConsistent_13() throws Exception {
		doTestStackIsConsistent(
			"'''«'foo\n" +
			"bar'»   '''");
	}

	public void testStackIsConsistent_14() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  foobar\n" +
			"'''");
	}

	public void testStackIsConsistent_15() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  foobar\n" +
			"    foobar\n" +
			" foobar\n" +
			"'''");
	}

	public void testStackIsConsistent_16() throws Exception {
		doTestStackIsConsistent(
			"'''  foobar\n" +
			"    foobar\n" +
			" foobar\n" +
			"'''");
	}

	public void testStackIsConsistent_17() throws Exception {
		doTestStackIsConsistent(
			"'''  foobar\n" +
			"    foobar\n" +
			" foobar  '''");
	}

	public void testStackIsConsistent_18() throws Exception {
		doTestStackIsConsistent(
			"'''«IF true»foobar«ENDIF»'''");
	}

	public void testStackIsConsistent_19() throws Exception {
		doTestStackIsConsistent(
			"'''«IF false»foobar«ENDIF»'''");
	}

	public void testStackIsConsistent_20() throws Exception {
		doTestStackIsConsistent(
			"'''«IF false»foobar«ELSE»zonk«ENDIF»'''");
	}

	public void testStackIsConsistent_21() throws Exception {
		doTestStackIsConsistent(
			"'''«IF false»foobar«ELSEIF true»zonk«ENDIF»'''");
	}

	public void testStackIsConsistent_22() throws Exception {
		doTestStackIsConsistent(
			"'''«IF false»foobar«ELSEIF false»foobar«ELSE»zonk«ENDIF»'''");
	}

	public void testStackIsConsistent_23() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"«IF true»\n" +
			"\tfoobar«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_24() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «IF true»\n" +
			"\t  foobar«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_25() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «IF true»\n" +
			"    foobar\n" +
			"  «ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_26() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF false»\n" +
			"\t\tfoobar\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_27() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"«IF false»\n" +
			"  foobar\n" +
			"«ELSE»\n" +
			"  zonk\n" +
			"«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_28() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"«IF false»\n" +
			"\tfoobar\n" +
			"«ELSEIF true»\n" +
			"\tzonk\n" +
			"«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_29() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\t«IF false»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ELSEIF false»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ELSE»\n" +
			"\t\t\t\tzonk\n" +
			"\t\t«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_30() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF true»\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_31() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF true»\n" +
			"\t\t«IF true»foobar«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_32() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF true»\n" +
			"\t\t«IF false»foobar«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_33() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF true»\n" +
			"\t\t«IF false»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_34() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF false»\n" +
			"\t\t«IF true»foobar«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_35() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF false»\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_36() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «IF true»\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"  «ENDIF»\n" +
			"'''");
	}

	public void testStackIsConsistent_37() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\t«IF false»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\n" +
			"'''");
	}

	public void testStackIsConsistent_38() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\n" +
			"'''");
	}

	public void testStackIsConsistent_39() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t\t\n" +
			"'''");
	}

	public void testStackIsConsistent_40() throws Exception {
		doTestStackIsConsistent(
			"'''    \n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t\t  \n" +
			"'''");
	}

	public void testStackIsConsistent_41() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\tfoobar\n" +
			"\t\t  \n" +
			"'''");
	}

	public void testStackIsConsistent_42() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\t«IF true»foobar«ENDIF»\n" +
			"\t\t  \n" +
			"'''");
	}

	public void testStackIsConsistent_43() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: ''.toCharArray»foobar«ENDFOR»'''");
	}

	public void testStackIsConsistent_44() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:''.toCharArray»\n" +
			"    foobar\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_45() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a:'1'.toCharArray»«FOR a:''.toCharArray»foobar«ENDFOR»«ENDFOR»'''");
	}

	public void testStackIsConsistent_46() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    «FOR a:''.toCharArray»\n" +
			"      foobar\n" +
			"    «ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_47() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a:'1'.toCharArray»foobar«ENDFOR»'''");
	}

	public void testStackIsConsistent_48() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    foobar\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_49() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a:'1'.toCharArray»«FOR a:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''");
	}

	public void testStackIsConsistent_50() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    «FOR a:'1'.toCharArray»\n" +
			"      foobar\n" +
			"    «ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_51() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    «FOR a:'1'.toCharArray»foobar«ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_52() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    «FOR a:'12'.toCharArray»foobar«ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_53() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'12'.toCharArray»\n" +
			"    «FOR a:'1'.toCharArray»foobar«ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_54() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'12'.toCharArray»\n" +
			"    «FOR a:'12'.toCharArray»\n" +
			"      foobar\n" +
			"    «ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_55() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    «FOR a:'12'.toCharArray»\n" +
			"      «'foobar\n" +
			"foobar'»\n" +
			"    «ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_56() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'12'.toCharArray»\n" +
			"    «FOR a:'1'.toCharArray»\n" +
			"      «'  foobar\n" +
			"foobar'»\n" +
			"    «ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_57() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'12'.toCharArray»\n" +
			"    «FOR a:'12'.toCharArray»\n" +
			"      «'foobar\n" +
			"  foobar'»\n" +
			"    «ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_58() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: ''.toCharArray BEFORE '<-' SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}

	public void testStackIsConsistent_59() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '1'.toCharArray BEFORE '<-' SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}

	public void testStackIsConsistent_60() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '12'.toCharArray BEFORE '<-' SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}

	public void testStackIsConsistent_61() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '12'.toCharArray SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}

	public void testStackIsConsistent_62() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '12'.toCharArray BEFORE '<-' SEPARATOR '-' »foobar«ENDFOR»'''");
	}

	public void testStackIsConsistent_63() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '12'.toCharArray BEFORE '<-' AFTER '->' »foobar«ENDFOR»'''");
	}

	public void testStackIsConsistent_64() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a: '123'.toCharArray»\n" +
			"      a,\n" +
			"  «ENDFOR»'''");
	}

	public void testStackIsConsistent_65() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a: '123'.toCharArray SEPARATOR ','»\n" +
			"      a\n" +
			"  «ENDFOR»'''");
	}

	public void testStackIsConsistent_66() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a: '123'.toCharArray BEFORE 'begin [' SEPARATOR ',' AFTER ']' »\n" +
			"      a\n" +
			"  «ENDFOR»'''");
	}

	public void testStackIsConsistent_67() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\tindentedLine\n" +
			"'''");
	}

	public void testStackIsConsistent_68() throws Exception {
		doTestStackIsConsistent(
			"'''  \n" +
			"\t\tindentedLine\n" +
			"\t\tindentedLine\n" +
			"  '''");
	}

	public void testStackIsConsistent_69() throws Exception {
		doTestStackIsConsistent(
			"'''  \n" +
			"  \tindentedLine\n" +
			"  \tindentedLine\n" +
			"  '''");
	}

	public void testStackIsConsistent_70() throws Exception {
		doTestStackIsConsistent(
			"'''  \n" +
			"\t\tindentedLine\n" +
			"  \tindentedLine\n" +
			"  '''");
	}

	public void testStackIsConsistent_71() throws Exception {
		doTestStackIsConsistent(
			"'''    \n" +
			"\t\tindentedLine\n" +
			"\t\tindentedLine\n" +
			"  last line'''");
	}

	public void testStackIsConsistent_72() throws Exception {
		doTestStackIsConsistent(
			"'''        \n" +
			"  \tindentedLine\n" +
			"  \tindentedLine\n" +
			"  last line '''");
	}

	public void testStackIsConsistent_73() throws Exception {
		doTestStackIsConsistent(
			"'''  content  '''");
	}

	public void testStackIsConsistent_74() throws Exception {
		doTestStackIsConsistent(
			"'''  \n" +
			"\t\tindentedLine\n" +
			"\t\tindentedLine\n" +
			"'''");
	}

	public void testStackIsConsistent_75() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"\t\t  first line\n" +
			"'''");
	}

	public void testStackIsConsistent_76() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"\t\t  first line\n" +
			"\n" +
			"'''");
	}

	public void testStackIsConsistent_77() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"\t\t  first line\n" +
			"  \n" +
			"'''");
	}

	public void testStackIsConsistent_78() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"  '''");
	}

	public void testStackIsConsistent_79() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"'''");
	}

	public void testStackIsConsistent_80() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"'''");
	}

	public void testStackIsConsistent_81() throws Exception {
		doTestStackIsConsistent(
			"''''''");
	}

	public void testStackIsConsistent_82() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"\t\t  first line\n" +
			"«'end'»'''");
	}

	public void testStackIsConsistent_83() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»'''");
	}

	public void testStackIsConsistent_84() throws Exception {
		doTestStackIsConsistent(
			"'''  «'test'»'''");
	}

	public void testStackIsConsistent_85() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR c : 'test'.bytes»«'test123'»\n" +
			"  «ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»«'test123'»\n" +
			"  «ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»«'test123'»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_86() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_87() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR c : 'test'.bytes»\n" +
			"    «'test123'»«ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»\n" +
			"    «'test123'»«ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»\n" +
			"    «'test123'»«ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_88() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR c : 'test'.bytes»«FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»«FOR c : 'test'.bytes»«'test123'»\n" +
			"  «ENDFOR»«ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»«FOR c : 'test'.bytes»«FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" +
			"  «ENDFOR»«ENDFOR»\n" +
			"'''");
	}

	public void testStackIsConsistent_89() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: 'test'.bytes»\n" +
			"   foo\n" +
			"«ENDFOR»'''");
	}

	public void testStackIsConsistent_90() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: ''.bytes»foobar«ENDFOR»'''");
	}

	public void testStackIsConsistent_91() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a:'1'.bytes»«FOR a:''.bytes»foobar«ENDFOR»«ENDFOR»'''");
	}

	public void testStackIsConsistent_92() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a:'1'.bytes»«FOR a:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''");
	}
	
	public void testStackIsConsistent_93() throws Exception {
		doTestStackIsConsistent(
			"'''«»'''");
	}
	
	public void testStackIsConsistent_94() throws Exception {
		doTestStackIsConsistent(
			"'''  «\n  »'''");
	}
	
	public void testStackIsConsistent_95() throws Exception {
		doTestStackIsConsistent(
			"'''  «\n  »  '''");
	}
	
	public void testStackIsConsistent_96() throws Exception {
		doTestStackIsConsistent(
			"''' «null» «/* zonk */» «null»'''");
	}
	
	public void testStackIsConsistent_97() throws Exception {
		doTestStackIsConsistent(
				"''' «null» «/* zonk \n */» «null»'''");
	}
	
	public void testStackIsConsistent_98() throws Exception {
		doTestStackIsConsistent(
				"''' «null» «  \n/* zonk \n */\n   » «null»'''");
	}
	
	public void testStackIsConsistent_99() throws Exception {
		doTestStackIsConsistent(
			"'''" +
			"    «\n  »" +
			"'''");
	}

	public void testBug342556_01() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
			"'''«DEFINE genCode(LangDef language) FOR Code-»\n" + 
			"«formatCode(unescapeXdocChars(contents), language)-»\n" + 
			"«ENDDEFINE»'''");
	}
	
	public void testBug342556_02() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
			"'''\n" + 
			"«formatCode(unescapeXdocChars(contents), language)-»\n" + 
			"«ENDDEFINE»'''");
	}
	
	public void testBug342556_03() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
			"'''«formatCode(unescapeXdocChars(contents), language)-»\n" + 
			"«ENDDEFINE»'''");
	}
	
	public void testBug342724() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
				"'''\n" + 
				"	«IF true»\n" + 
				"		test\n" + 
				"	«ENDIF»\n" + 
				"	test\n" + 
				"'''");
	}
	
	public void testBug343269() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
				"'''\n" + 
				"«FOR\n" + 
				"\n" + 
				"'''");
	}
	
	public void testBug361702() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
				"''' «\"» \n" + 
				"    }\n" + 
				"}");
	}
}
