/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.impl.InitializeParamsImpl
import io.typefox.lsapi.services.json.JsonBasedLanguageServer
import java.lang.ProcessBuilder.Redirect
import org.eclipse.xtext.ide.server.ServerLauncher
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * @author efftinge - Initial contribution and API
 */
class ServerLauncherTest {
	
	Process process
	
	@Before
	def void setUp() {
		this.process = new ProcessBuilder("java","-cp",System.getProperty("java.class.path")
		      , ServerLauncher.name
//            ,"debug"
        ).redirectInput(Redirect.PIPE).redirectOutput(Redirect.PIPE).start
	}
	
	@After
	def void tearDown() {
		process?.destroy	
	}
    
    @Test(timeout = 3000) 
    def void testServerLaunch() {
        val client = new JsonBasedLanguageServer()
        client.protocol.addErrorListener[p1, p2|
            System.err.println(p1)
            p2?.printStackTrace
        ]
        client.connect(process.inputStream, process.outputStream)
        val msg = client.initialize(new InitializeParamsImpl() => [
            rootPath = "."
        ]).get
        Assert.assertTrue(msg != null)
        client.shutdown
        client.exit
    }

}