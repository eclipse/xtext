/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.lib;

import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
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
    int[] _clone = this.intArray.clone();
    Assert.assertNotSame(this.intArray, _clone);
    int[] _clone_1 = this.intArray.clone();
    Assert.assertArrayEquals(this.intArray, _clone_1);
    boolean[] _clone_2 = this.booleanArray.clone();
    Assert.assertNotSame(this.booleanArray, _clone_2);
    boolean[] _clone_3 = this.booleanArray.clone();
    boolean _equals = Arrays.equals(this.booleanArray, _clone_3);
    Assert.assertTrue(_equals);
    long[] _clone_4 = this.longArray.clone();
    Assert.assertNotSame(this.longArray, _clone_4);
    long[] _clone_5 = this.longArray.clone();
    Assert.assertArrayEquals(this.longArray, _clone_5);
    double[] _clone_6 = this.doubleArray.clone();
    Assert.assertNotSame(this.doubleArray, _clone_6);
    double[] _clone_7 = this.doubleArray.clone();
    boolean _equals_1 = Arrays.equals(this.doubleArray, _clone_7);
    Assert.assertTrue(_equals_1);
    String[] _clone_8 = this.stringArray.clone();
    Assert.assertNotSame(this.stringArray, _clone_8);
    Object[] _clone_9 = this.stringArray.clone();
    Assert.assertArrayEquals(this.stringArray, _clone_9);
    char[] _clone_10 = this.charArray.clone();
    Assert.assertNotSame(this.charArray, _clone_10);
    char[] _clone_11 = this.charArray.clone();
    Assert.assertArrayEquals(this.charArray, _clone_11);
  }
  
  @Test
  public void testHashCode() {
    int _objectHashCode = this.objectHashCode(this.intArray);
    int _hashCode = this.intArray.hashCode();
    Assert.assertEquals(_objectHashCode, _hashCode);
    int _objectHashCode_1 = this.objectHashCode(this.booleanArray);
    int _hashCode_1 = this.booleanArray.hashCode();
    Assert.assertEquals(_objectHashCode_1, _hashCode_1);
    int _objectHashCode_2 = this.objectHashCode(this.longArray);
    int _hashCode_2 = this.longArray.hashCode();
    Assert.assertEquals(_objectHashCode_2, _hashCode_2);
    int _objectHashCode_3 = this.objectHashCode(this.doubleArray);
    int _hashCode_3 = this.doubleArray.hashCode();
    Assert.assertEquals(_objectHashCode_3, _hashCode_3);
    int _objectHashCode_4 = this.objectHashCode(this.stringArray);
    int _hashCode_4 = this.stringArray.hashCode();
    Assert.assertEquals(_objectHashCode_4, _hashCode_4);
    int _objectHashCode_5 = this.objectHashCode(this.charArray);
    int _hashCode_5 = this.charArray.hashCode();
    Assert.assertEquals(_objectHashCode_5, _hashCode_5);
  }
  
  @Test
  public void testEquals() {
    boolean _equals = ArrayExtensions.equals(this.intArray, this.intArray);
    Assert.assertTrue(_equals);
    boolean _equals_1 = ArrayExtensions.equals(this.booleanArray, this.booleanArray);
    Assert.assertTrue(_equals_1);
    boolean _equals_2 = ArrayExtensions.equals(this.longArray, this.longArray);
    Assert.assertTrue(_equals_2);
    boolean _equals_3 = ArrayExtensions.equals(this.doubleArray, this.doubleArray);
    Assert.assertTrue(_equals_3);
    boolean _equals_4 = ArrayExtensions.equals(this.stringArray, this.stringArray);
    Assert.assertTrue(_equals_4);
    boolean _equals_5 = ArrayExtensions.equals(this.charArray, this.charArray);
    Assert.assertTrue(_equals_5);
  }
  
  public int objectHashCode(final Object x) {
    Class<? extends Object> _class = x.getClass();
    boolean _isArray = _class.isArray();
    Assert.assertTrue(_isArray);
    return x.hashCode();
  }
}
