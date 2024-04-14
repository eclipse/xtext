/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import java.util.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.IEObjectDescription;
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
    Assert.assertEquals(1, IterableExtensions.size(d.getExportedObjects()));
    final String textHash = IterableExtensions.<IEObjectDescription>head(d.getExportedObjects()).getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    Assert.assertNotNull(textHash);
    boolean _equals = Objects.equals("", textHash);
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
    Assert.assertTrue(IterableExtensions.isEmpty(d.getImportedNames()));
    Assert.assertTrue(IterableExtensions.isEmpty(d.getReferenceDescriptions()));
  }

  @Test
  public void testTextChange() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IResourceDescription d = this.getDirtyResourceDescription(_builder);
    final String textHash = IterableExtensions.<IEObjectDescription>head(d.getExportedObjects()).getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("// added comment");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IResourceDescription d1 = this.getDirtyResourceDescription(_builder_1);
    final String textHash1 = IterableExtensions.<IEObjectDescription>head(d1.getExportedObjects()).getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    boolean _equals = Objects.equals(textHash, textHash1);
    Assert.assertFalse(_equals);
    final IResourceDescription.Delta delta = this.dirtyManager.createDelta(d, d1);
    Assert.assertTrue(delta.haveEObjectDescriptionsChanged());
  }

  @Test
  public void testNoTextChange() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IResourceDescription d = this.getDirtyResourceDescription(_builder);
    final String textHash = IterableExtensions.<IEObjectDescription>head(d.getExportedObjects()).getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IResourceDescription d1 = this.getDirtyResourceDescription(_builder_1);
    final String textHash1 = IterableExtensions.<IEObjectDescription>head(d1.getExportedObjects()).getUserData(DirtyStateResourceDescription.Manager.TEXT_HASH);
    Assert.assertEquals(textHash, textHash1);
    final IResourceDescription.Delta delta = this.dirtyManager.createDelta(d, d1);
    Assert.assertFalse(delta.haveEObjectDescriptionsChanged());
  }

  @Test
  public void testAffected() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IResourceDescription foo = this.plainManager.getResourceDescription(this.parse("Foo", _builder));
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar implements Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IResourceDescription bar = this.plainManager.getResourceDescription(this.parse("Bar", _builder_1));
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("interface Foo {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("// added comment");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    final IResourceDescription dirtyFoo = this.dirtyManager.getResourceDescription(this.parse("Foo", _builder_2));
    final IResourceDescription.Delta delta = this.plainManager.createDelta(foo, dirtyFoo);
    Assert.assertTrue(this.plainManager.isAffected(delta, bar));
  }

  @Test
  public void testAffected1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IResourceDescription foo = this.plainManager.getResourceDescription(this.parse("Foo", _builder));
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar implements Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IResourceDescription bar = this.plainManager.getResourceDescription(this.parse("Bar", _builder_1));
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("interface Foo {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("def void foo()");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    final IResourceDescription dirtyFoo = this.dirtyManager.getResourceDescription(this.parse("Foo", _builder_2));
    final IResourceDescription.Delta delta = this.plainManager.createDelta(foo, dirtyFoo);
    Assert.assertTrue(this.plainManager.isAffected(delta, bar));
  }

  @Test
  public void testNotAffected() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IResourceDescription foo = this.plainManager.getResourceDescription(this.parse("Foo", _builder));
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IResourceDescription bar = this.plainManager.getResourceDescription(this.parse("Bar", _builder_1));
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("interface Foo {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("def void foo()");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    final IResourceDescription dirtyFoo = this.dirtyManager.getResourceDescription(this.parse("Foo", _builder_2));
    final IResourceDescription.Delta delta = this.plainManager.createDelta(foo, dirtyFoo);
    Assert.assertFalse(this.plainManager.isAffected(delta, bar));
  }

  public IResourceDescription getDirtyResourceDescription(final CharSequence model) {
    return this.dirtyManager.getResourceDescription(this.parse("Foo", model));
  }

  public XtextResource parse(final String fileName, final CharSequence model) {
    try {
      XtextResource _xblockexpression = null;
      {
        final XtextResourceSet rs = this.resourceSetProvider.get();
        Resource _createResource = rs.createResource(URI.createURI((fileName + ".xtend")));
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
