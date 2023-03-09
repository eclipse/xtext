/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.nio.charset.Charset;

import org.eclipse.xtext.generator.parser.antlr.AntlrToolFacade;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class AntlrToolFacadeTest extends Assert {
	
	public static class TestableToolFacade extends AntlrToolFacade {
		
		TestableToolFacade() {
			setLoader(AntlrToolFacadeTest.class.getClassLoader());
		}
		
		@Override
		protected String getToolRunnerClassName() {
			return AntlrToolFacadeTest.MODE.getToolRunnerClassName();
		}
	}
	
	public enum Mode {
		OLD {

			@Override
			String getToolRunnerClassName() {
				return OldToolRunner.class.getName();
			}
			
		}, NEW {

			@Override
			String getToolRunnerClassName() {
				return NewToolRunner.class.getName();
			}
			
		};
		abstract String getToolRunnerClassName();
	}
	
	private static Mode MODE;
	private static String calledMethod;

	public static class NewToolRunner {
		public static void runWithEncodingAndParams(String grammarFullPath, String explicitEncoding, String... furtherArgs) {
			assertNull(calledMethod);
			calledMethod = "runWithEncodingAndParams";
		}
		public static void runWithParams(String grammarFullPath, String... furtherArgs) {
			assertNull(calledMethod);
			calledMethod = "runWithParams";
		}
	}
	public static class OldToolRunner {
		public static void runWithParams(String grammarFullPath, String... furtherArgs) {
			assertNull(calledMethod);
			calledMethod = "runWithParams";
		}
	}
	
	@Before
	@After
	public void clearState() {
		AntlrToolFacadeTest.MODE = Mode.NEW;
		calledMethod = null;
	}
	
	private static void setMode(Mode mode) {
		AntlrToolFacadeTest.MODE = mode;
	}
	
	@Test
	public void testNewXtextOldAntlrSameEncoding() {
		setMode(Mode.OLD);
		TestableToolFacade facade = new TestableToolFacade();
		facade.runWithEncodingAndParams("", Charset.defaultCharset().name());
		assertEquals("runWithParams", calledMethod);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testNewXtextOldAntlrDifferentEncoding() {
		setMode(Mode.OLD);
		Charset encoding = Charset.defaultCharset().equals(Charsets.ISO_8859_1) ? Charsets.UTF_8 : Charsets.ISO_8859_1; 
		TestableToolFacade facade = new TestableToolFacade();
		facade.runWithEncodingAndParams("", encoding.name());
	}
	
	@Test
	public void testOldXtextOldAntlr() {
		setMode(Mode.OLD);
		TestableToolFacade facade = new TestableToolFacade();
		facade.runWithParams("");
	}
	
	@Test
	public void testOldXtextNewAntlr() {
		setMode(Mode.NEW);
		TestableToolFacade facade = new TestableToolFacade();
		facade.runWithParams("");
	}
	
	@Test
	public void testNewXtextNewAntlr() {
		setMode(Mode.NEW);
		TestableToolFacade facade = new TestableToolFacade();
		facade.runWithEncodingAndParams("", Charset.defaultCharset().name());
		assertEquals("runWithEncodingAndParams", calledMethod);
	}
	
}
