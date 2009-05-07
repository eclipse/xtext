package org.eclipse.emf.index.guice;

import org.eclipse.emf.index.IndexStore;

import com.google.inject.Inject;

public class TestDependencyInjection extends AbstractEmfIndexTest {
	
	@Inject 
	private IndexStore indexStore;

	public void testIndexStoreSingleton() throws Exception {
		TestClass testClass = new TestClass();
		injector.injectMembers(testClass);
		assertEquals(indexStore, testClass.indexStore);
	}
	
	private static class TestClass {
		@Inject 
		public IndexStore indexStore;
	}
}
