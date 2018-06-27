/*******************************************************************************
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard;

public enum SourceLayout {
	PLAIN("Plain") {
		@Override
		public String getPathFor(Outlet outlet) {
			switch (outlet) {
			case ROOT:
				return "";
			case MAIN_JAVA:
				return "src";
			case MAIN_RESOURCES:
				return "src";
			case TEST_RESOURCES:
				return "src";
			case TEST_JAVA:
				return "src";
			case META_INF:
				return "META-INF";
			case MAIN_SRC_GEN:
				return "src-gen";
			case MAIN_XTEND_GEN:
				return "xtend-gen";
			case TEST_SRC_GEN:
				return "src-gen";
			case TEST_XTEND_GEN:
				return "xtend-gen";
			case WEBAPP:
				return "WebRoot";
			default:
				throw new IllegalArgumentException("Unknown Outlet " + outlet);
			}
		}

		@Override
		public String getOutputFor(Outlet outlet) {
			switch (outlet) {
			case ROOT:
				return "";
			case MAIN_JAVA:
				return "bin";
			case MAIN_RESOURCES:
				return "bin";
			case TEST_RESOURCES:
				return "bin";
			case TEST_JAVA:
				return "bin";
			case META_INF:
				return "META-INF";
			case MAIN_SRC_GEN:
				return "bin";
			case MAIN_XTEND_GEN:
				return "bin";
			case TEST_SRC_GEN:
				return "bin-test";
			case TEST_XTEND_GEN:
				return "bin-test";
			case WEBAPP:
				return "WebRoot";
			default:
				throw new IllegalArgumentException("Unknown Outlet " + outlet);
			}
		}

		@Override
		public boolean isTest(Outlet outlet) {
			switch (outlet) {
			case ROOT:
			case MAIN_JAVA:
			case MAIN_RESOURCES:
			case META_INF:
			case MAIN_SRC_GEN:
			case MAIN_XTEND_GEN:
			case WEBAPP:
				return false;
			case TEST_RESOURCES:
			case TEST_JAVA:
			case TEST_SRC_GEN:
			case TEST_XTEND_GEN:
				return true;
			default:
				throw new IllegalArgumentException("Unknown Outlet " + outlet);
			}
		}
	},

	MAVEN("Maven/Gradle") {
		@Override
		public String getPathFor(Outlet outlet) {
			switch (outlet) {
			case ROOT:
				return "";
			case MAIN_JAVA:
				return "src/main/java";
			case MAIN_RESOURCES:
				return "src/main/resources";
			case TEST_JAVA:
				return "src/test/java";
			case TEST_RESOURCES:
				return "src/test/resources";
			case META_INF:
				return "src/main/resources/META-INF";
			case MAIN_SRC_GEN:
				return "src/main/xtext-gen";
			case MAIN_XTEND_GEN:
				return "src/main/xtend-gen";
			case TEST_SRC_GEN:
				return "src/test/xtext-gen";
			case TEST_XTEND_GEN:
				return "src/test/xtend-gen";
			case WEBAPP:
				return "src/main/webapp";
			default:
				throw new IllegalArgumentException("Unknown Outlet " + outlet);
			}
		}

		@Override
		public String getOutputFor(Outlet outlet) {
			switch (outlet) {
			case ROOT:
				return "";
			case MAIN_JAVA:
				return "target/main/java";
			case MAIN_RESOURCES:
				return "target/main/resources";
			case TEST_JAVA:
				return "target/test/java";
			case TEST_RESOURCES:
				return "target/test/resources";
			case META_INF:
				return "target/main/resources/META-INF";
			case MAIN_SRC_GEN:
				return "target/main/xtext-gen";
			case MAIN_XTEND_GEN:
				return "target/main/xtend-gen";
			case TEST_SRC_GEN:
				return "target/test/xtext-gen";
			case TEST_XTEND_GEN:
				return "target/test/xtend-gen";
			case WEBAPP:
				return "target/main/webapp";
			default:
				throw new IllegalArgumentException("Unknown Outlet " + outlet);
			}
		}

		@Override
		public boolean isTest(Outlet outlet) {
			switch (outlet) {
			case ROOT:
			case MAIN_JAVA:
			case MAIN_RESOURCES:
			case META_INF:
			case MAIN_SRC_GEN:
			case MAIN_XTEND_GEN:
			case WEBAPP:
				return false;
			case TEST_RESOURCES:
			case TEST_JAVA:
			case TEST_SRC_GEN:
			case TEST_XTEND_GEN:
				return true;
			default:
				throw new IllegalArgumentException("Unknown Outlet " + outlet);
			}
		}
	};

	private String humanReadableName;

	public abstract String getPathFor(Outlet outlet);

	public abstract String getOutputFor(Outlet outlet);

	public abstract boolean isTest(Outlet outlet);

	private SourceLayout(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}

	public String toString() {
		return humanReadableName;
	}
}
