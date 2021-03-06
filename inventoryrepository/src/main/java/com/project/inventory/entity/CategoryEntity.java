package com.project.inventory.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "tbl_category")
public class CategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public CategoryEntity() {
    }

    public CategoryEntity(String categoryId) {
        this.categoryId = categoryId;
    }

    @Id
    @Column(name = "category_id",length = 50)
    private String categoryId;

    @Column(name = "category_name",length = 50)
    private String categoryName;

    @Column(name = "category_description",length = 50)
    private String categoryDescription;

    @OneToMany(mappedBy = "categoryEntity",cascade = CascadeType.ALL)
    private List<ProductEntity> productEntity;

    public List<ProductEntity> getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(List<ProductEntity> productEntity) {
        this.productEntity = productEntity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
