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
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.xtend.core.formatting.XtendFormatter;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.junit4.smoketest.ProcessedBy;
import org.eclipse.xtext.junit4.smoketest.ScenarioProcessor;
import org.eclipse.xtext.junit4.smoketest.XtextSmokeTestRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;
import org.junit.ComparisonFailure;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

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
		private ParseHelper<XtendFile> parseHelper;
		
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
				XtendFile file = parseHelper.parse(data);
				if (file != null) {
					try {
						IPreferenceValues cfg = new MapBasedPreferenceValues(new HashMap<String, String>());
						formatter.setDiagnoseConflicts(false);
						formatter.format((XtextResource) file.eResource(), 0, data.length(), new FormattingPreferenceValues(cfg));
					} catch(Exception e) {
						ComparisonFailure error = new ComparisonFailure(e.getMessage(), data, "");
						error.setStackTrace(e.getStackTrace());
						throw error;
					}
				}
			}
		}
		
	}
	
}
