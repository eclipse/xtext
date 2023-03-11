/**
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.jdt.ui.PreferenceConstants;
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
    final String typeFilter = PreferenceConstants.getPreferenceStore().getDefaultString(
      "org.eclipse.jdt.ui.typefilter.enabled");
    if (((typeFilter != null) && typeFilter.contains("jdk.*"))) {
      this.newBuilder().append("@Data").assertText(
        "org.eclipse.xtend.lib.annotations.Data", 
        "org.junit.experimental.theories.DataPoint", 
        "org.junit.experimental.theories.DataPoints");
    } else {
      this.newBuilder().append("@Data").assertText(
        "jdk.jfr.DataAmount", 
        "org.eclipse.xtend.lib.annotations.Data", 
        "org.junit.experimental.theories.DataPoint", 
        "org.junit.experimental.theories.DataPoints");
    }
  }
}
