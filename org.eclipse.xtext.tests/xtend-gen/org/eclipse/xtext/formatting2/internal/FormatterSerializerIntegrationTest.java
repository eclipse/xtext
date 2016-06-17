/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.internal;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.internal.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.internal.FormatterTestLanguageRuntimeModule;
import org.eclipse.xtext.formatting2.internal.FormatterTestLanguageStandaloneSetup;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguageFactory;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterSerializerIntegrationTest.InjectorProvider.class)
@SuppressWarnings("all")
public class FormatterSerializerIntegrationTest {
  public static class InjectorProvider extends FormatterTestLanguageInjectorProvider {
    @Override
    protected Injector internalCreateInjector() {
      FormatterSerializerIntegrationTest.Setup _setup = new FormatterSerializerIntegrationTest.Setup();
      return _setup.createInjectorAndDoEMFRegistration();
    }
  }
  
  public static class Setup extends FormatterTestLanguageStandaloneSetup {
    @Override
    public Injector createInjector() {
      FormatterSerializerIntegrationTest.Module _module = new FormatterSerializerIntegrationTest.Module();
      return Guice.createInjector(_module);
    }
  }
  
  public static class Module extends FormatterTestLanguageRuntimeModule {
    public Class<? extends IFormatter2> bindIFormatter2() {
      return FormatterSerializerIntegrationTest.Formatter.class;
    }
  }
  
  public static class Formatter extends AbstractFormatter2 {
    protected void _format(final IDList model, @Extension final IFormattableDocument document) {
      ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(model);
      ISemanticRegion _keyword = _regionFor.keyword("idlist");
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.setSpace("  ");
      };
      document.append(_keyword, _function);
    }
    
    public void format(final Object model, final IFormattableDocument document) {
      if (model instanceof XtextResource) {
        _format((XtextResource)model, document);
        return;
      } else if (model instanceof IDList) {
        _format((IDList)model, document);
        return;
      } else if (model instanceof EObject) {
        _format((EObject)model, document);
        return;
      } else if (model == null) {
        _format((Void)null, document);
        return;
      } else if (model != null) {
        _format(model, document);
        return;
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(model, document).toString());
      }
    }
  }
  
  @Inject
  private IResourceFactory factory;
  
  @Test
  public void testFormatterIntegrationWithSerializer() {
    try {
      URI _createURI = URI.createURI("dummy.ext");
      final Resource resource = this.factory.createResource(_createURI);
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      EList<Resource> _resources = _resourceSetImpl.getResources();
      _resources.add(resource);
      final IDList model = FormattertestlanguageFactory.eINSTANCE.createIDList();
      EList<String> _ids = model.getIds();
      _ids.add("foo");
      EList<EObject> _contents = resource.getContents();
      _contents.add(model);
      final ByteArrayOutputStream out = new ByteArrayOutputStream();
      BufferedOutputStream _bufferedOutputStream = new BufferedOutputStream(out);
      Map<Object, Object> _emptyMap = Collections.<Object, Object>emptyMap();
      resource.save(_bufferedOutputStream, _emptyMap);
      String _string = out.toString();
      Assert.assertEquals("idlist  foo", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
