/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Author - Sven Efftinge
 */
package example3;

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
