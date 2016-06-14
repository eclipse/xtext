/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import java.io.File;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.test.AbstractWebServerTest;
import org.eclipse.xtext.web.server.validation.ValidationResult;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ValidationTest extends AbstractWebServerTest {
  protected void assertValidationResult(final String resourceContent, final String expectedResult) {
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "validate");
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("fullText", resourceContent);
    final XtextServiceDispatcher.ServiceDescriptor validate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)));
    boolean _isHasSideEffects = validate.isHasSideEffects();
    Assert.assertFalse(_isHasSideEffects);
    Function0<? extends IServiceResult> _service = validate.getService();
    IServiceResult _apply = _service.apply();
    final ValidationResult result = ((ValidationResult) _apply);
    String _string = result.toString();
    Assert.assertEquals(expectedResult, _string);
  }
  
  @Test
  public void testSyntaxError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ValidationResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("issues = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Issue [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("description = \"missing EOF at \'stat\'\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("severity = \"error\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("line = 1");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("column = 1");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("offset = 0");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("length = 4");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("]");
    this.assertValidationResult("stat foo end", _builder.toString());
  }
  
  @Test
  public void testCrossRefError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ValidationResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("issues = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Issue [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("description = \"Couldn\'t resolve reference to Signal \'x\'.\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("severity = \"error\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("line = 1");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("column = 15");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("offset = 14");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("length = 1");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("]");
    this.assertValidationResult("state foo set x = true end", _builder.toString());
  }
  
  @Test
  public void testCustomValidationError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ValidationResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("issues = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Issue [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("description = \"Only output signals are allowed for write access.\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("severity = \"error\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("line = 1");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("column = 30");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("offset = 29");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("length = 1");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("]");
    this.assertValidationResult("input signal x state foo set x = true end", _builder.toString());
  }
  
  @Test
  public void testValidateFile() {
    final File file = this.createFile("stat foo end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "validate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    final XtextServiceDispatcher.ServiceDescriptor validate = this.getService(Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1)));
    boolean _isHasSideEffects = validate.isHasSideEffects();
    Assert.assertFalse(_isHasSideEffects);
    Function0<? extends IServiceResult> _service = validate.getService();
    IServiceResult _apply = _service.apply();
    final ValidationResult result = ((ValidationResult) _apply);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ValidationResult [");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("issues = ArrayList (");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Issue [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("description = \"missing EOF at \'stat\'\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("severity = \"error\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("line = 1");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("column = 1");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("offset = 0");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("length = 4");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("]");
    final String expectedResult = _builder.toString();
    String _string = result.toString();
    Assert.assertEquals(expectedResult, _string);
  }
  
  @Test
  public void testIncorrectStateId() {
    final File file = this.createFile("state foo end");
    Pair<String, String> _mappedTo = Pair.<String, String>of("serviceType", "validate");
    String _name = file.getName();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("resource", _name);
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("requiredStateId", "totalerquatsch");
    final XtextServiceDispatcher.ServiceDescriptor validate = this.getService(
      Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2)));
    boolean _isHasConflict = validate.isHasConflict();
    Assert.assertTrue(_isHasConflict);
    Function0<? extends IServiceResult> _service = validate.getService();
    final IServiceResult result = _service.apply();
    Matcher<IServiceResult> _instanceOf = IsInstanceOf.<IServiceResult>instanceOf(ServiceConflictResult.class);
    Assert.<IServiceResult>assertThat(result, _instanceOf);
    String _conflict = ((ServiceConflictResult) result).getConflict();
    Assert.assertEquals(_conflict, "invalidStateId");
  }
}
