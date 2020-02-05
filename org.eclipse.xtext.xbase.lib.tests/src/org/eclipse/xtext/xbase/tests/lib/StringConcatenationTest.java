/*******************************************************************************
 * Copyright (c) 2016, 2017 Pantheon Technologies, s.r.o. and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.junit.Test;

public class StringConcatenationTest {
    // Utility class wrapping a String
    private static final class StringObject extends Object {
        final String string;

        StringObject(final String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    @Test
    public void testEmpty() {
        assertEquals("", new StringConcatenation().toString());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNullDelimiter() {
        new StringConcatenation(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testEmptyDelimiter() {
        new StringConcatenation("");
    }

    @Test
    public void testAppendObjectNull() {
        final StringConcatenation c = new StringConcatenation();
        c.append((Object)null);
        c.append((Object)null, "");
        c.append((Object)null, " ");
        assertEquals("", c.toString());
    }

    @Test
    public void testAppendStringNull() {
        final StringConcatenation c = new StringConcatenation();
        c.append((String)null);
        c.append((String)null, "");
        c.append((String)null, " ");
        assertEquals("", c.toString());
    }

    @Test
    public void testAppendStringConcatNull() {
        final StringConcatenation c = new StringConcatenation();
        c.append((StringConcatenation)null);
        c.append((StringConcatenation)null, "");
        c.append((StringConcatenation)null, " ");
        assertEquals("", c.toString());
    }

    @Test
    public void testAppendStringConcatClientNull() {
        final StringConcatenation c = new StringConcatenation();
        c.append((StringConcatenationClient)null);
        c.append((StringConcatenationClient)null, "");
        c.append((StringConcatenationClient)null, " ");
        assertEquals("", c.toString());
    }

    @Test
    public void testAppendNullToString() {
        final Object o = new StringObject(null);
        final StringConcatenation c = new StringConcatenation();
        c.append(o);
        c.append(o, "");
        assertEquals("", new StringConcatenation().toString());
    }

    @Test(expected=NullPointerException.class)
    public void testAppendWithNullIndent() {
        final StringConcatenation c = new StringConcatenation();
        c.append("a", null);
    }

    @Test(expected=NullPointerException.class)
    public void testAppendNullWithNullIndent() {
        final StringConcatenation c = new StringConcatenation();
        c.append((Object)null, null);
    }

    @Test
    public void testStringConcat() {
        final StringConcatenation c = new StringConcatenation();
        c.append("a");
        c.append("b");
        c.append("c");
        assertEquals("abc", c.toString());
    }

    @Test
    public void testMaskedStringConcat() {
        final StringConcatenation c = new StringConcatenation();
        c.append((Object)"a");
        c.append((Object)"b");
        c.append((Object)"c");
        assertEquals("abc", c.toString());
    }

    @Test
    public void testMixedConcat() {
        final StringConcatenation c = new StringConcatenation();
        c.append("a");
        c.append(Character.valueOf('b'));
        c.append(new StringObject("c"));
        assertEquals("abc", c.toString());
    }

    @Test
    public void testCharSequenceMethods() {
        final StringConcatenation c = new StringConcatenation();
        c.append("a");
        c.append("b");
        c.append("c");

        assertEquals(3, c.length());
        assertEquals('a', c.charAt(0));
        assertEquals('b', c.charAt(1));
        assertEquals("ab", c.subSequence(0, 2));
        assertEquals("bc", c.subSequence(1, 3));
    }

    @Test
    public void testNoindentConcat() {
        final StringConcatenation c = new StringConcatenation("\n");
        c.append("a\n");
        c.append("b\r");
        c.append("c\n");
        assertEquals("a\nb\nc\n", c.toString());
    }

    @Test
    public void testIndentConcat() {
        final StringConcatenation c = new StringConcatenation("\n");
        c.append("a\n", " ");
        c.append("b\r", "  ");
        c.append("c\nd", "   ");
        assertEquals("a\n b\n  c\n   d", c.toString());
    }

    @Test
    public void testMaskedIndentConcat() {
        final StringConcatenation c = new StringConcatenation("\n");
        c.append((Object)"a\n", " ");
        c.append((Object)"b\r", "  ");
        c.append((Object)"c\nd", "   ");
        assertEquals("a\n b\n  c\n   d", c.toString());
    }

    @Test
    public void testObjectIndentConcat() {
        final StringConcatenation c = new StringConcatenation("\n");
        c.append(new StringObject("a\n"), " ");
        c.append(new StringObject("b\r"), "  ");
        c.append(new StringObject("c\nd"), "   ");
        assertEquals("a\n b\n  c\n   d", c.toString());
    }

    @Test
    public void testNewLine() {
        final StringConcatenation c = new StringConcatenation("\n");
        c.newLine();
        c.append("a");
        c.newLine();
        assertEquals("\na\n", c.toString());
    }

    @Test
    public void testNewLineIfNotEmpty() {
        final StringConcatenation c = new StringConcatenation("\n");
        c.newLineIfNotEmpty();
        c.append("a");
        c.newLineIfNotEmpty();
        c.append("b\n");
        c.newLineIfNotEmpty();
        c.append("  ");
        c.newLineIfNotEmpty();
        assertEquals("a\nb\n", c.toString());
    }

    @Test
    public void testCachedToString() {
        final StringConcatenation c = new StringConcatenation();
        c.append("a");
        c.append("b\n");

        final String str = c.toString();
        assertSame(str, c.toString());
    }

    @Test
    public void testAppendEmptyConcat() {
        final StringConcatenation c = new StringConcatenation();
        c.append(new StringConcatenation());
        assertEquals("", c.toString());
        c.append(new StringConcatenation(), "  ");
        assertEquals("", c.toString());
    }

    @Test
    public void testAppendConcat() {
        final StringConcatenation toAppend = new StringConcatenation("\n");
        toAppend.append("a\n");
        toAppend.append("b");

        final StringConcatenation c = new StringConcatenation("\n");
        c.append(toAppend);
        assertEquals("a\nb", c.toString());
    }

    @Test
    public void testAppendConcatSeparator() {
        final StringConcatenation toAppend = new StringConcatenation("\t");
        toAppend.append("a\t");
        toAppend.append("b");

        final StringConcatenation c = new StringConcatenation();
        c.append(toAppend);
        assertEquals("a\tb", c.toString());
    }

    @Test
    public void testAppendEmptyConcatSeparator() {
        final StringConcatenation c = new StringConcatenation();
        c.append(new StringConcatenation("\t"));
        assertEquals("", c.toString());
    }

    @Test
    public void testAppendMaskedConcat() {
        final StringConcatenation toAppend = new StringConcatenation("\n");
        toAppend.append("a\n");
        toAppend.append("b");

        final StringConcatenation c = new StringConcatenation("\n");
        c.append((Object)toAppend);
        assertEquals("a\nb", c.toString());
    }

    @Test
    public void testAppendMaskedIndentConcat() {
        final StringConcatenation toAppend = new StringConcatenation("\n");
        toAppend.append("a\n");
        toAppend.append("b");

        final StringConcatenation c = new StringConcatenation("\n");
        c.append((Object)toAppend, " ");
        assertEquals("a\n b", c.toString());
    }

    @Test
    public void testAppendImmediateSimple() {
        final StringConcatenation c = new StringConcatenation();
        c.appendImmediate("a", "  ");
        assertEquals("a", c.toString());
    }

    @Test
    public void testAppendImmediateComplex() {
        final StringConcatenation c = new StringConcatenation("\n");
        c.append("a\n");
        c.append(" b   ");
        c.newLineIfNotEmpty();
        c.append("    ");
        c.appendImmediate("c\nd", "  ");
        assertEquals("a\n b   c\n  d\n", c.toString());
    }

    @Test
    public void testGrowInChunks() throws Exception {
        // This is rather ugly, but gets the job done. It would be much cleaner if this test were in the same
        // package as the class being tested...
        final Field lss = StringConcatenation.class.getDeclaredField("lastSegmentsSize");
        lss.setAccessible(true);

        final StringConcatenation c = new StringConcatenation();
        final int initialSize = lss.getInt(c);
        assertTrue(initialSize >= 0);

        for (int i = 0; i < initialSize; ++i) {
            c.append("a");
        }

        // No reallocation should happen
        assertEquals(initialSize, lss.getInt(c));

        // This should trigger pre-allocation
        c.append("b");
        final int firstGrown = lss.getInt(c);
        assertTrue(firstGrown > initialSize);

        // The delta needs to be a power-of-two
        final int deltaSize = firstGrown - initialSize;
        assertEquals(1, Integer.bitCount(deltaSize));

        // Now just to make sure, append another set
        final StringConcatenation batch = new StringConcatenation();
        for (int i = 1; i < deltaSize * 2; ++i) {
            batch.newLine();
        }
        c.append(batch);

        final int secondGrown = lss.getInt(c);
        assertTrue(firstGrown < secondGrown);
        assertEquals(deltaSize, secondGrown - firstGrown);
    }
}
