/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 */
package example3;

import example3.BottleSupport;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Test;

/**
 * Prints the lyrics of the song "99 bottles of beer"
 * See http://99-bottles-of-beer.net/
 * 
 * Uses template expressions and extension methods.
 */
@SuppressWarnings("all")
public class BottleSong {
  @Test
  public void singIt() {
    InputOutput.<CharSequence>println(this.singTheSong(99));
  }
  
  public CharSequence singTheSong(final int all) {
    StringConcatenation _builder = new StringConcatenation();
    {
      IntegerRange _upTo = new IntegerRange(all, 1);
      for(final Integer i : _upTo) {
        String _Bottles = BottleSupport.Bottles((i).intValue());
        _builder.append(_Bottles);
        _builder.append(" of beer on the wall, ");
        String _bottles = BottleSupport.bottles((i).intValue());
        _builder.append(_bottles);
        _builder.append(" of beer.");
        _builder.newLineIfNotEmpty();
        _builder.append("Take one down and pass it around, ");
        String _bottles_1 = BottleSupport.bottles(((i).intValue() - 1));
        _builder.append(_bottles_1);
        _builder.append(" of beer on the wall.");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.append("No more bottles of beer on the wall, no more bottles of beer.");
    _builder.newLine();
    _builder.append("Go to the store and buy some more, ");
    String _bottles_2 = BottleSupport.bottles(all);
    _builder.append(_bottles_2);
    _builder.append(" of beer on the wall.");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
