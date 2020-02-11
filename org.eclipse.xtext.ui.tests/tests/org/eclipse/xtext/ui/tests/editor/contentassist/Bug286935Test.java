/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.Bug286935TestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Bug286935TestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug286935Test extends AbstractContentAssistTest {
	
	@Test public void testBug286935_01() throws Exception {
    	newBuilder()
    		.append("init cond")
    		.assertText("cond", "\"Label\"");
    }
    
    @Test public void testBug286935_02() throws Exception {
    	newBuilder()
    		.append("init cond ")
    		.assertText("state", 
    				"stateName", 
    				"\"Label\"", 
    				"final");
    }

}
