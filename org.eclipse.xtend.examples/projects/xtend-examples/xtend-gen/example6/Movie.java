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
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class Movie {
  private final String title;
  
  private final int year;
  
  private final double rating;
  
  private final long numberOfVotes;
  
  private final Set<String> categories;
  
  public Movie(final String title, final int year, final double rating, final long numberOfVotes, final Set<String> categories) {
    super();
    this.title = title;
    this.year = year;
    this.rating = rating;
    this.numberOfVotes = numberOfVotes;
    this.categories = categories;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.title== null) ? 0 : this.title.hashCode());
    result = prime * result + this.year;
    result = prime * result + (int) (Double.doubleToLongBits(this.rating) ^ (Double.doubleToLongBits(this.rating) >>> 32));
    result = prime * result + (int) (this.numberOfVotes ^ (this.numberOfVotes >>> 32));
    return prime * result + ((this.categories== null) ? 0 : this.categories.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Movie other = (Movie) obj;
    if (this.title == null) {
      if (other.title != null)
        return false;
    } else if (!this.title.equals(other.title))
      return false;
    if (other.year != this.year)
      return false;
    if (Double.doubleToLongBits(other.rating) != Double.doubleToLongBits(this.rating))
      return false; 
    if (other.numberOfVotes != this.numberOfVotes)
      return false;
    if (this.categories == null) {
      if (other.categories != null)
        return false;
    } else if (!this.categories.equals(other.categories))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("title", this.title);
    b.add("year", this.year);
    b.add("rating", this.rating);
    b.add("numberOfVotes", this.numberOfVotes);
    b.add("categories", this.categories);
    return b.toString();
  }
  
  @Pure
  public String getTitle() {
    return this.title;
  }
  
  @Pure
  public int getYear() {
    return this.year;
  }
  
  @Pure
  public double getRating() {
    return this.rating;
  }
  
  @Pure
  public long getNumberOfVotes() {
    return this.numberOfVotes;
  }
  
  @Pure
  public Set<String> getCategories() {
    return this.categories;
  }
}
