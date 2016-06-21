/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider.SingletonPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Sebastian Zarnekow - Include feature calls in exception analysis
 */
public class CheckedExceptionTest extends AbstractXbaseTestCase {
	
	@Inject
	protected ValidationTestHelper helper;
	
	private MapBasedPreferenceValues preferences;
	
	@Inject
	public void setPreferences(SingletonPreferenceValuesProvider prefProvider) {
		preferences = prefProvider.getPreferenceValues(null);
	}
	
	@Before
	public void setSeverity() {
		preferences.put(UNHANDLED_EXCEPTION, "error");
	}
	
	@After
	public void clearPreferences() {
		preferences.clear();
	}
	
	@Test public void testExceptionInClosure_01() throws Exception {
		XExpression expression = expression("{val func = [Integer i| throw new Exception() ]}");
		helper.assertError(expression, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test public void testExceptionInClosure_02() throws Exception {
		XExpression expression = expression("{val func = [Integer i| try { throw new Exception() } catch(Exception e) {} i]}");
		helper.assertNoErrors(expression);
	}
	
	@Test public void testExceptionInClosure_03() throws Exception {
		XExpression expression = expression("{val func = [Integer i| try { throw new Exception() } catch(NoSuchFieldException e) {} i]}");
		helper.assertError(expression, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}

	@Test public void testExceptionInClosure_04() throws Exception {
		XExpression expression = expression("{val func = [Integer i| while(i==1) { throw new Exception() } i]}");
		helper.assertError(expression, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInClosure_05() throws Exception {
		XExpression expression = expression("{val func = [ throw new RuntimeException() ]}");
		helper.assertNoError(expression, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInClosure_06() throws Exception {
		XExpression expression = expression("{val java.beans.VetoableChangeListener listener = [ throw new java.beans.PropertyVetoException() ]}");
		helper.assertNoError(expression, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInClosure_07() throws Exception {
		XExpression expression = expression("{val java.beans.VetoableChangeListener listener = [ throw new java.io.IOException() ]}");
		helper.assertError(expression, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInClosure_08() throws Exception {
		XExpression expression = expression("try {val java.beans.VetoableChangeListener listener = [ throw new java.io.IOException() ]} catch(Exception e) {}");
		helper.assertError(expression, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInTryCatch_01() throws Exception {
		XExpression expression = expression("{ try { throw new Exception() } catch (CloneNotSupportedException e) {} }");
		helper.assertError(expression, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInTryCatch_02() throws Exception {
		XExpression expression = expression("{ try { throw new Exception() } catch (Exception e) {} }");
		helper.assertNoError(expression, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInTryCatch_03() throws Exception {
		XExpression expression = expression("{ try { throw new RuntimeException() } catch (CloneNotSupportedException e) {} }");
		helper.assertNoError(expression, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInTryCatchFinally_01() throws Exception {
		XExpression expression = expression("{ try { 'foo' } catch (Exception e) {} finally { throw new Exception() } }");
		helper.assertError(expression, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionAfterTryCatch_01() throws Exception {
		XExpression expression = expression("{ try { 'foo' } catch (Exception e) {} throw new Exception() }");
		helper.assertError(expression, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInTryCatchCatch_01() throws Exception {
		XExpression expression = expression("{ try { throw new Exception() } catch (CloneNotSupportedException e) {} catch(InstantiationException e2) {} }");
		helper.assertError(expression, XTHROW_EXPRESSION, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInTryCatchCatch_02() throws Exception {
		XExpression expression = expression("{ try { throw new CloneNotSupportedException() } catch (CloneNotSupportedException e) {} catch(InstantiationException e2) {} }");
		helper.assertNoError(expression, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInTryCatchCatch_03() throws Exception {
		XExpression expression = expression("{ try { throw new InstantiationException() } catch (CloneNotSupportedException e) {} catch(InstantiationException e2) {} }");
		helper.assertNoError(expression, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testExceptionInTryCatchNested() throws Exception {
		XExpression expression = expression("{ try { try { throw new InstantiationException() } catch (CloneNotSupportedException e) {} } catch(InstantiationException e2) {} }");
		helper.assertNoError(expression, UNHANDLED_EXCEPTION);
	}
	
	@Test
	public void testConstructorCall_01() throws Exception {
		XExpression expression = expression("new java.net.URI('')");
		helper.assertError(expression, XCONSTRUCTOR_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type URISyntaxException");
	}
	
	@Test
	public void testConstructorCall_02() throws Exception {
		String model = "new java.net.URI('')";
		XExpression expression = expression(model);
		List<Issue> issues = helper.validate(expression);
		assertEquals(issues.toString(), 1, issues.size());
		Issue singleIssue = issues.get(0);
		assertEquals(model.indexOf("java.net.URI"), singleIssue.getOffset().intValue());
		assertEquals("java.net.URI".length(), singleIssue.getLength().intValue());
	}
	
	@Test
	public void testConstructorCall_03() throws Exception {
		XExpression expression = expression("try { new java.net.URI('') } catch(java.net.URISyntaxException e) {}");
		helper.assertNoErrors(expression);
	}
	
	@Test
	public void testConstructorCall_04() throws Exception {
		XExpression expression = expression("try { new java.net.URI('') } catch(RuntimeException e) {}");
		helper.assertError(expression, XCONSTRUCTOR_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type URISyntaxException");
	}
	
	@Test
	public void testFeatureCall_01() throws Exception {
		XExpression expression = expression("''.getBytes('')");
		helper.assertError(expression, XMEMBER_FEATURE_CALL, UNHANDLED_EXCEPTION, "Unhandled exception type UnsupportedEncodingException");
	}
	
	@Test
	public void testFeatureCall_02() throws Exception {
		String model = "''.getBytes('')";
		XExpression expression = expression(model);
		List<Issue> issues = helper.validate(expression);
		assertEquals(issues.toString(), 1, issues.size());
		Issue singleIssue = issues.get(0);
		assertEquals(model.indexOf("getBytes"), singleIssue.getOffset().intValue());
		assertEquals("getBytes".length(), singleIssue.getLength().intValue());
	}
	
	@Test
	public void testFeatureCall_03() throws Exception {
		XExpression expression = expression("try { ''.getBytes('') } catch(Exception e) {}");
		helper.assertNoErrors(expression);
	}
	
}
