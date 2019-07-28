package com.semantyca.test.pojo;

public interface ISimpleAppEntity<K> extends IModel {

    K getId();

    void setId(K id);

}
