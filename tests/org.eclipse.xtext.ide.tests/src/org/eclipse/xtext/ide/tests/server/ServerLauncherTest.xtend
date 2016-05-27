/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.InitializeParamsImpl
import io.typefox.lsapi.json.JsonBasedLanguageServer
import org.eclipse.xtext.ide.server.ServerLauncher
import org.junit.Test
import java.lang.ProcessBuilder.Redirect

/**
 * @author efftinge - Initial contribution and API
 */
class ServerLauncherTest {
    
    @Test def void testServerLaunch() {
        val process = new ProcessBuilder("java","-cp",System.getProperty("java.class.path"), "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=1044", ServerLauncher.name).redirectInput(Redirect.PIPE).redirectOutput(Redirect.PIPE).start
        
        try {
            val client = new JsonBasedLanguageServer()
            client.connect(process.inputStream, process.outputStream)
            
            println(client.initialize(new InitializeParamsImpl() => [
                rootPath = "."
            ]))
        } finally {
            process.destroy
        }
    }
}