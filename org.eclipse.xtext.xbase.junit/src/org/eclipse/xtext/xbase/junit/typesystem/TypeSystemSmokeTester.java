/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit.typesystem;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import org.eclipse.xtext.junit4.smoketest.ScenarioProcessor;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated Use org.eclipse.xtext.xbase.testing.typesystem.TypeSystemSmokeTester instead
 */
@Deprecated(forRemoval = true)
@Singleton
public class TypeSystemSmokeTester extends ScenarioProcessor {
	@Inject
	private Oven oven;
	
	private static final Pattern WS = Pattern.compile("\\s{2,}");
	
	private MessageDigest messageDigest;
	private Set<BigInteger> seen;
	
	public TypeSystemSmokeTester() throws NoSuchAlgorithmException {
		messageDigest = MessageDigest.getInstance("MD5");
		seen = Sets.newSetFromMap(new ConcurrentHashMap<BigInteger, Boolean>());
	}
	
	@Override
	public String preProcess(String data) {
		return WS.matcher(data).replaceAll(" ");
	}
	
	@Override
	public void processFile(String data) throws Exception {
		byte[] hash = ((MessageDigest) messageDigest.clone()).digest(data.getBytes("UTF-8"));
		if (seen.add(new BigInteger(hash))) {
			oven.fireproof(data);
		}
	}
}