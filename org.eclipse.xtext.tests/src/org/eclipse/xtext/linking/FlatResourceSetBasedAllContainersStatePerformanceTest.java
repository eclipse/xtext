/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.containers.FlatResourceSetBasedAllContainersState;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author kosyakov - Initial contribution and API
 */
@Ignore
public class FlatResourceSetBasedAllContainersStatePerformanceTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new IgnoreCaseNamespacesTestLanguageStandaloneSetup() {

			@Override
			public Injector createInjector() {
				return Guice.createInjector(new IgnoreCaseNamespacesTestLanguageRuntimeModule());
			}

		});
	}

	@Test
	public void testGetContainedURIs() throws IOException {
		Stopwatches.setEnabled(true);
		for (int attempt = 0; attempt < 3; attempt++) {
	//		File directory = null;
	//		List<File> files = new ArrayList<File>();
			try {
				XtextResourceSet resourceSet = get(XtextResourceSet.class);
				resourceSet.setClasspathURIContext(getClass().getClassLoader());
				
	//			directory = new File("/Users/kosyakov/oomph/xtext/master/git/xtext/tests/org.eclipse.xtext.tests/src/org/eclipse/xtext/linking/ignorecasenamespacestestlanguage");
	//			directory.mkdir();
	//			Map<String, String> importedEntities = new HashMap<String, String>();
				
				StoppedTask getResourceTask = Stopwatches.forTask("getResource");
				getResourceTask.start();
				for (int i = 0; i < 1000; i++) {
	//				File file = new File(directory, (i + 1) + ".ignorecasenamespacestestlanguage");
	//				files.add(file);
	//				file.createNewFile();
	//				PrintWriter printWriter = new PrintWriter(new FileWriter(file));
	//				Set<String> keySet = importedEntities.keySet();
	//				for (String importedKey : keySet) {
	//					String importedValue = importedEntities.get(importedKey);
	//					printWriter.print(importedKey);
	//					printWriter.print(".");
	//					printWriter.println(importedValue);
	//				}
	//				String exportedKey = "e" + i;
	//				printWriter.print(exportedKey);
	//				printWriter.println(" {");
	//				Map<String, String> exportedEntities = new HashMap<String, String>();
	//				int j = 0;
	//				String exportedValue = exportedKey + "_" + j++;
	//				exportedEntities.put(exportedKey, exportedValue);
	//				printWriter.print("	");
	//				printWriter.print(exportedValue);
	//				printWriter.println(" { }");
	//				for (String importedKey : keySet) {
	//					String importedValue = importedEntities.get(importedKey);
	//					
	//					exportedValue = exportedKey + "_" + j++;
	//					exportedEntities.put(exportedKey, exportedValue);
	//					printWriter.print("	");
	//					printWriter.print(exportedValue);
	//					printWriter.print(" ");
	//					printWriter.print(importedValue);
	//					printWriter.println(" { }");
	//				}
	//				importedEntities.putAll(exportedEntities);
	//				printWriter.println("}");
	//				printWriter.close();
					
					for (int k = 0; k < 3; k++) {
						resourceSet.getResource(
								URI.createURI("classpath:/org/eclipse/xtext/linking/ignorecasenamespacestestlanguage/"
										+ (i + 1)  + ".ignorecasenamespacestestlanguage"), true);
					}
				}
				getResourceTask.stop();
				
				StoppedTask getContainedURIsTask = Stopwatches.forTask("getContainedURIs");
				getContainedURIsTask.start();
				FlatResourceSetBasedAllContainersState containersState = new FlatResourceSetBasedAllContainersState(resourceSet);
				for (int k = 0; k < 1000; k++) {
					Assert.assertEquals(1000, containersState.getContainedURIs(containersState.getContainerHandle(null)).size());
				}
				getContainedURIsTask.stop();
				
				System.out.println(Stopwatches.getPrintableStopwatchData());
				Stopwatches.resetAll();
			} finally {
	//			for (File file : files) {
	//				file.delete();
	//			}
	//			if (directory != null) {
	//				directory.delete();
	//			}
			}
		}
	}

}
