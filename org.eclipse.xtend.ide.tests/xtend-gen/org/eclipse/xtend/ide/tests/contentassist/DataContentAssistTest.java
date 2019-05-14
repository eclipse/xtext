/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest;
import org.eclipse.xtext.testing.Flaky;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class DataContentAssistTest extends AbstractXtendContentAssistBugTest {
  @Flaky
  @Test
  public void testDataAnnotation() throws Exception {
    boolean _isJava11OrLater = AbstractXtendUITestCase.isJava11OrLater();
    if (_isJava11OrLater) {
      this.newBuilder().append("@Data").assertText(
        "jdk.jfr.DataAmount", 
        "org.eclipse.xtend.lib.annotations.Data", 
        "org.junit.experimental.theories.DataPoint", 
        "org.junit.experimental.theories.DataPoints");
    } else {
      this.newBuilder().append("@Data").assertText(
        "org.eclipse.xtend.lib.annotations.Data", 
        "org.junit.experimental.theories.DataPoint", 
        "org.junit.experimental.theories.DataPoints");
    }
  }
}
