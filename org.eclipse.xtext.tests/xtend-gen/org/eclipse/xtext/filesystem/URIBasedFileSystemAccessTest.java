/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.filesystem;

import com.google.common.base.StandardSystemProperty;
import com.google.inject.Inject;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;
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
  private final static String MISSING_RESOURCE_NAME = "someMissingResource";
  
  private final static String EXISTING_RESOURCE_NAME = "someExistingResource";
  
  @Inject
  private URIBasedFileSystemAccess fsa;
  
  @Inject
  private IOutputConfigurationProvider configProvider;
  
  private ExtensibleURIConverterImpl uriConverter = new ExtensibleURIConverterImpl();
  
  @Before
  public void before() {
    try {
      String _value = StandardSystemProperty.JAVA_IO_TMPDIR.value();
      final Path tmpPath = Paths.get(_value);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("tempFolder_");
      UUID _randomUUID = UUID.randomUUID();
      _builder.append(_randomUUID, "");
      final Path output = Files.createTempDirectory(tmpPath, _builder.toString());
      Path _resolve = output.resolve(URIBasedFileSystemAccessTest.EXISTING_RESOURCE_NAME);
      final Path resource = Files.createFile(_resolve);
      File _file = resource.toFile();
      _file.deleteOnExit();
      File _file_1 = output.toFile();
      _file_1.deleteOnExit();
      Set<OutputConfiguration> _outputConfigurations = this.configProvider.getOutputConfigurations();
      final OutputConfiguration config = IterableExtensions.<OutputConfiguration>head(_outputConfigurations);
      String _string = output.toString();
      config.setOutputDirectory(_string);
      Pair<String, OutputConfiguration> _mappedTo = Pair.<String, OutputConfiguration>of(IFileSystemAccess.DEFAULT_OUTPUT, config);
      this.fsa.setOutputConfigurations(Collections.<String, OutputConfiguration>unmodifiableMap(CollectionLiterals.<String, OutputConfiguration>newHashMap(_mappedTo)));
      this.fsa.setConverter(this.uriConverter);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFalseOnAbsent() {
    boolean _isFile = this.fsa.isFile(URIBasedFileSystemAccessTest.MISSING_RESOURCE_NAME);
    Assert.assertFalse(_isFile);
  }
  
  @Test
  public void testTrueOnPresent() {
    boolean _isFile = this.fsa.isFile(URIBasedFileSystemAccessTest.EXISTING_RESOURCE_NAME);
    Assert.assertTrue(_isFile);
  }
}
