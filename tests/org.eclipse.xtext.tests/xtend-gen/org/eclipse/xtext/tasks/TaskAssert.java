/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTag;
import org.junit.Assert;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class TaskAssert {
  public static void assertExactMatch(final Task expected, final Task actual) {
    TaskTag _tag = expected.getTag();
    TaskTag _tag_1 = actual.getTag();
    TaskAssert.assertExactMatch(_tag, _tag_1);
    String _description = expected.getDescription();
    String _description_1 = actual.getDescription();
    Assert.assertEquals(_description, _description_1);
    int _lineNumber = expected.getLineNumber();
    int _lineNumber_1 = actual.getLineNumber();
    Assert.assertEquals(_lineNumber, _lineNumber_1);
    int _offset = expected.getOffset();
    int _offset_1 = actual.getOffset();
    Assert.assertEquals(_offset, _offset_1);
  }
  
  public static void assertExactMatch(final TaskTag expected, final TaskTag actual) {
    String _name = expected.getName();
    String _name_1 = actual.getName();
    Assert.assertEquals(_name, _name_1);
    Priority _priority = expected.getPriority();
    Priority _priority_1 = actual.getPriority();
    Assert.assertEquals(_priority, _priority_1);
  }
}
