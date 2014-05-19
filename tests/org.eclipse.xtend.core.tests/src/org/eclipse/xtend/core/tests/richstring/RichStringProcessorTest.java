/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.IRichStringIndentationHandler;
import org.eclipse.xtend.core.richstring.IRichStringPartAcceptor;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringProcessorTest extends AbstractRichStringTest {
	
	protected static class StackChecker implements IRichStringIndentationHandler {

		private int i = 0;
		boolean wasCompletelyPopped = false;
		
		public void pushTemplateIndentation(/* @NonNull */ CharSequence completeIndentation) {
			i++;
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
		}

		public void pushSemanticIndentation(/* @NonNull */ CharSequence completeIndentation) {
			i++;
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
		}

		public void popIndentation() {
			i--;
			wasCompletelyPopped = i == 0;
			assertTrue("i>=0", i>=0);
		}

		public void accept(/* @NonNull */ IRichStringPartAcceptor acceptor) {
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
		}

		/* @NonNull */ 
		public CharSequence getTotalSemanticIndentation() {
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
			return "";
		}

		/* @NonNull */ 
		public CharSequence getTotalIndentation() {
			assertFalse("wasCompletelyPopped", wasCompletelyPopped);
			return "";
		}
		
		protected void done(IRichStringPartAcceptor acceptor) {
			assertTrue("size is: " + i + " / acceptor was: " + acceptor, wasCompletelyPopped);
		}
		
	}
	
	public static class RecordingRichStringPartAcceptor extends AbstractRichStringPartAcceptor.ForLoopOnce {

		private List<String> record = Lists.newArrayList();

		@Override
		public void acceptForLoop(JvmFormalParameter parameter, /* @Nullable */ XExpression expression) {
			record.add("acceptForLoop()");
			super.acceptForLoop(parameter, expression);
		}

		@Override
		public void acceptEndFor(/* @Nullable */ XExpression after, CharSequence indentation) {
			record.add("acceptEndFor()");
			super.acceptEndFor(after, indentation);
		}

		@Override
		public void acceptSemanticText(CharSequence text, /* @Nullable */ RichStringLiteral origin) {
			record.add("acceptSemanticText(" + text + ")");
			super.acceptSemanticText(text, origin);
		}

		@Override
		public void acceptTemplateText(CharSequence text, /* @Nullable */ RichStringLiteral origin) {
			record.add("acceptTemplateText(" + text + ")");
			super.acceptTemplateText(text, origin);
		}

		@Override
		public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
			record.add("acceptSemanticLineBreak()");
			super.acceptSemanticLineBreak(charCount, origin, controlStructureSeen);
		}

		@Override
		public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
			record.add("acceptTemplateLineBreak()");
			super.acceptTemplateLineBreak(charCount, origin);
		}

		@Override
		public void acceptIfCondition(XExpression condition) {
			record.add("acceptIfCondition()");
			super.acceptIfCondition(condition);
		}

		@Override
		public void acceptElseIfCondition(XExpression condition) {
			record.add("acceptElseIfCondition()");
			super.acceptElseIfCondition(condition);
		}

		@Override
		public void acceptElse() {
			record.add("acceptElse()");
			super.acceptElse();
		}

		@Override
		public void acceptEndIf() {
			record.add("acceptEndIf()");
			super.acceptEndIf();
		}

		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			record.add("acceptExpression(«" + NodeModelUtils.getNode(expression).getText() + "»)");
			super.acceptExpression(expression, indentation);
		}

		@Override
		public void announceNextLiteral(RichStringLiteral object) {
			record.add("announceNextLiteral()");
			super.announceNextLiteral(object);
		}
		
		@Override
		public String toString() {
			return Joiner.on("\n").join(record);
		}

	}
	
	public static class ForLoopSkipped extends AbstractRichStringPartAcceptor {

		public boolean forLoopHasNext(/* @Nullable */ XExpression before, /* @Nullable */ XExpression separator, /* @NonNull */ CharSequence indentation) {
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
		public void acceptForLoop(/* @NonNull */ JvmFormalParameter parameter, /* @NonNull */ XExpression expression) {
			forLoopStack.push(count);
		}
		
		public boolean forLoopHasNext(/* @Nullable */ XExpression before, /* @Nullable */ XExpression separator, /* @NonNull */ CharSequence indentation) {
			Integer peek = forLoopStack.peek();
			if (peek > 0) {
				forLoopStack.pop();
				forLoopStack.push(peek - 1);
				return true;
			}
			return false;
		}
		
		@Override
		public void acceptEndFor(/* @Nullable */ XExpression after, /* @NonNull */ CharSequence indentation) {
			forLoopStack.pop();
		}
		
		@Override
		public String toString() {
			return "FixedCountForLoops: " + count; 
		}
	}
	
	protected String recordRichStringProcessorEvents(String string) throws Exception {
		RichString richString = richString(string);
		RichStringProcessor processor = new RichStringProcessor();
		RecordingRichStringPartAcceptor acceptor = new RecordingRichStringPartAcceptor();
		processor.process(richString, acceptor, new DefaultIndentationHandler());
		return acceptor.toString();
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
		XtextResourceSet set = getResourceSet();
		String fileName = getFileName(string);
		Resource resource = set.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(getPrefix()+string+"}"), null);
		XtendFile file = (XtendFile) resource.getContents().get(0);
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
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
	
	@Test public void testStackIsConsistent_01() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «IF 'a'.charAt(0)!='a'»\n" +
			"\t  foobar«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_02() throws Exception {
		doTestStackIsConsistent(
			"'''«var max = 10»«FOR i: 1..max SEPARATOR ', '»«i»«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_03() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: newArrayList(new testdata.OuterClass$InnerClass())»\n" +
			"   foo\n" +
			"«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_04() throws Exception {
		doTestStackIsConsistent(
			"'''foobar'''");
	}

	@Test public void testStackIsConsistent_05() throws Exception {
		doTestStackIsConsistent(
			"'''  foobar'''");
	}

	@Test public void testStackIsConsistent_06() throws Exception {
		doTestStackIsConsistent(
			"'''foobar   '''");
	}

	@Test public void testStackIsConsistent_07() throws Exception {
		doTestStackIsConsistent(
			"'''«'foobar'»'''");
	}

	@Test public void testStackIsConsistent_08() throws Exception {
		doTestStackIsConsistent(
			"'''  «'foobar'»'''");
	}

	@Test public void testStackIsConsistent_09() throws Exception {
		doTestStackIsConsistent(
			"'''«'foobar'»   '''");
	}

	@Test public void testStackIsConsistent_10() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"  first line\n" +
			"  second line\n" +
			"\t\t'''");
	}

	@Test public void testStackIsConsistent_11() throws Exception {
		doTestStackIsConsistent(
			"'''«'foo\n" +
			"bar'»'''");
	}

	@Test public void testStackIsConsistent_12() throws Exception {
		doTestStackIsConsistent(
			"'''  «'foo\n" +
			"bar'»'''");
	}

	@Test public void testStackIsConsistent_13() throws Exception {
		doTestStackIsConsistent(
			"'''«'foo\n" +
			"bar'»   '''");
	}

	@Test public void testStackIsConsistent_14() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  foobar\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_15() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  foobar\n" +
			"    foobar\n" +
			" foobar\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_16() throws Exception {
		doTestStackIsConsistent(
			"'''  foobar\n" +
			"    foobar\n" +
			" foobar\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_17() throws Exception {
		doTestStackIsConsistent(
			"'''  foobar\n" +
			"    foobar\n" +
			" foobar  '''");
	}

	@Test public void testStackIsConsistent_18() throws Exception {
		doTestStackIsConsistent(
			"'''«IF true»foobar«ENDIF»'''");
	}

	@Test public void testStackIsConsistent_19() throws Exception {
		doTestStackIsConsistent(
			"'''«IF false»foobar«ENDIF»'''");
	}

	@Test public void testStackIsConsistent_20() throws Exception {
		doTestStackIsConsistent(
			"'''«IF false»foobar«ELSE»zonk«ENDIF»'''");
	}

	@Test public void testStackIsConsistent_21() throws Exception {
		doTestStackIsConsistent(
			"'''«IF false»foobar«ELSEIF true»zonk«ENDIF»'''");
	}

	@Test public void testStackIsConsistent_22() throws Exception {
		doTestStackIsConsistent(
			"'''«IF false»foobar«ELSEIF false»foobar«ELSE»zonk«ENDIF»'''");
	}

	@Test public void testStackIsConsistent_23() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"«IF true»\n" +
			"\tfoobar«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_24() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «IF true»\n" +
			"\t  foobar«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_25() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «IF true»\n" +
			"    foobar\n" +
			"  «ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_26() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF false»\n" +
			"\t\tfoobar\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_27() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"«IF false»\n" +
			"  foobar\n" +
			"«ELSE»\n" +
			"  zonk\n" +
			"«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_28() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"«IF false»\n" +
			"\tfoobar\n" +
			"«ELSEIF true»\n" +
			"\tzonk\n" +
			"«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_29() throws Exception {
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

	@Test public void testStackIsConsistent_30() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF true»\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_31() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF true»\n" +
			"\t\t«IF true»foobar«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_32() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF true»\n" +
			"\t\t«IF false»foobar«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_33() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF true»\n" +
			"\t\t«IF false»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_34() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF false»\n" +
			"\t\t«IF true»foobar«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_35() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t«IF false»\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t«ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_36() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «IF true»\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"  «ENDIF»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_37() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\t«IF false»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_38() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_39() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t\t\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_40() throws Exception {
		doTestStackIsConsistent(
			"'''    \n" +
			"\t\t«IF true»\n" +
			"\t\t\t\tfoobar\n" +
			"\t\t«ENDIF»\n" +
			"\t\t  \n" +
			"'''");
	}

	@Test public void testStackIsConsistent_41() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\tfoobar\n" +
			"\t\t  \n" +
			"'''");
	}

	@Test public void testStackIsConsistent_42() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\t\t«IF true»foobar«ENDIF»\n" +
			"\t\t  \n" +
			"'''");
	}

	@Test public void testStackIsConsistent_43() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: ''.toCharArray»foobar«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_44() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:''.toCharArray»\n" +
			"    foobar\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_45() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a:'1'.toCharArray»«FOR a:''.toCharArray»foobar«ENDFOR»«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_46() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    «FOR a:''.toCharArray»\n" +
			"      foobar\n" +
			"    «ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_47() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a:'1'.toCharArray»foobar«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_48() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    foobar\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_49() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a:'1'.toCharArray»«FOR a:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_50() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    «FOR a:'1'.toCharArray»\n" +
			"      foobar\n" +
			"    «ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_51() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    «FOR a:'1'.toCharArray»foobar«ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_52() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'1'.toCharArray»\n" +
			"    «FOR a:'12'.toCharArray»foobar«ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_53() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'12'.toCharArray»\n" +
			"    «FOR a:'1'.toCharArray»foobar«ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_54() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR a:'12'.toCharArray»\n" +
			"    «FOR a:'12'.toCharArray»\n" +
			"      foobar\n" +
			"    «ENDFOR»\n" +
			"  «ENDFOR»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_55() throws Exception {
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

	@Test public void testStackIsConsistent_56() throws Exception {
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

	@Test public void testStackIsConsistent_57() throws Exception {
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

	@Test public void testStackIsConsistent_58() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: ''.toCharArray BEFORE '<-' SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_59() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '1'.toCharArray BEFORE '<-' SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_60() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '12'.toCharArray BEFORE '<-' SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_61() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '12'.toCharArray SEPARATOR '-' AFTER '->'»foobar«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_62() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '12'.toCharArray BEFORE '<-' SEPARATOR '-' »foobar«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_63() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: '12'.toCharArray BEFORE '<-' AFTER '->' »foobar«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_64() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a: '123'.toCharArray»\n" +
			"      a,\n" +
			"  «ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_65() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a: '123'.toCharArray SEPARATOR ','»\n" +
			"      a\n" +
			"  «ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_66() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a: '123'.toCharArray BEFORE 'begin [' SEPARATOR ',' AFTER ']' »\n" +
			"      a\n" +
			"  «ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_67() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"\tindentedLine\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_68() throws Exception {
		doTestStackIsConsistent(
			"'''  \n" +
			"\t\tindentedLine\n" +
			"\t\tindentedLine\n" +
			"  '''");
	}

	@Test public void testStackIsConsistent_69() throws Exception {
		doTestStackIsConsistent(
			"'''  \n" +
			"  \tindentedLine\n" +
			"  \tindentedLine\n" +
			"  '''");
	}

	@Test public void testStackIsConsistent_70() throws Exception {
		doTestStackIsConsistent(
			"'''  \n" +
			"\t\tindentedLine\n" +
			"  \tindentedLine\n" +
			"  '''");
	}

	@Test public void testStackIsConsistent_71() throws Exception {
		doTestStackIsConsistent(
			"'''    \n" +
			"\t\tindentedLine\n" +
			"\t\tindentedLine\n" +
			"  last line'''");
	}

	@Test public void testStackIsConsistent_72() throws Exception {
		doTestStackIsConsistent(
			"'''        \n" +
			"  \tindentedLine\n" +
			"  \tindentedLine\n" +
			"  last line '''");
	}

	@Test public void testStackIsConsistent_73() throws Exception {
		doTestStackIsConsistent(
			"'''  content  '''");
	}

	@Test public void testStackIsConsistent_74() throws Exception {
		doTestStackIsConsistent(
			"'''  \n" +
			"\t\tindentedLine\n" +
			"\t\tindentedLine\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_75() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"\t\t  first line\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_76() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"\t\t  first line\n" +
			"\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_77() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"\t\t  first line\n" +
			"  \n" +
			"'''");
	}

	@Test public void testStackIsConsistent_78() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"  '''");
	}

	@Test public void testStackIsConsistent_79() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_80() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_81() throws Exception {
		doTestStackIsConsistent(
			"''''''");
	}

	@Test public void testStackIsConsistent_82() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»\n" +
			"\t\t  first line\n" +
			"«'end'»'''");
	}

	@Test public void testStackIsConsistent_83() throws Exception {
		doTestStackIsConsistent(
			"'''«'start'»'''");
	}

	@Test public void testStackIsConsistent_84() throws Exception {
		doTestStackIsConsistent(
			"'''  «'test'»'''");
	}

	@Test public void testStackIsConsistent_85() throws Exception {
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

	@Test public void testStackIsConsistent_86() throws Exception {
		doTestStackIsConsistent(
			"'''\n" +
			"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" +
			"  «FOR c : 'test'.bytes»«'test123'»«ENDFOR»\n" +
			"'''");
	}

	@Test public void testStackIsConsistent_87() throws Exception {
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

	@Test public void testStackIsConsistent_88() throws Exception {
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

	@Test public void testStackIsConsistent_89() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: 'test'.bytes»\n" +
			"   foo\n" +
			"«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_90() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a: ''.bytes»foobar«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_91() throws Exception {
		doTestStackIsConsistent(
			"'''«FOR a:'1'.bytes»«FOR a:''.bytes»foobar«ENDFOR»«ENDFOR»'''");
	}

	@Test public void testStackIsConsistent_92() throws Exception {
		doTestStackIsConsistent(
			"'''  «FOR a:'1'.bytes»«FOR a:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''");
	}
	
	@Test public void testStackIsConsistent_93() throws Exception {
		doTestStackIsConsistent(
			"'''«»'''");
	}
	
	@Test public void testStackIsConsistent_94() throws Exception {
		doTestStackIsConsistent(
			"'''  «\n  »'''");
	}
	
	@Test public void testStackIsConsistent_95() throws Exception {
		doTestStackIsConsistent(
			"'''  «\n  »  '''");
	}
	
	@Test public void testStackIsConsistent_96() throws Exception {
		doTestStackIsConsistent(
			"''' «null» «/* zonk */» «null»'''");
	}
	
	@Test public void testStackIsConsistent_97() throws Exception {
		doTestStackIsConsistent(
				"''' «null» «/* zonk \n */» «null»'''");
	}
	
	@Test public void testStackIsConsistent_98() throws Exception {
		doTestStackIsConsistent(
				"''' «null» «  \n/* zonk \n */\n   » «null»'''");
	}
	
	@Test public void testStackIsConsistent_99() throws Exception {
		doTestStackIsConsistent(
			"'''" +
			"    «\n  »" +
			"'''");
	}
	
	@Test public void testProcessorEvents1() throws Exception {
		String events = recordRichStringProcessorEvents(
				"'''\n" +
				"    «true»\n" +
				"'''");
		String expected = 
				"announceNextLiteral()\n"+
				"acceptTemplateText()\n"+
				"acceptTemplateLineBreak()\n"+
				"acceptTemplateText(    )\n"+
				"acceptSemanticText()\n"+
				"acceptSemanticText()\n"+
				"acceptExpression(«true»)\n"+
				"announceNextLiteral()\n"+
				"acceptSemanticText()\n"+
				"acceptSemanticLineBreak()\n"+
				"acceptTemplateText()";
		Assert.assertEquals(expected, events);
	}
	
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=394277")
	@Test public void testProcessorEventsBug394277_01() throws Exception {
		String events = recordRichStringProcessorEvents(
				"'''\n" +
				"    «»\n" +
				"'''");
		String expected = 
				"announceNextLiteral()\n"+
				"acceptTemplateText()\n"+
				"acceptTemplateLineBreak()\n"+
				"acceptTemplateText()\n"+
				"acceptSemanticText(    )\n"+
				"acceptSemanticText()\n"+
				"announceNextLiteral()\n"+
				"acceptSemanticText()\n"+
				"acceptSemanticLineBreak()\n"+
				"acceptTemplateText()";
		Assert.assertEquals(expected, events);
	}
	
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=394277")
	@Test public void testProcessorEventsBug394277_02() throws Exception {
		String events = recordRichStringProcessorEvents("'''  «\n  »  '''");
		String expected = 
				"announceNextLiteral()\n"+
				"acceptTemplateText()\n"+
				"acceptTemplateLineBreak()\n"+
				"acceptTemplateText()\n"+
				"acceptSemanticText(    )\n"+
				"acceptSemanticText()\n"+
				"announceNextLiteral()\n"+
				"acceptSemanticText()\n"+
				"acceptSemanticLineBreak()\n"+
				"acceptTemplateText()";
		Assert.assertEquals(expected, events);
	}

	@Test public void testBug342556_01() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
			"'''«DEFINE genCode(LangDef language) FOR Code-»\n" + 
			"«formatCode(unescapeXdocChars(contents), language)-»\n" + 
			"«ENDDEFINE»'''");
	}
	
	@Test public void testBug342556_02() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
			"'''\n" + 
			"«formatCode(unescapeXdocChars(contents), language)-»\n" + 
			"«ENDDEFINE»'''");
	}
	
	@Test public void testBug342556_03() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
			"'''«formatCode(unescapeXdocChars(contents), language)-»\n" + 
			"«ENDDEFINE»'''");
	}
	
	@Test public void testBug342724() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
				"'''\n" + 
				"	«IF true»\n" + 
				"		test\n" + 
				"	«ENDIF»\n" + 
				"	test\n" + 
				"'''");
	}
	
	@Test public void testBug343269() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
				"'''\n" + 
				"«FOR\n" + 
				"\n" + 
				"'''");
	}
	
	@Test public void testBug361702() throws Exception {
		doTestStackIsConsistentWithErroneousModel(
				"''' «\"» \n" + 
				"    }\n" + 
				"}");
	}
}
