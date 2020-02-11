/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.DefaultFragmentProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.SyntacticSequencerTestLanguageInjectorProvider;
import org.eclipse.xtext.serializer.syntacticsequencertest.Model;
import org.eclipse.xtext.serializer.syntacticsequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestFactory;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(SyntacticSequencerTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class TokenSerializerTest {
  @Inject
  @Extension
  private ISerializer _iSerializer;
  
  @Inject
  private FileExtensionProvider fileExtensionProvider;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  private final SyntacticsequencertestFactory factory = SyntacticsequencertestFactory.eINSTANCE;
  
  private void assertSerializesTo(final Model model, final CharSequence expectation) {
    Assert.assertEquals(expectation.toString().trim(), this._iSerializer.serialize(model).trim());
  }
  
  private URI getFileURI(final String name) {
    String _primaryFileExtension = this.fileExtensionProvider.getPrimaryFileExtension();
    String _plus = ((name + ".") + _primaryFileExtension);
    return URI.createFileURI(_plus);
  }
  
  @Test
  public void testConstructedCrossReferenceWithProxy() {
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    Resource _createResource = resourceSet.createResource(this.getFileURI("dummy"));
    final XtextResource resource = ((XtextResource) _createResource);
    Model _createModel = this.factory.createModel();
    final Procedure1<Model> _function = (Model it) -> {
      SingleCrossReference _createSingleCrossReference = this.factory.createSingleCrossReference();
      final Procedure1<SingleCrossReference> _function_1 = (SingleCrossReference it_1) -> {
        it_1.setName("myref");
      };
      SingleCrossReference _doubleArrow = ObjectExtensions.<SingleCrossReference>operator_doubleArrow(_createSingleCrossReference, _function_1);
      it.setX5(_doubleArrow);
    };
    final Model model = ObjectExtensions.<Model>operator_doubleArrow(_createModel, _function);
    EList<EObject> _contents = resource.getContents();
    _contents.add(model);
    SingleCrossReference _x5 = model.getX5();
    SingleCrossReference _createSingleCrossReference = this.factory.createSingleCrossReference();
    final Procedure1<SingleCrossReference> _function_1 = (SingleCrossReference it) -> {
      ((InternalEObject) it).eSetProxyURI(resource.getURI().appendFragment("foo"));
    };
    SingleCrossReference _doubleArrow = ObjectExtensions.<SingleCrossReference>operator_doubleArrow(_createSingleCrossReference, _function_1);
    _x5.setRef3(_doubleArrow);
    resource.setFragmentProvider(new DefaultFragmentProvider() {
      @Override
      public EObject getEObject(final Resource resource, final String fragment, final IFragmentProvider.Fallback fallback) {
        EObject _xifexpression = null;
        boolean _equals = Objects.equal(fragment, "foo");
        if (_equals) {
          _xifexpression = model.getX5();
        } else {
          _xifexpression = super.getEObject(resource, fragment, fallback);
        }
        return _xifexpression;
      }
    });
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#5 myref kw3 myref");
    _builder.newLine();
    this.assertSerializesTo(model, _builder);
  }
}
