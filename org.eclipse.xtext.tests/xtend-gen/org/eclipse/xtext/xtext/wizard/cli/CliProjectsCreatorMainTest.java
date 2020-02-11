/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard.cli;

import java.io.File;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.tests.TemporaryFolder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xtext.wizard.cli.CliProjectsCreatorMain;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 * @since 2.15
 */
@SuppressWarnings("all")
public class CliProjectsCreatorMainTest {
  @Rule
  public TemporaryFolder temp = new TemporaryFolder();
  
  @Test
  public void testCreateGreetingsGradleProject() {
    try {
      final File targetDir = this.temp.newFolder();
      String _absolutePath = targetDir.getAbsolutePath();
      String _plus = ("-targetDir=" + _absolutePath);
      final List<String> args = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_plus, "-languageName=org.xtext.example.mydsl.MyDsl", "-baseName=org.xtext.example.mydsl", "-extension=mydsl", "-enabledProjects=GenericIDE,RuntimeTest", "-buildSystem=GRADLE", "-sourceLayout=MAVEN", "-languageServer=FATJAR", "-xtextVersion=undefined", "-projectLayout=FLAT", "-javaVersion=JAVA10"));
      CliProjectsCreatorMain.main(((String[])Conversions.unwrapArray(args, String.class)));
      final List<String> files = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.xtext.example.mydsl/src/main/java/org/xtext/example/mydsl/GenerateMyDsl.mwe2", "org.xtext.example.mydsl/src/main/java/org/xtext/example/mydsl/MyDsl.xtext", "org.xtext.example.mydsl/build.gradle", "org.xtext.example.mydsl.ide/build.gradle", "org.xtext.example.mydsl.parent/build.gradle", "org.xtext.example.mydsl.parent/gradlew", "org.xtext.example.mydsl.parent/gradlew.bat", "org.xtext.example.mydsl.parent/settings.gradle", "org.xtext.example.mydsl.parent/gradle/source-layout.gradle", "org.xtext.example.mydsl.parent/gradle/wrapper/gradle-wrapper.jar", "org.xtext.example.mydsl.parent/gradle/wrapper/gradle-wrapper.properties"));
      for (final String file : files) {
        Assert.assertTrue(new File(targetDir, file).exists());
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
