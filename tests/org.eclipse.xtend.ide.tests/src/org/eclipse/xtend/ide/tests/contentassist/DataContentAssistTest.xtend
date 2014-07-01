/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest
import org.junit.Test

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class DataContentAssistTest extends AbstractXtendContentAssistBugTest {
	@Test def void testPropertyAnnotation() throws Exception {
		newBuilder().append("@Data").assertText("org.eclipse.xtend.lib.annotations.Data");
	}
}