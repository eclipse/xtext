/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.inject.Inject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.XbaseQualifiedNameConverter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseInjectorProvider.class)
@SuppressWarnings("all")
public class XbaseQualifiedNameConverterTest {
  @Inject
  private XbaseQualifiedNameConverter converter;
  
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public void test_toQualifiedName() {
    Pair<List<String>, String> _mappedTo = Pair.<List<String>, String>of(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("foo")), "foo");
    Pair<List<String>, String> _mappedTo_1 = Pair.<List<String>, String>of(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("foo", "bar")), "foo.bar");
    Pair<List<String>, String> _mappedTo_2 = Pair.<List<String>, String>of(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("..")), "..");
    Pair<List<String>, String> _mappedTo_3 = Pair.<List<String>, String>of(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("..<")), "..<");
    Pair<List<String>, String> _mappedTo_4 = Pair.<List<String>, String>of(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(">..")), ">..");
    final Map<List<String>, String> testdata = Collections.<List<String>, String>unmodifiableMap(CollectionLiterals.<List<String>, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4));
    final Consumer<Map.Entry<List<String>, String>> _function = (Map.Entry<List<String>, String> it) -> {
      Assert.assertEquals(QualifiedName.create(it.getKey()), this.converter.toQualifiedName(it.getValue()));
    };
    testdata.entrySet().forEach(_function);
  }
  
  @Test
  public void test_toQualifiedName_null() {
    this.thrown.expect(IllegalArgumentException.class);
    this.thrown.expectMessage("Qualified name cannot be null");
    this.converter.toQualifiedName(null);
  }
  
  @Test
  public void test_toQualifiedName_empty() {
    this.thrown.expect(IllegalArgumentException.class);
    this.thrown.expectMessage("Qualified name cannot be empty");
    this.converter.toQualifiedName("");
  }
}
