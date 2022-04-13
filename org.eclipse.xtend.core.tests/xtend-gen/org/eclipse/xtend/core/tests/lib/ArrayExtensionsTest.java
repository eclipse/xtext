/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.lib;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ArrayExtensionsTest {
  private int[] intArray = { 1, 2, 3 };

  private boolean[] booleanArray = { true, false };

  private long[] longArray = { 1, 2, 3 };

  private double[] doubleArray = { 1, 2, 3 };

  private String[] stringArray = { "foo", "bar", "baz" };

  private char[] charArray = { 'a', 'b', 'c' };

  @Test
  public void testClone() {
    Assert.assertNotSame(this.intArray, this.intArray.clone());
    Assert.assertArrayEquals(this.intArray, this.intArray.clone());
    Assert.assertNotSame(this.booleanArray, this.booleanArray.clone());
    Assert.assertTrue(Arrays.equals(this.booleanArray, this.booleanArray.clone()));
    Assert.assertNotSame(this.longArray, this.longArray.clone());
    Assert.assertArrayEquals(this.longArray, this.longArray.clone());
    Assert.assertNotSame(this.doubleArray, this.doubleArray.clone());
    Assert.assertTrue(Arrays.equals(this.doubleArray, this.doubleArray.clone()));
    Assert.assertNotSame(this.stringArray, this.stringArray.clone());
    Assert.assertArrayEquals(this.stringArray, this.stringArray.clone());
    Assert.assertNotSame(this.charArray, this.charArray.clone());
    Assert.assertArrayEquals(this.charArray, this.charArray.clone());
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(this.objectHashCode(this.intArray), this.intArray.hashCode());
    Assert.assertEquals(this.objectHashCode(this.booleanArray), this.booleanArray.hashCode());
    Assert.assertEquals(this.objectHashCode(this.longArray), this.longArray.hashCode());
    Assert.assertEquals(this.objectHashCode(this.doubleArray), this.doubleArray.hashCode());
    Assert.assertEquals(this.objectHashCode(this.stringArray), this.stringArray.hashCode());
    Assert.assertEquals(this.objectHashCode(this.charArray), this.charArray.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(this.intArray.equals(this.intArray));
    Assert.assertTrue(this.booleanArray.equals(this.booleanArray));
    Assert.assertTrue(this.longArray.equals(this.longArray));
    Assert.assertTrue(this.doubleArray.equals(this.doubleArray));
    Assert.assertTrue(this.stringArray.equals(this.stringArray));
    Assert.assertTrue(this.charArray.equals(this.charArray));
    Assert.assertFalse(this.intArray.equals(this.intArray.clone()));
    Assert.assertFalse(this.booleanArray.equals(this.booleanArray.clone()));
    Assert.assertFalse(this.longArray.equals(this.longArray.clone()));
    Assert.assertFalse(this.doubleArray.equals(this.doubleArray.clone()));
    Assert.assertFalse(this.stringArray.equals(this.stringArray.clone()));
    Assert.assertFalse(this.charArray.equals(this.charArray.clone()));
  }

  public int objectHashCode(final Object x) {
    Assert.assertTrue(x.getClass().isArray());
    return x.hashCode();
  }
}
