/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Guice
import com.google.inject.Inject
import io.typefox.lsapi.NotificationMessage
import io.typefox.lsapi.json.LanguageServerToJsonAdapter
import io.typefox.lsapi.json.MessageMethods
import java.io.ByteArrayInputStream
import java.io.FileOutputStream
import java.io.PrintStream
import java.util.concurrent.atomic.AtomicBoolean
import org.apache.log4j.Logger

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ServerLauncher {
    
    val LOG = Logger.getLogger(ServerLauncher)
    
    def static void main(String[] args) {
    	val launcher = Guice.createInjector(new ServerModule).getInstance(ServerLauncher)
    	launcher.start()
    }
    
    @Inject LanguageServerImpl languageServer 
    
    private final AtomicBoolean hasExitNotification = new AtomicBoolean(false) 
    
    def void start() {
        val stdin = System.in
        val stdout = System.out
        
        System.setIn(new ByteArrayInputStream(newByteArrayOfSize(0)))
        System.setOut(new PrintStream(new FileOutputStream("out.log")))
        
        System.err.println("Starting Xtext Language Server.")
        val messageAcceptor = new LanguageServerToJsonAdapter(languageServer) {
            override protected _doAccept(NotificationMessage message) {
                if (LOG.isDebugEnabled) {
                    LOG.debug(message)
                }
                if (message.method == MessageMethods.EXIT) {
                    hasExitNotification.set(true);
                }
                super._doAccept(message)
            }
            
            override protected sendResponse(String responseId, Object resultValue) {
                if (LOG.isDebugEnabled) {
                    LOG.debug("response : "+resultValue)
                }
                super.sendResponse(responseId, resultValue)
            }
            
            override protected sendNotification(String methodId, Object parameter) {
                if (LOG.isDebugEnabled) {
                    LOG.debug("id"+methodId)
                    LOG.debug("notification : "+parameter)
                }
                super.sendNotification(methodId, parameter)
            }
            
            override protected sendResponseError(String responseId, String errorMessage, int errorCode, Object errorData) {
                if (LOG.isDebugEnabled) {
                    LOG.debug("id"+responseId)
                    LOG.debug("error : "+errorMessage)
                }
                super.sendResponseError(responseId, errorMessage, errorCode, errorData)
            }
            
        }
        messageAcceptor.connect(stdin, stdout)
        messageAcceptor.start
        System.err.println("started.")
        messageAcceptor.join
        while (!hasExitNotification.get) {
            Thread.sleep(10_000l)
        }
        System.err.println("Exit notification received. Good Bye!")
    }
    
}