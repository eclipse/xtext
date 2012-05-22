package lesson5;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Time {
  private final double _ms;
  
  public double getMs() {
    return this._ms;
  }
  
  public Time operator_plus(final Time other) {
    double _ms = this.getMs();
    double _ms_1 = other.getMs();
    double _plus = (_ms + _ms_1);
    Time _time = new Time(_plus);
    return _time;
  }
  
  public Time operator_minus(final Time other) {
    double _ms = this.getMs();
    double _ms_1 = other.getMs();
    double _minus = (_ms - _ms_1);
    Time _time = new Time(_minus);
    return _time;
  }
  
  public Time operator_multiply(final int times) {
    double _ms = this.getMs();
    double _multiply = (_ms * times);
    Time _time = new Time(_multiply);
    return _time;
  }
  
  public Time operator_divide(final int times) {
    double _ms = this.getMs();
    double _divide = (_ms / times);
    Time _time = new Time(_divide);
    return _time;
  }
  
  public static Time msec(final int milliSeconds) {
    Time _time = new Time(milliSeconds);
    return _time;
  }
  
  public static Time sec(final int seconds) {
    int _multiply = (seconds * 1000);
    Time _msec = Time.msec(_multiply);
    return _msec;
  }
  
  public static Time min(final int minutes) {
    int _multiply = (minutes * 60);
    Time _sec = Time.sec(_multiply);
    return _sec;
  }
  
  public static Time h(final int hours) {
    int _multiply = (hours * 60);
    Time _min = Time.min(_multiply);
    return _min;
  }
  
  public Time(final double ms) {
    super();
    this._ms = ms;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (Double.doubleToLongBits(_ms) ^ (Double.doubleToLongBits(_ms) >>> 32));
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Time other = (Time) obj;
    if (Double.doubleToLongBits(other._ms) != Double.doubleToLongBits(_ms))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
