package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by harrisfz
 * ubilih@gmail.com
 * harris.febryantony@sisi.id
 * on 11/9/17.
 */

public class OpnameDetail {

    @SerializedName("head")
    @Expose
    private Head head;
    @SerializedName("items")
    @Expose
    private List<OpnameItem> opnameItems = null;

    /**
     * No args constructor for use in serialization
     */
    public OpnameDetail() {
    }

    /**
     * @param opnameItems
     * @param head
     */
    public OpnameDetail(Head head, List<OpnameItem> opnameItems) {
        super();
        this.head = head;
        this.opnameItems = opnameItems;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public List<OpnameItem> getOpnameItems() {
        return opnameItems;
    }

    public void setOpnameItems(List<OpnameItem> opnameItems) {
        this.opnameItems = opnameItems;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("head", head).append("opnameItems", opnameItems).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(opnameItems).append(head).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof OpnameDetail)) {
            return false;
        }
        OpnameDetail rhs = ((OpnameDetail) other);
        return new EqualsBuilder().append(opnameItems, rhs.opnameItems).append(head, rhs.head).isEquals();
    }

}


