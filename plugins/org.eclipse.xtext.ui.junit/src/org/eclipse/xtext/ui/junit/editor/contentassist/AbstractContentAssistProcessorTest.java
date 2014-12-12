/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.junit.editor.contentassist;

import java.lang.reflect.Method;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit.AbstractXtextTests;

import com.google.inject.Injector;

/**
 * Unit test for class <code>DefaultContentAssistProcessor</code>. Reused by Xtend implementation.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Jan Koehnlein
 * @author Sebastian Zarnekow
 * @see org.eclipse.xtext.ui.editor.contentassist.impl.DefaultContentAssistProcessor
 */
public abstract class AbstractContentAssistProcessorTest extends AbstractXtextTests {

	public static class SetupExtension implements ISetup {

		private final ISetup plainSetup;

		public SetupExtension(ISetup plainSetup) {
			this.plainSetup = plainSetup;
		}
		
		@Override
		public Injector createInjectorAndDoEMFRegistration() {
			return plainSetup.createInjectorAndDoEMFRegistration();
		}

		public void register(Injector injector) {
			try {
				Method method = plainSetup.getClass().getMethod("register", Injector.class);
				method.setAccessible(true);
				method.invoke(plainSetup, injector);
			} catch (Exception e) {
				throw new UnsupportedOperationException("register(Injector)", e);
			}
			
		}
		
	}
	
	private static boolean useStaticInjector = false;
	
	private static SetupExtension staticSetup = null;
	private static Injector staticInjector = null;
	
	protected static Test suite(Class<? extends AbstractContentAssistProcessorTest> clazz) {
		return new TestSetup(new TestSuite(clazz)) {
			@Override
			protected void setUp() throws Exception {
				super.setUp();
				useStaticInjector = true;
			}
			@Override
			protected void tearDown() throws Exception {
				useStaticInjector = false;
				staticSetup = null;
				staticInjector = null;
				super.tearDown();
			}
			
		};
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return newBuilder(getSetup());
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder(ISetup setup) throws Exception {
		return new ContentAssistProcessorTestBuilder(setup, this);
	}
	
	protected final ISetup getSetup() {
		if (!useStaticInjector) {
			return doGetSetup();
		}
		return new ISetup() {
			
			@Override
			public Injector createInjectorAndDoEMFRegistration() {
				if (staticSetup == null) {
					staticSetup = new SetupExtension(doGetSetup());
					staticInjector = staticSetup.createInjectorAndDoEMFRegistration();
					return staticInjector;
				}
				staticSetup.register(staticInjector);
				return staticInjector;
			}
		};
	}
	
	protected abstract ISetup doGetSetup() ;

}