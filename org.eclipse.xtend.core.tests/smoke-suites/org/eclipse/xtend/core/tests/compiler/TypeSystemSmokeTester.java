package org.eclipse.xtend.core.tests.compiler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import org.eclipse.xtend.core.tests.typesystem.Oven;
import org.eclipse.xtext.testing.smoketest.ScenarioProcessor;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
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