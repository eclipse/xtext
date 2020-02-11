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
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.LookAheadContentAssistTestLanguageUiInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(LookAheadContentAssistTestLanguageUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class Bug282031Test extends AbstractContentAssistTest {
	
	@Test public void testBug282031_01() throws Exception {
    	newBuilder()
    		.append("( values1 ")
    		.assertText("=", ")", "Value", "Name");
    }
    
    @Test public void testBug282031_02() throws Exception {
    	newBuilder()
    		.append("(")
    		.assertText("(", ")", "Value", "Name");
    }
    
    @Test public void testBug282031_03() throws Exception {
    	newBuilder()
    		.append("( ")
    		.assertText(")", "Value", "Name");
    }
    
    @Test public void testBug282031_04() throws Exception {
    	newBuilder()
    		.append("( values1")
    		.assertText("=", ")");
    }
    
    @Test public void testBug282031_05() throws Exception {
    	newBuilder()
    		.append("[ values1 ")
    		.assertText("]", "Value", "Name");
    }
    
    @Test public void testBug282031_06() throws Exception {
    	newBuilder()
    		.append("[")
    		.assertText("[", "Value");
    }
    
    @Test public void testBug282031_07() throws Exception {
    	newBuilder()
    		.append("[ ")
    		.assertText("Value");
    }
    
    @Test public void testBug282031_08() throws Exception {
    	newBuilder()
    		.append("[ values1")
    		.assertText("]");
    }
    
    @Test public void testBug282031_09() throws Exception {
    	newBuilder()
    		.append("< values1 ")
    		.assertText("=", "Value", "Name");
    }
    
    @Test public void testBug282031_10() throws Exception {
    	newBuilder()
    		.append("<")
    		.assertText("<", "Value", "Name");
    }
    
    @Test public void testBug282031_11() throws Exception {
    	newBuilder()
    		.append("< ")
    		.assertText("Value", "Name");
    }
    
    @Test public void testBug282031_12() throws Exception {
    	newBuilder()
    		.append("< values1")
    		.assertText("=");
    }
    
    @Test public void testBug282031_13() throws Exception {
    	newBuilder()
    		.append("{ values1 ")
    		.assertText("Value", "Name");
    }
    
    @Test public void testBug282031_14() throws Exception {
    	newBuilder()
    		.append("{")
    		.assertText("{", "Value");
    }
    
    @Test public void testBug282031_15() throws Exception {
    	newBuilder()
    		.append("{ ")
    		.assertText("Value");
    }
    
    @Test public void testBug282031_16() throws Exception {
    	newBuilder()
    		.append("{ values1")
    		.assertText();
    }

}
