/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 */
package example5;

import example5.Distance;
import example5.Speed;
import example5.Time;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Assert;
import org.junit.Test;

/**
 * This example shows the usage of operator overloading combined with
 * extension methods.
 */
@SuppressWarnings("all")
public class Units {
  @Test
  public void distances() {
    Distance _km = Distance.km(15);
    Distance _km_1 = Distance.km(13);
    Distance _m = Distance.m(2000);
    Distance _plus = _km_1.operator_plus(_m);
    Assert.assertEquals(_km, _plus);
    Distance _km_2 = Distance.km(30);
    Distance _km_3 = Distance.km(13);
    Distance _m_1 = Distance.m(2000);
    Distance _plus_1 = _km_3.operator_plus(_m_1);
    Distance _multiply = _plus_1.operator_multiply(2);
    Assert.assertEquals(_km_2, _multiply);
    Distance distance = Distance.km(10);
    IntegerRange _upTo = new IntegerRange(1, 10);
    for (final Integer i : _upTo) {
      Distance _distance = distance;
      Distance _km_4 = Distance.km((i).intValue());
      distance = _distance.operator_plus(_km_4);
    }
    Distance _km_5 = Distance.km(65);
    Assert.assertEquals(_km_5, distance);
  }
  
  @Test
  public void time() {
    Time _h = Time.h(1);
    Time _sec = Time.sec(65);
    Time _min = Time.min(59);
    Time _plus = _sec.operator_plus(_min);
    Time _msec = Time.msec(5000);
    Time _minus = _plus.operator_minus(_msec);
    Assert.assertEquals(_h, _minus);
  }
  
  @Test
  public void speed() {
    Distance _km = Distance.km(42);
    Time _h = Time.h();
    Speed _divide = Speed.operator_divide(_km, _h);
    Distance _m = Distance.m(40000);
    Distance _km_1 = Distance.km(2);
    Distance _plus = _m.operator_plus(_km_1);
    Time _min = Time.min(60);
    Speed _divide_1 = Speed.operator_divide(_plus, _min);
    Assert.assertEquals(_divide, _divide_1);
  }
}
