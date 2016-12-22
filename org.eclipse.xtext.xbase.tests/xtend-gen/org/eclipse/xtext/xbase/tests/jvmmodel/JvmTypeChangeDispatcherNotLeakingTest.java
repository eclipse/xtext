/**
 * Copyright (c) 2016 TypeFox (https://typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
      ResourceSet _resourceSet = resource.getResourceSet();
      final JvmTypeChangeDispatcher dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(_resourceSet);
      List<Runnable> listeners = this._reflectExtensions.<List<Runnable>>get(dispatcher, "listeners");
      int _size = listeners.size();
      Assert.assertEquals(2, _size);
      resource.reparse(contents);
      EcoreUtil2.resolveAll(resource);
      List<Runnable> _get = this._reflectExtensions.<List<Runnable>>get(dispatcher, "listeners");
      listeners = _get;
      int _size_1 = listeners.size();
      Assert.assertEquals(2, _size_1);
      EList<EObject> _contents = resource.getContents();
      final EObject jvmType = _contents.get(1);
      this.unloader.unloadRoot(jvmType);
      EList<EObject> _contents_1 = resource.getContents();
      _contents_1.remove(jvmType);
      List<Runnable> _get_1 = this._reflectExtensions.<List<Runnable>>get(dispatcher, "listeners");
      listeners = _get_1;
      int _size_2 = listeners.size();
      Assert.assertEquals(0, _size_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
