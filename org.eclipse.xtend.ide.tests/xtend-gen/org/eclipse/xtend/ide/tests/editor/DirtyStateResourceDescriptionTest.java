/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.DirtyStateResourceDescription;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class DirtyStateResourceDescriptionTest extends AbstractXtendUITestCase {
  @Inject
  private IResourceDescription.Manager plainManager;
  
  @Inject
  private DirtyStateResourceDescription.Manager dirtyManager;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Test
  public void testTextHash() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IResourceDescription d = this.getDirtyResourceDescription(_builder);
    Iterable<IEObjectDescription> _exportedObjects = d.getExportedObjects();
    int _size = IterableExtensions.size(_exportedObjects);
    Assert.assertEquals(1, _size);
    Iterable<IEObjectDescription> _exportedObjects_1 = d.getExportedObjects();
    IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
    final String textHash = _head.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    Assert.assertNotNull(textHash);
    boolean _equals = Objects.equal("", textHash);
    Assert.assertFalse(_equals);
  }
  
  @Test
  public void testEmptyContents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IResourceDescription d = this.getDirtyResourceDescription(_builder);
    Iterable<QualifiedName> _importedNames = d.getImportedNames();
    boolean _isEmpty = IterableExtensions.isEmpty(_importedNames);
    Assert.assertTrue(_isEmpty);
    Iterable<IReferenceDescription> _referenceDescriptions = d.getReferenceDescriptions();
    boolean _isEmpty_1 = IterableExtensions.isEmpty(_referenceDescriptions);
    Assert.assertTrue(_isEmpty_1);
  }
  
  @Test
  public void testTextChange() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IResourceDescription d = this.getDirtyResourceDescription(_builder);
    Iterable<IEObjectDescription> _exportedObjects = d.getExportedObjects();
    IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
    final String textHash = _head.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("// added comment");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IResourceDescription d1 = this.getDirtyResourceDescription(_builder_1);
    Iterable<IEObjectDescription> _exportedObjects_1 = d1.getExportedObjects();
    IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
    final String textHash1 = _head_1.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    boolean _equals = Objects.equal(textHash, textHash1);
    Assert.assertFalse(_equals);
    final IResourceDescription.Delta delta = this.dirtyManager.createDelta(d, d1);
    boolean _haveEObjectDescriptionsChanged = delta.haveEObjectDescriptionsChanged();
    Assert.assertTrue(_haveEObjectDescriptionsChanged);
  }
  
  @Test
  public void testNoTextChange() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IResourceDescription d = this.getDirtyResourceDescription(_builder);
    Iterable<IEObjectDescription> _exportedObjects = d.getExportedObjects();
    IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
    final String textHash = _head.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IResourceDescription d1 = this.getDirtyResourceDescription(_builder_1);
    Iterable<IEObjectDescription> _exportedObjects_1 = d1.getExportedObjects();
    IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
    final String textHash1 = _head_1.getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    Assert.assertEquals(textHash, textHash1);
    final IResourceDescription.Delta delta = this.dirtyManager.createDelta(d, d1);
    boolean _haveEObjectDescriptionsChanged = delta.haveEObjectDescriptionsChanged();
    Assert.assertFalse(_haveEObjectDescriptionsChanged);
  }
  
  @Test
  public void testAffected() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtextResource _parse = this.parse("Foo", _builder);
    final IResourceDescription foo = this.plainManager.getResourceDescription(_parse);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar implements Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    XtextResource _parse_1 = this.parse("Bar", _builder_1);
    final IResourceDescription bar = this.plainManager.getResourceDescription(_parse_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("interface Foo {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("// added comment");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    XtextResource _parse_2 = this.parse("Foo", _builder_2);
    final IResourceDescription dirtyFoo = this.dirtyManager.getResourceDescription(_parse_2);
    final IResourceDescription.Delta delta = this.plainManager.createDelta(foo, dirtyFoo);
    boolean _isAffected = this.plainManager.isAffected(delta, bar);
    Assert.assertTrue(_isAffected);
  }
  
  @Test
  public void testAffected1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtextResource _parse = this.parse("Foo", _builder);
    final IResourceDescription foo = this.plainManager.getResourceDescription(_parse);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar implements Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    XtextResource _parse_1 = this.parse("Bar", _builder_1);
    final IResourceDescription bar = this.plainManager.getResourceDescription(_parse_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("interface Foo {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("def void foo()");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    XtextResource _parse_2 = this.parse("Foo", _builder_2);
    final IResourceDescription dirtyFoo = this.dirtyManager.getResourceDescription(_parse_2);
    final IResourceDescription.Delta delta = this.plainManager.createDelta(foo, dirtyFoo);
    boolean _isAffected = this.plainManager.isAffected(delta, bar);
    Assert.assertTrue(_isAffected);
  }
  
  @Test
  public void testNotAffected() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    XtextResource _parse = this.parse("Foo", _builder);
    final IResourceDescription foo = this.plainManager.getResourceDescription(_parse);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    XtextResource _parse_1 = this.parse("Bar", _builder_1);
    final IResourceDescription bar = this.plainManager.getResourceDescription(_parse_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("interface Foo {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("def void foo()");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    XtextResource _parse_2 = this.parse("Foo", _builder_2);
    final IResourceDescription dirtyFoo = this.dirtyManager.getResourceDescription(_parse_2);
    final IResourceDescription.Delta delta = this.plainManager.createDelta(foo, dirtyFoo);
    boolean _isAffected = this.plainManager.isAffected(delta, bar);
    Assert.assertFalse(_isAffected);
  }
  
  public IResourceDescription getDirtyResourceDescription(final CharSequence model) {
    XtextResource _parse = this.parse("Foo", model);
    return this.dirtyManager.getResourceDescription(_parse);
  }
  
  public XtextResource parse(final String fileName, final CharSequence model) {
    try {
      XtextResource _xblockexpression = null;
      {
        final XtextResourceSet rs = this.resourceSetProvider.get();
        URI _createURI = URI.createURI((fileName + ".xtend"));
        Resource _createResource = rs.createResource(_createURI);
        final XtextResource r = ((XtextResource) _createResource);
        String _string = model.toString();
        StringInputStream _stringInputStream = new StringInputStream(_string);
        r.load(_stringInputStream, Collections.<Object, Object>unmodifiableMap(CollectionLiterals.<Object, Object>newHashMap()));
        _xblockexpression = r;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
