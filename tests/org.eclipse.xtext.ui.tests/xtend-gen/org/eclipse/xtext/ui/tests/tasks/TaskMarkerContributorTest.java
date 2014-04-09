/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.tasks;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.tasks.TaskMarkerContributor;
import org.eclipse.xtext.ui.tasks.TaskMarkerTypeProvider;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class TaskMarkerContributorTest extends AbstractXtextTests {
  @Inject
  private TaskMarkerContributor markerContributor;
  
  @Before
  public void setup() {
    Activator _instance = Activator.getInstance();
    Injector _injector = _instance.getInjector(
      Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_EDITOR_CONTENTASSIST_DOMAINMODELTESTLANGUAGE);
    this.setInjector(_injector);
    this.injectMembers(this);
  }
  
  @Test
  public void testMarkerCreation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/*");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* TODO foo");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* FIXME bar");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      String _unix = LineDelimiters.toUnix(_builder.toString());
      final IFile file = IResourcesSetupUtil.createFile("foo/foo.domainModelTest", _unix);
      final XtextResource resource = this.getResource(file);
      this.markerContributor.updateMarkers(file, resource, null);
      final IMarker[] markers = file.findMarkers(TaskMarkerTypeProvider.XTEXT_TASK_TYPE, true, IResource.DEPTH_ZERO);
      int _size = ((List<IMarker>)Conversions.doWrapArray(markers)).size();
      Assert.assertEquals(2, _size);
      IMarker _head = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(markers)));
      Object _attribute = _head.getAttribute(IMarker.MESSAGE);
      Assert.assertEquals("TODO foo", _attribute);
      IMarker _head_1 = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(markers)));
      Object _attribute_1 = _head_1.getAttribute(IMarker.LINE_NUMBER);
      Assert.assertEquals(Integer.valueOf(2), _attribute_1);
      IMarker _head_2 = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(markers)));
      Object _attribute_2 = _head_2.getAttribute(IMarker.CHAR_START);
      Assert.assertEquals(Integer.valueOf(6), _attribute_2);
      IMarker _head_3 = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(markers)));
      Object _attribute_3 = _head_3.getAttribute(IMarker.CHAR_END);
      Assert.assertEquals(Integer.valueOf(14), _attribute_3);
      IMarker _head_4 = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(markers)));
      Object _attribute_4 = _head_4.getAttribute(IMarker.PRIORITY);
      Assert.assertEquals(Integer.valueOf(IMarker.PRIORITY_NORMAL), _attribute_4);
      IMarker _head_5 = IterableExtensions.<IMarker>head(((Iterable<IMarker>)Conversions.doWrapArray(markers)));
      Object _attribute_5 = _head_5.getAttribute(IMarker.LOCATION);
      Assert.assertEquals("line 2", _attribute_5);
      IMarker _get = markers[1];
      Object _attribute_6 = _get.getAttribute(IMarker.MESSAGE);
      Assert.assertEquals("FIXME bar", _attribute_6);
      IMarker _get_1 = markers[1];
      Object _attribute_7 = _get_1.getAttribute(IMarker.LINE_NUMBER);
      Assert.assertEquals(Integer.valueOf(3), _attribute_7);
      IMarker _get_2 = markers[1];
      Object _attribute_8 = _get_2.getAttribute(IMarker.CHAR_START);
      Assert.assertEquals(Integer.valueOf(18), _attribute_8);
      IMarker _get_3 = markers[1];
      Object _attribute_9 = _get_3.getAttribute(IMarker.CHAR_END);
      Assert.assertEquals(Integer.valueOf(27), _attribute_9);
      IMarker _get_4 = markers[1];
      Object _attribute_10 = _get_4.getAttribute(IMarker.PRIORITY);
      Assert.assertEquals(Integer.valueOf(IMarker.PRIORITY_HIGH), _attribute_10);
      IMarker _get_5 = markers[1];
      Object _attribute_11 = _get_5.getAttribute(IMarker.LOCATION);
      Assert.assertEquals("line 3", _attribute_11);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XtextResource getResource(final IFile file) {
    try {
      String _fileToString = IResourcesSetupUtil.fileToString(file);
      IPath _fullPath = file.getFullPath();
      String _string = _fullPath.toString();
      URI _createFileURI = URI.createFileURI(_string);
      String _string_1 = _createFileURI.toString();
      return this.getResource(_fileToString, _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void cleanUp() {
    try {
      IResourcesSetupUtil.cleanWorkspace();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
