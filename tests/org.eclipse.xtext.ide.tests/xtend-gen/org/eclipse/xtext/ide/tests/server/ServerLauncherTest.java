/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.common.base.Objects;
import io.typefox.lsapi.InitializeParamsImpl;
import io.typefox.lsapi.InitializeResult;
import io.typefox.lsapi.json.JsonBasedLanguageServer;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.xtext.ide.server.ServerLauncher;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ServerLauncherTest {
  @Test
  public void testServerLaunch() {
    try {
      String _property = System.getProperty("java.class.path");
      String _name = ServerLauncher.class.getName();
      ProcessBuilder _processBuilder = new ProcessBuilder("java", "-cp", _property, "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=1044", _name);
      ProcessBuilder _redirectInput = _processBuilder.redirectInput(ProcessBuilder.Redirect.PIPE);
      ProcessBuilder _redirectOutput = _redirectInput.redirectOutput(ProcessBuilder.Redirect.PIPE);
      final Process process = _redirectOutput.start();
      try {
        final JsonBasedLanguageServer client = new JsonBasedLanguageServer();
        InputStream _inputStream = process.getInputStream();
        OutputStream _outputStream = process.getOutputStream();
        client.connect(_inputStream, _outputStream);
        InitializeParamsImpl _initializeParamsImpl = new InitializeParamsImpl();
        final Procedure1<InitializeParamsImpl> _function = new Procedure1<InitializeParamsImpl>() {
          @Override
          public void apply(final InitializeParamsImpl it) {
            it.setRootPath(".");
          }
        };
        InitializeParamsImpl _doubleArrow = ObjectExtensions.<InitializeParamsImpl>operator_doubleArrow(_initializeParamsImpl, _function);
        final InitializeResult msg = client.initialize(_doubleArrow);
        boolean _notEquals = (!Objects.equal(msg, null));
        Assert.assertTrue(_notEquals);
      } finally {
        process.destroy();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
