package hellojpa;

import javax.persistence.MappedSuperclass;
import java.util.PrimitiveIterator;

@MappedSuperclass
public abstract class BaseEntity {
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastMOdifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastMOdifiedDate() {
        return lastMOdifiedDate;
    }

    public void setLastMOdifiedDate(String lastMOdifiedDate) {
        this.lastMOdifiedDate = lastMOdifiedDate;
    }
}
