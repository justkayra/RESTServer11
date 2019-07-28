package com.semantyca.test.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;
import java.util.UUID;

@JsonPropertyOrder({"kind", "id", "title", "regDate", "wasRead", "url", "authorId", "editable", "isNew"})
public abstract class AppEntity<K> implements IAppEntity<K> {


    protected K id;

    private Date regDate;

    private Date lastModifiedDate = new Date();

    private Long lastModifier;

    private boolean editable = true;

    private boolean wasRead = true;

    private boolean hasAttachments;

    private boolean deleted;
    private String title;

    @Override
    public K getId() {
        return id;
    }

    @Override
    public void setId(K id) {
        this.id = id;
    }


    public String getIdentifier() {
        if (id != null) {
            return id.toString();
        } else {
            return "null";
        }
    }



    @JsonIgnore
    @Override
    public String toString() {
        if (getId() == null) {
            return "id is null," + this.getClass().getName();
        }
        UUID id = UUID.fromString(getId().toString());
        return id.toString() + "," + this.getClass().getName();
    }


    public String getURL() {
        return getIdentifier();
    }

    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    @JsonProperty("isNew")
    public boolean isNew() {
        return id == null;
    }

    @Override
    public boolean isEditable() {
        return editable;
    }

    @Override
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isWasRead() {
        return wasRead;
    }

    public void setWasRead(boolean wasRead) {
        this.wasRead = wasRead;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int hashCode() {
        if (id == null) {
            return super.hashCode();
        }
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        @SuppressWarnings("unchecked")
        AppEntity<UUID> tmp = (AppEntity<UUID>) obj;

        return id != null && id.equals(tmp.id);
    }

    public void setHasAttachments(boolean hasAttachments) {
        this.hasAttachments = hasAttachments;
    }
}
