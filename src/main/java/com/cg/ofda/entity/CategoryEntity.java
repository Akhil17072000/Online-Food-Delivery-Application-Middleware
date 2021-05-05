package com.cg.ofda.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/* This is an Entity class
 * 
 * 
 */
@Entity
/*For specifying name of table as "category"*/
@Table(name="category")
public class CategoryEntity {
			/*
		 * All the private members are defined here with suitable datatypes
		 * 
		 */
	
		@Id
		/*For setting column name as cat_id*/
		@Column(name = "cat_id")
		private Long catId;

		/*For setting column name as category_name*/
		@Column(name = "category_name")
		private String categoryName;

		/*To specify OneToMany relationship*/
		@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
		private List<ItemEntity> itemList;
		
		/*
		 * A default Constructor with no implementation
		 */
		
		public CategoryEntity() {
			// default
		}

		/*
		 * A Parameterized Constructor for assigning the values to private members
		 */

		public CategoryEntity(Long catId, String categoryName) {
			super();
			this.catId = catId;
			this.categoryName = categoryName;
		}

		/*
		 * Corresponding Getters and Setters for private members
		 * 
		 */

		public Long getCatId() {
			return catId;
		}

		public void setCatId(Long catId) {
			this.catId = catId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		

		/*Corresponding hashcode and equals*/

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((catId == null) ? 0 : catId.hashCode());
			result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
			result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CategoryEntity other = (CategoryEntity) obj;
			if (catId == null) {
				if (other.catId != null)
					return false;
			} else if (!catId.equals(other.catId))
				return false;
			if (categoryName == null) {
				if (other.categoryName != null)
					return false;
			} else if (!categoryName.equals(other.categoryName))
				return false;
			if (itemList == null) {
				if (other.itemList != null)
					return false;
			} else if (!itemList.equals(other.itemList))
				return false;
			return true;
		}
		
		
		/*
		 * toString() method overridden here
		 * 
		 */
		
		@Override
		public String toString() {
			return String.format("CategoryEntity [catId=%s, categoryName=%s, itemList=%s]", catId, categoryName,
					itemList);
		}


	


}
