package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class DynamicDispatchTest extends TestCase{

	private static final String FOO = "foo";
	private static final List<ICompletionProposal> STRING = Arrays.asList(new ICompletionProposal[] {new CompletionProposal()});
	private static final List<ICompletionProposal> OBJECT = Arrays.asList(new ICompletionProposal[] {new CompletionProposal()});

	private static final List<Class<?>> objectType = Arrays.asList(new Class<?>[] { Object.class });
	private static final List<Class<?>> stringType = Arrays.asList(new Class<?>[] { String.class });

	private static final List<Object> object = Arrays.asList(new Object[] { new Object() });
	private static final List<String> string = Arrays.asList(new String[] { "dummdidumm" });
	
	public void testDynamicDispatch() throws Exception {
		JavaReflectiveMethodInvoker invoker = new JavaReflectiveMethodInvoker(new Example1());
		assertEquals(OBJECT, invoker.invoke(FOO, objectType, object));
		assertEquals(STRING, invoker.invoke(FOO, stringType, string));
		JavaReflectiveMethodInvoker invoker1 = new JavaReflectiveMethodInvoker(new Example2());
		assertEquals(OBJECT, invoker1.invoke(FOO, objectType, object));
		assertEquals(STRING, invoker1.invoke(FOO, stringType, string));
	}
	
	class Example1 {
		List<ICompletionProposal> foo(Object o) {
			return OBJECT;
		}
		
		List<ICompletionProposal> foo(String s) {
			return STRING;
		}
	}
	
	class Example2 {
		List<ICompletionProposal> foo(String s) {
			return STRING;
		}

		List<ICompletionProposal> foo(Object o) {
			return OBJECT;
		}
	}
	
	static class CompletionProposal implements ICompletionProposal {

		public void apply(IDocument document) {
		}

		public String getAdditionalProposalInfo() {
			return null;
		}

		public IContextInformation getContextInformation() {
			return null;
		}

		public String getDisplayString() {
			return null;
		}

		public Image getImage() {
			return null;
		}

		public Point getSelection(IDocument document) {
			return null;
		}
		
	}
}
