/*******************************************************************************
 * Copyright (c) 2008, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.ui;

import java.lang.reflect.Method;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.google.inject.Injector;

/**
 * Unit test for class <code>DefaultContentAssistProcessor</code>. Reused by Xtend implementation.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Jan Koehnlein
 * @author Sebastian Zarnekow
 * @see org.eclipse.xtext.ui.editor.contentassist.impl.DefaultContentAssistProcessor
 * @deprecated Use org.eclipse.xtext.ui.testing.AbstractContentAssistTest instead
 */
@Deprecated(forRemoval = true)
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
	
	protected static boolean useStaticInjector = false;
	
	private static SetupExtension staticSetup = null;
	private static Injector staticInjector = null;
	
	@BeforeClass
	public static void useStaticInjector() {
		useStaticInjector = true;
	}
	
	@AfterClass
	public static void discardStaticInjector() {
		useStaticInjector = false;
		staticSetup = null;
		staticInjector = null;
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return newBuilder(getSetup());
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder(ISetup setup) throws Exception {
		return new ContentAssistProcessorTestBuilder(setup, this);
	}
	
	protected ISetup getSetup() {
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