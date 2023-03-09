/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Collections;
import java.util.List;

/**
 * Enumeration of Java language versions. This is likely to be extended as new versions are released.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 * @since 2.9
 */
public enum JavaVersion {
	
	/**
	 * Java 5 language enhancements: generics, simplified for-loop, autoboxing and unboxing, enums, varargs, static
	 * import, annotations.
	 */
	JAVA5("Java 5", new String[] {"1.5"}, "J2SE-1.5", "-1.5", Constants.JAVA5),

	/**
	 * Java 6 language enhancements: Override annotations for implemented methods.
	 */
	JAVA6("Java 6", new String[] {"1.6", "6"}, "JavaSE-1.6", "-1.6", Constants.JAVA6),

	/**
	 * Java 7 language enhancements: extended numeric literals, switch over strings, type inference, try-with-resources,
	 * catch multiple exceptions.
	 */
	JAVA7("Java 7", new String[] {"1.7", "7"}, "JavaSE-1.7", "-1.7", Constants.JAVA7),

	/**
	 * Java 8 language enhancements: lambda expressions, better type inference, more flexible annotations.
	 */
	JAVA8("Java 8", new String[] {"1.8", "8"}, "JavaSE-1.8", "-1.8", Constants.JAVA8),

	/**
	 * Java 9 language enhancements: mainly modules and a different version scheme (9 is favored over 1.9).
	 */
	JAVA9("Java 9", new String[] {"9", "1.9"}, "JavaSE-9", "-1.9", Constants.JAVA9),
	
	/**
	 * Java 10 language enhancements: local variable type inference (keyword 'var') (10 is favored over 1.10).
	 */
	JAVA10("Java 10", new String[] {"10", "1.10"}, "JavaSE-10", "-1.10", Constants.JAVA10),
	/**
	 * Well, Java 11
	 */
	JAVA11("Java 11", new String[] {"11", "1.11"}, "JavaSE-11", "-1.11", Constants.JAVA11),
	/**
	 * Well, Java 17, next LTS version
	 */
	JAVA17("Java 17", new String[] {"17", "1.17"}, "JavaSE-17", "-1.17", Constants.JAVA17)
	;

	private static final class Constants {
		private static final int MAJOR_VERSION_1_5 = 49;
		private static final int MINOR_VERSION_0 = 0;
		private static final long JAVA5 = ((long)MAJOR_VERSION_1_5 << 16) + MINOR_VERSION_0;
		private static final long JAVA6 = ((long)(MAJOR_VERSION_1_5 + 1) << 16) + MINOR_VERSION_0;
		private static final long JAVA7 = ((long)(MAJOR_VERSION_1_5 + 2) << 16) + MINOR_VERSION_0;
		private static final long JAVA8 = ((long)(MAJOR_VERSION_1_5 + 3) << 16) + MINOR_VERSION_0;
		private static final long JAVA9 = ((long)(MAJOR_VERSION_1_5 + 4) << 16) + MINOR_VERSION_0;
		private static final long JAVA10 = ((long)(MAJOR_VERSION_1_5 + 5) << 16) + MINOR_VERSION_0;
		private static final long JAVA11 = ((long)(MAJOR_VERSION_1_5 + 6) << 16) + MINOR_VERSION_0;
		private static final long JAVA17 = ((long)(MAJOR_VERSION_1_5 + 12) << 16) + MINOR_VERSION_0;
	}

	//	 if you introduce a new JavaVersion don't forget to adapt
	//	 - JavaVersionTest
	//	 - JavaVersionExtendedTest

	private final String label;
	private final String[] qualifiers;
	private final String bree;
	private final String complianceLevelArg;
	private final long jdtClassFileConstant;

	JavaVersion(String label, String[] qualifiers, String bree, String complianceLevelArg, long jdtClassFileConstant) {
		this.label = label;
		this.qualifiers = qualifiers;
		this.bree = bree;
		this.complianceLevelArg = complianceLevelArg;
		this.jdtClassFileConstant = jdtClassFileConstant;
	}

	public static JavaVersion fromQualifier(String qualifier) {
		JavaVersion[] values = JavaVersion.values();
		// iterate backwards since it's a fair assumption that we'll use a more recent java version
		for(int i = values.length - 1; i >= 0; i--) {
			JavaVersion candidate = values[i];
			if (Arrays.contains(candidate.qualifiers, qualifier))
				return candidate;
		}
		return null;
	}

	public static JavaVersion fromBree(String bree) {
		for (JavaVersion version : JavaVersion.values()) {
			if (version.bree.equals(bree))
				return version;
		}
		return null;
	}
	
	/**
	 * @since 2.14
	 */
	public String getComplianceLevelArg() {
		return complianceLevelArg;
	}
	
	public String getLabel() {
		return label;
	}
	
	/**
	 * @since 2.14
	 */
	public List<String> getAllQualifiers() {
		return Collections.unmodifiableList(java.util.Arrays.asList(qualifiers));
	}

	public String getQualifier() {
		return qualifiers[0];
	}

	public String getBree() {
		return bree;
	}

	public boolean isAtLeast(JavaVersion other) {
		// This implementation relies on the correct order of declaration of the enum constants
		return this.ordinal() >= other.ordinal();
	}

	/**
	 * @since 2.14
	 */
	public long toJdtClassFileConstant() {
		return jdtClassFileConstant;
	}
}
