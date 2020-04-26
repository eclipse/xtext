/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.filesystem;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.URIBasedFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.StandardSystemProperty;
import com.google.inject.Inject;

/**
 * @author akos.kitta - Initial contribution and API
 * 
 * @see https://github.com/eclipse/xtext-core/issues/180
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class URIBasedFileSystemAccessTest {
	private static final String MISSING_RESOURCE_NAME = "someMissingResource";

	private static final String EXISTING_RESOURCE_NAME = "someExistingResource";

	@Inject
	private URIBasedFileSystemAccess fsa;

	@Inject
	private IOutputConfigurationProvider configProvider;

	private final ExtensibleURIConverterImpl uriConverter = new ExtensibleURIConverterImpl();

	@Before
	public void before() throws Exception {
		Path tmpPath = Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value());
		Path output = Files.createTempDirectory(tmpPath, "tempFolder_" + UUID.randomUUID());
		Path resource = Files.createFile(output.resolve(URIBasedFileSystemAccessTest.EXISTING_RESOURCE_NAME));
		resource.toFile().deleteOnExit();
		output.toFile().deleteOnExit();
		OutputConfiguration config = configProvider.getOutputConfigurations().iterator().next();
		config.setOutputDirectory(output.toString());
		Map<String, OutputConfiguration> cfgMap = new HashMap<>();
		cfgMap.put(IFileSystemAccess.DEFAULT_OUTPUT, config);
		fsa.setOutputConfigurations(cfgMap);
		fsa.setConverter(uriConverter);
	}

	@Test
	public void testFalseOnAbsent() {
		Assert.assertFalse(fsa.isFile(URIBasedFileSystemAccessTest.MISSING_RESOURCE_NAME));
	}

	@Test
	public void testTrueOnPresent() {
		Assert.assertTrue(fsa.isFile(URIBasedFileSystemAccessTest.EXISTING_RESOURCE_NAME));
	}
}
