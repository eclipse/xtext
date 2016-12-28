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
    Assert.assertEquals("1,2,3,4", IterableExtensions.join(new ExclusiveRange(1, 5, true), ","));
    Assert.assertEquals("", IterableExtensions.join(new ExclusiveRange(0, 0, true), ","));
    Assert.assertEquals("", IterableExtensions.join(new ExclusiveRange(0, (-1), true), ","));
    Assert.assertEquals("-1", IterableExtensions.join(new ExclusiveRange((-1), 0, true), ","));
    Assert.assertEquals("4,3,2,1", IterableExtensions.join(new ExclusiveRange(5, 1, false), ","));
    Assert.assertEquals("", IterableExtensions.join(new ExclusiveRange(0, 0, false), ","));
    Assert.assertEquals("", IterableExtensions.join(new ExclusiveRange((-1), 0, false), ","));
    Assert.assertEquals("-1", IterableExtensions.join(new ExclusiveRange(0, (-1), false), ","));
  }
  
  @Test
  public void testSize() {
    Assert.assertEquals(4, new ExclusiveRange(1, 5, true).size());
    Assert.assertEquals(0, new ExclusiveRange(0, 0, true).size());
    Assert.assertEquals(0, new ExclusiveRange(0, (-1), true).size());
    Assert.assertEquals(1, new ExclusiveRange((-1), 0, true).size());
    Assert.assertEquals(4, new ExclusiveRange(5, 1, false).size());
    Assert.assertEquals(0, new ExclusiveRange(0, 0, false).size());
    Assert.assertEquals(0, new ExclusiveRange((-1), 0, false).size());
    Assert.assertEquals(1, new ExclusiveRange(0, (-1), false).size());
  }
  
  @Test
  public void testIsEmpty() {
    Assert.assertFalse(new ExclusiveRange(1, 5, true).isEmpty());
    Assert.assertTrue(new ExclusiveRange(0, 0, true).isEmpty());
    Assert.assertTrue(new ExclusiveRange(0, (-1), true).isEmpty());
    Assert.assertFalse(new ExclusiveRange((-1), 0, true).isEmpty());
    Assert.assertFalse(new ExclusiveRange(5, 1, false).isEmpty());
    Assert.assertTrue(new ExclusiveRange(0, 0, false).isEmpty());
    Assert.assertTrue(new ExclusiveRange((-1), 0, false).isEmpty());
    Assert.assertFalse(new ExclusiveRange(0, (-1), false).isEmpty());
  }
  
  @Test
  public void testContains() {
    Assert.assertFalse(new ExclusiveRange(1, 5, true).contains(0));
    Assert.assertTrue(new ExclusiveRange(1, 5, true).contains(1));
    Assert.assertTrue(new ExclusiveRange(1, 5, true).contains(2));
    Assert.assertTrue(new ExclusiveRange(1, 5, true).contains(3));
    Assert.assertTrue(new ExclusiveRange(1, 5, true).contains(4));
    Assert.assertFalse(new ExclusiveRange(1, 5, true).contains(5));
    Assert.assertFalse(new ExclusiveRange(0, 0, true).contains(0));
    Assert.assertFalse(new ExclusiveRange(0, (-1), true).contains(0));
    Assert.assertFalse(new ExclusiveRange(0, (-1), true).contains((-1)));
    Assert.assertFalse(new ExclusiveRange((-1), 0, true).contains((-2)));
    Assert.assertTrue(new ExclusiveRange((-1), 0, true).contains((-1)));
    Assert.assertFalse(new ExclusiveRange((-1), 0, true).contains((-0)));
    Assert.assertFalse(new ExclusiveRange(5, 1, false).contains(0));
    Assert.assertTrue(new ExclusiveRange(5, 1, false).contains(1));
    Assert.assertTrue(new ExclusiveRange(5, 1, false).contains(2));
    Assert.assertTrue(new ExclusiveRange(5, 1, false).contains(3));
    Assert.assertTrue(new ExclusiveRange(5, 1, false).contains(4));
    Assert.assertFalse(new ExclusiveRange(5, 1, false).contains(5));
    Assert.assertFalse(new ExclusiveRange(0, 0, false).contains(0));
    Assert.assertFalse(new ExclusiveRange((-1), 0, false).contains(0));
    Assert.assertFalse(new ExclusiveRange((-1), 0, false).contains((-1)));
    Assert.assertFalse(new ExclusiveRange(0, (-1), false).contains((-2)));
    Assert.assertTrue(new ExclusiveRange(0, (-1), false).contains((-1)));
    Assert.assertFalse(new ExclusiveRange(0, (-1), false).contains((-0)));
  }
}
