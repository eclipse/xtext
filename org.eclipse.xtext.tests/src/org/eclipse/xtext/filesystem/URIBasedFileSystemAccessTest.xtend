/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.filesystem

import com.google.common.base.StandardSystemProperty
import com.google.inject.Inject
import java.nio.file.Files
import java.nio.file.Paths
import java.util.UUID
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.URIBasedFileSystemAccess
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.tests.XtextInjectorProvider
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author akos.kitta - Initial contribution and API
 * 
 * @see https://github.com/eclipse/xtext-core/issues/180
 */
@RunWith(XtextRunner)
@InjectWith(XtextInjectorProvider)
class URIBasedFileSystemAccessTest {

	static val MISSING_RESOURCE_NAME = 'someMissingResource';
	static val EXISTING_RESOURCE_NAME = 'someExistingResource';

	@Inject
	URIBasedFileSystemAccess fsa;

	@Inject
	IOutputConfigurationProvider configProvider;

	ExtensibleURIConverterImpl uriConverter = new ExtensibleURIConverterImpl();

	@Before
	def void before() {
		val tmpPath = Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value);
		val output = Files.createTempDirectory(tmpPath, '''tempFolder_«UUID.randomUUID»''');
		val resource = Files.createFile(output.resolve(EXISTING_RESOURCE_NAME));

		resource.toFile.deleteOnExit;
		output.toFile.deleteOnExit;

		val config = configProvider.outputConfigurations.head;
		config.outputDirectory = output.toString;
		fsa.outputConfigurations = #{IFileSystemAccess.DEFAULT_OUTPUT -> config};
		fsa.converter = uriConverter;
	}

	@Test
	def void testFalseOnAbsent() {
		assertFalse(fsa.isFile(MISSING_RESOURCE_NAME));
	}

	@Test
	def void testTrueOnPresent() {
		assertTrue(fsa.isFile(EXISTING_RESOURCE_NAME));
	}

}
