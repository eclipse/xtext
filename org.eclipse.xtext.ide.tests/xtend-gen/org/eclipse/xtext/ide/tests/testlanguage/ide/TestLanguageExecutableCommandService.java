/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class TestLanguageExecutableCommandService implements IExecutableCommandService {
  @Override
  public List<String> initialize() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("testlang.a", "testlang.b", "testlang.c"));
  }
  
  @Override
  public Object execute(final ExecuteCommandParams params, final ILanguageServerAccess access, final CancelIndicator cancelIndicator) {
    String _command = params.getCommand();
    boolean _equals = Objects.equal(_command, "testlang.a");
    if (_equals) {
      return "a";
    } else {
      String _command_1 = params.getCommand();
      boolean _equals_1 = Objects.equal(_command_1, "testlang.b");
      if (_equals_1) {
        return "b";
      } else {
        String _command_2 = params.getCommand();
        boolean _equals_2 = Objects.equal(_command_2, "testlang.c");
        if (_equals_2) {
          return "c";
        }
      }
    }
    return null;
  }
}
