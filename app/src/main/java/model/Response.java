package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by harrisfz
 * ubilih@gmail.com
 * harris.febryantony@sisi.id
 * on 11/9/17.
 */

public class Response<T> {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("content")
    @Expose
    private T content = null;

    /**
     * No args constructor for use in serialization
     */
    public Response() {
    }

    /**
     * @param content
     * @param status
     */
    public Response(int status, T content) {
        super();
        this.status = status;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Response withStatus(int status) {
        this.status = status;
        return this;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Response withContent(T content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("status", status).append("content", content).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(content).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response rhs = ((Response) other);
        return new EqualsBuilder().append(content, rhs.content).append(status, rhs.status).isEquals();
    }

}
