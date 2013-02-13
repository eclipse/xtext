package org.eclipse.xtext.xbase.tests.lib;

import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class ExclusiveRangeTest {
  @Test
  public void testContent() {
    ExclusiveRange _exclusiveRange = new ExclusiveRange(1, 5, true);
    String _join = IterableExtensions.join(_exclusiveRange, ",");
    Assert.assertEquals("1,2,3,4", _join);
    ExclusiveRange _exclusiveRange_1 = new ExclusiveRange(0, 0, true);
    String _join_1 = IterableExtensions.join(_exclusiveRange_1, ",");
    Assert.assertEquals("", _join_1);
    int _minus = (-1);
    ExclusiveRange _exclusiveRange_2 = new ExclusiveRange(0, _minus, true);
    String _join_2 = IterableExtensions.join(_exclusiveRange_2, ",");
    Assert.assertEquals("", _join_2);
    int _minus_1 = (-1);
    ExclusiveRange _exclusiveRange_3 = new ExclusiveRange(_minus_1, 0, true);
    String _join_3 = IterableExtensions.join(_exclusiveRange_3, ",");
    Assert.assertEquals("-1", _join_3);
    ExclusiveRange _exclusiveRange_4 = new ExclusiveRange(5, 1, false);
    String _join_4 = IterableExtensions.join(_exclusiveRange_4, ",");
    Assert.assertEquals("4,3,2,1", _join_4);
    ExclusiveRange _exclusiveRange_5 = new ExclusiveRange(0, 0, false);
    String _join_5 = IterableExtensions.join(_exclusiveRange_5, ",");
    Assert.assertEquals("", _join_5);
    int _minus_2 = (-1);
    ExclusiveRange _exclusiveRange_6 = new ExclusiveRange(_minus_2, 0, false);
    String _join_6 = IterableExtensions.join(_exclusiveRange_6, ",");
    Assert.assertEquals("", _join_6);
    int _minus_3 = (-1);
    ExclusiveRange _exclusiveRange_7 = new ExclusiveRange(0, _minus_3, false);
    String _join_7 = IterableExtensions.join(_exclusiveRange_7, ",");
    Assert.assertEquals("-1", _join_7);
  }
  
  @Test
  public void testSize() {
    ExclusiveRange _exclusiveRange = new ExclusiveRange(1, 5, true);
    int _size = _exclusiveRange.getSize();
    Assert.assertEquals(4, _size);
    ExclusiveRange _exclusiveRange_1 = new ExclusiveRange(0, 0, true);
    int _size_1 = _exclusiveRange_1.getSize();
    Assert.assertEquals(0, _size_1);
    int _minus = (-1);
    ExclusiveRange _exclusiveRange_2 = new ExclusiveRange(0, _minus, true);
    int _size_2 = _exclusiveRange_2.getSize();
    Assert.assertEquals(0, _size_2);
    int _minus_1 = (-1);
    ExclusiveRange _exclusiveRange_3 = new ExclusiveRange(_minus_1, 0, true);
    int _size_3 = _exclusiveRange_3.getSize();
    Assert.assertEquals(1, _size_3);
    ExclusiveRange _exclusiveRange_4 = new ExclusiveRange(5, 1, false);
    int _size_4 = _exclusiveRange_4.getSize();
    Assert.assertEquals(4, _size_4);
    ExclusiveRange _exclusiveRange_5 = new ExclusiveRange(0, 0, false);
    int _size_5 = _exclusiveRange_5.getSize();
    Assert.assertEquals(0, _size_5);
    int _minus_2 = (-1);
    ExclusiveRange _exclusiveRange_6 = new ExclusiveRange(_minus_2, 0, false);
    int _size_6 = _exclusiveRange_6.getSize();
    Assert.assertEquals(0, _size_6);
    int _minus_3 = (-1);
    ExclusiveRange _exclusiveRange_7 = new ExclusiveRange(0, _minus_3, false);
    int _size_7 = _exclusiveRange_7.getSize();
    Assert.assertEquals(1, _size_7);
  }
  
  @Test
  public void testIsEmpty() {
    ExclusiveRange _exclusiveRange = new ExclusiveRange(1, 5, true);
    boolean _isEmpty = _exclusiveRange.isEmpty();
    Assert.assertFalse(_isEmpty);
    ExclusiveRange _exclusiveRange_1 = new ExclusiveRange(0, 0, true);
    boolean _isEmpty_1 = _exclusiveRange_1.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    int _minus = (-1);
    ExclusiveRange _exclusiveRange_2 = new ExclusiveRange(0, _minus, true);
    boolean _isEmpty_2 = _exclusiveRange_2.isEmpty();
    Assert.assertTrue(_isEmpty_2);
    int _minus_1 = (-1);
    ExclusiveRange _exclusiveRange_3 = new ExclusiveRange(_minus_1, 0, true);
    boolean _isEmpty_3 = _exclusiveRange_3.isEmpty();
    Assert.assertFalse(_isEmpty_3);
    ExclusiveRange _exclusiveRange_4 = new ExclusiveRange(5, 1, false);
    boolean _isEmpty_4 = _exclusiveRange_4.isEmpty();
    Assert.assertFalse(_isEmpty_4);
    ExclusiveRange _exclusiveRange_5 = new ExclusiveRange(0, 0, false);
    boolean _isEmpty_5 = _exclusiveRange_5.isEmpty();
    Assert.assertTrue(_isEmpty_5);
    int _minus_2 = (-1);
    ExclusiveRange _exclusiveRange_6 = new ExclusiveRange(_minus_2, 0, false);
    boolean _isEmpty_6 = _exclusiveRange_6.isEmpty();
    Assert.assertTrue(_isEmpty_6);
    int _minus_3 = (-1);
    ExclusiveRange _exclusiveRange_7 = new ExclusiveRange(0, _minus_3, false);
    boolean _isEmpty_7 = _exclusiveRange_7.isEmpty();
    Assert.assertFalse(_isEmpty_7);
  }
  
  @Test
  public void testContains() {
    ExclusiveRange _exclusiveRange = new ExclusiveRange(1, 5, true);
    boolean _contains = _exclusiveRange.contains(0);
    Assert.assertFalse(_contains);
    ExclusiveRange _exclusiveRange_1 = new ExclusiveRange(1, 5, true);
    boolean _contains_1 = _exclusiveRange_1.contains(1);
    Assert.assertTrue(_contains_1);
    ExclusiveRange _exclusiveRange_2 = new ExclusiveRange(1, 5, true);
    boolean _contains_2 = _exclusiveRange_2.contains(2);
    Assert.assertTrue(_contains_2);
    ExclusiveRange _exclusiveRange_3 = new ExclusiveRange(1, 5, true);
    boolean _contains_3 = _exclusiveRange_3.contains(3);
    Assert.assertTrue(_contains_3);
    ExclusiveRange _exclusiveRange_4 = new ExclusiveRange(1, 5, true);
    boolean _contains_4 = _exclusiveRange_4.contains(4);
    Assert.assertTrue(_contains_4);
    ExclusiveRange _exclusiveRange_5 = new ExclusiveRange(1, 5, true);
    boolean _contains_5 = _exclusiveRange_5.contains(5);
    Assert.assertFalse(_contains_5);
    ExclusiveRange _exclusiveRange_6 = new ExclusiveRange(0, 0, true);
    boolean _contains_6 = _exclusiveRange_6.contains(0);
    Assert.assertFalse(_contains_6);
    int _minus = (-1);
    ExclusiveRange _exclusiveRange_7 = new ExclusiveRange(0, _minus, true);
    boolean _contains_7 = _exclusiveRange_7.contains(0);
    Assert.assertFalse(_contains_7);
    int _minus_1 = (-1);
    ExclusiveRange _exclusiveRange_8 = new ExclusiveRange(0, _minus_1, true);
    int _minus_2 = (-1);
    boolean _contains_8 = _exclusiveRange_8.contains(_minus_2);
    Assert.assertFalse(_contains_8);
    int _minus_3 = (-1);
    ExclusiveRange _exclusiveRange_9 = new ExclusiveRange(_minus_3, 0, true);
    int _minus_4 = (-2);
    boolean _contains_9 = _exclusiveRange_9.contains(_minus_4);
    Assert.assertFalse(_contains_9);
    int _minus_5 = (-1);
    ExclusiveRange _exclusiveRange_10 = new ExclusiveRange(_minus_5, 0, true);
    int _minus_6 = (-1);
    boolean _contains_10 = _exclusiveRange_10.contains(_minus_6);
    Assert.assertTrue(_contains_10);
    int _minus_7 = (-1);
    ExclusiveRange _exclusiveRange_11 = new ExclusiveRange(_minus_7, 0, true);
    int _minus_8 = (-0);
    boolean _contains_11 = _exclusiveRange_11.contains(_minus_8);
    Assert.assertFalse(_contains_11);
    ExclusiveRange _exclusiveRange_12 = new ExclusiveRange(5, 1, false);
    boolean _contains_12 = _exclusiveRange_12.contains(0);
    Assert.assertFalse(_contains_12);
    ExclusiveRange _exclusiveRange_13 = new ExclusiveRange(5, 1, false);
    boolean _contains_13 = _exclusiveRange_13.contains(1);
    Assert.assertTrue(_contains_13);
    ExclusiveRange _exclusiveRange_14 = new ExclusiveRange(5, 1, false);
    boolean _contains_14 = _exclusiveRange_14.contains(2);
    Assert.assertTrue(_contains_14);
    ExclusiveRange _exclusiveRange_15 = new ExclusiveRange(5, 1, false);
    boolean _contains_15 = _exclusiveRange_15.contains(3);
    Assert.assertTrue(_contains_15);
    ExclusiveRange _exclusiveRange_16 = new ExclusiveRange(5, 1, false);
    boolean _contains_16 = _exclusiveRange_16.contains(4);
    Assert.assertTrue(_contains_16);
    ExclusiveRange _exclusiveRange_17 = new ExclusiveRange(5, 1, false);
    boolean _contains_17 = _exclusiveRange_17.contains(5);
    Assert.assertFalse(_contains_17);
    ExclusiveRange _exclusiveRange_18 = new ExclusiveRange(0, 0, false);
    boolean _contains_18 = _exclusiveRange_18.contains(0);
    Assert.assertFalse(_contains_18);
    int _minus_9 = (-1);
    ExclusiveRange _exclusiveRange_19 = new ExclusiveRange(_minus_9, 0, false);
    boolean _contains_19 = _exclusiveRange_19.contains(0);
    Assert.assertFalse(_contains_19);
    int _minus_10 = (-1);
    ExclusiveRange _exclusiveRange_20 = new ExclusiveRange(_minus_10, 0, false);
    int _minus_11 = (-1);
    boolean _contains_20 = _exclusiveRange_20.contains(_minus_11);
    Assert.assertFalse(_contains_20);
    int _minus_12 = (-1);
    ExclusiveRange _exclusiveRange_21 = new ExclusiveRange(0, _minus_12, false);
    int _minus_13 = (-2);
    boolean _contains_21 = _exclusiveRange_21.contains(_minus_13);
    Assert.assertFalse(_contains_21);
    int _minus_14 = (-1);
    ExclusiveRange _exclusiveRange_22 = new ExclusiveRange(0, _minus_14, false);
    int _minus_15 = (-1);
    boolean _contains_22 = _exclusiveRange_22.contains(_minus_15);
    Assert.assertTrue(_contains_22);
    int _minus_16 = (-1);
    ExclusiveRange _exclusiveRange_23 = new ExclusiveRange(0, _minus_16, false);
    int _minus_17 = (-0);
    boolean _contains_23 = _exclusiveRange_23.contains(_minus_17);
    Assert.assertFalse(_contains_23);
  }
}
