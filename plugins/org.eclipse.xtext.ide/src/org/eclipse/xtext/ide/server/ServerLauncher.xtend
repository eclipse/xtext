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
import io.typefox.lsapi.services.json.LanguageServerToJsonAdapter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.io.PrintStream

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ServerLauncher {
    
    private static boolean IS_DEBUG = false
    
    def static void main(String[] args) {
        IS_DEBUG = args.exists[it == 'debug']
    	val launcher = Guice.createInjector(new ServerModule).getInstance(ServerLauncher)
    	launcher.start()
    }
    
    @Inject LanguageServerImpl languageServer 
    
    def void start() {
        val stdin = System.in
        val stdout = System.out
        redirectStandardStreams()
        
        System.err.println("Starting Xtext Language Server.")
        val messageAcceptor = new LanguageServerToJsonAdapter(languageServer) {
            override protected _doAccept(NotificationMessage message) {
                if (IS_DEBUG) {
                    println(message)
                }
                super._doAccept(message)
            }
            
            override protected sendResponse(String responseId, Object resultValue) {
                if (IS_DEBUG) {
                    println("response : "+resultValue)
                }
                super.sendResponse(responseId, resultValue)
            }
            
            override protected sendNotification(String methodId, Object parameter) {
                if (IS_DEBUG) {
                    println("id"+methodId)
                    println("notification : "+parameter)
                }
                super.sendNotification(methodId, parameter)
            }
            
            override protected sendResponseError(String responseId, String errorMessage, int errorCode, Object errorData) {
                if (IS_DEBUG) {
                    println("id"+responseId)
                    println("error : "+errorMessage)
                }
                super.sendResponseError(responseId, errorMessage, errorCode, errorData)
            }
            
			override exit() {
        		System.err.println("Exit notification received. Good Bye!")
				super.exit()
			}
            
        }
        messageAcceptor.protocol.addErrorListener[p1, p2|
            p2.printStackTrace(System.err)
        ]
        messageAcceptor.connect(stdin, stdout)
        System.err.println("started.")
        messageAcceptor.join
        while (true) {
            Thread.sleep(10_000l)
        }
    }
    
    def redirectStandardStreams() {
        System.setIn(new ByteArrayInputStream(newByteArrayOfSize(0)))
        val id = ServerLauncher.name+"-"+System.currentTimeMillis
        if (IS_DEBUG) {
            val stdFileOut = new FileOutputStream("out-"+id+".log")
            System.setOut(new PrintStream(stdFileOut))
            val stdFileErr = new FileOutputStream("error-"+id+".log")
            System.setErr(new PrintStream(stdFileErr))
        } else {
            System.setOut(new PrintStream(new ByteArrayOutputStream()))
            System.setErr(new PrintStream(new ByteArrayOutputStream()))
        }
    }
    
}