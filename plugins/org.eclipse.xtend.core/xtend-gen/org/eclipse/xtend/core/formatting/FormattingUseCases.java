package org.eclipse.xtend.core.formatting;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractLogicalContainerAwareRootComputationState;

@SuppressWarnings("all")
public class FormattingUseCases {
  public Object parameterListSLStrategy(final Integer param1, final String param2, final String param3, final String param4) {
    return null;
  }
  
  public Object parameterListML0Strategy(final Integer param1, final String param2, final String param3, final String param4) {
    return null;
  }
  
  public Object parameterListML01Strategy(final Integer param1, final String param2, final String param3, final String param4) {
    return null;
  }
  
  public Object parameterListMLStrategy1(final Integer param1, final String param2, final String param3, final String param4) {
    return null;
  }
  
  public Object parameterListMLStrategy2(final Integer param1, final String param2, final String param3, final String param4) {
    return null;
  }
  
  public Object parameterListMLStrategy3(final Integer param1, final AbstractLogicalContainerAwareRootComputationState veryLongParameterName, final String param3, final String param4) {
    return null;
  }
  
  public Object parameterListMLStrategy4(final Integer param1, final InputStream param2, final AbstractAction param3, final String param4) {
    return null;
  }
  
  public Object parameterListMLStrategy5(final Integer param1, final InputStream param2, final AbstractAction param3, final String param4) {
    return null;
  }
  
