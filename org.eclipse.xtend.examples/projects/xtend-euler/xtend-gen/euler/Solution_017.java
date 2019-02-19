/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sebastian Zarnekow
 * See https://github.com/szarnekow/xtend-euler
 */
package euler;

import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 * 
 * @see http://projecteuler.net/problem=17
 */
@SuppressWarnings("all")
public class Solution_017 {
  public static void main(final String[] args) {
    InputOutput.<Integer>println(new Solution_017(1000).solve());
  }
  
  private int upper;
  
  public Solution_017(final int upper) {
    this.upper = upper;
  }
  
  public Integer solve() {
    final Function1<Integer, Integer> _function = (Integer it) -> {
      return Integer.valueOf(this.word((it).intValue()).replace(" ", "").length());
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer i1, Integer i2) -> {
      return Integer.valueOf(((i1).intValue() + (i2).intValue()));
    };
    return IterableExtensions.<Integer>reduce(IterableExtensions.<Integer, Integer>map(new IntegerRange(1, this.upper), _function), _function_1);
  }
  
  public String word(final int number) {
    String _xifexpression = null;
    if ((number >= 1000)) {
      String _word = this.word((number / 1000));
      String _plus = (_word + " thousand ");
      String _word_1 = this.word((number % 1000));
      _xifexpression = (_plus + _word_1);
    } else {
      String _xifexpression_1 = null;
      if ((number >= 100)) {
        String _xblockexpression = null;
        {
          int remainder = (number % 100);
          String _word_2 = this.word((number / 100));
          String _plus_1 = (_word_2 + " hundred");
          String _xifexpression_2 = null;
          if ((remainder != 0)) {
            String _word_3 = this.word(remainder);
            _xifexpression_2 = (" and " + _word_3);
          } else {
            _xifexpression_2 = "";
          }
          _xblockexpression = (_plus_1 + _xifexpression_2);
        }
        _xifexpression_1 = _xblockexpression;
      } else {
        _xifexpression_1 = this.wordToHundred(number);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String wordToHundred(final int number) {
    String _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(number, 0)) {
      _matched=true;
      _switchResult = "";
    }
    if (!_matched) {
      if (Objects.equal(number, 1)) {
        _matched=true;
        _switchResult = "one";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 2)) {
        _matched=true;
        _switchResult = "two";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 3)) {
        _matched=true;
        _switchResult = "three";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 4)) {
        _matched=true;
        _switchResult = "four";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 5)) {
        _matched=true;
        _switchResult = "five";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 6)) {
        _matched=true;
        _switchResult = "six";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 7)) {
        _matched=true;
        _switchResult = "seven";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 8)) {
        _matched=true;
        _switchResult = "eight";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 9)) {
        _matched=true;
        _switchResult = "nine";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 10)) {
        _matched=true;
        _switchResult = "ten";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 11)) {
        _matched=true;
        _switchResult = "eleven";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 12)) {
        _matched=true;
        _switchResult = "twelve";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 13)) {
        _matched=true;
        _switchResult = "thirteen";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 14)) {
        _matched=true;
        _switchResult = "fourteen";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 15)) {
        _matched=true;
        _switchResult = "fifteen";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 16)) {
        _matched=true;
        _switchResult = "sixteen";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 17)) {
        _matched=true;
        _switchResult = "seventeen";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 18)) {
        _matched=true;
        _switchResult = "eighteen";
      }
    }
    if (!_matched) {
      if (Objects.equal(number, 19)) {
        _matched=true;
        _switchResult = "nineteen";
      }
    }
    if (!_matched) {
      if ((number < 30)) {
        _matched=true;
        String _wordToHundred = this.wordToHundred((number % 10));
        _switchResult = ("twenty " + _wordToHundred);
      }
    }
    if (!_matched) {
      if ((number < 40)) {
        _matched=true;
        String _wordToHundred_1 = this.wordToHundred((number % 10));
        _switchResult = ("thirty " + _wordToHundred_1);
      }
    }
    if (!_matched) {
      if ((number < 50)) {
        _matched=true;
        String _wordToHundred_2 = this.wordToHundred((number % 10));
        _switchResult = ("forty " + _wordToHundred_2);
      }
    }
    if (!_matched) {
      if ((number < 60)) {
        _matched=true;
        String _wordToHundred_3 = this.wordToHundred((number % 10));
        _switchResult = ("fifty " + _wordToHundred_3);
      }
    }
    if (!_matched) {
      if ((number < 70)) {
        _matched=true;
        String _wordToHundred_4 = this.wordToHundred((number % 10));
        _switchResult = ("sixty " + _wordToHundred_4);
      }
    }
    if (!_matched) {
      if ((number < 80)) {
        _matched=true;
        String _wordToHundred_5 = this.wordToHundred((number % 10));
        _switchResult = ("seventy " + _wordToHundred_5);
      }
    }
    if (!_matched) {
      if ((number < 90)) {
        _matched=true;
        String _wordToHundred_6 = this.wordToHundred((number % 10));
        _switchResult = ("eighty " + _wordToHundred_6);
      }
    }
    if (!_matched) {
      if ((number < 100)) {
        _matched=true;
        String _wordToHundred_7 = this.wordToHundred((number % 10));
        _switchResult = ("ninety " + _wordToHundred_7);
      }
    }
    return _switchResult;
  }
}
