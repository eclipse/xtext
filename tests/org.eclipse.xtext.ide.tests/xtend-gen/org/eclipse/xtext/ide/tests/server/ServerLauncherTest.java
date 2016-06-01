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
import io.typefox.lsapi.services.json.JsonBasedLanguageServer;
import io.typefox.lsapi.services.json.LanguageServerProtocol;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CompletableFuture;
import org.eclipse.xtext.ide.server.ServerLauncher;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ServerLauncherTest {
  private Process process;
  
  @Before
  public void setUp() {
    try {
      String _property = System.getProperty("java.class.path");
      String _name = ServerLauncher.class.getName();
      ProcessBuilder _processBuilder = new ProcessBuilder("java", "-cp", _property, _name);
      ProcessBuilder _redirectInput = _processBuilder.redirectInput(ProcessBuilder.Redirect.PIPE);
      ProcessBuilder _redirectOutput = _redirectInput.redirectOutput(ProcessBuilder.Redirect.PIPE);
      Process _start = _redirectOutput.start();
      this.process = _start;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void tearDown() {
    if (this.process!=null) {
      this.process.destroy();
    }
  }
  
  @Test(timeout = 3000)
  public void testServerLaunch() {
    try {
      final JsonBasedLanguageServer client = new JsonBasedLanguageServer();
      LanguageServerProtocol _protocol = client.getProtocol();
      final Procedure2<String, Throwable> _function = (String p1, Throwable p2) -> {
        System.err.println(p1);
        if (p2!=null) {
          p2.printStackTrace();
        }
      };
      _protocol.addErrorListener(_function);
      InputStream _inputStream = this.process.getInputStream();
      OutputStream _outputStream = this.process.getOutputStream();
      client.connect(_inputStream, _outputStream);
      InitializeParamsImpl _initializeParamsImpl = new InitializeParamsImpl();
      final Procedure1<InitializeParamsImpl> _function_1 = (InitializeParamsImpl it) -> {
        it.setRootPath(".");
      };
      InitializeParamsImpl _doubleArrow = ObjectExtensions.<InitializeParamsImpl>operator_doubleArrow(_initializeParamsImpl, _function_1);
      CompletableFuture<InitializeResult> _initialize = client.initialize(_doubleArrow);
      final InitializeResult msg = _initialize.get();
      boolean _notEquals = (!Objects.equal(msg, null));
      Assert.assertTrue(_notEquals);
      client.shutdown();
      client.exit();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
