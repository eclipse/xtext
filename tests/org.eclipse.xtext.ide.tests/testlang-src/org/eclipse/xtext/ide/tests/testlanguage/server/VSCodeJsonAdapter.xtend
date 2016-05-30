/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.server

import com.google.inject.Inject
import io.typefox.lsapi.NotificationMessage
import io.typefox.lsapi.RequestMessage
import io.typefox.lsapi.ResponseMessage
import io.typefox.lsapi.services.LanguageServer
import io.typefox.lsapi.services.json.LanguageServerToJsonAdapter
import io.typefox.lsapi.services.json.MessageMethods
import java.io.PrintWriter
import org.eclipse.xtend.lib.annotations.Accessors

class VSCodeJsonAdapter extends LanguageServerToJsonAdapter {
	
	@Accessors(PUBLIC_SETTER)
	PrintWriter errorLog
	
	@Accessors(PUBLIC_SETTER)
	PrintWriter messageLog
	
	@Accessors(PUBLIC_GETTER)
	boolean exitRequested
	
	@Inject
	new(LanguageServer server) {
		super(server)
		protocol.addErrorListener[ message, throwable |
			if (errorLog !== null) {
				if (throwable !== null)
					throwable.printStackTrace(errorLog)
				else if (message !== null)
					errorLog.println(message)
				errorLog.flush()
			}
		]
		protocol.addIncomingMessageListener[ message, json |
			if (message instanceof RequestMessage) {
				switch message.method {
					case MessageMethods.EXIT:
						exitRequested = true
				}
			}
			if (messageLog !== null) {
				switch message {
					RequestMessage:
						messageLog.println('Client Request:\n\t' + json)
					NotificationMessage:
						messageLog.println('Client Notification:\n\t' + json)
				}
				messageLog.flush()
			}
		]
		protocol.addOutgoingMessageListener[ message, json |
			if (messageLog !== null) {
				switch message {
					ResponseMessage:
						messageLog.println('Server Response:\n\t' + json)
					NotificationMessage:
						messageLog.println('Server Notification:\n\t' + json)
				}
				messageLog.flush()
			}
		]
	}
	
}
