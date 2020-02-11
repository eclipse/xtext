/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.filesystem;

import com.google.common.base.StandardSystemProperty;
import com.google.inject.Inject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.UUID;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.URIBasedFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author akos.kitta - Initial contribution and API
 * 
 * @see https://github.com/eclipse/xtext-core/issues/180
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
@SuppressWarnings("all")
public class URIBasedFileSystemAccessTest {
  private static final String MISSING_RESOURCE_NAME = "someMissingResource";
  
  private static final String EXISTING_RESOURCE_NAME = "someExistingResource";
  
  @Inject
  private URIBasedFileSystemAccess fsa;
  
  @Inject
  private IOutputConfigurationProvider configProvider;
  
  private ExtensibleURIConverterImpl uriConverter = new ExtensibleURIConverterImpl();
  
  @Before
  public void before() {
    try {
      final Path tmpPath = Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("tempFolder_");
      UUID _randomUUID = UUID.randomUUID();
      _builder.append(_randomUUID);
      final Path output = Files.createTempDirectory(tmpPath, _builder.toString());
      final Path resource = Files.createFile(output.resolve(URIBasedFileSystemAccessTest.EXISTING_RESOURCE_NAME));
      resource.toFile().deleteOnExit();
      output.toFile().deleteOnExit();
      final OutputConfiguration config = IterableExtensions.<OutputConfiguration>head(this.configProvider.getOutputConfigurations());
      config.setOutputDirectory(output.toString());
      Pair<String, OutputConfiguration> _mappedTo = Pair.<String, OutputConfiguration>of(IFileSystemAccess.DEFAULT_OUTPUT, config);
      this.fsa.setOutputConfigurations(Collections.<String, OutputConfiguration>unmodifiableMap(CollectionLiterals.<String, OutputConfiguration>newHashMap(_mappedTo)));
      this.fsa.setConverter(this.uriConverter);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFalseOnAbsent() {
    Assert.assertFalse(this.fsa.isFile(URIBasedFileSystemAccessTest.MISSING_RESOURCE_NAME));
  }
  
  @Test
  public void testTrueOnPresent() {
    Assert.assertTrue(this.fsa.isFile(URIBasedFileSystemAccessTest.EXISTING_RESOURCE_NAME));
  }
}
