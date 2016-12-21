/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.tasks;

import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTag;
import org.junit.Assert;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class TaskAssert {
  public static void assertExactMatch(final Task expected, final Task actual) {
    TaskAssert.assertExactMatch(expected.getTag(), actual.getTag());
    Assert.assertEquals(expected.getDescription(), actual.getDescription());
    Assert.assertEquals(expected.getLineNumber(), actual.getLineNumber());
    Assert.assertEquals(expected.getOffset(), actual.getOffset());
  }
  
  public static void assertExactMatch(final TaskTag expected, final TaskTag actual) {
    Assert.assertEquals(expected.getName(), actual.getName());
    Assert.assertEquals(expected.getPriority(), actual.getPriority());
  }
}
