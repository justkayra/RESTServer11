package com.semantyca.test.pojo;


import java.util.Date;
import java.util.List;

public interface IAppEntity<K> extends ISimpleAppEntity<K> {


    Date getRegDate();

    boolean isEditable();

    void setEditable(boolean isEditable);

    default boolean wasRead(){
        return true;
    }

    String getTitle();

    String getURL();

    void setTitle(String title);

    default String getEntityKind() {
        return this.getClass().getSimpleName();
    }

    boolean isNew();


    default List getExtAttachments() {
        return null;
    }

}
