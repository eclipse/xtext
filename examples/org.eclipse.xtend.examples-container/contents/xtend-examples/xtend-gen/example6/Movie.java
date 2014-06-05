/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 */
package example6;

import java.util.Set;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Movie {
  private final String _title;
  
  public String getTitle() {
    return this._title;
  }
  
  private final int _year;
  
  public int getYear() {
    return this._year;
  }
  
  private final double _rating;
  
  public double getRating() {
    return this._rating;
  }
  
  private final long _numberOfVotes;
  
  public long getNumberOfVotes() {
    return this._numberOfVotes;
  }
  
  private final Set<String> _categories;
  
  public Set<String> getCategories() {
    return this._categories;
  }
  
  public Movie(final String title, final int year, final double rating, final long numberOfVotes, final Set<String> categories) {
    super();
    this._title = title;
    this._year = year;
    this._rating = rating;
    this._numberOfVotes = numberOfVotes;
    this._categories = categories;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._title== null) ? 0 : this._title.hashCode());
    result = prime * result + this._year;
    result = prime * result + (int) (Double.doubleToLongBits(this._rating) ^ (Double.doubleToLongBits(this._rating) >>> 32));
    result = prime * result + (int) (this._numberOfVotes ^ (this._numberOfVotes >>> 32));
    result = prime * result + ((this._categories== null) ? 0 : this._categories.hashCode());
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
    Movie other = (Movie) obj;
    if (this._title == null) {
      if (other._title != null)
        return false;
    } else if (!this._title.equals(other._title))
      return false;
    if (other._year != this._year)
      return false;
    if (Double.doubleToLongBits(other._rating) != Double.doubleToLongBits(this._rating))
      return false;
    if (other._numberOfVotes != this._numberOfVotes)
      return false;
    if (this._categories == null) {
      if (other._categories != null)
        return false;
    } else if (!this._categories.equals(other._categories))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
