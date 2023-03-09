/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ReturnTypeComputationTest extends AbstractXbaseTestCase {
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Test public void testReturnType_00() throws Exception {
		assertReturnType("java.lang.String", "return 'foo'");
	}
	
	@Test
	public void testReturnType_01() throws Exception {
		assertReturnType("java.lang.String", "'foo'");
	}
	
	@Test public void testReturnType_02() throws Exception {
		assertReturnType("null", "return null");
	}
	
	@Test
	public void testReturnType_03() throws Exception {
		// unresolved feature 'e' is intentional
		assertReturnType("()=>Object", "[| return e]");
	}
	
	@Test
	public void testReturnType_04() throws Exception {
		assertReturnType("()=>java.lang.String", "{ [| return '']}");
	}
	
	@Test public void testReturnType_05() throws Exception {
		assertReturnType("()=>java.lang.String", "return [| '']");
	}
	
	@Test public void testReturnType_06() throws Exception {
		assertReturnType("()=>java.lang.String", "return [| return '']");
	}
	
	@Test public void testReturnType_07() throws Exception {
		assertReturnType("java.lang.Object", "if (true) return 'x' else return new Object()");
	}
	
	@Test public void testReturnType_08() throws Exception {
		assertReturnType("java.lang.Object", "if (true) return 'x' else return new Object()");
	}
	
	@Test public void testReturnType_09() throws Exception {
		assertReturnTypeWithImplictReturnExpression("java.lang.Object", "if (true) return 'x' else [|'x']");
	}
	
	@Test public void testReturnType_10() throws Exception {
		assertReturnTypeWithImplictReturnExpression("java.lang.String", "if (true) return 'x' else 'y'");
	}
	
	@Test public void testReturnType_11() throws Exception {
		assertReturnTypeWithImplictReturnExpression("java.lang.Object", 
				"{" +
				" val x = [|if (true) return 'y' else new Object()]" +
				" x.apply()" +
				"}");
	}
	
	@Test public void testReturnType_12() throws Exception {
		assertReturnTypeWithImplictReturnExpression("java.lang.String", 
				"{" +
				" val x = [|if (true) return 'y' else 'x']" +
				" x.apply()" +
		"}");
	}
	
	@Test public void testThrownTypes_00() throws Exception {
		assertThrownTypes("throw new RuntimeException()", RuntimeException.class.getName());
	}
	
	@Test public void testThrownTypes_01() throws Exception {
		assertThrownTypes("{ if (true) throw new RuntimeException() else throw new IllegalArgumentException() }", 
				IllegalArgumentException.class.getName(), 
				RuntimeException.class.getName());
	}
	
	@Test public void testThrownTypes_02() throws Exception {
		assertThrownTypes("{ if (true) throw new RuntimeException() else [|throw new IllegalArgumentException()] }", 
				RuntimeException.class.getName());
	}
	
	@Test public void testThrownTypes_03() throws Exception {
		assertThrownTypes("try { if (true) throw new RuntimeException() else throw new IllegalArgumentException() } catch (IllegalArgumentException e) {}", 
				RuntimeException.class.getName());
	}
	
	@Test public void testThrownTypes_04() throws Exception {
		assertThrownTypes("try { if (true) throw new RuntimeException() else throw new IllegalArgumentException() } catch (IllegalArgumentException e) {" +
				" throw new NullPointerException()" +
				"}", 
				NullPointerException.class.getName(),
				RuntimeException.class.getName());
	}
	
	@Test public void testThrownTypes_05() throws Exception {
		assertThrownTypes("try { if (true) throw new RuntimeException() else throw new IllegalArgumentException() } catch (IllegalArgumentException e) {" +
				" throw new NullPointerException()" +
				"} catch (NullPointerException e) {" + 
				"} catch (RuntimeException e) {}", 
				NullPointerException.class.getName());
	}
	
	@Test public void testThrownTypes_06() throws Exception {
		assertThrownTypes("try { if (true) throw new RuntimeException() else throw new IllegalArgumentException() } catch (IllegalArgumentException e) {" +
				" throw new NullPointerException()" +
				"} catch (NullPointerException e) {" + 
				"} catch (RuntimeException e) {" +
				"} finally {" +
				"  throw new UnsupportedOperationException()" +
				"}", 
				NullPointerException.class.getName(),
				UnsupportedOperationException.class.getName());
	}
	
	@Test public void testThrownTypes_07() throws Exception {
		assertThrownTypes("{ if (true) throw new RuntimeException() else throw new RuntimeException() }", 
				RuntimeException.class.getName());
	}
	
	@Test public void testThrownTypes_08() throws Exception {
		assertThrownTypes("(null as java.io.InputStream).read()", 
				IOException.class.getName());
	}
	
	protected void assertThrownTypes(String expression, String...thrownTypes) throws Exception {
		final XExpression expr = expression(expression);
		List<LightweightTypeReference> exceptions = typeResolver.resolveTypes(expr).getThrownExceptions(expr);
		ArrayList<String> actual = newArrayList(transform(exceptions, new Function<LightweightTypeReference, String>() {
			@Override
			public String apply(LightweightTypeReference from) {
				return from.getIdentifier();
			}
		}));
		ArrayList<String> expected = newArrayList(Arrays.asList(thrownTypes));
		Collections.sort(actual);
		Collections.sort(expected);
		assertEquals(expected.toString(), actual.toString());
	}
		
	public void assertReturnTypeWithImplictReturnExpression(String expected, String expression) throws Exception {
		final XExpression expr = expression(expression);
		final LightweightTypeReference returnType = typeResolver.resolveTypes(expr).getReturnType(expr);
		assertNotNull(returnType);
		assertEquals(expected, returnType.getIdentifier());
	}
	
	public void assertReturnType(String expected, String expression) throws Exception {
		final XExpression expr = expression(expression);
		final LightweightTypeReference returnType = typeResolver.resolveTypes(expr).getReturnType(expr);
		assertNotNull(returnType);
		assertEquals(expected, returnType.getIdentifier());
	}
}
