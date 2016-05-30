/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.server;

import com.google.inject.Inject;
import io.typefox.lsapi.Message;
import io.typefox.lsapi.NotificationMessage;
import io.typefox.lsapi.RequestMessage;
import io.typefox.lsapi.ResponseMessage;
import io.typefox.lsapi.services.LanguageServer;
import io.typefox.lsapi.services.json.LanguageServerProtocol;
import io.typefox.lsapi.services.json.LanguageServerToJsonAdapter;
import io.typefox.lsapi.services.json.MessageMethods;
import java.io.PrintWriter;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class VSCodeJsonAdapter extends LanguageServerToJsonAdapter {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private PrintWriter errorLog;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private PrintWriter messageLog;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private boolean exitRequested;
  
  @Inject
  public VSCodeJsonAdapter(final LanguageServer server) {
    super(server);
    LanguageServerProtocol _protocol = this.getProtocol();
    final Procedure2<String, Throwable> _function = (String message, Throwable throwable) -> {
      if ((this.errorLog != null)) {
        if ((throwable != null)) {
          throwable.printStackTrace(this.errorLog);
        } else {
          if ((message != null)) {
            this.errorLog.println(message);
          }
        }
        this.errorLog.flush();
      }
    };
    _protocol.addErrorListener(_function);
    LanguageServerProtocol _protocol_1 = this.getProtocol();
    final Procedure2<Message, String> _function_1 = (Message message, String json) -> {
      if ((message instanceof RequestMessage)) {
        String _method = ((RequestMessage)message).getMethod();
        switch (_method) {
          case MessageMethods.EXIT:
            this.exitRequested = true;
            break;
        }
      }
      if ((this.messageLog != null)) {
        boolean _matched = false;
        if (message instanceof RequestMessage) {
          _matched=true;
          this.messageLog.println(("Client Request:\n\t" + json));
        }
        if (!_matched) {
          if (message instanceof NotificationMessage) {
            _matched=true;
            this.messageLog.println(("Client Notification:\n\t" + json));
          }
        }
        this.messageLog.flush();
      }
    };
    _protocol_1.addIncomingMessageListener(_function_1);
    LanguageServerProtocol _protocol_2 = this.getProtocol();
    final Procedure2<Message, String> _function_2 = (Message message, String json) -> {
      if ((this.messageLog != null)) {
        boolean _matched = false;
        if (message instanceof ResponseMessage) {
          _matched=true;
          this.messageLog.println(("Server Response:\n\t" + json));
        }
        if (!_matched) {
          if (message instanceof NotificationMessage) {
            _matched=true;
            this.messageLog.println(("Server Notification:\n\t" + json));
          }
        }
        this.messageLog.flush();
      }
    };
    _protocol_2.addOutgoingMessageListener(_function_2);
  }
  
  public void setErrorLog(final PrintWriter errorLog) {
    this.errorLog = errorLog;
  }
  
  public void setMessageLog(final PrintWriter messageLog) {
    this.messageLog = messageLog;
  }
  
  @Pure
  public boolean isExitRequested() {
    return this.exitRequested;
  }
}
