package org.eclipse.xtext.xtext.wizard;

public enum Outlet {
	ROOT,
	MAIN_JAVA,
	TEST_JAVA,
	MAIN_RESOURCES,
	TEST_RESOURCES,
	MAIN_SRC_GEN,
	TEST_SRC_GEN,
	MAIN_XTEND_GEN,
	TEST_XTEND_GEN,
	WEBAPP,
	META_INF;
	
	public static Outlet[] generateOutlets() {
		return new Outlet[] { MAIN_SRC_GEN, TEST_SRC_GEN, MAIN_XTEND_GEN, TEST_XTEND_GEN };
	}

	public static Outlet[] testOutlets() {
		return new Outlet[] { TEST_JAVA, TEST_RESOURCES, TEST_SRC_GEN, TEST_XTEND_GEN};
	}
	
}
