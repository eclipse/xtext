package org.eclipse.xpect.tests.text;

import org.eclipse.xpect.text.Canvas;
import org.eclipse.xpect.text.ICanvas;
import org.eclipse.xpect.text.IRenderContext;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class CanvasTest {
  private ICanvas newCanvas() {
    return Canvas.create('-', "$\n");
  }
  
  @Test
  public void testPaintAt00() {
    final ICanvas canvas = this.newCanvas();
    canvas.print("Foo");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Foo");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testPaintAt02() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _at = canvas.at(0, 2);
    _at.print("Foo");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("--Foo");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testPaintAt20() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _at = canvas.at(2, 0);
    _at.print("Foo");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("Foo");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testPaintAt22() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _at = canvas.at(2, 2);
    _at.print("Foo");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("--Foo");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testOverPaintAt22() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _at = canvas.at(2, 2);
    _at.print("Foo");
    IRenderContext _at_1 = canvas.at(1, 3);
    _at_1.print("Bar\nBaz");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$");
    _builder.newLine();
    _builder.append("---Bar$");
    _builder.newLine();
    _builder.append("--FBaz");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testSubcanvasAt22() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _at = canvas.at(2, 2);
    ICanvas _newSubCanvas = _at.newSubCanvas();
    _newSubCanvas.print("Foo");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("--Foo");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testSubcanvasAt2235() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _at = canvas.at(2, 2);
    ICanvas _newSubCanvas = _at.newSubCanvas();
    IRenderContext _at_1 = _newSubCanvas.at(3, 5);
    _at_1.print("Foo");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("$");
    _builder.newLine();
    _builder.append("-------Foo");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testBounds() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _withBounds = canvas.withBounds(2, 3);
    _withBounds.print("abcde\nfghij\nklmno\npqrstuv");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abc$");
    _builder.newLine();
    _builder.append("fgh");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testBoundsAt() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _at = canvas.at(1, 2);
    IRenderContext _withBounds = _at.withBounds(2, 3);
    _withBounds.print("abcde\nfghij\nklmno\npqrstuv");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$");
    _builder.newLine();
    _builder.append("--abc$");
    _builder.newLine();
    _builder.append("--fgh");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testBoundsSubcanvasAt() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _at = canvas.at(1, 2);
    IRenderContext _withBounds = _at.withBounds(2, 3);
    ICanvas _newSubCanvas = _withBounds.newSubCanvas();
    _newSubCanvas.print("abcde\nfghij\nklmno\npqrstuv");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$");
    _builder.newLine();
    _builder.append("--abc$");
    _builder.newLine();
    _builder.append("--fgh");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  @Test
  public void testFill() {
    final ICanvas canvas = this.newCanvas();
    IRenderContext _at = canvas.at(1, 2);
    IRenderContext _withBounds = _at.withBounds(5, 8);
    _withBounds.fill("a\nbcd");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$");
    _builder.newLine();
    _builder.append("--a--a--a-$");
    _builder.newLine();
    _builder.append("--bcdbcdbc$");
    _builder.newLine();
    _builder.append("--a--a--a-$");
    _builder.newLine();
    _builder.append("--bcdbcdbc$");
    _builder.newLine();
    _builder.append("--a--a--a-");
    _builder.newLine();
    this.operator_tripleEquals(canvas, _builder);
  }
  
  public void operator_tripleEquals(final Object o1, final Object o2) {
    String _string = o2.toString();
    String _trim = _string.trim();
    String _string_1 = o1.toString();
    String _trim_1 = _string_1.trim();
    Assert.assertEquals(_trim, _trim_1);
  }
}
