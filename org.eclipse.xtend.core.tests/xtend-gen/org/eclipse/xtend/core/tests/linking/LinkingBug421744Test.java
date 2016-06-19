/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.linking;

import javax.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class LinkingBug421744Test extends AbstractXtendTestCase {
  @Inject
  private ValidationTestHelper testHelper;
  
  @Test
  public void testTheBug() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package notification");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("import static notification.NotificationType.*");
      _builder.newLine();
      _builder.append("import notification.NotificationTester");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Tester {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void volume() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("NotificationTester.observeUnexpected([|getVolume_Key()], CHANGED)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class NotificationTester {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def static void observeUnexpected(Object x, NotificationType type, (List<String>)=>void observer) {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("enum NotificationType {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("CHANGED,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("DELETED");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString(), false);
      this.testHelper.assertError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INVALID_NUMBER_OF_ARGUMENTS, "observeUnexpected");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
