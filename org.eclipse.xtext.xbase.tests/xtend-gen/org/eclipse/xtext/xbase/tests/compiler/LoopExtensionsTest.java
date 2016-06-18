package org.eclipse.xtext.xbase.tests.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.compiler.LoopExtensions;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class LoopExtensionsTest extends AbstractXbaseTestCase {
  @Inject
  private LoopExtensions loopExtensions;
  
  @Test
  public void testForEach_all() {
    final ArrayList<String> all = CollectionLiterals.<String>newArrayList("jan", "hein", "class", "pit");
    final Procedure1<LoopParams> _function = (LoopParams it) -> {
    };
    this.assertForEach(all, _function, "janheinclasspit");
    final Procedure1<LoopParams> _function_1 = (LoopParams it) -> {
      it.setPrefix("_");
    };
    this.assertForEach(all, _function_1, "_janheinclasspit");
    final Procedure1<LoopParams> _function_2 = (LoopParams it) -> {
      it.setPrefix("_");
      it.setSeparator(" ");
    };
    this.assertForEach(all, _function_2, "_jan hein class pit");
    final Procedure1<LoopParams> _function_3 = (LoopParams it) -> {
      it.setPrefix("_");
      it.setSuffix("*");
    };
    this.assertForEach(all, _function_3, "_janheinclasspit*");
    final Procedure1<LoopParams> _function_4 = (LoopParams it) -> {
      it.setPrefix("_");
      it.setSeparator(" ");
      it.setSuffix("*");
    };
    this.assertForEach(all, _function_4, "_jan hein class pit*");
    final Procedure1<LoopParams> _function_5 = (LoopParams it) -> {
      it.setSeparator(" ");
    };
    this.assertForEach(all, _function_5, "jan hein class pit");
    final Procedure1<LoopParams> _function_6 = (LoopParams it) -> {
      it.setSeparator(" ");
      it.setSuffix("*");
    };
    this.assertForEach(all, _function_6, "jan hein class pit*");
    final Procedure1<LoopParams> _function_7 = (LoopParams it) -> {
      it.setSuffix("*");
    };
    this.assertForEach(all, _function_7, "janheinclasspit*");
  }
  
  @Test
  public void testForEach_single() {
    final ArrayList<String> single = CollectionLiterals.<String>newArrayList("foo");
    final Procedure1<LoopParams> _function = (LoopParams it) -> {
    };
    this.assertForEach(single, _function, "foo");
    final Procedure1<LoopParams> _function_1 = (LoopParams it) -> {
      it.setPrefix("_");
    };
    this.assertForEach(single, _function_1, "_foo");
    final Procedure1<LoopParams> _function_2 = (LoopParams it) -> {
      it.setPrefix("_");
      it.setSeparator(" ");
    };
    this.assertForEach(single, _function_2, "_foo");
    final Procedure1<LoopParams> _function_3 = (LoopParams it) -> {
      it.setPrefix("_");
      it.setSuffix("*");
    };
    this.assertForEach(single, _function_3, "_foo*");
    final Procedure1<LoopParams> _function_4 = (LoopParams it) -> {
      it.setPrefix("_");
      it.setSeparator(" ");
      it.setSuffix("*");
    };
    this.assertForEach(single, _function_4, "_foo*");
    final Procedure1<LoopParams> _function_5 = (LoopParams it) -> {
      it.setSeparator(" ");
    };
    this.assertForEach(single, _function_5, "foo");
    final Procedure1<LoopParams> _function_6 = (LoopParams it) -> {
      it.setSeparator(" ");
      it.setSuffix("*");
    };
    this.assertForEach(single, _function_6, "foo*");
    final Procedure1<LoopParams> _function_7 = (LoopParams it) -> {
      it.setSuffix("*");
    };
    this.assertForEach(single, _function_7, "foo*");
  }
  
  @Test
  public void testForEach_empty() {
    final List<String> empty = Collections.<String>emptyList();
    final Procedure1<LoopParams> _function = (LoopParams it) -> {
    };
    this.assertForEach(empty, _function, "");
    final Procedure1<LoopParams> _function_1 = (LoopParams it) -> {
      it.setPrefix("_");
    };
    this.assertForEach(empty, _function_1, "");
    final Procedure1<LoopParams> _function_2 = (LoopParams it) -> {
      it.setPrefix("_");
      it.setSeparator(" ");
    };
    this.assertForEach(empty, _function_2, "");
    final Procedure1<LoopParams> _function_3 = (LoopParams it) -> {
      it.setPrefix("_");
      it.setSuffix("*");
    };
    this.assertForEach(empty, _function_3, "");
    final Procedure1<LoopParams> _function_4 = (LoopParams it) -> {
      it.setPrefix("_");
      it.setSeparator(" ");
      it.setSuffix("*");
    };
    this.assertForEach(empty, _function_4, "");
    final Procedure1<LoopParams> _function_5 = (LoopParams it) -> {
      it.setSeparator(" ");
    };
    this.assertForEach(empty, _function_5, "");
    final Procedure1<LoopParams> _function_6 = (LoopParams it) -> {
      it.setSeparator(" ");
      it.setSuffix("*");
    };
    this.assertForEach(empty, _function_6, "");
    final Procedure1<LoopParams> _function_7 = (LoopParams it) -> {
      it.setSuffix("*");
    };
    this.assertForEach(empty, _function_7, "");
  }
  
  public void testForEachWithSkip() {
    final ArrayList<String> all = CollectionLiterals.<String>newArrayList("jan", "hein", "class", "pit");
    final Function1<String, Boolean> _function = (String it) -> {
      return Boolean.valueOf(Objects.equal(it, "jan"));
    };
    this.assertForEachWithSkip(all, _function, "{hein, class, pit}");
    final Function1<String, Boolean> _function_1 = (String it) -> {
      return Boolean.valueOf(Objects.equal(it, "hein"));
    };
    this.assertForEachWithSkip(all, _function_1, "{jan, class, pit}");
    final Function1<String, Boolean> _function_2 = (String it) -> {
      return Boolean.valueOf(Objects.equal(it, "pit"));
    };
    this.assertForEachWithSkip(all, _function_2, "{jan, hein, class}");
    final Function1<String, Boolean> _function_3 = (String it) -> {
      return Boolean.valueOf(true);
    };
    this.assertForEachWithSkip(all, _function_3, "{}");
  }
  
  @Test
  public void testForEachWithShortcut() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("jan", "hein", "class", "pit");
    this.assertForEachWithShortcut(_newArrayList, "{ jan, hein, class, pit }");
    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("foo");
    this.assertForEachWithShortcut(_newArrayList_1, "foo");
    ArrayList<String> _newArrayList_2 = CollectionLiterals.<String>newArrayList();
    this.assertForEachWithShortcut(_newArrayList_2, "{}");
  }
  
  protected void assertForEach(final Iterable<String> elements, final Procedure1<? super LoopParams> params, final String expectedResult) {
    final FakeTreeAppendable app = new FakeTreeAppendable();
    final Procedure1<String> _function = (String it) -> {
      app.append(it);
    };
    this.loopExtensions.<String>forEach(app, elements, params, _function);
    String _string = app.toString();
    Assert.assertEquals(expectedResult, _string);
  }
  
  protected void assertForEachWithSkip(final Iterable<String> elements, final Function1<? super String, ? extends Boolean> append, final String expectedResult) {
    final FakeTreeAppendable app = new FakeTreeAppendable();
    final Procedure1<LoopParams> _function = (LoopParams it) -> {
      it.setPrefix("{");
      it.setSeparator(", ");
      it.setSuffix("}");
    };
    final Procedure1<String> _function_1 = (String it) -> {
      Boolean _apply = append.apply(it);
      boolean _not = (!(_apply).booleanValue());
      if (_not) {
        app.append(it);
      }
    };
    this.loopExtensions.<String>forEach(app, elements, _function, _function_1);
    String _string = app.toString();
    Assert.assertEquals(expectedResult, _string);
  }
  
  protected void assertForEachWithShortcut(final Iterable<String> elements, final String expectedResult) {
    final FakeTreeAppendable app = new FakeTreeAppendable();
    final Procedure1<String> _function = (String it) -> {
      app.append(it);
    };
    this.loopExtensions.<String>forEachWithShortcut(app, elements, _function);
    String _string = app.toString();
    Assert.assertEquals(expectedResult, _string);
  }
}
