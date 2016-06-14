/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.xtend.core.formatting2.XtendFormatter;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.junit4.smoketest.ProcessedBy;
import org.eclipse.xtext.junit4.smoketest.ScenarioProcessor;
import org.eclipse.xtext.junit4.smoketest.XtextSmokeTestRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.ExceptionAcceptor;
import org.junit.ComparisonFailure;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextSmokeTestRunner.class)
@ProcessedBy(FormatterSmokeSuite.FormatterSmokeTester.class)
@SuiteClasses(SmokeTestCases.class)
public class FormatterSmokeSuite {

	public static class FormatterSmokeTester extends ScenarioProcessor {

		@Inject
		private XtendFormatter formatter;

		@Inject
		private Provider<TextRegionAccessBuilder> regionBuilder;

		@Inject
		private ParseHelper<XtendFile> parseHelper;

		@Inject
		private ClassLoader classLoader;
		
		@Inject
		private Provider<XtextResourceSet> resourceSetProvider;

		private MessageDigest messageDigest;
		private Set<BigInteger> seen;

		public FormatterSmokeTester() throws NoSuchAlgorithmException {
			messageDigest = MessageDigest.getInstance("MD5");
			seen = Sets.newSetFromMap(new ConcurrentHashMap<BigInteger, Boolean>());
		}

		@Override
		public void processFile(String data) throws Exception {
			byte[] hash = ((MessageDigest) messageDigest.clone()).digest(data.getBytes("UTF-8"));
			if (seen.add(new BigInteger(hash))) {
				XtextResourceSet resourceSet = resourceSetProvider.get();
				resourceSet.setClasspathURIContext(classLoader);
				XtendFile file = parseHelper.parse(data, resourceSet);
				if (file != null) {
					try {
						XtextResource resource = (XtextResource) file.eResource();
						ITextRegionAccess regions = regionBuilder.get().forNodeModel(resource).create();
						FormatterRequest request = new FormatterRequest().setTextRegionAccess(regions);
						request.setExceptionHandler(ExceptionAcceptor.IGNORING);
						formatter.format(request);
					} catch (Exception e) {
						e.printStackTrace();
						ComparisonFailure error = new ComparisonFailure(e.getMessage(), data, "");
						error.setStackTrace(e.getStackTrace());
						throw error;
					}
				}
			}
		}

	}

}