  public void callParamLists() {
    final ArrayList<Integer> SL1 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_1 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    final ArrayList<ArrayList<Integer>> SL2 = CollectionLiterals.<ArrayList<Integer>>newArrayList(_newArrayList, _newArrayList_1);
    ArrayList<Integer> _newArrayList_2 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_3 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_4 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_5 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    final ArrayList<ArrayList<Integer>> SL3 = CollectionLiterals.<ArrayList<Integer>>newArrayList(_newArrayList_2, _newArrayList_3, _newArrayList_4, _newArrayList_5);
    ArrayList<Integer> _newArrayList_6 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_7 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), 
      Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_8 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_9 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    final ArrayList<ArrayList<Integer>> ML1 = CollectionLiterals.<ArrayList<Integer>>newArrayList(_newArrayList_6, _newArrayList_7, _newArrayList_8, _newArrayList_9);
    ArrayList<Integer> _newArrayList_10 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_11 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_12 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_13 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    final ArrayList<ArrayList<Integer>> ML2 = CollectionLiterals.<ArrayList<Integer>>newArrayList(_newArrayList_10, _newArrayList_11, _newArrayList_12, _newArrayList_13);
    ArrayList<Integer> _newArrayList_14 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_15 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_16 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    ArrayList<Integer> _newArrayList_17 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4));
    final ArrayList<ArrayList<Integer>> ML3 = CollectionLiterals.<ArrayList<Integer>>newArrayList(_newArrayList_14, _newArrayList_15, _newArrayList_16, _newArrayList_17);
  }
  
  public void parenthesizedExpression() {
    int _multiply = (1 * 2);
    int _multiply_1 = (_multiply * 3);
    int _plus = (4 + 5);
    int _plus_1 = (_plus + 6);
    final int sl1 = (_multiply_1 * _plus_1);
    int _multiply_2 = (1 * 2);
    int _multiply_3 = (_multiply_2 * 3);
    int _plus_2 = (4 + 
      5);
    int _plus_3 = (_plus_2 + 6);
    final int ml1 = (_multiply_3 * _plus_3);
    int _multiply_4 = (1 * 2);
    int _multiply_5 = (_multiply_4 * 3);
    int _plus_4 = (4 + 5);
    int _plus_5 = (_plus_4 + 6);
    final int ml2 = (_multiply_5 * _plus_5);
  }
  
  public void closures() {
    ArrayList<?> _newArrayList = CollectionLiterals.<Object>newArrayList();
    final Function1<?,Integer> _function = new Function1<Object,Integer>() {
        public Integer apply(final Object it) {
          int _hashCode = it.hashCode();
          return Integer.valueOf(_hashCode);
        }
      };
    final List<Integer> SLClosure1 = ListExtensions.map(_newArrayList, _function);
    ArrayList<?> _newArrayList_1 = CollectionLiterals.<Object>newArrayList();
    final Function1<?,Integer> _function_1 = new Function1<Object,Integer>() {
        public Integer apply(final Object it) {
          int _xblockexpression = (int) 0;
          {
            final int x = it.hashCode();
            _xblockexpression = (x);
          }
          return Integer.valueOf(_xblockexpression);
        }
      };
    final List<Integer> SLClosure2 = ListExtensions.map(_newArrayList_1, _function_1);
    ArrayList<?> _newArrayList_2 = CollectionLiterals.<Object>newArrayList();
    final Function1<?,Integer> _function_2 = new Function1<Object,Integer>() {
        public Integer apply(final Object it) {
          int _hashCode = it.hashCode();
          return Integer.valueOf(_hashCode);
        }
      };
    final List<Integer> MLClosure1 = ListExtensions.map(_newArrayList_2, _function_2);
    ArrayList<?> _newArrayList_3 = CollectionLiterals.<Object>newArrayList();
    final Function1<?,Integer> _function_3 = new Function1<Object,Integer>() {
        public Integer apply(final Object it) {
          int _xblockexpression = (int) 0;
          {
            final int x = it.hashCode();
            _xblockexpression = (x);
          }
          return Integer.valueOf(_xblockexpression);
        }
      };
    final List<Integer> MLClosure2 = ListExtensions.map(_newArrayList_3, _function_3);
    ArrayList<Integer> _newArrayList_4 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1));
    final Function1<Integer,Integer> _function_4 = new Function1<Integer,Integer>() {
        public Integer apply(final Integer it) {
          int _plus = ((it).intValue() + 1);
          int _plus_1 = (_plus + 2);
          int _plus_2 = (_plus_1 + 3);
          int _plus_3 = (_plus_2 + 4);
          int _plus_4 = (_plus_3 + 5);
          int _plus_5 = (_plus_4 + 6);
          int _plus_6 = (_plus_5 + 7);
          int _plus_7 = (_plus_6 + 8);
          int _plus_8 = (_plus_7 + 9);
          int _plus_9 = (_plus_8 + 10);
          int _plus_10 = (_plus_9 + 11);
          int _plus_11 = (_plus_10 + 12);
          int _plus_12 = (_plus_11 + 13);
          int _plus_13 = (_plus_12 + 14);
          int _plus_14 = (_plus_13 + 15);
          int _plus_15 = (_plus_14 + 16);
          int _plus_16 = (_plus_15 + 17);
          int _plus_17 = (_plus_16 + 10);
          int _plus_18 = (_plus_17 + 11);
          int _plus_19 = (_plus_18 + 12);
          int _plus_20 = (_plus_19 + 13);
          int _plus_21 = (_plus_20 + 14);
          int _plus_22 = (_plus_21 + 15);
          int _plus_23 = (_plus_22 + 16);
          int _plus_24 = (_plus_23 + 17);
          return Integer.valueOf(_plus_24);
        }
      };
    final List<Integer> x = ListExtensions.<Integer, Integer>map(_newArrayList_4, _function_4);
    ArrayList<Integer> _newArrayList_5 = CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1));
    final Function1<Integer,Integer> _function_5 = new Function1<Integer,Integer>() {
        public Integer apply(final Integer it) {
          int _plus = ((it).intValue() + 1);
          int _plus_1 = (_plus + 2);
          int _plus_2 = (_plus_1 + 3);
          int _plus_3 = (_plus_2 + 4);
          int _plus_4 = (_plus_3 + 5);
          int _plus_5 = (_plus_4 + 6);
          int _plus_6 = (_plus_5 + 7);
          int _plus_7 = (_plus_6 + 8);
          int _plus_8 = (_plus_7 + 9);
          int _plus_9 = (_plus_8 + 10);
          int _plus_10 = (_plus_9 + 11);
          int _plus_11 = (_plus_10 + 12);
          int _plus_12 = (_plus_11 + 13);
          int _plus_13 = (_plus_12 + 14);
          int _plus_14 = (_plus_13 + 
            15);
          int _plus_15 = (_plus_14 + 16);
          int _plus_16 = (_plus_15 + 17);
          int _plus_17 = (_plus_16 + 10);
          int _plus_18 = (_plus_17 + 11);
          int _plus_19 = (_plus_18 + 12);
          int _plus_20 = (_plus_19 + 13);
          int _plus_21 = (_plus_20 + 14);
          int _plus_22 = (_plus_21 + 15);
          int _plus_23 = (_plus_22 + 16);
          int _plus_24 = (_plus_23 + 17);
          return Integer.valueOf(_plus_24);
        }
      };
    final List<Integer> y = ListExtensions.<Integer, Integer>map(_newArrayList_5, _function_5);
  }
}
