/**
 * Copyright (c) 2016 TypeFox (https://typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.jvmmodel.JvmElementsProxifyingUnloader;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmTypeChangeDispatcherNotLeakingTest extends AbstractJvmModelTest {
  @Inject
  @Extension
  private ReflectExtensions _reflectExtensions;
  
  @Inject
  private JvmElementsProxifyingUnloader unloader;
  
  @Test
  public void testNoLeaking() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{val x = \"foo\"");
      _builder.newLine();
      _builder.append("print(x)}");
      _builder.newLine();
      String contents = _builder.toString();
      Resource _newResource = this.newResource(contents);
      final XtextResource resource = ((XtextResource) _newResource);
      EcoreUtil2.resolveAll(resource);
      final JvmTypeChangeDispatcher dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(resource.getResourceSet());
      List<Runnable> listeners = this._reflectExtensions.<List<Runnable>>get(dispatcher, "listeners");
      Assert.assertEquals(2, listeners.size());
      resource.reparse(contents);
      EcoreUtil2.resolveAll(resource);
      listeners = this._reflectExtensions.<List<Runnable>>get(dispatcher, "listeners");
      Assert.assertEquals(2, listeners.size());
      final EObject jvmType = resource.getContents().get(1);
      this.unloader.unloadRoot(jvmType);
      resource.getContents().remove(jvmType);
      listeners = this._reflectExtensions.<List<Runnable>>get(dispatcher, "listeners");
      Assert.assertEquals(0, listeners.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
