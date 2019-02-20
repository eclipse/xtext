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

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Find the greatest product of five consecutive digits in the 1000-digit number.
 * 
 * 		73167176531330624919225119674426574742355349194934
 * 		96983520312774506326239578318016984801869478851843
 * 		85861560789112949495459501737958331952853208805511
 * 		12540698747158523863050715693290963295227443043557
 * 		66896648950445244523161731856403098711121722383113
 * 		62229893423380308135336276614282806444486645238749
 * 		30358907296290491560440772390713810515859307960866
 * 		70172427121883998797908792274921901699720888093776
 * 		65727333001053367881220235421809751254540594752243
 * 		52584907711670556013604839586446706324415722155397
 * 		53697817977846174064955149290862569321978468622482
 * 		83972241375657056057490261407972968652414535100474
 * 		82166370484403199890008895243450658541227588666881
 * 		16427171479924442928230863465674813919123162824586
 * 		17866458359124566529476545682848912883142607690042
 * 		24219022671055626321111109370544217506941658960408
 * 		07198403850962455444362981230987879927244284909188
 * 		84580156166097919133875499200524063689912560717606
 * 		05886116467109405077541002256983155200055935729725
 * 		71636269561882670428252483600823257530420752963450
 * 
 * @see http://projecteuler.net/problem=8
 */
@SuppressWarnings("all")
public class Solution_008 {
  public static void main(final String[] args) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("73167176531330624919225119674426574742355349194934");
    _builder.newLine();
    _builder.append("96983520312774506326239578318016984801869478851843");
    _builder.newLine();
    _builder.append("85861560789112949495459501737958331952853208805511");
    _builder.newLine();
    _builder.append("12540698747158523863050715693290963295227443043557");
    _builder.newLine();
    _builder.append("66896648950445244523161731856403098711121722383113");
    _builder.newLine();
    _builder.append("62229893423380308135336276614282806444486645238749");
    _builder.newLine();
    _builder.append("30358907296290491560440772390713810515859307960866");
    _builder.newLine();
    _builder.append("70172427121883998797908792274921901699720888093776");
    _builder.newLine();
    _builder.append("65727333001053367881220235421809751254540594752243");
    _builder.newLine();
    _builder.append("52584907711670556013604839586446706324415722155397");
    _builder.newLine();
    _builder.append("53697817977846174064955149290862569321978468622482");
    _builder.newLine();
    _builder.append("83972241375657056057490261407972968652414535100474");
    _builder.newLine();
    _builder.append("82166370484403199890008895243450658541227588666881");
    _builder.newLine();
    _builder.append("16427171479924442928230863465674813919123162824586");
    _builder.newLine();
    _builder.append("17866458359124566529476545682848912883142607690042");
    _builder.newLine();
    _builder.append("24219022671055626321111109370544217506941658960408");
    _builder.newLine();
    _builder.append("07198403850962455444362981230987879927244284909188");
    _builder.newLine();
    _builder.append("84580156166097919133875499200524063689912560717606");
    _builder.newLine();
    _builder.append("05886116467109405077541002256983155200055935729725");
    _builder.newLine();
    _builder.append("71636269561882670428252483600823257530420752963450");
    _builder.newLine();
    final String it = _builder.toString().replaceAll("\\r|\\n", "");
    int _length = it.length();
    int _minus = (_length - 5);
    final Function1<Integer, Integer> _function = (Integer i) -> {
      final Function2<Integer, Character, Integer> _function_1 = (Integer r, Character c) -> {
        int _parseInt = Integer.parseInt(c.toString());
        return Integer.valueOf(((r).intValue() * _parseInt));
      };
      return IterableExtensions.<Character, Integer>fold(((Iterable<Character>)Conversions.doWrapArray(it.substring((i).intValue(), ((i).intValue() + 5)).toCharArray())), Integer.valueOf(1), _function_1);
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer i1, Integer i2) -> {
      return Integer.valueOf(Math.max((i1).intValue(), (i2).intValue()));
    };
    InputOutput.<Integer>println(IterableExtensions.<Integer>reduce(IterableExtensions.<Integer, Integer>map(new IntegerRange(0, _minus), _function), _function_1));
  }
}
